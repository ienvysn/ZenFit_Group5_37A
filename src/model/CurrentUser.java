package model;

public class CurrentUser {
    private static UserData user;

    public static void set(UserData u) {
        user = u;
    }

    public static UserData get() {
        return user;
    }
}