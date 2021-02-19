package client;

import conf.CalculateServiceGrpc;
import conf.Ex;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;

public class ClientStd {
    public static void main(String[] args) throws InterruptedException {


        //client streaming (async)
        System.out.print("STD: ");
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080).usePlaintext().build();
        CalculateServiceGrpc.CalculateServiceStub asyncClient = CalculateServiceGrpc.newStub(channel);


        StreamObserver<Ex.CalculateResponse> calculateResponseStreamObserver = new StreamObserver<Ex.CalculateResponse>() {
            double res = 0;

            @Override

            public void onNext(Ex.CalculateResponse calculateResponse) {
                res = calculateResponse.getOutput();


            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("Error");
            }

            @Override
            public void onCompleted() {
                System.out.println(res);
            }
        };


        StreamObserver<Ex.CalculateRequest> requestStreamObserver = asyncClient.std(calculateResponseStreamObserver);


        Arrays.asList(1.0, 2.0, 6.0, 3.0).forEach(value -> requestStreamObserver.onNext(Ex.CalculateRequest.newBuilder().setInput(value).build()));


        requestStreamObserver.onCompleted();


        Thread.sleep(1000);
        channel.shutdown();


    }

    static class MyThread extends Thread {
        CountDownLatch cdl;
        StreamObserver<Ex.CalculateRequest> requestStreamObserver;

        public MyThread(CountDownLatch latch, StreamObserver<Ex.CalculateRequest> streamObserver) {
            cdl = latch;
            requestStreamObserver = streamObserver;
        }

        @Override
        public void run() {
            Arrays.asList(1.0, 2.0, 6.0, 3.0).forEach(value -> {
                requestStreamObserver.onNext(Ex.CalculateRequest.newBuilder().setInput(value).build());
            });
            cdl.countDown();
            requestStreamObserver.onCompleted();
            cdl.countDown();
        }
    }
}
