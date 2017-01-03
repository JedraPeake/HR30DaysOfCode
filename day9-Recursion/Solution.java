
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args)
    {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc= new Scanner(System.in);
        int factorial = sc.nextInt();
        int number =1;
        for (int i=1;i<=factorial;i++)
        {
            number *=i;
        }

        System.out.print(number);
    }
}
