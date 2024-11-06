package enumtypes;

public enum PasswordStrengthEnum {

    FAIL(0),//ordinal:0
    LOW(10),//ordinal:0-->1
    MEDIUM(50),//1->2
    HIGH(100);//2->3

    private final int level;//field

    //paramli const
    PasswordStrengthEnum(int level) {
        this.level = level;
    }

    //getter
    public int getLevel() {
        return level;
    }
}
