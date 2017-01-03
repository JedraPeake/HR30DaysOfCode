import java.util.Scanner;


public class Solution {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
       Scanner scan =new Scanner(System.in);
        int s = scan.nextInt();
        int numberOfSwaps = 0;

        int a[] = new int[s];
        for (int i=0; i<s; i++) {
            a[i] = scan.nextInt();
        }

        for (int i = 0; i < s; i++) {

            // Track number of elements swapped during a single array traversal

            for (int j = 0; j < s - 1; j++) {
                // Swap adjacent elements if they are in decreasing order
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;

                    numberOfSwaps++;
                }
            }
        }

        System.out.println("Array is sorted in "+ numberOfSwaps+" swaps.");
        System.out.println("First Element: "+ a[0]);
        System.out.println("Last Element: "+ a[s-1]);


    }
}
