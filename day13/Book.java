/**
 * Created by PeakeAndSons on 2016-12-30.
 */
abstract class Book {
    String title;
    String author;

    Book(String t,String a){
        title=t;
        author=a;
    }

    abstract void display();

}

class MyBook extends Book
{
    int price;

    MyBook(String title,String author, int p)
    {
        super(title,author);
        price=p;
    }

    void display()
    {
        System.out.println("Title: "+title);
        System.out.println("Author: "+author);
        System.out.println("Price: " + price);
    }
}
