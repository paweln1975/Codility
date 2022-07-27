package pl.paweln.codility.slice;

import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.SolutionInputParams;

public class MaxProfit implements CodilitySolution {
    @Override
    public int[] solution(SolutionInputParams params) {
        int[] A = params.getFirstArray();
        return new int[] {this.solution(A)};
    }


    private int solution(int[] A) {
        int max_ending = 0;
        int max_slice = 0;

        if (A.length < 1) {
            return 0;
        }

        int[] diff = new int[A.length-1];
        for (int i = 0; i < A.length - 1; i++) {
            diff[i] = A[i+1] - A[i];
        }

        for (int d : diff) {
            max_ending = Math.max(0, max_ending+d);
            max_slice = Math.max(max_slice, max_ending);
        }
        return max_slice;
    }

    private int altSolution(int[] A) {
        int bestEarnings = 0;

        int dayOfPurchase = 0;
        for (int currentDayIndex = 1; currentDayIndex < A.length - 1; ++currentDayIndex) {
            if (A[currentDayIndex] < A[dayOfPurchase]) {
                dayOfPurchase = currentDayIndex;
            }
            int dayOfSale = currentDayIndex + 1;
            int purchasePrice = A[dayOfPurchase];
            int salePrice = A[dayOfSale];
            int earnings = salePrice - purchasePrice;
            if (earnings > bestEarnings) {
                bestEarnings = earnings;
            }
        }
        return bestEarnings;
    }

    private int kadaneSolution(int[] A) {
        if(A.length == 1 || A.length == 0){
            return 0;
        }

        int maxSoFar = 0;
        int maxEndingHere;
        int minPrice = A[0];

        for(int i = 1; i < A.length; i++){
            maxEndingHere = Math.max(0, A[i] - minPrice);
            minPrice = Math.min(minPrice, A[i]);
            maxSoFar = Math.max(maxEndingHere, maxSoFar);
        }

        return maxSoFar;
    }

}
