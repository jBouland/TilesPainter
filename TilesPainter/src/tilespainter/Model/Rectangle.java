/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tilespainter.Model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Paint;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

/**
 *
 * @author Luxio Crimson
 */
public class Rectangle extends GeometricalTile
{
    private Rectangle2D.Float _Rectangle;
    
    public Rectangle(Dimension _TileSize)
    {    
        super(_TileSize);
        _Name = "Rectangle";
        _ID = 1;               
    }

    @Override
    public void DrawTile()
    {
        _Rectangle = new Rectangle2D.Float(0.0f, 0.0f, (float)_TileSize.width, (float)_TileSize.height);
        _Graphics2D.draw(_Rectangle);       
        
    }

    @Override
    public void PaintTile(Color _Color)
    {
        _Graphics2D.setPaint(_Color);
        _Graphics2D.fill(_Rectangle);
    }
    
    @Override
    public void PaintTile(String _Hex)
    {
        _Graphics2D.setPaint(Color.decode(_Hex));
        _Graphics2D.fill(_Rectangle);
    }    
}
