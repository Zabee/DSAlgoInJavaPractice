class Person{
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
public class ShallowCopyDemo {
    
    public static void main(String args[]) {
        //Shallow copy
        Contact c = new Contact(123, "a@a.com", 456);
        Address a = new Address(1, "StreetName1", "City1", "State1", "Country1");
        Person mother = new Person("MotherName", a, c);
        Person daughter = new Person("Daughter", a, c);
        System.out.println(mother);   
        System.out.println(daughter);
        
        daughter.contact.mobileNo = 9900;
        System.out.println("\nAfter updating the daughter mobile number");
        //Bug, as this is shallow copy it changes both persons's mobile number
        System.out.println(mother);   
        System.out.println(daughter);
        
        
        //Deep copy fixes this problem
        
    }
}

/** Output
        MotherName	1	StreetName1	City1	State1	Country1	a@a.com	123	456
        Daughter	  1	StreetName1	City1	State1	Country1	a@a.com	123	456

        After updating the daughter mobile number
        MotherName	1	StreetName1	City1	State1	Country1	a@a.com	9900	456
        Daughter	  1	StreetName1	City1	State1	Country1	a@a.com	9900	456
**/
