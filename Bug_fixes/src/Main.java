
import java.io.*;

import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("input1.txt");
        Scanner sc = new Scanner(fr);
        FileReader fr1 = new FileReader("input2.txt");
        FileReader fr2 = new FileReader("input3.txt");
        Bug[] bugs = new Bug[100];
        int i = 0;
        while (sc.hasNext()){
            String[] new_bug = new String[5];
            new_bug = sc.nextLine().split(";");
            bugs[i] = new Bug(new_bug[0], new_bug[1], new_bug[2], new_bug[3], new_bug[4]);
            i += 1;
        }
        sc = new Scanner(fr1);
        QA[] qas = new QA[100];
        int k = 0;
        while (sc.hasNext()){
            String[] new_qa = new String[3];
            new_qa = sc.nextLine().split(";| ");
            qas[i] = new QA(new_qa[0], new_qa[1], new_qa[2]);
            k += 1;
        }
        FileReader fr5 = new FileReader("input5.txt");
        sc = new Scanner(fr5);
        String q = sc.nextLine();
        Map<String, String> m6 = new HashMap<>();
        FileReader fr4 = new FileReader("input4.txt");
        sc = new Scanner(fr4);
        try (RandomAccessFile fw = new RandomAccessFile("output1.txt", "rw")) {
            while (sc.hasNext()){
                String[] qa1 = new String[2];
                qa1 = sc.nextLine().split(";");
                if(qa1[1].equals(q)){
                    for(int j = 0; j<i;  j++){
                        if(qa1[0].equals(bugs[j].getPriority_id())){
                            fw.write(bugs[j].getBug_title().getBytes(StandardCharsets.UTF_8));
                            fw.write("\n".getBytes(StandardCharsets.UTF_8));
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileReader fr3 = new FileReader("input4.txt");
        sc = new Scanner(fr3);
        ArrayList pr = new ArrayList();
        while(sc.hasNext()){
            String[] priority = sc.nextLine().split(";");
            pr.add(priority[1]);
        }
        Integer k1 = 1;
        FileWriter fw1 = new FileWriter("output2.txt");
        while (k1 <5) {
            for (int j = 0; j < i; j++) {
                if(bugs[j].getPriority_id().equals((k1).toString())){
                  fw1.write(bugs[j].getBug_title() + ";" + pr.get(k1 - 1).toString() + "\n");
                }
            }
            k1 +=1;
        }
        fw1.close();
        FileReader fr6 = new FileReader("input6.txt");
        sc = new Scanner(fr6);
         q = sc.nextLine();
         ArrayList<String> qa2 = new ArrayList<>();
         fr3 = new FileReader("input3.txt");
        sc = new Scanner(fr3);
        try (RandomAccessFile fw = new RandomAccessFile("output3.txt", "rw")) {
            while (sc.hasNext()){
                String[] qa1 = new String[2];
                qa1 = sc.nextLine().split(";");
                if(qa1[1].equals(q)){
                    for(int j = 0; j<i;  j++){
                        if(qa1[0].equals(bugs[j].getBug_id())){
                            fw.write(bugs[j].getBug_title().getBytes(StandardCharsets.UTF_8));
                            fw.write("\n".getBytes(StandardCharsets.UTF_8));
                        }
                    }
                    qa2.add(qa1[0]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<String> datestring=new ArrayList<String>();
        for(int j =0; j<i; j++){
            datestring.add(bugs[j].getReport_date());
        }
        Collections.sort(datestring, new Comparator<String>() {
            DateFormat f = new SimpleDateFormat("dd.mm.yyyy");
            @Override
            public int compare(String o1, String o2) {
                try {
                    return f.parse(o2).compareTo(f.parse(o1));
                } catch (ParseException e) {
                    throw new IllegalArgumentException(e);
                }
            }
        });
        FileWriter fw = new FileWriter("output4.txt");
        fr6 = new FileReader("input6.txt");
        sc = new Scanner(fr6);
        q = sc.nextLine();
        for(String m : datestring){
            for(int j =0; j<i; j++){
                if(bugs[j].getReport_date().equals(m)){
                    for (int h=0; h<qa2.size(); h++){
                        String mb = bugs[j].getBug_id();
                        String f = qa2.get(h);
                        if(mb.compareTo(f) == 0) {
                            fw.write(bugs[j].getBug_title() + ";" + bugs[j].getReport_date() + "\n");
                            break;
                        }
                    }

                }
            }
        }
     fw.close();
        String st = null;

    }

}
