package com.mmali.recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    ImageView mainImageView;
    TextView title,description;
    int myImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mainImageView=findViewById(R.id.mainImageView);
        title=findViewById(R.id.title);
        description=findViewById(R.id.description);
        myImage=getIntent().getIntExtra("myImage",1);

        title.setText(getIntent().getStringExtra("data1"));
        description.setText(getIntent().getStringExtra("data2"));
        mainImageView.setImageResource(myImage);
    }
}