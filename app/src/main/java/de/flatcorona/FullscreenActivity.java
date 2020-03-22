package de.flatcorona;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

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
        Intent i = new Intent(getApplicationContext(), main_page.class);
        startActivity(i);
    }

}
