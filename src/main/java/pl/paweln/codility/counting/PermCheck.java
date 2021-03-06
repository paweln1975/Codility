package pl.paweln.codility.counting;

import pl.paweln.codility.core.AbstractCodility;
import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.SolutionInputParams;

import java.util.HashSet;
import java.util.Set;

public class PermCheck extends AbstractCodility {

    public PermCheck() {
        int[] testArr = new int[] {4, 1, 2, 3};

        this.defaultParams = this.paramsBuilder
                .setFirstArray(testArr).build();
    }

    @Override
    public int[] solution(SolutionInputParams params) {
        int[] tab = params.getFirstArray();

        if (tab.length == 0 || tab.length > 100000)
            throw new IllegalArgumentException("Array size must be within range 1 .. 100000.");

        return new int[] {solution(tab)};
    }

    public int solution(int[] A) {

        if (A.length == 0) return 0;

        Set<Integer> missingPermValues = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            missingPermValues.add(i+1);
        }

        for (int aA : A) {
            missingPermValues.remove(aA);
        }

        return missingPermValues.size() == 0 ? 1 : 0;
    }



}
