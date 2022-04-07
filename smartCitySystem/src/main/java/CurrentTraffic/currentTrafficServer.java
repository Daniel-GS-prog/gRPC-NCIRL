package currentTraffic;

import java.io.IOException;
import java.util.Random;

import currentTraffic.currentTrafficGrpc.currentTrafficImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class currentTrafficServer {
	
	private Server server;
	
	public static void main(String[] args) throws InterruptedException, IOException {
		
		currentTrafficServer ourServer = new currentTrafficServer();
		
		ourServer.start();
		
	}

	private void start() throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("Starting gRPC Server");
		
		int port = 50051;
		
		server = ServerBuilder.forPort(port).addService(new currentTrafficImpl()).build().start();
		
		System.out.println("Server running on port: " + port);
		
		server.awaitTermination();
	}

	static class currentTrafficImpl extends currentTrafficImplBase{
		
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
		
	}
}
