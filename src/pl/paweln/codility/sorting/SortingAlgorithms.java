package pl.paweln.codility.sorting;

public class SortingAlgorithms {
    /**
     * Sprawdzamy całą tablicę od końca, jeżeli trafimy na parę elementów, w której większy poprzedza mniejszy to
     * zamieniamy je miejscami. Po przejściu całej tablicy znów zaczynamy przeszukiwać tą tablicę od końca. Czynność
     * powtarzamy tak długo aż podczas sprawdzania całej tablicy, nie zajdzie ani jedna zamiana elementów. Realizuje
     * się to najczęściej za pomocą zmiennej logicznej.
     * Algorytm nosi nazwę bąbelkowego, gdyż najmniejsze liczby "wypływają" z dołu tablicy na jej szczyt, podobnie
     * jak bąbelki powietrza w wodzie.
     * @param tab
     * @return
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
     * @param tab
     * @return
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
     * @param tab
     * @return
     */
    public static int insertionSort(int[] tab) {
        int operationCount = 0;
        int j, currentElem;
        // beggining from second element
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
     * @param tab
     * @return
     */
    public static int countingSort(int[] tab) {
        int operationCount = 0;
        int size = 0;

        // find max value
        for (int i = 0; i < tab.length; i++) {
            if (tab[i] < 0) {
                throw new IllegalArgumentException("Cannot sort negative element with counting sort.");
            }
            if (tab[i] > size) {
                size = tab[i];
            }
        }

        size++;

        // count how many times a value exists in the source table
        int[] countTab = new int[size];
        for (int i = 0; i < tab.length; i++) {
            countTab[tab[i]]++;
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
     * @param tab
     * @return
     */
    public static int quickSort(int[] tab) {
        int operationCount = 0;
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
