import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;
import java.util.Set;

public class Responder {
    private HashMap<String, String> responseMap;
    private ArrayList<String> defaultResponses;
    private ArrayList<String> funFacts;
    private Random randomGenerator;

    public Responder() {
        responseMap = new HashMap<>();
        defaultResponses = new ArrayList<>();
        funFacts = new ArrayList<>();
        fillResponseMap();
        fillDefaultResponses();
        fillFunFacts();
        randomGenerator = new Random();
    }

    public String generateResponse(Set<String> words) {

        if (words.stream().anyMatch(word -> word.equalsIgnoreCase("funfact") || word.equalsIgnoreCase("fun fact"))) {
            System.out.println("Returning a fun fact.");
            return getFunFact();
        }

        for (String word : words) {
            String response = responseMap.get(word.toLowerCase());
            if (response != null) {
                return response;
            }
        }

        System.out.println("Returning a default response.");
        return pickDefaultResponse();
    }

    private void fillResponseMap() {
        responseMap.put("software", "Kami dapat membantu memperbaiki masalah perangkat lunak yang Anda alami.");
        responseMap.put("hardware", "Jika Anda menghadapi masalah perangkat keras, cek koneksi dan beri detail lebih banyak.");
        responseMap.put("network", "Apakah Anda mengalami kendala pada jaringan? Restart router atau hubungi kami.");
        responseMap.put("password", "Jika Anda lupa password, kami dapat membantu Anda meresetnya.");
        responseMap.put("update", "Pembaruan perangkat lunak sering kali meningkatkan kinerja. Perlu panduan?");
        responseMap.put("kontak", "Hubungi kami di 123-456-789 atau support@techsupport.com.");
    }

    private void fillDefaultResponses() {
        defaultResponses.add("Itu terdengar seperti masalah teknis. Bisakah Anda memberikan informasi lebih rinci?");
        defaultResponses.add("Apakah Anda sudah mencoba langkah dasar seperti restart perangkat?");
        defaultResponses.add("Kami akan sangat senang membantu Anda, tetapi kami memerlukan lebih banyak detail.");
        defaultResponses.add("Ceritakan lebih lanjut agar kami bisa memberikan solusi terbaik.");
    }

    private void fillFunFacts() {
        funFacts.add("Tahukah Anda? Komputer pertama yang disebut ENIAC memiliki berat lebih dari 27 ton.");
        funFacts.add("Keyboard QWERTY dirancang untuk memperlambat pengetikan agar mesin ketik manual tidak macet.");
        funFacts.add("Istilah 'bug' dalam komputer berasal dari serangga yang ditemukan di dalam komputer Mark II pada tahun 1947.");
    }

    private String pickDefaultResponse() {
        int index = randomGenerator.nextInt(defaultResponses.size());
        return defaultResponses.get(index);
    }

    public String getFunFact() {
        if (funFacts.isEmpty()) {
            return "Belum ada fakta menarik yang tersedia.";
        }
        int index = randomGenerator.nextInt(funFacts.size());
        return funFacts.get(index);
    }
}
