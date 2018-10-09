package pl.paweln.codility.core;

public interface CodilitySolution<T> {
    int solution (int N);
    T solution (int[] A, int N);
    int solution (int[] A);
    int solution (int X, int Y, int Z);
    int[] solution (String S, int[] P, int[] Q);
}
