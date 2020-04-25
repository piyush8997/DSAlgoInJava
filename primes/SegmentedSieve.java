package primes;

import java.util.ArrayList;
import java.util.Arrays;

public class SegmentedSieve {
    public static void printPrimes(int start, int end) {
        System.out.println("SegmentedSieve.printPrimes");

        ArrayList<Integer> primeNumbers = new ArrayList<>();
        int newEnd = ((int) Math.sqrt(end)) + 1;

        sieveOfEratosthenes(newEnd, primeNumbers);

        int n = end - start + 1;
        boolean[] mark = new boolean[n + 1];
        Arrays.fill(mark, true);

        for (int prime : primeNumbers) {
            int lowLim = (start / prime) * prime;
            if (lowLim < start || lowLim == prime) {
                lowLim += prime;
            }
            for (int i = lowLim; i <= end; i += prime) {
                if(prime % i != 0) {
                    mark[i - start] = false;
                }
            }
        }

        for (int i = start; i <= end; i++) {
            if (mark[i - start]) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    private static void sieveOfEratosthenes(int end, ArrayList<Integer> primeNumbers) {
        boolean[] primes = new boolean[end + 1];
        Arrays.fill(primes, true);

        for (int p = 2; p * p <= end; p++) {
            if (primes[p]) {
                for (int i = p * 2; i <= end; i += p) {
                    primes[i] = false;
                }
            }
        }

        for (int i = 2; i < primes.length; i++) {
            if (primes[i]) {
                primeNumbers.add(i);
            }
        }
    }
}
