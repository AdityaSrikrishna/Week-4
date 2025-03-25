import java.io.*;

class WriterThread extends Thread {
    private PipedOutputStream output;

    public WriterThread(PipedOutputStream output) {
        this.output = output;
    }

    @Override
    public void run() {
        try {
            String message = "Hello from WriterThread!";
            output.write(message.getBytes());
            output.close();
        } catch (IOException e) {
            System.out.println("WriterThread IOException: " + e.getMessage());
        }
    }
}

class ReaderThread extends Thread {
    private PipedInputStream input;

    public ReaderThread(PipedInputStream input) {
        this.input = input;
    }

    @Override
    public void run() {
        try {
            int data;
            System.out.print("ReaderThread received: ");
            while ((data = input.read()) != -1) {
                System.out.print((char) data);
            }
            System.out.println();
            input.close();
        } catch (IOException e) {
            System.out.println("ReaderThread IOException: " + e.getMessage());
        }
    }
}

public class PipedCommunicationExample {
    public static void main(String[] args) {
        try {
            // Create connected piped streams
            PipedOutputStream pos = new PipedOutputStream();
            PipedInputStream pis = new PipedInputStream(pos);

            // Start writer and reader threads
            WriterThread writer = new WriterThread(pos);
            ReaderThread reader = new ReaderThread(pis);

            writer.start();
            reader.start();

            // Wait for threads to finish
            writer.join();
            reader.join();

        } catch (IOException | InterruptedException e) {
            System.out.println("Main Exception: " + e.getMessage());
        }
    }
}
