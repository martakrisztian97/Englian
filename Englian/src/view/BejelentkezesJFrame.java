package view;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import model.Felhasznalo;
import model.Hash;
import model.KapcsolatDB;

/**
 * Bejelentkezési felület.
 * @author Márta Krisztián
 * @since 2022-11-17
 */
public class BejelentkezesJFrame extends javax.swing.JFrame {
    
    private KapcsolatDB kapcsolat;
    private List<String> felhasznalonevek = new ArrayList<>();
    private Felhasznalo beFelh;

    /**
     * Creates new form Bejelentkezes.
     */
    public BejelentkezesJFrame() {
        initComponents();
        kapcsolat = new KapcsolatDB();
        felhasznalonevek = kapcsolat.felhasznalonevekLekerdez();
    }
    
    /**
     * Regisztrációs felület megnyitása.
     */
    public void regisztracioMegnyit() {
        RegisztracioJFrame reg = new RegisztracioJFrame();
        reg.setVisible(true);
        this.setVisible(false);
    }
    
    /**
     * Bejelentkezés implementálása és validálása.
     */
    public void bejelentkezes() {
        String felhasznalonev = felhasznalonevTextField.getText();
        String jelszo = new String(jelszoPasswordField.getPassword());
        if (felhasznalonev.isEmpty() || jelszo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Felhasználónév és jelszó megadása kötelező!", "Sikertelen bejelentkezés", JOptionPane.ERROR_MESSAGE);
        } else if (!felhasznalonevek.contains(felhasznalonev)) {
            JOptionPane.showMessageDialog(null, "Hibás felhasználónév!", "Sikertelen bejelentkezés", JOptionPane.ERROR_MESSAGE);
        } else {
            beFelh = kapcsolat.felhasznaloAdatokLekerdez(felhasznalonev);
            if (Hash.MD5(jelszo).equals(beFelh.getJelszo())) {
                MenuJFrame menu = new MenuJFrame(beFelh);
                menu.setVisible(true);
                this.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "Hibás jelszó!", "Sikertelen bejelentkezés", JOptionPane.ERROR_MESSAGE);
            }
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

        felhasznalonevTextField = new javax.swing.JTextField();
        jelszoPasswordField = new javax.swing.JPasswordField();
        capsLockLabel = new javax.swing.JLabel();
        bejelentkezesButton = new javax.swing.JButton();
        regisztracioButton = new javax.swing.JButton();
        logoLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jelszoFelfedLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bejelentkezés");
        setMaximumSize(new java.awt.Dimension(600, 600));
        setMinimumSize(new java.awt.Dimension(600, 600));
        setPreferredSize(new java.awt.Dimension(600, 600));
        setResizable(false);
        setSize(new java.awt.Dimension(600, 600));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        felhasznalonevTextField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        felhasznalonevTextField.setToolTipText("");
        felhasznalonevTextField.setMaximumSize(new java.awt.Dimension(250, 50));
        felhasznalonevTextField.setMinimumSize(new java.awt.Dimension(250, 50));
        felhasznalonevTextField.setPreferredSize(new java.awt.Dimension(250, 50));
        felhasznalonevTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                felhasznalonevTextFieldKeyPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 40, 10, 0);
        getContentPane().add(felhasznalonevTextField, gridBagConstraints);

        jelszoPasswordField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jelszoPasswordField.setMaximumSize(new java.awt.Dimension(250, 50));
        jelszoPasswordField.setMinimumSize(new java.awt.Dimension(250, 50));
        jelszoPasswordField.setOpaque(true);
        jelszoPasswordField.setPreferredSize(new java.awt.Dimension(250, 50));
        jelszoPasswordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jelszoPasswordFieldKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jelszoPasswordFieldKeyTyped(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 40, 0, 0);
        getContentPane().add(jelszoPasswordField, gridBagConstraints);

