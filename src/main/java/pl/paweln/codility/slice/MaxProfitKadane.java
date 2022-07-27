package pl.paweln.codility.slice;

public class MaxProfitKadane extends MaxProfit {
    @Override
    protected int solution(int[] tab) {
        if (tab.length == 1 || tab.length == 0){
            return 0;
        }

        int maxSoFar = 0;
        int maxEndingHere;
        int minPrice = tab[0];

        for(int i = 1; i < tab.length; i++){
            maxEndingHere = Math.max(0, tab[i] - minPrice);
            minPrice = Math.min(minPrice, tab[i]);
            maxSoFar = Math.max(maxEndingHere, maxSoFar);
        }

        return maxSoFar;
    }
}
