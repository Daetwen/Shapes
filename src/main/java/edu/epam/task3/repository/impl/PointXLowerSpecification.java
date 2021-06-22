package edu.epam.task3.repository.impl;

import edu.epam.task3.entity.Rectangle;
import edu.epam.task3.repository.RectangleSpecification;

public class PointXLowerSpecification implements RectangleSpecification {
    private final double maxBorder;

    public PointXLowerSpecification(double maxBorder) {
        this.maxBorder = maxBorder;
    }

    @Override
    public boolean specify(Rectangle rectangle) {
        double firstX = rectangle.getFirstPoint().getX();
        double secondX = rectangle.getSecondPoint().getX();
        double thirdX = rectangle.getThirdPoint().getX();
        double fourthX = rectangle.getFourthPoint().getX();
        return maxBorder > firstX && maxBorder > secondX && maxBorder > thirdX && maxBorder > fourthX;
    }
}
