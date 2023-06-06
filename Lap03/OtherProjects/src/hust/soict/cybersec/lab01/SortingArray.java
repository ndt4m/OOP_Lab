package hust.soict.cybersec.lab01;
import java.util.Arrays;
import java.util.Scanner;
public class SortingArray 
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter the size of array: ");
        int n = input.nextInt();
        
        int sum = 0;
        int[] arr = new int[n];
        System.out.println("Begin to fill the array!");
        for (int i = 0; i < n; i++)
        {
            arr[i] = input.nextInt();
            sum += arr[i];
        }

        Arrays.sort(arr);
        double avg = (double) sum / n;

        for (int i : arr) 
        {
            System.out.print(i + " ");
        }

        System.out.println("\nThe sum of the array is: " + sum);
        System.out.println("The avarage of the array is: " + avg);

    }
}
