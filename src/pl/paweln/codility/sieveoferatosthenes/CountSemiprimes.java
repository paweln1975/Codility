package pl.paweln.codility.sieveoferatosthenes;

import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.SolutionInputParams;

import java.util.*;

public class CountSemiprimes implements CodilitySolution {
    @Override
    public int[] solution(SolutionInputParams params) {
        int N = params.getN();
        int[] P = params.getFirstArray();
        int[] Q = params.getSecondArray();

        if (N < 1) {
            throw new IllegalArgumentException("N must be greater then 0.");
        }

        if (N > 50000) {
            throw new IllegalArgumentException("N must be lower then 50 000.");
        }

        if (P.length == 0) {
            throw new IllegalArgumentException("First array is empty.");
        }

        if (P.length > 30000) {
            throw new IllegalArgumentException("First array is to big. Max size is 30 000.");
        }

        if (P.length != Q.length) {
            throw new IllegalArgumentException("Arrays must have the same size.");
        }

        for (int i = 0; i < P.length; i++) {
            if (P[i] > Q[i]) {
                throw new IllegalArgumentException("Element from first table is greater then element from secoond table for index i=" + i);
            }
            if (Q[i] < 1 || P[i] < 1) {
                throw new IllegalArgumentException("All table elements must greater then 0.");
            }
            if (Q[i] > N) {
                throw new IllegalArgumentException("Each table element cannot be greater then N=" + N);
            }
        }
        return this.solution(N, P, Q);
    }

    private int[] solution(int N, int[] P, int[] Q) {
        int [] primes = this.generatePrimes(N);

        int[] semiprimes = this.calculateSemiPrimes(N, primes);

        int [] cumulativeSemiPrimesCount = new int[N + 1];

        // calculate cumulative number of semiprimes
        int semiPrimeIndex = 0;
        for (int i = 1; i <= N; i++) {
            cumulativeSemiPrimesCount[i] = cumulativeSemiPrimesCount[i-1];
            while (semiPrimeIndex < semiprimes.length && semiprimes[semiPrimeIndex] <= i) {
                cumulativeSemiPrimesCount[i]++;
                semiPrimeIndex++;
            }

        }

        int[] resultTab = new int[P.length];
        for (int i = 0; i < resultTab.length; i++) {
            resultTab[i] = cumulativeSemiPrimesCount[Q[i]] - cumulativeSemiPrimesCount[P[i]-1];
        }

        return resultTab;
    }

    private int[] calculateSemiPrimes(int N, int[] primes) {

        // find "semiprimes"
        boolean[] semiprimeArray = new boolean[N+1]; // note: plus one for "0"
        Arrays.fill(semiprimeArray, false); // initial setting: all "not" semiprimes

        for (int i = 0; i < primes.length; i++) {
            for (int j = i; j < primes.length; j++) {
                long semiPrimeTmp = (long)primes[i] * (long)primes[j];
                if (semiPrimeTmp <= (long)N) {
                    semiprimeArray[(int)semiPrimeTmp] = true;
                } else {
                    break;
                }
            }
        }

        // store all primes in "List"
        List<Integer> semiPrimeList = new ArrayList<>();
        for(int i=2; i<= N; i++){
            if(semiprimeArray[i]){
                semiPrimeList.add(i);    // "i" is semiprime
            }
        }

        return semiPrimeList.stream().mapToInt(Integer::intValue).toArray();
    }


    private int[] generatePrimes(int N) {
        boolean[] primeArray = new boolean[N+1]; // note: plus one for "0"

        // initial settting (sieve of Eratosthenes)
        Arrays.fill(primeArray, true); // initial setting: all primes
        primeArray[0] = false;         // not prime
        primeArray[1] = false;         // not prime
        int sqrtN = (int)Math.sqrt(N);
        // sieve of Eratosthenes
        for(int i =1; i < sqrtN; i++){
            if(primeArray[i]) // prime
            {
                int j = i + i;
                for(; j<=N; j=j+i){
                    primeArray[j] = false; // not prime
                }
            }
        }

        // store all primes in "List"
        List<Integer> primeList = new ArrayList<>();
        for(int i=2; i<= N; i++){
            if(primeArray[i]){
                primeList.add(i);    // "i" is prime
            }
        }

        // return as array
        return primeList.stream().mapToInt(Integer::intValue).toArray();
    }

}
