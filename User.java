import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

import static sun.util.locale.LocaleUtils.isEmpty;

public class User {
    static transient AtomicInteger idCounter = new AtomicInteger(0);   //for generating id
    private static LinkBoost top;

    public User() {
        top = null;
    }

    public static void addUser()
    {
        int id;
        String name;
        Integer money;
        int bought = 0;
        String sold="";
        id=idCounter.addAndGet(1);
        Scanner s = new Scanner(System.in);
        System.out.println("Enter name:");
        name=s.nextLine();
        System.out.println("Enter money amount:");
        money=s.nextInt();
        LinkBoost temp = new LinkBoost(id, name, money, bought, sold);
        temp.next = top;
        top = temp;
    }
    public static void seeUser(String sold)
    {
        LinkBoost temp = top;

        while (temp != null) {
            System.out.println("ID: " + temp.id);
            System.out.println("Name: " + temp.name);
            System.out.println("Money: " + temp.money);
            System.out.println("Bought: "+ temp.bought);
            System.out.println("Bought: "+ temp.sold);
            temp = temp.next;
        }
    }
    public static void print()
    {
        LinkBoost temp = top;

        while (temp!= null)
        {
            System.out.println("Id: "+temp.id+" Name: "+temp.name+" Money: "+temp.money+" Bought: "+temp.bought+" User`s products: "+temp.sold);
            temp = temp.next;
        }
    }
    public static String buy(int userId, int productPrice, int productId, String sold){
        LinkBoost temp = top;
        if(temp==null){
            System.out.println("No product found");
        }else{
            while (temp.id != userId)
            {
                temp = temp.next;
            }
            if(temp.id==userId)
            {
                if(temp.money>=productPrice){
                    temp.money-=productPrice;
                    temp.bought+=1;
                    if(sold==null) {
                        temp.sold = Product.boughtName(productId);
                    }else{
                        temp.sold += " "+Product.boughtName(productId);
                    }
                }
                else{
                    System.out.println("Not enough money:( ");
                }
            }
        }
        return temp.sold;
    }
    public static String refund(int userId, int productPrice, int productId, String sold, String productName){
        LinkBoost temp = top;
        while (temp.id != userId)
        {
            temp = temp.next;
        }
        if(temp.id==userId) {
            if (sold == null) {
                System.out.println("This user has not bought this product ");
                return null;
            } else {
                temp.money += productPrice;
                temp.bought -= 1;
                if(temp.bought<0){
                    System.out.println(temp.money+"This user has not bought this product ");
                    temp.money -= productPrice;
                    temp.bought += 1;
                    return null;
                }else {
                    temp.sold = temp.sold.replace(Product.boughtName(productId), "");
                }
            }
        }
        return temp.sold;
    }


}
