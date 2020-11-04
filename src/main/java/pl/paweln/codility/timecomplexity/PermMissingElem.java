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
            throw new IllegalArgumentException("Array to big. Max array size is 100 000.");
        }
        return new int[] {this.solution(A)};
    }

    public int solution (int [] A) {
        int N = A.length;
        if (N == 0) return 1;

        BigInteger sum = BigInteger.valueOf(0);

        for (int elem: A) {
            sum = sum.add(BigInteger.valueOf(elem));
        }

        BigInteger expectedSum = BigInteger.valueOf(2L + N).multiply(BigInteger.valueOf(1L + N)).divide(BigInteger.valueOf(2));

        return expectedSum.subtract(sum).intValue();
    }
}
