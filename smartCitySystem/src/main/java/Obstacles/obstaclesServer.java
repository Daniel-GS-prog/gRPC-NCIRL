package obstacles;

import java.io.IOException;

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
		
		ourServer.start();
	}

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