package pl.paweln.codility.leader;

public class DominatorN2 extends Dominator {

    @Override
    protected int solution(int[] A) {
        int idx = -1;
        int halfSize = A.length/2;
        for (int i = 0; i < A.length; i++) {
            int count = 0;
            for (int value : A) {
                if (value == A[i]) {
                    count++;
                }
            }
            if (count > halfSize) {
                idx = i;
                break;
            }
        }
        return idx;
    }
}
