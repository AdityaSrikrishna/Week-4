import java.util.*;
public class ShoppingKart{
    Map<String, Double> productPrices = new HashMap<>();
    Map<String, Integer> cartItems = new LinkedHashMap<>();

    public void add(String product, Double price){
        productPrices.put(product, price);
    }
    public void addToCart(String product, Integer quantity){
        if(!productPrices.containsKey(product)){
            System.out.println(product + " not available.");
            return ;
        }
        else{
            cartItems.put(product,cartItems.getOrDefault(product, 0) + quantity);
        }
    }
    public void displayCart(){
        System.out.println("Cart Items (In order ):");
        for(Map.Entry<String, Integer> entry : cartItems.entrySet()){
            String product = entry.getKey();
            int value = entry.getValue();
            double price = productPrices.get(product);
            System.out.printf("%s x%d -$%.2f each\n",product,value,price);
        }
    }
    public void displayCartItemsSortedByPrice(){
        TreeMap<String, Double> sortedByPrice = new TreeMap<>(
            (a,b) -> {
                int priceCompare = Double.compare(productPrices.get(a), productPrices.get(b));
                return priceCompare!=0 ? priceCompare : a.compareTo(b);
            }
        );
        for(String product : cartItems.keySet()){
            sortedByPrice.put(product, productPrices.get(product));
        }
        System.out.println("Items in Cart ( Sorted by Price ):");
        for(String product : sortedByPrice.keySet()){
            int quantity = cartItems.get(product);
            double price = productPrices.get(product);
            System.out.printf("%s x%d -$%.2f", product, quantity, price);
            System.out.println();
        }
    }
    public void gettotal(){
        double total = 0;
        for(Map.Entry<String, Integer> entry : cartItems.entrySet()){
            String product = entry.getKey();
            int quantity = entry.getValue();
            total += productPrices.get(product)*quantity;
        }
        System.out.printf("Total is: $%.2f", total);
    }
    public static void main(String[] Args){
        ShoppingKart cart = new ShoppingKart();
        cart.add("Milk", 2.75);
        cart.add("Bread", 2.70);
        cart.add("Apple", 1.58);
        cart.add("Banana", 0.9);
        cart.add("Eggs", 3.00);

        cart.addToCart("Milk", 2);
        cart.addToCart("Bread", 3);
        cart.addToCart("Banana", 6);

        cart.displayCart();
        System.out.println();
        cart.displayCartItemsSortedByPrice();
        System.out.println();
        cart.gettotal();
    }
}