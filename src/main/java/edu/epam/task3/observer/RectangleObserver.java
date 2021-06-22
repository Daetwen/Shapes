package edu.epam.task3.observer;

public interface RectangleObserver {

    void updateArea(RectangleEvent rectangleEvent);

    void updatePerimeter(RectangleEvent rectangleEvent);

    void updatePerimeterAndArea(RectangleEvent rectangleEvent);
}
