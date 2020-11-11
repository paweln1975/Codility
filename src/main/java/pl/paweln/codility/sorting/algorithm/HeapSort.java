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


}
