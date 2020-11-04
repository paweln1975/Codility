package pl.paweln.codility.sieveoferatosthenes;

import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.SolutionInputParams;

import java.util.LinkedHashSet;
import java.util.Set;

public class SieveOfEratosthenes implements CodilitySolution {
    @Override
    public int[] solution(SolutionInputParams params) {
        int N = params.getN();

        if (N > 46340) {
            throw new IllegalArgumentException("N parameter max value is 46340");
        }
        return this.solution(N);
    }
    private int[] solution (int N) {
        Set<Integer> candidates = new LinkedHashSet<>();
        for (int i = 2; i <= N; i++) {
            candidates.add(i);
        }

        for (int i = 2; i * i <= N; i++) {
            if (candidates.contains(i)) {
                for (int k = 2; k * i <= N; k++) {
                    candidates.remove(k * i);
                }
            }
        }

        return candidates.stream().mapToInt(Integer::intValue).toArray();
    }
}