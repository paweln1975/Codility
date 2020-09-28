package pl.paweln.codility.slice;

import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.SolutionInputParams;

/**
 * Let’s define a problem relating to maximum slices. You are given a sequence of n integers
 * a0, a1, . . . , an−1 and the task is to find the slice with the largest sum. More precisely, we are
 * looking for two indices p, q such that the total ap + ap+1 + . . . + aq is maximal. We assume
 * that the slice can be empty and its sum equals 0.
 * For each position, we compute the largest sum that ends in that position. If we assume that the maximum sum of a slice
 * ending in position i equals max_ending, then the maximum slice ending in position i+1 equals max(0, max_ending+ ai+1).
 */
public class MaxSlice implements CodilitySolution {
    @Override
    public int[] solution(SolutionInputParams params) {
        int[] A = params.getFirstArray();
        return new int[] {this.solution(A)};
    }

    public int solution(int[] A) {
        int max_ending = 0;
        int max_slice = 0;
        for (int a : A) {
            max_ending = Math.max(0, max_ending+a);
            max_slice = Math.max(max_slice, max_ending);
        }
        return max_slice;
    }
}
