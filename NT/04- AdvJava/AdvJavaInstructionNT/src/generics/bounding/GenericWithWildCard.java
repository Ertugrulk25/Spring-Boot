package generics.bounding;
//WildCard(?) : Joker ,bilinmeyen data tipi
//generic yapıları kullanırken alttan veya üstten sınırlandırma yapılabilir

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class GenericWithWildCard {

    public static void main(String[] args) {
        List<Integer>integerList=new ArrayList<>();
        List<String>stringList=new ArrayList<>();
        List<Double>doubleList=new ArrayList<>();
        List<Float>floatList=new ArrayList<>();
        List<Number>numberList=new ArrayList<>();
        List<Object>objectList=new ArrayList<>();

        //-----------------------------------------------------
        addElements(integerList);
       //addElements(stringList);
       //addElements(doubleList);//double ile Integer kardeştir
       //addElements(floatList);
        addElements(numberList);
        addElements(objectList);
        System.out.println(integerList);
        System.out.println(numberList);
        System.out.println(objectList);


    }

    //Generic yapıyı alttan sınırlandırma
    //task : Listeye 1Den 10A kadar tam sayılari yazdıran bir method olusturalım
    //E:Integer ->Number->Object
    public static void addElements(List<? super Integer> list){
        for (int i = 1; i <11 ; i++) {
            list.add(i);
        }
    }

    //generic yapıyı kullanırken üstten sınırlandırma
    //Task : Listedeki elemanlari 2 katına cıkarma işlemi uygulayınız
    //E: Number ve altında bulunanlar
    public static void multiplyByTwo(List<? extends Number> list){

        list.stream().map(t->2*t.doubleValue());
    }



}
