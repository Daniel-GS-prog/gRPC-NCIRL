package currentTraffic;

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
    comments = "Source: currentTraffic.proto")
public final class currentTrafficGrpc {

  private currentTrafficGrpc() {}

  public static final String SERVICE_NAME = "currentTraffic.currentTraffic";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<currentTraffic.StringMessage,
      currentTraffic.StringMessage> getCurrentTrafficMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CurrentTraffic",
      requestType = currentTraffic.StringMessage.class,
      responseType = currentTraffic.StringMessage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<currentTraffic.StringMessage,
      currentTraffic.StringMessage> getCurrentTrafficMethod() {
    io.grpc.MethodDescriptor<currentTraffic.StringMessage, currentTraffic.StringMessage> getCurrentTrafficMethod;
    if ((getCurrentTrafficMethod = currentTrafficGrpc.getCurrentTrafficMethod) == null) {
      synchronized (currentTrafficGrpc.class) {
        if ((getCurrentTrafficMethod = currentTrafficGrpc.getCurrentTrafficMethod) == null) {
          currentTrafficGrpc.getCurrentTrafficMethod = getCurrentTrafficMethod = 
              io.grpc.MethodDescriptor.<currentTraffic.StringMessage, currentTraffic.StringMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "currentTraffic.currentTraffic", "CurrentTraffic"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  currentTraffic.StringMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  currentTraffic.StringMessage.getDefaultInstance()))
                  .setSchemaDescriptor(new currentTrafficMethodDescriptorSupplier("CurrentTraffic"))
                  .build();
          }
        }
     }
     return getCurrentTrafficMethod;
  }

  private static volatile io.grpc.MethodDescriptor<currentTraffic.StringMessage,
      currentTraffic.StringMessage> getTrafficInCityMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TrafficInCity",
      requestType = currentTraffic.StringMessage.class,
      responseType = currentTraffic.StringMessage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<currentTraffic.StringMessage,
      currentTraffic.StringMessage> getTrafficInCityMethod() {
    io.grpc.MethodDescriptor<currentTraffic.StringMessage, currentTraffic.StringMessage> getTrafficInCityMethod;
    if ((getTrafficInCityMethod = currentTrafficGrpc.getTrafficInCityMethod) == null) {
      synchronized (currentTrafficGrpc.class) {
        if ((getTrafficInCityMethod = currentTrafficGrpc.getTrafficInCityMethod) == null) {
          currentTrafficGrpc.getTrafficInCityMethod = getTrafficInCityMethod = 
              io.grpc.MethodDescriptor.<currentTraffic.StringMessage, currentTraffic.StringMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "currentTraffic.currentTraffic", "TrafficInCity"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  currentTraffic.StringMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  currentTraffic.StringMessage.getDefaultInstance()))
                  .setSchemaDescriptor(new currentTrafficMethodDescriptorSupplier("TrafficInCity"))
                  .build();
          }
        }
     }
     return getTrafficInCityMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static currentTrafficStub newStub(io.grpc.Channel channel) {
    return new currentTrafficStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static currentTrafficBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new currentTrafficBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static currentTrafficFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new currentTrafficFutureStub(channel);
  }

  /**
   */
  public static abstract class currentTrafficImplBase implements io.grpc.BindableService {

    /**
     */
    public void currentTraffic(currentTraffic.StringMessage request,
        io.grpc.stub.StreamObserver<currentTraffic.StringMessage> responseObserver) {
      asyncUnimplementedUnaryCall(getCurrentTrafficMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<currentTraffic.StringMessage> trafficInCity(
        io.grpc.stub.StreamObserver<currentTraffic.StringMessage> responseObserver) {
      return asyncUnimplementedStreamingCall(getTrafficInCityMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCurrentTrafficMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                currentTraffic.StringMessage,
                currentTraffic.StringMessage>(
                  this, METHODID_CURRENT_TRAFFIC)))
          .addMethod(
            getTrafficInCityMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                currentTraffic.StringMessage,
                currentTraffic.StringMessage>(
                  this, METHODID_TRAFFIC_IN_CITY)))
          .build();
    }
  }

  /**
   */
  public static final class currentTrafficStub extends io.grpc.stub.AbstractStub<currentTrafficStub> {
    private currentTrafficStub(io.grpc.Channel channel) {
      super(channel);
    }

    private currentTrafficStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected currentTrafficStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new currentTrafficStub(channel, callOptions);
    }

    /**
     */
    public void currentTraffic(currentTraffic.StringMessage request,
        io.grpc.stub.StreamObserver<currentTraffic.StringMessage> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getCurrentTrafficMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<currentTraffic.StringMessage> trafficInCity(
        io.grpc.stub.StreamObserver<currentTraffic.StringMessage> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getTrafficInCityMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class currentTrafficBlockingStub extends io.grpc.stub.AbstractStub<currentTrafficBlockingStub> {
    private currentTrafficBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private currentTrafficBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected currentTrafficBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new currentTrafficBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<currentTraffic.StringMessage> currentTraffic(
        currentTraffic.StringMessage request) {
      return blockingServerStreamingCall(
          getChannel(), getCurrentTrafficMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class currentTrafficFutureStub extends io.grpc.stub.AbstractStub<currentTrafficFutureStub> {
    private currentTrafficFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private currentTrafficFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected currentTrafficFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new currentTrafficFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_CURRENT_TRAFFIC = 0;
  private static final int METHODID_TRAFFIC_IN_CITY = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final currentTrafficImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(currentTrafficImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CURRENT_TRAFFIC:
          serviceImpl.currentTraffic((currentTraffic.StringMessage) request,
              (io.grpc.stub.StreamObserver<currentTraffic.StringMessage>) responseObserver);
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
        case METHODID_TRAFFIC_IN_CITY:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.trafficInCity(
              (io.grpc.stub.StreamObserver<currentTraffic.StringMessage>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class currentTrafficBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    currentTrafficBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return currentTraffic.currentTrafficServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("currentTraffic");
    }
  }

  private static final class currentTrafficFileDescriptorSupplier
      extends currentTrafficBaseDescriptorSupplier {
    currentTrafficFileDescriptorSupplier() {}
  }

  private static final class currentTrafficMethodDescriptorSupplier
      extends currentTrafficBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    currentTrafficMethodDescriptorSupplier(String methodName) {
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
      synchronized (currentTrafficGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new currentTrafficFileDescriptorSupplier())
              .addMethod(getCurrentTrafficMethod())
              .addMethod(getTrafficInCityMethod())
              .build();
        }
      }
    }
    return result;
  }
}
