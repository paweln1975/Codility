package pl.paweln.codility.sorting.algorithm;

public class HeapSort2 extends HeapSort {
    @Override
    public long sort(int[] tab) {
        int rozmiar = tab.length;
        int temp;
        long opCount = 0;

        // build heap
        for (int i= (rozmiar-1)/2; i >= 0; i--)
            opCount += heapify(tab, rozmiar - 1, i);

        // sort
        for (int i=rozmiar - 1; i >= 0; i--)
        {
            opCount++;
            temp=tab[i];
            tab[i]=tab[0];
            tab[0]=temp;
            rozmiar--;
            opCount += heapify(tab, rozmiar - 1,0);
        }

        return opCount;
    }

    private static int heapify (int[] tab, int heap_size, int i)
    {
        int opCount = 0;

        int largest, temp;
        int left =2*i + 1, right =(2*i)+2;

        if (left <= heap_size && tab[left] > tab[i])
            largest=left;
        else largest=i;
        if (right <= heap_size && tab[right] > tab[largest])
            largest=right;

        if (largest!=i)
        {
            opCount++;
            temp=tab[largest];
            tab[largest]=tab[i];
            tab[i]=temp;
            opCount += heapify(tab, heap_size, largest);
        }

        return opCount;
    }
}
