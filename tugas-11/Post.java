import java.util.ArrayList;
import java.util.Date;

abstract class Post {
    protected String author;
    protected Date timestamp;
    protected ArrayList<String> likes;
    protected ArrayList<String> comments;

    public Post(String author) {
        this.author = author;
        this.timestamp = new Date();
        this.likes = new ArrayList<>();
        this.comments = new ArrayList<>();
    }

    public void addLike(String username) {
        if (!likes.contains(username)) {
            likes.add(username);
            System.out.println(username + " liked the post.");
        } else {
            System.out.println(username + " already liked this post.");
        }
    }

    public void addComment(String username, String comment) {
        comments.add(username + " : " + comment);
        System.out.println("Comment added by " + username + ": " + comment);
    }

    public void displayLikes() {
        System.out.println("Likes (" + likes.size() + "):");
        if (likes.isEmpty()) {
            System.out.println("No likes yet.");
        } else {
            for (String like : likes) {
                System.out.println("- " + like);
            }
        }
    }

    public void displayComments() {
        System.out.println("Comments:");
        if (comments.isEmpty()) {
            System.out.println("No comments yet.");
        } else {
            for (String comment : comments) {
                System.out.println("- " + comment);
            }
        }
    }

    public abstract void displayContent();

    public String getAuthor() {
        return author;
    }
}
