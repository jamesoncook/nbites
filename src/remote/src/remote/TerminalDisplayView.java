/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * TerminalDisplayView.java
 *
 * Created on Jan 19, 2011, 10:45:31 AM
 */
package remote;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jack
 */
public class TerminalDisplayView extends javax.swing.JFrame {

    RemoteModel model;

    private static final int DESIRED_WIDTH = 400, DESIRED_HEIGHT = 400;

    /** Creates new form TerminalDisplayView */
    public TerminalDisplayView(RemoteModel model) {
        initComponents();
        this.model = model;
        setSize(DESIRED_WIDTH,DESIRED_HEIGHT);
    }

    public TerminalDisplayView() {
        initComponents();
        setSize(DESIRED_WIDTH,DESIRED_HEIGHT);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        display = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        display.setColumns(20);
        display.setEditable(false);
        display.setRows(5);
        display.setMinimumSize(new java.awt.Dimension(200, 300));
        display.setPreferredSize(new java.awt.Dimension(300, 400));
        jScrollPane1.setViewportView(display);

        getContentPane().add(jScrollPane1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new TerminalDisplayView().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea display;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    public void update() {
        try {
            int numAvailable = model.getStdout().available();
            byte[] letters = new byte[numAvailable];
            model.getStdout().read(letters, 0, numAvailable);
            display.append(new String(letters));
        } catch (IOException ex) {
            Logger.getLogger(TerminalDisplayView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}