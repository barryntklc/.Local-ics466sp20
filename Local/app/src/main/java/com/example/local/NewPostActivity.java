package com.example.local;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class NewPostActivity extends AppCompatActivity {

    public static final String POST_REPLY =
            "com.example.android.NewPostActivity.POST_REPLY";

    private EditText post_reply;
    private Toolbar this_toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_post);

//        this_toolbar = findViewById(R.id.include);

//        this_toolbar.findViewById(this.this_toolbar.id.options_button);
        this_toolbar = findViewById(R.id.toolbar);
        ImageButton menubtn = (ImageButton) this_toolbar.getChildAt(0);
        menubtn.setImageResource(R.drawable.ic_arrow_back_button);

        TextView textvw = (TextView) this_toolbar.getChildAt(1);
        textvw.setText("New Post");

        ImageButton optbtn = (ImageButton) this_toolbar.getChildAt(2);
        optbtn.setVisibility(View.INVISIBLE);
    }

    public void optionsButtonClicked(View view) {
        Log.i("NewPost-Options", "Options button clicked!");
    }

    public void menuButtonClicked(View view) {
        Log.i("NewPost-Menu", "Menu button clicked!");
        finish();
    }

    public void returnReply(View view) {
        post_reply = findViewById(R.id.post_text);
        String reply = post_reply.getText().toString();
        if (!reply.trim().equals("")) {
            Intent replyIntent = new Intent();
            replyIntent.putExtra(POST_REPLY, reply.trim());
            setResult(RESULT_OK, replyIntent);
            finish();
        } else {
            Toast.makeText(this, "You cannot submit an empty post!", Toast.LENGTH_SHORT).show();
        }
    }
}
