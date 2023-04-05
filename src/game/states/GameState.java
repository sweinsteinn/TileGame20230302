package game.states;

import java.awt.*;
import java.awt.event.KeyEvent;

import game.assets.World;
import game.assets.Player;
import game.utils.KeyManager;
import gfx.assets.WorldTile;
import gfx.utils.ImageHandler;

public class GameState extends State {

    World world;
    Player player;

    ImageHandler imageHandler;
    public GameState() {
        imageHandler = new ImageHandler();
        world = new World(128, 64);
        player = new Player(imageHandler.getWorldTile(5));
    }

    @Override
    public void tick() {
        player.tick();

        movePlayer();
    }

    public void movePlayer() {
        if(KeyManager.getKeyManager().keyJustPressed(KeyEvent.VK_W)) {
            if(!checkSolid((player.getY()-WorldTile.defaultWorldTileHeight)/WorldTile.defaultWorldTileHeight , player.getX()/WorldTile.defaultWorldTileWidth))
                player.adjustY(-WorldTile.defaultWorldTileHeight);
        }
        if(KeyManager.getKeyManager().keyJustPressed(KeyEvent.VK_A)) {
            if(!checkSolid(player.getRow(), (player.getX()-WorldTile.defaultWorldTileWidth)/WorldTile.defaultWorldTileWidth))
              player.adjustX(-WorldTile.defaultWorldTileWidth);
        }
        if(KeyManager.getKeyManager().keyJustPressed(KeyEvent.VK_S)) {
            if(!checkSolid((player.getY()+WorldTile.defaultWorldTileHeight)/WorldTile.defaultWorldTileHeight , player.getX()/WorldTile.defaultWorldTileWidth))
             player.adjustY(WorldTile.defaultWorldTileHeight);
        }
        if(KeyManager.getKeyManager().keyJustPressed(KeyEvent.VK_D)) {
            if(!checkSolid(player.getRow(), (player.getX()+WorldTile.defaultWorldTileWidth)/WorldTile.defaultWorldTileWidth))
              player.adjustX(WorldTile.defaultWorldTileWidth);
        }
    }

    public boolean checkSolid(int r, int c) {
        return world.getWorldTile(r, c).getSolid();
    }

    @Override
    public void render(Graphics g) {
        world.render(g);
        player.render(g);
    }
}
