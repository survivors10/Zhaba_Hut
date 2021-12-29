import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class TextFileWriterOutput implements TextOutput {
    @Override
    public void writeText(List<String> text, String fileName) throws IOException {
        try {
            FileWriter fw = new FileWriter(fileName);
            for (String str : text)
                fw.write(str + "\n");
            fw.close();
        } catch (IOException e) {e.printStackTrace(); }
    }
}
