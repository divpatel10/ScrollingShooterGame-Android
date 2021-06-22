package com.example.scrollingshooter;

import java.util.ArrayList;

class PhysicsEngine {
    // This signature and much more will
//change later in the project

        boolean update(long fps, ArrayList<GameObject> objects,
                GameState gs, SoundEngine se,
                ParticleSystem ps){
// Update all the GameObjects
            for (GameObject object : objects) {
                if (object.checkActive()) {
                    object.update(fps, objects.get(
                            Level.PLAYER_INDEX)
                            .getTransform());
                }
            }

        if(ps.mIsRunning){

            ps.update(fps);
        }
        return false;
    }
// Collision detection method will go here
}
