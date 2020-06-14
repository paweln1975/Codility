package pl.paweln.codility.core;

import java.security.InvalidParameterException;

public class SolutionInputParams {
    private int n;
    private int k;
    private int x;
    private int y;
    private int d;
    private int a;
    private int b;
    private String s;
    private int[] firstArray;
    private int[] secondArray;

    public int getN() {
        return this.n;
    }
    public int getK() { return this.k; }
    public int getX() { return this.x; }
    public int getY() { return this.y; }
    public int getD() { return this.d; }
    public int getA() {
        return this.a;
    }
    public int getB() { return this.b; }
    public String getStringValue() { return this.s; }

    public int[] getFirstArray() { return this.firstArray; }
    public int[] getSecondArray() { return this.secondArray; }


    private SolutionInputParams(SolutionInputParamsBuilder paramsBuilder) {
        if (!paramsBuilder.isInitialized)
            throw new InvalidParameterException("None of SolutionInputParams has been set.");
        this.n = paramsBuilder.getN();
        this.k = paramsBuilder.getK();
        this.x = paramsBuilder.getX();
        this.y = paramsBuilder.getY();
        this.d = paramsBuilder.getD();
        this.a = paramsBuilder.getA();
        this.b = paramsBuilder.getB();
        this.s = paramsBuilder.getStringValue();
        this.firstArray = paramsBuilder.getFirstArray();
        this.secondArray = paramsBuilder.getSecondArray();
    }

    public static class SolutionInputParamsBuilder {
        private int n = 0;
        private int k = 0;
        private int x = 0;
        private int y = 0;
        private int d = 0;
        private int a = 0;
        private int b = 0;
        private String s = "";
        private int[] firstArray = new int[] {};
        private int[] secondArray = new int[] {};
        private boolean isInitialized = false;

        private int getN() {
            return n;
        }
        private int getK() {
            return k;
        }
        private int getY() {
            return y;
        }
        private int getD() {
            return d;
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
        private String getStringValue() { return s; }

        private int[] getFirstArray () {
            return this.firstArray;
        }
        private int[] getSecondArray () {
            return this.secondArray;
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

        public SolutionInputParamsBuilder setY(int y) {
            this.y = y;
            this.isInitialized = true;
            return this;
        }

        public SolutionInputParamsBuilder setD(int d) {
            this.d = d;
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

        public SolutionInputParamsBuilder setStringValue(String s) {
            this.s = s;
            this.isInitialized = true;
            return this;
        }

        public SolutionInputParamsBuilder setFirstArray(int[] pArray) {
            this.firstArray = pArray;
            this.isInitialized = true;
            return this;
        }

        public SolutionInputParamsBuilder setSecondArray(int[] pArray) {
            this.secondArray = pArray;
            this.isInitialized = true;
            return this;
        }

        public SolutionInputParams build() {
            return new SolutionInputParams(this);
        }
    }
}
