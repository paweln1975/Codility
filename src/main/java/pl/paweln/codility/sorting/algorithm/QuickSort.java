package pl.paweln.codility.sorting.algorithm;

public class QuickSort extends SortingAlgorithm {
    @Override
    public long sort(int[] tab) {
        int operationCount;
        operationCount = qs(tab, 0, tab.length-1);
        return operationCount;
    }

    private static int qs(int[] items, int left, int right) {
        int opCount = 0;
        int i, j;
        int x, y;
        i = left; j = right;
        x = items[(left+right)/2];
        do {
            while((items[i] < x) && (i < right)) i++;
            while((x < items[j]) && (j > left)) j--;
            if(i <= j) {
                opCount++;
                y = items[i];
                items[i] = items[j];
                items[j] = y;
                i++; j--;
            }
        } while(i <= j);
        if (left < j)
            opCount += qs(items, left, j);
        if (i < right)
            opCount += qs(items, i, right);
        return opCount;
    }
}
