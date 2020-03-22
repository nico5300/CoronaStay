package de.flatcorona;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class fertige_comics extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fertige_comics);
        generateList();
    }

    private void generateList(){
        JSONObject json = new JSONObject();
        try {
            json.put("type", "finished");
            json.put("api_key", global_variables.api_key);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        try {
            URL url = new URL(global_variables.adress + "/stories/");
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            http.setRequestMethod("GET");
            http.setDoOutput(true);
            byte[] out = json.toString().getBytes(StandardCharsets.UTF_8);
            int length = out.length;

            http.setFixedLengthStreamingMode(length);
            http.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            http.connect();
            try (OutputStream os = http.getOutputStream()) {
                os.write(out);
            }

            InputStream input = http.getInputStream();
            String output = "";
            int i = 0;
            while ((i = input.read()) != -1) {
                char c = (char) i;
                output += c;
            }
            //TODO: deserialize
        } catch (Exception e){

        }
    }

}
