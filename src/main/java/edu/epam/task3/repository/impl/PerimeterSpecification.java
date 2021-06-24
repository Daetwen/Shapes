package edu.epam.task3.repository.impl;

import edu.epam.task3.entity.Rectangle;
import edu.epam.task3.exception.ShapeException;
import edu.epam.task3.repository.RectangleSpecification;
import edu.epam.task3.service.impl.SizeServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PerimeterSpecification implements RectangleSpecification {
    private static Logger logger = LogManager.getLogger();
    private final double minBorder;
    private final double maxBorder;

    public PerimeterSpecification(double minBorder, double maxBorder) {
        this.minBorder = minBorder;
        this.maxBorder = maxBorder;
    }

    @Override
    public boolean specify(Rectangle rectangle) {
        var sizeService = new SizeServiceImpl();
        double resultPerimeter = 0;
        try {
            resultPerimeter = sizeService.calculateArea(rectangle);
        } catch (ShapeException e) {
            logger.error("Error in AreaSpecification with calculating area.", e);
        }
        return resultPerimeter >= minBorder && resultPerimeter <= maxBorder;
    }
}
