/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tilespainter.View;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import tilespainter.Model.ImageListCellRenderer;

/**
 *
 * @author Joris
 */
public class TilesListPanel extends JPanel implements ActionListener {

    private JList listTiles;

    public TilesListPanel() {
        this.display();
        this.loadPictures();
        this.setLayout(new GridBagLayout());
    }

    private void display() {
        listTiles = new JList();
        listTiles.setCellRenderer(new ImageListCellRenderer());
        JScrollPane scrollPane = new JScrollPane(listTiles);
        scrollPane.setPreferredSize(new Dimension(300, 600));

        GridBagConstraints cont = new GridBagConstraints();
        cont.gridx = 0;
        cont.gridy = 0;
        this.add(scrollPane, cont);
        listTiles.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    private void loadPictures() {
        Icon testIcon = new ImageIcon("test1.png");
        Icon testIcon1 = new ImageIcon("test2.png");
        Icon testIcon2 = new ImageIcon("test5.png");

        JLabel text1 = new JLabel("Image 1", testIcon, JLabel.LEFT);
        JLabel text2 = new JLabel("Image 2", testIcon1, JLabel.LEFT);
        JLabel text3 = new JLabel("Image 3", testIcon2, JLabel.LEFT);

        JPanel IconPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel IconPanel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel IconPanel3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        IconPanel.add(text1);
        IconPanel2.add(text2);
        IconPanel3.add(text3);
        
        Object[] panels = {IconPanel, IconPanel2, IconPanel3};
        listTiles.setListData(panels);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(180, 200);
    }

}
