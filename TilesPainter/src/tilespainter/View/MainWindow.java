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
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author Joris
 */
public class MainWindow extends JFrame implements ActionListener {

    JMenu menu;
    JMenuItem menuExport;
    JMenuBar bar;
    TilesListPanel tilesListPanel;

    public MainWindow() {
        setTitle("Tiles Painter");
        this.setMinimumSize(new Dimension(1024, 768));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        
        initMenu();
        this.setJMenuBar(bar);
        
        tilesListPanel = new TilesListPanel();
        this.add(tilesListPanel);
        
        this.pack();
    }
    
    private void initMenu(){
        menu = new JMenu("Options");
        menuExport = new JMenuItem("Export");
        bar = new JMenuBar();
        menu.add(menuExport);
        bar.add(menu);
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
