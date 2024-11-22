import java.util.Scanner;

public interface HomePage {

    static Scanner scanner = new Scanner(System.in);

    public static void start() {}

    public static void profStart(User user){}
    public static void studentStart(User user){}
    public static void adminStart(User user){}
}