import java.util.ArrayList;
import java.util.List;
abstract class WorkhouseItems{
    private String name;
    public WorkhouseItems(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public abstract void displayinfo();
}
class Electronics extends WorkhouseItems{
    private String brand;
    public Electronics(String name, String brand){
        super(name);
        this.brand = brand;
    }
    @Override
    public void displayinfo(){
        System.out.println("Name: " + getName() + "  Brand: " + brand);
    }
}
class Grocery extends WorkhouseItems{
    private String expiryDate;
    public Grocery(String name, String expiryDate){
        super(name);
        this.expiryDate = expiryDate;
    }
    public void displayinfo(){
        System.out.println("Name: " + getName() + "  Expiry Date: " + expiryDate);
    }
}
class Furniture extends WorkhouseItems{
    private String material;
    public Furniture(String name, String material){
        super(name);
        this.material = material;
    }
    public void displayinfo(){
        System.out.println("Name: " + getName() + "  Material: " + material);
    }
}
class Storage<T extends WorkhouseItems>{
    private List<T> items = new ArrayList<>();
    public void addItems(T item){
        items.add(item);
    }
    public T getItem(int index){
        return items.get(index);
    }
    public List<T> getAllitems(){
        return items;
    }
}
class WorkhouseUtil{
    public static void displayitems(List<? extends WorkhouseItems> items){
        for(WorkhouseItems item : items){
            item.displayinfo();
        }
    }
}
public class WorkhouseMain{
    public static void main(String[] args) {
        Storage<Electronics> electronics = new Storage<>();
        Storage<Grocery> grocery = new Storage<>();
        Storage<Furniture> furniture = new Storage<>();

        electronics.addItems(new Electronics("Smartphone", "Samsung"));
        electronics.addItems(new Electronics("Laptop", "Dell"));

        grocery.addItems(new Grocery("Milk", "2025-05-01"));
        grocery.addItems(new Grocery("Bread", "2025-04-28"));

        furniture.addItems(new Furniture("Chair", "Wood"));
        furniture.addItems(new Furniture("Table", "Metal"));

        System.out.println("Electronics: ");
        WorkhouseUtil.displayitems(electronics.getAllitems());
        System.out.println("-----------------------");
        System.out.println("Grocery: ");
        WorkhouseUtil.displayitems(grocery.getAllitems());
        System.out.println("-----------------------");
        System.out.println("Furniture: ");
        WorkhouseUtil.displayitems(furniture.getAllitems());

    }
}