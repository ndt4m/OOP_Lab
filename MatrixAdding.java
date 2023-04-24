import java.util.Scanner;

import javax.swing.plaf.synth.SynthScrollBarUI;

public class MatrixAdding 
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the number of rows: ");
        int r = input.nextInt();
        System.out.println("Enter the number of colums: ");
        int c = input.nextInt();

        double[][] a = new double[r][c];
        double[][] b = new double[r][c];
        double[][] res = new double[r][c];

        System.out.println("Begin to fill the first matrix!");
        for (int i = 0; i < r; i++)
        {
            for (int j = 0; j < c; j++)
            {
                a[i][j] = input.nextDouble();
            }
        }

        System.out.println("Begin to fill the second matrix!");
        for (int i = 0; i < r; i++)
        {
            for (int j = 0; j < c; j++)
            {
                b[i][j] = input.nextDouble();
            }
        }

        System.out.println("The addition of the two matrix is: ");
        for (int i = 0; i < r; i++)
        {
            for (int j = 0; j < c; j++)
            {
                res[i][j] = a[i][j] + b[i][j];
                System.out.print(res[i][j]);
                if (j != c - 1)
                {
                    System.out.print(" ");
                }
            }
            System.out.print("\n");
        }


    }
}
