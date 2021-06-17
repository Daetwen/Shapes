package edu.epam.task3.service.impl;

import edu.epam.task3.entity.LocalPoint;
import edu.epam.task3.entity.Rectangle;
import edu.epam.task3.service.SizeService;

public class SizeServiceImpl implements SizeService {

    public double calculatePerimeter(Rectangle rectangle) {
        LocalPoint firstLocalPoint = rectangle.getFirstPoint();
        LocalPoint secondLocalPoint = rectangle.getSecondPoint();
        LocalPoint thirdLocalPoint = rectangle.getThirdPoint();
        LocalPoint fourthLocalPoint = rectangle.getFourthPoint();
        return calculatePerimeter(firstLocalPoint, secondLocalPoint, thirdLocalPoint, fourthLocalPoint);
    }

    public double calculatePerimeter(LocalPoint firstLocalPoint,
                                     LocalPoint secondLocalPoint,
                                     LocalPoint thirdLocalPoint,
                                     LocalPoint fourthLocalPoint) {
        double positionX = firstLocalPoint.getX() - secondLocalPoint.getX();
        double positionY = firstLocalPoint.getY() - secondLocalPoint.getY();
        double firstSide = Math.abs(Math.sqrt(Math.pow(positionX, 2) + Math.pow(positionY, 2)));
        positionX = secondLocalPoint.getX() - thirdLocalPoint.getX();
        positionY = secondLocalPoint.getY() - thirdLocalPoint.getY();
        double secondSide = Math.abs(Math.sqrt(Math.pow(positionX, 2) + Math.pow(positionY, 2)));
        positionX = thirdLocalPoint.getX() - fourthLocalPoint.getX();
        positionY = thirdLocalPoint.getY() - fourthLocalPoint.getY();
        double thirdSide = Math.abs(Math.sqrt(Math.pow(positionX, 2) + Math.pow(positionY, 2)));
        positionX = fourthLocalPoint.getX() - firstLocalPoint.getX();
        positionY = fourthLocalPoint.getY() - firstLocalPoint.getY();
        double fourthSide = Math.abs(Math.sqrt(Math.pow(positionX, 2) + Math.pow(positionY, 2)));
        return firstSide + secondSide +thirdSide + fourthSide;
    }

    public double calculateArea(Rectangle rectangle) {
        double result = 0;
        return result;
    }

    public double calculateArea(LocalPoint firstLocalPoint,
                                LocalPoint secondLocalPoint,
                                LocalPoint thirdLocalPoint,
                                LocalPoint fourthLocalPoint) {
        double result = 0;
        return result;
    }
}
