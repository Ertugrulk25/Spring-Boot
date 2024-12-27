package threads.multiThreading;

public class C01_Multithreading {
    public static void main(String[] args) {
        //TASK 1 den 10 a kadar 2 defa sayalım : main thread senkron bir şekilde çalışıyor

        long start=System.currentTimeMillis();
        Counter counter=new Counter("Tuba");
        counter.count();
        long middle=System.currentTimeMillis();
        System.out.println("Birinci count toplam süre : "+(middle-start));//1097
        Counter counter2=new Counter("Neslihan");
        counter2.count();
        long finish=System.currentTimeMillis();
        System.out.println("Ikinci count toplam süre : "+(finish-middle));//1086
        System.out.println("Single thread ile toplam süre : "+(finish-start));//2183

        //TASK 1 den 10 a kadar 2 defa sayalım : MultiThreading : asenkron

        long start2=System.currentTimeMillis();

        Thread counter3=new CounterThread("Ronaldo");
        Thread counter4=new CounterThread("Messi");
        counter3.start();
        counter4.start();
        try {
            counter3.join();//main thread' counter3 işlemini tamamlayana kadar bekle
            counter4.join();//main thread' counter4 işlemini tamamlayana kadar bekle

        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        long finish2=System.currentTimeMillis();


        System.out.println("Multi thread ile toplam süre : "+(finish2-start2));// 1089
    }
}

class Counter{

    public String name;

    //paramli cons.
    public Counter(String name) {
        this.name = name;
    }

    //1 den 10 a kadar sayma işlemi yapan bir method olusturalım
    public void count(){
        for (int i = 1; i <11 ; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            System.out.println(i+"--->"+name);
        }
    }
}

class CounterThread extends Thread{

    public String name;

    public CounterThread(String name) {
        this.name = name;
    }

    //1den 10a kadar yazdıran method
    public void count(){
        for (int i = 1; i <11 ; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            System.out.println(i+"----->"+name);
        }
    }
    //run methodu override edelim : sayma işlemlerini threadlere verelim

    @Override
    public void run() {
        count();//her threade sayma işlemini verdik
    }
}


