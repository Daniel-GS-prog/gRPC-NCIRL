package obstacles;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import currentTraffic.StringMessage;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import obstacles.obstaclesGrpc.obstaclesImplBase;

public class obstaclesServer {
	
	private Server server;
	
	public static void main(String[] args) throws InterruptedException, IOException {
		
		// --------------- Creating server and starting connection ------------------------------------

		obstaclesServer ourServer = new obstaclesServer();
		
		//jmDNS -
		ourServer.registerService();
		
		ourServer.start();
	}

	// JmDNS
	private void registerService() throws UnknownHostException, IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		// Create a JmDNS instance
        JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
        
        String service_type = "_http._tcp.local.";
        String service_name = "obstacles";
        int service_port = 50051;
        
        String service_description_properties = "path=index.html";
        
     // Register the service
        ServiceInfo serviceInfo = ServiceInfo.create(service_type, service_name, service_port, service_description_properties);
        jmdns.registerService(serviceInfo);
        
        System.out.printf("registrering service with type %s and name %s \n", service_type, service_name);
        
        // Wait a few seconds
        Thread.sleep(1000);
		
	}
	// JmDNS

	
	private void start() throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("Starting gRPC Server");
		
		int port = 50051;
		
		server = ServerBuilder.forPort(port).addService(new obstaclesImpl()).build().start();
		
		System.out.println("Server running on port: " + port);
		
		server.awaitTermination();
		
	}
	
	static class obstaclesImpl extends obstaclesImplBase{
		
	
		// --------------------------------------------------------------------------------------------
		// --------------- Implementation of rpc ObstaclesInRoad --------------------------------------
	
		public StreamObserver<Message> obstaclesInRoad(StreamObserver<Message> responseObserver){
			
			//Checking we are in client streaming service:
			System.out.println("Server: inside bidirectional streaming method ");
			
			return new StreamObserver<Message>() {

				@Override
				public void onNext(Message value) {
					// TODO Auto-generated method stub
					
					// Receiving message from client:
					System.out.println("Server has received the message: " + value.getStreets());
					
				}

				@Override
				public void onError(Throwable t) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void onCompleted() {
					// TODO Auto-generated method stub
					
					Message.Builder responseBuilder = Message.newBuilder();
					
					responseBuilder.setStreets("No obstacles in the selected streets.");
					responseObserver.onNext(responseBuilder.build());
					
					responseBuilder.setStreets("No flodding in the selected streets.");
					responseObserver.onNext(responseBuilder.build());
					
					
					responseObserver.onCompleted();
				}};
		}
		}
	}