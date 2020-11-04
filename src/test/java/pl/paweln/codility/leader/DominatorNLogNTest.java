package pl.paweln.codility.leader;

import org.junit.Before;
import pl.paweln.codility.core.SolutionFactory;
import pl.paweln.codility.core.SolutionInputParams;

public class DominatorNLogNTest extends DominatorTest {
        @Before
        @Override
        public void setUp() {
            super.s = this.solutionFactory.getSolution(SolutionFactory.CodilityTask.LEADER_DOMINATOR_LOG);
            super.paramsBuilder = new SolutionInputParams.SolutionInputParamsBuilder();
        }
}
