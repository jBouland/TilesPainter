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
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Luxio Crimson
 */
public class Test extends JPanel 
{
    private BufferedImage _BufferedImage;
    private Triangle _Triangle;
    public Test(int _Degree)
    {
//        Rectangle _Rectangle = new Rectangle(new Dimension(200, 200));
//        _Rectangle.DrawTile();
//        _Rectangle.PaintTile(Color.yellow);
//        _BufferedImage = _Rectangle.getBufferedImage();
        
        _Triangle = new Triangle(new Dimension(200, 200));
        _Triangle.DrawTile();
        _Triangle.PaintTile(Color.yellow);
        _Triangle.Rotate(_Degree);
        _BufferedImage = _Triangle.getBufferedImage();
        
        
    }
    
    public void update(int _Degree, Color _Color)
    {
        _Triangle.PaintTile(_Color);
        _Triangle.Rotate(_Degree);
        _BufferedImage = _Triangle.getBufferedImage();
        this.repaint();       
    }

   
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
      
        g.drawImage(_BufferedImage, 0, 0, null);
            
    }
    
   
    
    

}