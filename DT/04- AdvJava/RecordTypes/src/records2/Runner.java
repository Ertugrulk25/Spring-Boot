package records2;

public class Runner {
    public static void main(String[] args) {

        Student student1=new Student("Victor","Hugo","123456");
        Student student2=new Student("Lev","Tolstoy","123789");

        StudentRepo repo=new StudentRepo();

        //bu öğrencileri kaydedelim
        repo.save(student1);
        repo.save(student2);

        //tüm kayıtları listeleyelim
        System.out.println("--------- Tüm Öğrenciler ------------");
        repo.printAllStudents();

        student1.printFirstname();

        //listedeki 1. indexteki öğrencinin numarası yanlış girilmiş
        //değiştirmek istiyoruz...

        Student newStudent=new Student(repo.students.get(1).firstname(),
                                       repo.students.get(1).lastname(),
                                       "123780");

        repo.save(newStudent);

        //eskiyi öğrenciyi de silelim
        repo.delete(student2);

        //tüm öğrenciler
        System.out.println("--------- Tüm Öğrenciler ------------");
        repo.printAllStudents();







    }
}
