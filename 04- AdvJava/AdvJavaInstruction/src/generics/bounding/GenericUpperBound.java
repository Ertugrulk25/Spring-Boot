package generics.bounding;
//generic yapılarda parametre olarak kullanılan data tipi üstten sınırlandırılabilir.
//T data tipindeki field ile Matematiksel hesaplama yapacağız.
//T:Number classı ve alt sınıflarıyla üstten sınırlandıralım
//T:BYTE,SHORT,INTEGER,DOUBLE,LONG,FLOAT, NUMBER
public class GenericUpperBound<T extends Number> {//T:String,User,Object X X X

    public T[] numberArray;//field

    //numberArrayin içindeki elemanların ortalamasını bulan bir metod
    public Double countAverage(){

        double sum=0;

        for (T number:this.numberArray){

            sum+=number.doubleValue();//elemanların double data tipine dönüştürülmesini sağlar.
        }

        double avg=sum/this.numberArray.length;

        return avg;
    }






}
