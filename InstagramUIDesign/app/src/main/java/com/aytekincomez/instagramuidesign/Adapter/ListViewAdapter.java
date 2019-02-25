package com.aytekincomez.instagramuidesign.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.aytekincomez.instagramuidesign.Model.UserShare;
import com.aytekincomez.instagramuidesign.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {
    Context context;
    ArrayList<UserShare> userShare;
    LayoutInflater layoutInflater;

    public ListViewAdapter(Context context, ArrayList<UserShare> userShare){
        this.context = context;
        this.userShare = userShare;
        this.layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return userShare.size();
    }

    @Override
    public Object getItem(int position) {
        return userShare.get(position);
    }

    @Override
    public long getItemId(int position) {
        return userShare.get(position).getUser_share_id();
    }


    ImageView iconFavori, iconPaylas, iconMesaj, ivProfilResim, ivPaylasimResmi;
    TextView tvUserName, tvKonum, tvZaman, tvPaylasimYazisi, tvBegeniSayisi;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = layoutInflater.inflate(R.layout.listview_home, null) ;

        iconFavori = (ImageView)view.findViewById(R.id.icon_like_listView);
        iconPaylas = (ImageView)view.findViewById(R.id.icon_share_listView);
        iconMesaj = (ImageView)view.findViewById(R.id.icon_comment_listView);
        ivProfilResim = (ImageView)view.findViewById(R.id.ivProfilePhoto_ListView);
        ivPaylasimResmi = (ImageView)view.findViewById(R.id.ivSharePhoto_ListView);

        tvUserName = (TextView)view.findViewById(R.id.tvUserName_ListView);
        tvKonum = (TextView)view.findViewById(R.id.tvLocation_ListView);
        tvZaman = (TextView)view.findViewById(R.id.tvShareTime_ListView);
        tvPaylasimYazisi = (TextView)view.findViewById(R.id.tvShareText_ListView);
        tvBegeniSayisi = (TextView)view.findViewById(R.id.tvLikeCount_ListView);

        tvUserName.setText(userShare.get(position).getUser_name());
        tvKonum.setText(userShare.get(position).getUser_share_location_name());
        tvZaman.setText(userShare.get(position).getUser_share_time());
        tvPaylasimYazisi.setText(userShare.get(position).getUser_share_content());
        tvBegeniSayisi.setText(""+userShare.get(position).getUser_share_like_count());

        Picasso.with(context).load(userShare.get(position).getUser_photo_url()).into(ivProfilResim);
        Picasso.with(context).load(userShare.get(position).getUser_share_photo_url()).into(ivPaylasimResmi);

        return view;
    }
}
