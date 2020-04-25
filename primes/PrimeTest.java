package primes;

import java.util.Arrays;

public class PrimeTest {
    public static void main(String[] args) {
        int num = 7;
        System.out.println(num + " is " + (isPrime(num) ? "prime." : "not prime."));

        sieveOfEratosthenes(100);

        SegmentedSieve.printPrimes(5, 100);
    }

    // Check whether number is prime or not
    public static boolean isPrime(int num) {
        System.out.println("PrimeTest.isPrime");
        if(num == 0 || num == 1) {
            return false;
        }
        for(int i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Sieve of Eratosthenes to print prime numbers till n
    public static void sieveOfEratosthenes(int n) {
        System.out.println("PrimeTest.sieveOfEratosthenes");
        boolean[] primes = new boolean[n + 1];
        Arrays.fill(primes, true);

        for(int p = 2; p * p <= n; p++) {
            if(primes[p]) {
                for(int i = 2*p; i <= n; i+=p) {
                    primes[i] = false;
                }
            }
        }

        for(int i = 2; i < primes.length; i++) {
            if(primes[i]) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}
