package main.java;
import java.util.*;

import test.java.Comment;

public class SalesItem {
    private String description;
    private double price;
    private List<Comment> comments;

    public SalesItem(String description, double price) {
        this.description = description;
        this.price = price;
        this.comments = new ArrayList<>();
    }

    public boolean addComment(String author, String text, int rating) {
        if (rating < 1 || rating > 5) return false;
        for (Comment comment : comments) {
            if (comment.getAuthor().equals(author)) return false;
        }
        comments.add(new Comment(author, text, rating));
        return true;
    }

    public boolean removeComment(String author) {
        return comments.removeIf(comment -> comment.getAuthor().equals(author));
    }

    public void showInfo() {
        System.out.println("Description: " + description);
        System.out.println("Price: " + price);
        comments.forEach(System.out::println);
    }

    public Comment getMostHelpfulComment() {
        return comments.stream().max(Comparator.comparingInt(Comment::getVoteBalance)).orElse(null);
    }
}
