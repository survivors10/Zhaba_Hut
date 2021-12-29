import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CommandReader {
    private List<String> commands;

    public CommandReader(String fileName) throws IOException {
        List<String> commands = new ArrayList<>();
        File file = new File(fileName);
        Scanner sc = new Scanner(file);
        while(sc.hasNextLine()) {
            commands.add(sc.nextLine());
        }
        this.commands = commands;
        for(String command : commands)
            System.out.println(command + " ");
    }

    public void doCommands(Correct correct) throws MyException {
        for(String command : commands) {
            if (command.length() >= 8) {
                if (command.substring(0, 4).equals("goto")) {
                    String[] words = new String[3];
                    words = command.split(" ");
                    int n = Integer.parseInt(words[1]);
                    int m = Integer.parseInt(words[2]);
                    System.out.println(n);
                    correct.goTo_n_m(n, m);
                    System.out.println(n + " " + m);
                }
            }
            switch(command) {
                case("right"):
                    correct.right();
                    break;
                case("left"):
                    correct.left();
                    break;
                case("up"):
                    correct.up();
                    break;
                case("down"):
                    correct.down();
                    break;
                case("ctrl left"):
                    correct.ctrlLeft();
                    break;
                case("ctrl right"):
                    correct.ctrlRight();
                    break;
                case("ctrl up"):
                    correct.ctrlUp();
                    break;
                case("ctrl down"):
                    correct.ctrlDown();
                    break;
                case("backspace"):
                    correct.backspace();
                    break;
                case("del"):
                    correct.del();
                    break;
                case("ctrl backspace"):
                    correct.ctrlBackspace();
                    break;
                case("ctrl del"):
                    correct.ctrlDel();
                    break;
                case("ins"):
                    correct.ins();
                    break;
                case("type"):
                    correct.typeSymbols();
                    break;
            }
        }
    }
}
