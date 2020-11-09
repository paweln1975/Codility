package pl.paweln.codility.euclidean;

public class EuclideanSubtract extends AbstractEuclidean {


    protected int calcGreatestCommonDivisor (int a, int b) {
        if (a == b) {
            return a;
        } else if (a > b) {
            return calcGreatestCommonDivisor(a - b, b);
        } else {
            return calcGreatestCommonDivisor(a, b - a);
        }
    }
}
