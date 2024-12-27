package threads.multiThreading;
/*Bir öğrencinin banka hesabı için para yatırma(deposit) ve çekme işlemleri(withdraw) için uygulama
        Hesapta para yoksa para yatırılması(bakiyenin artması) beklensin.
        Bakiye artınca(yeterli olunca) para çekme gerçekleşsin.*/

//Üretici(producer)-tüketici(consumer)
//wait-notify : thread arasında iletişim kurmayı sağlar
//wait : bir threadin belirli bir kaynağın kilidi serbest bırakmasını
//       ve başka bir threadden sinyal alana kadar beklemesini sağlar,
//       wait methodu genellikle bir kilit mekanızması olan synchronized blok veya method icin kullanılır

//multithreading uygulamalarda bir threading işlemini sürdürebilmesi icin wait/notify wait/interrupt

public class C05_WaitInterrupt {

    public static int balance=0;//alican ve velihanın ortak banka hesabı

    //para yatırma
    public synchronized void deposit(int amount){
        System.out.println(Thread.currentThread().getName()+" para yatırmak istiyor.");
        balance+=amount;
        System.out.println("Para yatırma işlemi başarılı, mevcut bakiye : "+balance);
        //notify();//wait ile bekleyen sıradaki thread'e haber verir
        //notifyAll();//wait ile bekleyen tüm threadlere haber verir

    }





    //para çekme
    public synchronized void withdraw(int amount){
        System.out.println(Thread.currentThread().getName()+" para çekmek istiyor");
        //bakiye yetersiz ise
        if (balance==0||amount>balance) {
            System.out.println("Bakiye yetersiz!!! Mevcut bakiye : " + balance);
            //işleme devam edemez,bekleyecek
            System.out.println("Bakiyenin güncellenmesini bekleyiniz.");
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Cıhaza farklı bir yerden giriş gerçeklesti ve bakiye güncelleniyor");
            }

        }

        //bakiye güncellenme durumu
        //bakiye yeterli ise
        if (balance>=amount){
            System.out.println("Bakiye yeterli, işlem gerceklesiyor... ");
            balance-=amount;
            System.out.println("Para çekme işlemi başarılı, mevcut bakiye : "+balance);
        }

    }

    public static void main(String[] args) {

        C05_WaitInterrupt obj=new C05_WaitInterrupt();

        //para çekme ve yatırma işlemlerini 2 tane thread'e yaptıralım
        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                obj.withdraw(1000);//harcama
            }
        });
        thread1.setName("AliCan");//tüketici

        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
               /* try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }*/
                obj.deposit(2000);//yatırıcak
                thread1.interrupt();//Thread'i wait,sleep,join ile bekletmekte ise exception fırlatır
                //bu durum işlemi sürdürmek icin kullanılır

            }
        });

        thread2.setName("VeliHan");//üretici

        thread1.start();
        thread2.start();

    }



}
