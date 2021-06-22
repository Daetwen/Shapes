package edu.epam.task3.observer;

public interface RectangleObservable {

    void attach(RectangleObserver rectangleObserver);

    void detach(RectangleObserver rectangleObserver);

    void notifyObservers();
}
