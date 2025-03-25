import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class QueueBinary{
    public static List<String> generateBinary(int N){
        List<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        queue.add("1");
        for(int i=0; i<N; i++){
            String current = queue.remove();
            result.add(current);
            queue.add(current + "0");
            queue.add(current + "1");
        }
        return result;
    }
    public static void main(String[] args) {
        int N = 5;
        List<String> binary = generateBinary(N);
        System.out.println("Result: " + binary);
    }
}