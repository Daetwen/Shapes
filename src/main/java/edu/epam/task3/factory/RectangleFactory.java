package edu.epam.task3.factory;

import edu.epam.task3.entity.LocalPoint;
import edu.epam.task3.entity.Rectangle;

import java.util.ArrayList;
import java.util.List;

public class RectangleFactory {

    public static List<Rectangle> createRectangles(List<double[]> pointsDouble) {
        List<Rectangle> rectangleList = new ArrayList<>();
        for (int i = 0; i < pointsDouble.size(); i++) {
            LocalPoint firstPoint = new LocalPoint(pointsDouble.get(i)[0], pointsDouble.get(i)[1]);
            LocalPoint secondPoint = new LocalPoint(pointsDouble.get(i)[2], pointsDouble.get(i)[3]);
            LocalPoint thirdPoint = new LocalPoint(pointsDouble.get(i)[4], pointsDouble.get(i)[5]);
            LocalPoint fourthPoint = new LocalPoint(pointsDouble.get(i)[6], pointsDouble.get(i)[7]);
            Rectangle rectangle = new Rectangle(firstPoint, secondPoint, thirdPoint, fourthPoint);
            rectangleList.add(rectangle);
        }
        return rectangleList;
    }
}