        capsLockLabel.setForeground(new java.awt.Color(255, 0, 0));
        capsLockLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 40, 25, 0);
        getContentPane().add(capsLockLabel, gridBagConstraints);

        bejelentkezesButton.setBackground(new java.awt.Color(0, 153, 255));
        bejelentkezesButton.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        bejelentkezesButton.setForeground(new java.awt.Color(255, 255, 255));
        bejelentkezesButton.setText("BEJELENTKEZÉS");
        bejelentkezesButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bejelentkezesButton.setMaximumSize(new java.awt.Dimension(200, 50));
        bejelentkezesButton.setMinimumSize(new java.awt.Dimension(200, 50));
        bejelentkezesButton.setPreferredSize(new java.awt.Dimension(200, 50));
        bejelentkezesButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bejelentkezesButtonMouseClicked(evt);
            }
        });
        bejelentkezesButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bejelentkezesButtonKeyPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.insets = new java.awt.Insets(0, 40, 10, 0);
        getContentPane().add(bejelentkezesButton, gridBagConstraints);

        regisztracioButton.setBackground(Color.WHITE);
        regisztracioButton.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        regisztracioButton.setForeground(new java.awt.Color(0, 153, 255));
        regisztracioButton.setText("ÚJ FIÓK LÉTREHOZÁSA");
        regisztracioButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        regisztracioButton.setMaximumSize(new java.awt.Dimension(200, 50));
        regisztracioButton.setMinimumSize(new java.awt.Dimension(200, 50));
        regisztracioButton.setPreferredSize(new java.awt.Dimension(200, 50));
        regisztracioButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                regisztracioButtonMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.insets = new java.awt.Insets(0, 40, 0, 0);
        getContentPane().add(regisztracioButton, gridBagConstraints);

        logoLabel.setFont(new java.awt.Font("Magneto", 0, 48)); // NOI18N
        logoLabel.setForeground(new java.awt.Color(0, 153, 255));
        logoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoLabel.setText("Englian");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 50, 0);
        getContentPane().add(logoLabel, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Felhasználónév");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 40, 0, 0);
        getContentPane().add(jLabel1, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Jelszó");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 40, 0, 0);
        getContentPane().add(jLabel2, gridBagConstraints);

        jelszoFelfedLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jelszoFelfedLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/passwordShow.png"))); // NOI18N
        jelszoFelfedLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jelszoFelfedLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jelszoFelfedLabelMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        getContentPane().add(jelszoFelfedLabel, gridBagConstraints);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void regisztracioButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_regisztracioButtonMouseClicked
        regisztracioMegnyit();
    }//GEN-LAST:event_regisztracioButtonMouseClicked

    private void jelszoFelfedLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jelszoFelfedLabelMouseClicked
        if (jelszoPasswordField.getEchoChar() == '*') {
            jelszoPasswordField.setEchoChar((char)0);
            jelszoFelfedLabel.setIcon(new ImageIcon(getClass().getResource("/view/images/passwordHide.png")));
        } else if (jelszoPasswordField.getEchoChar() == (char)0) {
            jelszoPasswordField.setEchoChar('*');
            jelszoFelfedLabel.setIcon(new ImageIcon(getClass().getResource("/view/images/passwordShow.png")));
        }
    }//GEN-LAST:event_jelszoFelfedLabelMouseClicked

    private void bejelentkezesButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bejelentkezesButtonMouseClicked
        bejelentkezes();
    }//GEN-LAST:event_bejelentkezesButtonMouseClicked

    private void bejelentkezesButtonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bejelentkezesButtonKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            bejelentkezes();
        }
    }//GEN-LAST:event_bejelentkezesButtonKeyPressed

    private void jelszoPasswordFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jelszoPasswordFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            bejelentkezes();
        }
    }//GEN-LAST:event_jelszoPasswordFieldKeyPressed

    private void felhasznalonevTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_felhasznalonevTextFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            bejelentkezes();
        }
    }//GEN-LAST:event_felhasznalonevTextFieldKeyPressed

    private void jelszoPasswordFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jelszoPasswordFieldKeyTyped
        boolean capsBe = Toolkit.getDefaultToolkit().getLockingKeyState(KeyEvent.VK_CAPS_LOCK);
        if (capsBe) {
            capsLockLabel.setText("A Caps Lock aktív!");
        } else {
            capsLockLabel.setText("");
        }
    }//GEN-LAST:event_jelszoPasswordFieldKeyTyped

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
    private javax.swing.JLabel capsLockLabel;
    private javax.swing.JTextField felhasznalonevTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jelszoFelfedLabel;
    private javax.swing.JPasswordField jelszoPasswordField;
    private javax.swing.JLabel logoLabel;
    private javax.swing.JButton regisztracioButton;
    // End of variables declaration//GEN-END:variables
}
