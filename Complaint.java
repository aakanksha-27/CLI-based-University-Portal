public class Complaint {
    private final String description;
    private String status;
    private final String date;

    public Complaint(String dscr, String d){
        this.description = dscr;
        this.status = "Pending";
        this.date = d;
        Administrator.getAllComplaints().add(this);
    }

    public String getDescription(){
        return this.description;
    }
    public String getStatus(){
        return this.status;
    }
    public String getDate(){
        return this.date;
    }
    public void setStatus(String s) {
        this.status = s;
    }
}