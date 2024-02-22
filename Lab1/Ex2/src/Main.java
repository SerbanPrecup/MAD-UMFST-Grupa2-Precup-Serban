import java.util.Scanner;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        Vector<Integer> vector = new Vector<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("The number of elements: ");
        int nr = sc.nextInt();
        for(int i = 0 ; i<nr; i++){
            int v = sc.nextInt();
            vector.add(v);
        }
        double suma = 0;
        for(int x:vector){
            suma+=x;
        }
        suma/=vector.size();
        System.out.println("The average value is: " + suma);
    }
}