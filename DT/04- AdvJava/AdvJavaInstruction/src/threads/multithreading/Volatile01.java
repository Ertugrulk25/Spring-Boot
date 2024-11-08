package threads.multithreading;

public class Volatile01 {

    public static volatile int flag=0;
    //volatile: sadece flag değişkeninin main memoryden okunmasını ve yazılmasını garanti eder.

    public static void main(String[] args) {

        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {

                while (flag==0){
                    System.out.println("Bu sadece bir RİSK!");
                }

            }
        });
        thread1.start();//1.çekirdek, cache:flag=0

        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                flag=1;
                System.out.println("Flag değişkenin değeri değişti.");

            }
        });
        thread2.start();//2.çekirdek, cache:flag=1



    }
}
