import java.util.Scanner;
class pr3 {
   public static void main(String[] args) {
       System.out.println("-----------------------------------------------------------------");
       System.out.println("-------------basic calculator---------------------------");
       System.out.println("-----------------------------------------------------------------");
   
       System.out.println("enter two values to perform operation");
       int b,c;
       Scanner in=new Scanner(System.in);
       b=in.nextInt();
       c=in.nextInt();

       System.out.print("1)for addition  press 1\n2)for substraction press 2\n3)for multiplication press 3\n");
       System.out.print("4)for division press 4\n 5)press 0 to exit");
       int a=in.nextInt();
        in.close();
    
       switch (a) {
           case 1:
               System.out.println("addition = "+ (b+c));
               break;
          case 2:
               System.out.println("Substraction = "+ (b-c));
               break;
          case 3:
               System.out.println("multiplication = "+ (b*c));
               break;
           default:
               break;
       }

   }
}
