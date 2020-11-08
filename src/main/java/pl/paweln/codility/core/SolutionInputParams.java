package pl.paweln.codility.core;

import java.security.InvalidParameterException;
import java.util.Arrays;

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

    private boolean isNinitialized;
    private boolean isKinitialized;
    private boolean isXinitialized;
    private boolean isYinitialized;
    private boolean isAinitialized;
    private boolean isBinitialized;
    private boolean isSinitialized;
    private boolean isDinitialized;
    private boolean isFAinitialized;
    private boolean isSAinitialized;

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
        if (!paramsBuilder.isAnyInitialized)
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

        this.isNinitialized = paramsBuilder.isNinitialized();
        this.isKinitialized = paramsBuilder.isKinitialized();
        this.isXinitialized = paramsBuilder.isXinitialized();
        this.isYinitialized = paramsBuilder.isYinitialized();
        this.isDinitialized = paramsBuilder.isDinitialized();
        this.isAinitialized = paramsBuilder.isAinitialized();
        this.isBinitialized = paramsBuilder.isBinitialized();
        this.isSinitialized = paramsBuilder.isSinitialized();
        this.isFAinitialized = paramsBuilder.isFAinitialized();
        this.isSAinitialized = paramsBuilder.isSAinitialized();
    }

    public String toString() {
        String s = "";

        s+= (this.isNinitialized ? "N=" + this.n : "" );
        s+= (this.isKinitialized ? (s.length() > 0 ? ", " : "") + "K=" + this.k : "" );
        s+= (this.isXinitialized ? (s.length() > 0 ? ", " : "") + "X=" + this.x : "" );
        s+= (this.isYinitialized ? (s.length() > 0 ? ", " : "") + "Y=" + this.y : "" );
        s+= (this.isDinitialized ? (s.length() > 0 ? ", " : "") + "D=" + this.d : "" );
        s+= (this.isAinitialized ? (s.length() > 0 ? ", " : "") + "A=" + this.a : "" );
        s+= (this.isBinitialized ? (s.length() > 0 ? ", " : "") + "B=" + this.b : "" );
        s+= (this.isSinitialized ? (s.length() > 0 ? ", " : "") + "S=" + this.s : "" );
        s+= (this.isFAinitialized ? (s.length() > 0 ? ", " : "") + "FA=" + Arrays.toString(this.firstArray) : "" );
        s+= (this.isSAinitialized ? (s.length() > 0 ? ", " : "") + "SA=" + Arrays.toString(this.secondArray) : "" );

        return s;
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
        private boolean isAnyInitialized = false;

        private boolean isNinitialized = false;
        private boolean isKinitialized = false;
        private boolean isXinitialized = false;
        private boolean isYinitialized = false;
        private boolean isAinitialized = false;
        private boolean isBinitialized = false;
        private boolean isSinitialized = false;
        private boolean isDinitialized = false;
        private boolean isFAinitialized = false;
        private boolean isSAinitialized = false;

        public boolean isKinitialized() {
            return isKinitialized;
        }

        public boolean isXinitialized() {
            return isXinitialized;
        }

        public boolean isYinitialized() {
            return isYinitialized;
        }

        public boolean isDinitialized() {
            return isDinitialized;
        }

        public boolean isAinitialized() {
            return isAinitialized;
        }

        public boolean isBinitialized() {
            return isBinitialized;
        }

        public boolean isSinitialized() {
            return isSinitialized;
        }

        public boolean isFAinitialized() {
            return isFAinitialized;
        }

        public boolean isSAinitialized() {
            return isSAinitialized;
        }



        public boolean isNinitialized() {
            return isNinitialized;
        }

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

        private boolean isAnyInitialized() {
            return this.isAnyInitialized;
        }

        public SolutionInputParamsBuilder setN(int n) {
            this.n = n;
            this.isAnyInitialized = true;
            this.isNinitialized = true;
            return this;
        }

        public SolutionInputParamsBuilder setK(int k) {
            this.k = k;
            this.isAnyInitialized = true;
            this.isKinitialized = true;
            return this;
        }

        public SolutionInputParamsBuilder setX(int x) {
            this.x = x;
            this.isAnyInitialized = true;
            this.isXinitialized = true;
            return this;
        }

        public SolutionInputParamsBuilder setY(int y) {
            this.y = y;
            this.isAnyInitialized = true;
            this.isYinitialized = true;
            return this;
        }

        public SolutionInputParamsBuilder setD(int d) {
            this.d = d;
            this.isAnyInitialized = true;
            this.isDinitialized = true;
            return this;
        }

        public SolutionInputParamsBuilder setA(int a) {
            this.a = a;
            this.isAnyInitialized = true;
            this.isAinitialized = true;
            return this;
        }

        public SolutionInputParamsBuilder setB(int b) {
            this.b = b;
            this.isAnyInitialized = true;
            this.isBinitialized = true;
            return this;
        }

        public SolutionInputParamsBuilder setStringValue(String s) {
            this.s = s;
            this.isAnyInitialized = true;
            this.isSinitialized = true;
            return this;
        }

        public SolutionInputParamsBuilder setFirstArray(int[] pArray) {
            this.firstArray = pArray;
            this.isAnyInitialized = true;
            this.isFAinitialized = true;
            return this;
        }

        public SolutionInputParamsBuilder setSecondArray(int[] pArray) {
            this.secondArray = pArray;
            this.isAnyInitialized = true;
            this.isSAinitialized = true;
            return this;
        }

        public SolutionInputParams build() {
            return new SolutionInputParams(this);
        }
    }
}
