import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class DatabaseConnectionTest {

    DatabaseConnection db;

    @BeforeEach
    public void setUp() {
        db = new DatabaseConnection();
        db.connect();
    }

    @AfterEach
    public void tearDown() {
        db.disconnect();
    }

    @Test
    public void testConnectionIsEstablished() {
        assertTrue(db.isConnected(), "Database should be connected after setup.");
    }

    @Test
    public void testMultipleConnections() {
        assertTrue(db.isConnected(), "Database should be connected before each test.");
        db.disconnect();
        assertFalse(db.isConnected(), "Database should be disconnected after manual call.");
        db.connect();
        assertTrue(db.isConnected(), "Database should be connected again after reconnect.");
    }
}