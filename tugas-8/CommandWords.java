import java.util.Arrays;
import java.util.HashSet;

public class CommandWords {
    private HashSet<String> validCommands;

    public CommandWords() {
        validCommands = new HashSet<>(Arrays.asList("go", "quit", "help"));
    }

    public boolean isCommand(String word) {
        return validCommands.contains(word);
    }

    public String getCommandList() {
        return String.join(", ", validCommands);
    }
}
