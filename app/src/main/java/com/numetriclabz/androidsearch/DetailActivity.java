package com.numetriclabz.androidsearch;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import static android.content.ContentValues.TAG;


/**
 * A fragment representing a single Failure detail screen.
 * This fragment is either contained in a {@link FailureListActivity}
 * in two-pane mode (on tablets) or a {@link FailureDetailActivity}
 * on handsets.
 */
public class DetailActivity extends AppCompatActivity {

    private String text;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        int itemPos  = intent.getIntExtra("itemPos",0);
        Log.d(TAG, "here: " + itemPos);
        setContentView(R.layout.activity_detail);

        text = MainActivity.getListFixes(itemPos);
        Log.d(TAG, "here: " + text);

        TextView myAwesomeTextView = (TextView)findViewById(R.id.failure_detail);

        myAwesomeTextView.setText(text);

    }
}