/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sbb.gui;

import javax.swing.*;
import java.awt.*;
import sbb.gui.MainPanel;

/**
 *
 * @author Antonio
 */
public class MainFrame extends JFrame {

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        createMainPanel();
        pack();
        
    }
    
    private void createMainPanel(){
        MainPanel mainPanel = new MainPanel();
        Container mainContainer = this.getContentPane();
        mainContainer.add(mainPanel, BorderLayout.CENTER);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menueBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        editMenu = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("Predigplaner"); // NOI18N

        fileMenu.setText("File");
        menueBar.add(fileMenu);

        editMenu.setText("Edit");
        menueBar.add(editMenu);

        setJMenuBar(menueBar);
    }// </editor-fold>//GEN-END:initComponents



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenuBar menueBar;
    // End of variables declaration//GEN-END:variables
}
