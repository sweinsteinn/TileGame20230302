package game.utils;

import gfx.assets.Display;
import java.awt.image.BufferStrategy;
import java.awt.Graphics;

public class GameHandler {

    private BufferStrategy bufferStrategy;
    private Graphics g;

    private Display display;

    public static final int SCREEN_WIDTH = 1200;
    public static final int SCREEN_HEIGHT = 800;
    private final String GAME_TITLE = "School Appropriate Game Title";

    public static void main(String[] args) {
        GameHandler game = new GameHandler();
        game.init();
    }

    private void init() {
        display = new Display(GAME_TITLE, SCREEN_HEIGHT, SCREEN_WIDTH);
        run();
    }

    private void tick() {

    }

    private void render() {
        bufferStrategy = display.getCanvas().getBufferStrategy();
        g = bufferStrategy.getDrawGraphics();
        g.clearRect(0,0,SCREEN_HEIGHT,SCREEN_WIDTH);


        bufferStrategy.show();
        g.dispose();
    }

    private void run() {
        int fps = 60;
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;

        while(true){
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;

            if(delta >= 1){
                tick();
                render();
                ticks++;
                delta--;
            }

            if(timer >= 1000000000){
                System.out.println("FPS: " + ticks);
                ticks = 0;
                timer = 0;
            }
        }
    }


}
