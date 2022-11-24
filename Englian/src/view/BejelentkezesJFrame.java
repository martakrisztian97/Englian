package view;

/**
 * Bejelentkezés
 * @author Márta Krisztián
 * @since 2022-11-17
 */
public class BejelentkezesJFrame extends javax.swing.JFrame {

    /**
     * Creates new form Bejelentkezes
     */
    public BejelentkezesJFrame() {
        initComponents();
    }
    
    public void regisztracioMegnyit() {
        RegisztracioJFrame reg = new RegisztracioJFrame();
        reg.setVisible(true);
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

        felhasznalonevTextField = new javax.swing.JTextField();
        jelszoPasswordField = new javax.swing.JPasswordField();
        bejelentkezesButton = new javax.swing.JButton();
        regisztracioButton = new javax.swing.JButton();
        logoLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Angol szótanuló alkalmazás demó");
        setMaximumSize(new java.awt.Dimension(500, 400));
        setMinimumSize(new java.awt.Dimension(500, 400));
        setPreferredSize(new java.awt.Dimension(500, 400));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        felhasznalonevTextField.setMinimumSize(new java.awt.Dimension(200, 30));
        felhasznalonevTextField.setPreferredSize(new java.awt.Dimension(200, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 0);
        getContentPane().add(felhasznalonevTextField, gridBagConstraints);

        jelszoPasswordField.setMinimumSize(new java.awt.Dimension(200, 30));
        jelszoPasswordField.setPreferredSize(new java.awt.Dimension(200, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 0);
        getContentPane().add(jelszoPasswordField, gridBagConstraints);

        bejelentkezesButton.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        bejelentkezesButton.setText("Bejelentkezés");
        bejelentkezesButton.setMaximumSize(new java.awt.Dimension(250, 30));
        bejelentkezesButton.setMinimumSize(new java.awt.Dimension(250, 30));
        bejelentkezesButton.setPreferredSize(new java.awt.Dimension(250, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        getContentPane().add(bejelentkezesButton, gridBagConstraints);

        regisztracioButton.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        regisztracioButton.setText("Regisztráció");
        regisztracioButton.setMaximumSize(new java.awt.Dimension(250, 30));
        regisztracioButton.setMinimumSize(new java.awt.Dimension(250, 30));
        regisztracioButton.setPreferredSize(new java.awt.Dimension(250, 40));
        regisztracioButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                regisztracioButtonMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        getContentPane().add(regisztracioButton, gridBagConstraints);

        logoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/myemoji2.png"))); // NOI18N
        logoLabel.setText("ENGLIAN");
        logoLabel.setMaximumSize(new java.awt.Dimension(150, 150));
        logoLabel.setMinimumSize(new java.awt.Dimension(150, 150));
        logoLabel.setPreferredSize(new java.awt.Dimension(150, 150));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        getContentPane().add(logoLabel, gridBagConstraints);

        jLabel1.setText("Felhasználónév:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        getContentPane().add(jLabel1, gridBagConstraints);

        jLabel2.setText("Jelszó:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        getContentPane().add(jLabel2, gridBagConstraints);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void regisztracioButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_regisztracioButtonMouseClicked
        regisztracioMegnyit();
    }//GEN-LAST:event_regisztracioButtonMouseClicked

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
            java.util.logging.Logger.getLogger(BejelentkezesJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BejelentkezesJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BejelentkezesJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BejelentkezesJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
       java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BejelentkezesJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bejelentkezesButton;
    private javax.swing.JTextField felhasznalonevTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField jelszoPasswordField;
    private javax.swing.JLabel logoLabel;
    private javax.swing.JButton regisztracioButton;
    // End of variables declaration//GEN-END:variables
}