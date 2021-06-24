package edu.epam.task3.repository.impl;

import edu.epam.task3.entity.Rectangle;
import edu.epam.task3.exception.ShapeException;
import edu.epam.task3.repository.RectangleSpecification;
import edu.epam.task3.service.SizeService;
import edu.epam.task3.service.impl.SizeServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AreaSpecification implements RectangleSpecification {
    private static Logger logger = LogManager.getLogger();
    private final double minBorder;
    private final double maxBorder;

    public AreaSpecification(double minBorder, double maxBorder) {
        this.minBorder = minBorder;
        this.maxBorder = maxBorder;
    }

    @Override
    public boolean specify(Rectangle rectangle) {
        SizeService sizeService = new SizeServiceImpl();
        double resultArea = 0;
        try {
            resultArea = sizeService.calculateArea(rectangle);
        } catch (ShapeException e) {
            logger.error("Error in AreaSpecification with calculating area.", e);
        }
        return resultArea >= minBorder && resultArea <= maxBorder;
    }
}
