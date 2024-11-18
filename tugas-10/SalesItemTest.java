package test.java;
import org.junit.jupiter.api.Test;

import main.java.SalesItem;

import static org.junit.jupiter.api.Assertions.*;

public class SalesItemTest {
    @Test
    public void testAddComment() {
        SalesItem item = new SalesItem("Laptop", 1000.0);
        assertTrue(item.addComment("Alice", "Great product!", 5));
        assertFalse(item.addComment("Alice", "Duplicate comment", 4)); 
        assertFalse(item.addComment("Bob", "Bad rating", 6)); 
    }

    @Test
    public void testRemoveComment() {
        SalesItem item = new SalesItem("Laptop", 1000.0);
        item.addComment("Alice", "Great product!", 5);
        assertTrue(item.removeComment("Alice"));
        assertFalse(item.removeComment("Bob"));
    }

    @Test
    public void testGetMostHelpfulComment() {
        SalesItem item = new SalesItem("Laptop", 1000.0);
        item.addComment("Alice", "Great product!", 5);
        item.addComment("Bob", "Average.", 3);
        item.getMostHelpfulComment().upvote();
        assertEquals("Alice", item.getMostHelpfulComment().getAuthor());
    }
}
