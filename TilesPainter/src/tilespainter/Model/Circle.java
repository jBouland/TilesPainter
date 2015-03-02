/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tilespainter.Model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author Luxio Crimson
 */
public class Circle extends GeometricalTile
{
    private Ellipse2D.Float _Circle;

    public Circle(Dimension _TileSize)
    {
        super(_TileSize);
        this._Name = "Circle";
        this._ID = 3;            
    }    

    @Override
    public void DrawTile()
    {
        _Circle = new Ellipse2D.Float(0.0f, 0.0f, (float)_TileSize.width, (float)_TileSize.height);
        _Graphics2D.draw(_Circle);       
        
    }   

    @Override
    public void PaintTile(Color _Color)
    {
        _Graphics2D.setPaint(_Color);
        _Graphics2D.fill(_Circle);
    }

    @Override
    public void PaintTile(String _Hex)
    {
        _Graphics2D.setPaint(Color.decode(_Hex));
        _Graphics2D.fill(_Circle);
    }
}
