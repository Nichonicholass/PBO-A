import java.util.Set;
import java.util.ArrayList;

public class SupportSystem {
    private InputReader reader;
    private Responder responder;
    private ArrayList<String> conversationHistory;

    public SupportSystem() {
        reader = new InputReader();
        responder = new Responder();
        conversationHistory = new ArrayList<>();
    }

    public void start() {
        boolean finished = false;

        printWelcome();

        while (!finished) {
            Set<String> input = reader.getInput();

            if (input == null || input.isEmpty()) {
                System.out.println("Sorry, I didn't catch that. Could you please repeat?");
            } 
            
            else if (input.contains("bye")) {
                finished = true;
            } else {
                String response = responder.generateResponse(input);
                conversationHistory.add("> " + input);
                conversationHistory.add(response);
                System.out.println(colorText(response, "green"));
            }
        }
        printGoodbye();
        printHistory();
    }

    private void printWelcome() {
        System.out.println("-------------------------------------------------------");
    System.out.println("Selamat datang pada Technical Support System");
    System.out.println("-------------------------------------------------------");
    System.out.println("Kami siap membantu Anda dengan kendala teknis.");
    System.out.println("Jelaskan masalah Anda, dan kami akan mencari solusinya.");
    System.out.println("Ketik 'bye' apabila sudah selesai menggunakan sistem kami.");
}

    private void printGoodbye() {
        System.out.println("Terima kasih telah menggunakan Support System Bank ABC");
        System.out.println("-------------------------------------------------------");
    }

    private void printHistory() {
        System.out.println("\nRiwayat Percakapan Anda:");
        for (String line : conversationHistory) {
            System.out.println(line);
        }
    }

    private String colorText(String text, String color) {
        final String RESET = "\u001B[0m";
        switch (color.toLowerCase()) {
            case "green":
                return "\u001B[32m" + text + RESET;
            case "yellow":
                return "\u001B[33m" + text + RESET;
            default:
                return text;
        }
    }

    public static void main(String[] args) {
        SupportSystem system = new SupportSystem();
        system.start();
    }
}
