package edu.epam.task3.repository;

import edu.epam.task3.entity.Rectangle;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public interface RectangleRepository {

    boolean add(Rectangle rectangle);

    boolean addAll(Collection<? extends Rectangle> collection);

    boolean remove(Rectangle rectangle);

    boolean removeAll(Collection<?> collection);

    void clear();

    Rectangle get(int index);

    List<Rectangle> getAll();

    Rectangle set(int index, Rectangle element);

    int size();

    boolean isEmpty();

    List<Rectangle> sort(Comparator<? super Rectangle> comparator);

    List<Rectangle> query(RectangleSpecification specification);

    List<Rectangle> query(Predicate<Rectangle> specification);

    List<Rectangle> queryCycle(RectangleSpecification specification);
}
