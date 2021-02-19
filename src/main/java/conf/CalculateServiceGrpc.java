package conf;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.*;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.*;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.4.0)",
    comments = "Source: ex.proto")
public final class CalculateServiceGrpc {

  private CalculateServiceGrpc() {}

  public static final String SERVICE_NAME = "CalculateService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<Ex.CalculateRequest,
      Ex.CalculateResponse> METHOD_SQR =
      io.grpc.MethodDescriptor.<Ex.CalculateRequest, Ex.CalculateResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "CalculateService", "Sqr"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              Ex.CalculateRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              Ex.CalculateResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<Ex.CalculateRequest,
      Ex.CalculateResponse> METHOD_STD =
      io.grpc.MethodDescriptor.<Ex.CalculateRequest, Ex.CalculateResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
          .setFullMethodName(generateFullMethodName(
              "CalculateService", "Std"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              Ex.CalculateRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              Ex.CalculateResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<Ex.CalculateRequest,
      Ex.CalculateResponse> METHOD_MULTIPLIERS =
      io.grpc.MethodDescriptor.<Ex.CalculateRequest, Ex.CalculateResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
          .setFullMethodName(generateFullMethodName(
              "CalculateService", "Multipliers"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              Ex.CalculateRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              Ex.CalculateResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<Ex.CalculateRequest,
      Ex.CalculateResponse> METHOD_MAX =
      io.grpc.MethodDescriptor.<Ex.CalculateRequest, Ex.CalculateResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
          .setFullMethodName(generateFullMethodName(
              "CalculateService", "Max"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              Ex.CalculateRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              Ex.CalculateResponse.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CalculateServiceStub newStub(io.grpc.Channel channel) {
    return new CalculateServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CalculateServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new CalculateServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CalculateServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new CalculateServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class CalculateServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void sqr(Ex.CalculateRequest request,
                    io.grpc.stub.StreamObserver<Ex.CalculateResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SQR, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<Ex.CalculateRequest> std(
        io.grpc.stub.StreamObserver<Ex.CalculateResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(METHOD_STD, responseObserver);
    }

    /**
     */
    public void multipliers(Ex.CalculateRequest request,
                            io.grpc.stub.StreamObserver<Ex.CalculateResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_MULTIPLIERS, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<Ex.CalculateRequest> max(
        io.grpc.stub.StreamObserver<Ex.CalculateResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(METHOD_MAX, responseObserver);
    }

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_SQR,
            asyncUnaryCall(
              new MethodHandlers<
                Ex.CalculateRequest,
                Ex.CalculateResponse>(
                  this, METHODID_SQR)))
          .addMethod(
            METHOD_STD,
            asyncClientStreamingCall(
              new MethodHandlers<
                Ex.CalculateRequest,
                Ex.CalculateResponse>(
                  this, METHODID_STD)))
          .addMethod(
            METHOD_MULTIPLIERS,
            asyncServerStreamingCall(
              new MethodHandlers<
                Ex.CalculateRequest,
                Ex.CalculateResponse>(
                  this, METHODID_MULTIPLIERS)))
          .addMethod(
            METHOD_MAX,
            asyncBidiStreamingCall(
              new MethodHandlers<
                Ex.CalculateRequest,
                Ex.CalculateResponse>(
                  this, METHODID_MAX)))
          .build();
    }
  }

  /**
   */
  public static final class CalculateServiceStub extends io.grpc.stub.AbstractStub<CalculateServiceStub> {
    private CalculateServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CalculateServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected CalculateServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CalculateServiceStub(channel, callOptions);
    }

    /**
     */
    public void sqr(Ex.CalculateRequest request,
                    io.grpc.stub.StreamObserver<Ex.CalculateResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SQR, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<Ex.CalculateRequest> std(
        io.grpc.stub.StreamObserver<Ex.CalculateResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(METHOD_STD, getCallOptions()), responseObserver);
    }

    /**
     */
    public void multipliers(Ex.CalculateRequest request,
                            io.grpc.stub.StreamObserver<Ex.CalculateResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(METHOD_MULTIPLIERS, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<Ex.CalculateRequest> max(
        io.grpc.stub.StreamObserver<Ex.CalculateResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(METHOD_MAX, getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class CalculateServiceBlockingStub extends io.grpc.stub.AbstractStub<CalculateServiceBlockingStub> {
    private CalculateServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CalculateServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected CalculateServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CalculateServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public Ex.CalculateResponse sqr(Ex.CalculateRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SQR, getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<Ex.CalculateResponse> multipliers(
        Ex.CalculateRequest request) {
      return blockingServerStreamingCall(
          getChannel(), METHOD_MULTIPLIERS, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class CalculateServiceFutureStub extends io.grpc.stub.AbstractStub<CalculateServiceFutureStub> {
    private CalculateServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CalculateServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected CalculateServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CalculateServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Ex.CalculateResponse> sqr(
        Ex.CalculateRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SQR, getCallOptions()), request);
    }
  }

  private static final int METHODID_SQR = 0;
  private static final int METHODID_MULTIPLIERS = 1;
  private static final int METHODID_STD = 2;
  private static final int METHODID_MAX = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CalculateServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CalculateServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SQR:
          serviceImpl.sqr((Ex.CalculateRequest) request,
              (io.grpc.stub.StreamObserver<Ex.CalculateResponse>) responseObserver);
          break;
        case METHODID_MULTIPLIERS:
          serviceImpl.multipliers((Ex.CalculateRequest) request,
              (io.grpc.stub.StreamObserver<Ex.CalculateResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @Override
    @SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_STD:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.std(
              (io.grpc.stub.StreamObserver<Ex.CalculateResponse>) responseObserver);
        case METHODID_MAX:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.max(
              (io.grpc.stub.StreamObserver<Ex.CalculateResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static final class CalculateServiceDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return Ex.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (CalculateServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CalculateServiceDescriptorSupplier())
              .addMethod(METHOD_SQR)
              .addMethod(METHOD_STD)
              .addMethod(METHOD_MULTIPLIERS)
              .addMethod(METHOD_MAX)
              .build();
        }
      }
    }
    return result;
  }
}
