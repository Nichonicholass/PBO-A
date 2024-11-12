class User {
    protected String username;
    protected String name;
    protected String status;

    public User(String username, String name) {
        this.username = username;
        this.name = name;
        this.status = "No status set.";
    }

    public String getUsername() {
        return username;
    }

    public void setStatus(String status) {
        this.status = status;
        System.out.println(username + " updated their status: " + status);
    }

    public void displayStatus() {
        System.out.println(username + "'s status: " + status);
    }

    public void likePost(Post post) {
        post.addLike(username);
    }

    public void commentOnPost(Post post, String comment) {
        post.addComment(username, comment);
    }

    public boolean deletePost(Network network, Post post) {
        if (post.getAuthor().equals(username)) {
            return network.removePost(post);
        }
        System.out.println("Hanya AdminUser yang dapat menghapus postingan orang lain.");
        return false;
    }
}
