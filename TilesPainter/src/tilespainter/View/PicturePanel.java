/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tilespainter.View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import tilespainter.Model.TileSet;
import tilespainter.Model.TilesGrid;

/**
 *
 * @author Joris
 */
public class PicturePanel extends JPanel implements MouseListener {

    private int heigh;
    private int width;
    private int tileSize;
    private TilesGrid tgrid;
    private TilesListPanel tlp;
    private TileSet ts;

    private Image background;

    public PicturePanel(int _heigh, int _width, TilesListPanel tp, TileSet ts) {
        super();

        background = new ImageIcon("background.jpg").getImage();

        tlp = tp;
        this.ts = ts;
        tileSize = 32;
        this.setPreferredSize(new Dimension(_width * tileSize + 1, _heigh * tileSize + 1));
        this.heigh = _heigh;
        this.width = _width;
        tgrid = new TilesGrid(width, heigh);

        this.addMouseListener(this);

    }

    public int getGridH() {
        return heigh;
    }

    public int getGridW() {

        return width;

    }

    public void paintComponent(Graphics g) {

        g.drawImage(background, 0, 0, this);

        g.setColor(Color.lightGray);

        //dessine le fond
        g.fillRect(0, 0, tileSize * width + 2 * width + 2, tileSize * heigh + 2 * heigh + 2);

        //dessine les cases
        for (int i = 0; i < width; i++) {

            for (int j = 0; j < heigh; j++) {

                g.setColor(Color.WHITE);

                g.fillRect((i * tileSize + 2) + (i * 2), (j * tileSize + 2) + (j * 2), tileSize, tileSize);
            }
        }

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < heigh; j++) {
                if (tgrid.getTile(i, j) != -1) {
                    g.drawImage(ts.getTile(tgrid.getTile(i, j)), i * 32 + (1 + i) * 2, j * 32 + (1 + j) * 2, this);
                }
            }
        }
    }

    public void special_paint(Graphics g) {

        g.setColor(Color.white);
        g.fillRect(0, 0, tileSize * width + 2 * width + 2, tileSize * heigh + 2 * heigh + 2);

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < heigh; j++) {
                if (tgrid.getTile(i, j) != -1) {
                    g.drawImage(ts.getTile(tgrid.getTile(i, j)), i * 32, j * 32, this);
                }
            }
        }

    }
    
    public void loadFile(String file){
        try{
            Scanner scan = new Scanner(new File(file));
        }catch(Exception e){
            System.out.println("Pas d'ouverture de fichier");;
        }
    }

        
    public void exportTXT(String nom) throws IOException{
        
        String newLine = System.getProperty("line.separator");
        String extension=".txt";
        int numero=1;
        String nomFichier;
        Boolean nomCorrect = false;
        File file;
        while(nomCorrect == false){
            
            nomFichier = (nom+numero+extension);
            file = new File(nomFichier);
            
            if(!file.exists()){
                nomCorrect = true;
                file.createNewFile();
                FileWriter fw = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write("*Tile Painter*"+newLine);
                bw.write("Created by Joris Bouland, Lucille Guillot and Valentin Nguyen"
                +newLine);
                
                for(int i = 0; i < heigh; i++){
                    for(int j = 0 ; j < width;j++){
                        bw.write(tgrid.getTile(j, i)+",");
                    }
                    bw.write(newLine);
  
                }
                
                bw.close();
                
            }else{
                numero++;
                nomFichier="";
            }

        }
        
        
    }
    
    public BufferedImage export_Grid() {
        BufferedImage bImage = new BufferedImage(tileSize * width, tileSize * heigh, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2D = (Graphics2D) bImage.getGraphics();
        this.special_paint(g2D);
        return bImage;

    }

    @Override
    public void mouseClicked(MouseEvent me) {

    }

    @Override
    public void mousePressed(MouseEvent me) {
        tgrid.setTiles(tlp.getSelectedTile(), (me.getX() - (me.getX() / 16)) / 32, (me.getY() - me.getY() / 16) / 32);
  

        this.repaint();
    }

    @Override
    public void mouseReleased(MouseEvent me) {

    }

    @Override
    public void mouseEntered(MouseEvent me) {

    }

    @Override
    public void mouseExited(MouseEvent me) {

    }

    @Override
    public Dimension getPreferredSize() {

        return new Dimension(width * tileSize + 1 + 2 * width + 2, heigh * tileSize + 1 + 2 * heigh + 2);
    }

}
