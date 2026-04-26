import java.util.Scanner;
public class HelloWould3 {
    public static void main(String[] args) {
        Scanner userIn = new Scanner(System.in);
        System.out.print("Your name is:");
        String name = userIn.nextLine();
        userIn.close();
        System.out.println("Hello," + name);
    }
}
