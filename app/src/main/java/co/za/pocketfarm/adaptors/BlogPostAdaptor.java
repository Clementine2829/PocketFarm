package co.za.pocketfarm.adaptors;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import co.za.pocketfarm.R;
import co.za.pocketfarm.ViewBlog;
import co.za.pocketfarm.models.BlogPost;

public class BlogPostAdaptor extends RecyclerView.Adapter<BlogPostAdaptor.BlogPostsViewHolder>{
    private final List<BlogPost> posts;
    private final Activity activity;


    public BlogPostAdaptor(Activity activity, List<BlogPost> posts) {
        this.posts = posts;
        this.activity = activity;
    }

    @NonNull
    @Override
    public BlogPostAdaptor.BlogPostsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.blog_post_list_item,
                parent,
                false);
        return new BlogPostsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BlogPostsViewHolder holder, int position) {
        BlogPost blogPost = posts.get(position);
        holder.title.setText(blogPost.getTitle());
        String summary = ((blogPost.getContent().length() > 300) ?
                blogPost.getContent().substring(0, 300) :
                blogPost.getContent()) +
                "...";
        holder.summary.setText(summary);
        holder.createdBy.setText(String.format("Posted by: %s, ", blogPost.getUserCreated()));
        holder.dateCreated.setText(String.format("On %s", blogPost.getDateCreated()));
        holder.likes.setText(String.format("\t%s", blogPost.getLikes()));
        holder.dislikes.setText(String.format("\t%s", blogPost.getDislikes()));
        holder.comments.setText(String.format("\t%s", blogPost.getComments()));
        holder.summary.setOnClickListener(view -> {
            activity.startActivity(new Intent(activity, ViewBlog.class).putExtra("id", blogPost.getPostId()));
            activity.finish();
        });
        holder.likes.setOnClickListener(view -> {
            holder.likes.setText(String.format("\t%s", blogPost.getLikes() + 1));

            Drawable[] drawables = holder.likes.getCompoundDrawables();

            Drawable leftDrawable = drawables[0]; // index 0 is for left drawable, 1 for top, 2 for right, 3 for bottom

            int tintColor = Color.RED;

            leftDrawable.setColorFilter(tintColor, PorterDuff.Mode.SRC_IN);
        });
        holder.dislikes.setOnClickListener(view -> {
            holder.dislikes.setText(String.format("\t%s", blogPost.getDislikes() + 1));
        });
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public static class BlogPostsViewHolder extends RecyclerView.ViewHolder{
        public TextView title, summary, createdBy, dateCreated, likes, dislikes, comments;

        public BlogPostsViewHolder(@NonNull View itemView) {
            super(itemView);
            this.title = itemView.findViewById(R.id.title);
            this.summary = itemView.findViewById(R.id.summary);
            this.createdBy = itemView.findViewById(R.id.createdBy);
            this.dateCreated = itemView.findViewById(R.id.dateCreated);
            this.likes = itemView.findViewById(R.id.likesCount);
            this.dislikes= itemView.findViewById(R.id.dislikeCount);
            this.comments = itemView.findViewById(R.id.commentCount);
        }
    }
}
