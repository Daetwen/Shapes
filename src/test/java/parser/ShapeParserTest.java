package parser;

import edu.epam.task3.exception.ShapeException;
import edu.epam.task3.parser.ShapeParser;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class ShapeParserTest {
    private final ShapeParser shapeParser = new ShapeParser();
    private List<String> testListString1;
    private List<String> testListString2;
    private List<String> testListString3;
    private List<String> testListString4;
    private List<String> testListString5;
    private List<double[]> testListDouble1;
    private List<double[]> testListDouble2;
    private List<double[]> testListDouble3;

    @BeforeClass
    public void setUp() {
        testListString1 = new ArrayList<>();
        testListString1.add("4 2 3 45 5 6 7 8");
        testListString1.add("8.0 3.0 7.0 12.0 12.0 3.5 11.2 2.1");
        testListString1.add("11.0 4.0 10.0 6.0 11.0 8.0 12.0 6.0");

        testListString2 = new ArrayList<>();
        testListString2.add("4 2 3 45 67 1 4 9");
        testListString2.add("ewwe");
        testListString2.add("3 4 5 6opi 7");

        testListString3 = new ArrayList<>();
        testListString3.add("45 5uio 6 7 8op 9 8");
        testListString3.add("ewwe");
        testListString3.add("11.0 8.0 10.1 6.0 11.2 13.4 3.4 9.9");
        testListString3.add("21.0 5.0 10.5 6.7 16.0 9.0 10.0 6.9");

        testListDouble1 = new ArrayList<>();
        testListDouble1.add(new double[] {4.0, 2.0, 3.0, 45.0, 5.0, 6.0, 7.0, 8.0});
        testListDouble1.add(new double[] {8.0, 3.0, 7.0, 12.0, 12.0, 3.5, 11.2, 2.1});
        testListDouble1.add(new double[] {11.0, 4.0, 10.0, 6.0, 11.0, 8.0, 12.0, 6.0});

        testListDouble2 = new ArrayList<>();
        testListDouble2.add(new double[] {4, 2, 3, 45, 67, 1, 4, 9});

        testListDouble3 = new ArrayList<>();
        testListDouble3.add(new double[] {11.0, 8.0, 10.1, 6.0, 11.2, 13.4, 3.4, 9.9});
        testListDouble3.add(new double[] {21.0, 5.0, 10.5, 6.7, 16.0, 9.0, 10.0, 6.9});

        testListString4 = new ArrayList<>();
    }

    @Test
    public void parseListToPointsXYArraysPositiveTest1() throws ShapeException {
        List<double[]> expected = testListDouble1;
        List<double[]> actual = shapeParser.parseListToPointsXYArrays(testListString1);
        Assert.assertEquals(actual.size(), expected.size());
    }

    @DataProvider(name = "PositiveTest1")
    public Object[][] parametersPositiveTest1_1()  throws ShapeException {
        List<double[]> actual = shapeParser.parseListToPointsXYArrays(testListString1);
        return new Object[][] {{actual.get(0), testListDouble1.get(0)},
                               {actual.get(1), testListDouble1.get(1)},
                               {actual.get(2), testListDouble1.get(2)}};
    }

    @Test(dataProvider = "PositiveTest1")
    public void parseListToPointsXYArraysPositiveTest1_1(double[] actual, double[] expected) {
        assertEquals(actual, expected);
    }

    @Test
    public void parseListToPointsXYArraysPositiveTest2() throws ShapeException {
        List<double[]> expected = testListDouble2;
        List<double[]> actual = shapeParser.parseListToPointsXYArrays(testListString2);
        Assert.assertEquals(actual.size(), expected.size());
    }

    @DataProvider(name = "PositiveTest2")
    public Object[][] parametersPositiveTest2_1()  throws ShapeException {
        List<double[]> actual = shapeParser.parseListToPointsXYArrays(testListString2);
        return new Object[][] {{actual.get(0), testListDouble2.get(0)}};
    }

    @Test(dataProvider = "PositiveTest2")
    public void parseListToPointsXYArraysPositiveTest2_1(double[] actual, double[] expected) {
        assertEquals(actual, expected);
    }

    @Test
    public void parseListToPointsXYArraysPositiveTest3() throws ShapeException {
        List<double[]> expected = testListDouble3;
        List<double[]> actual = shapeParser.parseListToPointsXYArrays(testListString3);
        Assert.assertEquals(actual.size(), expected.size());
    }

    @DataProvider(name = "PositiveTest3")
    public Object[][] parametersPositiveTest3_1()  throws ShapeException {
        List<double[]> actual = shapeParser.parseListToPointsXYArrays(testListString3);
        return new Object[][] {{actual.get(0), testListDouble3.get(0)},
                               {actual.get(1), testListDouble3.get(1)}};
    }

    @Test(dataProvider = "PositiveTest3")
    public void parseListToPointsXYArraysPositiveTest3_1(double[] actual, double[] expected) {
        assertEquals(actual, expected);
    }

    @Test
    public void parseListToPointsXYArraysNegativeTest1() throws ShapeException {
        List<double[]> expected = testListDouble3;
        List<double[]> actual = shapeParser.parseListToPointsXYArrays(testListString2);
        assertNotEquals(actual.size(), expected.size());
    }

    @Test
    public void parseListToPointsXYArraysNegativeTest2() {
        assertThrows(ShapeException.class, () -> shapeParser.parseListToPointsXYArrays(testListString4));
    }

    @Test
    public void parseListToPointsXYArraysNegativeTest3() {
        assertThrows(ShapeException.class, () -> shapeParser.parseListToPointsXYArrays(testListString5));
    }
}
