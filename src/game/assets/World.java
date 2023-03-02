package game.assets;

import game.utils.WorldGenerator;
import gfx.utils.ImageHandler;
import gfx.assets.WorldTile;

import java.awt.Graphics;

public class World {

    private int worldRows, worldCols;

    private WorldGenerator worldGenerator;

    private int[][] worldTileArray = {{1, 1, 1, 1, 1},
                                      {1, 7, 1, 7, 1},
                                      {1, 1, 1, 1, 1},
                                      {1, 7, 1, 7, 1},
                                      {1, 1, 7, 1, 1},
                                      {1, 1, 1, 1, 1}};

    private ImageHandler imageHandler;

    public World() {
        worldGenerator = new WorldGenerator(10, 10);
    }

    public void tick() {
    }

    public void render(Graphics g) {
        for(int r = 0; r <  worldTileArray.length; r++) {
            for(int c = 0; c < worldTileArray[r].length; c++) {
                getWorldTile(r, c).render(g, c*ImageHandler.getImageHandler().getSPRITE_TILE_WIDTH(), r*ImageHandler.getImageHandler().getSPRITE_TILE_HEIGHT());
            }
        }
    }

    public WorldTile getWorldTile(int r, int c) {
        WorldTile tile = ImageHandler.getImageHandler().getWorldTile(worldTileArray[r][c]);
        if(tile == null) {
            return ImageHandler.getImageHandler().getWorldTile(1);
        }
        return tile;
    }

}
