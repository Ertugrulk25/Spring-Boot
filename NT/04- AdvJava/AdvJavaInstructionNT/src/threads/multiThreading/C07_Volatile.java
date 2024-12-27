package threads.multiThreading;

public class C07_Volatile {

    public static volatile int flag=0;
    //volatile : sadece flag değişkenin main memoryden okunmasını ve yazılmasını saglar

    public static void main(String[] args) {
        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
               // int sayac=0;
                while (flag==0){
                 //   sayac++;
                    System.out.println("bu sadece bir RİSK!");
                }
              //  System.out.println("işlem gerceklesene kadar yazdıgı sayı : "+sayac);
            }
        });
        thread1.start();
        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                flag=1;
                System.out.println("flag değişkeni değisti.");
            }
        });
        thread2.start();
    }
}
