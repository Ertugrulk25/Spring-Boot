package threads.multiThreading;

/*
Ölümcül kilitlenme; iki veya daha fazla threadin çalışmak için
aynı kaynağa/lara erişmek istemesiyle oluşur.

Kaynağa erişmek için sürekli birbirlerini beklemeleri sonucunda
sistem kaynakları olumsuz etkilenir ve hatta uygulama cevap veremez hale gelir.
 */

public class C10_DeadLock {
    public static void main(String[] args) {

        String coffee="Kahve";
        String sugar="Şeker";

        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Tom şekeri kullanmak istiyor....");
                synchronized (sugar){
                    System.out.println(Thread.currentThread().getName()+" "+sugar+" i kullanmaya başladı.....");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }//şeker burada bırakıldı
                System.out.println(Thread.currentThread().getName()+" "+coffee+" i kullanmak istiyor....");
                synchronized (coffee){
                    System.out.println(Thread.currentThread().getName()+" "+coffee+" i kullanmaya başladı....");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }//kahve bırakıldı

                System.out.println(Thread.currentThread().getName()+" Sıcak su ekledi ve kahvesini keyifle yudumluyor");
            }
        });
        thread1.setName("Tom");
        thread1.start();

        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+" "+coffee+" i kullanmak istiyor....");
                synchronized (coffee){
                    System.out.println(Thread.currentThread().getName()+" "+coffee+" i kullanmaya başladı....");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName()+"sekeri kullanmak istiyor.");
                    synchronized (sugar){
                        System.out.println(Thread.currentThread().getName()+" "+sugar+" i kullanmaya başladı.....");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }

                    }//sekeri bırakıyor

                }//kahveyi bırakıyor
                System.out.println(Thread.currentThread().getName()+" Sıcak su ekledi ve kahvesini keyifle yudumluyor");

            }
        });
        thread2.setName("Jerry");
        thread2.start();


    }
}
