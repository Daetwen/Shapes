package edu.epam.task3.comparator;

import edu.epam.task3.entity.Rectangle;
import edu.epam.task3.service.SizeService;
import edu.epam.task3.service.impl.SizeServiceImpl;

import java.util.Comparator;

public class RectanglePerimeterComparator implements Comparator<Rectangle> {

    @Override
    public int compare(Rectangle rectangle1, Rectangle rectangle2) {
        int result = 0;
        double perimeter1;
        double perimeter2;
        SizeService sizeService = new SizeServiceImpl();
        perimeter1 = sizeService.calculatePerimeter(rectangle1);
        perimeter2 = sizeService.calculatePerimeter(rectangle2);
        if (perimeter1 > perimeter2) {
            result = 1;
        } else if (perimeter1 < perimeter2) {
            result = -1;
        }
        return result;
    }
}
