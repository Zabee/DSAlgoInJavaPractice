import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class MethodReferenceJava8Demo {
    
    private static class Student{
        public Student(int sid, String name){
            this.sid = sid;
            this.name = name;
        }
        int sid;
        String name;
        
        @Override
        public String toString(){
            return sid + "\t" + name;
        }
    }
    
    private static class StudentUtils{
        public static String nameToUpperCase(String name){
            return name.toUpperCase();
        }
        
        public String nameToLowerCase(String name){
            return name.toLowerCase();
        }
        
    }
    
    private static List<Student> createStudentObjects(){
        List<Student> students = new ArrayList<>();
        List<String> names = Arrays.asList("Abdul","Bob","Cameron","Don","Eva","Fan","Goerge","Ham","Sam","Tom");
        for(int i=1; i<=10; i++){
            students.add(new Student(i, names.get(i-1)));
        }
        return students;
    }

    public static void main(String args[]) {
        List<Student> students = createStudentObjects();
        
        //Method static reference
        List<String> upperCaseNames = students.stream()//
                                                .map(s -> s.name)//
                                                .map(StudentUtils::nameToUpperCase)
                                                .collect(Collectors.toList());
                        //OR//
        Function<String, String> upperCaseConverterFn = StudentUtils::nameToUpperCase;
        upperCaseNames = students.stream()//
                                            .map(s -> s.name)//
                                            .map(upperCaseConverterFn)
                                            .collect(Collectors.toList());                
        upperCaseNames.forEach(System.out::println);
        StudentUtils studentUtilsObj = new StudentUtils();
        
        //Method instance reference
        List<String> lowerCaseNames = upperCaseNames.stream()
                                                    .map(studentUtilsObj::nameToLowerCase)
                                                    .collect(Collectors.toList());
        Function<String, String> lowerCaseConverter = studentUtilsObj::nameToLowerCase;
                        //OR//
        lowerCaseNames = upperCaseNames.stream()
                                        .map(lowerCaseConverter)
                                        .collect(Collectors.toList());                
        lowerCaseNames.forEach(System.out::println);
        
        //Constructor reference
        BiFunction<Integer, String, Student> bfn = Student::new;
        Student studentObj = bfn.apply(10, "Zabee");
        System.out.println(studentObj);
    }
}
