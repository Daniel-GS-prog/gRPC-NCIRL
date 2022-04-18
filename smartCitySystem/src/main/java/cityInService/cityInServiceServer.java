package cityInService;



import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import java.util.Random;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import cityInService.cityInServiceGrpc.cityInServiceImplBase;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class cityInServiceServer {
	
	
	private Server server;
	
	public static void main(String[] args) throws InterruptedException, IOException {
		
		// --------------------------------------------------------------------------------------------
		// --------------- Creating server and starting connection ------------------------------------
		
		cityInServiceServer ourServer = new cityInServiceServer();
		
		
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
        String service_name = "cityInService";
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
		
		server = ServerBuilder.forPort(port).addService(new cityInServiceImpl()).build().start();
		
		System.out.println("Server running on port: " + port);
		
		server.awaitTermination();
	}
	
	
	
	
	
	
	
	
		//Extend abstract base class for our own implementation
		static class cityInServiceImpl extends cityInServiceImplBase{
			
			
		// --------------------------------------------------------------------------------------------
		// --------------- Implementation of rpc CityInService ----------------------------------------
	
		@Override
		public void cityInService(StringMessage request, StreamObserver <StringMessage>responseObserver){
			
			// Find put what was the content of the message sent by the client
			String city = request.getCity();
			System.out.println("The city requested is: " + city);
			
			// Building the server response:
			StringMessage.Builder responseBuilder = StringMessage.newBuilder();
			
			responseBuilder.setCity(city + " city is in the system.");
			
			responseObserver.onNext(responseBuilder.build());
			responseObserver.onCompleted();
			
		}
		
		// --------------------------------------------------------------------------------------------
		// --------------- End of Implementation of rpc CityInService ---------------------------------
		
		
		// --------------------------------------------------------------------------------------------
		// --------------- Implementation of rpc TemperatureInCity ------------------------------------
	
		@Override
		public void temperatureInCity(StringMessage request, StreamObserver <IntMessage> responseObserver) {
			
			// Find put what was the content of the message sent by the client
			String city = request.getCity();
			System.out.println("The city requested is: " + city);
			
			// Now build the response
			IntMessage.Builder responseBuilder = IntMessage.newBuilder();
			
			Random random = new Random();
			
			// Generating a random number for temperature:
			int degrees = random.nextInt(5, 25);
			
			responseBuilder.setTemperature(degrees);
			
			responseObserver.onNext(responseBuilder.build());
			responseObserver.onCompleted();
			
		// --------------------------------------------------------------------------------------------
		// --------------- End of Implementation of rpc TemperatureInCity -----------------------------
			
			
		}
	}
}
