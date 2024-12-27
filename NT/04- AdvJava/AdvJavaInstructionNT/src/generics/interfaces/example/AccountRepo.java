package generics.interfaces.example;
//data türüm belli mi?
//account ile ilgili veritabani işlemleri yapacagim class demek
public class AccountRepo implements Repo<Account>{//T : Account sectim
    @Override
    public void save(Account obj) {
        System.out.println("Bu method Account bilgilerini dataBase save eder");
        //Account'i veri tabanına kayıt eder

    }

    @Override
    public Account find() {
        //Account bilgilerini bana bulup dondurur;
        return null;
    }

}
