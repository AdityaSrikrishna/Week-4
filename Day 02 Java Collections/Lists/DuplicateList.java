import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
public class DuplicateList{
    public static List<Integer> duplicate(List<Integer> items){
        List<Integer> result = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();
        for(Integer item : items){
            if(!seen.contains(item)){
                result.add(item);
                seen.add(item);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        List<Integer> items = new ArrayList<>();
        items.add(10);
        items.add(20);
        items.add(10);
        items.add(30);
        items.add(30);
        items.add(40);
        List<Integer> duplicateRemoved = duplicate(items);
        for(Integer v : duplicateRemoved){
            System.out.println(v + " ");
        }        
    }
}