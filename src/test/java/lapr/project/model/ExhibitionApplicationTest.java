/**
 * Package location for Model concept tests.
 */
package lapr.project.model;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests a exhibition application.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class ExhibitionApplicationTest {

    /**
     * The exhibition application to be tested.
     */
    private ExhibitionApplication exhibitionApplication;

    @Before
    public void setUp() {
        exhibitionApplication = new ExhibitionApplication();
    }

    /**
     * Test of equals method, of class ExhibitionApplication.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object otherObject = new ExhibitionApplication();
        assertTrue(exhibitionApplication.equals(otherObject));
    }

    /**
     * Test of newEvaluation method, of class ExhibitionApplication.
     */
    @Test
    public void testNewEvaluation() {
        System.out.println("newEvaluation");
        Evaluation expResult = new Evaluation();
        Evaluation result = exhibitionApplication.newEvaluation();
        assertEquals(expResult, result);
    }

    /**
     * Test of validateEvaluation method, of class ExhibitionApplication.
     */
    @Test
    public void testValidateEvaluation() {
        List<Integer> answers = new ArrayList<>();
        answers.add(5);
        answers.add(3);
        answers.add(4);
        answers.add(1);
        answers.add(3);
        Evaluation evaluation = new Evaluation(answers, new StaffAttribution());
        assertTrue(exhibitionApplication.validateEvaluation(evaluation));
    }

    /**
     * Test of registerEvaluation method, of class ExhibitionApplication.
     */
    @Test
    public void testRegisterEvaluation() {
        System.out.println("registerEvaluation");
        Evaluation evaluation = new Evaluation();
        assertTrue(exhibitionApplication.registerEvaluation(evaluation));
    }

}
