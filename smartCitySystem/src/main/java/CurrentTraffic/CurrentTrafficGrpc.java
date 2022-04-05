package CurrentTraffic;

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
    comments = "Source: CurrentTrafficService.proto")
public final class CurrentTrafficGrpc {

  private CurrentTrafficGrpc() {}

  public static final String SERVICE_NAME = "CurrentTraffic.CurrentTraffic";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<CurrentTraffic.StringMessage,
      CurrentTraffic.StringMessage> getCurrentTrafficServiceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "currentTrafficService",
      requestType = CurrentTraffic.StringMessage.class,
      responseType = CurrentTraffic.StringMessage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<CurrentTraffic.StringMessage,
      CurrentTraffic.StringMessage> getCurrentTrafficServiceMethod() {
    io.grpc.MethodDescriptor<CurrentTraffic.StringMessage, CurrentTraffic.StringMessage> getCurrentTrafficServiceMethod;
    if ((getCurrentTrafficServiceMethod = CurrentTrafficGrpc.getCurrentTrafficServiceMethod) == null) {
      synchronized (CurrentTrafficGrpc.class) {
        if ((getCurrentTrafficServiceMethod = CurrentTrafficGrpc.getCurrentTrafficServiceMethod) == null) {
          CurrentTrafficGrpc.getCurrentTrafficServiceMethod = getCurrentTrafficServiceMethod = 
              io.grpc.MethodDescriptor.<CurrentTraffic.StringMessage, CurrentTraffic.StringMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "CurrentTraffic.CurrentTraffic", "currentTrafficService"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  CurrentTraffic.StringMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  CurrentTraffic.StringMessage.getDefaultInstance()))
                  .setSchemaDescriptor(new CurrentTrafficMethodDescriptorSupplier("currentTrafficService"))
                  .build();
          }
        }
     }
     return getCurrentTrafficServiceMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CurrentTrafficStub newStub(io.grpc.Channel channel) {
    return new CurrentTrafficStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CurrentTrafficBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new CurrentTrafficBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CurrentTrafficFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new CurrentTrafficFutureStub(channel);
  }

  /**
   */
  public static abstract class CurrentTrafficImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<CurrentTraffic.StringMessage> currentTrafficService(
        io.grpc.stub.StreamObserver<CurrentTraffic.StringMessage> responseObserver) {
      return asyncUnimplementedStreamingCall(getCurrentTrafficServiceMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCurrentTrafficServiceMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                CurrentTraffic.StringMessage,
                CurrentTraffic.StringMessage>(
                  this, METHODID_CURRENT_TRAFFIC_SERVICE)))
          .build();
    }
  }

  /**
   */
  public static final class CurrentTrafficStub extends io.grpc.stub.AbstractStub<CurrentTrafficStub> {
    private CurrentTrafficStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CurrentTrafficStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CurrentTrafficStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CurrentTrafficStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<CurrentTraffic.StringMessage> currentTrafficService(
        io.grpc.stub.StreamObserver<CurrentTraffic.StringMessage> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getCurrentTrafficServiceMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class CurrentTrafficBlockingStub extends io.grpc.stub.AbstractStub<CurrentTrafficBlockingStub> {
    private CurrentTrafficBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CurrentTrafficBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CurrentTrafficBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CurrentTrafficBlockingStub(channel, callOptions);
    }
  }

  /**
   */
  public static final class CurrentTrafficFutureStub extends io.grpc.stub.AbstractStub<CurrentTrafficFutureStub> {
    private CurrentTrafficFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CurrentTrafficFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CurrentTrafficFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CurrentTrafficFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_CURRENT_TRAFFIC_SERVICE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CurrentTrafficImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CurrentTrafficImplBase serviceImpl, int methodId) {
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
        case METHODID_CURRENT_TRAFFIC_SERVICE:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.currentTrafficService(
              (io.grpc.stub.StreamObserver<CurrentTraffic.StringMessage>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class CurrentTrafficBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CurrentTrafficBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return CurrentTraffic.CurrentTrafficServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CurrentTraffic");
    }
  }

  private static final class CurrentTrafficFileDescriptorSupplier
      extends CurrentTrafficBaseDescriptorSupplier {
    CurrentTrafficFileDescriptorSupplier() {}
  }

  private static final class CurrentTrafficMethodDescriptorSupplier
      extends CurrentTrafficBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CurrentTrafficMethodDescriptorSupplier(String methodName) {
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
      synchronized (CurrentTrafficGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CurrentTrafficFileDescriptorSupplier())
              .addMethod(getCurrentTrafficServiceMethod())
              .build();
        }
      }
    }
    return result;
  }
}
