import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Student extends User {
    private int sem;
    private Set<Course> availableCourses;
    private Set<Course> registeredCourses;
    private Set<Course> completedCourses;
    private Set<Course> failedCourses;
    private int currentCreditSum;
    private double sgpa;
    private double cgpa;
    private Map<Course,Integer> grades;

    public Student(String em, String pwd){
        this.setEmail(em);
        this.setPassword(pwd);
        Administrator.getAllStudents().add(this);
        sem = 1;
        availableCourses = new HashSet<>();
        registeredCourses = new HashSet<>();
        completedCourses = new HashSet<>();
        failedCourses = new HashSet<>();
        currentCreditSum = 0;
        sgpa = 0.0;
        cgpa = 0.0;
        grades = new HashMap<>();
        displayMenu();
    }

    @Override
    public void displayMenu(){
        System.out.println("Select functionality:");
        System.out.println("1. View Available Courses");
        System.out.println("2. Register for Courses");
        System.out.println("3. View Schedule");
        System.out.println("4. Track Academic Progress");
        System.out.println("5. Drop Courses");
        System.out.println("6. Submit Complaints");
        System.out.println("7. View Complaint Status");
        System.out.println("8. Logout");
        int ft = scanner.nextInt();
        scanner.nextLine();
        switch(ft){
            case 1:
                viewAvailableCourses();
                break;
            case 2:
                registerCourse();
                break;
            case 3:
                viewSchedule();
                break;
            case 4:
                trackAcadProgress();
                break;
            case 5:
                dropCourse();
                break;
            case 6:
                submitComplaint();
                break;
            case 7:
                viewComplaintStatus();
                break;
            case 8:
                this.logout();
                break;
            default:
                System.out.println("Invalid choice.");
        } displayMenu();
    }

    public int getSem(){
        return this.sem;
    }
    public double getSgpa(int s){
        double num = 0.0;
        double den = 0.0;
        for (Course c : this.completedCourses) {
            if (c.getSem() == s){
                num += (this.grades.get(c) * c.getCredits());
                den += c.getCredits();
            }
        }
        if (den == 0.0) return this.sgpa;
        return this.sgpa = (double) num/den;
    }
    public double getCgpa(){
        double num = 0.0;
        double den = 0.0;
        for (Course c : this.completedCourses) {
            num += (this.grades.get(c) * c.getCredits());
            den += c.getCredits();
        }
        if (den == 0.0) return this.cgpa;
        return this.cgpa = (double) num/den;
    }
    public Set<Course> getAvailableCourses(){
        this.availableCourses = Administrator.coursesPerSem(this.sem);
        return this.availableCourses;
    }
    public Set<Course> getRegisteredCourses(){
        return this.registeredCourses;
    }
    public Set<Course> getCompletedCourses(){
        return this.completedCourses;
    }
    public Set<Course> getFailedCourses(){
        return this.failedCourses;
    }
    public void getGrade(String s){
        for (Course c: this.getCompletedCourses()){
            if(c.getTitle().equals(s)) System.out.println(this.grades.get(c));
        }
    }
    public int getCurrentCreditSum() {
        return this.currentCreditSum;
    }

    public void setCurrentCreditSum(int c) {
        this.currentCreditSum = c;
    }
    public void setSGPA(double s){
        this.sgpa = s;
    }
    public void setCGPA(double c){
        this.cgpa = c;
    }
    public void setGrades(Course c, int g){
        this.grades.put(c,g);
        if (g > 3) this.completedCourses.add(c);
        else this.failedCourses.add(c);
        this.registeredCourses.remove(c);
        this.currentCreditSum -= c.getCredits();
    }
    public void updateSem(){
        if(this.getRegisteredCourses().isEmpty()) {
            if (this.sem < 8) this.sem++;
            else System.out.println("You have graduated!");
        }
    }

    private void viewAvailableCourses(){
        for (Course c : getAvailableCourses()) c.displayCourseInfo();
    }

    private void registerCourse(){
        System.out.println("Select course title to be registered: ");
        for (Course c: getAvailableCourses()) System.out.println(c.getTitle());
        String cr = scanner.nextLine();
        for (Course c: getAvailableCourses()) {
            if (c.getTitle().equals(cr)) {
                boolean flag = true;
                for (Course p : c.getPrereq()) {
                    flag = false;
                    for (Course comp : completedCourses) {
                        flag = false;
                        if (comp.getTitle().equals(p.getTitle())) flag = true;
                        if(!flag) break;
                    }
                    if(!flag) break;
                }
                if(!flag || c.getCredits() + currentCreditSum > 20) {
                    System.out.println("You cannot register for this course.");
                    break;
                }
                registeredCourses.add(c);
                currentCreditSum += c.getCredits();
                System.out.println("Course registered successfully.");
            }
        }
    }

    private void viewSchedule(){
        Set<Course> mon = new HashSet<>(), tue = new HashSet<>(), wed = new HashSet<>(), thu = new HashSet<>(), fri = new HashSet<>();
        for (Course c: registeredCourses) {
            switch(c.getDay()){
                case "Monday":
                    mon.add(c);
                    break;
                case "Tuesday":
                    tue.add(c);
                    break;
                case "Wednesday":
                    wed.add(c);
                    break;
                case "Thursday":
                    thu.add(c);
                    break;
                case "Friday":
                    fri.add(c);
            }
        }
        for (Course m: mon) System.out.println(m.getTitle() + " " + m.getDay() + " " + m.getTime() + " " + m.getLocation() + " " + m.getProf().getName());
        for (Course m: tue) System.out.println(m.getTitle() + " " + m.getDay() + " " + m.getTime() + " " + m.getLocation() + " " + m.getProf().getName());
        for (Course m: wed) System.out.println(m.getTitle() + " " + m.getDay() + " " + m.getTime() + " " + m.getLocation() + " " + m.getProf().getName());
        for (Course m: thu) System.out.println(m.getTitle() + " " + m.getDay() + " " + m.getTime() + " " + m.getLocation() + " " + m.getProf().getName());
        for (Course m: fri) System.out.println(m.getTitle() + " " + m.getDay() + " " + m.getTime() + " " + m.getLocation() + " " + m.getProf().getName());
    }

    private void trackAcadProgress(){
        System.out.println("Choose what you wish to view:");
        System.out.println("1. Course Grades");
        System.out.println("2. SGPA for a semester");
        System.out.println("3. CGPA");
        System.out.println("4. Go Back");
        int ft = scanner.nextInt();
        scanner.nextLine();
        switch(ft){
            case 1:
                System.out.println("Which course's grade would you like to know?");
                String tt = scanner.nextLine();
                this.getGrade(tt);
                break;
            case 2:
                System.out.println("Enter semester:");
                int ss = scanner.nextInt();
                scanner.nextLine();
                double sg = this.getSgpa(ss);
                System.out.println(sg);
                break;
            case 3:
                double cg = this.getCgpa();
                System.out.println(cg);
                break;
            case 4:
                this.displayMenu();
                break;
            default:
                System.out.println("Invalid request.");
        } trackAcadProgress();
    }

    private void dropCourse(){
        System.out.println("Enter course to be dropped:");
        String title = scanner.nextLine();
        Course cc = null;
        for (Course c : registeredCourses) {
            if(c.getTitle().equals(title)){
                currentCreditSum -= c.getCredits();
                cc = c;
            }
        }
        this.getRegisteredCourses().remove(cc);
    }

    private void submitComplaint() {
        System.out.println("Enter complaint description and date (dd/mm/yyyy):");
        String dscr = scanner.nextLine();
        String date = scanner.nextLine();
        Complaint complaint = new Complaint(dscr,date);
        Administrator.getAllComplaints().add(complaint);
    }

    private void viewComplaintStatus(){
        System.out.println("Which complaint's status would you like to know?");
        String cmp = scanner.nextLine();
        for (Complaint c: Administrator.getAllComplaints()){
            if (c.getDescription().equals(cmp)) System.out.println(c.getStatus());
        }
    }
}