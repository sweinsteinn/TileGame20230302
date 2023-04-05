package gfx.utils;

import game.assets.Player;
import game.utils.GameHandler;
import game.utils.WorldGenerator;
import gfx.assets.WorldTile;

public class CameraHandler {
    public static CameraHandler cameraHandler = null;

    private static int xOffset, yOffset;

    private CameraHandler() {
        xOffset = 0;
        yOffset = 0;
    }

    public static CameraHandler getCameraHandler() {
        if(cameraHandler == null) {
            cameraHandler = new CameraHandler();
        }
        return cameraHandler;
    }

    public void centerOnEntity(Player player) {
        xOffset = player.getX() - GameHandler.SCREEN_WIDTH/2 + WorldTile.defaultWorldTileWidth/2;
        yOffset = player.getY() - GameHandler.SCREEN_HEIGHT/2 + WorldTile.defaultWorldTileHeight/2;

        checkBlankSpace();
    }

    public void checkBlankSpace(){
        if(xOffset < 0){
            xOffset = 0;
        }else if(xOffset > WorldGenerator.worldColumns * WorldTile.defaultWorldTileWidth - GameHandler.SCREEN_WIDTH){
            xOffset = WorldGenerator.worldColumns * WorldTile.defaultWorldTileWidth - GameHandler.SCREEN_WIDTH;
        }

        if(yOffset < 0){
            yOffset = 0;
        }else if(yOffset > WorldGenerator.worldRows * WorldTile.defaultWorldTileHeight - GameHandler.SCREEN_HEIGHT){
            yOffset = WorldGenerator.worldRows * WorldTile.defaultWorldTileHeight - GameHandler.SCREEN_HEIGHT;
        }
    }

    public static int getXOffset() {
        return xOffset;
    }

    public static int getYOffset() {
        return yOffset;
    }
}
