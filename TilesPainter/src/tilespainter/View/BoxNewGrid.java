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
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Joris
 */
public class BoxNewGrid extends JDialog implements ActionListener {

    int colonne, ligne;

    private JTextField col, lig;
    private JButton confirmer, annuler;
    private JLabel labelSize, labelSet, labelTitle, labelError;

    private JPanel pano;

    public BoxNewGrid(JFrame parent, String title, boolean modal) {

        super(parent, title, modal);

        this.setPreferredSize(new Dimension(300, 200));
        this.setLocationRelativeTo(null);
        this.setResizable(true);
        this.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);

        confirmer = new JButton("Confirm");
        confirmer.addActionListener(this);
        annuler = new JButton("Cancel");
        annuler.addActionListener(this);
        col = new JTextField("");
        col.setColumns(2);
        lig = new JTextField("");
        lig.setColumns(2);

        labelSize = new JLabel("Size of the grid ");
        labelTitle = new JLabel("New Grid - ");
        labelError = new JLabel("                ");
        labelError.setForeground(Color.RED);

        this.init();

    }

    private void init() {

        pano = new JPanel();
        pano.setLayout(new GridBagLayout());

        GridBagConstraints cont = new GridBagConstraints();

        cont.gridx = 0;
        cont.gridy = 0;

        pano.add(labelTitle, cont);

        cont.gridy++;

        pano.add(labelSize, cont);

        cont.gridx++;
        pano.add(col, cont);

        cont.gridx++;
        pano.add(lig, cont);

        cont.gridx = 0;
        cont.gridy++;

        pano.add(annuler, cont);
        cont.gridx++;

        pano.add(confirmer, cont);
        cont.gridx++;

        pano.add(labelError, cont);

        this.setContentPane(pano);
        this.pack();

    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == confirmer) {
            try {
                colonne = Integer.parseInt(col.getText());
                ligne = Integer.parseInt(lig.getText());

                if (colonne > 0 && colonne <= 500 && ligne > 0 && ligne <= 500) {
                    this.dispose();
                } else {
                    labelError.setText("Incorrect size !");
                    colonne = -1;
                    ligne = -1;
                    this.init();
                }

            } catch (NumberFormatException nfe) {
                labelError.setText("Incorrect size !");
                this.init();
            }

        } else if (ae.getSource() == annuler) {
            colonne = -1;
            ligne = -1;
            this.setVisible(false);
        }

    }

}
