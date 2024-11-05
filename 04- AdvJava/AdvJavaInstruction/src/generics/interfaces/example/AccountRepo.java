package generics.interfaces.example;
//Account ile ilgili veritabanı işlemleri bu classta yapılmalı
public class AccountRepo implements Repo<Account>{
    @Override
    public void save(Account obj) {

        //veritabanına kaydeder
    }

    @Override
    public Account find() {
        return null;
    }
}
