package threads.multithreading;

public class SynchronizedBlock {
    public static void main(String[] args) {
        //TASK: Konsola 1 den 10'a kadar 14 defa alt alta yazdıralım
        //bu task için 2 tane thread kullanalım

        Characters characters=new Characters();
        long start=System.currentTimeMillis();
        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=1;i<8;i++){
                    characters.printCharacters();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        thread1.setName("Fred");

        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=1;i<8;i++){
                    characters.printCharacters();
                }
            }
        });
        thread2.setName("Barnie");
        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long finish=System.currentTimeMillis();
        System.out.println("süre: "+(finish-start));

//blok için geçen süre:17989
//metod için geçen süre:35869
    }
}
class Characters{

    //tek satırda 1 den 10' a kadar yazdıran metod
    public /*synchronized*/ void printCharacters(){

        //1 den 10 a kadar sıralı olarak yazılsın
       synchronized (this) {//tüm metodun kodlarına sırayla erişilmesine gerek yok
            //sadece bu blok yeterli
            for (int i = 1; i < 11; i++) {
                System.out.print(i + " ");
            }
            System.out.println("---->" + Thread.currentThread().getName());
      }

        //a'dan e'ye kadar alt alta yazdırma:sıralı olmasına gerek yok
        //bu kodlar hala asenkron bir şekilde threadler tarafından çalıştırılabilir.
        for (char i='a';i<='e';i++){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(i);

        }
    }

}
