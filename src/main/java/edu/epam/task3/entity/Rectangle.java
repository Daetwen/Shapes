package edu.epam.task3.entity;

import edu.epam.task3.util.ShapeID;

import java.util.Objects;

public class Rectangle {
    private long id;
    private LocalPoint firstLocalPoint;
    private LocalPoint secondLocalPoint;
    private LocalPoint thirdLocalPoint;
    private LocalPoint fourthLocalPoint;

    public Rectangle() {
        this.id = ShapeID.generateID();
        this.firstLocalPoint = new LocalPoint(0,0);
        this.secondLocalPoint = new LocalPoint(0,0);
        this.thirdLocalPoint = new LocalPoint(0,0);
        this.fourthLocalPoint = new LocalPoint(0,0);
    }

    public Rectangle(LocalPoint firstLocalPoint, LocalPoint secondLocalPoint, LocalPoint thirdLocalPoint, LocalPoint fourthLocalPoint) {
        this.id = ShapeID.generateID();
        this.firstLocalPoint = firstLocalPoint;
        this.secondLocalPoint = secondLocalPoint;
        this.thirdLocalPoint = thirdLocalPoint;
        this.fourthLocalPoint = fourthLocalPoint;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalPoint getFirstPoint() {
        return firstLocalPoint;
    }

    public void setFirstPoint(LocalPoint firstLocalPoint) {
        this.firstLocalPoint = firstLocalPoint;
    }

    public LocalPoint getSecondPoint() {
        return secondLocalPoint;
    }

    public void setSecondPoint(LocalPoint secondLocalPoint) {
        this.secondLocalPoint = secondLocalPoint;
    }

    public LocalPoint getThirdPoint() {
        return thirdLocalPoint;
    }

    public void setThirdPoint(LocalPoint thirdLocalPoint) {
        this.thirdLocalPoint = thirdLocalPoint;
    }

    public LocalPoint getFourthPoint() {
        return fourthLocalPoint;
    }

    public void setFourthPoint(LocalPoint fourthLocalPoint) {
        this.fourthLocalPoint = fourthLocalPoint;
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
        return id == rectangle.id
                && Objects.equals(firstLocalPoint, rectangle.firstLocalPoint)
                && Objects.equals(secondLocalPoint, rectangle.secondLocalPoint)
                && Objects.equals(thirdLocalPoint, rectangle.thirdLocalPoint)
                && Objects.equals(fourthLocalPoint, rectangle.fourthLocalPoint);
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;

        result = result * prime + Long.hashCode(id);
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
                .append(id)
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
}
