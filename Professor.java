public class Professor extends User {

    private String name;

    public Professor(String n){
        Administrator.getAllProfs().add(this);
        this.setName(n);
        this.setEmail(n);
        this.setPassword(n);
    }

    //Overloading
    public Professor(String n, String em, String pw){
        Administrator.getAllProfs().add(this);
        this.setName(n);
        this.setEmail(em);
        this.setPassword(pw);
    }

    @Override
    public void displayMenu() {
        System.out.println("Select functionality:");
        System.out.println("1. Manage Courses");
        System.out.println("2. View Enrolled Students");
        System.out.println("3. View Feedback for your Courses");
        System.out.println("4. Logout");
        int ft = scanner.nextInt();
        scanner.nextLine();
        switch(ft){
            case 1:
                manageCourses();
                break;
            case 2:
                viewEnrolledStudents();
                break;
            case 3:
                viewFeedback();
                break;
            case 4:
                this.logout();
                break;
            default:
                System.out.println("Invalid request.");
        }displayMenu();
    }

    public String getName(){
        return this.name;
    }

    public void setName(String n){
        this.name = n;
    }

    private void manageCourses(){
        System.out.println("Select function:");
        System.out.println("1. View your courses");
        System.out.println("2. Edit your courses");
        System.out.println("3. Go Back");
        int ft = scanner.nextInt();
        scanner.nextLine();
        switch(ft){
            case 1:
                for (Course c : Administrator.getAllCourses()){
                    if (c.getProf().equals(this)) c.displayCourseInfo();
                }
                break;
            case 2:
                System.out.println("Which course would you like to update?");
                String cr = scanner.nextLine();
                Course cc = null;
                for (Course c : Administrator.getAllCourses()){
                    if (c.getTitle().equals(cr)) cc = c;
                }
                if (cc == null){
                    System.out.println("Course not found.");
                    break;
                }
                System.out.println("Which detail would you like to update?");
                System.out.println("1. Syllabus");
                System.out.println("2. Class Timings");
                System.out.println("3. Credits");
                System.out.println("4. Prerequisites");
                System.out.println("5. Enrollment Limits");
                System.out.println("6. Office Hours");
                System.out.println("7. Go Back");
                int ff = scanner.nextInt();
                scanner.nextLine();
                switch(ff){
                    case 1:
                        System.out.println("Enter new syllabus:");
                        cc.setSyllabus(scanner.nextLine());
                        break;
                    case 2:
                        System.out.println("Enter new class timings:");
                        cc.setTime(scanner.nextLine());
                        break;
                    case 3:
                        System.out.println("Enter new credits:");
                        cc.setCred(scanner.nextInt());
                        scanner.nextLine();
                        break;
                    case 4:
                        System.out.println("Select action:");
                        System.out.println("1. Add Prerequisite");
                        System.out.println("2. Delete Prerequisite");
                        int act = scanner.nextInt();
                        scanner.nextLine();
                        switch(act){
                            case 1:
                                System.out.println("Enter prerequisite to be added:");
                                String pr = scanner.nextLine();
                                for(Course c: Administrator.getAllCourses()){
                                    if(c.getTitle().equals(pr)) cc.addPreq(c);
                                }
                                break;
                            case 2:
                                System.out.println("Enter prerequisite to be deleted:");
                                String rp = scanner.nextLine();
                                for (Course c: cc.getPrereq()){
                                    if(c.getTitle().equals(rp)) cc.delPreq(c);
                                }
                                break;
                            default:
                                System.out.println("Invalid request.");
                        }
                        break;
                    case 5:
                        System.out.println("Enter new enrollment limit:");
                        cc.setEnrollmentLimit(scanner.nextInt());
                        scanner.nextLine();
                        System.out.println("Enrollment limit set successfully.");
                        break;
                    case 6:
                        System.out.println("Enter new office hours:");
                        cc.setOfficeHrs(scanner.nextLine());
                        System.out.println("Office hours set successfully.");
                        break;
                    case 7:
                        this.manageCourses();
                        break;
                    default:
                        System.out.println("Invalid request.");
                }
                break;
            case 3:
                this.displayMenu();
                break;
            default:
                System.out.println("Invalid request.");
        } this.manageCourses();
    }

    private void viewEnrolledStudents(){
        for (Student s: Administrator.getAllStudents()){
            for (Course c: s.getRegisteredCourses()){
                if (c.getProf().equals(this)) System.out.println(s.getEmail() + " CGPA: " + s.getCgpa());
            }
        }
    }

    private void viewFeedback(){
        for (Course c: Administrator.getAllCourses()){
            if (c.getProf().equals(this)) {
                System.out.println(c.getCourseCode() + ": ");
                if(!c.getIntFeedback().isEmpty()){
                    for (int i: c.getIntFeedback()) System.out.println(i);
                }
                if(!c.getStringFeedback().isEmpty()){
                    for (String s: c.getStringFeedback()) System.out.println(s);
                }
            }
        }
    }
}