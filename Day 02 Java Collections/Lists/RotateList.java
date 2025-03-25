import java.util.ArrayList;
import java.util.List;

public class RotateList{
    public static List<Integer> rotate(List<Integer> input, int position){
        int n = input.size();
        position = position%n;
        List<Integer> rotate = new ArrayList<>();
        for(int i=position; i<n; i++){
            rotate.add(input.get(i));
        }
        for(int i=0; i<position; i++){
            rotate.add(input.get(i));
        }
        return rotate;
    }
    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>();
        input.add(10);
        input.add(20);
        input.add(30);
        input.add(40);
        input.add(50);
        input.add(60);
        int position = 2;
        List<Integer> rotatedInput = rotate(input, position);
        for(int item : rotatedInput){
            System.out.println(item + " ");
        }
    }
}