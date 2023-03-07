package view;

import java.util.List;
import model.Felhasznalo;
import model.KapcsolatDB;
import model.Szo;

/**
 * Egy szószedet szavait tartalmazó felület azok megtanulására.
 * @author Márta Krisztián
 * @since 2023-03-05
 */
public class SzotanuloJFrame extends javax.swing.JFrame {
    
    private Felhasznalo beFelh;
    private KapcsolatDB kapcsolat;
    private int temakor_id;
    private List<Szo> szavak; 

    /**
     * Creates new form SzavakJFrame.
     */
    public SzotanuloJFrame() {
        initComponents();
    }
    
    /**
     * Creates new form SzavakJFrame.
     * @param f Bejelentkezett felhasználó.
     * @param temakorId A szószedet témakörének azonosítójas.
     */
    public SzotanuloJFrame(Felhasznalo f, int temakorId) {
        initComponents();
        tanulasPanel.setVisible(false);
        beFelh = f;
        kapcsolat = new KapcsolatDB();
        temakor_id = temakorId;
        szavak = kapcsolat.szavakAdottTemakorbenLekerdez(temakor_id);
        System.out.println(szavak.toString()); //@todo
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

        nyelvButtonGroup = new javax.swing.ButtonGroup();
        tanulasPanel = new javax.swing.JPanel();
        definicoButton = new javax.swing.JButton();
        kifejezesButton = new javax.swing.JButton();
        nemTudomButton = new javax.swing.JButton();
        tudomButton = new javax.swing.JButton();
        inditasPanel = new javax.swing.JPanel();
        startButton = new javax.swing.JButton();
        magyarRadioButton = new javax.swing.JRadioButton();
        angolRadioButton = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 800));
        setSize(new java.awt.Dimension(800, 800));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridBagLayout());

        tanulasPanel.setMaximumSize(new java.awt.Dimension(800, 800));
        tanulasPanel.setMinimumSize(new java.awt.Dimension(800, 800));
        tanulasPanel.setPreferredSize(new java.awt.Dimension(800, 800));
        tanulasPanel.setLayout(new java.awt.GridBagLayout());

        definicoButton.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        definicoButton.setText("definicioButton");
        definicoButton.setFocusable(false);
        definicoButton.setMaximumSize(new java.awt.Dimension(400, 200));
        definicoButton.setMinimumSize(new java.awt.Dimension(400, 200));
        definicoButton.setPreferredSize(new java.awt.Dimension(400, 200));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 50, 0);
        tanulasPanel.add(definicoButton, gridBagConstraints);

        kifejezesButton.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        kifejezesButton.setText("kifejezesButton");
        kifejezesButton.setFocusable(false);
        kifejezesButton.setMaximumSize(new java.awt.Dimension(400, 200));
        kifejezesButton.setMinimumSize(new java.awt.Dimension(400, 200));
        kifejezesButton.setPreferredSize(new java.awt.Dimension(400, 200));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 50, 0);
        tanulasPanel.add(kifejezesButton, gridBagConstraints);

        nemTudomButton.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        nemTudomButton.setForeground(new java.awt.Color(255, 0, 0));
        nemTudomButton.setText("<html><div text-align:center>NEM<br>TUDOM</div></html>");
        nemTudomButton.setFocusable(false);
        nemTudomButton.setMaximumSize(new java.awt.Dimension(200, 100));
        nemTudomButton.setMinimumSize(new java.awt.Dimension(200, 100));
        nemTudomButton.setPreferredSize(new java.awt.Dimension(175, 100));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        tanulasPanel.add(nemTudomButton, gridBagConstraints);

        tudomButton.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        tudomButton.setForeground(new java.awt.Color(0, 128, 0));
        tudomButton.setText("TUDOM");
        tudomButton.setFocusable(false);
        tudomButton.setMaximumSize(new java.awt.Dimension(200, 100));
        tudomButton.setMinimumSize(new java.awt.Dimension(200, 100));
        tudomButton.setPreferredSize(new java.awt.Dimension(175, 100));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        tanulasPanel.add(tudomButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        getContentPane().add(tanulasPanel, gridBagConstraints);

        inditasPanel.setMaximumSize(new java.awt.Dimension(800, 800));
        inditasPanel.setMinimumSize(new java.awt.Dimension(800, 800));
        inditasPanel.setName(""); // NOI18N
        inditasPanel.setPreferredSize(new java.awt.Dimension(800, 800));
        inditasPanel.setLayout(new java.awt.GridBagLayout());

        startButton.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        startButton.setText("KEZDÉS");
        startButton.setFocusable(false);
        startButton.setMaximumSize(new java.awt.Dimension(200, 100));
        startButton.setMinimumSize(new java.awt.Dimension(200, 100));
        startButton.setPreferredSize(new java.awt.Dimension(200, 100));
        startButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                startButtonMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        inditasPanel.add(startButton, gridBagConstraints);

        nyelvButtonGroup.add(magyarRadioButton);
        magyarRadioButton.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        magyarRadioButton.setText("Magyar");
        magyarRadioButton.setFocusable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 100, 200, 0);
        inditasPanel.add(magyarRadioButton, gridBagConstraints);

        nyelvButtonGroup.add(angolRadioButton);
        angolRadioButton.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        angolRadioButton.setSelected(true);
        angolRadioButton.setText("Angol");
        angolRadioButton.setFocusable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 200, 0);
        inditasPanel.add(angolRadioButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(inditasPanel, gridBagConstraints);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        SzoszedetekJFrame szoszedet = new SzoszedetekJFrame(beFelh);
        szoszedet.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    private void startButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_startButtonMouseClicked
        inditasPanel.setVisible(false);
        tanulasPanel.setVisible(true);
    }//GEN-LAST:event_startButtonMouseClicked

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
            java.util.logging.Logger.getLogger(SzotanuloJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SzotanuloJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SzotanuloJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SzotanuloJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SzotanuloJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton angolRadioButton;
    private javax.swing.JButton definicoButton;
    private javax.swing.JPanel inditasPanel;
    private javax.swing.JButton kifejezesButton;
    private javax.swing.JRadioButton magyarRadioButton;
    private javax.swing.JButton nemTudomButton;
    private javax.swing.ButtonGroup nyelvButtonGroup;
    private javax.swing.JButton startButton;
    private javax.swing.JPanel tanulasPanel;
    private javax.swing.JButton tudomButton;
    // End of variables declaration//GEN-END:variables
}
