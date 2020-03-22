package de.flatcorona;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.LabeledIntent;
import android.widget.Button;
import android.annotation.SuppressLint;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class main_page extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main_page);
        TextView WelcomeLabel = findViewById(R.id.main_page_welcome);
        WelcomeLabel.setText("Willkommen" + global_variables.strUserName);
    }

    public void main_page_create_comic(View view){
        Intent i = new Intent(getApplicationContext(), comic_erstellen.class);
        startActivity(i);
    }
/*
    public void main_page_create_comic(View view){
        Intent i = new Intent(getApplicationContext(), comic_erstellen.class);
        startActivity(i);
    }

    public void main_page_create_comic(View view){
        Intent i = new Intent(getApplicationContext(), comic_erstellen.class);
        startActivity(i);
    }
*/


}
