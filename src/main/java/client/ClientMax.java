package client;

import conf.CalculateServiceGrpc;
import conf.Ex;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.Arrays;

public class ClientMax {
    public static void main(String[] args) throws InterruptedException {

        //bi-directional streaming (async)
        System.out.print("MAX: ");
        ManagedChannel chan = ManagedChannelBuilder.forAddress("localhost", 8080).usePlaintext().build();
        CalculateServiceGrpc.CalculateServiceStub asClient = CalculateServiceGrpc.newStub(chan);
        StreamObserver<Ex.CalculateRequest> requestObserver = asClient.max(new StreamObserver<Ex.CalculateResponse>() {
            @Override
            public void onNext(Ex.CalculateResponse calculateResponse) {
                double res = calculateResponse.getOutput();
                System.out.println(res);
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onCompleted() {

            }
        });
        Arrays.asList(1.0,0.0,-15.0, 10.0, 7.0, 12.0).forEach(value -> {
            requestObserver.onNext(Ex.CalculateRequest.newBuilder().setInput(value).build());

        });

        requestObserver.onCompleted();
        Thread.sleep(1000);
        chan.shutdown();
    }
}
