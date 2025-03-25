import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DateFormatterTest {

    DateFormatter formatter = new DateFormatter();

    @Test
    public void testValidDate() {
        assertEquals("25-12-2024", formatter.formatDate("2024-12-25"));
        assertEquals("01-01-2023", formatter.formatDate("2023-01-01"));
    }

    @Test
    public void testInvalidDateFormat() {
        assertEquals("Invalid date format", formatter.formatDate("25/12/2024"));
        assertEquals("Invalid date format", formatter.formatDate("12-25-2024"));
        assertEquals("Invalid date format", formatter.formatDate("not-a-date"));
    }

    @Test
    public void testEmptyString() {
        assertEquals("Invalid date format", formatter.formatDate(""));
    }

    @Test
    public void testNullInput() {
        assertThrows(NullPointerException.class, () -> {
            formatter.formatDate(null);
        });
    }
}