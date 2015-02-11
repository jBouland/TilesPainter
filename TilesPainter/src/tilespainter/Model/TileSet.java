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

    Tile[] tileTab;

    public TileSet() throws IOException {

        final int width = 32;
        final int height = 32;
        final int rows = 16;
        final int cols = 16;
        tileTab = new Tile[rows * cols];

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

}
