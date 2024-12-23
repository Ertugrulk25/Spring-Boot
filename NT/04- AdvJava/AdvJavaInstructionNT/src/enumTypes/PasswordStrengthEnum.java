package enumTypes;

public enum PasswordStrengthEnum {

    FAIL(0),//0
    LOW(10),//0->1
    MEDIUM(50),//1->2
    HIGH(100);//2->3

    private final int level;//field

    //paramtli cons
    PasswordStrengthEnum(int level) {
        this.level = level;
    }
    //getter evet -peki setter olusuturcak mıyız? no


    public int getLevel() {
        return level;
    }

}
