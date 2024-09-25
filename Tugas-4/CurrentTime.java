import java.time.LocalTime;

public class CurrentTime {
    public static void main(String[] args) {
        ClockDisplay clock = new ClockDisplay();  
        
        LocalTime waktuSekarang = LocalTime.now();

        int jam = waktuSekarang.getHour();
        int menit = waktuSekarang.getMinute();
        int detik = waktuSekarang.getSecond();

        clock.setTime(jam, menit, detik);
    }
}
