package pl.paweln.codility.arrays;

public class CyclicRotation {
    public int[] solution(int[] A, int K) {
        // table length
        int N = A.length;
        int offset;

        if (N == 0 || N == K) return A;

        if (K > N) {
            offset = K % N;
        } else {
            offset = K;
        }

        int[] B = new int[N];

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
