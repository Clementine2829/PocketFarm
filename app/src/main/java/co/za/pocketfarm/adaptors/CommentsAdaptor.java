package co.za.pocketfarm.adaptors;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import co.za.pocketfarm.R;
import co.za.pocketfarm.models.Comment;

public class CommentsAdaptor extends RecyclerView.Adapter<CommentsAdaptor.CommentsViewHolder> {

    private final List<Comment> comments;

    public CommentsAdaptor(List<Comment> comments) {
        this.comments = comments;
    }

    @NonNull
    @Override
    public CommentsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.comments,
                parent,
                false);
        return new CommentsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CommentsViewHolder holder, int position) {
        Comment comment = comments.get(position);
        holder.comment.setText(comment.getContent());
        String user = (comment.getUser() != null) ? comment.getUser().getFirstName() : "Anonymous user";
        holder.user.setText(user);
        if(user.equals("Anonymous user")){
            holder.user.setTextColor(Color.GRAY);
        }
   }

    @Override
    public int getItemCount() {
        return comments.size();
    }

    public static class CommentsViewHolder extends RecyclerView.ViewHolder{
        public TextView comment, user;

        public CommentsViewHolder(@NonNull View itemView) {
            super(itemView);
            this.comment = itemView.findViewById(R.id.comment);
            this.user = itemView.findViewById(R.id.username);
        }
    }
}
