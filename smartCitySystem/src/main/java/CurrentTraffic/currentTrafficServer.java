package currentTraffic;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import com.google.protobuf.Int32Value;

import currentTraffic.currentTrafficGrpc.currentTrafficImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class currentTrafficServer {
	
	private Server server;
	
	public static void main(String[] args) throws InterruptedException, IOException {
		
		
		// --------------------------------------------------------------------------------------------
		// --------------- Creating server and starting connection ------------------------------------
		
		currentTrafficServer ourServer = new currentTrafficServer();
		
		//jmDNS -
		ourServer.registerService();
		
		ourServer.start();
		
	}
	
	// jmDNS
	private void registerService() throws UnknownHostException, IOException, InterruptedException {
		// TODO Auto-generated method stub
		// Create a JmDNS instance
        JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
        
        String service_type = "_http._tcp.local.";
        String service_name = "currentTraffic";
        int service_port = 50051;
        
        String service_description_properties = "path=index.html";
        
        // Register a service
        ServiceInfo serviceInfo = ServiceInfo.create(service_type, service_name, service_port, service_description_properties);
        jmdns.registerService(serviceInfo);
        
        System.out.printf("registrering service with type %s and name %s \n", service_type, service_name);
        
        // Wait a few seconds
        Thread.sleep(1000);
		
	}
	// jmDNS

	private void start() throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("Starting gRPC Server");
		
		int port = 50051;
		
		server = ServerBuilder.forPort(port).addService(new currentTrafficImpl()).build().start();
		
		System.out.println("Server running on port: " + port);
		
		server.awaitTermination();
	}

	static class currentTrafficImpl extends currentTrafficImplBase{
		
		
		// --------------------------------------------------------------------------------------------
		// --------------- Implementation of rpc CurrentTraffic ---------------------------------------
		@Override
		public void currentTraffic (StringMessage request, StreamObserver<StringMessage> responseObserver) {
			
			// Checking that message from client is correct:
			String city = request.getCity();
			System.out.println("The city requested is: " + city);
			
			// Building response:
			StringMessage.Builder responseBuilder = StringMessage.newBuilder();
			
			
			// Creating traffic variable for first message:
			String state [] = {"optimal", "slow", "heavy"};
			Random random = new Random();
			
			int select = random.nextInt(state.length);
			
			String traffic = state[select];
			
			//Creating first message for state of traffic in city:
			responseBuilder.setCity("The traffic in " + city + " is " + traffic + ".");
			responseObserver.onNext(responseBuilder.build());
			
			
			//Creating second message:
		
			if (traffic == "optimal") {
				responseBuilder.setCity("There are no delays in traffic in " + city);
				responseObserver.onNext(responseBuilder.build());
				
			}else if(traffic == "slow") {
				responseBuilder.setCity("There is a delay in traffic of 10 - 25 minutes in " + city);
				responseObserver.onNext(responseBuilder.build());
				
			}else {
				responseBuilder.setCity("There is a delay in traffic of over 30 minutes in " + city);
				responseObserver.onNext(responseBuilder.build());
			}
			
			responseObserver.onCompleted();
			
		}
		
		// --------------------------------------------------------------------------------------------
		// --------------- End of Implementation of rpc CurrentTraffic --------------------------------
		
		
		// --------------------------------------------------------------------------------------------
		// --------------- Implementation of rpc TrafficInCity ----------------------------------------
		
		
		public StreamObserver <StringM> trafficInCity(StreamObserver<StringM> responseObserver){
			
			//Checking we are in client streaming service:
			System.out.println("Server: inside the client streaming method ");
			
			return new StreamObserver<StringM>() {
				
				
				@Override
				//Verify message from client:
				public void onNext(StringM value) {
					// TODO Auto-generated method stub
					
					// Receiving message from client:
					System.out.println("Server has received the message: " + value.getCity1());
					
				}

				@Override
				public void onError(Throwable t) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void onCompleted() {
					// TODO Auto-generated method stub
					
					StringM.Builder responseBuilder = StringM.newBuilder();
					
					//Building message to client:
					responseBuilder.setCity1("For the selected streets the traffic is excellent." );
					
					//Sending message to client with responseObserver:
					responseObserver.onNext(responseBuilder.build());
					responseObserver.onCompleted();
					
				}
			
			};
			
		}
		// --------------------------------------------------------------------------------------------
		// --------------- End of Implementation of rpc TrafficInCity ---------------------------------
			
	}
	
}
