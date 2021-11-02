package com.sprint.gina.javaguifuns1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // everything we do with views in XML can be done with Java OOP at runtime
        // imagine some layouts are dynamic (arrangement, content, etc. is determined at runtime,
        // not compile time)

        // 1. we are going to recreate the 2x2 grid of buttons that fill the available screen space
        // WITH NO XML
        // let's subclass ConstraintLayout to practice MVC design
        // View: XML (now custom ConstraintLayout)
        // Controller: MainActivity
        MyConstraintLayout layout = new MyConstraintLayout(this);
        // 2. later... as a challenge task: set up a NxN grid of buttons where N is entered by the user

//        setContentView(R.layout.activity_main);
        setContentView(layout);
    }
}