package chapter8;

public class Member {

    public static boolean canEntry(int age, Gender gender) {
        return age <= 25 && Gender.FEMALE.equals(gender);
    }

}
