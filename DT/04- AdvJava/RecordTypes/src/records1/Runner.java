package records1;

public class Runner {
    public static void main(String[] args) {

        Employee employee1=new Employee("Jack","Sparrow","jack@mail.com");
        System.out.println(employee1);

        //emaili değştirmek istersek
        employee1.setEmail("jacksparrow@mail.com");
        System.out.println("emaili değşen employee : "+employee1);

        //bazı durumlarda bir kere değerlerini belirledikten sonra
        //fieldları bir daha değiştirilemeyen objelere ihtiyaç duyabiliriz

        System.out.println("-------------------immutable----------------------");
        //immutable class:read-only
        EmployeeImmutable employee2=new EmployeeImmutable("Harry","Potter","harry@mail.com");
        System.out.println(employee2);

        //emaili değiştirmek istersek
        //employee2.setEmail(".......");

        System.out.println("employee2 nin ismi: "+employee2.getFirstname());

        EmployeeImmutable employee3=new EmployeeImmutable("Harry","Potter","harry@mail.com");

        System.out.println("double equal ile : "+(employee2==employee3));//false
        System.out.println("equals metodu ile : "+employee2.equals(employee3));//true

        //peki boiler plate(basma kalıp) kodları kullanmadan
        //immutable class oluşturamaz mıyız?

        //CEVAP: Java 14 ile gelen record type özelliği ile yapabiliriz.
        EmployeeRecord employee4=new EmployeeRecord("Ali","Can","can@mail.com");
        System.out.println("Record employee : "+employee4);

        System.out.println("Record employee ismi: "+employee4.firstname());//getter

        //employee4.setEmail();-->immutable

        EmployeeRecord employee5=new EmployeeRecord("Ali","Can","can@mail.com");

        System.out.println("==  : "+(employee4==employee5));//false
        System.out.println("equals : "+(employee4.equals(employee5)));//true



    }
}
