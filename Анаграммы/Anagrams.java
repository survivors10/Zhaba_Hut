import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Anagrams {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner sc = new Scanner(file);
        List<List<String>> strings = new ArrayList<>();
        while(sc.hasNextLine()) {
            String[] array = sc.nextLine().split("[ ,.]");
            List<String> list = new ArrayList<>();
            for(String str : array)
                list.add(str);
            strings.add(list);
        }
        if(isLetterAnagram("huy", "uyh") == true)
            System.out.println("Words are anagrams!");
        if(isWordAnagram(strings.get(0), strings.get(1)) == true)
            System.out.println("Strings are anagrams!");
    }

    public static boolean isWordAnagram(List<String> A, List<String> B) {
        int count = 0;
        for (String wordB : B) {
            for (String wordA : A) {
                if(wordB.equals(wordA)) {
                    A.remove(wordA);
                    count++;
                    break;
                }
            }
        }
        if(count == B.size())
            return true;
        return false;
    }

    public static boolean isLetterAnagram(String word1, String word2) {
        if(word1.length() == word2.length()) {
            char[] chars1 = word1.toCharArray();
            char[] chars2 = word2.toCharArray();
            Arrays.sort(chars1);
            Arrays.sort(chars2);
            for (int i = 0; i < chars1.length; i++) {
                if (chars1[i] == chars2[i]) {
                } else return false;
            }
            return true;
        }
        else return false;
    }
}
