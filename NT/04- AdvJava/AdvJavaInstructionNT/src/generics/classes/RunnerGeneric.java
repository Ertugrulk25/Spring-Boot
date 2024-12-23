package generics.classes;

import java.util.ArrayList;
import java.util.HashMap;

public class RunnerGeneric {
    public static void main(String[] args) {

        //2 farkli ürün : laptop, book

        //generic yapıları kullanırken data tipine karar verilir.
        GenericProduct<String> laptop=new GenericProduct();//T : String
        laptop.setCode("ABC123");
        //laptop.setCode(123);


        GenericProduct<Integer>book=new GenericProduct<>();//T: Integer
        //book.setCode("123");
        book.setCode(123);
        //sıkı bir data tür denetimi sağlar

        String str= laptop.getCode();//1-Cast problemi kalmadı

        //String str2=book.getCode();//2-Casting'e gerek kalmadığı icin,classcastExceptionda almaktan kurtulmuş olduk

        Integer sayi=book.getCode();

        //------------Önceden bilgimiz generic yapılar-------------
        ArrayList<Boolean>mylist=new ArrayList<>();
        //mylist.add("Abc");

        HashMap<String,Integer>map=new HashMap<>();
        map.put("generic",123);
        //map.put(123,"generic");


        //------------Çok Param. Generic Class------------------

        //S:String(Ali Can),U:Integer(123)
        GenericClassTwoParam<String,Integer>obj=new GenericClassTwoParam<>("Ali Can",123);
        //S:Integer(1),U:Integer(2)
        GenericClassTwoParam<Integer,Integer>obj2=new GenericClassTwoParam<>(1,2);


    }
}
