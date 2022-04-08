package obstacles;

import java.io.IOException;
import java.util.Properties;

import currentTraffic.StringMessage;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import obstacles.obstaclesGrpc.obstaclesImplBase;

public class obstacleServer extends obstaclesImplBase{
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		obstacleServer ourServer = new obstacleServer();
		
		int port = 50051;
		
		Server server = ServerBuilder.forPort(port).addService(ourServer).build().start(); 
		
		server.awaitTermination();
	}
	@Override
	public StreamObserver<StringMessage> obstacles(StreamObserver<StringMessage> responseObserver){
		
		return new StreamObserver<StringMessage>() {

			@Override
			public void onNext(StringMessage value) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onCompleted() {
				// TODO Auto-generated method stub
				
			}};
		
	}
}


