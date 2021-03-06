package obstacles;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: obstacles.proto")
public final class obstaclesGrpc {

  private obstaclesGrpc() {}

  public static final String SERVICE_NAME = "obstacles.obstacles";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<obstacles.Message,
      obstacles.Message> getObstaclesInRoadMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ObstaclesInRoad",
      requestType = obstacles.Message.class,
      responseType = obstacles.Message.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<obstacles.Message,
      obstacles.Message> getObstaclesInRoadMethod() {
    io.grpc.MethodDescriptor<obstacles.Message, obstacles.Message> getObstaclesInRoadMethod;
    if ((getObstaclesInRoadMethod = obstaclesGrpc.getObstaclesInRoadMethod) == null) {
      synchronized (obstaclesGrpc.class) {
        if ((getObstaclesInRoadMethod = obstaclesGrpc.getObstaclesInRoadMethod) == null) {
          obstaclesGrpc.getObstaclesInRoadMethod = getObstaclesInRoadMethod = 
              io.grpc.MethodDescriptor.<obstacles.Message, obstacles.Message>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "obstacles.obstacles", "ObstaclesInRoad"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  obstacles.Message.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  obstacles.Message.getDefaultInstance()))
                  .setSchemaDescriptor(new obstaclesMethodDescriptorSupplier("ObstaclesInRoad"))
                  .build();
          }
        }
     }
     return getObstaclesInRoadMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static obstaclesStub newStub(io.grpc.Channel channel) {
    return new obstaclesStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static obstaclesBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new obstaclesBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static obstaclesFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new obstaclesFutureStub(channel);
  }

  /**
   */
  public static abstract class obstaclesImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<obstacles.Message> obstaclesInRoad(
        io.grpc.stub.StreamObserver<obstacles.Message> responseObserver) {
      return asyncUnimplementedStreamingCall(getObstaclesInRoadMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getObstaclesInRoadMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                obstacles.Message,
                obstacles.Message>(
                  this, METHODID_OBSTACLES_IN_ROAD)))
          .build();
    }
  }

  /**
   */
  public static final class obstaclesStub extends io.grpc.stub.AbstractStub<obstaclesStub> {
    private obstaclesStub(io.grpc.Channel channel) {
      super(channel);
    }

    private obstaclesStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected obstaclesStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new obstaclesStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<obstacles.Message> obstaclesInRoad(
        io.grpc.stub.StreamObserver<obstacles.Message> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getObstaclesInRoadMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class obstaclesBlockingStub extends io.grpc.stub.AbstractStub<obstaclesBlockingStub> {
    private obstaclesBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private obstaclesBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected obstaclesBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new obstaclesBlockingStub(channel, callOptions);
    }
  }

  /**
   */
  public static final class obstaclesFutureStub extends io.grpc.stub.AbstractStub<obstaclesFutureStub> {
    private obstaclesFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private obstaclesFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected obstaclesFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new obstaclesFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_OBSTACLES_IN_ROAD = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final obstaclesImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(obstaclesImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_OBSTACLES_IN_ROAD:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.obstaclesInRoad(
              (io.grpc.stub.StreamObserver<obstacles.Message>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class obstaclesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    obstaclesBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return obstacles.obstaclesServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("obstacles");
    }
  }

  private static final class obstaclesFileDescriptorSupplier
      extends obstaclesBaseDescriptorSupplier {
    obstaclesFileDescriptorSupplier() {}
  }

  private static final class obstaclesMethodDescriptorSupplier
      extends obstaclesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    obstaclesMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (obstaclesGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new obstaclesFileDescriptorSupplier())
              .addMethod(getObstaclesInRoadMethod())
              .build();
        }
      }
    }
    return result;
  }
}
