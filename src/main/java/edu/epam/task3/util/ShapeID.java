package edu.epam.task3.util;

public class ShapeID {
    private static long counter = 0;

    private ShapeID() {
    }

    public static long generateID() {
        return ++counter;
    }
}
