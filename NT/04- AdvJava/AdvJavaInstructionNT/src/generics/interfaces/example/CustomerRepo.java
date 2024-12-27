package generics.interfaces.example;

public class CustomerRepo implements Repo<Customer>{
    @Override
    public void save(Customer obj) {

    }

    @Override
    public Customer find() {
        return null;
    }
}
