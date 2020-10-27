package pl.paweln.codility.counting;

import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.SolutionInputParams;

import java.util.Arrays;

public class MissingInteger implements CodilitySolution {

    @Override
    public int[] solution(SolutionInputParams params) {
        int[] tab = params.getFirstArray();

        if (tab.length == 0 || tab.length > 100000)
            throw new IllegalArgumentException("Array size must be within range 1 .. 100000.");

        return new int[] {this.solution(tab)};
    }

    private int solution(int[] A) {
        int prevValue = 0;

        Arrays.sort(A);

        for (int aA : A) {
            if (aA > 0) {
                if (aA - prevValue > 1) {
                    break;
                } else {
                    prevValue = aA;
                }
            }
        }


        return ++prevValue;
    }


}
