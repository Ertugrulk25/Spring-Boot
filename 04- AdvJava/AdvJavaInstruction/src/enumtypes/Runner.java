package enumtypes;
//1-uygulamada içerdiği karakterlere göre password gücü belirleniyor:HIGH, MEDIUM, LOW
//2-kullanıcıya mesaj verilecek:
//LOW:Dikkat şifreniz yetersiz seviyededir!!!
//MEDIUM:Şifre gücünüz orta düzeydedir.
//HIGH:Tebrikler, şifre gücünüz yüksek düzeydedir:)
public class Runner {

    public static void main(String[] args) {

        printMessage("LOW");
        printMessage("MEDIUM");
        printMessage("high");//CTE yok,RTE yok AMAAAAA metod beklenen ilevi gerçekleştirmedi!!!
        printMessage("HIGH ");
        printMessage("......");

    }


    //ÇÖZÜM:metodun parametresine argüman olarak sadece belirlediğimiz
    //sabit değişkenler verilmeli--->Enum Type


    //kullanıcıya parametrede verilen password gücüne göre
    //mesaj gösteren bir metod yazalım.
    public static void printMessage(String strength){

        if (strength.equals(PasswordStrength.LOW)){
            System.out.println("Dikkat şifreniz yetersiz seviyededir!!!");
        } else if (strength.equals(PasswordStrength.MEDIUM)) {
            System.out.println("Şifre gücünüz orta düzeydedir.");
        } else if (strength.equals(PasswordStrength.HIGH)) {
            System.out.println("Tebrikler, şifre gücünüz yüksek düzeydedir:)");
        }

    }

    //TODO:kullanıcıya parametrede Enum ile verilen password gücüne göre
    //mesaj gösteren bir metod yazalım.


}
