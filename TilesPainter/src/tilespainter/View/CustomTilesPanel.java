/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tilespainter.View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import tilespainter.Model.ColourSlider;
import tilespainter.Model.CustomTileContainer;
import tilespainter.Model.RotationSlider;

/**
 *
 * @author Luxio Crimson
 */
public class CustomTilesPanel extends JPanel implements Observer, ActionListener
{
    private RotationSlider _RS;
    private ColourSlider _CS;
    private GridBagConstraints _GBConstr;
    private JComboBox _JCB;
    private CustomTileContainer _CTC;
    private JPanel _JPanel;
    
    
    public CustomTilesPanel()
    {
        Initialise();
        PlaceComponents();
        
        
        this.setVisible(true);         
    }
    
    private void Initialise()
    {
        _JPanel = new JPanel();
        _RS = new RotationSlider();
        _CS = new ColourSlider();
        String[] GTTypes = {"Rectangle", "Triangle", "Circle", "Pentagon", "Hexagon", "Octogon"};
        _JCB = new JComboBox(GTTypes);
        _JCB.addActionListener(this);
        _CTC = new CustomTileContainer();
        _JPanel = _CTC.getPanelContainer();
        _GBConstr = new GridBagConstraints();
        _CS.addObserver(this);
        _RS.addObserver(this);
    }
    
    private void PlaceComponents()
    {
       this.setLayout(new GridBagLayout());        

        _GBConstr.gridx = 0;
        _GBConstr.gridy = 0;          
        _GBConstr.weightx = 1.0;
        _GBConstr.weighty = 1.0;        
        this.add(_CTC.getPanelContainer(), _GBConstr);
        
        _GBConstr.gridx = 0;
        _GBConstr.gridy = 1;          
        this.add(_JCB, _GBConstr);
        
        _GBConstr.gridx = 0;
        _GBConstr.gridy = 2;          
        this.add(_RS.getPanelContainer(), _GBConstr);
        
        _GBConstr.gridx = 0;
        _GBConstr.gridy = 3;          
        this.add(_CS.getPanelContainer(), _GBConstr);       
    }

    @Override
    public void update(Observable o, Object arg)
    {        
        if(o == _CS)
        {
            _CTC.update(0, _CS.getColour());
        }
        else if(o == _RS)
        {
            _CTC.update(_RS.getRotationDegree(), null);            
        }
        this.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == _JCB)
        {            
            _CTC.ChangeGeometricalTile(_JCB.getSelectedItem().toString(), new Dimension(200,200), _CS.getColour());       
            _GBConstr.gridx = 0;
            _GBConstr.gridy = 0;  
            this.add(_CTC.getPanelContainer(), _GBConstr);            
        }        
    }
    
}
