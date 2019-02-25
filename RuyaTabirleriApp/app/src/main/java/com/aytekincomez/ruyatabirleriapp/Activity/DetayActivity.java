package com.aytekincomez.ruyatabirleriapp.Activity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.aytekincomez.ruyatabirleriapp.Database.DatabaseHelper;
import com.aytekincomez.ruyatabirleriapp.R;

import java.io.IOException;

public class DetayActivity extends AppCompatActivity {
    ImageView ivResim;
    TextView tvBaslik, tvAciklama;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detay);

        ivResim = (ImageView)findViewById(R.id.ivDetayResim);
        tvBaslik = (TextView)findViewById(R.id.tvDetayBaslik);
        tvAciklama = (TextView)findViewById(R.id.tvDetayAciklama);

        int id = getIntent().getIntExtra("id",1);

        SQLiteDatabase db;
        Cursor c;

        try {
            databaseHelper = new DatabaseHelper(getApplicationContext());
            databaseHelper.createDatabase();
            db = databaseHelper.getReadableDatabase();

            c = db.rawQuery("select * from Tabirler where id="+ id +" order by id desc", null);

            while (c.moveToNext()){
                tvBaslik.setText(c.getString(1));
                tvAciklama.setText(c.getString(2));

                int resimId = getResources().getIdentifier(
                        c.getString(3),
                        "drawable",
                        getPackageName()
                );
                ivResim.setImageResource(resimId);

            }
        }catch (IOException e){

        }

    }
}
