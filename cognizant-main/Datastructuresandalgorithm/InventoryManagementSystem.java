import java.util.*;
class Product{
    private int productid;
    private String name;
    private int quantity;
    private double price;
    Product(int productid,String name,int quantity,double price){
        this.productid=productid;
        this.name=name;
        this.quantity=quantity;
        this.price=price;
    }
    public int getProductid() {
        return productid;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    void displayProductDetails(){
        System.out.println("Product ID: "+productid);
        System.out.println("Name: "+name);
        System.out.println("Quantity: "+quantity);
        System.out.println("Price: "+price);
    }
}

class InventoryManager{
    HashMap<Integer,Product>inventory=new HashMap<>();
    void addProduct(Product product){
        inventory.put(product.getProductid(),product);
    }
    void updateProduct(int productid,int quantity,double price){
        if(inventory.containsKey(productid)){
            Product p=inventory.get(productid);
            p.setQuantity(quantity);
            p.setPrice(price);
            System.out.println("Product updated successfully");
        }
        else{
            System.out.println("Product not found");
        }
    }
    void deleteProduct(int productid){
        if(inventory.containsKey(productid)){
            inventory.remove(productid);
            System.out.println("Product deleted successfully");
        }
        else{
            System.out.println("Product not found");
        }
    }
    public void displayInventrory(){
        System.out.println("Inventory:");
        for(Product p:inventory.values()){
            p.displayProductDetails();
            System.out.println();
        }
    }
}
public class InventoryManagementSystem {
    public static void main(String[] args){
        InventoryManager manager=new InventoryManager();
        Product p1=new Product(1,"Laptop",10,999.99);
        Product p2=new Product(2,"Smartphone",20,499.99);
        manager.addProduct(p1);
        manager.addProduct(p2);
        manager.displayInventrory();
        manager.updateProduct(1,15,899.99);
        manager.deleteProduct(2);
        manager.displayInventrory();
    }
}