class ImagePost extends Post {
    private String imageUrl;

    public ImagePost(String author, String imageUrl) {
        super(author);
        this.imageUrl = imageUrl;
    }

    @Override
    public void displayContent() {
        System.out.println("Image URL: " + imageUrl);
        System.out.println("Author: " + author);
        System.out.println("Timestamp: " + timestamp);
        displayLikes();
        displayComments();
    }
}
