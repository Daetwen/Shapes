package service.impl;

import edu.epam.task3.entity.LocalPoint;
import edu.epam.task3.entity.Rectangle;
import edu.epam.task3.exception.ShapeException;
import edu.epam.task3.service.ShapeService;
import edu.epam.task3.service.impl.ShapeServiceImpl;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ShapeServiceImplTest {
    private ShapeService shapeService = new ShapeServiceImpl();
    private Rectangle figure1; //Квадрат
    private Rectangle figure2; //Ромб
    private Rectangle figure3; //Трапеция
    private Rectangle figure4; //Параллелограмм
    private Rectangle figure5; //Произвольная невыпуклая
    private Rectangle figure6; //Произвольная невыпуклая
    private Rectangle figure7; //Произвольная невыпуклая
    private Rectangle figure8; //Фигура с 3 точками на 1 линии

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

        figure8 = new Rectangle(new LocalPoint(6.0, -10.0),
                                new LocalPoint(6.0, -9.0),
                                new LocalPoint(6.0, -8.0),
                                new LocalPoint(10.0, -9.0));
    }

    @Test
    public void isRectanglePositiveTest() {
        boolean actual = shapeService.isRectangle(figure1);
        assertTrue(actual);
    }

    @Test
    public void isRectangleNegativeTest() {
        boolean actual = shapeService.isRectangle(figure8);
        assertFalse(actual);
    }

    @Test
    public void isСonvexPositiveTest() {
        boolean actual = shapeService.isСonvex(figure2);
        assertTrue(actual);
    }

    @Test
    public void isСonvexNegativeTest() {
        boolean actual = shapeService.isСonvex(figure5);
        assertFalse(actual);
    }

    @Test
    public void isSquarePositiveTest() {
        boolean actual = shapeService.isSquare(figure1);
        assertTrue(actual);
    }

    @Test
    public void isSquareNegativeTest() {
        boolean actual = shapeService.isSquare(figure4);
        assertFalse(actual);
    }

    @Test
    public void isRhombusPositiveTest() {
        boolean actual = shapeService.isRhombus(figure2);
        assertTrue(actual);
    }

    @Test
    public void isRhombusNegativeTest() {
        boolean actual = shapeService.isRhombus(figure4);
        assertFalse(actual);
    }

    @Test
    public void isTrapezoidPositiveTest() {
        boolean actual = shapeService.isTrapezoid(figure3);
        assertTrue(actual);
    }

    @Test
    public void isTrapezoidNegativeTest() {
        boolean actual = shapeService.isTrapezoid(figure4);
        assertFalse(actual);
    }

    @Test
    public void isParallelogramPositiveTest1() {
        boolean actual = shapeService.isParallelogram(figure1);
        assertTrue(actual);
    }

    @Test
    public void isParallelogramPositiveTest2() {
        boolean actual = shapeService.isParallelogram(figure2);
        assertTrue(actual);
    }

    @Test
    public void isParallelogramPositiveTest3() {
        boolean actual = shapeService.isParallelogram(figure4);
        assertTrue(actual);
    }

    @Test
    public void isParallelogramNegativeTest() {
        boolean actual = shapeService.isParallelogram(figure3);
        assertFalse(actual);
    }
}
