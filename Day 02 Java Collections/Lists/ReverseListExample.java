import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
public class ReverseListExample{
    public static <T> List<T> ReverseArrayList(List<T> list){
        List<T> reverseList = new ArrayList<>();
        for(int i = list.size()-1; i>=0; i--){
            reverseList.add(list.get(i));
        }
        return reverseList;
    }
    public static <T> List<T> ReverseLinkedList(List<T> list){
        List<T> reverseLinked = new ArrayList<>();
        for(T item : list){
            reverseLinked.addFirst(item);
        }
        return reverseLinked;
    }
    public static void main(String[] args) {
        ArrayList<Integer> ArrayList = new ArrayList<>();
        ArrayList.add(10);
        ArrayList.add(20);
        ArrayList.add(30);
        ArrayList.add(40);
        ArrayList.add(50);
        ArrayList.add(60);
        System.out.println("Array before reversing: " + ArrayList);
        List<Integer> reversedArray = ReverseArrayList(ArrayList);
        System.out.println("Array after reversing: " + reversedArray);

        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(30);
        linkedList.add(40);
        linkedList.add(50);
        linkedList.add(60);
        System.out.println("Linked List before reversing: " + linkedList);
        List<Integer> reversedLink = ReverseLinkedList(linkedList);
        System.out.println("Linked list after reversing: " + reversedLink);
    }
}