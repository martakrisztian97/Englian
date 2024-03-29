package view;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Allomanymuveletek;
import model.Kep;

/**
 * Englián szakdolgozatban szereplő képek forrásainak kezelésére sozlgáló felület.
 * @author Márta Krisztián
 * @since 2023-03-31 
 */
public class ForraskezeloJFrame extends javax.swing.JFrame {

    private ArrayList<Kep> kepek;
    
    /**
     * Creates new form ForraskezeloJFrame.
     */
    public ForraskezeloJFrame() {
        initComponents();
        kepek = Allomanymuveletek.beolvas("images_sources.txt");
        Collections.sort(kepek, new CompareKepek());
        for (Kep k : kepek) {
            kepekComboBox.addItem(k.getMegnevezes());
        }
        
        
        String forras = kepek.get(kepekComboBox.getSelectedIndex()).getForras();
        if (forras.equals("SAJÁT")) {
            jLabel1.setVisible(true);
            forrasMegnyitButton.setVisible(false);
        } else {
            jLabel1.setVisible(false);
            forrasMegnyitButton.setVisible(true);
        }
    }
    
    public void forrasBongeszobenMegnyit() {
    Desktop d = Desktop.getDesktop();
    try {
      try {
        d.browse(new URI(kepek.get(kepekComboBox.getSelectedIndex()).getForras()));
      } catch (IOException ex) {
        Logger.getLogger(ForraskezeloJFrame.class.getName()).log(Level.SEVERE, null, ex);
      }
    } catch (URISyntaxException ex) {
      Logger.getLogger(ForraskezeloJFrame.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        kepekComboBox = new javax.swing.JComboBox<>();
        forrasMegnyitButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Englián forráskezelő");
        setMinimumSize(new java.awt.Dimension(500, 500));
        setResizable(false);
        setSize(new java.awt.Dimension(500, 500));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Forrás megnyitása böngészőben", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel1.setMaximumSize(new java.awt.Dimension(400, 400));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        kepekComboBox.setBackground(new java.awt.Color(0, 153, 255));
        kepekComboBox.setForeground(new java.awt.Color(255, 255, 255));
        kepekComboBox.setFocusable(false);
        kepekComboBox.setMaximumSize(new java.awt.Dimension(250, 35));
        kepekComboBox.setMinimumSize(new java.awt.Dimension(250, 35));
        kepekComboBox.setPreferredSize(new java.awt.Dimension(250, 35));
        kepekComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                kepekComboBoxItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(25, 25, 25, 25);
        jPanel1.add(kepekComboBox, gridBagConstraints);

        forrasMegnyitButton.setBackground(new java.awt.Color(0, 153, 255));
        forrasMegnyitButton.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        forrasMegnyitButton.setForeground(new java.awt.Color(255, 255, 255));
        forrasMegnyitButton.setText("MEGNYITÁS");
        forrasMegnyitButton.setFocusPainted(false);
        forrasMegnyitButton.setMaximumSize(new java.awt.Dimension(125, 50));
        forrasMegnyitButton.setMinimumSize(new java.awt.Dimension(125, 50));
        forrasMegnyitButton.setPreferredSize(new java.awt.Dimension(125, 50));
        forrasMegnyitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                forrasMegnyitButtonMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 25, 25, 25);
        jPanel1.add(forrasMegnyitButton, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("SAJÁT");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 25, 25, 25);
        jPanel1.add(jLabel1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        getContentPane().add(jPanel1, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Magneto", 0, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Englián");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 50, 0);
        getContentPane().add(jLabel2, gridBagConstraints);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void forrasMegnyitButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forrasMegnyitButtonMouseClicked
        forrasBongeszobenMegnyit();
    }//GEN-LAST:event_forrasMegnyitButtonMouseClicked

    private void kepekComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_kepekComboBoxItemStateChanged
        String forras = kepek.get(kepekComboBox.getSelectedIndex()).getForras();
        if (forras.equals("SAJÁT")) {
            jLabel1.setVisible(true);
            forrasMegnyitButton.setVisible(false);
        } else {
            jLabel1.setVisible(false);
            forrasMegnyitButton.setVisible(true);
        }
    }//GEN-LAST:event_kepekComboBoxItemStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ForraskezeloJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ForraskezeloJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ForraskezeloJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ForraskezeloJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ForraskezeloJFrame().setVisible(true);
            }
        });
    }
    
    public static class CompareKepek implements Comparator<Kep> {

        @Override
        public int compare(Kep k1, Kep k2) {
            return k1.getMegnevezes().compareTo(k2.getMegnevezes());
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton forrasMegnyitButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> kepekComboBox;
    // End of variables declaration//GEN-END:variables
}