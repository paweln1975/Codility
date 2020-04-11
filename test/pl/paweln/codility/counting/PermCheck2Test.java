package pl.paweln.codility.counting;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.paweln.codility.core.Solution;
import pl.paweln.codility.core.SolutionFactory;
import pl.paweln.codility.core.SolutionInputParams;


public class PermCheck2Test extends PermCheckTest {

    @Before
    public void setUp() {
        this.s = this.solutionFactory.getSolution(SolutionFactory.CodilityTask.COUNTING_PERM_CHECK2);
        this.paramsBuilder = new SolutionInputParams.SolutionInputParamsBuilder();
    }


}