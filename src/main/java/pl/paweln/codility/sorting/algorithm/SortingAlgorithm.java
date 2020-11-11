package pl.paweln.codility.sorting.algorithm;

import pl.paweln.codility.core.AbstractCodility;
import pl.paweln.codility.core.SolutionInputParams;

import java.util.Arrays;

public abstract class SortingAlgorithm extends AbstractCodility {

    public SortingAlgorithm() {
        int[] tab = {5, 4, 3, 2, 1};
        this.defaultParams = paramsBuilder.setFirstArray(tab).build();
    }
    @Override
    public int[] solution(SolutionInputParams params) {
        int[] tab = params.getFirstArray();
        int[] copyTab = Arrays.copyOf(tab, tab.length);

        this.sort(copyTab);
        return copyTab;
    }

    public abstract long sort(int[] tab);

}
