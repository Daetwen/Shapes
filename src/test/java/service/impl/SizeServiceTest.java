package service.impl;

import edu.epam.task3.entity.LocalPoint;
import edu.epam.task3.entity.Rectangle;
import edu.epam.task3.exception.ShapeException;
import edu.epam.task3.service.SizeService;
import edu.epam.task3.service.impl.SizeServiceImpl;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;

public class SizeServiceTest {
    private SizeService sizeService = new SizeServiceImpl();
    private Rectangle figure1;
    private Rectangle figure2;
    private Rectangle figure3;
    private Rectangle figure4;
    private Rectangle figure5;
    private Rectangle figure6;
    private Rectangle figure7;
    private Rectangle figure8;

    @BeforeClass
    public void setUp() {
        figure1 = new Rectangle(3.0, 3.0, 3.0, 6.0, 6.0, 6.0, 6.0, 3.0);

        figure2 = new Rectangle(new LocalPoint(10.0, 6.0),
                                new LocalPoint(11.0, 8.0),
                                new LocalPoint(12.0, 6.0),
                                new LocalPoint(11.0, 4.0));

        figure3 = new Rectangle(new LocalPoint(1.0, 7.0),
                                new LocalPoint(2.0, 9.0),
                                new LocalPoint(4.0, 9.0),
                                new LocalPoint(6.0, 7.0));

        figure4 = new Rectangle(new LocalPoint(2.0, -5.0),
                                new LocalPoint(4.0, -3.0),
                                new LocalPoint(7.0, -3.0),
                                new LocalPoint(5.0, -5.0));

        figure5 = new Rectangle(new LocalPoint(2.0, -10.0),
                                new LocalPoint(5.0, -7.0),
                                new LocalPoint(4.0, -10.0),
                                new LocalPoint(6.0, -13.0));

        figure6 = new Rectangle(new LocalPoint(8.0, -6.0),
                                new LocalPoint(9.0, -6.0),
                                new LocalPoint(9.0, -5.0),
                                new LocalPoint(10.0, -7.0));

        figure7 = new Rectangle(new LocalPoint(6.0, -10.0),
                                new LocalPoint(8.0, -9.0),
                                new LocalPoint(6.0, -8.0),
                                new LocalPoint(10.0, -9.0));
    }

    @Test
    public void calculatePerimeterPositiveTest1() throws ShapeException {
        double expected = 12;
        double actual = sizeService.calculatePerimeter(figure1);
        assertEquals(actual, expected);
    }

    @Test
    public void calculatePerimeterPositiveTest2() throws ShapeException {
        double expected = 4 * Math.sqrt(5);
        double actual = sizeService.calculatePerimeter(figure2);
        assertEquals(actual, expected);
    }

    @Test
    public void calculatePerimeterPositiveTest3() throws ShapeException {
        double expected = 7  + Math.sqrt(5) + Math.sqrt(8);
        double actual = sizeService.calculatePerimeter(figure3);
        assertEquals(actual, expected);
    }

    @Test
    public void calculatePerimeterPositiveTest4() throws ShapeException {
        double expected = 6 + 2 * Math.sqrt(8);
        double actual = sizeService.calculatePerimeter(figure4);
        assertEquals(actual, expected);
    }

    @Test
    public void calculateAreaPositiveTest1() throws ShapeException {
        double expected = 9;
        double actual = sizeService.calculateArea(figure1);
        assertEquals(actual, expected);
    }

    @Test
    public void calculateAreaPositiveTest2() throws ShapeException {
        double expected = 4;
        double actual = sizeService.calculateArea(figure2);
        assertEquals(actual, expected);
    }

    @Test
    public void calculateAreaPositiveTest3() throws ShapeException {
        double expected = 7;
        double actual = sizeService.calculateArea(figure3);
        assertEquals(actual, expected);
    }

    @Test
    public void calculateAreaPositiveTest4() throws ShapeException {
        double expected = 6;
        double actual = sizeService.calculateArea(figure4);
        assertEquals(actual, expected);
    }

    @Test
    public void calculateAreaPositiveTest5() throws ShapeException {
        double expected = 6;
        double actual = sizeService.calculateArea(figure5);
        assertEquals(actual, expected);
    }

    @Test
    public void calculateAreaPositiveTest6() throws ShapeException {
        double expected = 1;
        double actual = sizeService.calculateArea(figure6);
        assertEquals(actual, expected);
    }

    @Test
    public void calculateAreaPositiveTest7() throws ShapeException {
        double expected = 2;
        double actual = sizeService.calculateArea(figure7);
        assertEquals(actual, expected);
    }

    @Test
    public void calculateAreaPositiveTest8() {
        assertThrows(ShapeException.class, () -> sizeService.calculateArea(figure8));
    }
}
