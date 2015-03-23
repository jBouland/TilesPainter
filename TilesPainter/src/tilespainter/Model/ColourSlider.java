/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tilespainter.Model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
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
public class ColourSlider extends Observable implements ChangeListener, ActionListener
{

    private JSlider _RSlider;
    private JSlider _GSlider;
    private JSlider _BSlider;
    private JTextField _Hex;
    private JTextField _RValue;
    private JTextField _GValue;
    private JTextField _BValue;
    private JLabel _Red;   
    private JLabel _Green;
    private JLabel _Blue;
    private JPanel _PanelContainer;
    
    
 
    
    public ColourSlider()
    {        
        _PanelContainer = new JPanel();
        _RSlider = new JSlider(0, 255, 0);
        _BSlider = new JSlider(0, 255, 0);
        _GSlider = new JSlider(0, 255, 0);
        _Hex = new JTextField(RGBtoHex(_RSlider.getValue(), _GSlider.getValue(), _BSlider.getValue()));
        _RValue = new JTextField(Integer.toString(_RSlider.getValue()), 3);
        _GValue = new JTextField(Integer.toString(_GSlider.getValue()), 3);
        _BValue = new JTextField(Integer.toString(_BSlider.getValue()), 3);        
        _RSlider.addChangeListener(this);
        _GSlider.addChangeListener(this);
        _BSlider.addChangeListener(this);
        _RValue.addActionListener(this);
        _GValue.addActionListener(this);
        _BValue.addActionListener(this);
        _Red = new JLabel("Red");
        _Red.setForeground(Color.red);
        _Green = new JLabel("Green");
        _Green.setForeground(Color.green);
        _Blue = new JLabel("Blue");  
        _Blue.setForeground(Color.blue);
        
        PlaceConstraints();
           
    }
    
    private void PlaceConstraints()
    {
        _PanelContainer.setLayout(new GridBagLayout());
        
        GridBagConstraints _GBConstr = new GridBagConstraints();    
        
        _GBConstr.gridx = 0;
        _GBConstr.gridy = 0;
        _PanelContainer.add(_Red, _GBConstr);
        
        _GBConstr.gridx = 1;
        _GBConstr.gridy = 0;
        _PanelContainer.add(_RSlider, _GBConstr);
        
        _GBConstr.gridx = 1;
        _GBConstr.gridy = 1;
        _PanelContainer.add(_RValue, _GBConstr);
        
        _GBConstr.gridx = 0;
        _GBConstr.gridy = 2;
        _PanelContainer.add(_Green, _GBConstr);
        
        _GBConstr.gridx = 1;
        _GBConstr.gridy = 2;
        _PanelContainer.add(_GSlider, _GBConstr);
        
        _GBConstr.gridx = 1;
        _GBConstr.gridy = 3;
        _PanelContainer.add(_GValue, _GBConstr);
        
        _GBConstr.gridx = 0;
        _GBConstr.gridy = 4;
        _PanelContainer.add(_Blue, _GBConstr);
        
        _GBConstr.gridx = 1;
        _GBConstr.gridy = 4;
        _PanelContainer.add(_BSlider, _GBConstr);
        
        _GBConstr.gridx = 1;
        _GBConstr.gridy = 5;
        _PanelContainer.add(_BValue, _GBConstr);
        
        _Hex.setText(RGBtoHex(_RSlider.getValue(), _GSlider.getValue(), _BSlider.getValue()));
        
        _GBConstr.gridx = 2 ;
        _GBConstr.gridy = 3;
        _PanelContainer.add(_Hex, _GBConstr);
    }
    
    private String RGBtoHex(int R, int G, int B)
    {
        return String.format("#%02x%02x%02x", R, G, B);       
    }
    
    private void SetSliderValue(JSlider _ColourSlider, JTextField _ColourField)
    {
         try
        {
            _ColourSlider.setValue(Integer.parseInt(_ColourField.getText()));
        }
        catch(NumberFormatException NFE)
        {
            _ColourSlider.setValue(0);
        }
    }
    
    public Color getColour()
    {
        Color _Color = new Color(_RSlider.getValue(), _GSlider.getValue(), _BSlider.getValue());
        return _Color;       
    }

    public JPanel getPanelContainer()
    {
        return _PanelContainer;
    }
    


    @Override
    public void stateChanged(ChangeEvent e)
    {
       _Hex.setText(RGBtoHex(_RSlider.getValue(), _GSlider.getValue(), _BSlider.getValue()));
       _RValue.setText(Integer.toString(_RSlider.getValue()));
       _GValue.setText(Integer.toString(_GSlider.getValue()));
       _BValue.setText(Integer.toString(_BSlider.getValue()));
       this.setChanged();
       this.notifyObservers();
       
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        SetSliderValue(_RSlider, _RValue);
        SetSliderValue(_GSlider, _GValue);
        SetSliderValue(_BSlider, _BValue);      
    }
    
}
