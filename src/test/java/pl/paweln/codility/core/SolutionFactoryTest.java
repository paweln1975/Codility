package pl.paweln.codility.core;

import org.junit.Assert;
import org.junit.Test;

public class SolutionFactoryTest {
    private final SolutionFactory solutionFactory = new SolutionFactory();
    @Test
    public void testObjectCreation() {
        for (SolutionFactory.CodilityTask task : SolutionFactory.CodilityTask.values()) {
            CodilitySolution codilitySolution = solutionFactory.getSolution(task);
            Assert.assertNotNull("Problem with creating object for value " + task.name(), codilitySolution);
        }
    }
}
