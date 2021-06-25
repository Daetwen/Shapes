package edu.epam.task3.repository.impl;

import edu.epam.task3.entity.Rectangle;
import edu.epam.task3.repository.RectangleSpecification;

public class IdSpecification implements RectangleSpecification {
    private final long id;

    public IdSpecification(long id) {
        this.id = id;
    }

    @Override
    public boolean specify(Rectangle rectangle) {
        return this.id == rectangle.getRectangleId();
    }
}
