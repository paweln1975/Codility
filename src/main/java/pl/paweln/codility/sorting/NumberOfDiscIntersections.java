package pl.paweln.codility.sorting;

import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.SolutionInputParams;

import java.util.Arrays;

/*
We draw N discs on a plane. The discs are numbered from 0 to N − 1. An array A of N non-negative integers, specifying
the radiuses of the discs, is given. The J-th disc is drawn with its center at (J, 0) and radius A[J].

We say that the J-th disc and K-th disc intersect if J ≠ K and the J-th and K-th discs have at least one common point
(assuming that the discs contain their borders).

The figure below shows discs drawn for N = 6 and A as follows:

  A[0] = 1
  A[1] = 5
  A[2] = 2
  A[3] = 1
  A[4] = 4
  A[5] = 0

  There are eleven (unordered) pairs of discs that intersect, namely:

discs 1 and 4 intersect, and both intersect with all the other discs;
disc 2 also intersects with discs 0 and 3.
Write a function:

class Solution { public int solution(int[] A); }

that, given an array A describing N discs as explained above, returns the number of (unordered) pairs of
 intersecting discs. The function should return −1 if the number of intersecting pairs exceeds 10,000,000.

Given array A shown above, the function should return 11, as explained above.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [0..100,000];
each element of array A is an integer within the range [0..2,147,483,647].

 */
public class NumberOfDiscIntersections implements CodilitySolution {
    private final static int MAX_INTERSECTIONS = 10000000;

    @Override
    public int[] solution(SolutionInputParams params) {
        int[] A = params.getFirstArray();

        return new int[] {this.solution(A)};
    }


    public int solution(int[] A) {
        CircleEnd[] circleEnds = new CircleEnd[2* A.length];
        for (int i = 0; i < A.length; i++) {
            // create start circle position

            circleEnds[i] = new CircleEnd((long)i - (long)A[i], 1);

            // create end circle position
            circleEnds[i+A.length] = new CircleEnd((long)i + (long)A[i], -1);
        }

        // sort circle positions together
        Arrays.sort(circleEnds);

        int depth = 0;
        int intersections = 0;

        for (CircleEnd circleEnd : circleEnds ) {
            if (circleEnd.start == 1) {
                intersections += depth;
                if (intersections > MAX_INTERSECTIONS) {
                    return -1;
                }
            }
            depth += circleEnd.start;
        }
        return intersections;
    }



}

class CircleEnd implements Comparable<CircleEnd> {
    protected final long position;
    protected final long start;
    CircleEnd (long position, long start) {
        this.position = position;
        this.start = start;
    }

    @Override
    public int compareTo(CircleEnd o) {
        if (this.position < o.position) {
            return -1;
        } else if (this.position == o.position && this.start > o.start) {
            return -1;
        } else if (this.position == o.position && this.start == o.start) {
            return 0;
        }
        return 1;
    }
}
