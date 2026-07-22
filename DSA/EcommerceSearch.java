package DSA;
import java.util.Arrays;
import java.util.Comparator;

// Product Class
class Product {

    int productId;
    String productName;
    String category;

    Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    void display() {
        System.out.println(
                "Product ID: " + productId +
                ", Name: " + productName +
                ", Category: " + category
        );
    }
}

// Linear Search
class LinearSearch {

    static Product search(Product[] products, String target) {

        for (Product p : products) {

            if (p.productName.equalsIgnoreCase(target)) {
                return p;
            }

        }

        return null;
    }
}

// Binary Search
class BinarySearch {

    static Product search(Product[] products, String target) {

        int left = 0;
        int right = products.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            int result =
                    products[mid]
                            .productName
                            .compareToIgnoreCase(target);

            if (result == 0) {
                return products[mid];
            }

            if (result < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return null;
    }
}

// Main Class
public class EcommerceSearch {

    public static void main(String[] args) {

        Product[] products = {

                new Product(101, "Phone", "Electronics"),
                new Product(102, "Shoes", "Fashion"),
                new Product(103, "Watch", "Accessories"),
                new Product(104, "Laptop", "Electronics"),
                new Product(105, "Camera", "Electronics")

        };

        System.out.println("===== LINEAR SEARCH =====");

        Product linearResult =
                LinearSearch.search(products, "Watch");

        if (linearResult != null) {
            linearResult.display();
        } else {
            System.out.println("Product not found");
        }


        // Sort before Binary Search
        Arrays.sort(
                products,
                Comparator.comparing(
                        p -> p.productName.toLowerCase()
                )
        );

        System.out.println("\n===== BINARY SEARCH =====");

        Product binaryResult =
                BinarySearch.search(products, "Watch");

        if (binaryResult != null) {
            binaryResult.display();
        } else {
            System.out.println("Product not found");
        }
    }
}
