package generics.classes;
//amacımız: farklı data tipindeki ürün kodlarını tutabilmek için
//ayrı ayrı classlar oluşturmadan (book, phone, laptop,...)
//tek bir class ile ürün objelerini oluşturmak

public class NonGenericProduct {

    private Object code;//"Ali can",123;
    //code fieldının data türü object(tüm data tiplerinin parenti)
    //bundan kaynakli olusturulan tüm nesneler bu fieldin tum ozelliklerini kullanabilir


    //getter-setter
    public Object getCode() {
        return code;
    }

    public void setCode(Object code) {
        this.code = code;
    }
}
