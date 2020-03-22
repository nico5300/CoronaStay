package de.flatcorona;

import android.app.Activity;
import android.content.Intent;
import android.widget.Button;
import android.annotation.SuppressLint;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;

public class main_page extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main_page);
    }

    public void main_page_create_comic(View view){
        setContentView(R.layout.comic_erstellen);
    }


}
