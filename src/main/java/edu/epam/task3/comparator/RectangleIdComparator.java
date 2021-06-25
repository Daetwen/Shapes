package edu.epam.task3.comparator;

import edu.epam.task3.entity.Rectangle;

import java.util.Comparator;

public class RectangleIdComparator implements Comparator<Rectangle> {

    @Override
    public int compare(Rectangle rectangle1, Rectangle rectangle2) {
        int result = 0;
        if (rectangle1.getRectangleId() > rectangle2.getRectangleId()) {
            result = 1;
        } else if (rectangle1.getRectangleId() < rectangle2.getRectangleId()) {
            result = -1;
        }
        return result;
    }
}
