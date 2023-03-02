package gfx.utils;

import gfx.assets.WorldTile;
import java.awt.image.BufferedImage;

public class ImageHandler {
    public static ImageHandler imageHandler = null;

    // actual pixel size of sprite on sheet
    private final int SPRITE_TILE_WIDTH = 64, SPRITE_TILE_HEIGHT = 64;

    private WorldTile[] worldTileList;

    private ImageHandler() {
        worldTileList = new WorldTile[1024];
        createWorldTiles();
    }

    public static ImageHandler getImageHandler() {
        if(imageHandler == null) {
            return new ImageHandler();
        }
        return imageHandler;
    }
    private void createWorldTiles() {
        BufferedImage primaryColorSheet = ImageLoader.loadImage("/primaryColorSheet.png");

        BufferedImage clear = primaryColorSheet.getSubimage(0, 0, SPRITE_TILE_WIDTH, SPRITE_TILE_HEIGHT);
        WorldTile clearTile = new WorldTile(clear, 0);
        setWorldTile(clearTile);

        BufferedImage white = primaryColorSheet.getSubimage(SPRITE_TILE_WIDTH, 0, SPRITE_TILE_WIDTH, SPRITE_TILE_HEIGHT);
        WorldTile whiteTile = new WorldTile(white, 1);
        setWorldTile(whiteTile);

        BufferedImage grey_0 = primaryColorSheet.getSubimage(0, SPRITE_TILE_HEIGHT, SPRITE_TILE_WIDTH, SPRITE_TILE_HEIGHT);
        WorldTile grey_0Tile = new WorldTile(grey_0, 3);
        setWorldTile(grey_0Tile);

        BufferedImage grey_1 = primaryColorSheet.getSubimage(SPRITE_TILE_WIDTH, SPRITE_TILE_HEIGHT, SPRITE_TILE_WIDTH, SPRITE_TILE_HEIGHT);
        WorldTile grey_1Tile = new WorldTile(grey_1, 4);
        setWorldTile(grey_1Tile);

        BufferedImage grey_2 = primaryColorSheet.getSubimage(SPRITE_TILE_WIDTH*2, SPRITE_TILE_HEIGHT, SPRITE_TILE_WIDTH, SPRITE_TILE_HEIGHT);
        WorldTile grey_2Tile = new WorldTile(grey_2, 5);
        setWorldTile(grey_2Tile);

        BufferedImage grey_3 = primaryColorSheet.getSubimage(SPRITE_TILE_WIDTH*3, SPRITE_TILE_HEIGHT, SPRITE_TILE_WIDTH, SPRITE_TILE_HEIGHT);
        WorldTile grey_3Tile = new WorldTile(grey_3, 6);
        setWorldTile(grey_3Tile);

        BufferedImage grey_4 = primaryColorSheet.getSubimage(SPRITE_TILE_WIDTH*4, SPRITE_TILE_HEIGHT, SPRITE_TILE_WIDTH, SPRITE_TILE_HEIGHT);
        WorldTile grey_4Tile = new WorldTile(grey_4, 7);
        setWorldTile(grey_4Tile);

        BufferedImage grey_5 = primaryColorSheet.getSubimage(SPRITE_TILE_WIDTH*5, SPRITE_TILE_HEIGHT, SPRITE_TILE_WIDTH, SPRITE_TILE_HEIGHT);
        WorldTile grey_5Tile = new WorldTile(grey_5, 8);
        setWorldTile(grey_5Tile);

        BufferedImage grey_6 = primaryColorSheet.getSubimage(SPRITE_TILE_WIDTH*6, SPRITE_TILE_HEIGHT, SPRITE_TILE_WIDTH, SPRITE_TILE_HEIGHT);
        WorldTile grey_6Tile = new WorldTile(grey_6, 9);
        setWorldTile(grey_6Tile);

        BufferedImage grey_7 = primaryColorSheet.getSubimage(SPRITE_TILE_WIDTH*7, SPRITE_TILE_HEIGHT, SPRITE_TILE_WIDTH, SPRITE_TILE_HEIGHT);
        WorldTile grey_7Tile = new WorldTile(grey_7, 10);
        setWorldTile(grey_7Tile);
    }

    private void setWorldTile(WorldTile tile) {
        worldTileList[tile.getID()] = tile;
    }
    public WorldTile getWorldTile(int id) {
        return worldTileList[id];
    }

    public int getSPRITE_TILE_WIDTH() {
        return SPRITE_TILE_WIDTH;
    }

    public int getSPRITE_TILE_HEIGHT() {
        return SPRITE_TILE_HEIGHT;
    }
}
