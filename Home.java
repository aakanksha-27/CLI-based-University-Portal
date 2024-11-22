public class Home implements HomePage {

    public static void start(){
        System.out.println("Enter user type: 1. Professor 2. Student 3. TA 4. Administrator 5. Exit Program");
        int type = scanner.nextInt();
        scanner.nextLine();
        User user = null    ;
        switch(type){
            case 1:
                try{
                    profStart(user);
                }
                catch(InvalidLoginException e){
                    System.out.println(e.getMessage());
                }
                break;
            case 2:
                try{
                    studentStart(user);
                }
                catch(InvalidLoginException e){
                    System.out.println(e.getMessage());
                }
                break;
            case 3:
                try{
                    TAStart(user);
                }
                catch(InvalidLoginException e){
                    System.out.println(e.getMessage());
                }
                break;
            case 4:
                try{
                    adminStart(user);
                }
                catch(InvalidLoginException e){
                    System.out.println(e.getMessage());
                }
                break;
            case 5:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid request.");
        }start();
    }

    public static void profStart(User user) throws InvalidLoginException {
        System.out.println("1. Login or 2. Sign Up?");
        int action1 = scanner.nextInt();
        scanner.nextLine();
        switch(action1){
            case 1:
                System.out.println("Enter email id:");
                String e1 = scanner.nextLine();
                boolean flag1 = false;
                Professor pp1 = null;
                for (Professor p : Administrator.getAllProfs()){
                    if (p.getEmail().equals(e1)) {flag1 = true; pp1 = p; break;}
                }
                if (!flag1) throw new InvalidLoginException("Exception: Incorrect Credentials.");
                else{
                    System.out.println("Enter password:");
                    if (pp1.getPassword().equals(scanner.nextLine())) {
                        System.out.println("Login successful.");
                        pp1.displayMenu();
                    }
                    else throw new InvalidLoginException("Exception: Incorrect Credentials.");
                }
                break;
            case 2:
                System.out.println("Enter email id:");
                String e2 = scanner.nextLine();
                boolean flag2 = true;
                for (Professor p : Administrator.getAllProfs()){
                    if (p.getEmail().equals(e2)) {flag2 = false; break;}
                }
                if (!flag2) System.out.println("Email already exits.");
                else{
                    System.out.println("Enter name:");
                    String n = scanner.nextLine();
                    System.out.println("Create password:");
                    String pw1 = scanner.nextLine();
                    System.out.println("Signed up successfully.");
                    user = new Professor(n,e2,pw1);
                    user.displayMenu();
                }
                break;
            default:
                System.out.println("Invalid request.");
        }
    }

    public static void studentStart(User user) throws InvalidLoginException{
        System.out.println("1. Login or 2. Sign Up?");
        int action2 = scanner.nextInt();
        scanner.nextLine();
        switch(action2){
            case 1:
                System.out.println("Enter email id:");
                String e3 = scanner.nextLine();
                boolean flag3 = false;
                Student ss = null;
                for (Student s : Administrator.getAllStudents()){
                    if (s.getEmail().equals(e3)) {flag3 = true; ss = s; break;}
                }
                if (!flag3) throw new InvalidLoginException("Exception: Incorrect Credentials.");
                else{
                    System.out.println("Enter password:");
                    if (ss.getPassword().equals(scanner.nextLine())) {
                        System.out.println("Login successful.");
                        ss.displayMenu();
                    }
                    else throw new InvalidLoginException("Exception: Incorrect Credentials.");
                }
                break;
            case 2:
                System.out.println("Enter email id:");
                String e4 = scanner.nextLine();
                boolean flag4 = true;
                for (Student s : Administrator.getAllStudents()){
                    if (s.getEmail().equals(e4)) {flag4 = false; break;}
                }
                if (!flag4) System.out.println("Email already exits.");
                else{
                    System.out.println("Create password:");
                    String pw = scanner.nextLine();
                    System.out.println("Signed up successfully.");
                    user = new Student(e4,pw);
                    user.displayMenu();
                }
                break;
            default:
                System.out.println("Invalid request.");
        }
    }

    public static void TAStart (User user) throws InvalidLoginException{
        System.out.println("1. Login or 2. Sign Up?");
        int action = scanner.nextInt();
        scanner.nextLine();
        switch(action){
            case 1:
                System.out.println("Enter email id:");
                String e = scanner.nextLine();
                boolean flag = false;
                Student tt = null;
                for (TA t : Administrator.getAllTAs()){
                    if (t.getEmail().equals(e)) {flag = true; tt = t; break;}
                }
                if (!flag) throw new InvalidLoginException("Exception: Incorrect Credentials.");
                else{
                    System.out.println("Enter password:");
                    if (tt.getPassword().equals(scanner.nextLine())) {
                        System.out.println("Login successful.");
                        tt.displayMenu();
                    }
                    else throw new InvalidLoginException("Exception: Incorrect Credentials.");
                }
                break;
            case 2:
                System.out.println("Enter email id:");
                String e1 = scanner.nextLine();
                boolean flag1 = true;
                for (TA t : Administrator.getAllTAs()){
                    if (t.getEmail().equals(e1)) {flag1 = false; break;}
                }
                if (!flag1) System.out.println("Email already exits.");
                else{
                    System.out.println("Create password:");
                    String pw = scanner.nextLine();
                    System.out.println("Signed up successfully.");
                    System.out.println("Enter course code:");
                    user = new TA(e1,pw,scanner.nextLine());
                }
                break;
            default:
                System.out.println("Invalid request.");
        }
    }

    public static void adminStart(User user) throws InvalidLoginException{
        System.out.println("Enter password:");
        if (scanner.nextLine().equals("admin123")) {
            System.out.println("Login successful.");
            user = new Administrator();
        }
        else throw new InvalidLoginException("Exception: Incorrect Credentials.");
    }
}