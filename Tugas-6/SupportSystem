import java.util.Set;
public class SupportSystem
{
    private InputReader reader;
    private Responder responder;

    public SupportSystem()
    {
        reader = new InputReader();
        responder = new Responder();
    }


    public void start()
    {
        boolean finished = false;

        printWelcome();

        while(!finished) {
            Set<String> input = reader.getInput();

            if (input == null || input.isEmpty()) {
                System.out.println("Sorry, I didn't catch that. Could you please repeat?");
            } 
            else if(input.contains("bye")) {
                finished = true;
            } 
            else {
                String response = responder.generateResponse(input);
                System.out.println(response);
            }
        }
        printGoodbye();
    }


    private void printWelcome()
    {   
        System.out.println("-------------------------------------------------------");
        System.out.println("Selamat datang pada Support System Bank ABC");
        System.out.println("-------------------------------------------------------");
        System.out.println("Katakan pada kami kendala yang anda alami.");
        System.out.println("Kami akan membantu mengatasi masalah anda.");
        System.out.println("Ketik 'bye' apabila sudah selesai menggunakan sistem kami");
    }


    private void printGoodbye()
    {
        System.out.println("Terima kasih telah menggunakan Support System Bank ABC");
        System.out.println("-------------------------------------------------------");

    }

    public static void main(String[] args)
    {
        SupportSystem system = new SupportSystem();
        system.start();
    }
}
