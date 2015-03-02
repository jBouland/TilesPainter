/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tilespainter.Model;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Luxio Crimson
 */
public class RotationSlider extends JPanel implements ChangeListener
{
    private JSlider _JSlider;
    private JLabel _Degree;
    
    public RotationSlider()
    {        
        this.setSize(new Dimension(200, 200));             
        _JSlider = new JSlider(-180, 180, 0);
        _Degree = new JLabel();
        _JSlider.addChangeListener(this);
        PlaceConstraints();
        this.setVisible(true);      
    }
    
    private void PlaceConstraints()
    {
        this.setLayout(new GridBagLayout());
        
        GridBagConstraints _GBConstr = new GridBagConstraints();    
        
        _GBConstr.gridx = 0;
        _GBConstr.gridy = 0;
        this.add(_JSlider, _GBConstr);
        
       _Degree.setText(Integer.toString(_JSlider.getValue()));
        
        _GBConstr.gridx = 1 ;
        _GBConstr.gridy = 0;
        this.add(_Degree, _GBConstr);
    }
    
    public int getRotationDegree()
    {
        return _JSlider.getValue();
    }

    @Override
    public void stateChanged(ChangeEvent e)
    {
       _Degree.setText(Integer.toString(_JSlider.getValue()));
    }
}
