package com.example.scrollingshooter;

import android.content.Context;
import android.graphics.Point;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceView;


public class GameEngine extends SurfaceView implements Runnable,GameStarter {

    private Thread mThread = null;
    private long mFPS;
    private GameState mGameState;

    public GameEngine(Context context, Point size) {
        super(context);
        mGameState = new GameState(this, context);
    }

    @Override
    public void run() {

        while (mGameState.getThreadRunning()) {



            long frameStartTime = System.currentTimeMillis();



            long timeThisFrame = System.currentTimeMillis()
                    - frameStartTime;

            if (!mGameState.getPaused()) {

            // Update all the game objects here
            // in a new way
            }

            // Draw all the game objects here
            // in a new way
            // Measure the frames per second in the usual way

            if (timeThisFrame >= 1) {
                final int MILLIS_IN_SECOND = 1000;
                mFPS = MILLIS_IN_SECOND / timeThisFrame;
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {
    // Handle the player's input here
    // But in a new way
        return true;
    }
    public void stopThread() {
        mGameState.stopEverything();
        try {
            mThread.join();
        } catch (InterruptedException e) {
            Log.e("Exception","stopThread()"
                    + e.getMessage());
        }
    }
    public void startThread() {
        mGameState.startThread();
        mThread = new Thread(this);
        mThread.start();
    }

    @Override
    public void deSpawnReSpawn() {

    }
}
