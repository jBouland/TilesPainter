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
public class Octogon extends GeometricalTile
{
    private Polygon _Octogon;

    public Octogon(Dimension _TileSize)
    {
        super(_TileSize);
        _Name = "Octogon";
        _ID = 6;
    }

    @Override
    public void DrawTile()
    {
        int[] xpoints = new int[8];
        int[] ypoints = new int[8];
        
        int radius = this._TileSize.height / 2;
        
        int x0 = this._TileSize.width/2;
        int y0 = this._TileSize.height/2;
    
        for(int i=0; i < 8; i++)
        {
            double v = i * (2 * Math.PI / 8);
            xpoints[i] = x0 + (int)Math.round(radius * Math.cos(v));
            ypoints[i] = y0 + (int)Math.round(radius * Math.sin(v));
        }
        
        _Octogon = new Polygon(xpoints, ypoints, 8);
        _Graphics2D.draw(_Octogon);
    }

    @Override
    public void PaintTile(Color _Color)
    {
        _Graphics2D.setPaint(_Color);
        _Graphics2D.fill(_Octogon);
    }
    
    @Override
    public void PaintTile(String _Hex)
    {
        _Graphics2D.setPaint(Color.decode(_Hex));
        _Graphics2D.fill(_Octogon);
    }
}
