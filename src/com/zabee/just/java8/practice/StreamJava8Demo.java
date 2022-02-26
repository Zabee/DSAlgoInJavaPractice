import java.util.stream.*;
import java.util.*;

public class StreamJava8Demo{
  
  public static void main(String []args){
    Stream<Integer> intStream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    Stream<String> strStream = Stream.of("Abu","Umar","Uthman","Ali");
    
    IntStream integerStream = IntStream.of(10, 9, 8, 7, 6, 5, 4, 3, 2, 1);
    LongStream longStream = LongStream.of(1l, 2l, 3l, 4l, 5l, 6l, 7l, 8l, 9l, 10l);
    DoubleStream doubleStream = DoubleStream.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0);
    
    // Do all regular operation that we do numsList.stream() ;)
    
    List<Integer> nums = Stream.iterate(0, i -> i+1)
                                .limit(10)
                                .map(n -> n*2) //Double the number
                              .collect(Collectors.toList());
      nums.stream().forEach(System.out::println);
      
      List<Book> bookObjects = createBookObjects();
      Map<Integer, String> bookISBNNameMap = new HashMap<>();
      bookISBNNameMap = bookObjects.stream()
                                    .collect(Collectors.toMap(Book::getISBN, Book::getName));
        bookISBNNameMap.forEach((k, v) -> System.out.println(k + " : " + v));
  }
 
 private static List<Book> createBookObjects(){
     List<Book> books = new ArrayList<>();
     books = Stream.iterate(0, i->i+1)
                    .limit(10)
                    .map(i -> new Book(i, "Name" + i))
                    .collect(Collectors.toList());
     return books;
 }
 
 private static class Book{
    int ISBN; //Ideally, this should be a string
    String name;
    
    public Book(int ISBN, String name){
        this.ISBN = ISBN;
        this.name = name;
     }
     public int getISBN(){
        return this.ISBN;
     }
     
     public String getName(){
        return name;
     }
 } 
}

/** Output
        0
        2
        4
        6
        8
        10
        12
        14
        16
        18
        0 : Name0
        1 : Name1
        2 : Name2
        3 : Name3
        4 : Name4
        5 : Name5
        6 : Name6
        7 : Name7
        8 : Name8
        9 : Name9
**/
