import java.util.Scanner;
class ExceptionForQuantity extends Exception{
    ExceptionForQuantity(String message)
    {
        super(message);
    }
}
public class CustomizedException {
    String ProductName;
    int ProductQuantity;
    Scanner s1=new Scanner(System.in);
    void getData()
    {
        System.out.println("Enter the Product Name ");
        ProductName=s1.next();
        System.out.println("Enter the Product Quantity ");
        ProductQuantity=s1.nextInt();
        try {
            this.validataQuantity(ProductQuantity);
        } catch (ExceptionForQuantity e) {
          System.out.println(e);
        }
    }
    public void validataQuantity(int ProductQuantity) throws ExceptionForQuantity
    {
        if(ProductQuantity>5) {
            throw new ExceptionForQuantity("We are sorry only 5 Product Allowed per User");
        }
        else
        {
            System.out.println("Happy Purchase");
        }
    }
    public static void main(String[] args) {
        CustomizedException ce=new CustomizedException();
        ce.getData();
    }
}
