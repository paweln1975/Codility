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


    public static int selectionSort(int[] tab) {
        int min, indexMin;
        int operationCount = 0;
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

    public static int selectionSortBackward(int[] tab) {
        int max, indexMax;
        int operationCount = 0;
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


    public static int insertionSort(int[] tab) {
        int operationCount = 0;
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


    public static int countingSort(int[] tab) {
        int operationCount;
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


    public static int quickSort(int[] tab) {
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


    public static int heapSort(int[] tab) {
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

    public static int siftDown(int key, int[] num, int root, int last) {
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

    public static int heapSort2(int[] tab)
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


    public static int mergeSort(int[] tab)
    {
        return mergeSortRange(tab,0, tab.length - 1);
    }

    private static int mergeSortRange(int[] tab, int l, int r) {
        int opCount = 0;
        int DividePoint = dividePoint(l,r);

        if (r!=l){
            opCount++;

            mergeSortRange(tab, l, DividePoint);
            mergeSortRange(tab, DividePoint+1, r);

            //pointers used to refer to content of arrays
            int ptrA = l;
            int ptrB = DividePoint+1;

            int i = 0;
            int[] temptab = new int[r-l+1];

            //join two arrays into one sorted array
            while(ptrA<=DividePoint && ptrB<=r){
                opCount ++;
                if (compare(tab[ptrA], tab[ptrB])){
                    temptab[i++] = tab[ptrA++];
                }else{
                    temptab[i++] = tab[ptrB++];
                }
            }
            if (ptrA > dividePoint(l,r)) {         //if all elements of first array
                                                //were used add rest of second
                                                //array to the end of temporary array
                for (int j = ptrB; j<=r; j++){
                    temptab[i++] = tab[j];
                    opCount++;
                }
            } else {                              //opposite case
                for (int j = ptrA; j<=dividePoint(l,r); j++){
                    opCount++;
                    temptab[i++] = tab[j];
                }
            }
//copy results
            copy(tab, temptab, l,r);
            opCount+= (r-l);
        }
        return opCount;
    }

    private static int dividePoint(int l, int r){
    //calculates divide point of array
        int tabLength = r-l+1;
        if (tabLength%2 == 0){
            return l-1+(tabLength)/2;
        }else{
            return l+tabLength/2;
        }
    }

    private static boolean compare(int num1, int num2){
        return num1 <= num2;
    }

    private static void copy(int[] tab, int[] temptab, int l, int r){
//copies result from temporary array to original array
        int j=0;
        for (int i=l; i<=r; i++){
            tab[i] = temptab[j++];
        }
    }



}
