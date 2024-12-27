package generics.interfaces;
//1.SEÇENEK Generic bir interface'i implement'e eden class generic olmalıdır

public class C02_GenericInterfaceImpl<T> implements C01_GenericInterface<T>{
    //T'nin Kırmızı yanma sebebi bizim generic ifadenin tanımlanmaması
    @Override
    public void print(T value) {
        //Body
    }

    @Override
    public T find() {
        //Body
        return null;
    }//generic yapmamız lazım
    //T'nin Kırmızı yanma sebebi bizim generic ifadenin tanımlanmaması

}
