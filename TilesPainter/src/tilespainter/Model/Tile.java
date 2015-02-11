/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tilespainter.Model;

import java.awt.image.BufferedImage;

/**
 *
 * @author Joris
 */
public class Tile {
   private BufferedImage pic;
   private int width;
   private int height;

    public Tile(BufferedImage pic) {
        this.pic = pic;
        width = 32;
        height = 32;
    }

    public BufferedImage getPic() {
        return pic;
    }
   
   
}
