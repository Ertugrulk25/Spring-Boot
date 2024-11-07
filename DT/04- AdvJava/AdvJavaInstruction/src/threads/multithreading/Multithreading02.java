package threads.multithreading;

public class Multithreading02 {

    public static int sayac=0;//ortak olan tabela

    public static void main(String[] args) {

        //task: sayacın değerini 2000 defa artırıp son değerinin 2000 olmasını
        //task için 2 tane thread görevlendireceğiz: Tom ve Jerry
        long start=System.currentTimeMillis();

        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=1;i<11;i++){
                    System.out.println("su satıldı");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                Sayac.increment();//Tom 1000 kere artırma yapacak

                for (int i=1;i<11;i++){
                    System.out.println("su satıldı");
                }
            }
        });
        thread1.setName("Tom");

        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=1;i<6;i++){
                    System.out.println("meşrubat satıldı");
                }
                Sayac.increment();//Jerry 1000 kere artırma yapacak

                for (int i=1;i<6;i++){
                    System.out.println("meşrubat satıldı");
                }
            }
        });
        thread2.setName("Jerry");
        thread1.start();
        thread2.start();






    }


}
class Sayac{

    //sayacın değerini 1000 kez artıran bir metod
    //synchronized:metoda aynı anda sadece 1 tane threadin erişmesine izin verir
    public static synchronized void increment(){

        for (int i=1;i<1001;i++){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Multithreading02.sayac++;
            //1-okuma
            // 2-bir artırma
            // 3-yazdırma
            System.out.println(Thread.currentThread().getName()+"-----> sayaç : "+Multithreading02.sayac);
        }

    }

}












