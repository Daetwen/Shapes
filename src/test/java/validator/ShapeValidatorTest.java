package validator;

import edu.epam.task3.validator.ShapeValidator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class ShapeValidatorTest {

    private String testStringValid1;
    private String testStringValid2;
    private String testStringInvalid1;
    private String testStringInvalid2;
    private String testStringInvalid3;

    @BeforeClass
    public void setUp() {
        testStringValid1 = "3.0 3.0 3.0 6.0 6.0 6.0 6.0 3.0";
        testStringValid2 = "11.0 4.0 10.0 6.0 11.0 8.0 12.0 6.0";
        testStringInvalid1 = "3,0 3,0 3,0 6,0 6.0 3.0";
        testStringInvalid2 = "11.0 4.0j 10.0 6.0jj 11.0 8.0 12.0 6.uu0";
        testStringInvalid3 = "message";
    }

    @Test
    public void checkIsStringArrayValidPositiveTest1() {
        boolean actual = ShapeValidator.checkIsStringArrayValid(testStringValid1);
        assertTrue(actual);
    }

    @Test
    public void checkIsStringArrayValidPositiveTest2() {
        boolean actual = ShapeValidator.checkIsStringArrayValid(testStringValid2);
        assertTrue(actual);
    }

    @Test
    public void checkIsStringArrayValidNegativeTest1() {
        boolean actual = ShapeValidator.checkIsStringArrayValid(testStringInvalid1);
        assertFalse(actual);
    }

    @Test
    public void checkIsStringArrayValidNegativeTest2() {
        boolean actual = ShapeValidator.checkIsStringArrayValid(testStringInvalid2);
        assertFalse(actual);
    }

    @Test
    public void checkIsStringArrayValidNegativeTest3() {
        boolean actual = ShapeValidator.checkIsStringArrayValid(testStringInvalid3);
        assertFalse(actual);
    }

    @Test
    public void checkIsStringArrayValidNegativeTest4() {
        boolean actual = ShapeValidator.checkIsStringArrayValid("");
        assertFalse(actual);
    }
}
