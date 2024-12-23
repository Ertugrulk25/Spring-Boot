package generics.bounding;
//T : her şey olabilirdi istersek sınırlandırabiliriz
//T sadece sayısal degerler olabilir
//Integer,Long,Double,Byte,Float,Short -> Number childidir
//T : data tipi matematiksel işlemler yapılıcagi zaman number'a üstten sınırlandırma yapılabilir
//generic yapılarda parametre olarak kullanılan data tipi üstten sınırlandırılabilir

public class GenericUpperBound <T extends Number>{//T : String,User,Object  bunlar olamaz

    public T[] numberArray;//field

    //numberArray icindeki elemanin ortalamasını bulan bir method olusturalım
    public Double countAvarage(){
        double sum=0;

        for (T number:this.numberArray){
            sum+=number.doubleValue();//data tiplerinin double'a donusmesini saglar
        }

        double avg=sum/this.numberArray.length;

        return avg;
    }


}
