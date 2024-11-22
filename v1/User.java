import java.util.Scanner;

public abstract class User {
    protected String email;
    protected String password;
    Scanner scanner = new Scanner(System.in);

    public String getEmail(){
        return this.email;
    }
    public void setEmail(String s){
        this.email = s;
    }
    public String getPassword(){
        return this.password;
    }
    public void setPassword(String s){
        this.password = s;
    }

    public void logout(){
        System.out.println("Logged out successfully.");
        Home.start();
    }

    public abstract void displayMenu();
}
