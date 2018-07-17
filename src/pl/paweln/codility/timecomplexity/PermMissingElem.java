package pl.paweln.codility.timecomplexity;

import java.math.BigInteger;
import java.util.Arrays;

public class PermMissingElem {
    public int solution (int [] A) {
        int N = A.length;
        if (N == 0) return 1;

        BigInteger sum = BigInteger.valueOf(0);

        for (int elem: A) {
            sum = sum.add(BigInteger.valueOf(elem));
        }

        BigInteger expectedSum = BigInteger.valueOf(2 + N).multiply(BigInteger.valueOf(1 + N)).divide(BigInteger.valueOf(2));

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

        long N = A.length + 1;
        long total = N * (N + 1) / 2;

        for (int i : A) {

            total -= i;
        }

        return (int)total;
    }
}
