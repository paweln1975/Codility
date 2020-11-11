package pl.paweln.codility.sorting.algorithm;

public class BubbleSort extends SortingAlgorithm {
    @Override
    public long sort(int [] tab) {
        long operationCount = 0;
        boolean changed = true;

        while (changed) {
            changed = false;
            for (int i = 0; i < tab.length - 1; i++) {
                if (tab[i] > tab[i+1]) {
                    int tmp = tab[i];
                    tab[i] = tab[i+1];
                    tab[i+1] = tmp;
                    changed = true;
                    operationCount++;
                }
            }
        }
        return operationCount;
    }
}
