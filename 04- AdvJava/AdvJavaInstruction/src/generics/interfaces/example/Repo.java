package generics.interfaces.example;

public interface Repo<T> {

    //save: reponun bu metodunu farklı objeler için
    //farklı data tipleri ile kullanmak istiyoruz
    void save(T obj);


    //find :reponun bu metodu farklı objeleri bulmak için
    //farklı data tipinde değer dönsün istiyoruz
    T find();

}
