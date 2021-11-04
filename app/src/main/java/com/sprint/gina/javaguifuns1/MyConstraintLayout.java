package com.sprint.gina.javaguifuns1;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

public class MyConstraintLayout extends ConstraintLayout {
    public MyConstraintLayout(@NonNull Context context) {
        super(context);
        // first, set up some attributes and parameters for our constraintlayout
        this.setId(View.generateViewId());
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        setLayoutParams(layoutParams);
        setBackgroundColor(getResources().getColor(R.color.purple_200));

        // next, start setting up child views and their constraints
        // for the constraints... there are 2 main ways to define them
        // 1. ConstraintLayout.LayoutParams objects and setting values like
        // bottomToBottomOf directly
        // 2. use the ConstraintSet convenience class for setting these values
        // pick one approach, don't mix the two (undefined behavior)
        // we will 2 because it is the more preferred approach

        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(this); // initialize the constraint set to our constraint layout
        // e.g. say this is the parent!!

        // set up the child views and the constraints
        hardcoded2by2Grid(context, constraintSet);
        // TODO: try demo #2 specified in MainActivity

        constraintSet.applyTo(this);
    }

    // solution to demo #1
    void hardcoded2by2Grid(Context context, ConstraintSet constraintSet) {
        Button button00 = new Button(context);
        button00.setId(View.generateViewId());
        button00.setText("00");
        addView(button00);

        Button button01 = new Button(context);
        button01.setId(View.generateViewId());
        button01.setText("01");
        addView(button01);

        // add button00's constraints... need at least 1 horiz and 1 vert
        constraintSet.constrainWidth(button00.getId(), ConstraintSet.WRAP_CONTENT);
        constraintSet.constrainHeight(button00.getId(), ConstraintSet.WRAP_CONTENT);
        constraintSet.connect(button00.getId(), ConstraintSet.START,
                ConstraintSet.PARENT_ID, ConstraintSet.START);
        // android:constrainStartToStartOf="parent"
        constraintSet.connect(button00.getId(), ConstraintSet.END,
                button01.getId(), ConstraintSet.START);
        constraintSet.connect(button00.getId(), ConstraintSet.TOP,
                ConstraintSet.PARENT_ID, ConstraintSet.TOP);

        // add button01's constraints... need at least 1 horiz and 1 vert
        constraintSet.constrainWidth(button01.getId(), ConstraintSet.WRAP_CONTENT);
        constraintSet.constrainHeight(button01.getId(), ConstraintSet.WRAP_CONTENT);
        constraintSet.connect(button01.getId(), ConstraintSet.START,
                button00.getId(), ConstraintSet.END);
        constraintSet.connect(button01.getId(), ConstraintSet.END,
                ConstraintSet.PARENT_ID, ConstraintSet.END);
        constraintSet.connect(button01.getId(), ConstraintSet.TOP,
                button00.getId(), ConstraintSet.TOP);
        constraintSet.connect(button01.getId(), ConstraintSet.BOTTOM,
                button00.getId(), ConstraintSet.BOTTOM);

        // task: finish the 2x2 grid
    }
}
