import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Test {
    public static void main(String[] args) throws IOException {
        System.out.println("Enter the information about you with commas in the following order:");
        System.out.println("surname, name, year, group");
        Scanner sc = new Scanner(System.in);
        String data = sc.nextLine();
        Student student = new Student(data);
        File file = new File("testInput.txt");
        sc = new Scanner(file);
        List<String> questionsAndAnswers = new ArrayList<>();
        while(sc.hasNextLine())
            questionsAndAnswers.add(sc.nextLine());
        student = studentTestData(questionsAndAnswers, student);
        try(RandomAccessFile raf = new RandomAccessFile("logfile.txt","rw")) {
            raf.seek(raf.length());
            raf.write(student.toString().getBytes(StandardCharsets.UTF_8));
            raf.write("\n".getBytes(StandardCharsets.UTF_8));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } ;
        makeOutputs("logfile.txt");
    }

    public static Student studentTestData(List<String> questionsAndAnswers, Student student) {
        int i = 0;
        int j = 0;
        int tmp = 0;
        int rightAnswers = 0;
        int numberOfQuestions = 0;
        while(i < questionsAndAnswers.size()) {
            numberOfQuestions++;
            System.out.println(questionsAndAnswers.get(i));
            i++;
            j = Integer.parseInt(questionsAndAnswers.get(i));
            tmp = i;
            i++;
            while(i <= j + tmp) {
                System.out.println(questionsAndAnswers.get(i));
                i++;
            }
            System.out.println("Enter the number of your answer:");
            Scanner scanner = new Scanner(System.in);
            String string = scanner.nextLine();
            if(string.equals(questionsAndAnswers.get(i)))
                rightAnswers++;
            i++;
        }
        if((rightAnswers * 1 / numberOfQuestions) >= 0.75)
            student.setPassed(1);
        else student.setPassed(0);
        return student;
    }

    public static void makeOutputs(String logfile) throws IOException {
        Set<Student> attemptsSet = new HashSet<>();
        List<Student> attemptsList = new ArrayList<>();
        List<Student> students = new ArrayList<>();
        File file = new File(logfile);
        Scanner sc = new Scanner(file);
        while(sc.hasNext()) {
            String[] array = sc.nextLine().split(";");
            attemptsSet.add(new Student(array[0], array[1]));
        }
        for(Student attempt : attemptsSet)
            attemptsList.add(attempt);
        Collections.sort(attemptsList, new Comparator<Student>() {
            @Override
            public int compare(Student first, Student second) {
                return first.getData().compareTo(second.getData());
            }
        });
        for(int i = 0; i < attemptsList.size() - 1; i++) {
            if(attemptsList.get(i).getData().equals(attemptsList.get(i + 1).getData())) {
                if(attemptsList.get(i).getPassed() == 1)
                    students.add(attemptsList.get(i));
                else students.add(attemptsList.get(i + 1));
                i++;
            }
            students.add(attemptsList.get(i));
        }
        file = new File("output1.txt");
        FileWriter fw = new FileWriter(file);
        for(Student student : students)
            fw.write(student.toString() + "\n");
        List<Student> passedStudents = new ArrayList<>();
        for(Student student : students) {
            if(student.getPassed() == 1)
                passedStudents.add(student);
        }
        fw.close();
        file = new File("output2.txt");
        fw = new FileWriter(file);
        for(Student student : passedStudents)
            fw.write(student.toString() + "\n");
        fw.close();
    }
}