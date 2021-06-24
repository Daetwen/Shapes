package edu.epam.task3.service;

import edu.epam.task3.entity.LocalPoint;
import edu.epam.task3.entity.Rectangle;
import edu.epam.task3.exception.ShapeException;

public interface SizeService {

    double calculatePerimeter(Rectangle rectangle) throws ShapeException;

    double calculatePerimeter(LocalPoint firstLocalPoint,
                              LocalPoint secondLocalPoint,
                              LocalPoint thirdLocalPoint,
                              LocalPoint fourthLocalPoint) throws ShapeException;

    double calculateArea(Rectangle rectangle) throws ShapeException;

    double calculateArea(LocalPoint firstLocalPoint,
                         LocalPoint secondLocalPoint,
                         LocalPoint thirdLocalPoint,
                         LocalPoint fourthLocalPoint) throws ShapeException;
}
