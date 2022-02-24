class Person implements Cloneable{
    String name;
    Address address;
    Contact contact;
    
    public Person(String name, Address address, Contact contact){
        this.name = name;
        this.address = address;
        this.contact = contact;
    }
    
    @Override
    public String toString(){
        return this.name + "\t" + this.address + "\t" +  this.contact;
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException{
        Address addres = (Address)this.address.clone();
        Contact contact = (Contact)this.contact.clone();
        Person person = (Person)super.clone();
        person.address = address;
        person.contact = contact;
        return person;
    }
}

class Contact implements Cloneable{
    long mobileNo;
    String emailId;
    long faxNo;
    public Contact(long mobileNo, String emailId, long faxNo){
        this.mobileNo = mobileNo;
        this.emailId = emailId;
        this.faxNo = faxNo;
    }
    @Override
    public String toString(){
        return this.emailId + "\t" +  this.mobileNo + "\t" +  this.faxNo;
    }
        @Override
    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
}

class Address implements Cloneable{
    int drNo;
    String streetName;
    String city;
    String state;
    String country;
    
    public Address(int drNo, String streetName, String city, String state, String country){
        this.drNo = drNo;
        this.streetName = streetName;
        this.city = city;
        this.state = state;
        this.country = country;
    }
     @Override
    public String toString(){
        return this.drNo + "\t" + this.streetName + "\t" +  this.city + "\t" +  this.state + "\t" +  this.country;
    }
    @Override
    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
}
public class DeepCopyDemoCloneMethod {
    
    public static void main(String args[])throws CloneNotSupportedException {
        //Shallow copy
        Contact c = new Contact(123, "a@a.com", 456);
        Address a = new Address(1, "StreetName1", "City1", "State1", "Country1");
        //Copy constructor
        Person mother = new Person("MotherName", a, c);
        //Copy constructor
        Person daughter = (Person)mother.clone();
        daughter.name = "Daughter";
        System.out.println(mother);   
        System.out.println(daughter);
        
        daughter.contact.mobileNo = 990;
        System.out.println("\nAfter updating the daughter mobile number");
        //Copy constructor fixes the problem
        System.out.println(mother);   
        System.out.println(daughter);
    }
}

/** Output
      MotherName	1	StreetName1	City1	State1	Country1	a@a.com	123	456
      Daughter	  1	StreetName1	City1	State1	Country1	a@a.com	123	456

      After updating the daughter mobile number
      MotherName	1	StreetName1	City1	State1	Country1	a@a.com	123	456
      Daughter	  1	StreetName1	City1	State1	Country1	a@a.com	990	456
**/
