import java.util.*;
class Patient implements Comparable<Patient>{
    String name;
    int severity;
    public Patient(String name, int severity){
        this.name = name;
        this.severity = severity;
    }
    public int compareTo(Patient other){
        return Integer.compare(other.severity, this.severity);
    }
    public String toString(){
        return name + "( Severity: " + severity + " )";
    }
}
public class PriorityMain{
    public static void main(String[] args) {
        PriorityQueue<Patient> triageQueue = new PriorityQueue<>();
        triageQueue.add(new Patient("John", 4));
        triageQueue.add(new Patient("James", 5));
        triageQueue.add(new Patient("Jack", 3));
        System.out.println("Treatment Order:");
        while(!triageQueue.isEmpty()){
            System.out.println(triageQueue.remove());
        }
    }
}
