package com.example.joginderpal.edittextanimation;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by joginderpal on 12-05-2017.
 */
public class secondActivity extends AppCompatActivity {

    TextView tx;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        tx= (TextView) findViewById(R.id.text);
        tx.setText(getIntent().getExtras().getString("username"));
    }
}
