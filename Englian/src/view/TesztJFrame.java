package view;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import model.Felhasznalo;
import model.KapcsolatDB;
import model.Szo;
import model.Temakor;

/**
 * Tesztfeladatsor kitöltésére alkalmas felület.
 * @author Márta Krisztián
 * @since 2023-03-15
 */
public class TesztJFrame extends javax.swing.JFrame {
    
    private Felhasznalo beFelh;
    private Temakor tesztTemakor;
    private KapcsolatDB kapcsolat;
    private boolean kifejezesAngol; // A kifejezés nyelve
    private List<Temakor> temakorok;
    private List<Szo> szavak;
    private List<String> kifejezesek;
    private List<String> definiciok;
    private int hanyadikSzo; // Nem index, hanem sorszám
    private int tudta;

    /**
     * Creates new form SzavakJFrame.
     */
    public TesztJFrame() {
        initComponents();
    }
    
    /**
     * Creates new form TesztJFrame.
     * @param f Bejelentkezett felhasználó.
     */
    public TesztJFrame(Felhasznalo f) {
        initComponents();
        tesztPanel.setVisible(false);
        vegePanel.setVisible(false);
        kovetkezoButton.setVisible(false);
        visszajelzesLabel.setVisible(false);
        beFelh = f;
        kapcsolat = new KapcsolatDB();
        kifejezesAngol = angolRadioButtonKijelolve();
        temakorok = kapcsolat.temakorokLekerdez(beFelh);
        temakorokComboBoxFeltolt();
        kifejezesek = new ArrayList<>();
        definiciok = new ArrayList<>();
        hanyadikSzo = 1;
        tudta = 0;
    }
    
    /**
     * Megvizsgálja, hogy az angol rádiógomb van-e kijelölve.
     * @return A rádiógomb kijelöltségével.
     */
    public boolean angolRadioButtonKijelolve() {
        boolean b = false;
        if (angolRadioButton.isSelected()) b = true;
        return b;
    }
    
    /**
     * A kifejezéseket és a definíciókat tartalmazó listák tartalmának beállítása.
     */
    public void kifejezesekEsDefiniciokBeallitasa() {
        kifejezesek.clear();
        definiciok.clear();
        for (Szo szo : szavak) {
            if (kifejezesAngol) {
                kifejezesek.add(szo.getAngol());
                definiciok.add(szo.getMagyar());
            } else {
                kifejezesek.add(szo.getMagyar());
                definiciok.add(szo.getAngol());
            }
        }
    }
    
    /**
     * Hozzáadja a témaköröket a legördülő listához.
     */
    public void temakorokComboBoxFeltolt() {
        for (Temakor t : temakorok) {
            temakorokComboBox.addItem(t.getMegnevezes());
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

        kifejezesNyelveButtonGroup = new javax.swing.ButtonGroup();
        inditasPanel = new javax.swing.JPanel();
        angolRadioButton = new javax.swing.JRadioButton();
        magyarRadioButton = new javax.swing.JRadioButton();
        temakorokComboBox = new javax.swing.JComboBox<>();
        kezdesButton = new javax.swing.JButton();
        tesztPanel = new javax.swing.JPanel();
        kepLabel = new javax.swing.JLabel();
        kifejezesLabel = new javax.swing.JLabel();
        definicioTextField = new javax.swing.JTextField();
        visszajelzesLabel = new javax.swing.JLabel();
        valaszButton = new javax.swing.JButton();
        kovetkezoButton = new javax.swing.JButton();
        pontszamLabel = new javax.swing.JLabel();
        vegePanel = new javax.swing.JPanel();
        ujraButton = new javax.swing.JButton();
        bezarasButton = new javax.swing.JButton();
        eredmenyLabel = new javax.swing.JLabel();
        aranyLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(600, 700));
        setMinimumSize(new java.awt.Dimension(600, 700));
        setSize(new java.awt.Dimension(600, 700));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridBagLayout());

        inditasPanel.setMaximumSize(new java.awt.Dimension(600, 700));
        inditasPanel.setMinimumSize(new java.awt.Dimension(600, 700));
        inditasPanel.setName(""); // NOI18N
        inditasPanel.setPreferredSize(new java.awt.Dimension(600, 700));
        inditasPanel.setLayout(new java.awt.GridBagLayout());

