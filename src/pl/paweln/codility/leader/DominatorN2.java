package pl.paweln.codility.leader;

public class DominatorN2 extends Dominator {
    /**
     * quadratic computational complexity
     * count the occurrences of every element
     * @param A input array
     * @return index of the leader otherwise -1
     */
    @Override
    public int solution(int[] A) {
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
