package records1;

import java.util.Objects;

/*
Bazı durumlarda thread güvenliği(thread-safe), cachede veri tutarlılığı,
test kolaylığı vb sebeplerle immutable(değiştirilemez) classlar tanımlamak isteyebiliriz.

 */
public class EmployeeImmutable {//bu classı aynen record ile yapalım

    private final String firstname;

    private final String lastname;

    private final String email;

    //paramli const
    public EmployeeImmutable(String firstname, String lastname, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }

    //getter : read-only
    //setter : final olduğu için, değiştirelemesin diye yazmıyoruz
    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    //toString
    @Override
    public String toString() {
        return "EmployeeImmutable{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this==obj) return true;//employee2.equals(employee2)

        if (obj==null || this.getClass()!=obj.getClass()) return false;
        //employee2.equals(null)
        //employee2.equals(employee1)

        EmployeeImmutable emp=(EmployeeImmutable) obj;
        //employee2.equals(employee3)

        return Objects.equals(this.firstname,emp.firstname) &&
                Objects.equals(this.lastname,emp.lastname) &&
                Objects.equals(this.email,emp.email);
        //emp2 ile emp3 fieldları aynı ise true
    }

    //objeler için benzersiz kodlar üretir
    @Override
    public int hashCode() {
        return Objects.hash(firstname,lastname,email);
    }
}
