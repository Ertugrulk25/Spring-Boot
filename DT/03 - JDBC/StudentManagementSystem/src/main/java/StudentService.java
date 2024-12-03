import java.util.Scanner;

//service:bussiness:mantıksal işlemler
//service classları repo classları ile görüşür
public class StudentService {

    Scanner input=Runner.inp;

    //repositorynin methodlarını kullanabilmek için obje oluşturalım
    private Repository repo=new StudentRepository();

    //7-a-student tablosunu oluşturma
    public void createStudentTable(){
        repo.createTable();
    }

    //8-a-verilen bilgiler ile öğrenciyi kaydetme
    public Student getStudentInfo(){
        System.out.println("AD :");
        String name=input.nextLine();
        System.out.println("SOYAD :");
        String lastname=input.nextLine();
        System.out.println("ŞEHİR :");
        String city=input.next();
        System.out.println("YAŞ :");
        int age= input.nextInt();
        input.nextLine();

        return new Student(name,lastname,city,age);//id:null
    }

    public void saveStudent(Student newStudent){
        repo.save(newStudent);
    }




}
