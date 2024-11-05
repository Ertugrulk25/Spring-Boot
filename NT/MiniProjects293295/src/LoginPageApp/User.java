package LoginPageApp;
//2-adım:user nesnesini oluşturalım

//POJO:Plain Old Java Object
//field:private
//constructor
//getter-setter
//toString
public class User {

    //ad-soyad,username(email),password

    private String name;//null

    private String email;//null

    private String password;//null

    //user oluşturulduğunda fieldlarının set edilmesi için:paramli const

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }


    //getter-setter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    //3-adım:üye olma metodu
//    public void register(){
//
//    }
}
