class TextPost extends Post {
    private String content;

    public TextPost(String author, String content) {
        super(author);
        this.content = content;
    }

    @Override
    public void displayContent() {
        System.out.println("Text Post Content: " + content);
        System.out.println("Author: " + author);
        System.out.println("Timestamp: " + timestamp);
        displayLikes();
        displayComments();
    }
}
