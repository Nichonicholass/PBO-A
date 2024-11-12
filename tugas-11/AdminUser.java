class AdminUser extends User {

    public AdminUser(String username, String name) {
        super(username, name);
    }

    @Override
    public boolean deletePost(Network network, Post post) {
        System.out.println("Admin is deleting the post by " + post.getAuthor());
        return network.removePost(post);
    }
}
