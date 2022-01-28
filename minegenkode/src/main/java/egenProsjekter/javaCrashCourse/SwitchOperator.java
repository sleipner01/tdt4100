package egenProsjekter.javaCrashCourse;

public class SwitchOperator {
    public static void main(String[] args) {
        String role = "admin";
        switch(role) {
            case "admin":
                System.out.println("You are an admin");
                break;

            case "moderator":
                System.out.println("You are a moderator");
                break;

            default:
                System.out.println("You are a guest");
        }

        int state = 1;
        switch(state) {
            case 1:
                System.out.println("You are an admin");
                break;

            case 2:
                System.out.println("You are a moderator");
                break;
                
            default:
                System.out.println("You are a guest");
        }

    }
}
