import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PasswordValidatorTest {

    PasswordValidator validator = new PasswordValidator();

    @Test
    public void testValidPasswords() {
        assertTrue(validator.isValid("StrongPass1"));
        assertTrue(validator.isValid("Hello123A"));
    }

    @Test
    public void testTooShortPassword() {
        assertFalse(validator.isValid("Ab1")); // Too short
    }

    @Test
    public void testNoUppercase() {
        assertFalse(validator.isValid("password1"));
    }

    @Test
    public void testNoDigit() {
        assertFalse(validator.isValid("Password"));
    }

    @Test
    public void testNullPassword() {
        assertFalse(validator.isValid(null));
    }
}