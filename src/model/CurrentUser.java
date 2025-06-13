package model;

public class CurrentUser {
//    private static UserData user;
//
//    public static void set(UserData u) {
//        user = u;
//    }
//
//    public static UserData get() {
//        return user;
//    }
    private static UserData user;

    public static void set(UserData u) {
        if (u == null) {
            throw new IllegalArgumentException("User cannot be null");
        }
        user = u;
    }

    public static UserData get() {
        if (user == null) {
            throw new IllegalStateException("No user is currently logged in");
        }
        return user;
    }
    
    public static boolean isLoggedIn() {
        return user != null;
    }
    
    public static void clear() {
        user = null;
    }
    public static void setTemporaryUser(int userId) {
    // Create a minimal UserData object with just the ID
    user = new UserData();
    user.setId(userId); // Make sure UserData has setId() method
    System.out.println("TEMP: Set user ID to " + userId);
}
}