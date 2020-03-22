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

            try {
                URL url = new URL(global_variables.adress + "/register/");
                HttpURLConnection http = (HttpURLConnection) url.openConnection();
                http.setRequestMethod("POST");
                http.setDoOutput(true);
                byte[] out = json.toString().getBytes(StandardCharsets.UTF_8);
                int length = out.length;

                http.setFixedLengthStreamingMode(length);
                http.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
                http.connect();
                try(OutputStream os = http.getOutputStream()) {
                    os.write(out);
                }

                InputStream input = http.getInputStream();
                String apiKey = "";
                int i = 0;
                while ((i = input.read()) != -1){
                    char c = (char) i;
                    apiKey += c;
                }
                //TODO: deserialize
                global_variables.api_key = apiKey;

            } catch (Exception e) {
                e.printStackTrace();
            }
            Intent i = new Intent(getApplicationContext(), main_page.class);
            startActivity(i);
        }
    }

}
