package threads.multiThreading;

public class C02_MultiThreading {

    public static int sayac=0;//ekrana yansıttıgım bilet nolari

    public static void main(String[] args) {
        //task sayacın deger 2000 olana kadar devam etsin
        //task icin 2 tane thread olusturalım bilet satmasi icin gorevlendiricez
        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <11 ; i++) {
                    System.out.println("Su satıldı");
                }
                Sayac.increment();//tom ile 1000 kere arttırma işlemi
                for (int i = 1; i <11 ; i++) {
                    System.out.println("Su satıldı");
                }
            }
        });

        thread1.setName("Tom");

        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <6 ; i++) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println("Meşrubat Satıldı");
                }
                Sayac.increment();//jerry ile 1000 kere arttırma işlemi
                for (int i = 1; i <6 ; i++) {
                    System.out.println("Meşrubat Satıldı");
                }
            }
        });
        thread2.setName("Jerry");
        thread1.start();
        thread2.start();


    }


}
class Sayac{

    //sayacın degerini 1000 kez artırma işlemi yapan method
    public static synchronized void increment(){//synchronized : aynı anda sadece 1 thread ile işlem yapmaya izin verir

        for (int i = 1; i <1001 ; i++) {
          //  try { //çözüm değil
          //      Thread.sleep(10);
          //  } catch (InterruptedException e) {
          //      throw new RuntimeException(e);
          //  }
            C02_MultiThreading.sayac++;
            System.out.println(Thread.currentThread().getName()+"-----> sayac : "+C02_MultiThreading.sayac);
        }
        //System.out.println(Thread.currentThread().getName()+"-----> sayac : "+C02_MultiThreading.sayac);

    }















}
