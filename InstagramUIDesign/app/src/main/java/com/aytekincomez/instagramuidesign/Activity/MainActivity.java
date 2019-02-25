package com.aytekincomez.instagramuidesign.Activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.aytekincomez.instagramuidesign.Fragment.FragmentFavories;
import com.aytekincomez.instagramuidesign.Fragment.FragmentHome;
import com.aytekincomez.instagramuidesign.Fragment.FragmentProfile;
import com.aytekincomez.instagramuidesign.Fragment.FragmentSearch;
import com.aytekincomez.instagramuidesign.Fragment.FragmentTakePhoto;
import com.aytekincomez.instagramuidesign.Helper.VolleyMultipartRequest;
import com.aytekincomez.instagramuidesign.Model.DataPartt;
import com.aytekincomez.instagramuidesign.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView ivHome, ivSearch, ivTakePhoto, ivFavories, ivProfile;
    int tabIndex = 0;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == RESULT_OK && data != null) {

            //getting the image Uri
            Uri imageUri = data.getData();
            try {
                //getting bitmap object from uri
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri);

                //calling the method uploadBitmap to upload image
                uploadBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public byte[] getFileDataFromDrawable(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 80, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    private void uploadBitmap(final Bitmap bitmap) {

        //getting the tag from the edittext
        //final String tags = editTextTags.getText().toString().trim();

        //our custom volley request
        VolleyMultipartRequest volleyMultipartRequest = new VolleyMultipartRequest(
                Request.Method.POST,
                "",
                new Response.Listener<NetworkResponse>() {
                    @Override
                    public void onResponse(NetworkResponse response) {
                        try {
                            JSONObject obj = new JSONObject(new String(response.data));
                            Toast.makeText(getApplicationContext(), obj.getString("message"), Toast.LENGTH_SHORT).show();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }) {

            /*
             * If you want to add more parameters with the image
             * you can do it here
             * here we have only one parameter with the image
             * which is tags
             * */
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                //params.put("tags", tags);
                return params;
            }

            /*
             * Here we are passing image by renaming it with a unique name
             * */
            @Override
            protected Map<String, DataPartt> getByteData() {
                Map<String, DataPartt> params = new HashMap<>();
                long imagename = System.currentTimeMillis();
                params.put("pic", new DataPartt(imagename + ".png", getFileDataFromDrawable(bitmap)));
                return params;
            }
        };

        //adding the request to volley
        Volley.newRequestQueue(this).add(volleyMultipartRequest);
    }

    public void setDefaultImage(){
        ivHome.setImageResource(R.drawable.home_grey);
        ivSearch.setImageResource(R.drawable.icon_search_grey);
        ivTakePhoto.setImageResource(R.drawable.icon_camera_gray);
        ivFavories.setImageResource(R.drawable.heart_grey);
        ivProfile.setImageResource(R.drawable.icon_profile_grey);
    }

    public void changeFragment(int fragmentTabIndex){
        Fragment fragment = null;

        switch (fragmentTabIndex){
            case 0:
                fragment = new FragmentHome();
                break;
            case 1:
                fragment = new FragmentSearch();
                break;
            case 2:
                fragment = new FragmentTakePhoto();
                break;
            case 3:
                fragment = new FragmentFavories();
                break;
            case 4:
                fragment = new FragmentProfile();
                break;
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ivHome:
                tabIndex = 0;
                setDefaultImage();
                ivHome.setImageResource(R.drawable.icon_home_black);
                changeFragment(tabIndex);
                break;
            case R.id.ivSearch:
                tabIndex = 1;
                setDefaultImage();
                ivSearch.setImageResource(R.drawable.icon_search_black);
                changeFragment(tabIndex);
                break;
            case R.id.ivTakePhoto:
                tabIndex = 2;
                setDefaultImage();
                ivTakePhoto.setImageResource(R.drawable.icon_camera_black);

                Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, 100);

                break;
            case R.id.ivFavories:
                tabIndex = 3;
                setDefaultImage();
                ivFavories.setImageResource(R.drawable.icon_news_black);
                changeFragment(tabIndex);
                break;
            case R.id.ivProfile:
                tabIndex = 4;
                setDefaultImage();
                ivProfile.setImageResource(R.drawable.icon_profile_black);
                changeFragment(tabIndex);
                break;
        }


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        ivHome = (ImageView)findViewById(R.id.ivHome);
        ivSearch = (ImageView)findViewById(R.id.ivSearch);
        ivTakePhoto = (ImageView)findViewById(R.id.ivTakePhoto);
        ivFavories = (ImageView)findViewById(R.id.ivFavories);
        ivProfile = (ImageView)findViewById(R.id.ivProfile);
        setDefaultImage();


        ivHome.setOnClickListener(this);
        ivSearch.setOnClickListener(this);
        ivTakePhoto.setOnClickListener(this);
        ivFavories.setOnClickListener(this);
        ivProfile.setOnClickListener(this);
        ivHome.setImageResource(R.drawable.icon_home_black);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, new FragmentHome());
        fragmentTransaction.commit();
    }

}
