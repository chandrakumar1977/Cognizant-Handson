class Product{
    int productid;
    String name;
    String category;
    Product(int productid,String name,String category){
        this.productid=productid;
        this.name=name;
        this.category=category;
    }
    public void display(){
        System.out.println("Product ID: "+productid);
        System.out.println("Name: "+name);
        System.out.println("Category: "+category);
    }
}
class SearchAlgorithms{
    static Product linearsearch(Product[] products,int key){
        for(int i=0;i<products.length;i++){
            if(products[i].productid==key){
                return products[i];
            }
        }
        return null;
    }
    static Product binarysearch(Product[] products,int key){
        int low=0;
        int high=products.length-1;
        while(low<=high){
        int mid=low+(high-low)/2;
            if(products[mid].productid==key){
                return products[mid];
            }
            else if(products[mid].productid<key){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return null;
    }
    public static void main(String args[]){
        Product []products={
            new Product(1,"Laptop","Electronics"),
            new Product(2,"Phone","Electronics"),
            new Product(3,"Table","Furniture"),
            new Product(4,"Chair","Furniture"),
            new Product(5,"Headphones","Electronics")
        };
        int key=4;
        System.out.println("Linear Search:");
        Product result1=linearsearch(products,key);
        if(result1!=null){
            result1.display();
        }
        else{
            System.out.println("Product not found");
        }
        System.out.println("Binary Search:");
        Product result2=binarysearch(products,key);
        if(result2!=null){
            result2.display();
        }
        else{
            System.out.println("Product not found");
        }
    }
}