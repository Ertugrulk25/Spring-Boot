package generics.classes;
//amacımız: farklı fieldlarda farklı data tiplerini bağımsız olarak kullanma

public class GenericClassTwoParam<S,U> {//S:String U:Integer

    private S anahtar;//S:tüm NON-PRIMITIVE data tipleri

    private U deger;//U:tüm NON-PRIMITIVE data tipleri

    //paramli const

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
