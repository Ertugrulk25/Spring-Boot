package LoginPageApp;

import java.util.*;

//3-adım:userla ilgili metodlar
public class UserService {

    public Scanner scanner=new Scanner(System.in);

    //List<User> users=new ArrayList<>();-->Practice

    private Map<String,String> userInfo=new HashMap<>(); //K:email, V:password

    //4-adım:üye olma metodu
    public void register(){
        System.out.println("Ad-soyad giriniz : ");
        String name=scanner.nextLine();

        //email geçerli mi?geçersizse tekrar sorulmalı
        String email;
        boolean isValid;//T:geçerli F:geçerli değil

        do {
            System.out.println("Email giriniz : ");
            email=scanner.nextLine();//asd@gmail.com

            //geçerli mi
            isValid=validateEmail(email);//T,F

            //email unique olmalı:bu email ile daha önce kayıtlı kullanıcı var mı
            boolean isExistEmail=this.userInfo.containsKey(email);//T
            if (isExistEmail){
                System.out.println("Bu email ile kayıtlı kullanıcı zaten var!");
                isValid=false;
            }

        }while (!isValid);

        //geçerli şifre oluşturma
        String password;
        boolean isValidPassword;

        do {
            System.out.println("Şifrenizi oluşturunuz : ");
            password=scanner.nextLine();

            isValidPassword=validatePassword(password);

        }while (!isValidPassword);

        //user oluşturalım
        User user=new User(name,email,password);

        //userın bilgilerini userInfo ya ekleyelim

        this.userInfo.put(user.getEmail(), user.getPassword());

        System.out.println("Sayın "+user.getName()+", tebrikler, kayıt işlemi başarıyla gerçekleşti.");
        System.out.println("Email ve şifrenizi kullanarak sisteme giriş yapabilirsiniz.");

    }

    //7-adım:giriş işlemi için metod
    public void login(){
        System.out.println("Email giriniz : ");
        String email=scanner.nextLine();//asd@gmail.com

        //kullanıcı kaydı var mı
        if (this.userInfo.containsKey(email)){//kullanıcı varsa
            //şifre soralım

            boolean isSuccess=false;
            int counter=3;

            while (!isSuccess && counter>0){
                System.out.println("Şifrenizi giriniz : ");
                String password=scanner.nextLine();

                //email ile şifre eşleşiyor mu
                if (this.userInfo.get(email).equals(password)){
                    //giriş başarılı
                    System.out.println("Harika, sisteme giriş yaptınız. Hoşgeldiniz:)");
                    isSuccess=true;
                }else {
                    //şifre yanlış
                    counter--;//2-1-0
                    if (counter==0){
                        System.out.println("3 kez hatalı giriş yaptınız! Ana menüye yönlendiriliyorsunuz!");
                    }else {
                        System.out.println("Şifreniz yanlış, tekrar deneyiniz, kalan hakkınız : "+counter);
                    }
                }

            }

        }else{//kullanıcı yoksa
            System.out.println("Sisteme bu email ile kayıtlı kullanıcı bulunamadı.");
            System.out.println("Üyeyseniz bilgilerinizi kontrol ediniz, değilseniz üye olunuz!");

        }

    }




    //5-adım:email doğrulama metodu:ÖDEVV
    private boolean validateEmail(String email){
        //email geçersizse hata mesajı ver
        boolean isValid=true;

        boolean hasSpace=email.contains(" ");
        boolean hasAtSymbol=email.contains("@");

        if (hasSpace){
            System.out.println("Email boşluk içeremez!");
            isValid=false;
        }else if (!hasAtSymbol){
            System.out.println("Email @ sembolü içermelidir!");
            isValid=false;
        }else {
            String firstPart=email.split("@")[0];
            String secondPart=email.split("@")[1];

            boolean isExistsInvalidChar=firstPart.
                    replaceAll("[A-Za-z0-9-._]","").length()>0;//* ? /

            boolean isValidDomain=secondPart.equals("gmail.com") ||
                                  secondPart.equals("yahoo.com") ||
                                  secondPart.equals("hotmail.com");

            if (isExistsInvalidChar){
                System.out.println("Email kullanıcı adı harf,rakam ve -._ dışında karakter içeremez!");
                isValid=false;
            } else if (!isValidDomain) {
                System.out.println("Sisteme sadece gmail, yahoo ve hotmail ile kayıt olabilirsiniz.");
                isValid=false;
            }

        }

        if (!isValid){
            System.out.println("Geçersiz email, tekrar deneyiniz!");
        }

        return isValid;
    }

    //6-adım:password doğrulama metodu:ÖDEVV
    private boolean validatePassword(String password){
        return true;
    }




}
