import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NumberUtilsTest {

    NumberUtils utils = new NumberUtils();

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6})
    public void testEvenNumbers(int number) {
        assertTrue(utils.isEven(number), number + " should be even.");
    }

    @ParameterizedTest
    @ValueSource(ints = {7, 9, 13})
    public void testOddNumbers(int number) {
        assertFalse(utils.isEven(number), number + " should be odd.");
    }
}