package pl.paweln.codility.arrays;

import pl.paweln.codility.core.AbstractCodility;
import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.SolutionInputParams;

import java.util.Arrays;

public class CyclicRotation extends AbstractCodility implements CodilitySolution {
    public CyclicRotation() {

        int[] A = { 3, 8, 9, 7, 6 };
        int K = 3;

        defaultParams = paramsBuilder
                .setFirstArray(A)
                .setK(K)
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
        int N = A.length;
        int offset;

        if (N == 0) return new int[0];

        int[] B = new int[N];

        if (N == K) {
            B = Arrays.copyOf(A, B.length);
            return B;
        }

        if (K > N) {
            offset = K % N;
        } else {
            offset = K;
        }


        for (int i = 0; i < N; i++) {
            B[getNewPos(i, offset, N)] = A[i];
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
