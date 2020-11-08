package pl.paweln.codility.iterations;

import pl.paweln.codility.core.AbstractCodility;
import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.SolutionInputParams;

public class BinaryGap extends AbstractCodility implements CodilitySolution {

    public BinaryGap() {
        defaultParams = paramsBuilder.setN(1041).build();
    }

    @Override
    public int[] solution(SolutionInputParams params) {
        int N = params.getN();

        if (N < 0) throw new IllegalArgumentException("N cannot be negative.");

        return new int[] {this.solution(N)};
    }

    private int solution(int N) {
        int binGap = 0;
        int tmpBinGap = 0;
        boolean foundStart = false;
        while (N > 0) {
            if (N % 2 == 1) {
                foundStart = true;
                binGap = Math.max(binGap, tmpBinGap);
                tmpBinGap = 0;
            } else {
                if (foundStart) tmpBinGap++;
            }
            N = N >> 1;
        }
        return binGap;
    }


}
