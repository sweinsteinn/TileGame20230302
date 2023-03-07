package game.utils;

public class WorldGenerator {

    private static int worldRows, worldColumns;
    private final long TIME_STAMP = System.nanoTime() % 1000000;
    private final String WORLD_FILE_NAME = "thisIsMyFileName_" + TIME_STAMP + ".txt";
    private final String WORLD_DIRECTORY = "res\\worlds\\";
    private final String WORLD_FULL_DIRECTORY_NAME = WORLD_DIRECTORY + WORLD_FILE_NAME;
    private int[][] worldMap2DArr;

    public WorldGenerator(int worldRows, int worldColumns) {
        this.worldRows = worldRows;
        this.worldColumns = worldColumns;

        worldMap2DArr = new int[worldRows][worldColumns];

        setWater();



        FileGenerator.getFileGenerator().createFile(WORLD_FULL_DIRECTORY_NAME, FileGenerator.getFileGenerator().intArr2DToString(worldMap2DArr));

    }

    private void setWater() {
        for(int r = 0; r < worldMap2DArr.length; r++) {
            for(int c = 0; c < worldMap2DArr[r].length; c++) {
                worldMap2DArr[r][c] = 9;
            }
        }
    }

    public String getWORLD_FULL_DIRECTORY_NAME() {
        return WORLD_FULL_DIRECTORY_NAME;
    }

}