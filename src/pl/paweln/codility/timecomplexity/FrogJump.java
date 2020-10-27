package pl.paweln.codility.timecomplexity;

import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.SolutionInputParams;

public class FrogJump implements CodilitySolution {
    @Override
    public int[] solution(SolutionInputParams params) {
        int X = params.getX();
        int Y = params.getY();
        int D = params.getD();
        if (X > Y) throw new IllegalArgumentException("X=" + X + " must be lower or equal to y=" + Y);

        return new int[] {this.solution(X, Y, D)};
    }

    private int solution (int X, int Y, int D) {

        if (X == Y) {
            return 0;
        } else {
            int diff = Y - X;
            int jumps = diff / D;
            if ((diff % D) > 0) jumps++;
            return jumps;
        }
    }


}
