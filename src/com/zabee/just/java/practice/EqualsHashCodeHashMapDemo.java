import java.util.*;


// Reference - https://stackoverflow.com/questions/1894377/understanding-the-workings-of-equals-and-hashcode-in-a-hashmap 
class Person implements Cloneable{
    String name;
    String dept;
    private static int hashValue = 0;
    public Person(String name, String dept){
        this.name = name;
        this.dept = dept;
    }
    
    @Override
    public String toString(){
        return this.name + "\t" + this.dept;
    }
    
    @Override
    public boolean equals(Object p){
        Person person = (Person)p;
        return this.name.equals(person.name);
        //This determines which value in it
    }
    
    @Override
    public int hashCode(){
        return hashValue++; //If this is same then only one ZABEE will be seen
        //This determines the bucket
    }
}

class Course{
    String courseName;
    public Course(String crsName){
        this.courseName = crsName;
    }
     @Override
    public String toString(){
        return this.courseName;
    }
}

public class EqualsHashCodeHashMapDemo {
    
    public static void main(String args[])throws CloneNotSupportedException {
        Map<Person, Course> personHashMap = new HashMap<>();
        Course p = new Course("Physics");
        Course c = new Course("Chemistry");
        Course m = new Course("Maths");
        Course b = new Course("Biology");
        
        Person p1 = new Person("Zabee", "CS");
        Person p2 = new Person("Zabee", "BCA");
        Person p3 = new Person("Doe", "MCA");
        Person p4 = new Person("Abraham", "EE");
        Person p5 = new Person("Abu Talib", "EC");
        
        personHashMap.put(p1, p);
        personHashMap.put(p2, c);
        personHashMap.put(p3, m);
        personHashMap.put(p4, b);
        
        for(Map.Entry<Person, Course> personCourseMap : personHashMap.entrySet()){
            System.out.println(personCourseMap.getKey() + " : " + personCourseMap.getValue());
        }

    }
}

/** Output
    Zabee	CS : Physics
    Zabee	BCA : Chemistry
    Doe	MCA : Maths
    Abraham	EE : Biology
**/
