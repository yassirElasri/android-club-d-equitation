package com.example.projet_mobil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
    public static String ipAdresse = "192.168.199.35";

    public static final String EXTRA_CLIENTID = "extraClientid";
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
       String login1;String Pass1;


        Log.d(Login.class.getSimpleName(), "we are in Loginn: ");
        JsonObjectRequest req = new JsonObjectRequest(Request.Method.GET,
                    "http://" + ipAdresse + "/equitationMaroc(projetMobile).php?login="+Login.getText()+"&passwd="+Pass.getText(), null,
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
                                int clientId = Integer.parseInt(response.getJSONObject("user").getString("clientID"));
                                Intent iHome = new Intent(getApplicationContext(), Home1Activity.class).putExtra(EXTRA_CLIENTID, clientId);
                                startActivity(iHome);
                                Log.d(Login.class.getSimpleName(),response.toString());
                                finish();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(Login.class.getSimpleName(),"ERREUR"+error);
            }
        } );
        VolleySingleton.getInstance(getApplicationContext()).addToRequestQueue(req);
    }
}