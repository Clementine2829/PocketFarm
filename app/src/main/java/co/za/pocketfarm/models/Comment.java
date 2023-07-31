package co.za.pocketfarm.models;

import android.widget.ImageView;

public class Comment {
    private final String commentId;
    private ImageView imageIcon;
    private final String content;
    private int likes;
    private int dislikes;
    private int comments;
    private User user;

    public Comment(String commentId, String content) {
        this.commentId = commentId;
        this.content = content;
        this.user = null;
    }

    public String getCommentId() {
        return commentId;
    }

    public ImageView getImageIcon() {
        return imageIcon;
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

    public User getUser() {
        return user;
    }

    public void setImageIcon(ImageView imageIcon) {
        this.imageIcon = imageIcon;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
