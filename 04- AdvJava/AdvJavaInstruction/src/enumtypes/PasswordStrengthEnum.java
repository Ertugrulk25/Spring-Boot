package enumtypes;

public enum PasswordStrengthEnum {

    LOW(10),
    MEDIUM(50),
    HIGH(100);

    private final int level;//field

    //paramli const
    PasswordStrengthEnum(int level) {
        this.level = level;
    }
    //devamı gelecek....:)
}
