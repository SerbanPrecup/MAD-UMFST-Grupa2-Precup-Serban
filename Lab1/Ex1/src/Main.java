import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Number: ");
        Scanner sc = new Scanner(System.in);
        int nr = sc.nextInt();
        if(nr<0)
            System.out.println("\nThe Number is negative.");
        else
            System.out.println("\nThe Number is positive.");
    }
}