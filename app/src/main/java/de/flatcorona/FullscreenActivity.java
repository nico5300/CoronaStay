package de.flatcorona;

import android.annotation.SuppressLint;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

import java.io.Console;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class FullscreenActivity extends Activity {



    public void full_activity_start(View view){
        EditText username = findViewById(R.id.activity_fullscreen_username);
        global_variables.strUserName = username.getText().toString();
        System.out.println(global_variables.strUserName);
        setContentView(R.layout.comic_erstellen);

    }

}
