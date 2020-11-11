package pl.paweln.codility.sorting.algorithm;

public class HeapSort extends SortingAlgorithm {
    @Override
    public long sort(int[] tab) {
        int operationCount = 0;
        // zbudowanie kopca
        for (int k = (tab.length + 1) / 2; k >= 0; k--)
            operationCount+= siftDown(tab[k], tab, k, tab.length - 1);

        // sortowanie
        for (int k = tab.length - 1; k > 0; k--) {
            int item = tab[k]; //pobieramy aktualnie ostatni element
            tab[k] = tab[0]; //przenosimy wierzchołek kopca do ostatniego elementu
            operationCount += siftDown(item, tab, 0, k-1); //odtwarzamy warunek kopca w zakresie od 1 do k–1
        }
        return operationCount;
    }

    private static int siftDown(int key, int[] num, int root, int last) {
        int opCount = 0;
        int bigger = 2 * root + 1;
        while (bigger <= last) { //dopóki jest co najmniej jedno dziecko
            if (bigger < last) //istnieje także prawe dziecko; znajdujemy większe
                if (num[bigger+1] > num[bigger]) bigger++; //'bigger' zawiera indeks większego dziecka
            if (key >= num[bigger]) break; //wartość key jest mniejsza; wybieramy num[bigger]
            opCount++;
            num[root] = num[bigger];
            root = bigger;
            bigger = 2 * root + 1;
        }
        num[root] = key;
        return opCount;
    } //koniec siftDown

    private static int heapSort2(int[] tab)
    {
        int rozmiar = tab.length;
        int temp;
        int opCount = 0;

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
