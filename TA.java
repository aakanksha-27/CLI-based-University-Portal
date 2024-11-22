public class TA extends Student {

    Course course;

    public TA(String e, String p, String c) {
        super(e, p);
        for (Course cc: Administrator.getAllCourses()){
            if(cc.getCourseCode().equals(c)) course = cc;
        }
        Administrator.getAllTAs().add(this);
        this.displayMenu();
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
        System.out.println("9. View Student Grades");
        System.out.println("10. Set Student Grades");
        System.out.println("11. Logout");
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
                viewStudentGrades();
                break;
            case 10:
                setStudentGrades();
                break;
            case 11:
                this.logout();
                break;
            default:
                System.out.println("Invalid choice.");
        } displayMenu();
    }

    public void viewStudentGrades(){
        for (Student s: Administrator.getAllStudents()){
            if(s.getCompletedCourses().contains(course)){
                System.out.println(s.getEmail() + ": " + s.getGrade(course.getTitle()));
            }
        }
    }

    public void setStudentGrades(){
        System.out.println("Which student's grade would you like to assign?");
        String em = scanner.nextLine();
        for (Student s: Administrator.getAllStudents()){
            if (s.getEmail().equals(em)){
                System.out.println("What is the grade?");
                s.setGrades(course, scanner.nextInt());
                scanner.nextLine();
                s.updateSem();
            }
        }
    }

    @Override
    public String toString() {
        return this.getEmail();
    }

    @Override
    public boolean equals(Object t) {
        if (t != null && t.getClass() == this.getClass() && ((TA) t).getEmail().equals(this.getEmail())) return true;
        return false;
    }
}