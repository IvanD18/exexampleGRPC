package server;


import io.grpc.stub.StreamObserver;

import conf.Ex;
import conf.CalculateServiceGrpc;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import static java.lang.Math.*;

public class CalculateService extends CalculateServiceGrpc.CalculateServiceImplBase {

    //unary
    @Override
    public void sqr(Ex.CalculateRequest request, StreamObserver<Ex.CalculateResponse> responseObserver) {
        double var = request.getInput();
        Ex.CalculateResponse response = Ex.CalculateResponse.newBuilder().setOutput(sqrt(var)).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    //client streaming


    @Override
    public StreamObserver<Ex.CalculateRequest> std(StreamObserver<Ex.CalculateResponse> responseObserver) {
        StreamObserver<Ex.CalculateRequest> requestStreamObserver = new StreamObserver<Ex.CalculateRequest>() {
            double res = 0;
            int i = 0;

            @Override
            public void onNext(Ex.CalculateRequest calculateRequest) {
                res += calculateRequest.getInput();
                i += 1;
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onCompleted() {
                responseObserver.onNext(Ex.CalculateResponse.newBuilder().setOutput(res / i).build());
                responseObserver.onCompleted();
            }
        };
        return requestStreamObserver;
    }

    //server streaming
    @Override
    public void multipliers(Ex.CalculateRequest request, StreamObserver<Ex.CalculateResponse> responseObserver) {
        int variable = (int) request.getInput();
        List<Integer> mass = sieveOfEratosthenes(variable);
        mass.sort(Integer::compareTo);
        int i = 1;
        List<Double> result = new ArrayList<>();
        while (floorDiv(variable, i) != 1) {
            for (Integer j : mass) {
                if (floorMod(variable, j) == 0) {
                    result.add((double) j);
                    variable /= j;
                    break;
                }
            }
        }
        result.forEach(res -> {
            Ex.CalculateResponse response = Ex.CalculateResponse.newBuilder().setOutput(res).build();
            responseObserver.onNext(response);
        });
        responseObserver.onCompleted();
    }

    public static List sieveOfEratosthenes(int n) {
        boolean prime[] = new boolean[n + 1];
        Arrays.fill(prime, true);
        for (int p = 2; p * p <= n; p++) {
            if (prime[p]) {
                for (int i = p * 2; i <= n; i += p) {
                    prime[i] = false;
                }
            }
        }
        List primeNumbers = new LinkedList<>();
        for (int i = 2; i <= n; i++) {
            if (prime[i]) {
                primeNumbers.add(i);
            }
        }
        return primeNumbers;
    }

    //bi-directional streaming


    @Override
    public StreamObserver<Ex.CalculateRequest> max(StreamObserver<Ex.CalculateResponse> responseObserver) {
        StreamObserver<Ex.CalculateRequest> requestObserver = new StreamObserver<Ex.CalculateRequest>() {
            double max = Double.MIN_VALUE;

            @Override
            public void onNext(Ex.CalculateRequest calculateRequest) {
                if (max < calculateRequest.getInput()) {
                    max = calculateRequest.getInput();
                }
                Ex.CalculateResponse calculateResponse = Ex.CalculateResponse.newBuilder().setOutput(max).build();
                responseObserver.onNext(calculateResponse);
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
            }
        };
        return requestObserver;
    }
}
