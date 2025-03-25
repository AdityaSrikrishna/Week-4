import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileProcessorTest {

    FileProcessor processor;
    String testFile = "testfile.txt";

    @BeforeEach
    public void setUp() {
        processor = new FileProcessor();
    }

    @AfterEach
    public void tearDown() throws IOException {
        Files.deleteIfExists(Path.of(testFile));  // Clean up after each test
    }

    @Test
    public void testWriteAndReadFile() throws IOException {
        String content = "Hello, world!";
        processor.writeToFile(testFile, content);

        String result = processor.readFromFile(testFile);
        assertEquals(content, result);
    }

    @Test
    public void testFileExistsAfterWriting() throws IOException {
        processor.writeToFile(testFile, "Sample Content");

        File file = new File(testFile);
        assertTrue(file.exists(), "File should exist after writing.");
    }

    @Test
    public void testIOExceptionWhenFileDoesNotExist() {
        String nonExistentFile = "nonexistent.txt";

        Exception exception = assertThrows(IOException.class, () -> {
            processor.readFromFile(nonExistentFile);
        });

        assertTrue(exception.getMessage().contains("nonexistent.txt"));
    }
}