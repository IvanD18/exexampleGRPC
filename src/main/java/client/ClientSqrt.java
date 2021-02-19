package client;

import conf.CalculateServiceGrpc;
import conf.Ex;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.Arrays;

public class ClientSqrt {
    public static void main(String[] args) {
        //unary (blocking - sync)
        System.out.print("SQRT: ");
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080).usePlaintext().build();
        CalculateServiceGrpc.CalculateServiceBlockingStub stub = CalculateServiceGrpc.newBlockingStub(channel);
        Ex.CalculateResponse response = stub.sqr(Ex.CalculateRequest.newBuilder().setInput(16).build());

        System.out.println(response.getOutput());
        channel.shutdown();
    }
}
