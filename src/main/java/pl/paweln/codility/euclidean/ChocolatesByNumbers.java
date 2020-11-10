package pl.paweln.codility.euclidean;

import pl.paweln.codility.core.AbstractCodility;
import pl.paweln.codility.core.SolutionInputParams;

import java.math.BigInteger;

public class ChocolatesByNumbers extends AbstractCodility {

    public ChocolatesByNumbers() {
        int N = 10;
        int D = 4;

        this.defaultParams = this.paramsBuilder
                .setN(N)
                .setD(D).build();
    }

    @Override
    public int[] solution(SolutionInputParams params) {
        final int max = 1000000000;
        int N = params.getN();
        int D = params.getD();

        if (N <= 0 || N > max) {
            throw new IllegalArgumentException("N is out of scope [1 .." + max + "]");
        }

        if (D <= 0 || D > max) {
            throw new IllegalArgumentException("D is out of scope [1 .." + max + "]");
        }

        return new int[] {this.solution(N, D)};
    }

    public int solution(int N, int D) {
        int gcd = calcGreatestCommonDivisor(N, D);

        BigInteger lcd = BigInteger.valueOf(N).multiply(BigInteger.valueOf(D)).divide(BigInteger.valueOf(gcd));

        return lcd.divide(BigInteger.valueOf(D)).intValue();

    }

    private int calcGreatestCommonDivisor(int A, int B) {
        if (A % B ==0) {
            return B;
        } else {
            return calcGreatestCommonDivisor(B, A % B);
        }
    }
}
