package edu.epam.task3.repository.impl;

import edu.epam.task3.entity.Rectangle;
import edu.epam.task3.repository.RectangleRepository;
import edu.epam.task3.repository.RectangleSpecification;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class RectangleRepositoryImpl implements RectangleRepository {

    private List<Rectangle> rectangleList = new ArrayList<>();

    public boolean add(Rectangle rectangle) {
        return rectangleList.add(rectangle);
    }

    public boolean addAll(Collection<? extends Rectangle> collection) {
        return rectangleList.addAll(collection);
    }

    public boolean remove(Rectangle rectangle) {
        return rectangleList.remove(rectangle);
    }

    public boolean removeAll(Collection<?> collection) {
        return rectangleList.removeAll(collection);
    }

    public void clear() {
        rectangleList.clear();
    }

    public Rectangle get(int index) {
        return rectangleList.get(index);
    }

    public List<Rectangle> getAll() {
        List<Rectangle> result = new ArrayList<>(rectangleList);
        return result;
    }

    public Rectangle set(int index, Rectangle element) {
        return rectangleList.set(index, element);
    }

    public int size() {
        return rectangleList.size();
    }

    public boolean isEmpty() {
        return rectangleList.isEmpty();
    }

    public List<Rectangle> sort(Comparator<? super Rectangle> comparator) {
        List<Rectangle> rectangleListCopy = new ArrayList<>(rectangleList);
        rectangleListCopy.sort(comparator);
        return rectangleListCopy;
    }

    public List<Rectangle> query(RectangleSpecification specification) {
        List<Rectangle> result = rectangleList.stream()
                .filter(element -> specification.specify(element))
                .collect(Collectors.toList());
        //С java16, у меня сейчас стоит 15 (если на 16, то можно попробовать). Возвращает неизменяемый список
        //List<Rectangle> result = rectangleList.stream().filter(element -> specification.test(element)).toList();
        return result;
    }

    public List<Rectangle> query(Predicate<Rectangle> specification) {
        List<Rectangle> result = rectangleList.stream()
                .filter(element -> specification.test(element))
                .collect(Collectors.toList());
        return result;
    }

    public List<Rectangle> queryCycle(RectangleSpecification specification) {
        List<Rectangle> result = new ArrayList<>();
        for (var element : rectangleList) {
            if (specification.specify(element)) {
                result.add(element);
            }
        }
        return result;
    }
}
