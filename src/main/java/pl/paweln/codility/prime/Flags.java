package pl.paweln.codility.prime;

import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.SolutionInputParams;

public class Flags implements CodilitySolution {
    @Override
    public int[] solution(SolutionInputParams params) {
        int[] A = params.getFirstArray();

        if (A.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty.");
        }

        if (A.length > 400000) {
            throw new IllegalArgumentException("Max array size is 400000. Array is too big N = " + A.length);
        }
        return new int[] {this.solution(A)};
    }

    private int solution(int[] A) {
        return this.bisectionMethod(A);
    }

    private int bisectionMethod (int[] A) {
        int a = 1;
        int b = (int) Math.sqrt(A.length) + 1;
        boolean[] peaks = this.createPeaks(A);
        int maxFlags = 0;

        while (a <= b) {
            int x = (a+b)/2;
            if (checkXFlags(x, peaks)) {
                a = x + 1;
                maxFlags = Math.max(maxFlags, x);
            } else {
                b = x - 1;
            }
        }

        return maxFlags;
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

    /**
     * the method checks if x flags could be set on given peaks
     * @param x possible x flags
     * @param peaks boolean table, true meas we have a peak
     * @return true if x flags could be set on the peaks, otherwise false
     */
    private boolean checkXFlags (int x, boolean[] peaks) {
        if (x == 0) {
            throw new IllegalArgumentException("You cannot check 0 flags.");
        }
        int flags = x;
        int pos = 0;
        int N = peaks.length;
        while (pos < N && flags > 0) {
            if (peaks[pos]) {
                flags--;
                pos += x;
            } else {
                pos++;
            }
        }
        return (flags == 0);
    }
}
