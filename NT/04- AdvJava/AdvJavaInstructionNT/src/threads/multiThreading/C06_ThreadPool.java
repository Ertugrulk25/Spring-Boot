package threads.multiThreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//threadlerle calışmak her zaman maliyetlidir
// a: fazla is yaparak maliyeti yükselttim
// b: az isci tutarak maliyeti azalttım
public class C06_ThreadPool {

    public static void main(String[] args) {
        //9 tane paket olusturayım 9 paket icinde 9 tane işci olusturalım bu benim a planım idi

        ExecutorService service= Executors.newFixedThreadPool(3);
        //aktif calisan 4 tane
        Thread kargo1=new ThreadCreator("A",5000);
        Thread kargo2=new ThreadCreator("B",3000);
        Thread kargo3=new ThreadCreator("C",4000);
        Thread kargo4=new ThreadCreator("D",1000);
        Thread kargo5=new ThreadCreator("E",2000);
        Thread kargo6=new ThreadCreator("F",5000);
        Thread kargo7=new ThreadCreator("G",4000);
        Thread kargo8=new ThreadCreator("H",7000);
        Thread kargo9=new ThreadCreator("I",8000);
/*
        kargo1.start();
        kargo2.start();
        kargo3.start();
        kargo4.start();
        kargo5.start();
        kargo6.start();
        kargo7.start();
        kargo8.start();
        kargo9.start();
*/
        service.execute(kargo1);
        service.execute(kargo2);
        service.execute(kargo3);
        service.execute(kargo4);
        service.execute(kargo5);
        service.execute(kargo6);
        service.execute(kargo7);
        service.execute(kargo8);
        service.execute(kargo9);

        service.shutdown();


    }

}

class ThreadCreator extends Thread{

    public String task;//her threadin yaptiği işin ismi

    public int duration;//her threading yapıcı işin suresi;//

    //paramli cons.
    public ThreadCreator(String task, int duration) {
        this.task = task;
        this.duration = duration;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" işe başladı. Görevi "+this.task);
        System.out.println();
        try {
            Thread.sleep(this.duration);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName()+" işi tamamladı....");
        System.out.println();
    }
}

