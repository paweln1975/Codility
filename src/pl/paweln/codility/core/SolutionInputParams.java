package pl.paweln.codility.core;

import java.security.InvalidParameterException;

public class SolutionInputParams {
    private int n;
    private int k;
    private int x;
    private int a;
    private int b;
    private int[] firstArray;

    public int getN() {
        return this.n;
    }
    public int getK() { return this.k; }
    public int getX() { return this.x; }
    public int getA() {
        return this.a;
    }
    public int getB() { return this.b; }


    public int[] getFirstArray() { return this.firstArray; }

    private SolutionInputParams(SolutionInputParamsBuilder paramsBuilder) {
        if (!paramsBuilder.isInitialized)
            throw new InvalidParameterException("None of SolutionInputParams has been set.");
        this.n = paramsBuilder.getN();
        this.k = paramsBuilder.getK();
        this.x = paramsBuilder.getX();
        this.a = paramsBuilder.getA();
        this.b = paramsBuilder.getB();
        this.firstArray = paramsBuilder.getFirstArray();
    }

    public static class SolutionInputParamsBuilder {
        private int n = 0;
        private int k = 0;
        private int x = 0;
        private int a = 0;
        private int b = 0;
        private int[] firstArray = new int[] {};
        private boolean isInitialized = false;

        private int getN() {
            return n;
        }
        private int getK() {
            return k;
        }
        private int getX() {
            return x;
        }
        private int getA() {
            return a;
        }
        private int getB() {
            return b;
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

        public SolutionInputParamsBuilder setK(int k) {
            this.k = k;
            this.isInitialized = true;
            return this;
        }

        public SolutionInputParamsBuilder setX(int x) {
            this.x = x;
            this.isInitialized = true;
            return this;
        }

        public SolutionInputParamsBuilder setA(int a) {
            this.a = a;
            this.isInitialized = true;
            return this;
        }

        public SolutionInputParamsBuilder setB(int b) {
            this.b = b;
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
