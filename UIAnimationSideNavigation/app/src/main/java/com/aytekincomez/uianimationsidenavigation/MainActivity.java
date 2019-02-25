package com.aytekincomez.uianimationsidenavigation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnMenu, exp, msg, so, st, ao;
    RelativeLayout maincontent;
    LinearLayout mainmenu;
    Animation fromTop, fromBottom;
    ImageView userPicBig;
    TextView user, country;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMenu = (Button)findViewById(R.id.btnMenu);

        exp = (Button)findViewById(R.id.exp);
        msg = (Button)findViewById(R.id.msg);
        so = (Button)findViewById(R.id.so);
        st = (Button)findViewById(R.id.st);
        ao = (Button)findViewById(R.id.ao);

        user = (TextView)findViewById(R.id.user);
        country = (TextView)findViewById(R.id.country);

        userPicBig = (ImageView)findViewById(R.id.userpicbig);

        fromBottom = AnimationUtils.loadAnimation(this, R.anim.frombotom);
        fromTop = AnimationUtils.loadAnimation(this, R.anim.fromtop);

        maincontent = (RelativeLayout) findViewById(R.id.maincontent);
        mainmenu = (LinearLayout) findViewById(R.id.mainmenu);

        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                maincontent.animate().translationX(0);
                mainmenu.animate().translationX(0);

                exp.startAnimation(fromBottom);
                msg.startAnimation(fromBottom);
                so.startAnimation(fromBottom);
                st.startAnimation(fromBottom);
                ao.startAnimation(fromBottom);

                user.startAnimation(fromTop);
                country.startAnimation(fromTop);
                userPicBig.startAnimation(fromTop);
            }
        });
        maincontent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                maincontent.animate().translationX(-300);
                mainmenu.animate().translationX(-300);
            }
        });
    }
}
