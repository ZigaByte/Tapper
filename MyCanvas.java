package com.zigabyte.tapper;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Display;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.zigabyte.tapper.input.Input;
import com.zigabyte.tapper.math.Vector2f;
import com.zigabyte.tapper.resources.Colors;
import com.zigabyte.tapper.resources.Images;


public class MyCanvas extends SurfaceView implements Runnable  {

    public static final Vector2f SIZE = new Vector2f(960,1600);

    private SurfaceHolder ourHolder;
    private Thread thread;
    public boolean running = false;

    public static MainActivity context;
    public static MyCanvas canvas;

    public static int screenWidth, screentHeight;
    public static float scaleX;
    public static float scaleY;

    private Input input;
    private Game game;

    public MyCanvas(Context context) {
        super(context);
        this.context = (MainActivity) context;
        init();
        start();
    }

    public MyCanvas(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = (MainActivity) context;
        init();
        start();
    }

    public MyCanvas(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.context = (MainActivity) context;
        init();
        start();
    }

    @SuppressWarnings("deprecation")
    private void init() {
        canvas = this;
        ourHolder = getHolder();
        Images.init(context);

        input = new Input();
        setOnTouchListener(input);

        // scaling
        Display display = context.getWindowManager().getDefaultDisplay();
        screenWidth = display.getWidth();
        screentHeight = display.getHeight();
        scaleX = (float) 960 / (float) screenWidth;
        scaleY = (float) 1600 / (float) screentHeight;
        // scaleX = scaleY;
        Log.e("Scales ", "x : " + scaleX + " | y : " + scaleY + " | " + screenWidth + "  " + screentHeight);

        game = new Game(context);

        Typeface myTypeface = Typeface.createFromAsset(context.getAssets(), "roboto.ttf");
        game.textPaint = new Paint();
        game.textPaint.setTypeface(myTypeface);
        game.textPaint.setTextAlign(Paint.Align.CENTER);
    }

    public void start() {
        if (running) return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public void stop() {
        running = false;

        while (true) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            break;
        }
    }

    @SuppressWarnings("static-access")
    @Override
    public void run() {
        long lastTime = System.nanoTime();
        long timer = System.currentTimeMillis();
        final double ns = 1000000000.0 / 60.0;
        double delta = 0;
        int frames = 0;
        int updates = 0;
        while (running) {
            long now = System.nanoTime();

            delta += (now - lastTime) / ns;

            try {
                thread.sleep(2);
                thread.yield();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (!ourHolder.getSurface().isValid()) continue;

            Canvas canvas = ourHolder.lockCanvas();

            if (canvas != null) {
                canvas.drawRGB(0, 0, 0);

                lastTime = now;
                while (delta >= 1) {
                    updates++;
                    delta--;
                    update();
                }
                render(canvas);
                frames++;
                if (System.currentTimeMillis() - timer > 1000) {
                    //Log.e("Running ", "fps: " + frames + "| ups:" + updates);
                    timer += 1000;
                    updates = 0;
                    frames = 0;
                }

                ourHolder.unlockCanvasAndPost(canvas);
            }
        }
    }

    private void update() {
        game.update();
    }

    private void render(Canvas canvas) {
        //BDC3C7, text.setColor(0xffecf0f1);
        // D4D9CC
        int color = Colors.DARK;
        canvas.drawARGB(0xff, (color & 0xff0000) >> 16, (color & 0xff00) >> 8, color & 0xff);
        canvas.scale(1 / scaleX, 1 / scaleY);

        game.render(canvas);
    }

}
