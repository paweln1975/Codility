package pl.paweln.codility.binarygap;

public class Solution {
    public int solution(int n) {
        int binGap = 0;
        int tmpBinGap = 0;
        boolean foundStart = false;
        while (n > 0) {
            if (n % 2 == 1) {
                foundStart = true;
                if (tmpBinGap > binGap) binGap = tmpBinGap;
                tmpBinGap = 0;
            } else {
                if (foundStart) tmpBinGap ++;
            }
            n = n >> 1;
        }
        return binGap;
    }
}
