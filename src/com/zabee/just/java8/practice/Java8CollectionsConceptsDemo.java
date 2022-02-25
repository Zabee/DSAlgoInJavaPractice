import java.util.*;
import java.util.stream.*;

public class Java8CollectionsConceptsDemo{
  
  public static void main(String []args){
      
    List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    
    //1. ForEach
    nums.forEach(System.out::print);
    System.out.println();    

    //2. Stream
    nums.stream()//
        .forEach(System.out::print);
    System.out.println();
    
    //3. Filter
    nums.stream()//
        .filter(n -> n % 2 ==0)//
        .forEach(System.out::print);
    System.out.println();

    //4. FindAny
    Optional<Integer> res = nums.stream()//
        .filter(n -> n > 10)//
        .findAny();
    System.out.println("Any number > 10 : "+ res.isPresent());
    
    //4. Map
    List<Integer> resNums = nums.stream()//
        .map(n -> n*2)// Double the value of every number
        .collect(Collectors.toList());
    System.out.print("Result:");
    resNums.forEach(System.out::print);
    System.out.println();

    //5. FlatMap
    List<String> namesA = Arrays.asList("Abdullah", "Amr", "Abid");
    List<String> namesB = Arrays.asList("Babur", "Bark");
    List<String> namesC = Arrays.asList("Camel", "Cat");
    List<String> allNames = Stream.of(namesA, namesB, namesC)//
            .flatMap(names -> names.stream())//
            .map(name -> name.toUpperCase())
            .collect(Collectors.toList());
    allNames.forEach(System.out::println);
    
    //6. MapReduce
    int sumOfAllNums = nums.stream()//
                            .map(n -> n)//
                            .reduce(0, (x, y) -> x + y); //0 - initial value, binaryOperator
    System.out.println("Sum of all numbers : " + sumOfAllNums);
    
    List<Student> students = createStudentObjects();
    double totalPercentage = students.stream()//
                                        .map(s1 -> s1.studentPercentageMarks)
                                        .reduce(0, (spm1, spm2) -> spm1 + spm2);
    double overAllStudentsPercentage = totalPercentage / students.size();
    System.out.println("overAllStudentsPercentage: " + overAllStudentsPercentage);
  }
    private static class Student{
        public Student(int sid, int spm){
            this.studentId = sid;
            this.studentPercentageMarks = spm;
        }
        int studentId;
        int studentPercentageMarks;
    }

    private static List<Student> createStudentObjects(){
        List<Student> students = new ArrayList<>();
        for(int i=1; i<=10; i++){
            students.add(new Student(i, i*8));
        }
        return students;
    }
}


/** Output
        12345678910
        12345678910
        246810
        Any number > 10 : false
        Result:2468101214161820
        ABDULLAH
        AMR
        ABID
        BABUR
        BARK
        CAMEL
        CAT
        Sum of all numbers : 55
        overAllStudentsPercentage: 44.0
**/
