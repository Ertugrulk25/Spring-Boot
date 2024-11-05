package generics.classes;

public class RunnerNonGeneric {

    public static void main(String[] args) {

        //2 farklı ürün : book, laptop
        NonGenericProduct laptop=new NonGenericProduct();//code:null
        laptop.setCode("ABC123");//code(Object) özelliğini String ile set ettik


        NonGenericProduct book=new NonGenericProduct();
        book.setCode(123);//code(Object) özelliğini Integer ile set ettik


        //1-CAST problemi!!!

        String str=(String) laptop.getCode();

        String str2=(String) book.getCode();//2-ClassCastException Problemi!!!

        System.out.println(str+str2);

    }

}
