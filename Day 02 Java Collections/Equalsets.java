import java.util.HashSet;
import java.util.Set;
public class Equalsets{
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        Set<Integer> set2 = new HashSet<>();
        set2.add(3);
        set2.add(2);
        set2.add(1);
        boolean areEqual = set1.equals(set2);
        if(areEqual){
            System.out.println("Both the sets are equal");   
        }
        else{
            System.out.println("Both the sets are not equal");
        }
    }
}