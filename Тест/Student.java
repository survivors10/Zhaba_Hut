import java.util.Objects;

public class Student {
    private String data;
    private int passed;

    public Student(String data) {
        this.data = data;
    }

    public Student(String data, String passed) {
        this.data = data;
        this.passed = Integer.parseInt(passed);
    }

    public void setPassed(int passed) {
        this.passed = passed;
    }

    @Override
    public String toString() {
        return data + ";" + passed;
    }

    public String getData() {
        return data;
    }

    public int getPassed() {
        return passed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return passed == student.passed && Objects.equals(data, student.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, passed);
    }
}
