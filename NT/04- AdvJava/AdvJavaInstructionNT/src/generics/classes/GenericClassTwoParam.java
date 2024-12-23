package generics.classes;
//amacımız: farklı fieldlar da farklı data turune bagımsız olarak kullanma

public class GenericClassTwoParam<S,U> {//Örnek : S: String U: Integer //<K> <V> degil <K,V>

    private S  anahtar;//tüm data türlerini kullanabileyim

    private U deger;//tüm data türlerini kullanabileyim

    //param. cons.
    public GenericClassTwoParam(S anahtar, U deger) {
        this.anahtar = anahtar;
        this.deger = deger;
    }


    //getter-setter

    public S getAnahtar() {
        return anahtar;
    }

    public void setAnahtar(S anahtar) {
        this.anahtar = anahtar;
    }

    public U getDeger() {
        return deger;
    }

    public void setDeger(U deger) {
        this.deger = deger;
    }
}
