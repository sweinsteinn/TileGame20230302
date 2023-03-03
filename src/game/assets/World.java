package game.assets;

import game.utils.WorldGenerator;
import gfx.assets.WorldTile;
import gfx.utils.ImageHandler;

import java.awt.Graphics;

public class World {

    // tbd into singleton
    private ImageHandler imageHandler;

    private int worldRows, worldCols;

    private WorldGenerator worldGenerator;

    private int[][] worldTileArray = {{1, 1, 1, 1, 1},
                                      {1, 7, 1, 7, 1},
                                      {1, 1, 1, 1, 1},
                                      {1, 7, 1, 7, 1},
                                      {1, 1, 7, 1, 1},
                                      {1, 1, 1, 1, 1}};

    public World() {
        worldGenerator = new WorldGenerator(10, 10);
        imageHandler = new ImageHandler();
    }

    public void tick() {
    }

    public void render(Graphics g) {
        for(int r = 0; r <  worldTileArray.length; r++) {
            for(int c = 0; c < worldTileArray[r].length; c++) {
                getWorldTile(r, c).render(g, c * ImageHandler.getSPRITE_TILE_WIDTH(), r * ImageHandler.getSPRITE_TILE_HEIGHT());
            }
        }
    }

    public WorldTile getWorldTile(int r, int c) {
        WorldTile tile = imageHandler.getWorldTile(worldTileArray[r][c]);
        if(tile == null) {
            return imageHandler.getWorldTile(1);
        }
        return tile;
    }

}
