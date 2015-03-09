/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tilespainter.Model;

/**
 *
 * @author Joris
 */
public class TilesGrid {

    private int[][] tilesTab;
    private int height, width;

    public TilesGrid(int height, int width) {
        this.height = height;
        this.width = width;
        tilesTab = new int[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                tilesTab[i][j] = -1;
            }
        }
    }

    public void setTiles(int id, int i, int j) {
        if (i < height && j < width && i >= 0 && j >= 0) {
            tilesTab[i][j] = id;
        }
    }

    public int getTile(int i, int j) {
        if (i < height && j < width && i >= 0 && j >= 0) {
            return tilesTab[i][j];
        }else{
            return -1;
        }
    }
    

}
