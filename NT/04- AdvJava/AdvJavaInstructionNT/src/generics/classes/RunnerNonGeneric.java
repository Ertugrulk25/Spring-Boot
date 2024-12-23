package generics.classes;

public class RunnerNonGeneric {
    public static void main(String[] args) {

        //2 farkli ürün : book,laptop
        NonGenericProduct laptop=new NonGenericProduct();//code : null
        laptop.setCode("ABC123");//code(object) fieldinin set özelliği ile String bir değeri set ettim
        laptop.setCode(123);


        NonGenericProduct book=new NonGenericProduct();
        book.setCode(123);//code(object) fieldinin set özelliği ile Integer bir degeri set ettim

        //1.Cast problemi
        String str= (String) laptop.getCode();


        String str2= (String) book.getCode();//2. ClassCastException

        System.out.println(str+str2);//ABC123123
    }
}
