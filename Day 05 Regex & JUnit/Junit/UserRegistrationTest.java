import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class UserRegistrationTest {

    UserRegistration registration = new UserRegistration();

    @Test
    public void testValidRegistration() {
        assertDoesNotThrow(() -> 
            registration.registerUser("john_doe", "john@example.com", "Secure123")
        );
    }

    @Test
    public void testEmptyUsername() {
        Exception ex = assertThrows(IllegalArgumentException.class, () ->
            registration.registerUser("", "john@example.com", "Secure123")
        );
        assertEquals("Username cannot be empty", ex.getMessage());
    }

    @Test
    public void testInvalidEmail() {
        Exception ex = assertThrows(IllegalArgumentException.class, () ->
            registration.registerUser("john", "invalid-email", "Secure123")
        );
        assertEquals("Invalid email format", ex.getMessage());
    }

    @Test
    public void testShortPassword() {
        Exception ex = assertThrows(IllegalArgumentException.class, () ->
            registration.registerUser("john", "john@example.com", "123")
        );
        assertEquals("Password must be at least 8 characters", ex.getMessage());
    }

    @Test
    public void testNullValues() {
        assertThrows(IllegalArgumentException.class, () ->
            registration.registerUser(null, "john@example.com", "Secure123")
        );
        assertThrows(IllegalArgumentException.class, () ->
            registration.registerUser("john", null, "Secure123")
        );
        assertThrows(IllegalArgumentException.class, () ->
            registration.registerUser("john", "john@example.com", null)
        );
    }
}