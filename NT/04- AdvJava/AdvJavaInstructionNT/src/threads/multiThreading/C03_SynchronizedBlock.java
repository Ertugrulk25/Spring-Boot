package threads.multiThreading;

public class C03_SynchronizedBlock {
    public static void main(String[] args) {
        //TASK konsola 1'den 10'a kadar 14 kere alt alta yazdıralım
        //bu task icin 2 tane thread kullanalım

        Characters characters=new Characters();
        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <8 ; i++) {
                    characters.printNumbers();
                  //  try {
                  //      Thread.sleep(1);
                  //  } catch (InterruptedException e) {
                  //      System.out.println(e.getMessage());
                  //  }
                }
            }
        });
        thread1.setName("Fred");
        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <8 ; i++) {
                    characters.printNumbers();
                  // try {
                  //     Thread.sleep(1);
                  // } catch (InterruptedException e) {
                  //     System.out.println(e.getMessage());
                  // }
                }


            }
        });
        thread2.setName("Barnie");

        thread1.start();
        thread2.start();



    }
}

class Characters{
    //tek satırda 1den 10 a kadar yazdıran method
    public /*synchronized*/ void printNumbers(){
        synchronized (this){
            for (int i = 1; i < 11; i++) {
                System.out.print(i + " ");
            }
            System.out.println("----->" + Thread.currentThread().getName());
        }
    //a'dan e'ye kadar alt alta yazdıralım
        for (char i = 'a'; i <='e'; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            System.out.println(i);
        }

    }

}
