public class QA
{
    private String qa_id;
    private String qa_surname;
    private String qa_name;

    public QA(String id, String surname, String name){
        this.qa_id = id;
        this.qa_surname = surname;
        this.qa_name = name;
    }

    public String getQa_id() {
        return qa_id;
    }

    public String getQa_name() {
        return qa_name;
    }

    public String getQa_surname() {
        return qa_surname;
    }
}
