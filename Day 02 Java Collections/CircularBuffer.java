public class CircularBuffer {
    private int[] buffer;
    private int size;
    private int start = 0;
    private int end = 0;
    private boolean isFull = false;

    public CircularBuffer(int capacity) {
        buffer = new int[capacity];
        size = capacity;
    }

    public void insert(int value) {
        buffer[end] = value;
        end = (end + 1) % size;

        if (isFull) {
            start = (start + 1) % size;
        }

        if (end == start) {
            isFull = true;
        }
    }

    public void printBuffer() {
        System.out.print("Buffer: [");
        int i = start;
        boolean first = true;
        do {
            if (!first) System.out.print(", ");
            System.out.print(buffer[i]);
            i = (i + 1) % size;
            first = false;
        } while (i != end || (isFull && i == end));
        System.out.println("]");
    }

    public static void main(String[] args) {
        CircularBuffer cb = new CircularBuffer(3);
        cb.insert(1);
        cb.insert(2);
        cb.insert(3);
        cb.printBuffer();
        cb.insert(4);
        cb.printBuffer();
        cb.insert(5);
        cb.printBuffer();
    }
}