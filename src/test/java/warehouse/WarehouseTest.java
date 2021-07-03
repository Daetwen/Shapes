package warehouse;

import edu.epam.task3.entity.LocalPoint;
import edu.epam.task3.entity.Rectangle;
import edu.epam.task3.exception.ShapeException;
import edu.epam.task3.observer.RectangleObserver;
import edu.epam.task3.observer.impl.RectangleObserverImpl;
import edu.epam.task3.service.SizeService;
import edu.epam.task3.service.impl.SizeServiceImpl;
import edu.epam.task3.warehouse.Warehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.*;

import static org.testng.Assert.*;

public class WarehouseTest {
    private static Logger logger = LogManager.getLogger();
    private final Warehouse warehouse = Warehouse.getInstance();
    private Rectangle figure1;
    private Rectangle figure2;

    @BeforeClass
    public void setUp() {
        RectangleObserver rectangleObserver = new RectangleObserverImpl();
        SizeService sizeService = new SizeServiceImpl();
        figure1 = new Rectangle(3.0, 3.0, 3.0, 6.0, 6.0, 6.0, 6.0, 3.0);

        figure2 = new Rectangle(new LocalPoint(2.0, 4.0),
                                new LocalPoint(2.0, 6.0),
                                new LocalPoint(7.0, 6.0),
                                new LocalPoint(7.0, 4.0));

        figure1.attach(rectangleObserver);
        figure2.attach(rectangleObserver);

        try {
            warehouse.put(figure1.getRectangleId(),
                    sizeService.calculatePerimeter(figure1),
                    sizeService.calculateArea(figure1));

            warehouse.put(figure2.getRectangleId(),
                    sizeService.calculatePerimeter(figure2),
                    sizeService.calculateArea(figure2));
        } catch (ShapeException e) {
            logger.error("Error in warehouse tests BeforeClass", e);
        }
    }

    @AfterMethod
    public void setUp2() {
        figure1.setSecondPoint(new LocalPoint(3.0, 6.0));
        figure2.setSecondPoint(new LocalPoint(2.0, 6.0));
        figure2.setThirdPoint(new LocalPoint(7.0, 6.0));
    }

    @Test
    public void updatePositiveTest0() throws ShapeException {
        double expected = 12.0;
        double actual = warehouse.get(figure1.getRectangleId()).getPerimeter();
        assertEquals(actual, expected);
    }

    @Test
    public void updatePositiveTest1() throws ShapeException {
        double expected = 18.0;
        figure1.setSecondPoint(new LocalPoint(3.0, 10.0));
        double actual = warehouse.get(figure1.getRectangleId()).getPerimeter();
        assertEquals(actual, expected);
    }

    @Test
    public void updatePositiveTest2() throws ShapeException {
        double expected = 15.0;
        figure1.setSecondPoint(new LocalPoint(3.0, 10.0));
        double actual = warehouse.get(figure1.getRectangleId()).getArea();
        assertEquals(actual, expected);
    }

    @Test
    public void updatePositiveTest3() throws ShapeException {
        double expected = 16.385164807134505;
        figure2.setSecondPoint(new LocalPoint(2.0, 8.0));
        double actual = warehouse.get(figure2.getRectangleId()).getPerimeter();
        assertEquals(actual, expected);
    }

    @Test
    public void updatePositiveTest4() throws ShapeException {
        double expected = 18.0;
        figure2.setSecondPoint(new LocalPoint(2.0, 8.0));
        figure2.setThirdPoint(new LocalPoint(7.0, 8.0));
        double actual = warehouse.get(figure2.getRectangleId()).getPerimeter();
        assertEquals(actual, expected);
    }

    @Test
    public void updatePositiveTest5() throws ShapeException {
        double expected = 15.0;
        figure2.setSecondPoint(new LocalPoint(2.0, 8.0));
        double actual = warehouse.get(figure2.getRectangleId()).getArea();
        assertEquals(actual, expected);
    }

    @Test
    public void updatePositiveTest6() throws ShapeException {
        double expected = 20.0;
        figure2.setSecondPoint(new LocalPoint(2.0, 8.0));
        figure2.setThirdPoint(new LocalPoint(7.0, 8.0));
        double actual = warehouse.get(figure2.getRectangleId()).getArea();
        assertEquals(actual, expected);
    }
}
