package Obstacles;

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
    comments = "Source: ObstaclesService.proto")
public final class ObstaclesGrpc {

  private ObstaclesGrpc() {}

  public static final String SERVICE_NAME = "Obstacles.Obstacles";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<Obstacles.StringMessage,
      Obstacles.StringMessage> getObstaclesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Obstacles",
      requestType = Obstacles.StringMessage.class,
      responseType = Obstacles.StringMessage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<Obstacles.StringMessage,
      Obstacles.StringMessage> getObstaclesMethod() {
    io.grpc.MethodDescriptor<Obstacles.StringMessage, Obstacles.StringMessage> getObstaclesMethod;
    if ((getObstaclesMethod = ObstaclesGrpc.getObstaclesMethod) == null) {
      synchronized (ObstaclesGrpc.class) {
        if ((getObstaclesMethod = ObstaclesGrpc.getObstaclesMethod) == null) {
          ObstaclesGrpc.getObstaclesMethod = getObstaclesMethod = 
              io.grpc.MethodDescriptor.<Obstacles.StringMessage, Obstacles.StringMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "Obstacles.Obstacles", "Obstacles"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Obstacles.StringMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Obstacles.StringMessage.getDefaultInstance()))
                  .setSchemaDescriptor(new ObstaclesMethodDescriptorSupplier("Obstacles"))
                  .build();
          }
        }
     }
     return getObstaclesMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ObstaclesStub newStub(io.grpc.Channel channel) {
    return new ObstaclesStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ObstaclesBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ObstaclesBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ObstaclesFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ObstaclesFutureStub(channel);
  }

  /**
   */
  public static abstract class ObstaclesImplBase implements io.grpc.BindableService {

    /**
     */
    public void obstacles(Obstacles.StringMessage request,
        io.grpc.stub.StreamObserver<Obstacles.StringMessage> responseObserver) {
      asyncUnimplementedUnaryCall(getObstaclesMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getObstaclesMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                Obstacles.StringMessage,
                Obstacles.StringMessage>(
                  this, METHODID_OBSTACLES)))
          .build();
    }
  }

  /**
   */
  public static final class ObstaclesStub extends io.grpc.stub.AbstractStub<ObstaclesStub> {
    private ObstaclesStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ObstaclesStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ObstaclesStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ObstaclesStub(channel, callOptions);
    }

    /**
     */
    public void obstacles(Obstacles.StringMessage request,
        io.grpc.stub.StreamObserver<Obstacles.StringMessage> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getObstaclesMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ObstaclesBlockingStub extends io.grpc.stub.AbstractStub<ObstaclesBlockingStub> {
    private ObstaclesBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ObstaclesBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ObstaclesBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ObstaclesBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<Obstacles.StringMessage> obstacles(
        Obstacles.StringMessage request) {
      return blockingServerStreamingCall(
          getChannel(), getObstaclesMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ObstaclesFutureStub extends io.grpc.stub.AbstractStub<ObstaclesFutureStub> {
    private ObstaclesFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ObstaclesFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ObstaclesFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ObstaclesFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_OBSTACLES = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ObstaclesImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ObstaclesImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_OBSTACLES:
          serviceImpl.obstacles((Obstacles.StringMessage) request,
              (io.grpc.stub.StreamObserver<Obstacles.StringMessage>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ObstaclesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ObstaclesBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return Obstacles.ObstaclesServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Obstacles");
    }
  }

  private static final class ObstaclesFileDescriptorSupplier
      extends ObstaclesBaseDescriptorSupplier {
    ObstaclesFileDescriptorSupplier() {}
  }

  private static final class ObstaclesMethodDescriptorSupplier
      extends ObstaclesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ObstaclesMethodDescriptorSupplier(String methodName) {
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
      synchronized (ObstaclesGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ObstaclesFileDescriptorSupplier())
              .addMethod(getObstaclesMethod())
              .build();
        }
      }
    }
    return result;
  }
}
