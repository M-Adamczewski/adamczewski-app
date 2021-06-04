package com.AdamczewskiIndustries;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private ImageView imageView;
    private Button button;
    private Button newActivity;
    private static String url1 = "https://i.redd.it/56ca6yr8wz231.jpg";
    private static String url2 = "https://icdn.2cda.pl/obr/oryginalne/d89616588c01fa2c4c694f387d9beec8.jpg";
    private static String url3 = "https://external-preview.redd.it/GgnBXqPVz-7au9ifWiOSLctehJOSLET7YnzUQyFuk8g.gif?width=640&format=mp4&s=22200c0eca75fddd007b7341e1fef2b59d4cc69f";
    private static final String[] urls = {url1, url2, url3};
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d( "Log on Create",  "CREATE");

        textView = (TextView) findViewById(R.id.textView);
        button = (Button) findViewById(R.id.button);
        imageView = (ImageView) findViewById(R.id.imageView);
        newActivity = (Button) findViewById(R.id.newActivity);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("onClick", "" + v.getId());
                String img = randomUrl();
                Glide
                        .with(getApplicationContext())
                        .load(img)
                        .into(imageView);
                textView.setText(img);
            }
        });
        newActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("onClick", "" + v.getId());
                Intent intent = new Intent(getApplicationContext(), ListActivity.class);
                startActivity(intent);
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d( "Log on Resume",  "RESUME");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d( "Log On Stop",  "STOP");
    }



    protected String randomUrl() {
        Random random = new Random();
        int limit = 3;
        int int_random = random.nextInt(limit);
        return urls[int_random];
    }
}