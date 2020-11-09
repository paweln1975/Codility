package pl.paweln.codility.euclidean;

public class EuclideanModulo extends AbstractEuclidean {
    @Override
    protected int calcGreatestCommonDivisor(int A, int B) {
        if (A % B ==0) {
            return B;
        } else {
            return calcGreatestCommonDivisor(B, A % B);
        }
    }
}
