package edu.epam.task3.factory;

import edu.epam.task3.entity.LocalPoint;
import edu.epam.task3.entity.Rectangle;
import edu.epam.task3.exception.ShapeException;
import edu.epam.task3.parser.ShapeParser;
import edu.epam.task3.reader.ShapeFileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class RectangleFactory {

    private static final Logger logger = LogManager.getLogger();

    public static List<Rectangle> createRectangles(String filePath) throws ShapeException {
        List<Rectangle> rectangleList = new ArrayList<>();
        List<String> points;
        List<double[]> pointsDouble;
        ShapeFileReader shapeFileReader = new ShapeFileReader();
        ShapeParser shapeParser = new ShapeParser();
        try {
            points = shapeFileReader.readPoints(filePath);
            pointsDouble = shapeParser.parseListToPointsXYArrays(points);
            for (int i = 0; i < pointsDouble.size(); i++) {
                LocalPoint firstPoint = new LocalPoint(pointsDouble.get(i)[0], pointsDouble.get(i)[1]);
                LocalPoint secondPoint = new LocalPoint(pointsDouble.get(i)[2], pointsDouble.get(i)[3]);
                LocalPoint thirdPoint = new LocalPoint(pointsDouble.get(i)[4], pointsDouble.get(i)[5]);
                LocalPoint fourthPoint = new LocalPoint(pointsDouble.get(i)[6], pointsDouble.get(i)[7]);
                Rectangle rectangle = new Rectangle(firstPoint, secondPoint, thirdPoint, fourthPoint);
                rectangleList.add(rectangle);
            }
        } catch (ShapeException e) {
            logger.error("Error in factory of rectangles: ", e);
            throw new ShapeException("Error in factory of rectangles: ", e);
        }
        return rectangleList;
    }
}
