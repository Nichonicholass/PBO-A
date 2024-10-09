import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;
import java.util.Set;

public class Responder
{
    
    private HashMap<String, String> responseMap;
    private ArrayList<String> defaultResponses;
    private Random randomGenerator;

    public Responder()
    {
        responseMap = new HashMap<>();
        defaultResponses = new ArrayList<>();
        fillResponseMap();
        fillDefaultResponses();
        randomGenerator = new Random();
    }

    
public String generateResponse(Set<String> words)
{
    if (words == null || words.isEmpty()) {
        return "Can you please clarify your issue? I didn't get any information.";
    }

    for (String word : words) {
        String response = responseMap.get(word);
        if (response != null) {
            return response;
        }
    }

    return pickDefaultResponse();
}

    private void fillResponseMap()
    {
        this.responseMap.put("saldo", "Anda dapat memeriksa saldo Anda melalui aplikasi mobile atau internet banking kami. Apakah Anda memerlukan bantuan untuk itu?");
        this.responseMap.put("akun", "Kami menyediakan berbagai jenis akun, termasuk tabungan, giro, dan rekening investasi. Jenis akun apa yang ingin Anda tanyakan?");
        this.responseMap.put("pinjaman", "Kami menawarkan berbagai produk pinjaman seperti pinjaman pribadi, pinjaman rumah, dan pinjaman kendaraan. Pinjaman jenis apa yang Anda minati?");
        this.responseMap.put("kredit", "Apakah Anda ingin menanyakan layanan kartu kredit atau informasi mengenai skor kredit Anda? Kami dapat membantu keduanya.");
        this.responseMap.put("biaya", "Bank ABC berusaha menjaga keterbukaan terkait biaya. Apakah Anda ingin menanyakan biaya transaksi, penarikan, atau biaya administrasi akun?");
        this.responseMap.put("bunga", "Suku bunga kami bervariasi tergantung pada produk. Untuk tabungan, suku bunganya saat ini 1,5%. Apakah Anda ingin mengetahui lebih lanjut tentang suku bunga pinjaman?");
        this.responseMap.put("penipuan", "Jika Anda mencurigai adanya penipuan, harap segera hubungi departemen fraud kami di 123-456-7890. Apakah Anda membutuhkan bantuan untuk memblokir akun Anda?");
        this.responseMap.put("transaksi", "Kami bisa membantu Anda meninjau transaksi terbaru. Apakah Anda ingin mengakses riwayat transaksi melalui mobile banking atau internet banking?");
        this.responseMap.put("internet banking", "Anda dapat mengelola akun Anda secara online. Apakah Anda memerlukan bantuan untuk mengatur atau mengakses internet banking?");
        this.responseMap.put("atm", "Kami memiliki ATM di seluruh negeri. Anda dapat menggunakan pencari lokasi ATM di situs web kami untuk menemukan yang terdekat.");
        this.responseMap.put("mutasi", "Anda bisa mengunduh atau meminta salinan mutasi rekening melalui aplikasi mobile atau internet banking. Apakah Anda ingin bantuan untuk itu?");
        this.responseMap.put("kartu", "Apakah Anda menanyakan tentang kartu debit atau kartu kredit? Jika kartu hilang atau dicuri, kami bisa membantu memblokirnya segera.");
        this.responseMap.put("password", "Jika Anda lupa password, Anda dapat meresetnya melalui aplikasi mobile atau internet banking. Apakah Anda membutuhkan panduan langkah demi langkah?");
        this.responseMap.put("cabang", "Kami memiliki banyak cabang di seluruh Indonesia. Saya dapat membantu Anda menemukan cabang terdekat atau membuat janji temu.");
    }

    private void fillDefaultResponses()
    {
        defaultResponses.add("Itu terdengar tidak biasa. Bisakah Anda menjelaskan masalah tersebut dengan lebih rinci?");
        defaultResponses.add("Tidak ada nasabah lain yang pernah melaporkan masalah ini sebelumnya. Bisakah dijelaskan lebih lanjut?");
        defaultResponses.add("Itu terdengar menarik. Ceritakan lebih lanjut...");
        defaultResponses.add("Saya memerlukan informasi lebih lanjut tentang masalah ini.");
        defaultResponses.add("Bisakah Anda jelaskan lebih lanjut?");
        defaultResponses.add("Apakah Anda sudah mencoba menghubungi layanan pelanggan kami di cabang terdekat?");
    }

    private String pickDefaultResponse()
    {
        int index = randomGenerator.nextInt(defaultResponses.size());
        return defaultResponses.get(index);
    }
}
