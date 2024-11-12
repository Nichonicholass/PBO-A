class RegularUser extends User {

    public RegularUser(String username, String name) {
        super(username, name);
    }

    @Override
    public boolean deletePost(Network network, Post post) {
        if (post.getAuthor().equals(username)) {
            return network.removePost(post);
        }
        System.out.println("Only Admin can delete post other people.");
        return false;
    }
}