        kifejezesNyelveButtonGroup.add(angolRadioButton);
        angolRadioButton.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        angolRadioButton.setSelected(true);
        angolRadioButton.setText("Angol");
        angolRadioButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        angolRadioButton.setFocusable(false);
        angolRadioButton.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                angolRadioButtonItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 50, 0);
        inditasPanel.add(angolRadioButton, gridBagConstraints);

        kifejezesNyelveButtonGroup.add(magyarRadioButton);
        magyarRadioButton.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        magyarRadioButton.setText("Magyar");
        magyarRadioButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        magyarRadioButton.setFocusable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 100, 50, 0);
        inditasPanel.add(magyarRadioButton, gridBagConstraints);

        temakorokComboBox.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        temakorokComboBox.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        temakorokComboBox.setFocusable(false);
        temakorokComboBox.setMaximumSize(new java.awt.Dimension(200, 35));
        temakorokComboBox.setMinimumSize(new java.awt.Dimension(200, 35));
        temakorokComboBox.setPreferredSize(new java.awt.Dimension(200, 35));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(50, 0, 50, 0);
        inditasPanel.add(temakorokComboBox, gridBagConstraints);

        kezdesButton.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        kezdesButton.setText("KEZDÉS");
        kezdesButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        kezdesButton.setFocusable(false);
        kezdesButton.setMaximumSize(new java.awt.Dimension(200, 100));
        kezdesButton.setMinimumSize(new java.awt.Dimension(200, 100));
        kezdesButton.setPreferredSize(new java.awt.Dimension(200, 100));
        kezdesButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kezdesButtonMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(50, 0, 0, 0);
        inditasPanel.add(kezdesButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(inditasPanel, gridBagConstraints);

        tesztPanel.setMaximumSize(new java.awt.Dimension(600, 700));
        tesztPanel.setMinimumSize(new java.awt.Dimension(600, 700));
        tesztPanel.setPreferredSize(new java.awt.Dimension(600, 700));
        tesztPanel.setLayout(new java.awt.GridBagLayout());

        kepLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 50, 0);
        tesztPanel.add(kepLabel, gridBagConstraints);

        kifejezesLabel.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        kifejezesLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        kifejezesLabel.setText("KIFEJEZÉS");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 50, 0);
        tesztPanel.add(kifejezesLabel, gridBagConstraints);

        definicioTextField.setFont(new java.awt.Font("Segoe UI", 0, 28)); // NOI18N
        definicioTextField.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        definicioTextField.setMaximumSize(new java.awt.Dimension(350, 50));
        definicioTextField.setMinimumSize(new java.awt.Dimension(350, 50));
        definicioTextField.setPreferredSize(new java.awt.Dimension(350, 50));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 25, 0);
        tesztPanel.add(definicioTextField, gridBagConstraints);

        visszajelzesLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        visszajelzesLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        visszajelzesLabel.setText("VISSZAJELZÉS");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 25, 0);
        tesztPanel.add(visszajelzesLabel, gridBagConstraints);

        valaszButton.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        valaszButton.setText("VÁLASZ");
        valaszButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        valaszButton.setFocusable(false);
        valaszButton.setMaximumSize(new java.awt.Dimension(125, 50));
        valaszButton.setMinimumSize(new java.awt.Dimension(125, 50));
        valaszButton.setPreferredSize(new java.awt.Dimension(125, 50));
        valaszButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                valaszButtonMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 25, 0);
        tesztPanel.add(valaszButton, gridBagConstraints);

        kovetkezoButton.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        kovetkezoButton.setText("KÖVETKEZŐ");
        kovetkezoButton.setToolTipText("");
        kovetkezoButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        kovetkezoButton.setFocusable(false);
        kovetkezoButton.setMaximumSize(new java.awt.Dimension(125, 50));
        kovetkezoButton.setMinimumSize(new java.awt.Dimension(125, 50));
        kovetkezoButton.setPreferredSize(new java.awt.Dimension(125, 50));
        kovetkezoButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kovetkezoButtonMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 25, 0);
        tesztPanel.add(kovetkezoButton, gridBagConstraints);

        pontszamLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        pontszamLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        tesztPanel.add(pontszamLabel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        getContentPane().add(tesztPanel, gridBagConstraints);

        vegePanel.setMaximumSize(new java.awt.Dimension(600, 700));
        vegePanel.setMinimumSize(new java.awt.Dimension(600, 700));
        vegePanel.setPreferredSize(new java.awt.Dimension(600, 700));
        vegePanel.setLayout(new java.awt.GridBagLayout());

        ujraButton.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        ujraButton.setText("ÚJRA");
        ujraButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ujraButton.setFocusable(false);
        ujraButton.setMaximumSize(new java.awt.Dimension(200, 100));
        ujraButton.setMinimumSize(new java.awt.Dimension(200, 100));
        ujraButton.setPreferredSize(new java.awt.Dimension(175, 100));
        ujraButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ujraButtonMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 20, 0);
        vegePanel.add(ujraButton, gridBagConstraints);

        bezarasButton.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        bezarasButton.setForeground(new java.awt.Color(255, 0, 0));
        bezarasButton.setText("BEZÁRÁS");
        bezarasButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bezarasButton.setFocusable(false);
        bezarasButton.setMaximumSize(new java.awt.Dimension(200, 100));
        bezarasButton.setMinimumSize(new java.awt.Dimension(200, 100));
        bezarasButton.setPreferredSize(new java.awt.Dimension(175, 100));
        bezarasButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bezarasButtonMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        vegePanel.add(bezarasButton, gridBagConstraints);

        eredmenyLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        eredmenyLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eredmenyLabel.setText("EREDMÉNY");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        vegePanel.add(eredmenyLabel, gridBagConstraints);

        aranyLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        aranyLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        aranyLabel.setText("ARÁNY");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 100, 0);
        vegePanel.add(aranyLabel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        getContentPane().add(vegePanel, gridBagConstraints);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        MenuJFrame menu = new MenuJFrame(beFelh);
        menu.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    private void kezdesButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kezdesButtonMouseClicked
        tesztTemakor = temakorok.get(temakorokComboBox.getSelectedIndex());
        szavak = kapcsolat.szavakAdottTemakorbenLekerdez(tesztTemakor.getId());
        System.out.println(tesztTemakor.toString()); // @todo
        System.out.println(szavak); // @todo
        if (szavak.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ez a szószedet nem tartalmaz szavakat, kérem töltsön fel párat!"); // @todo
        } else {
            inditasPanel.setVisible(false);
            tesztPanel.setVisible(true);
            Collections.shuffle(szavak);
            kifejezesekEsDefiniciokBeallitasa();
            kifejezesLabel.setText(kifejezesek.get(0));
            kepLabel.setIcon(new ImageIcon(getClass().getResource("/view/images/"+tesztTemakor.getMappa()+"/"+szavak.get(0).getKep()))); // @todo resize images
        }
    }//GEN-LAST:event_kezdesButtonMouseClicked

    private void angolRadioButtonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_angolRadioButtonItemStateChanged
       kifejezesAngol = angolRadioButtonKijelolve();
       System.out.println("ANGOL GOMB KIJELÖLVE? - "+kifejezesAngol); //@todo
    }//GEN-LAST:event_angolRadioButtonItemStateChanged

    private void bezarasButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bezarasButtonMouseClicked
        MenuJFrame menu = new MenuJFrame(beFelh);
        menu.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_bezarasButtonMouseClicked

    private void ujraButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ujraButtonMouseClicked
        vegePanel.setVisible(false);
        inditasPanel.setVisible(true);
        pontszamLabel.setText("");
        hanyadikSzo = 1;
        tudta = 0;
    }//GEN-LAST:event_ujraButtonMouseClicked

    private void valaszButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_valaszButtonMouseClicked
        valaszButton.setVisible(false);
        visszajelzesLabel.setVisible(true); // @todo tolowercase
        definicioTextField.setEnabled(false);
        if (definiciok.get(hanyadikSzo-1).equals(definicioTextField.getText())) {
            visszajelzesLabel.setForeground(Color.GREEN);
            visszajelzesLabel.setText("HELYES!");
            tudta++;
        }
        else {
            visszajelzesLabel.setForeground(Color.RED);
            visszajelzesLabel.setText(definiciok.get(hanyadikSzo-1));
        }
        kovetkezoButton.setVisible(true);
        pontszamLabel.setText(tudta+"/"+hanyadikSzo);
    }//GEN-LAST:event_valaszButtonMouseClicked

    private void kovetkezoButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kovetkezoButtonMouseClicked
        hanyadikSzo++;
        kovetkezoButton.setVisible(false);
        visszajelzesLabel.setVisible(false);
        definicioTextField.setEnabled(true);
        valaszButton.setVisible(true);
        definicioTextField.setText("");
        if (hanyadikSzo-1 < szavak.size()) {
            kifejezesLabel.setText(kifejezesek.get(hanyadikSzo-1));
            kepLabel.setIcon(new ImageIcon(getClass().getResource("/view/images/"+tesztTemakor.getMappa()+"/"+szavak.get(hanyadikSzo-1).getKep()))); // @todo resize images
        } else {
            tesztPanel.setVisible(false);
            vegePanel.setVisible(true);
            eredmenyLabel.setText("Pontszám: "+tudta+" / "+szavak.size());
            double eredmeny = (double)tudta/szavak.size()*100;
            aranyLabel.setText(Math.round(eredmeny)+"%");
            kapcsolat.tesztEredmenyFeltolt(beFelh.getId(), tesztTemakor.getId(), (int)Math.round(eredmeny));
        }
    }//GEN-LAST:event_kovetkezoButtonMouseClicked

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
            java.util.logging.Logger.getLogger(TesztJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TesztJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TesztJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TesztJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TesztJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton angolRadioButton;
    private javax.swing.JLabel aranyLabel;
    private javax.swing.JButton bezarasButton;
    private javax.swing.JTextField definicioTextField;
    private javax.swing.JLabel eredmenyLabel;
    private javax.swing.JPanel inditasPanel;
    private javax.swing.JLabel kepLabel;
    private javax.swing.JButton kezdesButton;
    private javax.swing.JLabel kifejezesLabel;
    private javax.swing.ButtonGroup kifejezesNyelveButtonGroup;
    private javax.swing.JButton kovetkezoButton;
    private javax.swing.JRadioButton magyarRadioButton;
    private javax.swing.JLabel pontszamLabel;
    private javax.swing.JComboBox<String> temakorokComboBox;
    private javax.swing.JPanel tesztPanel;
    private javax.swing.JButton ujraButton;
    private javax.swing.JButton valaszButton;
    private javax.swing.JPanel vegePanel;
    private javax.swing.JLabel visszajelzesLabel;
    // End of variables declaration//GEN-END:variables
}
