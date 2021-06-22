package edu.epam.task3.parser;

import edu.epam.task3.exception.ShapeException;
import edu.epam.task3.validator.ShapeValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShapeParser {
    private static final Logger logger = LogManager.getLogger();
    private static final String SPLIT_REGEX = "\\s+";
    private static final int NUMBERS_COUNT = 8;

    public List<double[]> parseListToPointsXYArrays(List<String> array) throws ShapeException {
        List<double[]> result = new ArrayList<>();
        if (array != null && !array.isEmpty()) {
            int i = -1;
            while (++i < array.size()) {
                if (ShapeValidator.checkIsStringArrayValid(array.get(i))) {
                    double[] numArray = Arrays.stream(array.get(i).split(SPLIT_REGEX))
                            .mapToDouble(Double::parseDouble)
                            .toArray();
                    if (numArray.length == NUMBERS_COUNT) {
                        result.add(numArray);
                    }
                }
            }
        } else {
            logger.error("Invalid List of string for parsing.");
            throw new ShapeException("Invalid List of string for parsing.");
        }
        return result;
    }
}
