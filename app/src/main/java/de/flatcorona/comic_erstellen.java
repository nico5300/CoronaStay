package de.flatcorona;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class comic_erstellen extends Activity {



    Spinner sItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.comic_erstellen);

        List<String> spinnerArray =  new ArrayList<String>();
        spinnerArray.add("Horror");
        spinnerArray.add("Fantasy");
        spinnerArray.add("Comedy");
        spinnerArray.add("Andere");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, spinnerArray);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sItems = (Spinner) findViewById(R.id.comic_erstellen_category);
        sItems.setAdapter(adapter);

    }

    public void create_Dataset(View view){

        EditText comic_title = findViewById(R.id.comic_erstellen_comic_title);
        Spinner category = findViewById(R.id.comic_erstellen_category);

        String selectedCategory = sItems.getSelectedItem().toString();
        if (selectedCategory.equals("what ever the option was")) {
        }

    }



}
