package edu.epam.task3.repository.impl;

import edu.epam.task3.entity.Rectangle;
import edu.epam.task3.repository.RectangleSpecification;

public class PointYLowerSpecification implements RectangleSpecification {
    private final double maxBorder;

    public PointYLowerSpecification(double maxBorder) {
        this.maxBorder = maxBorder;
    }

    @Override
    public boolean specify(Rectangle rectangle) {
        double firstY = rectangle.getFirstPoint().getY();
        double secondY = rectangle.getSecondPoint().getY();
        double thirdY = rectangle.getThirdPoint().getY();
        double fourthY = rectangle.getFourthPoint().getY();
        return maxBorder > firstY && maxBorder > secondY && maxBorder > thirdY && maxBorder > fourthY;
    }
}
