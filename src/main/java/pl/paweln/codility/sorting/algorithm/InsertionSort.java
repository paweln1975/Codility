package pl.paweln.codility.sorting.algorithm;

public class InsertionSort extends SortingAlgorithm {
    @Override
    public long sort(int[] tab) {
        long operationCount = 0;
        int j, currentElem;
        // begining from second element
        for (int i = 1; i < tab.length; i++) {
            j = i;
            currentElem = tab[i];
            while (j > 0 && tab[j - 1] > currentElem) {
                tab[j] = tab[j - 1];
                j--;
                operationCount++;
            }
            tab[j] = currentElem;
        }
        return operationCount;
    }
}
