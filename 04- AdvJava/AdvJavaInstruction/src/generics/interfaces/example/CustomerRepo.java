package generics.interfaces.example;

public class CustomerRepo implements Repo<Customer> {
    @Override
    public void save(Customer obj) {

    }

    @Override
    public Customer find() {
        return null;
    }
    //save
    //find
    //update
    //delete
    //.........
}
//ilerisi için NOT: Spring Data JPA: JpaRepository<Customer, Long>