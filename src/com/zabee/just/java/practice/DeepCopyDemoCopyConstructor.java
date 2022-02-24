class Person{
    String name;
    Address address;
    Contact contact;
    
    public Person(String name, Address address, Contact contact){
        this.name = name;
        //Copy constructor
        this.address = new Address(address.drNo, address.streetName, address.city, address.state, address.country);
        //Copy constructor
        this.contact = new Contact(contact.mobileNo, contact.emailId, contact.faxNo);
    }
    @Override
    public String toString(){
        return this.name + "\t" + this.address + "\t" +  this.contact;
    }
}

class Contact{
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
}

class Address{
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
}
public class DeepCopyDemoCopyConstructor {
    
    public static void main(String args[]) {
        //Shallow copy
        Contact c = new Contact(123, "a@a.com", 456);
        Address a = new Address(1, "StreetName1", "City1", "State1", "Country1");
        //Copy constructor
        Person mother = new Person("MotherName", a, c);
        //Copy constructor
        Person daughter = new Person("Daughter", a, c);
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
