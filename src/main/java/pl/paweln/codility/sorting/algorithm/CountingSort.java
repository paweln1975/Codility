package pl.paweln.codility.sorting.algorithm;

public class CountingSort extends SortingAlgorithm {
    @Override
    public long sort(int[] tab) {
        long operationCount;
        int size = 0;

        // find max value
        for (int j : tab) {
            if (j < 0) {
                throw new IllegalArgumentException("Cannot sort negative element with counting sort.");
            }
            if (j > size) {
                size = j;
            }
        }

        size++;

        // count how many times a value exists in the source table
        int[] countTab = new int[size];
        for (int j : tab) {
            countTab[j]++;
        }

        operationCount = 2*size;

        int c = 0;
        // generate output tab
        for (int i = 0; i < countTab.length; i++) {
            if (countTab[i] > 0) {
                for (int k=0; k < countTab[i]; k++) {
                    tab[c]=i;
                    c++;
                    operationCount++;
                }
            }
        }
        return  operationCount;
    }
}
