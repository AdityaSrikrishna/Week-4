import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    public void testAdd() {
        assertEquals(10, calculator.add(6, 4));
    }

    @Test
    public void testSubtract() {
        assertEquals(2, calculator.subtract(6, 4));
    }

    @Test
    public void testMultiply() {
        assertEquals(24, calculator.multiply(6, 4));
    }

    @Test
    public void testDivide() {
        assertEquals(3, calculator.divide(12, 4));
    }

    @Test
    public void testDivideByZero() {
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            calculator.divide(10, 0);
        });
        assertEquals("Cannot divide by zero.", exception.getMessage());
    }
}
