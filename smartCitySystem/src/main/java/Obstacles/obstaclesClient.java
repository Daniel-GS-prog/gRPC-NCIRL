package obstacles;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import obstacles.obstaclesGrpc.obstaclesStub;

public class obstaclesClient {
	
	public static void main (String [] args) throws InterruptedException {
		
		// Build a channel to connect the client to the server:
		
		int port = 50051;
		
		String host = "localhost";
		
		
		// Creating Channel:
		ManagedChannel newChannel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("=====================================================");
        System.out.println("====       Welcome to our service ===================");
        System.out.println(" Please enter the street you would like to check:");
        
        StreamObserver<Message> responseObserver = new StreamObserver<Message>() {

			@Override
			public void onNext(Message value) {
				// TODO Auto-generated method stub
				
				System.out.println(value.getStreets());
				
			}

			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onCompleted() {
				// TODO Auto-generated method stub
				
				
			}};
			
			//Keeping channel open until client has sent all the messages:
			obstaclesStub asyncStub = obstaclesGrpc.newStub(newChannel);
			
			StreamObserver<Message> requestObserver = asyncStub.obstaclesInRoad(responseObserver);
			
			
			// while loop to get all the information from client:
			int count = 0;
			
			System.out.println("Please enter the name of 3 streets: ");
			
			while (count < 3) {
				String street = keyboard.next();
				System.out.println();
				
				// Passing input to server:
				requestObserver.onNext(Message.newBuilder().setStreets(street).build());
				count ++;
			}
			
			
			requestObserver.onCompleted();
			
			// Sending client to sleep:
			Thread.sleep(2000);
			
			// shutdown the channel:
			newChannel.shutdown().awaitTermination(2, TimeUnit.SECONDS);
			System.out.println("Good bye!");
			
			
			// ---- End of Implementation of rpc ObstaclesInRoad ---------------------------
	}
	

}
