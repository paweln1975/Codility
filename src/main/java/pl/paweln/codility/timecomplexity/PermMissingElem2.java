package pl.paweln.codility.timecomplexity;

import java.util.Arrays;

public class PermMissingElem2 extends PermMissingElem {
    @Override
    public int solution(int[] A) {
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
}
