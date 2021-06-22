package edu.epam.task3.repository.impl;

import edu.epam.task3.entity.Rectangle;
import edu.epam.task3.repository.RectangleSpecification;

public class PointXUpperSpecification implements RectangleSpecification {
    private final double minBorder;

    public PointXUpperSpecification(double maxBorder) {
        this.minBorder = maxBorder;
    }

    @Override
    public boolean specify(Rectangle rectangle) {
        double firstX = rectangle.getFirstPoint().getX();
        double secondX = rectangle.getSecondPoint().getX();
        double thirdX = rectangle.getThirdPoint().getX();
        double fourthX = rectangle.getFourthPoint().getX();
        return minBorder < firstX && minBorder < secondX && minBorder < thirdX && minBorder < fourthX;
    }
}
