package com.example.chat.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.chat.Clases.Chat;
import com.example.chat.Clases.User;
import com.example.chat.R;
import com.example.chat.Vista.MessageActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

/**
 * The type Message adapter.
 */
public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.ViewHolder> {

    /**
     * The constant MSG_TYPE_LEFT.
     */
    public static final int MSG_TYPE_LEFT = 0;
    /**
     * The constant MSG_TYPE_RIGHT.
     */
    public static final int MSG_TYPE_RIGHT = 1;
    private Context mContext;
    private List<Chat> mChat;
    private String imageurl;

    /**
     * The Firebase user.
     */
    FirebaseUser firebaseUser;

    /**
     * Instantiates a new Message adapter.
     *
     * @param mContext the m context
     * @param mChat    the m chat
     * @param imageurl the imageurl
     */
    public MessageAdapter(Context mContext, List<Chat> mChat, String imageurl){
        this.mChat = mChat;
        this.mContext = mContext;
        this.imageurl = imageurl;
    }

    /**
     * On create view holder message adapter . view holder.
     *
     * @param parent   the parent
     * @param viewType the view type
     * @return the message adapter . view holder
     */
    @NonNull
    @Override
    public MessageAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType == MSG_TYPE_RIGHT){
            View view = LayoutInflater.from(mContext).inflate(R.layout.chat_item_right, parent, false);
            return new MessageAdapter.ViewHolder(view);
        }else{
            View view = LayoutInflater.from(mContext).inflate(R.layout.chat_item_left, parent, false);
            return new MessageAdapter.ViewHolder(view);
        }
    }

    /**
     * On bind view holder.
     *
     * @param holder   the holder
     * @param position the position
     */
    @Override
    public void onBindViewHolder(@NonNull MessageAdapter.ViewHolder holder, int position) {
        Chat chat = mChat.get(position);

        holder.show_message.setText(chat.getMessage());

        if (imageurl.equals("default")) {
            holder.profile_image.setImageResource(R.mipmap.ic_launcher);
        }else{
            Glide.with(mContext).load(imageurl).into(holder.profile_image);
        }

        if(position == mChat.size()-1){
            if(chat.isIsseen()){
                holder.txt_seen.setText("Seen");
            }else{
                holder.txt_seen.setText("Delivered");
            }
        }else{
            holder.txt_seen.setVisibility(View.GONE);
        }
    }

    /**
     * Gets item count.
     *
     * @return the item count
     */
    @Override
    public int getItemCount() {
        return mChat.size();
    }

    /**
     * The type View holder.
     */
    public class ViewHolder extends RecyclerView.ViewHolder{
        /**
         * The Show message.
         */
        public TextView show_message;
        /**
         * The Profile image.
         */
        public ImageView profile_image;

        /**
         * The Txt seen.
         */
        public TextView txt_seen;

        /**
         * Instantiates a new View holder.
         *
         * @param itemView the item view
         */
        public ViewHolder(View itemView){
            super(itemView);

            show_message = itemView.findViewById(R.id.show_message);
            profile_image = itemView.findViewById(R.id.profile_image);
            txt_seen = itemView.findViewById(R.id.txt_seen);
        }
    }

    /**
     * Gets item view type.
     *
     * @param position the position
     * @return the item view type
     */
    @Override
    public int getItemViewType(int position) {
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        if(mChat.get(position).getSender().equals(firebaseUser.getUid())){
            return MSG_TYPE_RIGHT;
        }else{
            return MSG_TYPE_LEFT;
        }
    }
}
