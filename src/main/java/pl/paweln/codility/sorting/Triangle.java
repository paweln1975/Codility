package pl.paweln.codility.sorting;

import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.SolutionInputParams;

import java.math.BigInteger;
import java.util.Arrays;


public class Triangle implements CodilitySolution {
    @Override
    public int[] solution(SolutionInputParams params) {
        int[] A = params.getFirstArray();
        int N = A.length;
        if (N > 100000) {
            throw new IllegalArgumentException("Array to big.");
        }
        return new int[] {this.solution(A)};
    }

    private int solution(int[] A) {
        if (A.length < 3) {
            return 0;
        }

        Arrays.sort(A);
        for (int i = A.length-1; i >= 2; i--)
        {
            if (A[i] <= 0) {
                continue;
            }

            int l = 0; // index of the first element in A[0..i-1]
            int r = i-1; // index of the last element in A[0..i-1]
            while (l < r)
            {
                // A triplet found
                if (isTriplet(A[l], A[r], A[i]))
                    return 1;

                //if (A[l] + A[r] <= A[i])
                if (BigInteger.valueOf(A[l]).add(BigInteger.valueOf(A[r])).compareTo(BigInteger.valueOf(A[i])) <= 0)
                    l++;
                else
                    r--;
            }
        }

        return 0;
    }

    private boolean isTriplet(int x, int y, int z) {
        BigInteger X = BigInteger.valueOf(x);
        BigInteger Y = BigInteger.valueOf(y);
        BigInteger Z = BigInteger.valueOf(z);

        return X.add(Y).compareTo(Z) > 0 &&
                X.add(Z).compareTo(Y) > 0 &&
                Z.add(Y).compareTo(X) > 0;

    }


}
