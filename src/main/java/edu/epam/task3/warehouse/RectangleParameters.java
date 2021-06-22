package edu.epam.task3.warehouse;

public class RectangleParameters {
    private double perimeter;
    private double area;

    public double getPerimeter() {
        return perimeter;
    }

    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RectangleParameters that = (RectangleParameters) obj;
        return Double.compare(that.perimeter, perimeter) == 0
                && Double.compare(that.area, area) == 0;
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;

        result = result * prime + Double.hashCode(perimeter);
        result = result * prime + Double.hashCode(area);

        return result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RectangleParameters{ perimeter = ")
                .append(perimeter)
                .append(", area = ")
                .append(area)
                .append("}\n");
        return stringBuilder.toString();
    }
}
