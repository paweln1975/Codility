package pl.paweln.codility.arrays;

import pl.paweln.codility.core.AbstractCodility;
import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.SolutionInputParams;

import java.util.Arrays;

public class CyclicRotation extends AbstractCodility implements CodilitySolution {
    public CyclicRotation() {

        int[] tabA = { 3, 8, 9, 7, 6 };
        int k = 3;

        defaultParams = paramsBuilder
                .setFirstArray(tabA)
                .setK(k)
                .build();
    }


    @Override
    public int[] solution(SolutionInputParams params) {
        int[] tab = params.getFirstArray();
        int k = params.getK();

        if (k < 0 || k > 100) throw new IllegalArgumentException("K must be within the range 0 .. 100.");
        if (tab.length > 100) throw new IllegalArgumentException("Table too big. Max table size is 100.");
        return this.solution(tab, k);
    }

    private int[] solution(int[] A, int K) {
        int n = A.length;
        int offset;

        if (n == 0) return new int[0];

        int[] B = new int[n];

        if (n == K) {
            B = Arrays.copyOf(A, B.length);
            return B;
        }

        if (K > n) {
            offset = K % n;
        } else {
            offset = K;
        }


        for (int i = 0; i < n; i++) {
            B[getNewPos(i, offset, n)] = A[i];
        }

        return B;
    }

    private int getNewPos(int curr, int offset, int size) {
        if ((curr + offset) > (size - 1)) {
            return curr + offset - size;
        } else {
            return curr+offset;
        }
    }


}
