package edu.epam.task3.comparator;

import edu.epam.task3.entity.Rectangle;
import edu.epam.task3.service.SizeService;
import edu.epam.task3.service.impl.SizeServiceImpl;

import java.util.Comparator;

public class RectangleAreaComparator implements Comparator<Rectangle> {

    @Override
    public int compare(Rectangle rectangle1, Rectangle rectangle2) {
        int result = 0;
        double area1;
        double area2;
        SizeService sizeService = new SizeServiceImpl();
        area1 = sizeService.calculateArea(rectangle1);
        area2 = sizeService.calculateArea(rectangle2);
        if (area1 > area2) {
            result = 1;
        } else if (area1 < area2) {
            result = -1;
        }
        return result;
    }
}
