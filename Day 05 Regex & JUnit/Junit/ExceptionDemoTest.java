import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ExceptionDemoTest {

    ExceptionDemo demo = new ExceptionDemo();

    @Test
    public void testDivideValid() {
        assertEquals(5, demo.divide(10, 2));
    }

    @Test
    public void testDivideByZeroThrowsException() {
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> {
            demo.divide(10, 0);
        });
        assertEquals("Cannot divide by zero.", exception.getMessage());
    }
}