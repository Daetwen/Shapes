package edu.epam.task3.comparator;

import edu.epam.task3.entity.Rectangle;
import edu.epam.task3.exception.ShapeException;
import edu.epam.task3.service.SizeService;
import edu.epam.task3.service.impl.SizeServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;

public class RectangleAreaComparator implements Comparator<Rectangle> {

    private static Logger logger = LogManager.getLogger();

    @Override
    public int compare(Rectangle rectangle1, Rectangle rectangle2) {
        int result = 0;
        double area1 = 0;
        double area2 = 0;
        SizeService sizeService = new SizeServiceImpl();
        try {
            area1 = sizeService.calculateArea(rectangle1);
            area2 = sizeService.calculateArea(rectangle2);
        } catch (ShapeException e) {
            logger.error("Error in RectangleAreaComparator with calculating area.", e);
        }
        if (area1 > area2) {
            result = 1;
        } else if (area1 < area2) {
            result = -1;
        }
        return result;
    }
}
