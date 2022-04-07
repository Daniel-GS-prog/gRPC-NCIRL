package currentTraffic;

import java.util.Iterator;
import java.util.Scanner;


import currentTraffic.currentTrafficGrpc.currentTrafficBlockingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

	public class currentTrafficClient {
	
	public static void main (String [] args) {
		
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
            System.out.println("====================================");
            System.out.println("Welcome to our service");
            System.out.println("What would you like to do?");
            System.out.println("(1) Check the traffic in the city.");
            System.out.println("(2)");
            System.out.println("(3) Exit.");
            System.out.println("=====================================");
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
            		
            		
            	} else if (choice == 3) {
            		
            		// Exiting session
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
