import java.util.Scanner;

public class BasicsOfException {
    int a;
    int b;
    int c;
    int marks[]=new int[5];
    Scanner s1=new Scanner(System.in);
    void calc()
    {
        System.out.println("Enter the Value for a  ");
        a=s1.nextInt();
        System.out.println("Enter the Value for b   ");
        b=s1.nextInt();
try{
    marks[0]=81;
    marks[1]=82;
    marks[2]=84;
    marks[3]=85;
    marks[4]=90;
   // marks[5]=90;

    c=a/b;
    System.out.println("Answer for c is "+c);
   // System.out.println("Values On "+marks[5]);
}
finally {
    System.out.println("Hi i am Finally");
}
System.out.println("Hi i am Outside of try block");

    }

    public static void main(String[] args) {
        BasicsOfException be=new BasicsOfException();
        be.calc();
    }
}
