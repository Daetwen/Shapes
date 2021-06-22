package edu.epam.task3.observer;

import edu.epam.task3.entity.Rectangle;

import java.util.EventObject;

public class RectangleEvent extends EventObject {

    public RectangleEvent(Object source) {
        super(source);
    }

    public Rectangle getSource() {
        return (Rectangle) super.getSource();
    }
}
