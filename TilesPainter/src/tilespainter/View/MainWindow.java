/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tilespainter.View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import tilespainter.Model.Filtre_Simple;
import tilespainter.Model.TileSet;

/**
 *
 * @author Joris
 */
public class MainWindow extends JFrame implements ActionListener {

    private JMenu menu;
    private JMenuItem menuExport, menuNew;
    private BoxNewGrid dialog;
    private JMenuBar bar;
    private TilesListPanel tilesListPanel;
    private PicturePanel picturePanel;
    private TileSet testTileSet;
    private JSplitPane splitPane;
    private JScrollPane jscroll;
    

    public MainWindow() throws IOException {
        setTitle("Tiles Painter");
        this.setMinimumSize(new Dimension(1024, 768));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());

        dialog = new BoxNewGrid(this, "Start a new grid", true);

        initMenu();
        this.setJMenuBar(bar);

        testTileSet = new TileSet();

        tilesListPanel = new TilesListPanel(testTileSet);
        picturePanel = new PicturePanel(10, 10, tilesListPanel, testTileSet);

        jscroll = new JScrollPane(picturePanel);


        initSplitPane();

    }

    private void initMenu() {
        menu = new JMenu("Options");
        menuExport = new JMenuItem("Export");
        menuExport.addActionListener(this);
        menuNew = new JMenuItem("New Grid");
        menuNew.addActionListener(this);

        bar = new JMenuBar();
        menu.add(menuExport);
        menu.add(menuNew);
        bar.add(menu);

    }

    private void initSplitPane() {
        jscroll = new JScrollPane(picturePanel);
        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, jscroll, tilesListPanel);
        splitPane.setDividerLocation(650);
        splitPane.setOneTouchExpandable(true);
        this.add(splitPane);

    }


    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == menuNew) {

            dialog.setVisible(true);
            if (dialog.colonne >= 0 && dialog.ligne >= 0) {
                picturePanel = new PicturePanel(dialog.colonne, dialog.ligne, tilesListPanel, testTileSet);
                this.remove(splitPane);
                this.remove(jscroll);
                initSplitPane();
                this.pack();
            }

        } else if (ae.getSource() == menuExport) {
            //open a JFileChooser

            JFileChooser save = new JFileChooser();
            Filtre_Simple ppm = new Filtre_Simple("Fichiers PNG", ".PNG");//Creation d'un filtre pour fichier PNG
            save.addChoosableFileFilter(ppm);//apllication du filtre sur le JFileChooser
            save.setAcceptAllFileFilterUsed(false);

            int returnVal = save.showSaveDialog(null);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                String path = save.getSelectedFile().getAbsolutePath() + ".png";
                try {
                    try(FileOutputStream fos = new FileOutputStream(path)){
                    ImageIO.write(picturePanel.export_Grid(), "png", fos);
                    }
                    
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
            
            try {
                picturePanel.exportTXT("devSave");
            } catch (IOException ex) {
                Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

}
