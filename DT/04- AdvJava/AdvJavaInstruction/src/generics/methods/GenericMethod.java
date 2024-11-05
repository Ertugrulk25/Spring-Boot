package generics.methods;

import java.util.Arrays;

public class GenericMethod {

    public static void main(String[] args) {

        Integer[] intArr={2,3,8,99,55};
        Double[] doubleArr={1.3,35.6,99.9,0.5};
        String[] stringArr={"Java","generics","hayatımızı","kolaylaştırır"};


        System.out.println("-----------------printArr kullanımı---------------------");
        printArr(intArr);
        printArr(doubleArr);
        printArr(stringArr);


        System.out.println("-----------------printArrGeneric kullanımı---------------------");
        printArrGeneric(intArr);//T:Integer
        printArrGeneric(doubleArr);//T:Double
        printArrGeneric(stringArr);//T:String


        System.out.println("-----------------return type ı olan generic metod----------------------");

        Integer eleman=getFirst(intArr);//T:Integer
        String eleman2=getFirst(stringArr);//T:String

        System.out.println("----------------iki paramli metod---------------------");
        printArrAndElement(stringArr,5);//S:String U:Integer
        printArrAndElement(intArr,"abc");//S:Integer U:String
        printArrAndElement(intArr,5);//S:Integer U:Integer


    }


    //amaç: farklı data tipindeki arrayleri konsola yazdırma için metod tanımlama
    //farklı datat tipleri ile kullanmak için: overloading....
    public static void printArr(Integer[] arr){

        Arrays.stream(arr).forEach(t-> System.out.print(t+" "));
        System.out.println();

    }
    public static void printArr(String[] arr){

        Arrays.stream(arr).forEach(t-> System.out.print(t+" "));
        System.out.println();

    }
    public static void printArr(Double[] arr){

        Arrays.stream(arr).forEach(t-> System.out.print(t+" "));
        System.out.println();

    }

    //keşke metodumuz generic olsaydı...
    public static <T> void printArrGeneric(T[] arr){
        Arrays.stream(arr).forEach(t-> System.out.print(t+" "));
        System.out.println();
    }

    //return type ı olan generic metod?
    //verilen arrayin ilk elemanını döndüren metod

    public static <T> T getFirst(T[] arr){

        T first=arr[0];

        return first;
    }

    //birden fazla parametreli generic metod
    public static <S,U> void printArrAndElement(S[] arr,U obj){//S:String , U:Integer

//        arr[0]=obj;--->data tipi belli değil, farklı data tipleri olabilir
//        arr[0]=3;


        Arrays.stream(arr).forEach(t-> System.out.print(t+" "));
        System.out.println(obj);

    }

    public static <T> void printArrAndElement2(T[] arr,T obj){

          arr[0]=obj;//--->data tipi belli değil,fakat ikisi de T data tipinde
//     arr[0]=3;


        Arrays.stream(arr).forEach(t-> System.out.print(t+" "));
        System.out.println(obj);

    }



}
