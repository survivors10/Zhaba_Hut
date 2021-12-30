import javax.xml.crypto.Data;
import java.util.Calendar;
import java.util.Date;

public class Bug {
    private String bug_id;
    private String page;
    private String bug_title;
    private String priority_id;
    private String report_date;

    public Bug(String id, String page, String title, String priority, String date){
        this.bug_id = id;
        this.bug_title = title;
        this.page = page;
        this.priority_id = priority;
        this.report_date = date;
    }

    public String getBug_id() {
        return bug_id;
    }

    public String getBug_title() {
        return bug_title;
    }

    public String getPriority_id() {
        return priority_id;
    }

    public String getReport_date() {
        return report_date;
    }
}
