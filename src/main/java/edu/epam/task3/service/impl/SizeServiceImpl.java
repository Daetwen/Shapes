package edu.epam.task3.service.impl;

import edu.epam.task3.entity.LocalPoint;
import edu.epam.task3.entity.Rectangle;
import edu.epam.task3.exception.ShapeException;
import edu.epam.task3.service.SizeService;
import edu.epam.task3.validator.ShapeValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SizeServiceImpl implements SizeService {

    private static Logger logger = LogManager.getLogger();

    public double calculatePerimeter(Rectangle rectangle) throws ShapeException {
        if (rectangle ==  null) {
            logger.error("Invalid rectangle for calculation perimeter. ");
            throw new ShapeException("Invalid rectangle for calculation perimeter. ");
        }
        LocalPoint firstLocalPoint = rectangle.getFirstPoint();
        LocalPoint secondLocalPoint = rectangle.getSecondPoint();
        LocalPoint thirdLocalPoint = rectangle.getThirdPoint();
        LocalPoint fourthLocalPoint = rectangle.getFourthPoint();
        return calculatePerimeter(firstLocalPoint, secondLocalPoint, thirdLocalPoint, fourthLocalPoint);
    }

    public double calculatePerimeter(LocalPoint firstLocalPoint,
                                     LocalPoint secondLocalPoint,
                                     LocalPoint thirdLocalPoint,
                                     LocalPoint fourthLocalPoint) throws ShapeException{
        if (!ShapeValidator.checkIsPointsValid(firstLocalPoint,
                                              secondLocalPoint,
                                              thirdLocalPoint,
                                              fourthLocalPoint)) {
            logger.error("Error in one or more points in calculate.");
            throw new ShapeException("Error in one or more points in calculate.");
        }
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

    public double calculateArea(Rectangle rectangle) throws ShapeException {
        if (rectangle ==  null) {
            logger.error("Invalid rectangle for calculation area. ");
            throw new ShapeException("Invalid rectangle for calculation area. ");
        }
        LocalPoint firstLocalPoint = rectangle.getFirstPoint();
        LocalPoint secondLocalPoint = rectangle.getSecondPoint();
        LocalPoint thirdLocalPoint = rectangle.getThirdPoint();
        LocalPoint fourthLocalPoint = rectangle.getFourthPoint();
        return calculateArea(firstLocalPoint, secondLocalPoint, thirdLocalPoint, fourthLocalPoint);
    }

    public double calculateArea(LocalPoint firstLocalPoint,
                                LocalPoint secondLocalPoint,
                                LocalPoint thirdLocalPoint,
                                LocalPoint fourthLocalPoint) throws ShapeException {
        if (!ShapeValidator.checkIsPointsValid(firstLocalPoint,
                                              secondLocalPoint,
                                              thirdLocalPoint,
                                              fourthLocalPoint)) {
            logger.error("Error in one or more points in calculate.");
            throw new ShapeException("Error in one or more points in calculate.");
        }
        double result = 0;
        double part1 = 0;
        double part2;
        part1 = Math.abs(
                (firstLocalPoint.getX() - thirdLocalPoint.getX())
                        * (secondLocalPoint.getY() - thirdLocalPoint.getY())
                        - (secondLocalPoint.getX() - thirdLocalPoint.getX())
                        * (firstLocalPoint.getY() - thirdLocalPoint.getY())) / 2;
        part2 = Math.abs(
                (firstLocalPoint.getX() - fourthLocalPoint.getX())
                        * (thirdLocalPoint.getY() - fourthLocalPoint.getY())
                        - (thirdLocalPoint.getX() - fourthLocalPoint.getX())
                        * (firstLocalPoint.getY() - fourthLocalPoint.getY())) / 2;
        if (fourthLocalPoint.getX() <= thirdLocalPoint.getX()
                && fourthLocalPoint.getY() >= thirdLocalPoint.getY()
                || secondLocalPoint.getX() <= thirdLocalPoint.getX()
                && secondLocalPoint.getX() >= firstLocalPoint.getX()
                && secondLocalPoint.getY() < thirdLocalPoint.getY()
                || secondLocalPoint.getX() >= thirdLocalPoint.getX()
                && secondLocalPoint.getX() >= firstLocalPoint.getX()
                && secondLocalPoint.getY() < thirdLocalPoint.getY()) {
            result = Math.abs(part1 - part2);
        } else {
            result = part1 + part2;
        }
        return result;
    }
}
