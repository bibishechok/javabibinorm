import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Product {
    static transient AtomicInteger idCounter = new AtomicInteger(0);  //for generating id
    private static Link top;

    public Product() {
        top = null;
    }

    private boolean isEmpty() {  //check if our list is not empty
        return top == null;
    }

    public static void addProduct()
    {
        int id;
        String name;
        Integer money;
        int inStock;
        id=idCounter.addAndGet(1);
        Scanner s = new Scanner(System.in);
        Scanner st = new Scanner(System.in);
        System.out.println("Enter product:");
        name=s.nextLine();
        System.out.println("Enter price:");
        money=s.nextInt();
        System.out.println("In stock:");
        inStock=st.nextInt();
        Link temp = new Link(id, name, money, inStock);
        temp.next = top;
        top = temp;
    }
    public static void seeProduct()
    {
        Link temp = top;

        while (temp != null) {
            System.out.println("Id: " + temp.id);
            System.out.println("Product: " + temp.name);
            System.out.println("Price: " + temp.money);
            System.out.println("In stock: "+ temp.bought);
            temp = temp.next;
        }
    }
    public static int find(int productId,int price){
        Link temp = top;
        System.out.println(top);
        if (temp == null) {
            System.out.println("No product found");
        }else {
            while (temp.id != productId) {
                temp = temp.next;
            }
            if (temp.id == productId) {
                price = temp.money;
            }
        }
        return price;
    }
    public static int bought(int productId){
        Link temp = top;
        if(temp!=null) {

            while (temp.id != productId) {
                temp = temp.next;
            }
            if (temp.id == productId) {
                if (temp.bought < 1) {
                    System.out.println("Sold out:( ");
                } else {
                    temp.bought -= 1;
                }
            }
            return temp.bought;
        }
        return productId;
    }
    public static String boughtName(int productId) {
        Link temp = top;
        if(temp==null) {
            System.out.println("This product has not been found ");
        }else{
        while (temp.id != productId) {
            temp = temp.next;
        }
            if (temp.id == productId) {
                if (temp.bought > 1) {
                    return temp.name;
                }
            }
            return temp.name;
        }
        return null;
    }
    public static int refund(int productId){
        Link temp = top;
        if(temp==null){
            return productId;
        }
        while (temp.id != productId)
        {
            temp = temp.next;
        }
        if(temp.id==productId&&User.refund(userId, productPrice, productId, sold, productName)!=null)
        {
                temp.bought+= 1;
        }
        return temp.bought;
    }
    public static void print()
    {
        Link temp = top;

        while (temp!= null)
        {
            System.out.println("Id: "+temp.id+" Product: "+temp.name+" Price: "+temp.money+" In stock: "+temp.bought);
            temp = temp.next;
        }
    }
}
