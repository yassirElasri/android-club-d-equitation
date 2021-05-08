package com.example.projet_mobil;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(Login.class.getSimpleName(), "we are in onCreate: ");
    }

    @Override
    protected void onStart() {
        super.onStart();        Log.d(Login.class.getSimpleName(), "we are in onStart: ");
    }

    @Override
    protected void onStop() {
        super.onStop();  Log.d(Login.class.getSimpleName(), "we are in onStop: ");
    }

    @Override
    protected void onPause() {
        super.onPause();  Log.d(Login.class.getSimpleName(), "we are in onPause: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();  Log.d(Login.class.getSimpleName(), "we are in onRestart: ");
    }

    public void login(View view) {
    }

    @Override
    protected void onResume() {
        super.onResume();  Log.d(Login.class.getSimpleName(), "we are in onResume: ");


    }

    public Login() {
        super();

    }
    public void loginn(View view) {
        EditText Login=findViewById(R.id.login);
        EditText Pass=findViewById(R.id.passwd);

        Log.d(Login.class.getSimpleName(), "we are in Loginn: ");
        JsonObjectRequest req = new JsonObjectRequest(Request.Method.GET,
                    "http://192.168.43.35/equitationMaroc(projetMobile).php?login="+Login+"&passwd="+Pass, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            if (response.has("error"))
                            {
                                Toast.makeText(Login.this,response.getString("error"),
                                        Toast.LENGTH_LONG).show();
                            }else {
                                Log.d(Login.class.getSimpleName(), "u are logged");
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        Log.d(Login.class.getSimpleName(),response.toString());
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(Login.class.getSimpleName(),"ERREUR"+error.getMessage());
            }
        } );
        VolleySingleton.getInstance(getApplicationContext()).addToRequestQueue(req);
    }
}