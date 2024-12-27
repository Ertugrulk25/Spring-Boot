package threads;
//1. YOL : Thread classını extend ederek bir tane thread olusturabiliriz
public class C02_MyThread extends Thread {

    @Override
    public void run() {
       // try {
       //     Thread.sleep(3000);
       // } catch (InterruptedException e) {
       //     System.out.println(e.getMessage());
       // }
        //yaptırmak istedigimiz işlemleri ekleriz
        System.out.println("Çalışan thread : "+Thread.currentThread().getName());
        System.out.println("MyThread calışıyor ve bize birer bardak çay hazırlıyor...");
    }
}
