package game.assets;

import game.utils.KeyManager;
import gfx.assets.WorldTile;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Player {
    WorldTile tile;
    int x, y;

    public Player(WorldTile tile) {
        this.tile = tile;

        this.x = 0;
        this.y = 0;
    }

    public void tick() {
        KeyManager.getKeyManager().tick();
        getInput();
    }

    public void render(Graphics g) {
        tile.render(g, x, y);
    }

    public void getInput() {

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getRow() {
        return y/WorldTile.defaultWorldTileHeight;
    }

    public int getCol() {
        return x/WorldTile.defaultWorldTileWidth;
    }

    public void adjustX(int num) {
        x += num;
    }

    public void adjustY(int num) {
        y += num;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
