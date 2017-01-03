import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.close();
        String ans="";

        // if 'n' is NOT evenly divisible by 2 (i.e.: n is odd)
        if(n%2==1)
        {
            ans = "Weird";
        }
        else{
            //If  n is even and in the inclusive range of  2 to 5 , print Not Weird
            if (1<n && n<6)
            {
                ans ="Not Weird";
            }
            //If  n is even and in the inclusive range of  6 to 20 , print Weird
            else if (5<n && n<21)
            {
                ans = "Weird";
            }
            //If  n is even and greater than 20, print Not Weird
            else
            {
                ans ="Not Weird";
            }
        }
        System.out.println(ans);
    }

}
