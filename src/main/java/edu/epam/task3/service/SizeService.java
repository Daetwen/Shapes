package edu.epam.task3.service;

import edu.epam.task3.entity.LocalPoint;
import edu.epam.task3.entity.Rectangle;

public interface SizeService {

    double calculatePerimeter(Rectangle rectangle);

    double calculatePerimeter(LocalPoint firstLocalPoint,
                              LocalPoint secondLocalPoint,
                              LocalPoint thirdLocalPoint,
                              LocalPoint fourthLocalPoint);

    double calculateArea(Rectangle rectangle);

    double calculateArea(LocalPoint firstLocalPoint,
                         LocalPoint secondLocalPoint,
                         LocalPoint thirdLocalPoint,
                         LocalPoint fourthLocalPoint);
}
