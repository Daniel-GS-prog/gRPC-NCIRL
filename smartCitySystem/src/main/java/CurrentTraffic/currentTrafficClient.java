package currentTraffic;

import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import currentTraffic.currentTrafficGrpc.currentTrafficBlockingStub;
import currentTraffic.currentTrafficGrpc.currentTrafficStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

	public class currentTrafficClient {
	
	public static void main (String [] args) throws InterruptedException {
		
		// Build a channel to connect the client to the server:
		
		int port = 50051;
		
		String host = "localhost";
		
		
		// Creating Channel:
		ManagedChannel newChannel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
		
		Scanner keyboard = new Scanner(System.in);
		
	
		
		
		
		// ---------------------------------------------------------------------------------------------
		// Loop to present a menu to the user ----------------------------------------------------------
		
		while (true) {
			
            int choice = 0;

            // Presenting a menu to the user:
            System.out.println();
            System.out.println("=====================================================");
            System.out.println("====       Welcome to our service ===================");
            System.out.println("    What would you like to do?");
            System.out.println("(1) Check the traffic in the city center.");
            System.out.println("(2) Check the traffic in different points of the city");
            System.out.println("(3) Exit.");
            System.out.println("=====================================================");
            System.out.println("Option: ");
            
            try{
            	
            // Receiving input from user with error handling:
                choice = keyboard.nextInt();
                
            // If user provides a symbol other than a number:
            }catch(Exception e){
                System.out.println("Choice must be an integer between 1 & 3");
                System.out.println("Good bye.");
                System.out.println("==================================");
                System.out.println();
                break;
            }
            
            // If symbol is a number:
            
            // If symbol is between the provided options 1 & 3:
            if (choice >= 1 && choice <= 3) {
            	
            	
        		
            	if (choice == 1) { 
            		
            		// ---- Implementation of rpc CurrentTraffic --------------------------
            		
            		// Building a message:
    				// Asking use for input to be processed:
    				System.out.println("Please enter the city you would like to check: ");
    	
    				// Creating a variable with user input:
    				String city = keyboard.next();
    				System.out.println();
    				
    				StringMessage cString = StringMessage.newBuilder().setCity(city).build();
    				
    				
    				// Create a stub, pass the channel to the stub
    				currentTrafficBlockingStub bstub = currentTrafficGrpc.newBlockingStub(newChannel);
    				
    				// Creating Iterator to pass stream messages from server:
    				Iterator <StringMessage> responses = bstub.currentTraffic(cString);
    				
    				// Assigning and printing responses from server:
    				while (responses.hasNext()) {
    					StringMessage individualResponse = responses.next();
    					System.out.println(individualResponse.getCity());
    					
    				}
    			
    				
            	} else if (choice == 2) {
            	
            		// ---- Implementation of rpc TrafficInCity ---------------------------
            		
            		StreamObserver<StringM> responseObserver = new StreamObserver<StringM>() {

						@Override
						public void onNext(StringM value) {
							// TODO Auto-generated method stub
							System.out.println(value.getCity1());
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
					currentTrafficStub asyncStub = currentTrafficGrpc.newStub(newChannel);
					
					
					StreamObserver<StringM> requestObserver = asyncStub.trafficInCity(responseObserver);
					
					// while loop to get all the information from client:
					int count = 0;
					
					System.out.println("Please enter the name of 3 streets: ");
					
					while (count < 3) {
						String city = keyboard.next();
	    				System.out.println();
	    				
	    				// Passing input to server:
	    				requestObserver.onNext(StringM.newBuilder().setCity1(city).build());
	    				count ++;
					}
					
					
					requestObserver.onCompleted();
					
					// Sending client to sleep:
					Thread.sleep(2000);
					
					// shutdown the channel:
					newChannel.shutdown().awaitTermination(2, TimeUnit.SECONDS);
					System.out.println("Good bye!");
					
					// Exiting session:
					break;
					
					// ---- End of Implementation of rpc TrafficInCity ---------------------------
					
    				
            	} else if (choice == 3) {
            		
            		// Exiting session:
            		System.out.println("Good bye!");
                	break;
            	}
            	
            } else {
            	
            	// Presenting user with a reminder of accepted options:
            	System.out.println("Choice must be an integer between 1 & 3");
            	
            }
		}
	}

}
	
	