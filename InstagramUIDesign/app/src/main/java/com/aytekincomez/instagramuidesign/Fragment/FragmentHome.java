package com.aytekincomez.instagramuidesign.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.aytekincomez.instagramuidesign.Adapter.ListViewAdapter;
import com.aytekincomez.instagramuidesign.Model.UserShare;
import com.aytekincomez.instagramuidesign.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Map;

public class FragmentHome extends Fragment {
    ListView listViewHomeShare;
    ArrayList<UserShare> liste = new ArrayList<>();
    RequestQueue queue;

    private void init(){

        StringRequest request = new StringRequest(
                Request.Method.POST,
                "http://192.168.49.1/instagram/user_share.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            JSONArray jsonArray = jsonObject.getJSONArray("usershare");

                            for(int i=0; i<jsonArray.length(); i++){
                                JSONObject item = jsonArray.optJSONObject(i);
                                Log.d("ITEM",item.getString("userid"));

                                int user_share_id = Integer.parseInt(item.getString("user_share_id"));
                                int user_id = Integer.parseInt(item.getString("user_id"));
                                String user_photo_url = item.getString("user_photo_url");
                                int user_share_like_count = Integer.parseInt( item.getString("user_share_like_count"));
                                String user_share_content = item.getString("user_share_content");
                                String user_share_time = item.getString("user_share_time");
                                String user_share_photo_url = item.getString("user_share_photo_url");
                                String user_share_location_name = item.getString("user_share_location_name");

                                liste.add(new UserShare(
                                        user_share_id,
                                        user_id,
                                        user_photo_url,
                                        user_share_like_count,
                                        user_share_content,
                                        user_share_time,
                                        user_share_photo_url,
                                        user_share_location_name,
                                        "Aytekin Çömez"));

                            }
                            ListViewAdapter adapter = new ListViewAdapter(getContext(), liste );
                            listViewHomeShare.setAdapter(adapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return super.getParams();
            }
        };
        queue.add(request);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_layout_home, container, false);
        queue = Volley.newRequestQueue(getContext());
        init();
        listViewHomeShare = (ListView)view.findViewById(R.id.listViewHomeShare);
        
        return view;
    }
}
