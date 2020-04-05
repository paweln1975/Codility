package pl.paweln.codility.core;

import java.security.InvalidParameterException;

public class SolutionInputParams {
    private int n;
    private int[] firstArray;

    public int getN() {
        return this.n;
    }

    public int[] getFirstArray() { return this.firstArray; }

    private SolutionInputParams(SolutionInputParamsBuilder paramsBuilder) {
        if (!paramsBuilder.isInitialized) throw new InvalidParameterException("None of SolutionInputParams has been set.");
        this.n = paramsBuilder.getN();
        this.firstArray = paramsBuilder.getFirstArray();
    }

    public static class SolutionInputParamsBuilder {
        private int n = 0;
        private int[] firstArray = new int[] {};
        private boolean isInitialized = false;

        private int getN() {
            return n;
        }

        private int[] getFirstArray () {
            return this.firstArray;
        }

        private boolean isInitialized() {
            return this.isInitialized;
        }

        public SolutionInputParamsBuilder setN(int n) {
            this.n = n;
            this.isInitialized = true;
            return this;
        }

        public SolutionInputParamsBuilder setFirstArray(int[] pArray) {
            this.firstArray = pArray;
            this.isInitialized = true;
            return this;
        }

        public SolutionInputParams build() {
            return new SolutionInputParams(this);
        }
    }
}
