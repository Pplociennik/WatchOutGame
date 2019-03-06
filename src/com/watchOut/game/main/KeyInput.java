package com.watchOut.game.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInput extends KeyAdapter implements KeyListener {

    private Handler handler;

    public KeyInput(Handler handler) {
        this.handler = handler;
    }


    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        System.out.println(key);

        for(int i = 0; i < handler.objects.size(); i++) {
           GameObject tempObject = handler.objects.get(i);

           if(tempObject.getId() == ID.Player) {

               switch (key) {
                   case KeyEvent.VK_W:
                       tempObject.setVelocityY(-5);
                       break;
                   case KeyEvent.VK_S:
                       tempObject.setVelocityY(5);
                       break;
                   case KeyEvent.VK_A:
                       tempObject.setVelocityX(-5);
                       break;
                   case KeyEvent.VK_D:
                       tempObject.setVelocityX(5);
                       break;
               }
           }

            else if(tempObject.getId() == ID.Player2) {

                switch (key) {
                    case KeyEvent.VK_UP:
                        tempObject.setVelocityY(-5);
                        break;
                    case KeyEvent.VK_DOWN:
                        tempObject.setVelocityY(5);
                        break;
                    case KeyEvent.VK_LEFT:
                        tempObject.setVelocityX(-5);
                        break;
                    case KeyEvent.VK_RIGHT:
                        tempObject.setVelocityX(5);
                        break;
                }
            }

            else if (key == KeyEvent.VK_ESCAPE) {
                System.exit(1);
           }
           }
        }


    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        System.out.println("STOP: " + key);

        for(int i = 0; i < handler.objects.size(); i++) {
            GameObject tempObject = handler.objects.get(i);

            if(tempObject.getId() == ID.Player) {

                switch (key) {
                    case KeyEvent.VK_W:
                        tempObject.setVelocityY(0);
                        break;
                    case KeyEvent.VK_S:
                        tempObject.setVelocityY(0);
                        break;
                    case KeyEvent.VK_A:
                        tempObject.setVelocityX(0);
                        break;
                    case KeyEvent.VK_D:
                        tempObject.setVelocityX(0);
                        break;
                }
            }

            else if(tempObject.getId() == ID.Player2) {

                switch (key) {
                    case KeyEvent.VK_UP:
                        tempObject.setVelocityY(0);
                        break;
                    case KeyEvent.VK_DOWN:
                        tempObject.setVelocityY(0);
                        break;
                    case KeyEvent.VK_LEFT:
                        tempObject.setVelocityX(0);
                        break;
                    case KeyEvent.VK_RIGHT:
                        tempObject.setVelocityX(0);
                        break;
                }
            }
        }
    }
}
