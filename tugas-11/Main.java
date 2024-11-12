public class Main {
    public static void main(String[] args) {
        Network network = new Network();

        // Menambahkan pengguna
        RegularUser user1 = new RegularUser("Tino", "TinoDonino");
        RegularUser user2 = new RegularUser("Adi", "AdiSaputra");
        AdminUser admin = new AdminUser("Jesi", "JesiJaya");

        network.addUser(user1);
        network.addUser(user2);
        network.addUser(admin);
        System.out.println("\n");  

        // Menampilkan semua pengguna
        network.displayAllUsers();
        System.out.println("\n");  

        // Mengatur status pengguna
        user1.setStatus("Feeling happy!");
        user2.setStatus("Busy with work.");
        admin.setStatus("Monitoring the network.");
        System.out.println("\n");  

        // Menampilkan status salah satu pengguna
        user1.displayStatus();
        user2.displayStatus();
        admin.displayStatus();
        System.out.println("\n");  


        // Membuat dan menambahkan postingan
        TextPost post1 = new TextPost(user1.getUsername(), "Hello, this is my first post!");
        ImagePost post2 = new ImagePost(user2.getUsername(), "http://image-url.com/photo.jpg");

        network.addPost(post1);
        network.addPost(post2);

        // Menambahkan like dan komentar
        user1.likePost(post1);
        user2.likePost(post1);
        admin.likePost(post2);

        user2.commentOnPost(post1, "Nice post!");
        user1.commentOnPost(post2, "Great photo!");
        System.out.println("\n");  

        // Menampilkan semua postingan
        network.displayAllPosts();
        System.out.println("\n");  

        // Mencoba menghapus postingan orang lain
        user1.deletePost(network, post2);
        admin.deletePost(network, post1);
        admin.deletePost(network, post2);
        System.out.println("\n");  

        // Menampilkan semua postingan setelah penghapusan
        network.displayAllPosts();
    }
}
