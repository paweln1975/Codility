package pl.paweln.codility.prefixsums;

import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.SolutionInputParams;

public class MinAvgTwoSlice implements CodilitySolution {

    @Override
    public int[] solution(SolutionInputParams params) {
        int[] A = params.getFirstArray();

        if (A.length < 2) {
            throw new IllegalArgumentException("Array too small. Minimum 2 elements are required.");
        }

        if (A.length > 100000) {
            throw new IllegalArgumentException("Array too big. Max size is 100 000.");
        }


        return new int[] {this.solution(A)};
    }

    public int solution(int[] A) {


        int idxOfMinSliceAvg = 0;
        float minSliceAvg = 0;

        int[] prefixSums = new int [A.length + 1];
        for (int i = 1; i <= A.length; i++) {
            prefixSums[i] = prefixSums[i-1] + A[i-1];
        }

        for (int sliceLength = 2; sliceLength <= 3; sliceLength++) {
            if (A.length == 2 && sliceLength == 3) {
                continue;
            }
            for (int i = 1; i < prefixSums.length - sliceLength + 1; i++) {
                if (i == 1 && sliceLength == 2) {
                    minSliceAvg = this.calculateSliceAvg(prefixSums, i, i + sliceLength - 1);
                    idxOfMinSliceAvg = 0;
                } else {
                    float tmpSliceAvg = this.calculateSliceAvg(prefixSums, i, i + sliceLength - 1);
                    if (tmpSliceAvg < minSliceAvg) {
                        minSliceAvg = tmpSliceAvg;
                        idxOfMinSliceAvg = i - 1;
                    }

                }
            }
        }

        return idxOfMinSliceAvg;
    }

    private float calculateSliceAvg (int[]T, int startIdx, int endIdx) {
        if (endIdx <= startIdx) {
            throw new IllegalArgumentException("Wrong index values.");
        }
        float sum = (float)T[endIdx] - (float)T[startIdx-1];
        float count = (float)endIdx - (float)startIdx + 1f;
        return sum / count;
    }



}
