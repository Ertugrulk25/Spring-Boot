package generics.classes;
//amacımız: farklı data tipindeki ürün kodlarını tutabilmek için
//ayrı ayrı classlar oluşturmadan (book, phone, laptop,...)
//tek bir class ile ürün objelerini oluşturmak
//ÇÖZÜM:Generic Class oluşturalım

  /*
        E --> Element, collection gibi yapılarda kullanılır
        K --> Key
        V --> Value
        N --> Number
        T --> Type
        S,U,V , vb --> 2., 3. ve 4. tipler için
  */

/*
GenericProduct'da artik T dışında baska veri türü kullanamayacagiz degil mi:Hayır
 */

public class GenericProduct<T> {

    private T code; //T : her hangi bir NON-PRIMITIVE data tipi olabilir
                    //T : data tipine kullanırken karar verilir.

    public String name;

    public int stock;

    //getter-setter


    public T getCode() {
        return code;
    }

    public void setCode(T code) {
        this.code = code;
    }
}
