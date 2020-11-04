package pl.paweln.codility.sorting;

public class SortingAlgorithms {
    /**
     * Sprawdzamy całą tablicę od końca, jeżeli trafimy na parę elementów, w której większy poprzedza mniejszy to
     * zamieniamy je miejscami. Po przejściu całej tablicy znów zaczynamy przeszukiwać tą tablicę od końca. Czynność
     * powtarzamy tak długo aż podczas sprawdzania całej tablicy, nie zajdzie ani jedna zamiana elementów. Realizuje
     * się to najczęściej za pomocą zmiennej logicznej.
     * Algorytm nosi nazwę bąbelkowego, gdyż najmniejsze liczby "wypływają" z dołu tablicy na jej szczyt, podobnie
     * jak bąbelki powietrza w wodzie.
     */

    public static int bubbleSort(int [] tab) {
        int operationCount = 0;
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

    /**
     * Metoda ta nazywana jest sortowaniem przez wymianę gdyż na początku szukany jest najmniejszy element, po
     * znalezieniu go jest on zamieniany z pierwszym elementem tablicy. Następnie szukany jest znów najmniejszy element,
     * ale począwszy od elementu drugiego (pierwszy - najmniejszy jest już wstawiony na odpowiednie miejsce), po jego
     * znalezieniu jest on zamieniany z drugim elementem. Czynność tą powtarzamy kolejno na elementach od trzeciego,
     * czwartego, aż do n-tego.
     */
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

    /**
     * Zasada działania tego algorytmu jest często porównywana do porządkowania kart w wachlarz podczas gry. Każdą kartę
     * wstawiamy w odpowiednie miejsce, tzn. po młodszej, ale przed starszą. Podobnie jest z liczbami.
     * Pierwszy element pozostaje na swoim miejscu. Następnie bierzemy drugi i sprawdzamy, w jakiej relacji jest on
     * z pierwszym. Jeśli jest niemniejszy, to zostaje na drugim miejscu, w przeciwnym wypadku wędruje na pierwsze
     * miejsce. Dalej sprawdzamy trzeci element (porównujemy go do dwóch pierwszych i wstawiamy w odpowiednie miejsce),
     * czwarty (porównujemy z trzema pierwszymi), piąty itd. Idea działania algorytmu opiera się na podziale ciągu na
     * dwie części: pierwsza jest posortowana, druga jeszcze nie. Wybieramy kolejną liczbę z drugiej części i wstawiamy
     * ją do pierwszej. Ponieważ jest ona posortowana, to szukamy dla naszej liczby takiego miejsca, aby liczba na lewo
     * była niewiększa a liczba na prawo niemniejsza. Wstawienie liczby do posortowanej tablicy wymaga więc czasu O(n).
     * Wynika z tego złożoność algorytmy: O(n2)

     */
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

    /**
     * Sortowanie przez zliczanie ma jedną potężną zaletę i jedną równie potężną wadę:
     * Zaleta: działa w czasie liniowym (jest szybki)
     * Wada: może sortować wyłącznie liczby całkowite
     * Obydwie te cechy wynikają ze sposobu sortowania. Polega ono na liczeniu, ile razy dana liczba występuje w ciągu,
     * który mamy posortować. Następnie wystarczy utworzyć nowy ciąg, korzystając z danych zebranych wcześniej. Np.
     * mamy posortować ciąg: 3,6,3,2,7,1,7,1. Po zliczeniu (w jednym korku) operujemy danymi na temat liczności
     * poszczególnych liczb. Na podstawie tych danych tworzymy ciąg: 1,1,2,3,3,6,7,7. Jest to ciąg wejściowy, ale
     * posortowany. Należy zauważyć trzy ważne rzeczy:
     * 1. Proces zliczania odbył się w jednym kroku
     * 2. Nie doszło do ani jednej zamiany elementów
     * 3. Proces tworzenia tablicy wynikowej odbył się w jednym kroku
     * Algorytm ten posiada jednak również dodatkową wadę: do przechowywania liczby wyrazów ciągu musimy użyć tablicy,
     * o liczbie elementów równej największemu elementowi ciągu.

     */
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

    /**
     * Algorytm Quicksort bazuje na idei podziału. Ogólna procedura polega na wybraniu pewnej wartości, a następnie
     * podziale tablicy na dwie części. W jednej umieszczamy elementy, których wartość jest równa bądź większa od
     * wybranej wartości, a w drugiej te, których wartość jest mniejsza. Proces ten powtarzamy dla każdej części
     * tablicy, aż uzyskamy całkowicie posortowaną tablicę. Na przykład dla tablicy fedacb możemy wybrać wartość d,
     * wtedy wynikiem pierwszego przebiegu algorytmu Quicksort będzie tablica bcadef. Następnie powtarzamy proces dla
     * każdej części tabeli, czyli dla bca i def. Jak łatwo zauważyć, proces ten jest z natury rekurencyjny i
     * rzeczywiście najlepsza jego implementacja wykorzystuje rekurencję.
     * Wartość, z którą porównujemy pozostałe elementy tablicy, możemy wybrać na dwa sposoby. Albo w sposób losowy,
     * albo jako średnią z pewnego podzbioru wartości tablicy. Optymalne działanie algorytmu wymaga wybrania wartości
     * znajdującej się dokładnie pośrodku zakresu. Jednak dokonanie takiego wyboru nie jest łatwe dla większości
     * sortowanych zbiorów danych. W najgorszym przypadku musimy liczyć się z wyborem wartości będącej ekstremum
     * sortowanego zbioru. Jednak nawet w takim przypadku algorytm Quicksort nadal działa poprawnie.
     *
     */
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

    /**
     * Sortowanie stogowe - poprzez kopcowanie
     * Drzewo binarne jest hierarchiczną strukturą danych, której elementy będziemy nazywali węzłami (ang. node).
     * W drzewie binarnym każdy węzeł może posiadać dwa następniki (stąd pochodzi nazwa drzewa - binarny = dwójkowy,
     * zawierający dwa elementy), które nazwiemy potomkami, dziećmi lub węzłami potomnymi danego węzła (ang. child node).
     * Jeśli chcemy przetwarzać za pomocą komputera struktury drzew binarnych, to musimy zastanowić się nad sposobem
     * reprezentacji takich struktur w pamięci. Najprostszym rozwiązaniem jest zastosowanie zwykłej tablicy n
     * elementowej. Każdy element tej tablicy będzie reprezentował jeden węzeł drzewa binarnego. Pozostaje nam jedynie
     * określenie związku pomiędzy indeksami elementów w tablicy a położeniem tych elementów w strukturze drzewa
     * binarnego.
     * węzeł nadrzędny ma indeks równy (k - 1) / 2 (dzielenie całkowitoliczbowe)
     * k - węzeł bieżący
     * 2k+1- lewy potomek
     * 2k+2 - prawy potomek
     * Kopiec jest drzewem binarnym, w którym wszystkie węzły spełniają następujący warunek (zwany warunkiem kopca):
     * Węzeł nadrzędny jest większy lub równy węzłom potomnym
     *
     * https://eduinf.waw.pl/inf/utils/010_2010/0411.php

     */
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

    /**
     * Sortowanie przez scalanie (podobnie jak algorytm QuickSort, jest algorytmem typu "dziel i zwyciężaj". Jednak
     * w odróżnieniu od QuickSort, algorytm ten w każdym przypadku osiąga złozoność T(n) = n*log(n). Niestety algorytm
     * MergeSort posiada większą złożoność pamięciową, potrzebuje do swojego działania dodatkowej, pomocniczej struktury
     * danych.
     * Ideą działania algorytmu jest dzielenie zbioru danych na mniejsze zbiory, aż do uzyskania n zbiorów jedno-
     * elementowych, które same z siebie są posortowane :), następnie zbiory te są łączone w coraz większe zbiory
     * posortowane, aż do uzyskania jednego, posortowanego zbioru n-elementowego. Etap dzielenia nie jest skomplikowany,
     * dzielenie następuje bez sprawdzania jakichkolwiek warunków. Dzięki temu, w przeciwieństwie do algorytmu QuickSort,
     * następuje pełne rozwinięcie wszystkich gałęzi drzewa. Z kolei łączenie zbiorów posortowanych wymaga odpowiedniego
     * wybierania poszczególnych elementów z łączonych zbiorów z uwzględnieniem faktu, że wielkość zbioru nie musi być
     * równa (parzysta i nieparzysta ilość elementów), oraz tego, iż wybieranie elementów z poszczególnych zbiorów nie
     * musi następować naprzemiennie, przez co jeden zbiór może osiągąć swój koniec wcześniej niż drugi. Robi sie to w
     * następujący sposób. Kopiujemy zawartość zbioru głównego do struktury pomocniczej. Następnie, operując wyłącznie
     * na kopii, ustawiamy wskaźniki na początki kolejnych zbiorów i porównujemy wskazywane wartości. Mniejszą wartość
     * wpisujemy do zbioru głównego i przesuwamy odpowiedni wskaźnik o 1 i czynności powtarzamy, aż do momentu, gdy
     * jeden ze wskaźników osiągnie koniec zbioru. Wówczam mamy do rozpatrzenia dwa przypadki, gdy zbiór 1 osiągnął
     * koniec i gdy zbiór 2 osiągnął koniec. W przypadku pierwszym nie będzie problemu, elementy w zbiorze głównym są
     * już posortowane i ułożone na właściwych miejscach. W przypadku drugim trzeba skopiować pozostałe elementy zbioru
     * pierwszego pokolei na koniec. Po zakończeniu wszystkich operacji otrzmujemy posortowany zbiór główny.
     */
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
