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

    private boolean isThreePointsOnOneLine(LocalPoint firstLocalPoint,
                                           LocalPoint secondLocalPoint,
                                           LocalPoint thirdLocalPoint) {
        boolean result = firstLocalPoint.getX() == secondLocalPoint.getX()
                      && firstLocalPoint.getX() == thirdLocalPoint.getX()
                      && firstLocalPoint.getY() == secondLocalPoint.getY()
                      && firstLocalPoint.getY() == thirdLocalPoint.getY();
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
        boolean result = true;
        return result;
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
        if (!isRectangle(firstLocalPoint, secondLocalPoint, thirdLocalPoint, fourthLocalPoint)) {
            return false;
        }
        boolean result = false;
        double scale = Math.pow(10, 10);
        if(Math.round((firstLocalPoint.getY() - secondLocalPoint.getY()) / (firstLocalPoint.getX() - secondLocalPoint.getX()) * scale) / scale
                == Math.round((firstLocalPoint.getY() - thirdLocalPoint.getY()) / (firstLocalPoint.getX() - thirdLocalPoint.getX()) * scale) / scale
                || Math.round((firstLocalPoint.getY() - secondLocalPoint.getY()) / (firstLocalPoint.getX() - secondLocalPoint.getX()) * scale) / scale
                == Math.round((firstLocalPoint.getY() - fourthLocalPoint.getY()) / (firstLocalPoint.getX() - fourthLocalPoint.getX()) * scale) / scale
                || Math.round((firstLocalPoint.getY() - secondLocalPoint.getY()) / (firstLocalPoint.getX() - secondLocalPoint.getX()) * scale) / scale
                == Math.round((secondLocalPoint.getY() - thirdLocalPoint.getY()) / (secondLocalPoint.getX() - thirdLocalPoint.getX()) * scale) / scale
                || Math.round((firstLocalPoint.getY() - secondLocalPoint.getY()) / (firstLocalPoint.getX() - secondLocalPoint.getX()) * scale) / scale
                == Math.round((secondLocalPoint.getY() - fourthLocalPoint.getY()) / (secondLocalPoint.getX() - fourthLocalPoint.getX()) * scale) / scale
                || Math.round((firstLocalPoint.getY() - secondLocalPoint.getY()) / (firstLocalPoint.getX() - secondLocalPoint.getX()) * scale) / scale
                == Math.round((thirdLocalPoint.getY() - fourthLocalPoint.getY()) / (thirdLocalPoint.getX() - fourthLocalPoint.getX()) * scale) / scale
                || Math.round((secondLocalPoint.getY() - thirdLocalPoint.getY()) / (secondLocalPoint.getX() - thirdLocalPoint.getX()) * scale) / scale
                == Math.round((secondLocalPoint.getY() - fourthLocalPoint.getY()) / (secondLocalPoint.getX() - fourthLocalPoint.getX()) * scale) / scale
                || Math.round((secondLocalPoint.getY() - thirdLocalPoint.getY()) / (secondLocalPoint.getX() - thirdLocalPoint.getX()) * scale) / scale
                == Math.round((thirdLocalPoint.getY() - fourthLocalPoint.getY()) / (thirdLocalPoint.getX() - fourthLocalPoint.getX()) * scale) / scale
                || Math.round((secondLocalPoint.getY() - fourthLocalPoint.getY()) / (secondLocalPoint.getX() - fourthLocalPoint.getX()) * scale) / scale
                == Math.round((thirdLocalPoint.getY() - fourthLocalPoint.getY()) / (thirdLocalPoint.getX() - fourthLocalPoint.getX()) * scale) / scale) {
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
}
