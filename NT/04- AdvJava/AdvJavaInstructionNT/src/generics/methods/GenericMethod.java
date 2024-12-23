package generics.methods;

import java.util.Arrays;

public class GenericMethod {
    public static void main(String[] args) {

    Integer[]intArr={2,3,5,7,11};
    Double[]doubleArr={1.3,2.5,6.7,8.9,5.4};
    String[]stringArr={"ali can","veli can","hüseyin","osman","Java"};

        System.out.println("-------------printArr kullanımı----------------");
        printArr(intArr);
        printArr(stringArr);
        printArr(doubleArr);

        System.out.println("-------------printArrGeneric kullanımı----------");
        printArrGeneric(intArr);//T : Integer
        printArrGeneric(stringArr);//T : String
        printArrGeneric(doubleArr);//T : Double


        System.out.println("-----------Return tpye i olan generic method----------------");
        Integer eleman1=getFirst(intArr);//T : Integer
        String eleman2=getFirst(stringArr);//T: String
        Double eleman3=getFirst(doubleArr);//T: Double


        System.out.println(eleman1);
        System.out.println(eleman2);
        System.out.println(eleman3);


        System.out.println("----------iki parametreli method----------------");
        printArrayAndElement(intArr,"Ahmet Hoca");//S : Integer ,U :String
        printArrayAndElement(doubleArr,true);//S: Double , U:Boolean
        printArrayAndElement(intArr,5);//S:Integer,U:Integer
        int a=5;
        int b=5;


    }

    //amaç:farkli data tipindeki arrayleri konsala yazdirmasi icin bir method olusturalım
    public static void printArr(Integer[]arr){
        Arrays.stream(arr).forEach(t-> System.out.print(t+" "));
        System.out.println();
    }

    public static void printArr(Double[]arr){
        Arrays.stream(arr).forEach(t-> System.out.print(t+" "));
        System.out.println();
    }

    public static void printArr(String[]arr){
        Arrays.stream(arr).forEach(t-> System.out.print(t+" "));
        System.out.println();
    }

    //keşke methodumuz generic olsaydi...
    public static <T>void printArrGeneric(T[]arr){
        Arrays.stream(arr).forEach(t-> System.out.print(t+" "));
        System.out.println();
    }

    //return type i olan generic bir method olustursak
    //verilen arrayin ilk elamınını donduren bir method

    public static <T> T getFirst(T[]arr){//T : herhangi bir data turu olabilir herhangi bir arrayin degeri olabilir

        T first=arr[0];
        return first;
    }

    //birden fazla parametreli generic method
    public static <S,U>void printArrayAndElement(S[]arr,U obj){//S: Integer,U: String
        //arr[0]=obj;---> S ve U birbirinden farklı tanımlanan generic ifadelerdir

        Arrays.stream(arr).forEach(t-> System.out.print(t+ " "));
        System.out.println(obj);

    }

}
