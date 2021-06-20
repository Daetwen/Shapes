package edu.epam.task3.service.impl;

import edu.epam.task3.entity.LocalPoint;
import edu.epam.task3.entity.Rectangle;
import edu.epam.task3.service.ShapeService;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class ShapeServiceImpl implements ShapeService {

    public boolean isRectangle(Rectangle rectangle) {
        LocalPoint firstLocalPoint = rectangle.getFirstPoint();
        LocalPoint secondLocalPoint = rectangle.getSecondPoint();
        LocalPoint thirdLocalPoint = rectangle.getThirdPoint();
        LocalPoint fourthLocalPoint = rectangle.getFourthPoint();
        return isRectangle(firstLocalPoint, secondLocalPoint, thirdLocalPoint, fourthLocalPoint);
    }

    public boolean isRectangle(LocalPoint firstLocalPoint,
                               LocalPoint secondLocalPoint,
                               LocalPoint thirdLocalPoint,
                               LocalPoint fourthLocalPoint) {
        boolean result = true;
        if (isThreePointsOnOneLine(firstLocalPoint, secondLocalPoint, thirdLocalPoint) ||
                isThreePointsOnOneLine(firstLocalPoint, secondLocalPoint, fourthLocalPoint) ||
                isThreePointsOnOneLine(firstLocalPoint, thirdLocalPoint, fourthLocalPoint) ||
                isThreePointsOnOneLine(secondLocalPoint, thirdLocalPoint, fourthLocalPoint)) {
            result = false;
        }
        return result;
    }

    public boolean isСonvex(Rectangle rectangle) {
        LocalPoint firstLocalPoint = rectangle.getFirstPoint();
        LocalPoint secondLocalPoint = rectangle.getSecondPoint();
        LocalPoint thirdLocalPoint = rectangle.getThirdPoint();
        LocalPoint fourthLocalPoint = rectangle.getFourthPoint();
        return isСonvex(firstLocalPoint, secondLocalPoint, thirdLocalPoint, fourthLocalPoint);
    }

    public boolean isСonvex(LocalPoint firstLocalPoint,
                            LocalPoint secondLocalPoint,
                            LocalPoint thirdLocalPoint,
                            LocalPoint fourthLocalPoint) {
        if (!isRectangle(firstLocalPoint, secondLocalPoint, thirdLocalPoint, fourthLocalPoint)) {
            return false;
        }
        return intersect (
                        firstLocalPoint.getX(),
                        thirdLocalPoint.getX(),
                        secondLocalPoint.getX(),
                        fourthLocalPoint.getX())
                && intersect (
                        firstLocalPoint.getY(),
                        thirdLocalPoint.getY(),
                        secondLocalPoint.getY(),
                        fourthLocalPoint.getY())
                && area(
                        firstLocalPoint,
                        thirdLocalPoint,
                        fourthLocalPoint)
                * area(
                        firstLocalPoint,
                        thirdLocalPoint,
                        secondLocalPoint) <= 0
                && area(
                        secondLocalPoint,
                        fourthLocalPoint,
                        firstLocalPoint)
                * area(
                        secondLocalPoint,
                        fourthLocalPoint,
                        thirdLocalPoint) <= 0;
    }

    public boolean isSquare(Rectangle rectangle) {
        LocalPoint firstLocalPoint = rectangle.getFirstPoint();
        LocalPoint secondLocalPoint = rectangle.getSecondPoint();
        LocalPoint thirdLocalPoint = rectangle.getThirdPoint();
        LocalPoint fourthLocalPoint = rectangle.getFourthPoint();
        return isSquare(firstLocalPoint, secondLocalPoint, thirdLocalPoint, fourthLocalPoint);
    }

    public boolean isSquare(LocalPoint firstLocalPoint,
                            LocalPoint secondLocalPoint,
                            LocalPoint thirdLocalPoint,
                            LocalPoint fourthLocalPoint) {
        if (!isRectangle(firstLocalPoint, secondLocalPoint, thirdLocalPoint, fourthLocalPoint)) {
            return false;
        }
        boolean result = false;
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

        MathContext context = new MathContext(10, RoundingMode.HALF_UP);
        BigDecimal diagonal = new BigDecimal(Math.sqrt(Math.pow(firstSide, 2) + Math.pow(secondSide, 2)), context);
        BigDecimal shapeDiagonal = new BigDecimal(Math.sqrt(2) * firstSide, context);

        if (firstSide == secondSide && firstSide == thirdSide && firstSide == fourthSide
                && diagonal.equals(shapeDiagonal)) {
            result = true;
        }
        return result;
    }

    public boolean isRhombus(Rectangle rectangle) {
        LocalPoint firstLocalPoint = rectangle.getFirstPoint();
        LocalPoint secondLocalPoint = rectangle.getSecondPoint();
        LocalPoint thirdLocalPoint = rectangle.getThirdPoint();
        LocalPoint fourthLocalPoint = rectangle.getFourthPoint();
        return isRhombus(firstLocalPoint, secondLocalPoint, thirdLocalPoint, fourthLocalPoint);
    }

    public boolean isRhombus(LocalPoint firstLocalPoint,
                             LocalPoint secondLocalPoint,
                             LocalPoint thirdLocalPoint,
                             LocalPoint fourthLocalPoint) {
        if (!isRectangle(firstLocalPoint, secondLocalPoint, thirdLocalPoint, fourthLocalPoint)) {
            return false;
        }
        boolean result = false;
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

        if (firstSide == secondSide && firstSide == thirdSide && firstSide == fourthSide
                && isParallelogram(firstLocalPoint, secondLocalPoint, thirdLocalPoint, fourthLocalPoint)) {
            result = true;
        }
        return result;
    }

    public boolean isTrapezoid(Rectangle rectangle) {
        LocalPoint firstLocalPoint = rectangle.getFirstPoint();
        LocalPoint secondLocalPoint = rectangle.getSecondPoint();
        LocalPoint thirdLocalPoint = rectangle.getThirdPoint();
        LocalPoint fourthLocalPoint = rectangle.getFourthPoint();
        return isTrapezoid(firstLocalPoint, secondLocalPoint, thirdLocalPoint, fourthLocalPoint);
    }

    public boolean isTrapezoid(LocalPoint firstLocalPoint,
                               LocalPoint secondLocalPoint,
                               LocalPoint thirdLocalPoint,
                               LocalPoint fourthLocalPoint) {
        if (!isRectangle(firstLocalPoint, secondLocalPoint, thirdLocalPoint, fourthLocalPoint) ||
            !isСonvex(firstLocalPoint, secondLocalPoint, thirdLocalPoint, fourthLocalPoint)) {
            return false;
        }
        boolean result = false;
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
        if ((isParallel(firstLocalPoint, secondLocalPoint, thirdLocalPoint, fourthLocalPoint) && secondSide != fourthSide) ||
                (isParallel(secondLocalPoint, thirdLocalPoint, firstLocalPoint, fourthLocalPoint) && firstSide != thirdSide)) {
            result = true;
        }
        return result;
    }

    public boolean isParallelogram(Rectangle rectangle) {
        LocalPoint firstLocalPoint = rectangle.getFirstPoint();
        LocalPoint secondLocalPoint = rectangle.getSecondPoint();
        LocalPoint thirdLocalPoint = rectangle.getThirdPoint();
        LocalPoint fourthLocalPoint = rectangle.getFourthPoint();
        return isParallelogram(firstLocalPoint, secondLocalPoint, thirdLocalPoint, fourthLocalPoint);
    }

    public boolean isParallelogram(LocalPoint firstLocalPoint,
                                   LocalPoint secondLocalPoint,
                                   LocalPoint thirdLocalPoint,
                                   LocalPoint fourthLocalPoint) {
        if (!isRectangle(firstLocalPoint, secondLocalPoint, thirdLocalPoint, fourthLocalPoint)) {
            return false;
        }
        boolean result = false;
        if (Math.abs(firstLocalPoint.getY() - fourthLocalPoint.getY())
                == Math.abs(secondLocalPoint.getY() - thirdLocalPoint.getY()) &&
                Math.abs(firstLocalPoint.getX() - secondLocalPoint.getX())
                == Math.abs(fourthLocalPoint.getX() - thirdLocalPoint.getX())) {
            result = true;
        }
        return result;
    }

    private boolean isThreePointsOnOneLine(LocalPoint firstLocalPoint,
                                           LocalPoint secondLocalPoint,
                                           LocalPoint thirdLocalPoint) {
        boolean result = firstLocalPoint.getX() == secondLocalPoint.getX()
                && firstLocalPoint.getX() == thirdLocalPoint.getX()
                && firstLocalPoint.getY() == secondLocalPoint.getY()
                && firstLocalPoint.getY() == thirdLocalPoint.getY();
        return result;
    }

    private double area(LocalPoint a, LocalPoint b, LocalPoint c) {
        return (b.getX() - a.getX()) * (c.getY() - a.getY()) - (b.getY() - a.getY()) * (c.getX() - a.getX());
    }

    private boolean intersect(double a, double b, double c, double d) {
        double temp;
        if (a > b)  {
            temp = a;
            a = b;
            b = temp;
        }
        if (c > d)  {
            temp = c;
            c = d;
            d = temp;
        }
        return Math.max(a,c) <= Math.min(b,d);
    }

    private boolean isParallel(LocalPoint firstPoint,
                               LocalPoint secondPoint,
                               LocalPoint thirdPoint,
                               LocalPoint fourthPoint) {
        boolean result = false;
        double firstSegmentA = firstPoint.getY() - secondPoint.getY();
        double firstSegmentB = secondPoint.getX() - firstPoint.getX();
        double secondSegmentA = thirdPoint.getY() - fourthPoint.getY();
        double secondSegmentB = thirdPoint.getX() - fourthPoint.getX();
        if (firstSegmentA * firstSegmentB - secondSegmentA * secondSegmentB == 0) {
            result = true;
        }
        return result;
    }
}
