package edu.epam.task3.repository.impl;

import edu.epam.task3.entity.Rectangle;
import edu.epam.task3.repository.RectangleSpecification;

public class IdSpecification implements RectangleSpecification {
    private final int id;

    public IdSpecification(int id) {
        this.id = id;
    }

    @Override
    public boolean specify(Rectangle rectangle) {
        return this.id == rectangle.getRectangleID();
    }
}
