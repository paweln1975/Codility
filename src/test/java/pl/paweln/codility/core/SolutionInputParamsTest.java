package pl.paweln.codility.core;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SolutionInputParamsTest {
    private SolutionInputParams.SolutionInputParamsBuilder paramsBuilder;
    private SolutionInputParams params;

    @Before
    public void setup() {
        this.paramsBuilder = new SolutionInputParams.SolutionInputParamsBuilder();
    }

    @Test
    public void test() {
        this.params = this.paramsBuilder
                .setN(10).setA(20).setB(30).setD(40).setK(50).setX(60).setY(70)
                .setFirstArray(new int[] {0, 1, 2, 3})
                .setSecondArray(new int[] {})
                .setStringValue("ABC").build();

        String expected = "N=10, K=50, X=60, Y=70, D=40, A=20, B=30, S=ABC, FA=[0, 1, 2, 3], SA=[]";

        Assert.assertEquals(expected, this.params.toString());
    }
}
