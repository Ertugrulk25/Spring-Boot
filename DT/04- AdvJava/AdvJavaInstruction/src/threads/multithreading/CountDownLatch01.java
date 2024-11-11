package threads.multithreading;

import java.util.concurrent.CountDownLatch;

/*
bazı threadlerin main thread ve diğer threadlerden önce çalışmasını ve işini
tamamladıktan sonra diğer threadlerin kaldığı yerden devam etmesini istediğimizde
CountDownLatch classının metodları ile öncelik vermek istediğimiz
threadlerin(worker threads) sayısı kadar bir sayaç başlatıp sayaç 0 olana kadar
diğer threadler bekletilebilir.
 */
public class CountDownLatch01 {
    public static void main(String[] args) {

        System.out.println("burada main thread başladı...");

        CountDownLatch latch=new CountDownLatch(3);
        //öncelik vermek istediğimiz thread sayısı ile sayaç oluşturuyoruz

        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Öğrencinin bilgileri alınıyor...");
                System.out.println("Öğrencinin numarası üretiliyor..");
                //hemzemin geçit
                try {
                    latch.await();//thread1, worker threadler işini bitirene kadar , sayaç 0 olana kadar bekler
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Öğrenci kaydediliyor.....");
            }
        });
        thread1.start();

        System.out.println("main thread devam ediyor...");

        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    latch.await();//thread2, workerları bekler
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Öğrencinin düzeyine göre sorular hazırlanıyor...");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        thread2.start();

        //seviye belirlemek için 3 tane thread
        WorkerThreads worker1=new WorkerThreads("writing",6000,latch);
        WorkerThreads worker2=new WorkerThreads("reading",5000,latch);
        WorkerThreads worker3=new WorkerThreads("speaking",3000,latch);
        worker1.start();
        worker2.start();
        worker3.start();
        //workerlar kendi aralarında asenkron:yine yarış halinde

        try {
            latch.await();
//            worker1.join();
//            worker2.join();
//            worker3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Main thread devam ediyor...son satır");






    }
}
class WorkerThreads extends Thread{

    public int duration;

    public CountDownLatch latch;

    //paramli const
    public WorkerThreads(String name, int duration, CountDownLatch latch) {
        super(name);//new Thread(String name)
        this.duration = duration;
        this.latch = latch;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" çalışmaya başladı....");
        System.out.println("Seviye tespiti yapılıyor.....");
        try {
            Thread.sleep(this.duration);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName()+" seviye tespitini tamamladı...");
        latch.countDown();//sayacı bir azaltır
    }
}