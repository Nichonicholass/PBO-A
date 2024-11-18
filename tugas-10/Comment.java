package test.java;
public class Comment {
    private String author;
    private String text;
    private int rating;
    private int upvotes;
    private int downvotes;

    public Comment(String author, String text, int rating) {
        this.author = author;
        this.text = text;
        this.rating = rating;
        this.upvotes = 0;
        this.downvotes = 0;
    }

    public String getAuthor() {
        return author;
    }

    public void upvote() {
        upvotes++;
    }

    public void downvote() {
        downvotes++;
    }

    public int getVoteBalance() {
        return upvotes - downvotes;
    }

    @Override
    public String toString() {
        return author + ": " + text + " (Rating: " + rating + ", Votes: " + getVoteBalance() + ")";
    }
}
