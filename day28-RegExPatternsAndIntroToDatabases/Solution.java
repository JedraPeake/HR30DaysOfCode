import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        List<String> userlist = new ArrayList<String>();
        for (int i=0; i<n;i++)
        {
            String name=sc.next();
            String email=sc.next();

            boolean gmail = email.contains("@gmail.com");

            if(gmail)
            {
                userlist.add(name);
            }
        }

        String[] sortArr = userlist.toArray(new String[userlist.size()]);
        Arrays.sort(sortArr);
        for (int i=0;i<userlist.size();i++)
        {
            System.out.println(sortArr[i]);
        }

    }
}
