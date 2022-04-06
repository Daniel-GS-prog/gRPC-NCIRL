package cityInService;

import java.util.concurrent.TimeUnit;

import cityInService.cityInServiceGrpc.cityInServiceBlockingStub;
import cityInService.cityInServiceGrpc.cityInServiceStub;
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
		StringMessage cString = StringMessage.newBuilder().setCity("Caracas").build();
		
		// Create a stub, pass the channel to the stub
		cityInServiceBlockingStub bstub = cityInServiceGrpc.newBlockingStub(newChannel);
		
		
		
		StringMessage response = bstub.cityInService(cString);
		
		System.out.println(response.getCity());
		
		
		newChannel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
	}

}
