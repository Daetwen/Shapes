package edu.epam.task3.entity;

import edu.epam.task3.observer.RectangleEvent;
import edu.epam.task3.observer.RectangleObservable;
import edu.epam.task3.observer.RectangleObserver;
import edu.epam.task3.util.ShapeID;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Rectangle implements RectangleObservable {
    private long rectangleID;
    private LocalPoint firstLocalPoint;
    private LocalPoint secondLocalPoint;
    private LocalPoint thirdLocalPoint;
    private LocalPoint fourthLocalPoint;
    private List<RectangleObserver> observerList = new ArrayList<>();

    public Rectangle() {
        this.rectangleID = ShapeID.generateID();
        this.firstLocalPoint = new LocalPoint(0,0);
        this.secondLocalPoint = new LocalPoint(0,0);
        this.thirdLocalPoint = new LocalPoint(0,0);
        this.fourthLocalPoint = new LocalPoint(0,0);
    }

    public Rectangle(double pointX1, double pointY1,
                     double pointX2, double pointY2,
                     double pointX3, double pointY3,
                     double pointX4, double pointY4) {
        this.rectangleID = ShapeID.generateID();
        this.firstLocalPoint = new LocalPoint(pointX1, pointY1);
        this.secondLocalPoint = new LocalPoint(pointX2, pointY2);
        this.thirdLocalPoint = new LocalPoint(pointX3, pointY3);
        this.fourthLocalPoint = new LocalPoint(pointX4, pointY4);
    }

    public Rectangle(LocalPoint firstLocalPoint,
                     LocalPoint secondLocalPoint,
                     LocalPoint thirdLocalPoint,
                     LocalPoint fourthLocalPoint) {
        this.rectangleID = ShapeID.generateID();
        this.firstLocalPoint = firstLocalPoint;
        this.secondLocalPoint = secondLocalPoint;
        this.thirdLocalPoint = thirdLocalPoint;
        this.fourthLocalPoint = fourthLocalPoint;
    }

    public long getRectangleID() {
        return rectangleID;
    }

    public LocalPoint getFirstPoint() {
        return firstLocalPoint;
    }

    public void setFirstPoint(LocalPoint firstLocalPoint) {
        this.firstLocalPoint = firstLocalPoint;
        notifyObservers();
    }

    public LocalPoint getSecondPoint() {
        return secondLocalPoint;
    }

    public void setSecondPoint(LocalPoint secondLocalPoint) {
        this.secondLocalPoint = secondLocalPoint;
        notifyObservers();
    }

    public LocalPoint getThirdPoint() {
        return thirdLocalPoint;
    }

    public void setThirdPoint(LocalPoint thirdLocalPoint) {
        this.thirdLocalPoint = thirdLocalPoint;
        notifyObservers();
    }

    public LocalPoint getFourthPoint() {
        return fourthLocalPoint;
    }

    public void setFourthPoint(LocalPoint fourthLocalPoint) {
        this.fourthLocalPoint = fourthLocalPoint;
        notifyObservers();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Rectangle rectangle = (Rectangle) obj;
        return Objects.equals(firstLocalPoint, rectangle.firstLocalPoint)
                && Objects.equals(secondLocalPoint, rectangle.secondLocalPoint)
                && Objects.equals(thirdLocalPoint, rectangle.thirdLocalPoint)
                && Objects.equals(fourthLocalPoint, rectangle.fourthLocalPoint);
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;

        result = result * prime + firstLocalPoint.hashCode();
        result = result * prime + secondLocalPoint.hashCode();
        result = result * prime + thirdLocalPoint.hashCode();
        result = result * prime + fourthLocalPoint.hashCode();

        return result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Rectangle: (id = ")
                .append(rectangleID)
                .append(") [")
                .append(firstLocalPoint)
                .append(", ")
                .append(secondLocalPoint)
                .append(", ")
                .append(thirdLocalPoint)
                .append(", ")
                .append(fourthLocalPoint)
                .append("]\n");
        return stringBuilder.toString();
    }

    @Override
    public void attach(RectangleObserver rectangleObserver) {
        observerList.add(rectangleObserver);
    }

    @Override
    public void detach(RectangleObserver rectangleObserver) {
        observerList.remove(rectangleObserver);
    }

    @Override
    public void notifyObservers() {
        RectangleEvent rectangleEvent = new RectangleEvent(this);
        if (!observerList.isEmpty()) {
            for(var observer : observerList) {
                observer.updatePerimeterAndArea(rectangleEvent);
            }
        }
    }
}
