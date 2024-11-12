package records2;

public record Student(String firstname, String lastname, String studentNumber) {

//    public void setStudentNumber(String number){
//        this.studentNumber=number;
//    }

    //NOT: recordlar default olarak immutable yani
    //değiştirilemez read-only'dir.
    //fieldları finaldır ve setter gibi metodlar eklenemez.

    public void printFirstname(){
        System.out.println("Öğrencinin adı : "+this.firstname);
    }

}
