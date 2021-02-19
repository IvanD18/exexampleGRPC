package client;

import conf.CalculateServiceGrpc;
import conf.Ex;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.Arrays;

public class ClientMulti {
    public static void main(String[] args) {
        //server streaming (sync)
        System.out.print("MULTI: ");
        ManagedChannel chan = ManagedChannelBuilder.forAddress("localhost", 8080).usePlaintext().build();

        CalculateServiceGrpc.CalculateServiceBlockingStub calculateClient = CalculateServiceGrpc.newBlockingStub(chan);

        Ex.CalculateRequest multiRequest = Ex.CalculateRequest.newBuilder().setInput(18).build();

        calculateClient.multipliers(multiRequest).forEachRemaining(multiResponse -> {
            Double result = multiResponse.getOutput();
            System.out.println(result);
        });

        chan.shutdown();
    }
}
