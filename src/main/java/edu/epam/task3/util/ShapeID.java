package edu.epam.task3.util;

public class ShapeID {
    private static long counter = 0;

    public static long generateID() {
        return ++counter;
    }
}
