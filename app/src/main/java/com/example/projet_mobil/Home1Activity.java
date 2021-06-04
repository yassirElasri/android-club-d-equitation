package com.example.projet_mobil;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Home1Activity extends AppCompatActivity {
    private static final String TAG = "Home1Activity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        int clientId = getIntent().getIntExtra(Login.EXTRA_CLIENTID, 0);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home1);
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET,
                "http://192.168.199.35/seance.php?id=" + clientId, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.i(TAG, response.toString());
                        List<Seance> seanses = new ArrayList<Seance>();
                        try {
                            JSONArray arraySeances = response.getJSONArray("Success");
                            for(int i=0; i<response.length(); i++){
                                JSONObject s = (JSONObject) arraySeances.get(i);
                                Seance seance = new Seance();
                                seance.setStartDate(s.getString("startTime"));
                                seance.setId(Integer.parseInt(s.getString("seanceId")));
                                seance.setDuration(Integer.parseInt(s.getString("durationMinute")));
                                seance.setIsDone(Integer.parseInt(s.getString("isDone")));
                                seanses.add(seance);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        Log.i(TAG,"seance 1" + seanses.get(0).getStartDate());

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i(TAG, error.toString());
            }
        });
        VolleySingleton.getInstance(getApplicationContext()).addToRequestQueue(request);
    }
}