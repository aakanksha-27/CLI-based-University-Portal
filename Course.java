import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Course {
    private final String courseCode;
    private final String title;
    private Professor prof;
    private int credits;
    private Set<Course> prereq = new HashSet<>();
    private String time;
    private int sem;
    private String location;
    private String day;
    private String syllabus;
    private int enrollLimit;
    private int currEnrollment;
    private String oHrs;
    private Feedback<Integer> intFeedback;
    private Feedback<String> stringFeedback;
    private int dropDMonth;

    public Course (String code, String title, Professor prof, int credits, String time, int sem, String loc, String day, String syll, int elimit, String OffH){
        this.courseCode = code;
        this.title = title;
        this.prof = prof;
        this.credits = credits;
        this.time = time;
        this.sem = sem;
        this.location = loc;
        this.day = day;
        this.syllabus = syll;
        this.enrollLimit = elimit;
        this.currEnrollment = 0;
        this.oHrs = OffH;
        Administrator.getAllCourses().add(this);
        intFeedback = new Feedback<>();
        stringFeedback = new Feedback<>();
        if(this.sem % 2 == 1) this.dropDMonth = 8;
        else this.dropDMonth = 1;
    }

    public void displayCourseInfo(){
        System.out.println("Course code: " + this.courseCode);
        System.out.println("Course title: " + this.title);
        System.out.println("Professor: " + this.prof.getName());
        System.out.println("Credits: " + this.credits);
        System.out.println("Prerequisites: ");
        for (Course c: prereq) System.out.println(c.getTitle());
        System.out.println("Timing: " + time);
    }

    public String getTitle(){
        return this.title;
    }
    public int getCredits(){
        return this.credits;
    }
    public Set<Course> getPrereq(){
        return this.prereq;
    }
    public int getSem(){
        return this.sem;
    }
    public String getDay(){
        return this.day;
    }
    public String getTime(){
        return this.time;
    }
    public String getLocation(){
        return this.location;
    }
    public Professor getProf(){
        return this.prof;
    }
    public String getCourseCode(){
        return this.courseCode;
    }
    public String getSyllabus(){
        return this.syllabus;
    }
    public int getEnrollLimit(){
        return this.enrollLimit;
    }
    public int getCurrEnrollment() {
        return currEnrollment;
    }
    public String getoHrs(){
        return this.oHrs;
    }
    public ArrayList<Integer> getIntFeedback() {
        return this.intFeedback.getFeedback();
    }
    public ArrayList<String> getStringFeedback() {
        return this.stringFeedback.getFeedback();
    }
    public int getDropDMonth(){
        return this.dropDMonth;
    }

    public void setIntFeedback(Integer i) {
        this.intFeedback.setFeedback(i);
    }
    public void setStringFeedback(String s) {
        this.stringFeedback.setFeedback(s);
    }
    public void setProf(Professor p) {
        this.prof = p;
    }
    public void setSyllabus(String s){
        this.syllabus = s;
    }
    public void setTime(String t) {
        this.time = t;
    }
    public void setCred(int c) {
        this.credits = c;
    }
    public void addPreq(Course c){
        this.prereq.add(c);
    }
    public void delPreq(Course c){
        this.prereq.remove(c);
    }
    public void setEnrollmentLimit(int el) {
        this.enrollLimit = el;
    }
    public void incrementCurrEnrollment() {
        this.currEnrollment++;
    }
    public void setOfficeHrs(String oh) {
        this.oHrs = oh;
    }
    public void setSem(int i){
        this.sem = i;
    }
    public void setLocation(String l){
        this.location = l;
    }
    public void setDay(String d){
        this.day = d;
    }
}
