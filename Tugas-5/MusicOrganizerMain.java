import java.util.ArrayList;
import java.util.Scanner;

class MusicOrganizer {

    private ArrayList<Track> tracks;
    private MusicPlayer player;
    private TrackReader reader;
    private Track currentTrack;

    public MusicOrganizer() {
        tracks = new ArrayList<Track>();
        player = new MusicPlayer();
        reader = new TrackReader();
        readLibrary("audio");
        System.out.println("Music library loaded. " + getNumberOfTracks() + " tracks.");
        System.out.println();
    }

    public void addTrack(Track track) {
        tracks.add(track);
    }

    public void addTrack(String title, String artist, String filename) {
        if (title.isEmpty() || artist.isEmpty() || filename.isEmpty()) {
            System.out.println("Title, artist, atau filename tidak boleh kosong");
            return;
        }
        Track newTrack = new Track(title, artist, filename);
        tracks.add(newTrack);
        System.out.println("Track added: " + newTrack.getDetails());
    }

    public void removeTrack(int index) {
        if (indexValid(index-1)) {
            Track removedTrack = tracks.remove(index-1);
            System.out.println("Track removed: " + removedTrack.getDetails());
        } else {
            System.out.println("Invalid index. No track removed.");
        }
    }

    public void searchTrack(String keyword) {
        System.out.println("Search results for: " + keyword);
        keyword = keyword.toLowerCase();
        boolean found = false;

        for (Track track : tracks) {
            if (track.getTitle().toLowerCase().contains(keyword) || track.getArtist().toLowerCase().contains(keyword)) {
                System.out.println(track.getDetails());
                found = true;
            }
        }

        if (!found) {
            System.out.println("No tracks found for the keyword: " + keyword);
        }
    }

    public void listAllTracks() {
        System.out.println("Track listing: ");
        int i = 1;
        for (Track track : tracks) {
            System.out.println(i + ". " + track.getDetails());
            i++;
        }
        System.out.println();
    }

    public void playTrack(int index) {
        if (indexValid(index - 1)) {
            if (currentTrack != null) {
                stopPlaying();  // Hentikan track sebelumnya jika ada
            }
            Track track = tracks.get(index - 1);
            player.startPlaying(track.getFilename());
            currentTrack = track;
            System.out.println("Now playing: " + track.getArtist() + " - " + track.getTitle());
        } else {
            System.out.println("Invalid track index.");
        }
    }

    public void stopPlaying() {
        if (currentTrack != null) {
            player.stop();
            System.out.println("Stopped playing: " + currentTrack.getArtist() + " - " + currentTrack.getTitle());
            currentTrack = null;
        } else {
            System.out.println("No track is currently playing.");
        }
    }

    private boolean indexValid(int index) {
        return index >= 0 && index < tracks.size();
    }

    public int getNumberOfTracks() {
        return tracks.size();
    }

    private void readLibrary(String folderName) {
        tracks.addAll(reader.readTracks(folderName));
    }
}

class Track {
    private String title;
    private String artist;
    private String filename;

    public Track(String title, String artist, String filename) {
        this.title = title;
        this.artist = artist;
        this.filename = filename;
    }

    public String getDetails() {
        return artist + " - " + title;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getFilename() {
        return filename;
    }
}

class MusicPlayer {

    public void startPlaying(String filename) {
        System.out.println("Playing: " + filename);
    }

    public void stop() {
        System.out.println("Music stopped.");
    }
}

public class MusicOrganizerMain {

    public static void main(String[] args) {
        
        Scanner userInput = new Scanner(System.in);
        
        MusicOrganizer organizer = new MusicOrganizer();

        int option = 0;

        while(option != 7){  
            System.out.println("\n--- Music Organizer ---");
            System.out.println("1. Memasukkan Lagu");
            System.out.println("2. Melihat List semua Lagu");
            System.out.println("3. Memainkan Lagu");
            System.out.println("4. Mencari Lagu");
            System.out.println("5. Menghapus Lagu dari Track");
            System.out.println("6. Menhentikan Lagu yang sedang di play");
            System.out.println("7. Exit");
            System.out.println("--------------");
            System.out.print("Masukkan pilihan Anda : ");
            option = userInput.nextInt();

            switch (option){
                case 1:
                System.out.print("Masukkan Judul Lagu : ");
                userInput.nextLine();
                String input_judul = userInput.nextLine();

                System.out.print("Masukkan Penyanyi Lagu : ");
                String input_penyanyi = userInput.nextLine();

                System.out.print("Masukkan Namafile : ");
                String input_namafile = userInput.nextLine();

                organizer.addTrack(input_judul,input_penyanyi, input_namafile);
                break;
                

                case 2:
                System.out.println("\n- List Lagu -");
                organizer.listAllTracks();
                break;

                case 3:
                System.out.println("\n- Pilih nomor lagu untuk dimainkan -");
                int index = userInput.nextInt();
                organizer.playTrack(index);
                break;
                
                case 4:
                System.out.println("Masukkan Judul atau Penyanyi lagu yang ingin kamu cari");
                userInput.nextLine();
                String cari = userInput.nextLine();
                organizer.searchTrack(cari); 
                break;

                case 5:
                System.out.println("\n- Pilih nomor lagu yang ingin dihapus -");
                int remove = userInput.nextInt();
                organizer.removeTrack(remove);
                
                case 6:  // Opsi untuk menghentikan track
                organizer.stopPlaying();
                break;

                case 7:
                System.out.println("\n--- Terima Kasih ---");
                break;
            }
        } 
    }
}
