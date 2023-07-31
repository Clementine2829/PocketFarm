package co.za.pocketfarm;

import static co.za.pocketfarm.fragmenets.BlogPostsFragment.posts;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import co.za.pocketfarm.adaptors.CommentsAdaptor;
import co.za.pocketfarm.models.BlogPost;
import co.za.pocketfarm.models.Comment;
import co.za.pocketfarm.models.User;

public class ViewBlog extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_blog);
        setTitle("Pocket Farm - View post");

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            String postId = extras.getString("id");
            displayPost(posts, postId);
        }else{
            createAPopUpMessage();
        }
    }

    private void displayPost(List<BlogPost> posts, String id) {
        TextView title = findViewById(R.id.title);
        TextView body = findViewById(R.id.body);
        TextView likes = findViewById(R.id.likesCount);
        TextView dislikes = findViewById(R.id.dislikeCount);
        TextView comments = findViewById(R.id.commentCount);

        BlogPost post = getPost(posts, id);
        if(post != null && !id.isEmpty()){
            title.setText(post.getTitle());
            body.setText(post.getContent());
            likes.setText(String.format("\t%s", post.getLikes()));
            dislikes.setText(String.format("\t%s", post.getDislikes()));
            comments.setText(String.format("\t%s", post.getComments()));
            getComments();
        }else{
            createAPopUpMessage();
        }
    }

    private BlogPost getPost(List<BlogPost> posts, String id) {
        for (BlogPost post: posts) {
            if(post.getPostId().equals(id)) return post;
        }
        return null;
    }

    private void getComments() {
        RecyclerView recyclerView = findViewById(R.id.comments);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        // Create and set the adapter
        List<Comment> comments = new ArrayList<>();
        Comment c1 = new Comment("1", "Very insightful ");
        Comment c2 = new Comment("2", "This reminds me of my old plants and I was able to use the " +
                "oil to kill all the pets in my farm");
        Comment c3 = new Comment("3", "I like it");
        Comment c4 = new Comment("4", "Thanks for such post");

        c1.setUser(new User("", "Thulani"));
        c3.setUser(new User("", "Livett"));
        c4.setUser(new User("", "Clementine"));

        comments.add(c1);
        comments.add(c2);
        comments.add(c3);
        comments.add(c4);

        CommentsAdaptor adapter = new CommentsAdaptor(comments);
        recyclerView.setAdapter(adapter);
    }
    private void goToHomePage() {
        startActivity(new Intent(this, MainActivity.class).putExtra("fragment", "blog"));
        finishAffinity();
    }
    private void createAPopUpMessage() {
        findViewById(R.id.commentsAndLikes).setVisibility(View.GONE);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Post not found");
        builder.setMessage("Blog post not found. Reason might be that it has been removed from the server." +
                            "\nRedirecting to blog list");
        builder.setCancelable(false);
        builder.setPositiveButton("Okay", (dialog, which) -> goToHomePage());
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    @Override
    public void onBackPressed() {
        goToHomePage();
    }
}