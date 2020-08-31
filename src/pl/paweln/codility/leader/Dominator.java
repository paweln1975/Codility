package pl.paweln.codility.leader;

import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.SolutionInputParams;

public class Dominator implements CodilitySolution {
    @Override
    public int[] solution(SolutionInputParams params) {
        int[] A = params.getFirstArray();

        if (A.length > 100000) {
            throw new IllegalArgumentException("Input array too big.");
        }
        return new int[] {this.solution(A)};
    }

    public int solution(int[] A) {
        return 2;
    }

    public int solutionNotOptimal1 (int[] A) {
        return -1;
    }

    public int solutionNotOptimal2 (int[] A) {
        return -1;
    }
}
