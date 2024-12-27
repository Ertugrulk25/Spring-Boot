package threads.multiThreading;

import java.util.concurrent.CountDownLatch;

/*
oluşturdugumuz threadlerin icerisinden bazı threadler main thread ve diger olusturdugumuz threadlerden
önceliğe sahip olabiliyor işini tamamladıkta sonra diger threadlerimiz calısmaya devam eder
CountDownLatch methodlar ile oncelik vererek istegimiz threadlerin sayısı kadar
bir sayac baslatıp sayac 0 olaran kadar diger threadlerimizi bekletiriz
*/
public class C09_CountDownLatch {
    public static void main(String[] args) {
        CountDownLatch latch=new CountDownLatch(3);
        //öncelik verecegim thread sayisi ile sayac olusturuyoruz
        System.out.println("Main Threadimizde işe karıştı!!!");
        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Öğrencinin bilgileri alınıyor.....");
                System.out.println("Öğrenci numarası üretiliyor.....");
                //hemzemin geçit
                try {
                    latch.await();//worker thread isini bitirmesini bekler yukarıdaki sayacın 0lanmasını bekler
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Öğrenci kaydediliyor.....");

            }
        });
        thread1.start();

        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Öğrencinin düzeyine soru hazırlanıyor....");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        });
        thread2.start();
        //seviye belirlemek icin 3 sınav olusturalım
        WorkerThreads worker1=new WorkerThreads("writing",6000,latch);
        WorkerThreads worker2=new WorkerThreads("reading",4000,latch);
        WorkerThreads worker3=new WorkerThreads("listing",3000,latch);
        worker1.start();
        worker2.start();
        worker3.start();
        //worker threadler kendi arasında asenkron;
        try {
            latch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Main Thread devam ediyor.... son satır");
    }
}

class WorkerThreads extends Thread{

    public int duration;

    public CountDownLatch latch;

    //paramli cons


    public WorkerThreads(String name, int duration, CountDownLatch latch) {
        super(name);
        this.duration = duration;
        this.latch = latch;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" Çalışmaya başladı");
        System.out.println("Seviye tespiti yapılıyor....");
        try {
            Thread.sleep(this.duration);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName()+" Seviye tespiti tamamlandı.");
        latch.countDown();//sayacı azaltmayı saglar

    }


}
