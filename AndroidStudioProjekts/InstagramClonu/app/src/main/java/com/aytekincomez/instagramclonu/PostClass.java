package com.aytekincomez.instagramclonu;

import android.app.Activity;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PostClass extends ArrayAdapter<String> {

    private final ArrayList<String> username;
    private final ArrayList<Bitmap> userImage;
    private final ArrayList<String> userComment;
    private final Activity context;


    public PostClass(ArrayList<String> username, ArrayList<Bitmap> userImage, ArrayList<String> userComment, Activity context) {
        super(context,R.layout.custom_view, username);
        this.username = username;
        this.userImage = userImage;
        this.userComment = userComment;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = context.getLayoutInflater();
        View custonView = layoutInflater.inflate(R.layout.custom_view,null,true);
        TextView usernameText = (TextView) custonView.findViewById(R.id.username);
        ImageView imageView = (ImageView) custonView.findViewById(R.id.imageView);
        TextView commentText = (TextView) custonView.findViewById(R.id.commentText);

        usernameText.setText(username.get(position));
        imageView.setImageBitmap(userImage.get(position));
        commentText.setText(userComment.get(position));


        return custonView;
    }
}












