import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TextInput {
    private List<String> textList;

    public TextInput(String fileName) throws IOException {
        List<String> textList = new ArrayList<>();
        File file = new File(fileName);
        Scanner sc = new Scanner(file);
        while(sc.hasNextLine()) {
            textList.add(sc.nextLine());
        }
        this.textList = textList;
    }

    public List<String> getText() {
        return textList;
    }
}
