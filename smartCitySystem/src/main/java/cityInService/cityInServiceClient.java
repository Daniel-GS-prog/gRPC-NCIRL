package cityInService;

import java.util.concurrent.TimeUnit;
import java.util.Scanner;

import cityInService.cityInServiceGrpc.cityInServiceBlockingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class cityInServiceClient {
	
	public static void main (String [] args) throws InterruptedException {
		
		// Build a channel to connect the client to the server:
		
		int port = 50051;
		
		String host = "localhost";
		
		
		// Creating Channel:
		ManagedChannel newChannel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
		
		// Building a message:
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Here we are!");
		String city = keyboard.next();
		
		
		StringMessage cString = StringMessage.newBuilder().setCity(city).build();
		
		// Create a stub, pass the channel to the stub
		cityInServiceBlockingStub bstub = cityInServiceGrpc.newBlockingStub(newChannel);
		
		
		
		StringMessage response = bstub.cityInService(cString);
		
		System.out.println(response.getCity());
		
		
		newChannel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
	}

}
