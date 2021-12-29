import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class StringsDiversity {
    public static void main(String[] args) throws IOException {
        File file = new File("diversityInput.txt");
        Scanner sc = new Scanner(file);
        List<String> strings = new ArrayList<>();
        List<String> maxDiversitySubstrings = new ArrayList<>();
        while(sc.hasNextLine())
            strings.add(sc.nextLine());
        for(String string : strings)
            maxDiversitySubstrings.add(findMaxDiversitySubstring(string));
        file = new File("output.txt");
        FileWriter fw = new FileWriter(file);
        for(String substring : maxDiversitySubstrings)
            fw.write(substring + "\n");
        fw.close();
    }

    public static int findStringsDiversity(String str) {
        char[] array = str.toCharArray();
        if(str.length() == 1)
            return 1;
        else {
            Arrays.sort(array);
            int diversityNumber = 0;
            if (array[0] != array[1])
                diversityNumber++;
            if (array[array.length - 1] != array[array.length - 2])
                diversityNumber++;
            for (int i = 1; i < array.length - 1; i++) {
                if (array[i] != array[i - 1] && array[i] != array[i + 1])
                    diversityNumber++;
            }
            return diversityNumber;
        }
    }

    public static String findMaxDiversitySubstring(String str) {
        int maxDiversity = findStringsDiversity(str);
        String maxDiversitySubstring = new String(str);
        for(int i = str.length() - 2; i > 0; i--) {
            for (int j = 0; j < str.length() - i + 1; j++) {
                String substring = str.substring(j, j + i);
                if(findStringsDiversity(substring) > maxDiversity) {
                    maxDiversity = findStringsDiversity(substring);
                    maxDiversitySubstring = new String(substring);
                }
            }
        }
        return maxDiversitySubstring;
    }
}
