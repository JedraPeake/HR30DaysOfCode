import java.util.Scanner;

public class Solution {
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int remainder=0;
        int maxCount=0;
        int storedMaxCount=0;

        //binary conversion
        while(n > 0)
        {
            remainder = n % 2;
            n = n / 2;

            if(remainder==1)
            {
                maxCount++;
                if(storedMaxCount<maxCount)
                {
                    storedMaxCount=maxCount;
                }
            }
            else
            {
                if(storedMaxCount<maxCount)
                {
                    storedMaxCount=maxCount;
                }
                maxCount=0;
            }
        }

        System.out.println(storedMaxCount);
    }
}
