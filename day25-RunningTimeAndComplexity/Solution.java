import java.util.Scanner;

public class Solution {
    public static void main(String[] args)
    {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();

        for (int i=0; i<T;i++)
        {
            int temp =sc.nextInt();
            boolean check = isPrime(temp);
            if(check)
            {
                System.out.println("Prime");
            }
            else
            {
                System.out.println("Not Prime");
            }

        }

    }

    public static boolean isPrime(int n)
    {
        //smallest number n can be is 1
        if(n==1)
        {
            return false;
        }
        else if (n==2)
        {
            return true;
        }
        else
        {
            for (int i=2; i <= Math.sqrt(n);i++)//only need to check half the size
            {
                if(n%i==0)
                {
                    return false;
                }
            }
            return true;
        }
    }
}
