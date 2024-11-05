package TicketReservationApp;

import java.util.Scanner;

/*
Project: Bilet Rezervasyon ve Bilet Fiyatı Hesaplama Uygulaması

    1- Uygulama mesafe ve kurallara göre otobüs bileti fiyatı hesaplar sonuç olarak bilet bilgisini verir
    2- Kullanıcıdan     mesafe (KM),
                        yolcu adı, yaşı ,
                        yolculuk tipi (Tek Yön, Gidiş-Dönüş)
                        ve koltuk no bilgilerini alınır.
             NOT: Koltuk numaraları her otobüs için dinamik olmalıdır.)
                  Kullanıcıdan alınan değerler geçerli (mesafe ve yaş değerleri pozitif sayı, yolculuk tipi ise 1 veya 2) olmalıdır.
                  Aksi halde kullanıcıya "Hatalı Veri Girdiniz !" şeklinde bir uyarı verilmelidir.

    3-Fiyat hesaplama kuralları:
       -Mesafe başına ücret:
                  Tek yön: 1 Lira / km       Çift Yön(Gidiş-Dönüş): 2 Lira/km
       -Tekli Koltuk ücreti:
                  Koltuk no 3 veya 3 ün katı ise fiyat %20 daha fazladır(Tek yön: 1.2 Lira/km, Çift Yön:2.4 Lira/km).
       -İlk olarak seferin mesafe, yön ve koltuk no bilgisine göre fiyatı hesaplanır,
        sonrasında koşullara göre aşağıdaki indirimler uygulanır ;
                   i)-Çift Yön indirimi:
                               "Yolculuk Tipi" gidiş dönüş seçilmiş ise son bilet fiyatı üzerinden %20 indirim uygulanır.
                   ii)-Yaş indirimi:
                                Kişi 12 yaşından küçükse son bilet fiyatı üzerinden %50 indirim uygulanır.
                                Kişi 65 yaşından büyük ise son bilet fiyatı üzerinden %30 indirim uygulanır.

 */
public class TicketReservationApp {
    public static void main(String[] args) {

      start();

    }

    private static void start() {

        //1-bilet ve otobüs objelerini oluşturalım.
        Bus bus=new Bus("34 TPE 789",33);

        Ticket ticket;

        Scanner scanner=new Scanner(System.in);
        int select;//ÇIKIŞ için 0 ı seçiniz.

        do {
            //kullanıcıdan bilgileri alalım
            System.out.println("Bilet Rezervasyon Sistemine Hoşgeldiniz:)");
            System.out.println("Lütfen ad-soyad giriniz: ");
            String name=scanner.nextLine();

            System.out.println("Lütfen yaşınızı giriniz: ");
            int age=scanner.nextInt();//  \n


            System.out.println("Lütfen gidilecek mesafeyi(KM) giriniz:");
            double km=scanner.nextDouble();

            System.out.println("Yolculuk tipini seçiniz :");
            System.out.println("1-Tek Yön");
            System.out.println("2-Gidiş-Dönüş");
            int type=scanner.nextInt();// \n
            scanner.nextLine();

            System.out.println("Lütfen koltuk no giriniz: ");
            System.out.println("Tekli koltuk ücreti %20 daha fazladır!");
            System.out.println(bus.getSeats());//1, ,3,,,,33
            String seat=scanner.next();//2,56

            //koltuk no rezerve edilmiş mi veya listede var mı
            boolean isReserved=!bus.getSeats().contains(seat);
            //True ise rezerve edilmiş veya bu koltuk no otobüste yok


            //girilen değerler geçerli mi
            if (km>0 && age>0 && (type==1 || type==2) && !isReserved){
                //bileti hazırlayalım
                ticket=new Ticket(km,type,seat,bus);
                ticket.setPrice(age);

                //rezerve edilen koltuğu listeden kaldıralım
                ticket.getBus().getSeats().remove(seat);

                //bileti yazdıralım
                ticket.printTicket(name);

            } else {
                if (isReserved){
                    System.out.println("Seçilen koltuk mevcut değil veya rezerve edilmiştir!");
                }else {
                    System.out.println("Sayın "+name+" hatalı veri girdiniz!");
                }
            }
            System.out.println("Yeni işlem için bir sayı giriniz, ÇIKIŞ için 0 giriniz:");
            select=scanner.nextInt();//1-0
            scanner.nextLine();


        }while (select!=0);
        System.out.println("İyi günler dileriz, yine bekleriz...");

    }


}















