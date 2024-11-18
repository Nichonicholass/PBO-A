import java.util.Scanner;

public class Parser {
    private CommandWords commandWords;
    private Scanner reader;

    public Parser() {
        commandWords = new CommandWords();
        reader = new Scanner(System.in);
    }

    public Command getCommand() {
        System.out.print("> ");
        String inputLine = reader.nextLine();
        String[] words = inputLine.split(" ");

        String commandWord = (words.length > 0) ? words[0] : null;
        String secondWord = (words.length > 1) ? words[1] : null;

        if (commandWords.isCommand(commandWord)) {
            return new Command(commandWord, secondWord);
        } else {
            return new Command(null, secondWord);
        }
    }

    public void showCommands() {
        System.out.println("Valid commands are: " + commandWords.getCommandList());
    }
}
