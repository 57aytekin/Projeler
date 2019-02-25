package com.aytekincomez.recyclerview_staggeredgridview.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.aytekincomez.recyclerview_staggeredgridview.Adapter.Photo_Adapter;
import com.aytekincomez.recyclerview_staggeredgridview.Model.Photo;
import com.aytekincomez.recyclerview_staggeredgridview.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Photo_Adapter adapter;
    List<Photo> photos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        photos = new ArrayList<>();
        /*
        int id, String photoUrl, String photoTitle, String userPhotoUrl, String userName, String userDescription
         */
        photos.add(
                new Photo(1,"http://www.bilimgenc.tubitak.gov.tr/sites/default/files/adelie_pengueni.jpg","Penguen","https://mediacat.com/wp-content/uploads/2017/11/odullu-reklamlarin-ortak-ozelligi-00.jpg","username","açıklama")
        );
        photos.add(
                new Photo(1,"http://www.doyoucity.com/site_media/entradas/imgs/Regent_1933630b.jpg","Street","https://mediacat.com/wp-content/uploads/2017/11/odullu-reklamlarin-ortak-ozelligi-00.jpg","username","açıklama")
        );
        photos.add(
                new Photo(1,"https://s1.it.atcdn.net/wp-content/uploads/2014/09/Geneva-to-Vienna-by-train-3-of-42.jpg","Train","https://images.unsplash.com/photo-1544808728-35c5958efd93?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60","username","açıklama")
        );
        photos.add(
                new Photo(1,"https://cdnuploads.aa.com.tr/uploads/Contents/2019/01/12/thumbs_b_c_098f2fea4622f3899bf37458880aa26c.jpg","Taksi","https://images.unsplash.com/photo-1544842413-05944bc01da2?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60","username","açıklama")
        );

        recyclerView = findViewById(R.id.recyclerView);
        adapter = new Photo_Adapter(photos);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(adapter);
    }
}
