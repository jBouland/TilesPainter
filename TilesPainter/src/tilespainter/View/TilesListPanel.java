/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tilespainter.View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import tilespainter.Model.ImageListCellRenderer;
import tilespainter.Model.TileSet;

/**
 *
 * @author Joris
 */
public class TilesListPanel extends JPanel {

    private JList listTiles;
    private TileSet ts;
    private int selectedTile;
    private JButton editor;

    public TilesListPanel(TileSet ts) {
        selectedTile = 0;
        this.ts = ts;
        this.display();
        this.loadPictures();
        this.setPreferredSize(this.getPreferredSize());
        this.setLayout(new GridBagLayout());
        listTiles.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent lse) {
                selectedTile = listTiles.getSelectedIndex();
            }
        });
    }

    public int getSelectedTile() {
        return selectedTile;
    }

    private void display() {

        editor = new JButton("Editor");

        listTiles = new JList();
        listTiles.setCellRenderer(new ImageListCellRenderer());
        JScrollPane scrollPane = new JScrollPane(listTiles);


        this.add(editor, BorderLayout.NORTH);
        this.add(scrollPane, BorderLayout.SOUTH);

        listTiles.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    }

    private void loadPictures() {

        JPanel[] panels = new JPanel[ts.getSize()];

        for (int i = 0; i < ts.getSize(); i++) {

            panels[i] = new JPanel(new FlowLayout(FlowLayout.LEFT));
            panels[i].add(new JLabel("Image " + (i + 1), new ImageIcon(ts.getTile(i)), JLabel.LEFT));
        }

        listTiles.setListData(panels);

    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(180, 400);
    }

}
