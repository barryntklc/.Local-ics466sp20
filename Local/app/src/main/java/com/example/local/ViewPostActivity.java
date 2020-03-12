package com.example.local;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class ViewPostActivity extends AppCompatActivity {

    private Toolbar this_toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_post);

        this_toolbar = findViewById(R.id.toolbar);
        ImageButton menubtn = (ImageButton) this_toolbar.findViewById(R.id.menu_button);
        menubtn.setImageResource(R.drawable.ic_arrow_back_button);

        TextView textvw = (TextView) this_toolbar.findViewById(R.id.toolbar_title);
        textvw.setText("Post by <username>");

//        ImageButton optbtn = (ImageButton) this_toolbar.findViewById(R.id.options_button);
//        optbtn.setVisibility(View.INVISIBLE);
    }

    public void optionsButtonClicked(View view) {
        //create menu
    }
}
