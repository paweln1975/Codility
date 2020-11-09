package pl.paweln.codility.euclidean;

public class EuclideanBinary extends AbstractEuclidean {

    @Override
    protected int calcGreatestCommonDivisor(int A, int B) {
        if (A == 0) return B;
        if (B == 0) return A;

        if ((A % 2 == 0) && (B % 2 == 0 )){
            return calcGreatestCommonDivisor(A >> 1, B >> 1) << 1;
        } else if (A % 2 == 0) {
            return calcGreatestCommonDivisor (A >> 1, B);
        } else if (B % 2 == 0) {
            return calcGreatestCommonDivisor (A, B >> 1);
        } else if (A >= B) {
            return calcGreatestCommonDivisor((A - B) >> 1, B);
        } else {
            return calcGreatestCommonDivisor(A, (B - A) >> 1);
        }
    }
}
