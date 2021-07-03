package edu.epam.task3.warehouse;

import edu.epam.task3.exception.ShapeException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    private static Logger logger = LogManager.getLogger();
    private static Warehouse instance;
    private Map<Long, RectangleParameters> rectangleParametersMap;

    private Warehouse() {
        this.rectangleParametersMap = new HashMap<>();
    }

    public static Warehouse getInstance() {
        if (instance == null) {
            instance = new Warehouse();
        }
        return instance;
    }

    public void put(Long key, RectangleParameters value) {
        rectangleParametersMap.put(key, value);
    }

    public void put(Long key, double perimeter, double area) {
        RectangleParameters rectangleParameter = new RectangleParameters();
        rectangleParameter.setPerimeter(perimeter);
        rectangleParameter.setArea(area);
        rectangleParametersMap.put(key, rectangleParameter);
    }

    public RectangleParameters remove(Long key) {
        return rectangleParametersMap.remove(key);
    }

    public int size() {
        return rectangleParametersMap.size();
    }

    public RectangleParameters get(Long key) throws ShapeException {
        RectangleParameters rectangleParameter = rectangleParametersMap.get(key);
        if (rectangleParameter == null) {
            logger.error("There are no element with this id: " + key);
            throw new ShapeException("There are no element with this id: " + key);
        }
        return rectangleParameter;
    }

    public void update(Long key, RectangleParameters value) throws ShapeException {
        RectangleParameters rectangleParameter = rectangleParametersMap.get(key);
        if (rectangleParameter == null) {
            logger.error("There are no element with this id: " + key);
            throw new ShapeException("There are no element with this id: " + key);
        }
        rectangleParameter.setPerimeter(value.getPerimeter());
        rectangleParameter.setArea(value.getArea());
    }

    public void update(Long key, double perimeter, double area) throws ShapeException {
        RectangleParameters rectangleParameter = rectangleParametersMap.get(key);
        if (rectangleParameter == null) {
            logger.error("There are no element with this id: " + key);
            throw new ShapeException("There are no element with this id: " + key);
        }
        rectangleParameter.setPerimeter(perimeter);
        rectangleParameter.setArea(area);
    }

    public void updatePerimeter(Long key, double perimeter) throws ShapeException {
        RectangleParameters rectangleParameter = rectangleParametersMap.get(key);
        if (rectangleParameter == null) {
            logger.error("There are no element with this id: " + key);
            throw new ShapeException("There are no element with this id: " + key);
        }
        rectangleParameter.setPerimeter(perimeter);
    }

    public void updateArea(Long key, double area) throws ShapeException {
        RectangleParameters rectangleParameter = rectangleParametersMap.get(key);
        if (rectangleParameter == null) {
            logger.error("There are no element with this id: " + key);
            throw new ShapeException("There are no element with this id: " + key);
        }
        rectangleParameter.setArea(area);
    }
}
