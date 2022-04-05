package cityInService;



import java.io.IOException;

import cityInService.cityInServiceGrpc.cityInServiceImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class cityInServiceServer {
	
	private Server server;
	
	public static void main(String[] args) throws InterruptedException, IOException {
		
		cityInServiceServer ourServer = new cityInServiceServer();
		
		ourServer.start();
		
	}

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
	
		@Override
		public void cityInService(StringMessage request, StreamObserver <StringMessage>responseObserver){
			
			// Find put what was the content of the message sent by the client
			String city = request.getCity();
			System.out.println("Out first request string is: " + city);
			
			// Building the server response:
			StringMessage.Builder responseBuilder = StringMessage.newBuilder();
			
			responseBuilder.setCity(city + " city is in the system.");
			
			responseObserver.onNext(responseBuilder.build());
			responseObserver.onCompleted();
			
		}
	
	}
}
