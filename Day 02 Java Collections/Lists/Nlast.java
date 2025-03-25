import java.util.LinkedList;
public class Nlast{
    public static String Nthlast(LinkedList<String> lists, int n){
        int firstIndex = 0;
        int secondIndex = 0;
        while(firstIndex<n){
            try{
                lists.get(firstIndex);
            }catch(IndexOutOfBoundsException e){
                return "Index out of Range";
            }
            firstIndex++;
        }
        while(true){
            try {
                lists.get(firstIndex);
            } catch (IndexOutOfBoundsException e) {
                break;
            }
            firstIndex++;
            secondIndex++;
        }
        return lists.get(secondIndex);
    }
    public static void main(String[] args) {
        LinkedList<String> lists = new LinkedList<>();
        lists.add("A");
        lists.add("B");
        lists.add("C");
        lists.add("D");
        lists.add("E");

        int N = 2;

        String result = Nthlast(lists, N);
        System.out.println("The " + N + "th element from the last is: " + result);
    }
}