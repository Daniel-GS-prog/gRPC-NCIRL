package cityInService;

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
    comments = "Source: cityInSystemService.proto")
public final class cityInServiceGrpc {

  private cityInServiceGrpc() {}

  public static final String SERVICE_NAME = "cityInService.cityInService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<cityInService.StringMessage,
      cityInService.StringMessage> getCityInServiceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CityInService",
      requestType = cityInService.StringMessage.class,
      responseType = cityInService.StringMessage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<cityInService.StringMessage,
      cityInService.StringMessage> getCityInServiceMethod() {
    io.grpc.MethodDescriptor<cityInService.StringMessage, cityInService.StringMessage> getCityInServiceMethod;
    if ((getCityInServiceMethod = cityInServiceGrpc.getCityInServiceMethod) == null) {
      synchronized (cityInServiceGrpc.class) {
        if ((getCityInServiceMethod = cityInServiceGrpc.getCityInServiceMethod) == null) {
          cityInServiceGrpc.getCityInServiceMethod = getCityInServiceMethod = 
              io.grpc.MethodDescriptor.<cityInService.StringMessage, cityInService.StringMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "cityInService.cityInService", "CityInService"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cityInService.StringMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cityInService.StringMessage.getDefaultInstance()))
                  .setSchemaDescriptor(new cityInServiceMethodDescriptorSupplier("CityInService"))
                  .build();
          }
        }
     }
     return getCityInServiceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<cityInService.StringMessage,
      cityInService.IntMessage> getTemperatureInCityMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TemperatureInCity",
      requestType = cityInService.StringMessage.class,
      responseType = cityInService.IntMessage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<cityInService.StringMessage,
      cityInService.IntMessage> getTemperatureInCityMethod() {
    io.grpc.MethodDescriptor<cityInService.StringMessage, cityInService.IntMessage> getTemperatureInCityMethod;
    if ((getTemperatureInCityMethod = cityInServiceGrpc.getTemperatureInCityMethod) == null) {
      synchronized (cityInServiceGrpc.class) {
        if ((getTemperatureInCityMethod = cityInServiceGrpc.getTemperatureInCityMethod) == null) {
          cityInServiceGrpc.getTemperatureInCityMethod = getTemperatureInCityMethod = 
              io.grpc.MethodDescriptor.<cityInService.StringMessage, cityInService.IntMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "cityInService.cityInService", "TemperatureInCity"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cityInService.StringMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cityInService.IntMessage.getDefaultInstance()))
                  .setSchemaDescriptor(new cityInServiceMethodDescriptorSupplier("TemperatureInCity"))
                  .build();
          }
        }
     }
     return getTemperatureInCityMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static cityInServiceStub newStub(io.grpc.Channel channel) {
    return new cityInServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static cityInServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new cityInServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static cityInServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new cityInServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class cityInServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void cityInService(cityInService.StringMessage request,
        io.grpc.stub.StreamObserver<cityInService.StringMessage> responseObserver) {
      asyncUnimplementedUnaryCall(getCityInServiceMethod(), responseObserver);
    }

    /**
     */
    public void temperatureInCity(cityInService.StringMessage request,
        io.grpc.stub.StreamObserver<cityInService.IntMessage> responseObserver) {
      asyncUnimplementedUnaryCall(getTemperatureInCityMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCityInServiceMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                cityInService.StringMessage,
                cityInService.StringMessage>(
                  this, METHODID_CITY_IN_SERVICE)))
          .addMethod(
            getTemperatureInCityMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                cityInService.StringMessage,
                cityInService.IntMessage>(
                  this, METHODID_TEMPERATURE_IN_CITY)))
          .build();
    }
  }

  /**
   */
  public static final class cityInServiceStub extends io.grpc.stub.AbstractStub<cityInServiceStub> {
    private cityInServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private cityInServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected cityInServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new cityInServiceStub(channel, callOptions);
    }

    /**
     */
    public void cityInService(cityInService.StringMessage request,
        io.grpc.stub.StreamObserver<cityInService.StringMessage> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCityInServiceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void temperatureInCity(cityInService.StringMessage request,
        io.grpc.stub.StreamObserver<cityInService.IntMessage> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getTemperatureInCityMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class cityInServiceBlockingStub extends io.grpc.stub.AbstractStub<cityInServiceBlockingStub> {
    private cityInServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private cityInServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected cityInServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new cityInServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public cityInService.StringMessage cityInService(cityInService.StringMessage request) {
      return blockingUnaryCall(
          getChannel(), getCityInServiceMethod(), getCallOptions(), request);
    }

    /**
     */
    public cityInService.IntMessage temperatureInCity(cityInService.StringMessage request) {
      return blockingUnaryCall(
          getChannel(), getTemperatureInCityMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class cityInServiceFutureStub extends io.grpc.stub.AbstractStub<cityInServiceFutureStub> {
    private cityInServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private cityInServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected cityInServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new cityInServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<cityInService.StringMessage> cityInService(
        cityInService.StringMessage request) {
      return futureUnaryCall(
          getChannel().newCall(getCityInServiceMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<cityInService.IntMessage> temperatureInCity(
        cityInService.StringMessage request) {
      return futureUnaryCall(
          getChannel().newCall(getTemperatureInCityMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CITY_IN_SERVICE = 0;
  private static final int METHODID_TEMPERATURE_IN_CITY = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final cityInServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(cityInServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CITY_IN_SERVICE:
          serviceImpl.cityInService((cityInService.StringMessage) request,
              (io.grpc.stub.StreamObserver<cityInService.StringMessage>) responseObserver);
          break;
        case METHODID_TEMPERATURE_IN_CITY:
          serviceImpl.temperatureInCity((cityInService.StringMessage) request,
              (io.grpc.stub.StreamObserver<cityInService.IntMessage>) responseObserver);
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

  private static abstract class cityInServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    cityInServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return cityInService.cityInServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("cityInService");
    }
  }

  private static final class cityInServiceFileDescriptorSupplier
      extends cityInServiceBaseDescriptorSupplier {
    cityInServiceFileDescriptorSupplier() {}
  }

  private static final class cityInServiceMethodDescriptorSupplier
      extends cityInServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    cityInServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (cityInServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new cityInServiceFileDescriptorSupplier())
              .addMethod(getCityInServiceMethod())
              .addMethod(getTemperatureInCityMethod())
              .build();
        }
      }
    }
    return result;
  }
}
