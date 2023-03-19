package com.example.pr_6;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private BlankFragment blank = new BlankFragment();
    private BlankFragment2 blank2 = new BlankFragment2();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}
