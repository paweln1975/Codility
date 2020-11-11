package pl.paweln.codility.arrays;

import pl.paweln.codility.core.AbstractCodility;
import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.SolutionInputParams;

public class OddOccurrencesInArray extends AbstractCodility implements CodilitySolution {

    public OddOccurrencesInArray() {
        int[] tabA = {9, 3, 9, 3, 9, 7, 9};
        this.defaultParams =this.paramsBuilder
            .setFirstArray(tabA).build();
    }

    @Override
    public int[] solution(SolutionInputParams params) {
        int[] arr = params.getFirstArray();

        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty");
        }

        if (arr.length > 1000000) {
            throw new IllegalArgumentException("Array size to big");
        }
        if (arr.length % 2 == 0) {
            throw new IllegalArgumentException("Array size must be odd value");
        }

        return new int[] {this.solution(arr)};


    }

    private int solution(int[] A) {
        int result = 0;

        // XOR operator A xor A = 0, B xor 0 = B, therefore A xor B xor C xor A xor B = C
        for (int aA : A) {
            result ^= aA;
        }
        return result;
    }


}
