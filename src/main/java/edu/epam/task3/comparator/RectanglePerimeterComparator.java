package edu.epam.task3.comparator;

import edu.epam.task3.entity.Rectangle;
import edu.epam.task3.exception.ShapeException;
import edu.epam.task3.service.SizeService;
import edu.epam.task3.service.impl.SizeServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;

public class RectanglePerimeterComparator implements Comparator<Rectangle> {

    private static Logger logger = LogManager.getLogger();

    @Override
    public int compare(Rectangle rectangle1, Rectangle rectangle2) {
        int result = 0;
        double perimeter1 = 0;
        double perimeter2 = 0;
        SizeService sizeService = new SizeServiceImpl();
        try {
            perimeter1 = sizeService.calculatePerimeter(rectangle1);
            perimeter2 = sizeService.calculatePerimeter(rectangle2);
        } catch (ShapeException e) {
            logger.error("Error in RectanglePerimeterComparator with calculating perimeter.", e);
        }
        if (perimeter1 > perimeter2) {
            result = 1;
        } else if (perimeter1 < perimeter2) {
            result = -1;
        }
        return result;
    }
}
