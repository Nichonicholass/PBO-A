import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.util.Collections;

public class InputReader
{
    private Scanner reader;
    public InputReader()
    {
        reader = new Scanner(System.in);
    }

    public Set<String> getInput() 
    {
        System.out.print("> "); 
        String inputLine = reader.nextLine().trim().toLowerCase();
        
        if (inputLine.isEmpty()) {
            return Collections.emptySet();  
        }

        String[] wordArray = inputLine.split("\\s+");  

        Set<String> words = new HashSet<>();
        Collections.addAll(words, wordArray);

        return words;
    }
}
