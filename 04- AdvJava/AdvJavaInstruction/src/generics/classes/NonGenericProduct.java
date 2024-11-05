package generics.classes;
//amacımız: farklı data tipindeki ürün kodlarını tutabilmek için
//ayrı ayrı classlar oluşturmadan (book, phone, laptop,...)
//tek bir class ile ürün objelerini oluşturmak
public class NonGenericProduct {

    private Object code;//123,"A12"
    //code fieldının data tipi Object(tüm data tiplerinin parentı)
    //olduğu için oluşturulan nesnelerin code özelliğinde tüm
    //data tipleri kullanılabilir

    //getter-setter

    public Object getCode() {
        return code;
    }

    public void setCode(Object code) {
        this.code = code;
    }
}
