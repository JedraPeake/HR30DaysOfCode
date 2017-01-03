import java.util.Scanner;
class Calculator
{
    int power(int x,int y) throws Exception {
        //negative exception
        if(x<0||y<0)
        {
            throw new CalculatorException();
        }

        int sum =1;
        for(int i=0; i<y;i++)
        {
            sum*=x;
        }
        return sum;
    }

}


class CalculatorException extends Exception{
    Exception Exception=new Exception();
    public CalculatorException() {
        super("n and p should be non-negative");
    }

}

public class Solution {

    public static void main(String []argh)
    {
        Scanner in = new Scanner(System.in);
        int T=in.nextInt();
        while(T-->0)
        {
            int n = in.nextInt();
            int p = in.nextInt();
            Calculator myCalculator = new Calculator();
            try
            {
                int ans=myCalculator.power(n,p);
                System.out.println(ans);

            }
            catch(Exception e)
            {
                System.out.println(e.getMessage());
            }
        }

    }
}
