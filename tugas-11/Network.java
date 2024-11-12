import java.util.ArrayList;

class Network {
    private ArrayList<User> users;
    private ArrayList<Post> posts;

    public Network() {
        users = new ArrayList<>();
        posts = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
        if (user instanceof AdminUser) {
            System.out.println("Added User: " + user.getUsername() + " as AdminUser");
        } else if (user instanceof RegularUser) {
            System.out.println("Added User: " + user.getUsername() + " as RegularUser");
        }
    }

    public void displayAllUsers() {
        if (users.isEmpty()) {
            System.out.println("No users available.");
        } else {
            System.out.println("All Users:");
            for (User user : users) {
                String userType = user instanceof AdminUser ? "AdminUser" : "RegularUser";
                System.out.println("- " + user.getUsername() + " (" + userType + ")");
            }
        }
    }

    public void addPost(Post post) {
        posts.add(post);
    }

    public boolean removePost(Post post) {
        if (posts.remove(post)) {
            System.out.println("Post removed successfully.");
            return true;
        }
        System.out.println("Failed to remove post.");
        return false;
    }

    public void displayAllPosts() {
        if (posts.isEmpty()) {
            System.out.println("No posts available.");
        } else {
            for (Post post : posts) {
                System.out.println("=================================");
                post.displayContent();
                System.out.println("=================================");
            }
        }
    }
}
