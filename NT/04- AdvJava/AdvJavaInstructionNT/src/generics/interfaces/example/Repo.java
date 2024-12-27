package generics.interfaces.example;

public interface Repo<T> {


    //save : reponun bu methodu farkli objeler icin
    //farkli data tiplerinde kullanılmasını istiyoruz
    void save(T obj);


    //find :  reponun bu methodu farkli objeler icin
    //farkli data tiplerinde kullanılmasını istiyoruz
    T find();
    //kütüphaneler eklicez JPARepository interface
}
