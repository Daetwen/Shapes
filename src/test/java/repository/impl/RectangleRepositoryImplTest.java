package repository.impl;

import edu.epam.task3.comparator.RectangleIdComparator;
import edu.epam.task3.entity.LocalPoint;
import edu.epam.task3.entity.Rectangle;
import edu.epam.task3.repository.RectangleRepository;
import edu.epam.task3.repository.RectangleSpecification;
import edu.epam.task3.repository.impl.AreaSpecification;
import edu.epam.task3.repository.impl.RectangleRepositoryImpl;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class RectangleRepositoryImplTest {
    private RectangleRepository rectangleRepository = new RectangleRepositoryImpl();
    private List<Rectangle> rectangleList;
    private List<Rectangle> rectangleListSortedById;
    private List<Rectangle> rectangleListQueryByAreaSpecification;
    private Rectangle figure1;
    private Rectangle figure2;
    private Rectangle figure3;
    private Rectangle figure4;
    private Rectangle figure5;
    private Rectangle figure6;
    private Rectangle figure7;

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

        rectangleList = new ArrayList<>();
        rectangleList.add(figure7);
        rectangleList.add(figure6);
        rectangleList.add(figure5);
        rectangleList.add(figure4);
        rectangleList.add(figure3);
        rectangleList.add(figure2);
        rectangleList.add(figure1);

        rectangleListSortedById = new ArrayList<>();
        rectangleListSortedById.add(figure1);
        rectangleListSortedById.add(figure2);
        rectangleListSortedById.add(figure3);
        rectangleListSortedById.add(figure4);
        rectangleListSortedById.add(figure5);
        rectangleListSortedById.add(figure6);
        rectangleListSortedById.add(figure7);

        rectangleListQueryByAreaSpecification = new ArrayList<>();
        rectangleListQueryByAreaSpecification.add(figure5);
        rectangleListQueryByAreaSpecification.add(figure4);
        rectangleListQueryByAreaSpecification.add(figure3);
        rectangleListQueryByAreaSpecification.add(figure1);

        rectangleRepository.add(figure7);
        rectangleRepository.add(figure6);
        rectangleRepository.add(figure5);
        rectangleRepository.add(figure4);
        rectangleRepository.add(figure3);
        rectangleRepository.add(figure2);
        rectangleRepository.add(figure1);
    }

    @Test
    public void sizePositiveTest() {
        int expected = 7;
        int actual = rectangleRepository.size();
        assertEquals(actual, expected);
    }

    @Test
    public void sortPositiveTest() {
        List<Rectangle> expected = rectangleListSortedById;
        RectangleIdComparator rectangleIdComparator = new RectangleIdComparator();
        List<Rectangle> actual = rectangleRepository.sort(rectangleIdComparator);
        assertEquals(actual, expected);
    }

    @Test(description = "work with RectangleSpecification")
    public void queryPositiveTest() {
        List<Rectangle> expected = rectangleListQueryByAreaSpecification;
        RectangleSpecification rectangleSpecification = new AreaSpecification(5, 9);
        List<Rectangle> actual = rectangleRepository.query(rectangleSpecification);
        assertEquals(actual, expected);
    }

    @Test(description = "work with RectangleSpecification")
    public void queryCyclePositiveTest() {
        List<Rectangle> expected = rectangleListQueryByAreaSpecification;
        RectangleSpecification rectangleSpecification = new AreaSpecification(5, 9);
        List<Rectangle> actual = rectangleRepository.queryCycle(rectangleSpecification);
        assertEquals(actual, expected);
    }
}
