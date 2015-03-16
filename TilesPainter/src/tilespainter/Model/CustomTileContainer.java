/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tilespainter.Model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;

/**
 *
 * @author Luxio Crimson
 */
public class CustomTileContainer extends Observable
{
    private BufferedImage _BufferedImage;
    private GeometricalTile _GeoT;
    private Dimension _Dimension;
    private PanelContainer _PanelContainer;
    
    private class PanelContainer extends JPanel
    {
       public PanelContainer()
       {
           this.setPreferredSize(_Dimension);
           this.setVisible(true);
       }
        
       protected void paintComponent(Graphics g)
       {
           super.paintComponent(g);      
           g.drawImage(_BufferedImage, 0, 0, null);
           
           //System.out.println(_BufferedImage.getRGB(0,0));
       }        
    }
    
    public CustomTileContainer()
    {        
        _GeoT = new Rectangle(new Dimension(200,200));
        _GeoT.DrawTile();
        _GeoT.PaintTile(Color.WHITE);        
        _BufferedImage = _GeoT.getBufferedImage();  
        _Dimension = new Dimension(200,200);        
        _PanelContainer = new PanelContainer();
    }
    
    public void ChangeGeometricalTile(String _TileType, Dimension _Dimension, Color _Color)
    {
        this._Dimension = _Dimension;
        
        if(_TileType == "Rectangle")
        {
            _GeoT = new Rectangle(_Dimension);
        }
        else if(_TileType == "Triangle")
        {
            _GeoT = new Triangle(_Dimension);
        }
        else if(_TileType == "Circle")
        {
            _GeoT = new Circle(_Dimension);
        }
        else if(_TileType == "Pentagon")
        {
            _GeoT = new Pentagon(_Dimension);
        }
        else if(_TileType == "Hexagon")
        {
            _GeoT = new Hexagon(_Dimension);
        }
        else if(_TileType == "Octogon")
        {
            _GeoT = new Octogon(_Dimension);
        }
        
        _GeoT.DrawTile();
        _GeoT.PaintTile(_Color);        
        _BufferedImage = _GeoT.getBufferedImage();          
        _PanelContainer.repaint();
    }
    
    public void update(int _Degree, Color _Color)
    {
        if(_Color != null)
        {
            _GeoT.PaintTile(_Color);
        }
        else if(_Degree != 0)
        {
            _GeoT.Rotate(_Degree);   
        }
        
        _BufferedImage = _GeoT.getBufferedImage();        
        
        _PanelContainer.repaint();        
    }
    
    

    public JPanel getPanelContainer()
    {    
        return _PanelContainer;
    }
}
