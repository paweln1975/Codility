package pl.paweln.codility.sorting;

public class MaxProductOfThree2 extends MaxProductOfThree {

    // solution from internet - nice one as well with three maxes and 2 minis
    @Override
    public int solution(int[] A) {

        int[] max_values = {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
        // Invariant: max_values[0] <= max_values[1] <= max_values[2]

        int[] min_values = {Integer.MAX_VALUE, Integer.MAX_VALUE};
        // Invariant: min_values[0] <= min_values[1]

        // O(n)
        for( int a : A )
        {
            updateMaxValues( a, max_values );
            updateMinValues( a, min_values );
        }

        int obvious = max_values[0] * max_values[1] * max_values[2];
        int twoBigNegs = min_values[0] * min_values[1] * max_values[2];
        return Math.max( obvious, twoBigNegs );
    }

    private static void updateMaxValues(int a, int[] pMaxValues )
    {
        if( a >= pMaxValues[2] ) {
            // Found new max, shift down
            pMaxValues[0] = pMaxValues[1];
            pMaxValues[1] = pMaxValues[2];
            pMaxValues[2] = a;
        } else if( a >= pMaxValues[1] ) {
            pMaxValues[0] = pMaxValues[1];
            pMaxValues[1] = a;
        } else if( a > pMaxValues[0] ) {
            pMaxValues[0] = a;
        }
    }

    private static void updateMinValues(int a, int[] pMinValues )
    {
        if( a <= pMinValues[0] ) {
            // Found new min, shift down
            pMinValues[1] = pMinValues[0];
            pMinValues[0] = a;
        } else if( a < pMinValues[1] ) {
            pMinValues[1] = a;
        }
    }
}
