/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tilespainter.Model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

/**
 *
 * @author Luxio
 */
public abstract class GeometricalTile 
{
    protected String _Name;
    protected int _ID;
    protected BufferedImage _BufferedImage;
    protected Graphics2D _Graphics2D;
    protected Dimension _TileSize;   
    
    public GeometricalTile(Dimension _TileSize) 
    {        
        this._TileSize = _TileSize;       
        this._BufferedImage = new BufferedImage(_TileSize.height, _TileSize.width, BufferedImage.TYPE_INT_ARGB);
        this._Graphics2D = this._BufferedImage.createGraphics();
    }

    public BufferedImage getBufferedImage() 
    {
        return this._BufferedImage;
    }
    
    public void Rotate(int _Degree)
    {
        AffineTransform _AFTrans = new AffineTransform();
        _AFTrans.rotate(Math.toRadians(_Degree), _BufferedImage.getWidth() / 2, _BufferedImage.getHeight() / 2);

        AffineTransformOp _AFTransOP= new AffineTransformOp(_AFTrans, AffineTransformOp.TYPE_BILINEAR);
        _BufferedImage = _AFTransOP.filter(_BufferedImage, null);
    }
    
    public abstract void DrawTile();
    public abstract void PaintTile(Color _Color);
    public abstract void PaintTile(String _Hex);
}
