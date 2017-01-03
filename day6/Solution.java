import java.util.Scanner;

public class Solution {

        public static void main(String[] args)
        {
        /* Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
            Scanner str = new Scanner(System.in);
            int n = str.nextInt();
            String inputString;
            for (int j=0; j<n; j++)
            {
                inputString =str.next();
                char[] myCharArray = inputString.toCharArray();
                char[] myEvenCharArray = inputString.toCharArray();
                char[] myOddCharArray = inputString.toCharArray();

                for (int i = 0; i < inputString.length(); i++) {
                    // Print each sequential character on the same line
                    if (i % 2 == 0) {
                        myEvenCharArray[i / 2] = myCharArray[i];
                    } else {
                        if (i == 1) {
                            myOddCharArray[0] = myCharArray[i];
                        } else {
                            myOddCharArray[i / 2] = myCharArray[i];
                        }
                    }
                }

                if(inputString.length()%2==0)
                {
                    for (int i = 0; i < inputString.length() / 2; i++) {
                        System.out.print(myEvenCharArray[i]);
                    }
                }
                else
                {
                    for (int i = 0; i < inputString.length() / 2 + 1; i++) {
                        System.out.print(myEvenCharArray[i]);
                    }
                }
                System.out.print(" ");
                for (int i = 0; i < inputString.length() / 2; i++) {
                    System.out.print(myOddCharArray[i]);
                }

                System.out.println();
            }
            str.close();
        }
}
