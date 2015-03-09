/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tilespainter.Model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Joris
 */
public class TileSet {

    private Tile[] tileTab;
    private int size;

    public TileSet() throws IOException {

        final int width = 32;
        final int height = 32;
        final int rows = 16;
        final int cols = 16;
        size = rows * cols;
        tileTab = new Tile[size];

        BufferedImage bigImg = ImageIO.read(new File("tilesetMario.png"));
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                tileTab[(i * cols) + j] = new Tile(bigImg.getSubimage(
                        j * width,
                        i * height,
                        width,
                        height
                ));
            }
        }

    }

    public int getSize() {
        return size;
    }
    
    public BufferedImage getTile(int i){
        if(i<size){
            return tileTab[i].getPic();
        }else{
            return null;
        }
    }

}
