package generics.interfaces;
//1.SEÇENEK: Generic bir interfacei implemente eden class da generic olmalı

public class GenericInterfaceImpl<T> implements GenericInterface<T>{
    @Override
    public void print(T value) {

        //body

    }

    @Override
    public T find() {

        //body
        return null;
    }
}
