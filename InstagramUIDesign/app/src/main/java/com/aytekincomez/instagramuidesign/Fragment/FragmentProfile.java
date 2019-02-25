package com.aytekincomez.instagramuidesign.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.aytekincomez.instagramuidesign.R;
import com.squareup.picasso.Picasso;

public class FragmentProfile  extends Fragment {

    public void changeTab(int refid, Fragment fragment){
        getFragmentManager().beginTransaction().replace(refid, fragment).commit();

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_layout_profile, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageView ivBackButton = (ImageView)view.findViewById(R.id.btnProfileBackButton);
        ImageView ivProfileMenu = (ImageView)view.findViewById(R.id.btnProfileMenu);
        ImageView ivProfilePhoto = (ImageView)view.findViewById(R.id.ivProfilePhoto);
        TextView tvProfilePostCount = (TextView)view.findViewById(R.id.tvProfilePostCount);
        TextView tvProfileFollowCount = (TextView)view.findViewById(R.id.tvProfileFollowCount);
        TextView tvProfileFollowerCount = (TextView)view.findViewById(R.id.tvProfileFollowerCount);
        TextView tvUserName = (TextView)view.findViewById(R.id.tvProfileUserName);
        TextView tvDescription = (TextView)view.findViewById(R.id.tvProfileDescription);
        TextView tvUserWebSite = (TextView)view.findViewById(R.id.tvProfileWebSite);
        TextView tvProfileTitle = (TextView)view.findViewById(R.id.tvProfileTitle);

        Button btnUpdateProfile = (Button)view.findViewById(R.id.btnProfileUpdate);

        tvProfileFollowCount.setText("100");
        tvProfileFollowerCount.setText("70");
        tvProfilePostCount.setText("20");
        tvProfileTitle.setText("aytekincomes57");
        tvUserName.setText("aytekincomes57");
        tvUserWebSite.setText("http://serifgungor.com");
        tvDescription.setText("Hi, I am new here");
        Picasso.with(getContext()).load("https://galeri13.uludagsozluk.com/633/sozluk-yazarlarinin-profil-resmi_1363249.png")
                .into(ivProfilePhoto);
        Linkify.addLinks(tvUserWebSite, Linkify.WEB_URLS);

        ImageView ivProfilePhotosSaved = (ImageView)view.findViewById(R.id.ivPRofilePhotosSave);
        ImageView ivProfilePhotoLabel = (ImageView)view.findViewById(R.id.ivProfilePhotosLabel);
        ImageView ivProfilePhotoList = (ImageView)view.findViewById(R.id.ivProfilePhotosList);
        ImageView ivProfilePhotoGrid = (ImageView)view.findViewById(R.id.ivProfilePhotoGrid);

        ivProfilePhotoGrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeTab(R.id.frameProfile, new FragmentProfile_Grid());
            }
        });

        ivProfilePhotoList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeTab(R.id.frameProfile, new FragmentProfile_List());
            }
        });

        ivProfilePhotoLabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeTab(R.id.frameProfile, new FragmentProfile_Label());
            }
        });

        ivProfilePhotosSaved.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeTab(R.id.frameProfile, new FragmentProfile_Saved());
            }
        });

        getFragmentManager()
                .beginTransaction().replace(R.id.frameProfile, new FragmentProfile_Grid())
                .commit();
    }
}
