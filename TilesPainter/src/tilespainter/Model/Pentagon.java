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
public class Pentagon extends GeometricalTile
{
    private Polygon _Pentagon;
    
    public Pentagon(Dimension _TileSize)
    {
        super(_TileSize);
        _Name = "Pentagon";
        _ID = 4;             
    }

    @Override
    public void DrawTile()
    {
        int[] xpoints = new int[5];
        int[] ypoints = new int[5];
        
        int radius = this._TileSize.height / 2;
        
        int x0 = this._TileSize.width/2;
        int y0 = this._TileSize.height/2;
    
        for(int i=0; i < 5; i++)
        {
            double v = i * (2 * Math.PI / 5);
            xpoints[i] = x0 + (int)Math.round(radius * Math.cos(v));
            ypoints[i] = y0 + (int)Math.round(radius * Math.sin(v));
        }
        
        _Pentagon = new Polygon(xpoints, ypoints, 5);
        _Graphics2D.draw(_Pentagon);
    }

    @Override
    public void PaintTile(Color _Color)
    {
        _Graphics2D.setPaint(_Color);
        _Graphics2D.fill(_Pentagon);
    }
    
    @Override
    public void PaintTile(String _Hex)
    {
        _Graphics2D.setPaint(Color.decode(_Hex));
        _Graphics2D.fill(_Pentagon);
    }
}
