package pl.paweln.codility.arrays;

public class OddOccurrencesInArray {
    public int solution(int[] A) {
        int result = 0;
        for (int i = 0; i < A.length; i++) {
            result ^= A[i];
        }
        return result;
    }
}
