package threads;
//1.YOL : Thread Classını extend ederek
public class MyThread extends Thread{

    @Override
    public void run() {
        //threade yaptırmak istediğimiz işler(kodları)
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Çalışan thread : "+Thread.currentThread().getName());
        System.out.println("MyThread threadi çalışıyor:HARİKA:)");
    }
}
