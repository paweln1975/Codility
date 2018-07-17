package pl.paweln.codility.timecomplexity;

public class FrogJump {
    public int solution (int X, int Y, int D) {
        if (X > Y) throw new IllegalArgumentException("X=" + X + " must be lower or equal to y=" + Y);
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
