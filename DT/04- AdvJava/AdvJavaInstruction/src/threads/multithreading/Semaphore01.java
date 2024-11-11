package threads.multithreading;

import java.util.concurrent.Semaphore;
/*
Semaphore, aşırı yüklenmeyi önlemek için
n tane(2,3,4....) aynı anda ortak bir kaynağa erişmesine
izin vermemizi sağlar.Örn:Asansör

Synchronized, aynı anda ortak bir kaynağa SADECE 1
threadin erişmesine izin vermemizi sağlar.
Örn:kabin
 */
public class Semaphore01 {
    public static void main(String[] args) {


        Semaphore semaphore=new Semaphore(4);
        Car car1=new Car("Audi",8000,semaphore);
        Car car2=new Car("Toyota",5000,semaphore);
        Car car3=new Car("BMW",2000,semaphore);
        Car car4=new Car("Opel",1000,semaphore);
        Car car5=new Car("Skoda",9000,semaphore);
        Car car6=new Car("Honda",3000,semaphore);
        Car car7=new Car("Mercedes",6000,semaphore);
        car1.start();
        car2.start();
        car3.start();
        car4.start();
        car5.start();
        car6.start();
        car7.start();//7 tane aktif thread






    }
}

class Car extends Thread{

    public String carName;

    public int duration;

    public Semaphore semaphore;//sınırlı kapasitenin izinlerini takip etmek için

    //paramli const
    public Car(String carName, int duration, Semaphore semaphore) {
        this.carName = carName;
        this.duration = duration;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        System.out.println(this.carName+" park etmek istiyor...");
        //burada başka kodlar
        try {

            semaphore.acquire();//ortak kaynağa erişim iznini kontrol ediyor
            //ortak kaynağın başlangıcı(veritabanı bağlantısı ile ilgili işler)
            System.out.println("---> "+this.carName+" park alanına girdi....");
            Thread.sleep(duration);
            System.out.println("<---"+this.carName+" park alanından çıkıyor..." );
            //ortak kaynağın sonu
            semaphore.release();//izin belgesi serbest bırakılır,müsait alan sayısı artılır.

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //burada başka kodlar

    }
}
