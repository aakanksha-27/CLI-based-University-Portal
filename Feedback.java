import java.util.ArrayList;
public class Feedback <T> {

    private ArrayList<T> feedback;

    public Feedback() {
        feedback = new ArrayList<>();
    }

    public ArrayList<T> getFeedback() {
        return feedback;
    }
    public void setFeedback(T t){
        feedback.add(t);
    }
}
