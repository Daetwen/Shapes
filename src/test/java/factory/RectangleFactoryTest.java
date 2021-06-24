package factory;

import edu.epam.task3.entity.Rectangle;
import edu.epam.task3.factory.RectangleFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.testng.Assert.assertEquals;

public class RectangleFactoryTest {
    private List<double[]> testListDouble1;
    private List<double[]> testListDouble2;
    private List<Rectangle> testListRectangle1;
    private List<Rectangle> testListRectangle2;

    @BeforeClass
    public void setUp() {
        testListDouble1 = new ArrayList<>();
        testListDouble1.add(new double[] {4.0, 2.0, 3.0, 45.0, 5.0, 6.0, 7.0, 8.0});
        testListDouble1.add(new double[] {8.0, 3.0, 7.0, 12.0, 12.0, 3.5, 11.2, 2.1});
        testListDouble1.add(new double[] {11.0, 4.0, 10.0, 6.0, 11.0, 8.0, 12.0, 6.0});

        testListDouble2 = new ArrayList<>();
        testListDouble2.add(new double[] {11.0, 8.0, 10.1, 6.0, 11.2, 13.4, 3.4, 9.9});
        testListDouble2.add(new double[] {21.0, 5.0, 10.5, 6.7, 16.0, 9.0, 10.0, 6.9});

        testListRectangle1 = new ArrayList<>();
        testListRectangle1.add(new Rectangle(4.0, 2.0, 3.0, 45.0, 5.0, 6.0, 7.0, 8.0));
        testListRectangle1.add(new Rectangle(8.0, 3.0, 7.0, 12.0, 12.0, 3.5, 11.2, 2.1));
        testListRectangle1.add(new Rectangle(11.0, 4.0, 10.0, 6.0, 11.0, 8.0, 12.0, 6.0));

        testListRectangle2 = new ArrayList<>();
        testListRectangle2.add(new Rectangle(11.0, 8.0, 10.1, 6.0, 11.2, 13.4, 3.4, 9.9));
        testListRectangle2.add(new Rectangle(21.0, 5.0, 10.5, 6.7, 16.0, 9.0, 10.0, 6.9));
    }

    @Test
    public void createRectanglesPositiveTest1() {
        List<Rectangle> expected = testListRectangle1;
        List<Rectangle> actual = RectangleFactory.createRectangles(testListDouble1);
        assertEquals(actual, expected);
    }

    @Test
    public void createRectanglesPositiveTest2() {
        List<Rectangle> expected = testListRectangle2;
        List<Rectangle> actual = RectangleFactory.createRectangles(testListDouble2);
        assertEquals(actual, expected);
    }
}
