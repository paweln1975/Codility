package pl.paweln.codility.euclidean;

import pl.paweln.codility.core.AbstractCodility;
import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.SolutionInputParams;

public abstract class AbstractEuclidean extends AbstractCodility implements CodilitySolution {

    @Override
    public int[] solution(SolutionInputParams params) {
        int A = params.getA();
        int B = params.getB();

        if (A <= 0 || B <= 0) {
            throw new IllegalArgumentException("A and B must be positive, greater then 0.");
        }

        int division = (A > B ? A / B : B / A);
        if (division > 5000) {
            throw new IllegalArgumentException("Too many iterations expected");
        }

        return new int[] {this.solution(A, B)};
    }

    public int solution(int A, int B) {
        return this.calcGreatestCommonDivisor(A, B);
    }

    protected abstract int calcGreatestCommonDivisor(int A, int B);
}
