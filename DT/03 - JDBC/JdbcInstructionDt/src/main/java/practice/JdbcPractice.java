package practice;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcPractice {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        //n00-ADIM:Veri tabanı sürücü sınıfını kaydetme
        Class.forName("org.postgresql.Driver");

        //n00:ADIM:bağlantı:açıl sussam açıl susam
        Connection con =DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_dt","techpro","password");

        //n00:statement veya preparedstatement
        Statement st=con.createStatement();


        //n01:countries tablosunda, ülke kodu(country_code) 'TR' olan ülkenin telefon kodunu bulun.
        System.out.println("---------------------------------------------------------1");
        String sql1="SELECT phone_code FROM countries WHERE country_code='TR'";
        ResultSet rs1 =st.executeQuery(sql1);
        if (rs1.next()){
            System.out.println("Telefon kodu: "+rs1.getInt("phone_code"));
        }

        //n02: ogrenciler tablosunda, puanı 500’den büyük olan öğrencilerin isimlerini
        // ve şehirlerini getirin.(preparedstatement)
        System.out.println("---------------------------------------------------------2");
        String sql2="SELECT isim, sehir FROM ogrenciler WHERE puan>?";
        PreparedStatement ps2=con.prepareStatement(sql2);
        ps2.setInt(1,500);

        ResultSet rs2=ps2.executeQuery();

        while (rs2.next()){
            System.out.println("isim : "+rs2.getString(1)+
                              " - sehir  : "+rs2.getString(2));
        }



        //n03. bolumler tablosuna yeni bir bölüm ekleyin.
        // Bölüm adı 'Mimarlık', taban puanı 510, kampüsü 'Hisar' olsun.(kullanıcıdan alınan bilgiler)

        System.out.println("---------------------------------------------------------3");
        PreparedStatement ps3=con.
                prepareStatement("INSERT INTO bolumler(bolum,taban_puani,kampus) VALUES(?,?,?)");
        ps3.setString(1,"Mimarlık");
        ps3.setInt(2,510);
        ps3.setString(3,"Hisar");

        int inserted=ps3.executeUpdate();

        if (inserted>0){
            System.out.println("Kayıt ekleme başarılı"+inserted);
        }

        //n04. developers tablosunda maaşı 5000’den fazla olan geliştiricilerin isimlerini
        // bir listeye ekleyiniz.

        System.out.println("---------------------------------------------------------4");

        String sql4="SELECT name FROM developers WHERE salary>5000";
        ResultSet rs4=st.executeQuery(sql4);

        List<String> names=new ArrayList<>();

        while (rs4.next()){
            names.add(rs4.getString(1));
        }
        System.out.println(names);

        //n05. ogrenciler tablosundaki her öğrenciye 50 puan bonus ekleyin.
        System.out.println("---------------------------------------------------------5");
        PreparedStatement ps5=con.prepareStatement("UPDATE ogrenciler SET puan=puan+?");
        ps5.setInt(1,50);

        int updated=ps5.executeUpdate();

        System.out.println("öğrencilerin puanı artırıldı : "+updated);

        //n06. developers tablosunda 'Java' programlama diliyle çalışan
        // en yüksek maaşlı geliştiriciyi bulun.(name,salary)
        System.out.println("---------------------------------------------------------6");

        ResultSet rs6=st.executeQuery("SELECT name,salary FROM developers" +
                           " WHERE prog_lang='Java'" +
                           " ORDER BY salary DESC LIMIT 1");
        if (rs6.next()){
            System.out.println("isim: "+rs6.getString("name")+
                    " - max. maaş: "+rs6.getDouble("salary"));
        }

        System.out.println("---------------------------------------------------------6-alternatif");

        //alternatif çözüm
        ResultSet rset6=st.executeQuery("SELECT name,salary FROM developers " +
                            "WHERE prog_lang = 'Java' " +
                "AND salary = (SELECT MAX(salary) FROM developers WHERE prog_lang = 'Java')");
        while (rset6.next()){
            System.out.println("isim: "+rset6.getString("name")+
                    " - max. maaş: "+rset6.getDouble("salary"));
        }

        //n07. countries tablosundaki toplam ülke sayısını bulun.
        System.out.println("---------------------------------------------------------7");

        ResultSet rs7=st.executeQuery("SELECT COUNT(*) AS ulke_sayisi FROM countries");

        if (rs7.next()){
            System.out.println("Toplam ülke sayısı : "+rs7.getInt("ulke_sayisi"));
        }

        //n08. developers tablosunda maaşı en düşük olan geliştiricinin bilgilerini silin.
        System.out.println("---------------------------------------------------------8");
        int deleted=st.executeUpdate("DELETE FROM developers " +
                             "WHERE salary=(SELECT MIN(salary) FROM developers)");

        System.out.println(deleted+" tane satır silindi.");

        //n09. ogrenciler ve bolumler tablolarını birleştirerek,
        // öğrencilerin isimlerini ve okudukları bölümün kampüslerini getirin.


        System.out.println("---------------------------------------------------------9");

        ResultSet rs9=st.executeQuery("SELECT o.isim, b.kampus " +
                            "FROM ogrenciler o INNER JOIN bolumler b ON o.bolum=b.bolum");

        while (rs9.next()){
            System.out.println("isim : "+rs9.getString("isim")+
                    " kampüs: "+rs9.getString("kampus"));
        }

        //10. ogrenciler tablosunda her şehirdeki öğrenci sayısını bulun
        // ve azalan sırayla listeleyin.
        System.out.println("---------------------------------------------------------10");

        String sql10="SELECT sehir,COUNT(*) ogrenci_sayisi FROM ogrenciler " +
                "GROUP BY sehir ORDER BY ogrenci_sayisi DESC";
        ResultSet rs10=st.executeQuery(sql10);
        while (rs10.next()){
            System.out.println("şehir : "+rs10.getString("sehir")
            +" - öğrenci sayısı : "+rs10.getInt("ogrenci_sayisi"));
        }

        //ödev 1: developers tablosunda her programlama dili için ortalama maaşı bulun
        // ve sonuçları büyükten küçüğe sıralayın.

        //ödev 2: developers tablosunda programlama dillerine göre geliştirici sayısını
        // ve toplam maaşı hesaplayın. Sonuçları geliştirici sayısına göre azalan sırada sıralayın.


        //n00:kaynakları kapatma
        ps2.close();
        ps3.close();
        ps5.close();
        st.close();
        con.close();

    }
}
