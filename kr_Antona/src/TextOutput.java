import java.io.IOException;
import java.util.List;

public interface TextOutput {
    abstract void writeText(List<String> text, String fileName) throws IOException;
}
