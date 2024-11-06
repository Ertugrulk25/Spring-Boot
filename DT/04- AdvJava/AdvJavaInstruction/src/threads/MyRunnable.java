package threads;
//2.YOL: Runnable interfaceini implemente ederek
//NOT:Runnable : Functional Interface: Implemente edilmesi gereken sadece 1 tane metod vardır(run)
public class MyRunnable implements Runnable{

    @Override
    public void run() {
        //threade yaptırmak istediğimiz işler(kodları)
        System.out.println("Çalışan thread : "+Thread.currentThread().getName());
        System.out.println("MyRunnable ile oluşturulan thread başladı...");
    }

}
