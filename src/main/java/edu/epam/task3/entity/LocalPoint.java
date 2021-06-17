package edu.epam.task3.entity;

public class LocalPoint {

    private double x;
    private double y;

    public LocalPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        LocalPoint localPoint = (LocalPoint) obj;
        return x == localPoint.x && y == localPoint.y;
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;

        result = result * prime + Double.hashCode(x);
        result = result * prime + Double.hashCode(y);

        return result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Point{")
                .append(x)
                .append(", ")
                .append(y)
                .append("}");
        return stringBuilder.toString();
    }
}
