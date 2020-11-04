package pl.paweln.codility.timecomplexity;

public class PermMissingElem3 extends PermMissingElem {
    @Override
    public int solution(int[] A) {

        long N = 1L + A.length;
        long total = N * (N + 1L) / 2L;

        for (int i : A) {

            total -= i;
        }

        return (int)total;
    }
}
