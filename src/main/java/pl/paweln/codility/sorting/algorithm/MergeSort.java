package pl.paweln.codility.sorting.algorithm;

public class MergeSort extends SortingAlgorithm {
    @Override
    public long sort(int[] tab) {
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
