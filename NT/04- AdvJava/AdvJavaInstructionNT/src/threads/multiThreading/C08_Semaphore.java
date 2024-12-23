package threads.multiThreading;

import java.util.concurrent.Semaphore;
/*
Semaphore, n tane(2,3,4....) aynı anda ortak bir kaynağa erişmesine
izin vermemizi sağlar.

Synchronized, aynı anda ortak bir kaynağa(blok,metod) sadece 1 threadin
 erişmesine izin verir.
*/
//Örn: 7 işcinin calıstıgı bir inşaatta 1 el arabasını sadece 1 işci kullanmasi sychronized   ortak kaynak kullanımı soz konusu!!!!
//                                      4 bardağı sırasıyla 7 işcinin kullanmasi semaphore     ortak kaynak kullanımı soz konusu!!!!

// bu 7 işcinin 12 tane civi cakması gerekmektedi ve bunları sırasıyla surelerine gore islerini dagıtan threadPooldur


public class C08_Semaphore {
    public static void main(String[] args) {
        Semaphore semaphore=new Semaphore(4);//musait olma sayısını belirler
        Car car1=new Car("Audi",8000,semaphore);
        Car car2=new Car("Toyota",5000,semaphore);
        Car car3=new Car("BMC",10000,semaphore);
        Car car4=new Car("Bentley",11000,semaphore);
        Car car5=new Car("Opel",4000,semaphore);
        Car car6=new Car("Ferrari",10000,semaphore);
        Car car7=new Car("Skoda",3000,semaphore);
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

    public Semaphore semaphore;//sınırlı kapasitenin izinlerini takip etmek icin

    public Car(String carName, int duration, Semaphore semaphore) {
        this.carName = carName;
        this.duration = duration;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
                System.out.println(this.carName+ " park etmek istiyor.....");
                try {
                    semaphore.acquire();//ortak kaynağa erişim iznini kontrol eder
            System.out.println("-----> "+this.carName+" park alanına girdi.....");
            Thread.sleep(duration);
            System.out.println("-----> "+this.carName+" park alanından cıkıyor.....");
            semaphore.release();//izin belgesini serbest bırakılır, müsait alan sayısını artırır.


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }



    }

}
