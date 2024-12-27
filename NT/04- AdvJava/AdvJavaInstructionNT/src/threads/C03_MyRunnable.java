package threads;
//2.YOL : Runnable interface'ini implemente ederek
//Not : Runnable = Functional interface : implemente edilmesi gereken sadece 1 tane method vardır(run)
public class C03_MyRunnable implements Runnable{
    @Override
    public void run() {
       // try {
       //     Thread.sleep(3000);
       // } catch (InterruptedException e) {
       //     System.out.println(e.getMessage());
       // }
        //threadde yaptırmak istedigimiz islem
        System.out.println("Çalışan Thread : "+Thread.currentThread().getName());
        System.out.println("MyRunnable ile olusturulan thread portakallı kek yapmaya başladı...");
    }
}

