import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String S = in.next();

        try
        {
            int change;
            change=Integer.parseInt(S);
            System.out.println(change);

        }
        catch(NumberFormatException a)
        {
            System.out.println("Bad String");
        }
    }

}
