package reader;

import edu.epam.task3.exception.ShapeException;
import edu.epam.task3.reader.ShapeFileReader;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class ShapeFileReaderTest {
    private static String FILE_PATH_1 = "src/test/resources/info.txt";
    private static String FILE_PATH_2 = "src/test/resources/info2.txt";
    private final ShapeFileReader shapeFileReader = new ShapeFileReader();
    private List<String> infoList1;
    private List<String> infoList2;

    @BeforeClass
    public void setUp() {
        infoList1 = new ArrayList<>();
        infoList1.add("3.0 3.0 3.0 6.0 6.0 6.0 6.0 3.0");
        infoList1.add("3.0j 3.0 3.0 6.0j 6.0 6.0 6.0g 3.0");
        infoList1.add("8.0 3.0 9.0 4.0 12.0 3.0 11.0 2.0");
        infoList1.add("3.0 3.0 3.0 6.0 6.0");
        infoList1.add("1.0 7.0 2.0 9.0 4.0 9.0 6.0 7.0");
        infoList1.add("11.0 4.0 10.0 6.0 11.0 8.0 12.0 6.0");

        infoList2 = new ArrayList<>();
        infoList2.add("3.0 3.0 3.0 6.0 6.0 6.0 6.0 3.0");
        infoList2.add("3.0j 3.0 3.0 6.0j 6.0 6.0 6.0g 3.0");
        infoList2.add("8.0 3.0 9.0 4.0 12.0 3.0 11.0 2.0");
        infoList2.add("3.0 3.0 3.0 6.0 6.0");
        infoList2.add("1.0 7.0 2.0 9.0 4.0 9.0 6.0 7.0");
        infoList2.add("11.0 4.0 10.0 6.0 11.0 8.0 12.0 6.0");
        infoList2.add("3.0 3.0 3.0 6.0 6.0");
        infoList2.add("10.0 7j.0 2,0 9.0 4.0 9.0 6.0 7.0");
        infoList2.add("12.0 4.0 10.0 8.0 1.0 8.0 12.0 6.0");
    }

    @Test
    public void readPointsPositiveTest1() throws ShapeException {
        List<String> expected = infoList1;
        List<String> actual = shapeFileReader.readPoints(FILE_PATH_1);
        assertEquals(actual, expected);
    }

    @Test
    public void readPointsPositiveTest2() throws ShapeException{
        List<String> expected = infoList2;
        List<String> actual = shapeFileReader.readPoints(FILE_PATH_2);
        assertEquals(actual, expected);
    }

    @Test
    public void readPointsNegativeTest() {
        assertThrows(ShapeException.class, () -> shapeFileReader.readPoints("something"));
    }
}
