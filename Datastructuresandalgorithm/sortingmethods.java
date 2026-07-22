// import java.util.*;
// class sort{
//     int orderid;
//     String customername;
//     double totalPrice;
//     sort(int orderid,String customername,double totalPrice){
//         this.orderid=orderid;
//         this.customername=customername;
//         this.totalPrice=totalPrice;
//     }
//     public void display(){
//         System.out.println("Order ID: "+orderid);
//         System.out.println("Customer Name: "+customername);
//         System.out.println("Total Price: "+totalPrice);
//     }
// }
class Order {
    int orderId;
    String customerName;
    double totalPrice;

    Order(int orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    void display() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Total Price: ₹" + totalPrice);
        System.out.println("-------------------------");
    }
}

public class sortingmethods {

    // Bubble Sort
    static void bubbleSort(Order[] orders) {
        int n = orders.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {

                if (orders[j].totalPrice >
                    orders[j + 1].totalPrice) {

                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    // Partition using FIRST element as pivot
    static int partition(Order[] orders, int low, int high) {

        double pivot = orders[low].totalPrice;

        int i = low;
        int j = high;

        while (i < j) {

            while (i <= high - 1 &&
                   orders[i].totalPrice <= pivot) {
                i++;
            }

            while (orders[j].totalPrice > pivot) {
                j--;
            }

            if (i < j) {
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }

        Order temp = orders[low];
        orders[low] = orders[j];
        orders[j] = temp;

        return j;
    }

    // Quick Sort
    static void quickSort(Order[] orders,
                          int low, int high) {

        if (low < high) {

            int pivotIndex =
                    partition(orders, low, high);

            quickSort(orders, low,
                      pivotIndex - 1);

            quickSort(orders,
                      pivotIndex + 1,
                      high);
        }
    }

    // Display Orders
    static void display(Order[] orders) {
        for (Order o : orders) {
            o.display();
        }
    }

    public static void main(String[] args) {

        Order[] orders = {
            new Order(101, "Rahul", 5000),
            new Order(102, "Priya", 12000),
            new Order(103, "Arun", 8000),
            new Order(104, "Meena", 15000),
            new Order(105, "Kiran", 3000)
        };

        System.out.println("Before Sorting:");
        display(orders);

        // Bubble Sort
        bubbleSort(orders);

        System.out.println("\nAfter Bubble Sort:");
        display(orders);

        // Unsorted array for Quick Sort
        Order[] orders2 = {
            new Order(101, "Rahul", 5000),
            new Order(102, "Priya", 12000),
            new Order(103, "Arun", 8000),
            new Order(104, "Meena", 15000),
            new Order(105, "Kiran", 3000)
        };

        quickSort(orders2, 0,
                  orders2.length - 1);

        System.out.println("\nAfter Quick Sort:");
        display(orders2);
    }
}