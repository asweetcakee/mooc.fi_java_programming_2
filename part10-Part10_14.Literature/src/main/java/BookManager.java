
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mefferio
 */
public class BookManager {
    private List<Book> books;

    public BookManager() {
        this.books = new ArrayList<>();
    }
    
    public void add(String title, int age){
        this.books.add(new Book(title, age));
    }
    
    public int quantityOfAddedBooks(){
        return this.books.size();
    }
    
    public void printBooks(){
        sortByAge();
        this.books.stream()
                .forEach(book -> System.out.println(book));
    }
    
    public void sortByAge(){
        Comparator<Book> comparator = Comparator
                .comparing(Book::getAge)
                .thenComparing(Book::getTitle);
        //Collections.sort(this.books, comparator);
        this.books.sort(comparator);
    }
}
