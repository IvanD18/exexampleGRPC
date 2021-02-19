package server;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Prob {
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
    public static void main(String[] args) {
        List<Integer> mass = sieveOfEratosthenes(256);
        System.out.println(mass);
    }
}
