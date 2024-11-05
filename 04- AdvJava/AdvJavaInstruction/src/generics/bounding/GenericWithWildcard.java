package generics.bounding;

//wildcard(?) : joker, bilinmeyen data tipi
//generic yapıları kullanırken alttan veya üstten sınırlandırabiliriz.

import generics.classes.GenericProduct;

import java.util.ArrayList;
import java.util.List;

public class GenericWithWildcard {

    public static void main(String[] args) {

        List<Integer> integerList=new ArrayList<>();
        List<Double> doubleList=new ArrayList<>();
        List<String> stringList=new ArrayList<>();
        List<Number> numberList=new ArrayList<>();
        List<Object> objectList=new ArrayList<>();
        objectList.add("asd");


        //----------------------------------------------------
        addElements(integerList);
       // addElements(doubleList);--> Double Integerın parentı değil, kardeşidir.
        addElements(numberList);
        addElements(objectList);

        //----------------------------------------------------

        multiplyByTwo(integerList);
        multiplyByTwo(doubleList);
        //multiplyByTwo(stringList);
        multiplyByTwo(numberList);
        //multiplyByTwo(objectList);-->Object Numberın Parentıdır!!!




    }

    //generic yapıyı kullanırken alttan sınırlama
    //Task : Listeye 1 den 10 a kadar tam sayıları yazdıran bir metod tanımlayalım.
    //E:Integer-> Number -> Object
    public static void addElements(List<? super Integer> list){

        for (int i=1;i<11;i++){
            list.add(i);
        }
    }


    //generic yapıyı kullanırken üstten sınırlama
    //Task:listedeki elemanları 2 ile çarpan bir metod tanımlayalım
    //E: Number ve childları
    public static void multiplyByTwo(List<? extends Number> list){

       // list.add(3);

        list.stream().map(t->2*t.doubleValue());

    }

    //NOT: List<?> ve List<T> benzer fakat farklı kullanımı vardır!!!
   // List<T> list1,List<U> list2
   // List<?> list1,List<?> list2

}
