/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tilespainter.Model;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.UIManager;

/**
 *
 * @author Joris
 */
public class ImageListCellRenderer implements ListCellRenderer {

    @Override
    public Component getListCellRendererComponent(JList jlist, Object e, int i, boolean bln, boolean bln1) {
        if (e instanceof JPanel) {
             Component component = (Component) e;
             component.setForeground(Color.white);
             component.setBackground(bln ? UIManager.getColor("Table.FocusCellForeground") : Color.white);
            if(bln){
                component.setBackground(new Color(180,220,240));
            }
             return component;
        }else{
            return new JLabel("??");
        }
    }

}
