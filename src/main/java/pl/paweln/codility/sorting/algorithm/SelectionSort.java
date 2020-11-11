package pl.paweln.codility.sorting.algorithm;

public class SelectionSort extends SortingAlgorithm {
    @Override
    public long sort(int[] tab) {
        return this.selectionSort(tab);
    }

    public long selectionSort(int[] tab) {
        int min, indexMin;
        long operationCount = 0;
        for (int i = 0; i < tab.length -1; i++) {
            indexMin = i;
            min = tab[indexMin];
            for (int j = indexMin + 1; j < tab.length; j++) {
                if (tab[j] < min) {
                    indexMin = j;
                    min = tab[indexMin];
                    operationCount++;
                }
            }
            if (indexMin != i) {
                int tmp = tab[i];
                tab[i] = tab[indexMin];
                tab[indexMin] = tmp;
                operationCount++;
            }
        }
        return operationCount;
    }

    public long selectionSortBackward(int[] tab) {
        int max, indexMax;
        long operationCount = 0;
        for (int i = tab.length - 1; i > 0; i--) {
            indexMax = i;
            max = tab[indexMax];
            for (int j = indexMax - 1; j >= 0; j--) {
                if (tab[j] > max) {
                    indexMax = j;
                    max = tab[indexMax];
                    operationCount++;
                }
            }
            if (indexMax != i) {
                int tmp = tab[i];
                tab[i] = tab[indexMax];
                tab[indexMax] = tmp;
                operationCount++;
            }
        }
        return operationCount;
    }
}
