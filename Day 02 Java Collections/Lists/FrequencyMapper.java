import java.util.HashMap;
import java.util.Map;
public class FrequencyMapper{
    public static Map<String, Integer> countFrequency(String[] input){
        Map<String, Integer> frequencyMap = new HashMap<>();
        for(int i=0; i<input.length; i++){
            String current = input[i];
            boolean found = false;
            for(Map.Entry<String, Integer> entry : frequencyMap.entrySet()){
                if(entry.getKey().equals(current)){
                    frequencyMap.put(current, entry.getValue() + 1);
                    found = true;
                    break;
                }
            }
            if(!found){
                frequencyMap.put(current, 1);
            }
        }
        return frequencyMap;
    }
    public static void main(String[] args) {
        String[] input = {"apple", "mango", "apple", "orange"};
        Map<String, Integer> freq = countFrequency(input);
        for(Map.Entry<String, Integer> entry : freq.entrySet()){
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}