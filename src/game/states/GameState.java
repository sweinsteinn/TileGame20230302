package game.states;

import java.awt.*;

import game.assets.World;

public class GameState extends State {

    World world;
    public GameState() {
        world = new World(10, 10);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        world.render(g);
    }
}
