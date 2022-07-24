import java.util.Scanner;

public class Main {
    static int code;
    static String sold;
    public static void heading(){
        System.out.println("To enter a new user press 1;");
        System.out.println("To enter a new product press 2;");
        System.out.println("To see all users press 3;");
        System.out.println("To see all products press 4;");
        System.out.println("To buy something press 5;");
        System.out.println("To have a refund press 6;");
        System.out.println("To end press 7;");
        Scanner in = new Scanner(System.in);
        code = in.nextInt();
    }
    public static void main(String[] args) {

        heading();
        int userId;
        int productId;
        Scanner s = new Scanner(System.in);
        while(code!=7){
            switch(code){
                case 1:    //add new user
                    User.addUser();
                    User.seeUser(sold);
                    break;

                case 2:     //add new product
                    Product.addProduct();
                    Product.seeProduct();
                    break;

                case 3:    //show all users
                    User.print();
                    break;

                case 4:    //show all goods
                    Product.print();
                    break;
                case 5:    //buy smth
                    System.out.println("Enter user`s id: ");
                    userId=s.nextInt();
                    System.out.println("Enter product id: ");
                    productId=s.nextInt();
                    User.buy(userId,Product.find(productId,0), productId, sold);
                    Product.bought(productId);
                    break;

                case 6:       //get a refund
                    System.out.println("Enter user`s id: ");
                    userId=s.nextInt();
                    System.out.println("Enter product id: ");
                    productId=s.nextInt();
                    User.refund(userId, Product.find(productId,0), productId, User.buy(userId, Product.find(productId,0) , productId,  sold), Product.findName(productId));
                    Product.refund(userId, Product.find(productId,0), productId,User.buy(userId, Product.find(productId,0) , productId,  sold), Product.findName(productId));
                    break;
                case 7:
                    return;

                default:     //end
                    System.out.println("Wrong code");
            }
            heading();
        }

    }
}
