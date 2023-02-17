package gfx.utils;

import gfx.assets.WorldTile;
import java.awt.image.BufferedImage;

public class ImageHandler {

    // actual pixel size of sprite on sheet
    private final int SPRITE_TILE_WIDTH = 64;, SPRITE_TILE_HEIGHT = 64;

    private WorldTile[] worldTileList;

    public ImageHandler() {
        worldTileList = new WorldTile[1024];
        createWorldTiles();
    }

    private void createWorldTiles() {
        BufferedImage primaryColorSheet = ImageLoader.loadImage("/primaryColorSheet.png");

        BufferedImage white = primaryColorSheet.getSubimage(SPRITE_TILE_WIDTH, 0, SPRITE_TILE_WIDTH, SPRITE_TILE_HEIGHT);
        WorldTile whiteTile = new WorldTile(white, 1);
        setWorldTile(whiteTile);
        
    }

    private void setWorldTile(WorldTile tile) {
        worldTileList[tile.getID()] = tile;
    }

}
