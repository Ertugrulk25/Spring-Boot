package threads;

public class ThreadCreationWays {

    public static void main(String[] args) {

        //her Java programında default olarak 1 tane thread başlatılır:main thread
        //Thread.currentThread().getName():mevcut threadin ismini getirir.
        System.out.println("Mevcut thread : "+Thread.currentThread().getName());

        //Javada Thread oluşturmanın 2 yolu vardır.
        //run metodu overrride etmeliyiz
        //1:YOL
        Thread thread1=new MyThread();
        thread1.start();//threadi başlatır ve run metodunu çağırır
        //thread1.run();//yeni bir thread başlatılmaz, main thread
        thread1.setName("threadcik:)");


        //2.YOL
        Runnable runnable=new MyRunnable();//inheritance
        Thread thread2=new Thread(runnable);
        thread2.start();
        thread2.setName("canımthreadcimm");


        //2.YOL :anonymous class:isimsiz sınıf
        //Runnable içinde sadece 1 tane implemente edilecek metod var
        Thread thread3=new Thread(new Runnable() {
            @Override
            public void run() {
                //threadin işlemleri
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Çalışan thread : "+Thread.currentThread().getName());
                System.out.println("Anonim class ile üretilen thread başladı...");
            }
        });
        thread3.start();
        thread3.setName("süperthread");

        //2.YOL:Functional Interface: Lambda exp ile
        Thread thread4=new Thread(()->{
            //run metodunun bodysindeyiz:)

            System.out.println("Çalışan thread : "+Thread.currentThread().getName());
            try {
                thread1.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Lambda exp ile üretilen thread başladı...");
        });
        thread4.start();
        thread4.setName("çakmathread");


        //main threadi biraz bekletebiliriz:uyutalım
        try {
            Thread.sleep(1000);//hangi threadin görevleri arasında çağrılırsa o threadi bekletir.
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }


        try {
            thread1.join();//hangi threadin kodları içinde çağrılırsa bu threadi bekletir:thread1 işini bitirene kadar
            thread2.join();//bekletir:thread2 işini bitirene kadar
            thread3.join();//bekletir:thread3 işini bitirene kadar
            thread4.join();//bekletir:thread4 işini bitirene kadar
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }//main thread artık devam edebilir
        System.out.println("main metod burada tamamlandı.");//main thread görevi


        //NOT:her thread kendi işini(run metodu içindeki kodları) senkron(sıralı)
        //threadler kendi arasında ASENKRON çalışır.

    }

}
