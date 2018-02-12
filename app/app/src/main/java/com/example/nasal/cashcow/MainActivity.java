package com.example.nasal.cashcow;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int milk = 0;
    TextView milkText;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        milkText = (TextView)findViewById(R.id.milkCounter);
        milkText.setText(Integer.toString(milk));
        milkText.setKeyListener(null);
    }

    private class SwipeGestureListener extends GestureDetector.SimpleOnGestureListener {
        public boolean onFling(MotionEvent e1, MotionEvent e2, float v1, float v2) {
            if(e1.getY() > e2.getY()) {
                return true;
            } else {
                return false;
            }
        }

    }

    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getActionMasked();
        float x1 = 0, y1 = 0, x2 = 0, y2 = 0;
        switch(action) {
            case (MotionEvent.ACTION_DOWN):
                x1 = event.getX();
                y1 = event.getY();
                break;
            case (MotionEvent.ACTION_UP):
                x2 = event.getX();
                y2 = event.getY();
                break;
            default:
                return false;
        }

        if((y1 > y2) && (Math.abs(y2 - y1) > Math.abs(x2 - x1))) {
            milk++;
            milkText.setText(Integer.toString(milk));
            return true;
        } else {
            return false;
        }
    }
}
