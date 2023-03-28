package view;

import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import model.Felhasznalo;
import model.KapcsolatDB;
import model.Szo;
import model.Temakor;

/**
 * Szószedetek és szavak szerkesztésére alkalmas felület.
 * @author Márta Krisztián
 * @since 2023-03-18
 */
public class SzerkesztoJFrame extends javax.swing.JFrame {

    private Felhasznalo beFelh;
    private KapcsolatDB kapcsolat;
    private ArrayList<Temakor> temakorok;
    private ArrayList<Szo> szavak;
    
    /**
     * Creates new form SzerkesztoJFrame.
     */
    public SzerkesztoJFrame() {
        initComponents();
    }
    
    /**
     * Creates new form SzerkesztoJFrame.
     * @param f  Bejelentkezett felhasználó.
     */
    public SzerkesztoJFrame(Felhasznalo f) {
        initComponents();
        beFelh = f;
        kapcsolat = new KapcsolatDB();
        
        temakorokComboBoxokFeltolt();

        // ha nincs saját témaköre a felhasználónak, akkor letiltja a beviteli mezőket és a gombokat
        if (temakorok.isEmpty()) {
            angolTextField.setEnabled(false);
            magyarTextField.setEnabled(false);
            angolTextField.setText("");
            magyarTextField.setText("");
            modositButton.setEnabled(false);
            szoTorlesButton.setEnabled(false);
            szoszedetTorleseTabPanel.setEnabled(false);
        }
    }
    
    /**
     * SzavakCombobox nevű legördülő lista feltöltése.
     */
    public void szavakComboBoxFeltolt() {
        szavak = kapcsolat.szavakAdottTemakorbenLekerdez(temakorok.get(temakorokComboBox.getSelectedIndex()).getId());
        szavakComboBox.removeAllItems();
        for (Szo szo : szavak) {
            szavakComboBox.addItem(szo.getAngol()+" - "+szo.getMagyar());
        }
    }
    
    /**
     * temakorokComboBox és temakorokComboBoxUjSzohoz nevű legördülő listák feltöltése.
     */
    public void temakorokComboBoxokFeltolt() {
        temakorok = kapcsolat.temakorokLekerdez(beFelh);
        
        // a beépített témakörök kivétele, hogy azt ne lehessen szerkeszteni
        Iterator itr = temakorok.iterator();
        while (itr.hasNext()) {
            Temakor t = (Temakor)itr.next();
            if (t.isBeepitett() == true) {
                itr.remove();
            }
        }
               
        // témakör ComboBox-ok feltöltése
        temakorokComboBox.removeAllItems();
        temakorokComboBoxUjSzohoz.removeAllItems();
        temakorokComboBoxSzoszedetTorleshez.removeAllItems();
        for (Temakor t : temakorok) {
            temakorokComboBox.addItem(t.getMegnevezes());
            temakorokComboBoxUjSzohoz.addItem(t.getMegnevezes());
            temakorokComboBoxSzoszedetTorleshez.addItem(t.getMegnevezes());
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

        szerkesztoTabbedPane = new javax.swing.JTabbedPane();
        szavakSzerkeszteseTabPanel = new javax.swing.JPanel();
        szavakSzerkesztesePanel = new javax.swing.JPanel();
        temakorokComboBox = new javax.swing.JComboBox<>();
        szavakComboBox = new javax.swing.JComboBox<>();
        angolTextField = new javax.swing.JTextField();
        magyarTextField = new javax.swing.JTextField();
        modositButton = new javax.swing.JButton();
        szoTorlesButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ujSzoszedetTabPanel = new javax.swing.JPanel();
        ujTemakorPanel = new javax.swing.JPanel();
        ujTemakorTextField = new javax.swing.JTextField();
        temakorLetrehozButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        ujSzoPanel = new javax.swing.JPanel();
        temakorokComboBoxUjSzohoz = new javax.swing.JComboBox<>();
        ujAngolTextField = new javax.swing.JTextField();
        ujMagyarTextField = new javax.swing.JTextField();
        szoHozzaadButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        szoszedetTorleseTabPanel = new javax.swing.JPanel();
        szoszedetTorlesePanel = new javax.swing.JPanel();
        temakorokComboBoxSzoszedetTorleshez = new javax.swing.JComboBox<>();
        szoszedetTorleseButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Szerkesztőnézet");
        setMaximumSize(new java.awt.Dimension(800, 800));
        setMinimumSize(new java.awt.Dimension(800, 800));
        setResizable(false);
        setSize(new java.awt.Dimension(800, 800));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridBagLayout());

        szerkesztoTabbedPane.setFocusable(false);
        szerkesztoTabbedPane.setMaximumSize(new java.awt.Dimension(800, 800));
        szerkesztoTabbedPane.setMinimumSize(new java.awt.Dimension(800, 800));
        szerkesztoTabbedPane.setPreferredSize(new java.awt.Dimension(800, 800));

        szavakSzerkeszteseTabPanel.setFocusable(false);
        szavakSzerkeszteseTabPanel.setLayout(new java.awt.GridBagLayout());

        szavakSzerkesztesePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Szavak szerkesztése", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        szavakSzerkesztesePanel.setLayout(new java.awt.GridBagLayout());

        temakorokComboBox.setBackground(new java.awt.Color(0, 153, 255));
        temakorokComboBox.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        temakorokComboBox.setFocusable(false);
        temakorokComboBox.setMaximumSize(new java.awt.Dimension(200, 35));
        temakorokComboBox.setMinimumSize(new java.awt.Dimension(200, 35));
        temakorokComboBox.setPreferredSize(new java.awt.Dimension(200, 35));
        temakorokComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                temakorokComboBoxItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 25, 0);
        szavakSzerkesztesePanel.add(temakorokComboBox, gridBagConstraints);

