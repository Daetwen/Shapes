package edu.epam.task3.service;

import edu.epam.task3.entity.LocalPoint;
import edu.epam.task3.entity.Rectangle;

public interface ShapeService {

    boolean isRectangle(Rectangle rectangle);

    boolean isRectangle(LocalPoint firstLocalPoint,
                        LocalPoint secondLocalPoint,
                        LocalPoint thirdLocalPoint,
                        LocalPoint fourthLocalPoint);

    boolean isСonvex(Rectangle rectangle);

    boolean isСonvex(LocalPoint firstLocalPoint,
                     LocalPoint secondLocalPoint,
                     LocalPoint thirdLocalPoint,
                     LocalPoint fourthLocalPoint);

    boolean isSquare(Rectangle rectangle);

    boolean isSquare(LocalPoint firstLocalPoint,
                     LocalPoint secondLocalPoint,
                     LocalPoint thirdLocalPoint,
                     LocalPoint fourthLocalPoint);

    boolean isRhombus(Rectangle rectangle);

    boolean isRhombus(LocalPoint firstLocalPoint,
                      LocalPoint secondLocalPoint,
                      LocalPoint thirdLocalPoint,
                      LocalPoint fourthLocalPoint);

    boolean isTrapezoid(Rectangle rectangle);

    boolean isTrapezoid(LocalPoint firstLocalPoint,
                        LocalPoint secondLocalPoint,
                        LocalPoint thirdLocalPoint,
                        LocalPoint fourthLocalPoint);

    boolean isParallelogram(Rectangle rectangle);

    boolean isParallelogram(LocalPoint firstLocalPoint,
                            LocalPoint secondLocalPoint,
                            LocalPoint thirdLocalPoint,
                            LocalPoint fourthLocalPoint);
}
