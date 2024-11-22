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
        System.out.println("8. Give Feedback");
        System.out.println("9. Logout");
        int ft = scanner.nextInt();
        scanner.nextLine();
        switch(ft){
            case 1:
                viewAvailableCourses();
                break;
            case 2:
                try {
                    registerCourse();
                }
                catch(CourseFullException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case 3:
                viewSchedule();
                break;
            case 4:
                trackAcadProgress();
                break;
            case 5:
                try{
                    dropCourse();
                }
                catch(DropDeadlinePassedException e){
                    System.out.println(e.getMessage());
                }
                break;
            case 6:
                submitComplaint();
                break;
            case 7:
                viewComplaintStatus();
                break;
            case 8:
                giveFeedback();
                break;
            case 9:
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
    public Integer getGrade(String s){
        for (Course c: this.getCompletedCourses()){
            if(c.getTitle().equals(s)) return this.grades.get(c);
        }
        return -1;
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

    protected void viewAvailableCourses(){
        for (Course c : getAvailableCourses()) c.displayCourseInfo();
    }

    protected void registerCourse() throws CourseFullException {
        System.out.println("Select course title to be registered: ");
        for (Course c: getAvailableCourses()) System.out.println(c.getTitle());
        String cr = scanner.nextLine();
        for (Course c: getAvailableCourses()) {
            if (c.getTitle().equals(cr)) {
                if(c.getCurrEnrollment() + 1 > c.getEnrollLimit()) throw new CourseFullException("Exception: Enrollment limit has been met.");
                boolean flag = true;
                for (Course p : c.getPrereq()) {
                    if (!this.getCompletedCourses().contains(p)) {
                        flag = false;
                        break;
                    }
                }
                if(!flag || c.getCredits() + getCurrentCreditSum() > 20) {
                    System.out.println("You cannot register for this course.");
                    break;
                }
                getRegisteredCourses().add(c);
                currentCreditSum += c.getCredits();
                c.incrementCurrEnrollment();
                System.out.println("Course registered successfully.");
            }
        }
    }

    protected void viewSchedule(){
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

    protected void trackAcadProgress(){
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
                System.out.println(this.getGrade(tt));
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

    protected void dropCourse() throws DropDeadlinePassedException {
        System.out.println("Enter course to be dropped:");
        String title = scanner.nextLine();
        Course cc = null;
        for (Course c : registeredCourses) {
            if(c.getTitle().equals(title)){
                System.out.println("Enter current month:");
                int m = scanner.nextInt();
                scanner.nextLine();
                if (m > c.getDropDMonth()) throw new DropDeadlinePassedException("Exception: Drop Deadline Passed.");
                currentCreditSum -= c.getCredits();
                cc = c;
            }
        }
        this.getRegisteredCourses().remove(cc);
        System.out.println("Course dropped successfully.");
    }

    protected void submitComplaint() {
        System.out.println("Enter complaint description and date (dd/mm/yyyy):");
        String dscr = scanner.nextLine();
        String date = scanner.nextLine();
        Complaint complaint = new Complaint(dscr,date);
        Administrator.getAllComplaints().add(complaint);
    }

    protected void viewComplaintStatus(){
        System.out.println("Which complaint's status would you like to know?");
        String cmp = scanner.nextLine();
        for (Complaint c: Administrator.getAllComplaints()){
            if (c.getDescription().equals(cmp)) System.out.println(c.getStatus());
        }
    }

    protected void giveFeedback(){
        System.out.println("Enter course code:");
        String code = scanner.nextLine();
        Course cc = null;
        for (Course c: completedCourses){
            if (c.getCourseCode().equals(code)) cc = c;
        }
        if (cc == null) System.out.println("Course not completed.");
        else {
            System.out.println("Would you like to give a rating or a review?");
            String act = scanner.nextLine();
            switch (act) {
                case "rating":
                    System.out.println("Enter integer rating(0-10):");
                    cc.setIntFeedback(scanner.nextInt());
                    scanner.nextLine();
                    break;
                case "review":
                    System.out.println("Enter review:");
                    cc.setStringFeedback(scanner.nextLine());
                    break;
            }
        }
    }

    @Override
    public String toString() {
        return this.getEmail();
    }

    @Override
    public boolean equals(Object s) {
        if (s != null && s.getClass() == this.getClass() && ((Student) s).getEmail().equals(this.getEmail())) return true;
        return false;
    }
}