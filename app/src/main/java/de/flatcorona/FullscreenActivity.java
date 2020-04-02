package de.flatcorona;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class FullscreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_fullscreen);
    }

    public void full_activity_start(View view){
        EditText username = findViewById(R.id.activity_fullscreen_username);
        global_variables.strUserName = username.getText().toString();
        System.out.println(global_variables.strUserName);
        if (global_variables.strUserName .equals("")){
            Toast noInputToast = Toast.makeText(getApplicationContext(), "Bitte gebe einen Namen ein", Toast.LENGTH_SHORT); // Test ob name schon vergeben
            noInputToast.show();
        }
        else {

            JSONObject json = new JSONObject();
            try {
                json.put("username", global_variables.strUserName);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            JsonObjectRequest req = new JsonObjectRequest(Request.Method.POST, global_variables.adress + "/register/", json,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                global_variables.api_key = (String)response.get("api_key");
                                startActivity(new Intent(getApplicationContext(), main_page.class));
                            } catch (JSONException e) {}
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(getApplicationContext(), "Unable to get API key", Toast.LENGTH_SHORT).show();
                        }
                    });
            Networking.getInstance(this).addRequest(req);
        }
    }

}
