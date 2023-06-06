package hust.soict.cybersec.lab01;
import java.util.Scanner;;
public class PrintTriangle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter the height of the triangle: ");
        int h = input.nextInt();

        for (int i = 0; i < h; i++)
        {
            System.out.println(" ".repeat(h-i-1) + "*".repeat(i*2 + 1));
        }
    }
}
