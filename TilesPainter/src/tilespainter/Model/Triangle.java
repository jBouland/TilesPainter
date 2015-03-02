/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tilespainter.Model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Polygon;

/**
 *
 * @author Luxio Crimson
 */
public class Triangle extends GeometricalTile
{
    private Polygon _Triangle;
    
    public Triangle(Dimension _TileSize)
    {
        super(_TileSize);
        _Name = "Triangle";
        _ID = 2;                
    }
    
    @Override
    public void DrawTile()
    {
        int[] xpoints = {this._TileSize.width / 2, 0, this._TileSize.width};
        int[] ypoints = {0, this._TileSize.height, this._TileSize.height};
        _Triangle = new Polygon(xpoints, ypoints, 3);
        _Graphics2D.draw(_Triangle);     
    }

    @Override
    public void PaintTile(Color _Color)
    {
        _Graphics2D.setPaint(_Color);
        _Graphics2D.fill(_Triangle);        
    }

    @Override
    public void PaintTile(String _Hex)
    {
        _Graphics2D.setPaint(Color.decode(_Hex));
        _Graphics2D.fill(_Triangle);   
    }  
}
