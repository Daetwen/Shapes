package edu.epam.task3.observer.impl;

import edu.epam.task3.entity.Rectangle;
import edu.epam.task3.exception.ShapeException;
import edu.epam.task3.observer.RectangleEvent;
import edu.epam.task3.observer.RectangleObserver;
import edu.epam.task3.service.SizeService;
import edu.epam.task3.service.impl.SizeServiceImpl;
import edu.epam.task3.warehouse.Warehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RectangleObserverImpl implements RectangleObserver {

    private static Logger logger = LogManager.getLogger();

    @Override
    public void updateArea(RectangleEvent rectangleEvent) {
        Rectangle rectangle = rectangleEvent.getSource();
        long id = rectangle.getRectangleID();
        Warehouse warehouse = Warehouse.getInstance();
        try {
            SizeService sizeService = new SizeServiceImpl();
            double area = sizeService.calculateArea(rectangle);
            warehouse.updateArea(id, area);
            logger.info("Area of rectangle with id " + id + " was changed successfully. New area = " + area);
        } catch (ShapeException e) {
            logger.error("Error in updating area: ", e);
        }
    }

    @Override
    public void updatePerimeter(RectangleEvent rectangleEvent) {
        Rectangle rectangle = rectangleEvent.getSource();
        long id = rectangle.getRectangleID();
        Warehouse warehouse = Warehouse.getInstance();
        try {
            SizeService sizeService = new SizeServiceImpl();
            double perimeter = sizeService.calculatePerimeter(rectangle);
            warehouse.updatePerimeter(id, perimeter);
            logger.info("Perimeter of rectangle with id "
                    + id + " was changed successfully. New perimeter = " + perimeter);
        } catch (ShapeException e) {
            logger.error("Error in updating perimeter: ", e);
        }
    }

    @Override
    public void updatePerimeterAndArea(RectangleEvent rectangleEvent) {
        Rectangle rectangle = rectangleEvent.getSource();
        long id = rectangle.getRectangleID();
        Warehouse warehouse = Warehouse.getInstance();
        try {
            SizeService sizeService = new SizeServiceImpl();
            double perimeter = sizeService.calculatePerimeter(rectangle);
            double area = sizeService.calculateArea(rectangle);
            warehouse.update(id, perimeter, area);
            logger.info("Perimeter and area of rectangle with id "
                    + id + " was changed successfully. New perimeter = " + perimeter + ". New area = " + area);
        } catch (ShapeException e) {
            logger.error("Error in updating perimeter and area: ", e);
        }
    }
}
