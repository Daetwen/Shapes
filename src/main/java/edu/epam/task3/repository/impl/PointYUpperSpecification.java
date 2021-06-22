package edu.epam.task3.repository.impl;

import edu.epam.task3.entity.Rectangle;
import edu.epam.task3.repository.RectangleSpecification;

public class PointYUpperSpecification implements RectangleSpecification {
    private final double minBorder;

    public PointYUpperSpecification(double maxBorder) {
        this.minBorder = maxBorder;
    }

    @Override
    public boolean specify(Rectangle rectangle) {
        double firstY = rectangle.getFirstPoint().getY();
        double secondY = rectangle.getSecondPoint().getY();
        double thirdY = rectangle.getThirdPoint().getY();
        double fourthY = rectangle.getFourthPoint().getY();
        return minBorder < firstY && minBorder < secondY && minBorder < thirdY && minBorder < fourthY;
    }
}
