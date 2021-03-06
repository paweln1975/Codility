package pl.paweln.codility.prefixsums;

import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.SolutionInputParams;

public class GenomicRangeQuery implements CodilitySolution {
    @Override
    public int[] solution(SolutionInputParams params) {
        String S = params.getStringValue();
        int[] P = params.getFirstArray();
        int[] Q = params.getSecondArray();

        if (P.length != Q.length) {
            throw new IllegalArgumentException("Tables have different size.");
        }

        if (S.length() == 0 || S.length() > 100000) {
            throw new IllegalArgumentException("String length is incorrect.");
        }

        if (P.length == 0 || P.length > 50000) {
            throw new IllegalArgumentException("First table's length is incorrect.");
        }

        return this.solution(S, P, Q);
    }

    public int[] solution(String S, int[] P, int[] Q) {
        int[] result = new int [P.length];
        int dnaLength = S.length();
        int[] resultValues = new int[] {1, 2, 3, 4};

        // table is one element bigger to calculate correctly for the first element
        int[][] prefixSums = new int[S.length()+1][4]; // all set to 0 I believe

         // calculate prefix sum - how many time the letter exists up to current position
        for (int i = 0; i < dnaLength; i++) {
            if (S.charAt(i) == 'A') {
                prefixSums[i+1][0] = prefixSums[i][0] + 1;
                prefixSums[i+1][1] = prefixSums[i][1];
                prefixSums[i+1][2] = prefixSums[i][2];
                prefixSums[i+1][3] = prefixSums[i][3];
            } else if (S.charAt(i) == 'C') {
                prefixSums[i+1][1] = prefixSums[i][1] + 1;
                prefixSums[i+1][0] = prefixSums[i][0];
                prefixSums[i+1][2] = prefixSums[i][2];
                prefixSums[i+1][3] = prefixSums[i][3];
            } else if (S.charAt(i) == 'G') {
                prefixSums[i+1][2] = prefixSums[i][2] + 1;
                prefixSums[i+1][0] = prefixSums[i][0];
                prefixSums[i+1][1] = prefixSums[i][1];
                prefixSums[i+1][3] = prefixSums[i][3];
            } else if (S.charAt(i) == 'T') {
                prefixSums[i+1][3] = prefixSums[i][3] + 1;
                prefixSums[i+1][0] = prefixSums[i][0];
                prefixSums[i+1][1] = prefixSums[i][1];
                prefixSums[i+1][2] = prefixSums[i][2];
            } else {
                throw new IllegalArgumentException("DNA contains illegal character.");
            }
        }

        // for each range calculate how many time each letter occurs in the range
        for (int i = 0; i < P.length ; i++) {
            int beginIdx = P[i];
            int endIdx = Q[i] + 1;


            // check how many time each letter exists
            for (int j = 0; j < resultValues.length; j++) {
                int count = prefixSums[endIdx][j] - prefixSums[beginIdx][j];
                if (count > 0) {
                    result[i] = resultValues[j];
                    break;
                }
            }


        }
        return result;
    }



}
