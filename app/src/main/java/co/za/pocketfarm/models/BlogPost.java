package co.za.pocketfarm.models;

import static co.za.pocketfarm.CurrentDate.getCurrentDate;

public class BlogPost {
    private final String postId;
    private final String title;
    private final String content;
    private final String dateCreated;
    private User userCreated;
    private int likes;
    private int dislikes;
    private int comments;

    public BlogPost(String postId, String title, String content) {
        this.postId = postId;
        this.title = title;
        this.content = content;
        this.dateCreated = getCurrentDate();
        this.userCreated = null;
        this.likes = 0;
        this.dislikes = 0;
        this.comments = 0;
    }

    public String getPostId() {
        return postId;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public int getLikes() {
        return likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public int getComments() {
        return comments;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public String getUserCreated() {
        return (userCreated != null) ? userCreated.getFirstName() : "Stuff";
    }

    public void setLikes(int likes){
        this.likes = likes;
    }

    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    public void setUserCreated(User user) {
        this.userCreated = user;
    }
}
