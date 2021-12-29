import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Code {
    public static void main(String[] args) throws IOException, MyException {
        TextInput textInput = new TextInput("Text.txt");
        for(String str : textInput.getText())
            System.out.println(str);
        Correct correct = new Correct(textInput);
        CommandReader commandReader = new CommandReader("Command.txt");
        commandReader.doCommands(correct);
        TextOutput textOutput = new TextFileWriterOutput();
        textOutput.writeText(correct.getText(), "Result.txt");
    }
}
