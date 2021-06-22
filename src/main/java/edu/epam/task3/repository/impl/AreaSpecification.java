package edu.epam.task3.repository.impl;

import edu.epam.task3.entity.Rectangle;
import edu.epam.task3.repository.RectangleSpecification;
import edu.epam.task3.service.impl.SizeServiceImpl;

public class AreaSpecification implements RectangleSpecification {
    private final double minBorder;
    private final double maxBorder;

    public AreaSpecification(double minBorder, double maxBorder) {
        this.minBorder = minBorder;
        this.maxBorder = maxBorder;
    }

    @Override
    public boolean specify(Rectangle rectangle) {
        var sizeService = new SizeServiceImpl();
        double resultArea = sizeService.calculateArea(rectangle);
        return resultArea >= minBorder && resultArea <= maxBorder;
    }
}
