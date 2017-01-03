import java.util.Scanner;

class Node{
    int data;
    Node next;
    Node(int d){
        data=d;
        next=null;
    }

}

public class Solution {
    public static Node removeDuplicates(Node head)
    {
        //Write your code here
        //empty case and if list is just 1 node, no duplicates
        if(head ==null||head.next==null)
        {
            return head;
        }
        //given constraint that the list is alwasy in non decreasing order ie 1 2222 3 444 5 not 4 2 3 4
        else if(head.data == head.next.data)
        {
            head.next=head.next.next;
            removeDuplicates(head);
        }
        //move to next node
        else
        {
            removeDuplicates(head.next);
        }
        return head;
    }

    public static  Node insert(Node head,int data)
    {
        Node p=new Node(data);
        if(head==null)
            head=p;
        else if(head.next==null)
            head.next=p;
        else
        {
            Node start=head;
            while(start.next!=null)
                start=start.next;
            start.next=p;

        }
        return head;
    }
    public static void display(Node head)
    {
        Node start=head;
        while(start!=null)
        {
            System.out.print(start.data+" ");
            start=start.next;
        }
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        Node head=null;
        int T=sc.nextInt();
        while(T-->0){
            int ele=sc.nextInt();
            head=insert(head,ele);
        }
        head=removeDuplicates(head);
        display(head);

    }
}

