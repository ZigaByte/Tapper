package com.zigabyte.tapper.input;

import android.support.v4.view.MotionEventCompat;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

import com.zigabyte.tapper.MyCanvas;
import com.zigabyte.tapper.math.Vector2f;

import java.util.ArrayList;


public class Input implements OnTouchListener {

    public static ArrayList<Vector2f> inputs = new ArrayList<Vector2f>();

    @Override
    public boolean onTouch(View v, MotionEvent m) {

        int pointerCount = m.getPointerCount();

        /*for (int i = 0; i < pointerCount; i++) {*/
        int i = pointerCount - 1;
            int x = (int) (m.getX(i) * MyCanvas.scaleX);
            int y = (int) (m.getY(i) * MyCanvas.scaleY);
            int id = m.getPointerId(i);
            int action = m.getActionMasked();
            int actionIndex = m.getActionIndex();

            switch (action) {
                case MotionEvent.ACTION_DOWN:
                    inputs.add(new Vector2f(x, y));
                    break;
                case MotionEvent.ACTION_UP:
                    break;
                case MotionEvent.ACTION_POINTER_DOWN:
                    inputs.add(new Vector2f(x, y));
                    break;
                case MotionEvent.ACTION_POINTER_UP:
                    break;
                case MotionEvent.ACTION_MOVE:
                    break;
            }
        /*}*/
        return true;
    }

    /**
     * Return the first input and remove it from the list
     * */
    public static Vector2f getInput() {
        if (inputs.size() > 0) {
            Vector2f v = inputs.get(0);
            inputs.remove(0);
            return v;
        } else {
            return null;
        }
    }

}
