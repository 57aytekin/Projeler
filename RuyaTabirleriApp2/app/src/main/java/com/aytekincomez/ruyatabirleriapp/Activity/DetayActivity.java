package com.aytekincomez.ruyatabirleriapp.Activity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.aytekincomez.ruyatabirleriapp.Database.DatabaseHelper;
import com.aytekincomez.ruyatabirleriapp.Model.Tabir;
import com.aytekincomez.ruyatabirleriapp.R;
import com.squareup.picasso.Picasso;

import java.io.IOException;

public class DetayActivity extends AppCompatActivity {
    ImageView ivResim;
    TextView tvBaslik, tvIcerik;
    Button btnSil;
    DatabaseHelper databaseHelper;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detay);

        Tabir tabir = (Tabir) getIntent().getSerializableExtra("model");

        tvBaslik = findViewById(R.id.tvDetayBaslik);
        tvIcerik = findViewById(R.id.tvDetayIcerik);
        ivResim = findViewById(R.id.ivDetayResim);
        btnSil = findViewById(R.id.btnDetaySil);
        final int id = tabir.getId();

        try {
            databaseHelper = new DatabaseHelper(getApplicationContext());
            db = databaseHelper.getReadableDatabase();
        } catch (IOException e) {
            e.printStackTrace();
        }

        tvBaslik.setText(tabir.getBaslik());
        tvIcerik.setText(tabir.getIcerik());
        Picasso.with(getApplicationContext()).load(tabir.getResim_url()).into(ivResim);
        btnSil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.execSQL("delete from Tabirler where id="+id);
                finish();
            }
        });
    }
}
