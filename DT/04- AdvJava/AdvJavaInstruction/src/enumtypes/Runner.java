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

        //-----------------------------------------------

        printMessageEnum(PasswordStrengthEnum.LOW);
        printMessageEnum(PasswordStrengthEnum.MEDIUM);
        printMessageEnum(PasswordStrengthEnum.HIGH);



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

    //kullanıcıya parametrede Enum ile verilen password gücüne göre
    //mesaj gösteren bir metod yazalım.
    public static void printMessageEnum(PasswordStrengthEnum strength){

        if (strength.equals(PasswordStrengthEnum.LOW)){
        //if (strength.ordinal()==0){
            System.out.println("Dikkat şifreniz yetersiz seviyededir!!!");
        } else if (strength.equals(PasswordStrengthEnum.MEDIUM)) {
            System.out.println("Şifre gücünüz orta düzeydedir.");
        } else if (strength.equals(PasswordStrengthEnum.HIGH)) {
            System.out.println("Tebrikler, şifre gücünüz yüksek düzeydedir:)");
        }

        System.out.println("Enum sırası : "+strength.ordinal());//enum typeın sırasını
        System.out.println("Enum ismi : "+strength.name());//enum typeın ismini gösterir

    }


}
