package pl.paweln.codility.prime;

import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.SolutionInputParams;

public class Flags implements CodilitySolution {
    @Override
    public int[] solution(SolutionInputParams params) {
        int[] A = params.getFirstArray();

        return new int[] {this.solution(A)};
    }

    private int solution(int[] A) {
        return 0;
    }
}
