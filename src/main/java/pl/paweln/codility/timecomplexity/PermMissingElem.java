package pl.paweln.codility.timecomplexity;

import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.SolutionInputParams;

import java.math.BigInteger;
import java.util.Arrays;

public class PermMissingElem implements CodilitySolution {
    @Override
    public int[] solution(SolutionInputParams params) {
        int[] A = params.getFirstArray();
        int N = A.length;
        if (N > 100000) {
            throw new IllegalArgumentException("Array to big.");
        }
        return new int[] {this.solution(A)};
    }

    private int solution (int [] A) {
        int N = A.length;
        if (N == 0) return 1;

        BigInteger sum = BigInteger.valueOf(0);

        for (int elem: A) {
            sum = sum.add(BigInteger.valueOf(elem));
        }

        BigInteger expectedSum = BigInteger.valueOf(2L + N).multiply(BigInteger.valueOf(1L + N)).divide(BigInteger.valueOf(2));

        return expectedSum.subtract(sum).intValue();
    }


    public int solution2(int[] A) {
        int previous = 0;
        if (A.length != 0) {
            Arrays.sort(A);
            for (int i : A) {
                if (++previous != i) {
                    return previous;
                }
            }
        }
        return ++previous;
    }

    public int solution3(int[] A) {

        long N = 1L + A.length;
        long total = N * (N + 1L) / 2L;

        for (int i : A) {

            total -= i;
        }

        return (int)total;
    }


}
