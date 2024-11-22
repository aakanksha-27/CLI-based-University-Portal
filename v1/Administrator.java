import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Administrator extends User{

    Scanner scanner = new Scanner(System.in);
    private static Set<Course> allCourses;
    private static Set<Student> allStudents;
    private static Set<Professor> allProfs;
    private static Set<Complaint> allComplaints;

    static{
        allCourses = new HashSet<>();
        allStudents = new HashSet<>();
        allProfs = new HashSet<>();
        allComplaints = new HashSet<>();
        CourseCatalog.hardcodeCourses();
    }

    public Administrator(){
        this.displayMenu();
    }

    public void displayMenu() {
        System.out.println("Choose functionality:");
        System.out.println("1. Manage Course Catalog");
        System.out.println("2. Manage Student Records");
        System.out.println("3. Assign Professors");
        System.out.println("4. Handle Complaints");
        System.out.println("5. Logout");
        int ft = scanner.nextInt();
        scanner.nextLine();
        switch (ft){
            case 1:
                manageCourseCatalog();
                break;
            case 2:
                manageStudentRecords();
                break;
            case 3:
                assignProfs();
                break;
            case 4:
                handleComplaints();
                break;
            case 5:
                this.logout();
                break;
            default:
                System.out.println("Invalid choice.");
        } displayMenu();
    }

    public static Set<Student> getAllStudents(){
        return allStudents;
    }
    public static Set<Course> getAllCourses(){
        return allCourses;
    }
    public static Set<Professor> getAllProfs(){
        return allProfs;
    }
    public static Set<Complaint> getAllComplaints(){
        return allComplaints;
    }

    public static Set<Course> coursesPerSem(int sem){
        Set<Course> coursesInSem = new HashSet<>();
        for (Course c: allCourses){
            if (c.getSem()==sem){
                coursesInSem.add(c);
            }
        }
        return coursesInSem;
    }

    private void manageCourseCatalog(){
        System.out.println("What do you want to do?");
        System.out.println("1. View All Courses");
        System.out.println("2. Add Course");
        System.out.println("3. Delete Course");
        System.out.println("4. Go Back");
        int ft = scanner.nextInt();
        scanner.nextLine();
        switch (ft){
            case 1:
                for (Course c : allCourses) c.displayCourseInfo();
                break;
            case 2:
                System.out.println("Enter course code:");
                String cc = scanner.nextLine();
                System.out.println("Enter title:");
                String tt = scanner.nextLine();
                System.out.println("Enter professor's name:");
                String n = scanner.nextLine();
                Professor pp = null;
                for (Professor p : getAllProfs()){
                    if (p.getName().equals(n)) pp = p;
                }
                if (pp == null) {
                    System.out.println("Professor does not exist.");
                    manageCourseCatalog();
                }
                System.out.println("Enter credits:");
                int cred = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter number of prerequisites:");
                int numpre = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter prerequisites:");
                Set<Course> prereq = new HashSet<>();
                for (int i = 0; i < numpre; i++) {
                    String title = scanner.nextLine();
                    for (Course c : allCourses) {
                        if (c.getTitle().equals(title)) prereq.add(c);
                    }
                }
                System.out.println("Enter timing:");
                String timi = scanner.nextLine();
                System.out.println("Enter semester");
                int sem = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter location:");
                String loc = scanner.nextLine();
                System.out.println("Enter day:");
                String day = scanner.nextLine();
                System.out.println("Enter syllabus:");
                String syll = scanner.nextLine();
                System.out.println("Enter enrollment limit:");
                int el = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter office hours:");
                String oh = scanner.nextLine();
                Course c = new Course(cc, tt, pp, cred, timi, sem, loc, day, syll, el, oh);
                for (Course cp : prereq) c.addPreq(cp);
                allCourses.add(c);
                break;
            case 3:
                System.out.println("Enter title of the course to be deleted:");
                String title = scanner.nextLine();
                Course ck = null;
                for (Course cr : getAllCourses()){
                    if (cr.getTitle().equals(title)) {
                        System.out.println("Course " + title + " removed successfully.");
                        ck = cr;
                        break;
                    }
                }
                getAllCourses().remove(ck);
                break;
            case 4:
                displayMenu();
                break;
            default:
                System.out.println("Invalid request");
        } manageCourseCatalog();
    }

    private void manageStudentRecords(){
        System.out.println("Select function:");
        System.out.println("1. View Records");
        System.out.println("2. Update Information");
        System.out.println("3. Go Back");
        int ft = scanner.nextInt();
        scanner.nextLine();
        switch (ft){
            case 1:
                for (Student s : allStudents) {
                    System.out.println(s.getEmail() + " Current sem: " + s.getSem() + " Cgpa: " + s.getCgpa());
                    System.out.println("Registered Courses:");
                    for (Course c: s.getRegisteredCourses()) System.out.println(c.getTitle());
                }
                break;
            case 2:
                System.out.println("Whose info do you want to update?");
                String ee = scanner.nextLine();
                Student ss = null;
                for (Student s: getAllStudents()){
                    if(s.getEmail().equals(ee)) ss = s;
                }
                System.out.println("What do you wish to update?");
                System.out.println("1. Email id");
                System.out.println("2. SGPA");
                System.out.println("3. CGPA");
                System.out.println("4. Course Grades");
                System.out.println("5. Go Back");
                int ff = scanner.nextInt();
                scanner.nextLine();
                switch(ff){
                    case 1:
                        System.out.println("Enter new email:");
                        ss.setEmail(scanner.nextLine());
                        System.out.println("Email set successfully.");
                        break;
                    case 2:
                        System.out.println("Enter new SGPA:");
                        ss.setSGPA(scanner.nextDouble());
                        scanner.nextLine();
                        System.out.println("SGPA set successfully.");
                        break;
                    case 3:
                        System.out.println("Enter new CGPA:");
                        ss.setCGPA(scanner.nextDouble());
                        scanner.nextLine();
                        System.out.println("CGPA set successfully.");
                        break;
                    case 4:
                        System.out.println("Which course's grade do you want to update?");
                        String crs = scanner.nextLine();
                        Course cc = null;
                        for (Course c: Administrator.getAllCourses()){
                            if (c.getTitle().equals(crs)) cc = c;
                        }
                        System.out.println("Enter updated grade:");
                        ss.setGrades(cc,scanner.nextInt());
                        scanner.nextLine();
                        ss.updateSem();
                        System.out.println("Grade set successfully.");
                        break;
                    case 5:
                        manageStudentRecords();
                        break;
                    default:
                        System.out.println("Invalid request.");
                }
                break;
            case 3:
                displayMenu();
                break;
            default:
                System.out.println("Invalid request.");
        }manageStudentRecords();
    }

    private void assignProfs(){
        System.out.println("Enter course title and professor's name:");
        String title = scanner.nextLine();
        String name = scanner.nextLine();
        Course cc = null;
        for (Course c : allCourses) {
            if(c.getTitle().equals(title)) cc = c;
        }
        Professor pp = null;
        for (Professor p : allProfs) {
            if(p.getName().equals(name)) pp = p;
        }
        cc.setProf(pp);
    }

    private void handleComplaints(){
        System.out.println("Select function:");
        System.out.println("1. View submitted complaints");
        System.out.println("2. Update complaints status");
        System.out.println("3. Filter and update complaints");
        System.out.println("4. Go Back");
        int ft = scanner.nextInt();
        scanner.nextLine();
        switch(ft){
            case 1:
                for (Complaint cmp : getAllComplaints()) System.out.println(cmp.getDescription());
                break;
            case 2:
                System.out.println("Enter complaint and new status:");
                String d = scanner.nextLine();
                String s = scanner.nextLine();
                for (Complaint cmp : getAllComplaints()) {
                    if(cmp.getDescription().equals(d)) cmp.setStatus(s);
                }
                break;
            case 3:
                System.out.println("Do you wish to filter complaints based on status or date?");
                String act = scanner.nextLine();
                switch (act){
                    case "status":
                        System.out.println("Pending or Resolved?");
                        String st = scanner.nextLine();
                        for (Complaint c: getAllComplaints()){
                            if (c.getStatus().equals(st)) System.out.println(c.getDescription());
                        }
                        System.out.println("Enter new status:");
                        String nst = scanner.nextLine();
                        for (Complaint c: getAllComplaints()){
                            if (c.getStatus().equals(st)) c.setStatus(nst);
                        }
                        break;
                    case "date":
                        System.out.println("Enter date (dd/mm/yyyy):");
                        String dd = scanner.nextLine();
                        for (Complaint c: getAllComplaints()){
                            if (c.getDate().equals(dd)) System.out.println(c.getDescription());
                        }
                        System.out.println("Enter new status:");
                        String nstd = scanner.nextLine();
                        for (Complaint c: getAllComplaints()){
                            if (c.getDate().equals(dd)) c.setStatus(nstd);
                        }
                        break;
                    default:
                        System.out.println("Invalid request.");
                }
                break;
            case 4:
                displayMenu();
                break;
            default:
                System.out.println("Invalid request.");
        }handleComplaints();
    }
}