        szavakComboBox.setBackground(new java.awt.Color(0, 153, 255));
        szavakComboBox.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        szavakComboBox.setFocusable(false);
        szavakComboBox.setMaximumSize(new java.awt.Dimension(300, 35));
        szavakComboBox.setMinimumSize(new java.awt.Dimension(300, 35));
        szavakComboBox.setPreferredSize(new java.awt.Dimension(300, 35));
        szavakComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                szavakComboBoxItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 25, 0);
        szavakSzerkesztesePanel.add(szavakComboBox, gridBagConstraints);

        angolTextField.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        angolTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        angolTextField.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        angolTextField.setMaximumSize(new java.awt.Dimension(250, 50));
        angolTextField.setMinimumSize(new java.awt.Dimension(250, 50));
        angolTextField.setPreferredSize(new java.awt.Dimension(250, 50));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 25, 25, 0);
        szavakSzerkesztesePanel.add(angolTextField, gridBagConstraints);

        magyarTextField.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        magyarTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        magyarTextField.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        magyarTextField.setMaximumSize(new java.awt.Dimension(250, 50));
        magyarTextField.setMinimumSize(new java.awt.Dimension(250, 50));
        magyarTextField.setPreferredSize(new java.awt.Dimension(250, 50));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 25, 25, 25);
        szavakSzerkesztesePanel.add(magyarTextField, gridBagConstraints);

        modositButton.setBackground(new java.awt.Color(0, 153, 255));
        modositButton.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        modositButton.setForeground(new java.awt.Color(255, 255, 255));
        modositButton.setText("MÓDOSÍT");
        modositButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        modositButton.setFocusable(false);
        modositButton.setMaximumSize(new java.awt.Dimension(125, 50));
        modositButton.setMinimumSize(new java.awt.Dimension(125, 50));
        modositButton.setPreferredSize(new java.awt.Dimension(125, 50));
        modositButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                modositButtonMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 25, 0);
        szavakSzerkesztesePanel.add(modositButton, gridBagConstraints);

        szoTorlesButton.setBackground(new java.awt.Color(255, 0, 0));
        szoTorlesButton.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        szoTorlesButton.setForeground(new java.awt.Color(255, 255, 255));
        szoTorlesButton.setText("TÖRLÉS");
        szoTorlesButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        szoTorlesButton.setFocusable(false);
        szoTorlesButton.setMaximumSize(new java.awt.Dimension(125, 50));
        szoTorlesButton.setMinimumSize(new java.awt.Dimension(125, 50));
        szoTorlesButton.setPreferredSize(new java.awt.Dimension(125, 50));
        szoTorlesButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                szoTorlesButtonMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 25, 0);
        szavakSzerkesztesePanel.add(szoTorlesButton, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Témakör");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(25, 0, 0, 0);
        szavakSzerkesztesePanel.add(jLabel1, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Szó");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        szavakSzerkesztesePanel.add(jLabel2, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Angol");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(0, 25, 0, 0);
        szavakSzerkesztesePanel.add(jLabel3, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Magyar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        szavakSzerkesztesePanel.add(jLabel4, gridBagConstraints);

        szavakSzerkeszteseTabPanel.add(szavakSzerkesztesePanel, new java.awt.GridBagConstraints());

        szerkesztoTabbedPane.addTab("Szavak szerkesztése", szavakSzerkeszteseTabPanel);

        ujSzoszedetTabPanel.setLayout(new java.awt.GridBagLayout());

        ujTemakorPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Új témakör létrehozása", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        ujTemakorPanel.setLayout(new java.awt.GridBagLayout());

        ujTemakorTextField.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        ujTemakorTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ujTemakorTextField.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        ujTemakorTextField.setMaximumSize(new java.awt.Dimension(250, 50));
        ujTemakorTextField.setMinimumSize(new java.awt.Dimension(250, 50));
        ujTemakorTextField.setPreferredSize(new java.awt.Dimension(250, 50));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 25, 25, 0);
        ujTemakorPanel.add(ujTemakorTextField, gridBagConstraints);

        temakorLetrehozButton.setBackground(new java.awt.Color(0, 153, 255));
        temakorLetrehozButton.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        temakorLetrehozButton.setForeground(new java.awt.Color(255, 255, 255));
        temakorLetrehozButton.setText("<html><div text-align:center>TÉMAKÖR<br>LÉTREHOZÁSA</div></html>");
        temakorLetrehozButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        temakorLetrehozButton.setFocusable(false);
        temakorLetrehozButton.setMaximumSize(new java.awt.Dimension(150, 50));
        temakorLetrehozButton.setMinimumSize(new java.awt.Dimension(150, 50));
        temakorLetrehozButton.setPreferredSize(new java.awt.Dimension(150, 50));
        temakorLetrehozButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                temakorLetrehozButtonMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 25, 25, 25);
        ujTemakorPanel.add(temakorLetrehozButton, gridBagConstraints);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Új témakör");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(25, 25, 0, 0);
        ujTemakorPanel.add(jLabel5, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 50, 0);
        ujSzoszedetTabPanel.add(ujTemakorPanel, gridBagConstraints);

        ujSzoPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Új szó hozzáadása", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        ujSzoPanel.setLayout(new java.awt.GridBagLayout());

        temakorokComboBoxUjSzohoz.setBackground(new java.awt.Color(0, 153, 255));
        temakorokComboBoxUjSzohoz.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        temakorokComboBoxUjSzohoz.setFocusable(false);
        temakorokComboBoxUjSzohoz.setMaximumSize(new java.awt.Dimension(200, 35));
        temakorokComboBoxUjSzohoz.setMinimumSize(new java.awt.Dimension(200, 35));
        temakorokComboBoxUjSzohoz.setPreferredSize(new java.awt.Dimension(200, 35));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 25, 0);
        ujSzoPanel.add(temakorokComboBoxUjSzohoz, gridBagConstraints);

        ujAngolTextField.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        ujAngolTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ujAngolTextField.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        ujAngolTextField.setMaximumSize(new java.awt.Dimension(250, 50));
        ujAngolTextField.setMinimumSize(new java.awt.Dimension(250, 50));
        ujAngolTextField.setPreferredSize(new java.awt.Dimension(250, 50));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 25, 25, 0);
        ujSzoPanel.add(ujAngolTextField, gridBagConstraints);

        ujMagyarTextField.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        ujMagyarTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ujMagyarTextField.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        ujMagyarTextField.setMaximumSize(new java.awt.Dimension(250, 50));
        ujMagyarTextField.setMinimumSize(new java.awt.Dimension(250, 50));
        ujMagyarTextField.setPreferredSize(new java.awt.Dimension(250, 50));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 25, 25, 25);
        ujSzoPanel.add(ujMagyarTextField, gridBagConstraints);

        szoHozzaadButton.setBackground(new java.awt.Color(0, 153, 255));
        szoHozzaadButton.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        szoHozzaadButton.setForeground(new java.awt.Color(255, 255, 255));
        szoHozzaadButton.setText("<html><div text-align:center>SZÓ<br>HOZZÁADÁSA</div></html>");
        szoHozzaadButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        szoHozzaadButton.setFocusable(false);
        szoHozzaadButton.setMaximumSize(new java.awt.Dimension(150, 50));
        szoHozzaadButton.setMinimumSize(new java.awt.Dimension(150, 50));
        szoHozzaadButton.setPreferredSize(new java.awt.Dimension(150, 50));
        szoHozzaadButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                szoHozzaadButtonMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 25, 0);
        ujSzoPanel.add(szoHozzaadButton, gridBagConstraints);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Témakör");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(25, 0, 0, 0);
        ujSzoPanel.add(jLabel6, gridBagConstraints);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Angol");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 25, 0, 0);
        ujSzoPanel.add(jLabel7, gridBagConstraints);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Magyar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        ujSzoPanel.add(jLabel8, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        ujSzoszedetTabPanel.add(ujSzoPanel, gridBagConstraints);

        szerkesztoTabbedPane.addTab("Új szószedet hozzáadása", ujSzoszedetTabPanel);

        szoszedetTorleseTabPanel.setLayout(new java.awt.GridBagLayout());

        szoszedetTorlesePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Szószedet törlése", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        szoszedetTorlesePanel.setLayout(new java.awt.GridBagLayout());

        temakorokComboBoxSzoszedetTorleshez.setBackground(new java.awt.Color(0, 153, 255));
        temakorokComboBoxSzoszedetTorleshez.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        temakorokComboBoxSzoszedetTorleshez.setFocusable(false);
        temakorokComboBoxSzoszedetTorleshez.setMaximumSize(new java.awt.Dimension(200, 35));
        temakorokComboBoxSzoszedetTorleshez.setMinimumSize(new java.awt.Dimension(200, 35));
        temakorokComboBoxSzoszedetTorleshez.setPreferredSize(new java.awt.Dimension(200, 35));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(25, 25, 25, 0);
        szoszedetTorlesePanel.add(temakorokComboBoxSzoszedetTorleshez, gridBagConstraints);

        szoszedetTorleseButton.setBackground(new java.awt.Color(255, 0, 0));
        szoszedetTorleseButton.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        szoszedetTorleseButton.setForeground(new java.awt.Color(255, 255, 255));
        szoszedetTorleseButton.setText("TÖRLÉS");
        szoszedetTorleseButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        szoszedetTorleseButton.setFocusable(false);
        szoszedetTorleseButton.setMaximumSize(new java.awt.Dimension(125, 50));
        szoszedetTorleseButton.setMinimumSize(new java.awt.Dimension(125, 50));
        szoszedetTorleseButton.setPreferredSize(new java.awt.Dimension(125, 50));
        szoszedetTorleseButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                szoszedetTorleseButtonMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(25, 25, 25, 25);
        szoszedetTorlesePanel.add(szoszedetTorleseButton, gridBagConstraints);

        szoszedetTorleseTabPanel.add(szoszedetTorlesePanel, new java.awt.GridBagConstraints());

        szerkesztoTabbedPane.addTab("Szószedet törlése", szoszedetTorleseTabPanel);

        getContentPane().add(szerkesztoTabbedPane, new java.awt.GridBagConstraints());

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        MenuJFrame menu = new MenuJFrame(beFelh);
        menu.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    private void temakorokComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_temakorokComboBoxItemStateChanged
        if (temakorokComboBox.getItemCount() > 0) { // ha a témakörök ComboBoxban van elem, akkor a szavak ComboBox-ot feltölti az adott kategória szavaival
            szavakComboBoxFeltolt();
            if (szavakComboBox.getItemCount() == 0) { // ha a szavak ComboBoxban nincs elem, akkor letiltja a beviteli mezőket és a gombokat
                angolTextField.setEnabled(false);
                magyarTextField.setEnabled(false);
                angolTextField.setText("");
                magyarTextField.setText("");
                modositButton.setEnabled(false);
                szoTorlesButton.setEnabled(false);
                szoszedetTorleseTabPanel.setEnabled(false);
            }
        }
    }//GEN-LAST:event_temakorokComboBoxItemStateChanged

    private void szavakComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_szavakComboBoxItemStateChanged
        if (szavakComboBox.getItemCount() == 0) {
            angolTextField.setEnabled(false);
            magyarTextField.setEnabled(false);
            angolTextField.setText("");
            magyarTextField.setText("");
            modositButton.setEnabled(false);
            szoTorlesButton.setEnabled(false);
        } else {
            angolTextField.setEnabled(true);
            magyarTextField.setEnabled(true);
            modositButton.setEnabled(true);
            szoTorlesButton.setEnabled(true);
            angolTextField.setText(szavak.get(szavakComboBox.getSelectedIndex()).getAngol());
            magyarTextField.setText(szavak.get(szavakComboBox.getSelectedIndex()).getMagyar());
        }
    }//GEN-LAST:event_szavakComboBoxItemStateChanged

    private void modositButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modositButtonMouseClicked
        if (szavakComboBox.getSelectedIndex() != -1) {
            kapcsolat.szotModosit(szavak.get(szavakComboBox.getSelectedIndex()).getId(), angolTextField.getText(), magyarTextField.getText());
            szavakComboBoxFeltolt();
        }
    }//GEN-LAST:event_modositButtonMouseClicked

    private void szoTorlesButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_szoTorlesButtonMouseClicked
        if (szavakComboBox.getSelectedIndex() != -1) {
            kapcsolat.szoTorles(szavak.get(szavakComboBox.getSelectedIndex()).getId());
            szavakComboBoxFeltolt();
        }
    }//GEN-LAST:event_szoTorlesButtonMouseClicked

    private void szoHozzaadButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_szoHozzaadButtonMouseClicked
        String ujAngol = ujAngolTextField.getText();
        String ujMagyar = ujMagyarTextField.getText();
        if (ujAngol.isEmpty() || ujMagyar.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Adja meg az új témakör nevét!", "Hiba", JOptionPane.ERROR_MESSAGE);
        } else {
            kapcsolat.ujSzo(temakorok.get(temakorokComboBoxUjSzohoz.getSelectedIndex()).getId(), ujAngol, ujMagyar);
        }
        ujAngolTextField.setText("");
        ujMagyarTextField.setText("");
        szavakComboBoxFeltolt();
    }//GEN-LAST:event_szoHozzaadButtonMouseClicked

    private void temakorLetrehozButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_temakorLetrehozButtonMouseClicked
        String ujTemakor = ujTemakorTextField.getText();
        if (ujTemakor.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Adja meg az új témakör nevét!", "Új témakör létrehozása", JOptionPane.ERROR_MESSAGE);
        } else {
            kapcsolat.ujTemakor(beFelh.getId(), ujTemakor);
        }
        ujTemakorTextField.setText("");
        temakorokComboBoxokFeltolt();
        szavakComboBoxFeltolt();
    }//GEN-LAST:event_temakorLetrehozButtonMouseClicked

    private void szoszedetTorleseButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_szoszedetTorleseButtonMouseClicked
        kapcsolat.szoszedetTorlese(temakorok.get(temakorokComboBoxSzoszedetTorleshez.getSelectedIndex()).getId());
        temakorokComboBoxokFeltolt();
        if (szavakComboBox.getItemCount() > 0) {
            szavakComboBoxFeltolt();
        }
    }//GEN-LAST:event_szoszedetTorleseButtonMouseClicked

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
            java.util.logging.Logger.getLogger(SzerkesztoJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SzerkesztoJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SzerkesztoJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SzerkesztoJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SzerkesztoJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField angolTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField magyarTextField;
    private javax.swing.JButton modositButton;
    private javax.swing.JComboBox<String> szavakComboBox;
    private javax.swing.JPanel szavakSzerkesztesePanel;
    private javax.swing.JPanel szavakSzerkeszteseTabPanel;
    private javax.swing.JTabbedPane szerkesztoTabbedPane;
    private javax.swing.JButton szoHozzaadButton;
    private javax.swing.JButton szoTorlesButton;
    private javax.swing.JButton szoszedetTorleseButton;
    private javax.swing.JPanel szoszedetTorlesePanel;
    private javax.swing.JPanel szoszedetTorleseTabPanel;
    private javax.swing.JButton temakorLetrehozButton;
    private javax.swing.JComboBox<String> temakorokComboBox;
    private javax.swing.JComboBox<String> temakorokComboBoxSzoszedetTorleshez;
    private javax.swing.JComboBox<String> temakorokComboBoxUjSzohoz;
    private javax.swing.JTextField ujAngolTextField;
    private javax.swing.JTextField ujMagyarTextField;
    private javax.swing.JPanel ujSzoPanel;
    private javax.swing.JPanel ujSzoszedetTabPanel;
    private javax.swing.JPanel ujTemakorPanel;
    private javax.swing.JTextField ujTemakorTextField;
    // End of variables declaration//GEN-END:variables
}
