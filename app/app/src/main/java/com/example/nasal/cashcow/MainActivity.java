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

    float x1, x2, y1, y2;

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
        switch(action) {
            case (MotionEvent.ACTION_DOWN):
                x1 = event.getX();
                y1 = event.getY();
                break;
            case (MotionEvent.ACTION_UP):
                x2 = event.getX();
                y2 = event.getY();

                float deltax = x1 - x2;
                float deltay = y1 - y2;

                if(deltay < 0 && Math.abs(deltay) > Math.abs(deltax)) {
                    milk++;
                    milkText.setText(Integer.toString(milk));
                }
                break;
        }
        return true;
    }
}
