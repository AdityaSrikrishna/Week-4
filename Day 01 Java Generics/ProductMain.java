import java.util.ArrayList;
import java.util.List;
enum BookCategory{
    FICTION, NONFICTION, SCIENCE, HISTORY
}
enum ClothingCategory{
    MEN, WOMEN, KIDS
}
enum GadgetCategory{
    LAPTOPS, PHONES, ACCESSORIES
}
abstract class Product<CATEGORY>{
    private String name;
    private double price;
    private CATEGORY category;

    public Product(String name, double price, CATEGORY category){
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName(){
        return name;
    }
    public double getPrice(){
        return price;
    }
    public CATEGORY getCategory(){
        return category;
    }
    public void setPrice(double newprice){
        this.price = newprice;
    }
    public void displayinfo(){
        System.out.println(name + "(" + category + ") - $"+ price);
    }
}
class Book extends Product<BookCategory>{
    public Book(String name, double price, BookCategory category){
        super(name, price, category);
    }
}
class Clothing extends Product<ClothingCategory>{
    public Clothing(String name, double price, ClothingCategory category){
        super(name, price, category);
    }
}
class Gadgets extends Product<GadgetCategory>{
    public Gadgets(String name, double price, GadgetCategory category){
        super(name, price, category);
    }
}
class ProductUtils{
    public static <T extends Product<?>> void applydiscount(T product, double discount){
        double oldprice = product.getPrice();
        double discountAmount = oldprice *(discount/100);
        product.setPrice(oldprice - discountAmount);
    }
}
class ProductCatalog{
    private List<Product<?>> products = new ArrayList<>();
    public void addProduct(Product<?> product){
        products.add(product);
    }
    public void displaycatalog(){
        for(Product<?> product : products){
            product.displayinfo();
        }
    }
}
public class ProductMain{
    public static void main(String[] args) {
        Book book = new Book("The Great Gatsby", 20.0, BookCategory.FICTION);
        Clothing cloth = new Clothing("Casual Shirt", 50, ClothingCategory.MEN);
        Gadgets mobile = new Gadgets("Nothing 2a plus", 250, GadgetCategory.PHONES);

        ProductCatalog catalog = new ProductCatalog();
        catalog.addProduct(book);
        catalog.addProduct(cloth);
        catalog.addProduct(mobile);

        System.out.println("Before discount:");
        catalog.displaycatalog();

        ProductUtils.applydiscount(mobile, 10);
        ProductUtils.applydiscount(cloth, 5);

        System.out.println("After discount:");
        catalog.displaycatalog();
    }
}