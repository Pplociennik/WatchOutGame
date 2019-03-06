package com.watchOut.game.main;

import java.util.Random;

public class Spawn {

    private Handler handler;
    private HUD hud;
    private Random r;

    private int scoreKeeper = 0;

    public Spawn(Handler handler, HUD hud) {
        this.handler = handler;
        this.hud = hud;
        this.r = new Random();
    }

    public void tick() {
        scoreKeeper++;

        if (scoreKeeper >= 250) {
            scoreKeeper = 0;
            hud.setLevel(hud.getLevel() + 1);

            switch (hud.getLevel()) {
                case 2:
                    handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
                    break;
                case 3:
                    handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
                    //handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
                    break;
                case 4:
                    handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
                    break;
            }
        }

    }

}
