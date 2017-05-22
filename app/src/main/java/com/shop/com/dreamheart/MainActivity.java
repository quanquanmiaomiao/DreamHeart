package com.shop.com.dreamheart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.shop.com.dreamheart.view.HeartView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new HeartView(this));
    }
}
