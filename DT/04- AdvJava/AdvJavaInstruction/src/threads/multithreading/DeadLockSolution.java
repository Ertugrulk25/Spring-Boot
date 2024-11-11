package threads.multithreading;
/*
Ölümcül kilitlenme; iki veya daha fazla threadin çalışmak için
aynı kaynağa/lara erişmek istemesiyle oluşur.

Kaynağa erişmek için sürekli birbirlerini beklemeleri sonucunda
sistem kaynakları olumsuz etkilenir ve hatta uygulama cevap veremez hale gelir.
 */
public class DeadLockSolution {
    public static void main(String[] args) {

        String sugar="şeker";
        String coffee="kahve";

        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Tom kahveyi kullanmak istiyor...");
                synchronized (coffee){
                    System.out.println(Thread.currentThread().getName()+" "+coffee+" i kullanmaya başladı...");
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName()+" "+sugar+" yi kullanmak istiyor...");
                    synchronized (sugar){
                        System.out.println(Thread.currentThread().getName()+" "+sugar+" yi kullanıyor.. ");
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }//şekeri bıraktı
                }//kahveyi bıraktı
                System.out.println("Tom , Sıcak su ekledi ve kahvesini keyifle yudumluyor....");

            }
        });
        thread1.setName("Tom");
        thread1.start();

        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Jerry kahveyi kullanmak istiyor...");
                synchronized (coffee){
                    System.out.println(Thread.currentThread().getName()+" "+coffee+" yi kullanıyor...");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Jerry şekeri kullanmak istiyor...");
                    synchronized (sugar){
                        System.out.println(Thread.currentThread().getName()+" "+sugar+" yi kullanıyor...");

                    }//şekeri bıraktı
                }//kahveyi de bıraktı
                System.out.println("Jerry , Sıcak su ekledi ve kahvesini keyifle yudumluyor....");
            }
        });
        thread2.setName("Jerry");
        thread2.start();
    }
}
















