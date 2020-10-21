package pl.paweln.codility.prime;

import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.SolutionInputParams;

public class Peaks implements CodilitySolution {
    @Override
    public int[] solution(SolutionInputParams params) {
        int[] A = params.getFirstArray();

        if (A.length == 0) throw new IllegalArgumentException("Array cannot be empty.");

        if (A.length > 100000) throw new IllegalArgumentException("Max array size is 100000. Array too big N = " + A.length);

        return new int[] {this.solution(A)};
    }

    private int solution (int[] A) {
        boolean[] peaks = createPeaks(A);
        int maxNumberOfBlocks = 0;
        int tmpNumberOfBlocks;
        boolean blockSatisfiesCondition = false;

        for (int size = 2; size <= A.length; size++) {
            if (A.length % size != 0) continue;

            tmpNumberOfBlocks = A.length / size;

            int leftIndex = 0;
            int rightIndex = size - 1;
            for (int i = 1; i <= tmpNumberOfBlocks; i++) {
                blockSatisfiesCondition = checkBlockHasPeaks(peaks, leftIndex, rightIndex);
                leftIndex = rightIndex + 1;
                rightIndex = rightIndex + size;

                if (!blockSatisfiesCondition) {
                    break;
                }
            }

            if (blockSatisfiesCondition) {
                maxNumberOfBlocks = tmpNumberOfBlocks;
                break;
            }

        }

        return maxNumberOfBlocks;
    }

    private boolean[] createPeaks (int[] A) {
        boolean[] peaks = new boolean[A.length];
        peaks[0] = false;
        for (int i = 1; i < A.length - 1; i++) {
            // check peak condition - neighbors are lower
            if (A[i-1] < A[i] && A[i+1] < A[i]) {
                peaks[i] = true;
            }
        }
        peaks[A.length-1] = false;
        return peaks;
    }

    private boolean checkBlockHasPeaks(boolean[] peaks, int leftIndex, int rightIndex) {
        if (leftIndex < 0 || rightIndex < 0) throw new IllegalArgumentException("Index below 0.");
        if (leftIndex >= peaks.length || rightIndex >= peaks.length) throw new IllegalArgumentException("Index too high.");

        boolean foundPeak = false;
        for (int i = leftIndex; i <= rightIndex ; i++) {
            if (peaks[i]) {
                foundPeak = true;
                break;
            }
        }
        return foundPeak;
    }
}
