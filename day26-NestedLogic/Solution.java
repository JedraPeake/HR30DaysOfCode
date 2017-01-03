import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
          /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc=new Scanner(System.in);
        int rDay =sc.nextInt();
        int rMonth =sc.nextInt();
        int rYear =sc.nextInt();

        int eDay =sc.nextInt();
        int eMonth =sc.nextInt();
        int eYear =sc.nextInt();
        int yearsLate = rYear -eYear;
        int monthsLate=rMonth-eMonth;
        int daysLate=rDay-eDay;
        int fine=0;
        if (yearsLate>0)
        {
            fine =10000;
        }
        else if (yearsLate<0)
        {
            fine =0;
        }
        else if(monthsLate > 0)
        {
            fine =monthsLate * 500;
        }
        else if (daysLate > 0)
        {
            fine=daysLate * 15;
        }
        else
        {
            fine=0;
        }

        System.out.println(fine);
    }
}
