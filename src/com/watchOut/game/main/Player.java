package com.watchOut.game.main;

import java.awt.*;
import java.util.Random;

public class Player extends GameObject {

    Handler handler;


    public Player(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 32, 32);
    }

    public void tick() {
        x += velocityX;
        y += velocityY;

        x = Game.clamp(x, 0, Game.WIDTH - 37);
        y = Game.clamp(y, 0, Game.HEIGHT - 64);

        handler.addObject(new Trail(x, y, ID.Trail, Color.white, 32, 32, 0.02f, handler));


        collision();
    }

    private void collision() {
        for (int i = 0; i < handler.objects.size(); i++) {
            GameObject tempObject = handler.objects.get(i);

            if (tempObject.getId() == ID.BasicEnemy || tempObject.getId() == ID.FastEnemy) {
                if (getBounds().intersects(tempObject.getBounds())) {
                    HUD.HEALTH -= 2;
                }
            }
        }
    }

    public void render(Graphics g) {

//        Graphics2D g2d = (Graphics2D) g;
//
//        g.setColor(Color.green);
//        g2d.draw(getBounds());

        g.setColor(Color.white);
        g.fillRect(x, y, 32, 32);
    }
}
