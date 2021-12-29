import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Correct extends AbstractCorrect {
    static List<String> text;
    static int positionInCurrentString;
    static int currentString;
    static boolean mode;

    public Correct(TextInput textInput) {
        text = textInput.getText();
        positionInCurrentString = 0;
        currentString = 0;
        mode = true;
    }

    @Override
    public void goTo_n_m(int n, int m) throws MyException {
        if(n > text.size() || n < 1)
            throw new MyException("Invalid parameters in goto command");
        currentString = n - 1;
        if(m > text.get(n - 1).length())
            positionInCurrentString = text.get(n - 1).length();
        else positionInCurrentString = m - 1;
        StringBuilder sb = new StringBuilder(text.get(n - 1));
        sb.insert(m, "1$");
        text.remove(n - 1);
        text.add(n - 1, sb.toString());
    }

    public void right() {
        positionInCurrentString++;
        if(positionInCurrentString > text.get(currentString).length())
            positionInCurrentString = text.get(currentString).length();
        StringBuilder sb = new StringBuilder(text.get(currentString));
        sb.insert(positionInCurrentString, "2$");
        text.remove(currentString);
        text.add(currentString, sb.toString());
    }

    public void left() {
        positionInCurrentString--;
        if(positionInCurrentString == 0)
            positionInCurrentString = 1;
        StringBuilder sb = new StringBuilder(text.get(currentString));
        sb.insert(positionInCurrentString, "2$");
        text.remove(currentString);
        text.add(currentString, sb.toString());
    }

    public void up() {
        currentString++;
        if(currentString > text.size() - 1) {
            currentString = text.size() - 1;
        }
        StringBuilder sb = new StringBuilder(text.get(currentString));
        sb.insert(positionInCurrentString, "2$");
        text.remove(currentString);
        text.add(currentString, sb.toString());
    }

    public void down() {
        currentString--;
        if(currentString < 0) {
            currentString = 0;
        }
        StringBuilder sb = new StringBuilder(text.get(currentString));
        sb.insert(positionInCurrentString, "2$");
        text.remove(currentString);
        text.add(currentString, sb.toString());
    }

    public void ctrlLeft() {
        while(text.get(currentString).charAt(positionInCurrentString) != ' ') {
            positionInCurrentString--;
            if(positionInCurrentString < 0) {
                positionInCurrentString = 0;
                break;
            }
        }
        StringBuilder sb = new StringBuilder(text.get(currentString));
        sb.insert(positionInCurrentString, "3$");
        text.remove(currentString);
        text.add(currentString, sb.toString());
    }

    public void ctrlRight() {
        while(text.get(currentString).charAt(positionInCurrentString) != ' ') {
            positionInCurrentString++;
            if(positionInCurrentString > text.get(currentString).length()) {
                positionInCurrentString = text.get(currentString).length();
                break;
            }
        }
        StringBuilder sb = new StringBuilder(text.get(currentString));
        sb.insert(positionInCurrentString, "3$");
        text.remove(currentString);
        text.add(currentString, sb.toString());
    }

    public void ctrlUp() {
        currentString--;
        if(currentString == -1)
            currentString = 0;
        positionInCurrentString = 0;
        StringBuilder sb = new StringBuilder(text.get(currentString));
        sb.insert(positionInCurrentString, "4$");
        text.remove(currentString);
        text.add(currentString, sb.toString());
    }

    public void ctrlDown() {
        currentString++;
        System.out.println(currentString);
        if(currentString == text.size())
            currentString = text.size() - 1;
        if(positionInCurrentString >= text.get(currentString).length())
            positionInCurrentString = text.get(currentString).length() - 1;
        StringBuilder sb = new StringBuilder(text.get(currentString));
        sb.insert(positionInCurrentString, "4$");
        text.remove(currentString);
        text.add(currentString, sb.toString());
    }

    public void backspace() {
        if(positionInCurrentString != 0) {
            StringBuilder sb = new StringBuilder(text.get(currentString));
            sb.deleteCharAt(positionInCurrentString - 1);
            text.remove(currentString);
            text.add(currentString, sb.toString());
        }
    }

    public void del() {
        if(positionInCurrentString != text.get(currentString).length()) {
            StringBuilder sb = new StringBuilder(text.get(currentString));
            sb.deleteCharAt(positionInCurrentString);
            text.remove(currentString);
            text.add(currentString, sb.toString());
        }
    }

    public void ctrlBackspace() {
        int i = positionInCurrentString;
        while(text.get(currentString).charAt(i) != ' ') {
            i--;
            if(i < 0) {
                i = 0;
                break;
            }
        }
        StringBuilder sb = new StringBuilder(text.get(currentString));
        sb.delete(positionInCurrentString - i, positionInCurrentString);
        text.remove(currentString);
        text.add(currentString, sb.toString());
        positionInCurrentString -= i;
    }

    public void ctrlDel() {
        int i = positionInCurrentString;
        while(text.get(currentString).charAt(i) != ' ') {
            i++;
            if(i > text.get(currentString).length()) {
                i = text.get(currentString).length();
                break;
            }
        }
        StringBuilder sb = new StringBuilder(text.get(currentString));
        sb.delete(positionInCurrentString, positionInCurrentString + i);
        text.remove(currentString);
        text.add(currentString, sb.toString());
    }

    public static List<String> getText() {
        return text;
    }

    public static void setText(List<String> text) {
        Correct.text = text;
    }

    public static int getPositionInCurrentString() {
        return positionInCurrentString;
    }

    public static int getCurrentString() {
        return currentString;
    }

    public static void ins() {
        if(mode == true)
            mode = false;
        else mode = true;
    }

    public static void typeSymbols() {
        if(mode == true) {
            Scanner scanner = new Scanner(System.in);
            String str = scanner.nextLine();
            StringBuilder sb = new StringBuilder(text.get(currentString));
            sb.insert(positionInCurrentString, str);
            text.remove(currentString);
            text.add(currentString, sb.toString());
        }
        else {
            Scanner scanner = new Scanner(System.in);
            String str = scanner.nextLine();
            StringBuilder sb = new StringBuilder(text.get(currentString));
            sb.delete(positionInCurrentString, str.length());
            sb.insert(positionInCurrentString, str);
            text.remove(currentString);
            text.add(currentString, sb.toString());
        }
    }
}
