package edu.epam.task3.reader;

import edu.epam.task3.exception.ShapeException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class ShapeFileReader {

    private static final Logger logger = LogManager.getLogger();

    public List<String> readPoints(String filePath) throws ShapeException {
        List<String> infoList;
        Path path = Paths.get(filePath);
        try (Stream<String> lineStream = Files.lines(path)) {
            infoList = lineStream.collect(Collectors.toList());
            logger.info("Information read successfully.");
        } catch (IOException e) {
            logger.error("Error reading from file.", e);
            throw new ShapeException("Error reading from file.", e);
        }
        return infoList;
    }
}
