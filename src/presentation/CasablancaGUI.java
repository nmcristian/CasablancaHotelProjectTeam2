package presentation;

import domain.Controller;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;

/**
 *
 * @author Cristian
 */
public class CasablancaGUI extends javax.swing.JFrame
{

    private Controller controller;
    private JFrame reservationForm;
    private boolean datesNotChanged;

    public CasablancaGUI()
    {
        controller = Controller.getInstance();
        initComponents();
        initializeLoginScreen();
        reservationForm = null;
        datesNotChanged = false;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jLoginDetailsLayeredPane = new javax.swing.JLayeredPane();
        jTitleLabel = new javax.swing.JLabel();
        jConnectionLabel = new javax.swing.JLabel();
        jUsernameLabel = new javax.swing.JLabel();
        jPasswordLabel = new javax.swing.JLabel();
        jConnectionField = new javax.swing.JTextField();
        jUsernameField = new javax.swing.JTextField();
        jPasswordField = new javax.swing.JPasswordField();
        jRememberCheckBox = new javax.swing.JCheckBox();
        jConnectButton = new javax.swing.JButton();
        jLogLabel = new javax.swing.JLabel();
        jPresentationLayeredPane = new javax.swing.JLayeredPane();
        jLogLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jSearchButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jXDatePicker1 = new org.jdesktop.swingx.JXDatePicker();
        jXDatePicker2 = new org.jdesktop.swingx.JXDatePicker();
        jComboBox3 = new javax.swing.JComboBox();
        jComboBox4 = new javax.swing.JComboBox();
        jPanelDetails = new javax.swing.JPanel();
        jButtonAddToReservation = new javax.swing.JButton();
        jButtonEdit = new javax.swing.JButton();
        jLabel101 = new javax.swing.JLabel();
        jTextField101 = new javax.swing.JTextField();
        jLabel102 = new javax.swing.JLabel();
        jTextField102 = new javax.swing.JTextField();
        jLabel103 = new javax.swing.JLabel();
        jTextField103 = new javax.swing.JTextField();
        jLabel104 = new javax.swing.JLabel();
        jTextField104 = new javax.swing.JTextField();
        jLabel105 = new javax.swing.JLabel();
        jTextField105 = new javax.swing.JTextField();
        jLabel106 = new javax.swing.JLabel();
        jTextField106 = new javax.swing.JTextField();
        jLabel107 = new javax.swing.JLabel();
        jLabel108 = new javax.swing.JLabel();
        jTextField107 = new javax.swing.JTextField();
        jTextField108 = new javax.swing.JTextField();
        jLabel109 = new javax.swing.JLabel();
        jTextField109 = new javax.swing.JTextField();
        jLabel110 = new javax.swing.JLabel();
        jTextField110 = new javax.swing.JTextField();
        jMenuBar = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Casablanca Hotel");
        setResizable(false);
        addWindowFocusListener(new java.awt.event.WindowFocusListener()
        {
            public void windowGainedFocus(java.awt.event.WindowEvent evt)
            {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt)
            {
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter()
        {
            public void windowClosing(java.awt.event.WindowEvent evt)
            {
                formWindowClosing(evt);
            }
        });
        addComponentListener(new java.awt.event.ComponentAdapter()
        {
            public void componentMoved(java.awt.event.ComponentEvent evt)
            {
                formComponentMoved(evt);
            }
        });

        jLoginDetailsLayeredPane.setRequestFocusEnabled(false);

        jTitleLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jTitleLabel.setText("User login");

        jConnectionLabel.setText("Connection:");

        jUsernameLabel.setText("Username:");

        jPasswordLabel.setText("Password:");

        jConnectionField.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                jConnectionFieldKeyPressed(evt);
            }
        });

        jUsernameField.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                jUsernameFieldKeyPressed(evt);
            }
        });

        jPasswordField.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                jPasswordFieldKeyPressed(evt);
            }
        });

        jRememberCheckBox.setText("Remember username & password");

        jConnectButton.setText("Connect");
        jConnectButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jConnectButtonActionPerformed(evt);
            }
        });

        jLogLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        javax.swing.GroupLayout jLoginDetailsLayeredPaneLayout = new javax.swing.GroupLayout(jLoginDetailsLayeredPane);
        jLoginDetailsLayeredPane.setLayout(jLoginDetailsLayeredPaneLayout);
        jLoginDetailsLayeredPaneLayout.setHorizontalGroup(
            jLoginDetailsLayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLoginDetailsLayeredPaneLayout.createSequentialGroup()
                .addGroup(jLoginDetailsLayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLoginDetailsLayeredPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLogLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jLoginDetailsLayeredPaneLayout.createSequentialGroup()
                        .addGap(272, 272, 272)
                        .addGroup(jLoginDetailsLayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jLoginDetailsLayeredPaneLayout.createSequentialGroup()
                                .addComponent(jRememberCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jConnectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jLoginDetailsLayeredPaneLayout.createSequentialGroup()
                                .addGroup(jLoginDetailsLayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jPasswordLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jConnectionLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                                    .addComponent(jUsernameLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jLoginDetailsLayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jConnectionField, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                                    .addComponent(jPasswordField)
                                    .addComponent(jUsernameField, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)))
                            .addComponent(jTitleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 274, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jLoginDetailsLayeredPaneLayout.setVerticalGroup(
            jLoginDetailsLayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLoginDetailsLayeredPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jLoginDetailsLayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jConnectionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jConnectionField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jLoginDetailsLayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jUsernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jUsernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jLoginDetailsLayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPasswordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jLoginDetailsLayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRememberCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jConnectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 220, Short.MAX_VALUE)
                .addComponent(jLogLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jLoginDetailsLayeredPane.setLayer(jTitleLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLoginDetailsLayeredPane.setLayer(jConnectionLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLoginDetailsLayeredPane.setLayer(jUsernameLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLoginDetailsLayeredPane.setLayer(jPasswordLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLoginDetailsLayeredPane.setLayer(jConnectionField, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLoginDetailsLayeredPane.setLayer(jUsernameField, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLoginDetailsLayeredPane.setLayer(jPasswordField, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLoginDetailsLayeredPane.setLayer(jRememberCheckBox, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLoginDetailsLayeredPane.setLayer(jConnectButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLoginDetailsLayeredPane.setLayer(jLogLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Action:");

        jComboBox1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Search criteria:");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("From:");

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyReleased(java.awt.event.KeyEvent evt)
            {
                jTextField1KeyReleased(evt);
            }
        });

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("To:");

        jSearchButton.setText("Search");
        jSearchButton.setPreferredSize(new java.awt.Dimension(65, 25));
        jSearchButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jSearchButtonActionPerformed(evt);
            }
        });

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {

            }
        ));
        jTable1.setName(""); // NOI18N
        jTable1.setRowHeight(20);
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseReleased(java.awt.event.MouseEvent evt)
            {
                jTable1MouseReleased(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyReleased(java.awt.event.KeyEvent evt)
            {
                jTable1KeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Quick search:");

        jXDatePicker1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jXDatePicker1ActionPerformed(evt);
            }
        });

        jXDatePicker2.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jXDatePicker2ActionPerformed(evt);
            }
        });

        jComboBox3.setMaximumRowCount(13);
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00:00", "01:00", "02:00", "03:00", "04:00", "05:00", "06:00", "07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00" }));
        jComboBox3.setMinimumSize(new java.awt.Dimension(60, 25));
        jComboBox3.setName(""); // NOI18N
        jComboBox3.setPreferredSize(new java.awt.Dimension(60, 25));

        jComboBox4.setMaximumRowCount(13);
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00:00", "01:00", "02:00", "03:00", "04:00", "05:00", "06:00", "07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00" }));
        jComboBox4.setMinimumSize(new java.awt.Dimension(60, 25));
        jComboBox4.setPreferredSize(new java.awt.Dimension(60, 25));

        jButtonAddToReservation.setText("Add to reservation");
        jButtonAddToReservation.setPreferredSize(new java.awt.Dimension(65, 25));
        jButtonAddToReservation.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButtonAddToReservationActionPerformed(evt);
            }
        });

        jButtonEdit.setText("Edit details");
        jButtonEdit.setPreferredSize(new java.awt.Dimension(65, 25));
        jButtonEdit.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButtonEditActionPerformed(evt);
            }
        });

        jLabel101.setText("jLabel101");

        jTextField101.setEditable(false);
        jTextField101.setText("jTextField2");

        jLabel102.setText("jLabel102");

        jTextField102.setEditable(false);
        jTextField102.setText("jTextField2");

        jLabel103.setText("jLabel103");

        jTextField103.setEditable(false);
        jTextField103.setText("jTextField2");

        jLabel104.setText("jLabel104");

        jTextField104.setEditable(false);
        jTextField104.setText("jTextField2");

        jLabel105.setText("jLabel105");

        jTextField105.setEditable(false);
        jTextField105.setText("jTextField2");

        jLabel106.setText("jLabel106");

        jTextField106.setEditable(false);
        jTextField106.setText("jTextField2");

        jLabel107.setText("jLabel107");

        jLabel108.setText("jLabel108");

        jTextField107.setEditable(false);
        jTextField107.setText("jTextField2");

        jTextField108.setEditable(false);
        jTextField108.setText("jTextField2");

        jLabel109.setText("jLabel109");

        jTextField109.setEditable(false);
        jTextField109.setText("jTextField2");

        jLabel110.setText("jLabel110");

        jTextField110.setEditable(false);
        jTextField110.setText("jTextField2");

        javax.swing.GroupLayout jPanelDetailsLayout = new javax.swing.GroupLayout(jPanelDetails);
        jPanelDetails.setLayout(jPanelDetailsLayout);
        jPanelDetailsLayout.setHorizontalGroup(
            jPanelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDetailsLayout.createSequentialGroup()
                .addGroup(jPanelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDetailsLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonAddToReservation, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelDetailsLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelDetailsLayout.createSequentialGroup()
                                .addComponent(jLabel102)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField102))
                            .addGroup(jPanelDetailsLayout.createSequentialGroup()
                                .addComponent(jLabel101)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField101))
                            .addGroup(jPanelDetailsLayout.createSequentialGroup()
                                .addComponent(jLabel103)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField103))
                            .addGroup(jPanelDetailsLayout.createSequentialGroup()
                                .addComponent(jLabel105)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField105))
                            .addGroup(jPanelDetailsLayout.createSequentialGroup()
                                .addComponent(jLabel104)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField104))
                            .addGroup(jPanelDetailsLayout.createSequentialGroup()
                                .addComponent(jLabel106)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField106))
                            .addGroup(jPanelDetailsLayout.createSequentialGroup()
                                .addComponent(jLabel108)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField107))
                            .addGroup(jPanelDetailsLayout.createSequentialGroup()
                                .addComponent(jLabel107)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField108))
                            .addGroup(jPanelDetailsLayout.createSequentialGroup()
                                .addComponent(jLabel109)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField109))
                            .addGroup(jPanelDetailsLayout.createSequentialGroup()
                                .addComponent(jLabel110)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField110)))))
                .addContainerGap())
        );
        jPanelDetailsLayout.setVerticalGroup(
            jPanelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDetailsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel101)
                    .addComponent(jTextField101, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel102)
                    .addComponent(jTextField102, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel103)
                    .addComponent(jTextField103, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel104)
                    .addComponent(jTextField104, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel105)
                    .addComponent(jTextField105, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel106)
                    .addComponent(jTextField106, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel107)
                    .addComponent(jTextField108, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel108)
                    .addComponent(jTextField107, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel109)
                    .addComponent(jTextField109, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel110)
                    .addComponent(jTextField110, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAddToReservation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPresentationLayeredPaneLayout = new javax.swing.GroupLayout(jPresentationLayeredPane);
        jPresentationLayeredPane.setLayout(jPresentationLayeredPaneLayout);
        jPresentationLayeredPaneLayout.setHorizontalGroup(
            jPresentationLayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPresentationLayeredPaneLayout.createSequentialGroup()
                .addGroup(jPresentationLayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPresentationLayeredPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPresentationLayeredPaneLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLogLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPresentationLayeredPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPresentationLayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPresentationLayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPresentationLayeredPaneLayout.createSequentialGroup()
                                .addGroup(jPresentationLayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jComboBox1, 0, 170, Short.MAX_VALUE)
                                    .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPresentationLayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPresentationLayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPresentationLayeredPaneLayout.createSequentialGroup()
                                        .addComponent(jXDatePicker2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPresentationLayeredPaneLayout.createSequentialGroup()
                                        .addComponent(jXDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPresentationLayeredPaneLayout.createSequentialGroup()
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jSearchButton, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(40, 40, 40)
                .addComponent(jPanelDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        jPresentationLayeredPaneLayout.setVerticalGroup(
            jPresentationLayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPresentationLayeredPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPresentationLayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPresentationLayeredPaneLayout.createSequentialGroup()
                        .addGroup(jPresentationLayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jXDatePicker1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPresentationLayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jXDatePicker2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPresentationLayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSearchButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanelDetails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLogLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPresentationLayeredPane.setLayer(jLogLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jPresentationLayeredPane.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jPresentationLayeredPane.setLayer(jComboBox1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jPresentationLayeredPane.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jPresentationLayeredPane.setLayer(jComboBox2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jPresentationLayeredPane.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jPresentationLayeredPane.setLayer(jTextField1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jPresentationLayeredPane.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jPresentationLayeredPane.setLayer(jSearchButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jPresentationLayeredPane.setLayer(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jPresentationLayeredPane.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jPresentationLayeredPane.setLayer(jXDatePicker1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jPresentationLayeredPane.setLayer(jXDatePicker2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jPresentationLayeredPane.setLayer(jComboBox3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jPresentationLayeredPane.setLayer(jComboBox4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jPresentationLayeredPane.setLayer(jPanelDetails, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jMenuBar.setPreferredSize(new java.awt.Dimension(300, 20));

        jMenu1.setText("Options");

        jMenuItem1.setText("Log in");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Exit");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar.add(jMenu1);

        jMenu2.setText("Settings");

        jMenuItem3.setText("Connection");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuBar.add(jMenu2);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLoginDetailsLayeredPane)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPresentationLayeredPane))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLoginDetailsLayeredPane)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPresentationLayeredPane))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void initializeLoginScreen()
    {
        jPresentationLayeredPane.setVisible(false);
        jLoginDetailsLayeredPane.setVisible(true);
        jConnectionLabel.setVisible(false);
        jConnectionField.setVisible(false);
        jRememberCheckBox.setVisible(true);
        jConnectButton.setText("Connect");
        jTitleLabel.setText("User login");
        jMenuItem1.setText("Log in");
        jMenuItem1.setEnabled(false);
        jMenuItem3.setEnabled(true);
        jMenu2.setVisible(true);
        jLogLabel.setText(null);
        if (controller.getRememberPreferencesState())
        {
            jRememberCheckBox.setSelected(true);
            jUsernameField.setText(controller.getUsername());
            jPasswordField.setText(controller.getPassword());
        } else
        {
            jRememberCheckBox.setSelected(false);
            jUsernameField.setText(null);
            jPasswordField.setText(null);
        }
    }

    private void initializeConnectionSettingsScreen()
    {
        jPresentationLayeredPane.setVisible(false);
        jLoginDetailsLayeredPane.setVisible(true);
        jConnectionField.setText(null);
        jUsernameField.setText(null);
        jPasswordField.setText(null);
        jConnectionLabel.setVisible(true);
        jConnectionField.setVisible(true);
        jRememberCheckBox.setVisible(false);
        jConnectButton.setText("Save");
        jTitleLabel.setText("Connection settings");
        jMenuItem1.setText("Log in");
        jMenuItem1.setEnabled(true);
        jMenuItem3.setEnabled(false);
        jLogLabel.setText(null);
    }

    private void initializePresentationScreen()
    {
        jLoginDetailsLayeredPane.setVisible(false);
        jPresentationLayeredPane.setVisible(true);
        jMenuItem1.setText("Log out");
        jMenuItem1.setEnabled(true);
        jMenuItem3.setEnabled(false);
        jLogLabel2.setForeground(Color.black);
        jLogLabel2.setText("Connected as " + controller.getUserType());
        jTable1.setModel(new CustomTableModel(new Object[][]
        {
        }, new String[]
        {
        }));
        jSearchButton.setEnabled(false);
        jButtonAddToReservation.setEnabled(false);
        jButtonEdit.setEnabled(false);
        setupActionComboBox(controller.getUserType());
        jXDatePicker1.getMonthView().setLowerBound(new Date(System.currentTimeMillis()));
        jXDatePicker2.getMonthView().setLowerBound(new Date(System.currentTimeMillis() + 86400000));
    }

    private void setupActionComboBox(String userType)
    {
        String[] actionComboBoxItems = null;
        switch (userType)
        {
            case "Receptionist":
                actionComboBoxItems = new String[8];
                actionComboBoxItems[0] = "Create reservation";
                actionComboBoxItems[1] = "List rooms";
                actionComboBoxItems[2] = "List clients";
                actionComboBoxItems[3] = "List reservations";
                actionComboBoxItems[4] = "List facility reservations";
                actionComboBoxItems[5] = "List facilities";
                actionComboBoxItems[6] = "List room types";
                actionComboBoxItems[7] = "List employees";
                break;
            case "Client":
                actionComboBoxItems = new String[2];
                actionComboBoxItems[0] = "List facilities";
                actionComboBoxItems[1] = "List facility reservations";
                break;
        }

        jComboBox1.setModel(new DefaultComboBoxModel(actionComboBoxItems));
        jComboBox1.setSelectedIndex(-1);
    }

    private void setupCriteriaComboBox(String userType, String actionType)
    {
        String[] criteriaComboBoxItems;
        switch (userType)
        {
            case "Receptionist":
                switch (actionType)
                {
                    case "List rooms":
                        criteriaComboBoxItems = new String[3];
                        criteriaComboBoxItems[0] = "Show all";
                        criteriaComboBoxItems[1] = "by availability";
                        criteriaComboBoxItems[2] = "by room number";
                        break;
                    case "List clients":
                        criteriaComboBoxItems = new String[3];
                        criteriaComboBoxItems[0] = "Show all";
                        criteriaComboBoxItems[1] = "by client ID";
                        criteriaComboBoxItems[2] = "by client name";
                        break;
                    case "List reservations":
                        criteriaComboBoxItems = new String[4];
                        criteriaComboBoxItems[0] = "Show all";
                        criteriaComboBoxItems[1] = "by client ID";
                        criteriaComboBoxItems[2] = "by reservation ID";
                        criteriaComboBoxItems[3] = "by room ID";
                        break;
                    case "List facility reservations":
                        criteriaComboBoxItems = new String[5];
                        criteriaComboBoxItems[0] = "Show all";
                        criteriaComboBoxItems[1] = "by client ID";
                        criteriaComboBoxItems[2] = "by client name";
                        criteriaComboBoxItems[3] = "by reservation ID";
                        criteriaComboBoxItems[4] = "by facility title";
                        break;
                    case "List employees":
                        criteriaComboBoxItems = new String[4];
                        criteriaComboBoxItems[0] = "Show all";
                        criteriaComboBoxItems[1] = "by employee ID";
                        criteriaComboBoxItems[2] = "by employee name";
                        criteriaComboBoxItems[3] = "by employee position";
                        break;
                    case "List facilities":
                        criteriaComboBoxItems = new String[1];
                        criteriaComboBoxItems[0] = "Show all";
                        break;
                    case "List room types":
                        criteriaComboBoxItems = new String[1];
                        criteriaComboBoxItems[0] = "Show all";
                        break;

                    default:
                        criteriaComboBoxItems = new String[]
                        {
                        };
                }
                break;
            case "Client":
                switch (actionType)
                {
                    case "List facilities":
                        criteriaComboBoxItems = new String[1];
                        criteriaComboBoxItems[0] = "Show all";
                        break;
                    case "List facility reservations":
                        criteriaComboBoxItems = new String[2];
                        criteriaComboBoxItems[0] = "Show all";
                        criteriaComboBoxItems[1] = "by client ID";
                        break;
                    default:
                        criteriaComboBoxItems = new String[]
                        {
                        };
                }
                break;
            default:
                criteriaComboBoxItems = new String[]
                {
                };
        }

        jComboBox2.setModel(new DefaultComboBoxModel(criteriaComboBoxItems));
    }

    private void jConnectButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jConnectButtonActionPerformed
    {//GEN-HEADEREND:event_jConnectButtonActionPerformed
        if (jConnectButton.getText().equals("Connect"))
        {
            controller.setRememberPreferencesState(jRememberCheckBox.isSelected());
            if (jRememberCheckBox.isSelected())
            {
                controller.setUsername(jUsernameField.getText());
                controller.setPassword(jPasswordField.getText());
            }
            jLogLabel.setForeground(Color.black);
            jLogLabel.setText("Connecting...");
            if (controller.connect())
            {
                if (controller.checkUserLogin())
                {
                    jLogLabel.setForeground(Color.green);
                    jLogLabel.setText("Connected!");
                    initializePresentationScreen();
                } else
                {
                    jLogLabel.setForeground(Color.red);
                    jLogLabel.setText("Wrong username/password!");
                }
            } else
            {
                jLogLabel.setForeground(Color.red);
                jLogLabel.setText("Database connection error!");
            }
        } else
        {
            jLogLabel.setForeground(Color.green);
            jLogLabel.setText("Saved!");
            controller.setDbHost(jConnectionField.getText());
            controller.setDbUsername(jUsernameField.getText());
            controller.setDbPassword(jPasswordField.getText());
        }
    }//GEN-LAST:event_jConnectButtonActionPerformed

    private void jConnectionFieldKeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_jConnectionFieldKeyPressed
    {//GEN-HEADEREND:event_jConnectionFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            jUsernameField.requestFocus();
        }
    }//GEN-LAST:event_jConnectionFieldKeyPressed

    private void jPasswordFieldKeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_jPasswordFieldKeyPressed
    {//GEN-HEADEREND:event_jPasswordFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            jConnectButton.doClick();
        }
    }//GEN-LAST:event_jPasswordFieldKeyPressed

    private void jUsernameFieldKeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_jUsernameFieldKeyPressed
    {//GEN-HEADEREND:event_jUsernameFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            jPasswordField.requestFocus();
        }
    }//GEN-LAST:event_jUsernameFieldKeyPressed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jMenuItem3ActionPerformed
    {//GEN-HEADEREND:event_jMenuItem3ActionPerformed
        initializeConnectionSettingsScreen();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jMenuItem1ActionPerformed
    {//GEN-HEADEREND:event_jMenuItem1ActionPerformed
        if (jMenuItem1.getText().equals("Log out"))
        {
            jLogLabel2.setForeground(Color.black);
            jLogLabel2.setText("Disconnecting...");
            if (controller.disconnect())
            {
                jLogLabel2.setForeground(Color.green);
                jLogLabel2.setText("Disconnected!");
                if (controller.currentReservationCreationState())
                {
                    controller.discardNewReservation();
                    reservationForm.dispose();
                }
                initializeLoginScreen();
            } else
            {
                jLogLabel2.setForeground(Color.red);
                jLogLabel2.setText("Disconnecting error!");
            }
        } else
        {
            initializeLoginScreen();
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jMenuItem2ActionPerformed
    {//GEN-HEADEREND:event_jMenuItem2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt)//GEN-FIRST:event_formWindowClosing
    {//GEN-HEADEREND:event_formWindowClosing
        controller.savePreferences();
    }//GEN-LAST:event_formWindowClosing

    private void formComponentMoved(java.awt.event.ComponentEvent evt)//GEN-FIRST:event_formComponentMoved
    {//GEN-HEADEREND:event_formComponentMoved
        if (controller.currentReservationCreationState())
        {
            reservationForm.setLocation((int) (this.getLocation().getX() + this.getSize().getWidth() + 10), (int) (this.getLocation().getY()));
        }
    }//GEN-LAST:event_formComponentMoved

    protected void refreshTableInfo()
    {
        switch (controller.getSearchResultType())
        {
            case "Rooms":
            {
                if (controller.getLastSearchFrom() != null && controller.getLastSearchTo() != null)
                {
                    jTable1.setModel(new CustomTableModel(controller.getRoomsByAvailability(controller.getLastSearchFrom(), controller.getLastSearchTo()), controller.getTableColumnNames()));
                }
                break;
            }
            case "Clients":
            {
                jTable1.setModel(new CustomTableModel(controller.getAllClients(), controller.getTableColumnNames()));
                break;
            }

            default:
            {
                //do nothing
            }
        }
    }

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt)//GEN-FIRST:event_formWindowGainedFocus
    {//GEN-HEADEREND:event_formWindowGainedFocus
        if (controller.getSearchResultCount() != jTable1.getRowCount())
        {
            refreshTableInfo();
        }
    }//GEN-LAST:event_formWindowGainedFocus

    private void jButtonAddToReservationActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonAddToReservationActionPerformed
    {//GEN-HEADEREND:event_jButtonAddToReservationActionPerformed
        if (jTable1.getSelectedRow() != -1)
        {
            switch (controller.getSearchResultType())
            {
                case "Rooms":
                    int roomNumber = 0;
                    for (int i = 0; i < jTable1.getColumnCount(); i++)
                    {
                        if (jTable1.getColumnName(i).equals("Room number"))
                        {
                            roomNumber = Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), i).toString());
                            break;
                        }
                    }
                    controller.addRoomToReservation(roomNumber);
                    jTable1.setModel(new CustomTableModel(controller.getRoomsByAvailability(controller.getLastSearchFrom(), controller.getLastSearchTo()), controller.getTableColumnNames()));
                    jButtonAddToReservation.setEnabled(false);
                    reservationForm.requestFocus();
                    break;
                case "Clients":
                    long clientID = 0;
                    for (int i = 0; i < jTable1.getColumnCount(); i++)
                    {
                        if (jTable1.getColumnName(i).equals("Client ID"))
                        {
                            clientID = Long.parseLong(jTable1.getValueAt(jTable1.getSelectedRow(), i).toString());
                            break;
                        }
                    }
                    controller.addClientToReservation(clientID);
                    jTable1.setModel(new CustomTableModel(controller.getAllClients(), controller.getTableColumnNames()));
                    jButtonAddToReservation.setEnabled(false);
                    reservationForm.requestFocus();
                    break;
                default:
                {
                    //do nothing
                }
            }
        }
    }//GEN-LAST:event_jButtonAddToReservationActionPerformed

    private void jXDatePicker2ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jXDatePicker2ActionPerformed
    {//GEN-HEADEREND:event_jXDatePicker2ActionPerformed
        if (jXDatePicker2.getDate() != null)
        {
            if (jXDatePicker2.getDate() != controller.getLastSearchTo())
            {
                datesNotChanged = false;
                jButtonAddToReservation.setEnabled(false);
            }
        }
    }//GEN-LAST:event_jXDatePicker2ActionPerformed

    private void jXDatePicker1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jXDatePicker1ActionPerformed
    {//GEN-HEADEREND:event_jXDatePicker1ActionPerformed
        if (jXDatePicker1.getDate() != null)
        {
            jXDatePicker2.getMonthView().setLowerBound(new Date(jXDatePicker1.getDate().getTime() + 86400000));
            if (jXDatePicker1.getDate() != controller.getLastSearchFrom())
            {
                datesNotChanged = false;
                jButtonAddToReservation.setEnabled(false);
            }
        }
        //        jTable1.getSelectionModel().clearSelection();
    }//GEN-LAST:event_jXDatePicker1ActionPerformed

    private void jTable1KeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_jTable1KeyReleased
    {//GEN-HEADEREND:event_jTable1KeyReleased
        //        if (evt.getKeyCode() == KeyEvent.VK_UP || evt.getKeyCode() == KeyEvent.VK_DOWN)
//        {
        if (jTable1.getSelectedRow() != -1)
        {
            Object[][] detailsSet;
            switch (controller.getSearchResultType())
            {
                case "Rooms":
                    int roomNumber = 0;
                    for (int i = 0; i < jTable1.getColumnCount(); i++)
                    {
                        if (jTable1.getColumnName(i).equals("Room number"))
                        {
                            roomNumber = Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), i).toString());
                            detailsSet = controller.getRoomByRoomNumber(roomNumber);

                            jLabel101.setVisible(true);
                            jLabel102.setVisible(true);
                            jLabel103.setVisible(true);
                            jLabel104.setVisible(true);

                            jLabel101.setText("Room number");
                            jLabel102.setText("Room type");
                            jLabel103.setText("Capacity");
                            jLabel104.setText("Price/night");

                            jTextField101.setVisible(true);
                            jTextField102.setVisible(true);
                            jTextField103.setVisible(true);
                            jTextField104.setVisible(true);

                            jTextField101.setText(detailsSet[0][0].toString());
                            jTextField102.setText(detailsSet[0][1].toString());
                            jTextField103.setText(detailsSet[0][2].toString());
                            jTextField104.setText(detailsSet[0][3].toString());

                            jLabel105.setVisible(false);
                            jLabel106.setVisible(false);
                            jLabel107.setVisible(false);
                            jLabel108.setVisible(false);
                            jLabel109.setVisible(false);
                            jLabel110.setVisible(false);

                            jTextField105.setVisible(false);
                            jTextField106.setVisible(false);
                            jTextField107.setVisible(false);
                            jTextField108.setVisible(false);
                            jTextField109.setVisible(false);
                            jTextField110.setVisible(false);

                            break;
                        }
                    }
                case "":
                    break;
            }
        }
//        }
    }//GEN-LAST:event_jTable1KeyReleased

    private void jTable1MouseReleased(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jTable1MouseReleased
    {//GEN-HEADEREND:event_jTable1MouseReleased
        if (jTable1.getSelectedRow() != -1)
        {
            Object[][] detailsSet;

            switch (controller.getSearchResultType())
            {
                case "Rooms":
                {
                    int roomNumber = 0;
                    for (int i = 0; i < jTable1.getColumnCount(); i++)
                    {
                        if (jTable1.getColumnName(i).equals("Room number"))
                        {
                            roomNumber = Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), i).toString());
                            detailsSet = controller.getRoomByRoomNumber(roomNumber);
                            jButtonEdit.setEnabled(true);

                            jLabel101.setVisible(true);
                            jLabel102.setVisible(true);
                            jLabel103.setVisible(true);
                            jLabel104.setVisible(true);

                            jLabel101.setText("Room number");
                            jLabel102.setText("Room type");
                            jLabel103.setText("Capacity");
                            jLabel104.setText("Price/night");

                            jTextField101.setVisible(true);
                            jTextField102.setVisible(true);
                            jTextField103.setVisible(true);
                            jTextField104.setVisible(true);

                            jTextField101.setText(detailsSet[0][0].toString());
                            jTextField102.setText(detailsSet[0][1].toString());
                            jTextField103.setText(detailsSet[0][2].toString());
                            jTextField104.setText(detailsSet[0][3].toString());

                            jLabel105.setVisible(false);
                            jLabel106.setVisible(false);
                            jLabel107.setVisible(false);
                            jLabel108.setVisible(false);
                            jLabel109.setVisible(false);
                            jLabel110.setVisible(false);

                            jTextField105.setVisible(false);
                            jTextField106.setVisible(false);
                            jTextField107.setVisible(false);
                            jTextField108.setVisible(false);
                            jTextField109.setVisible(false);
                            jTextField110.setVisible(false);

                        }
                    }

                    if (controller.getUserType().equals("Manager"))
                    {
                        if (controller.currentReservationCreationState() && datesNotChanged)
                        {
                            jButtonAddToReservation.setEnabled(true);
                        }
                        jButtonEdit.setEnabled(true);
                    } else
                    {
                        jButtonAddToReservation.setEnabled(true);
                        //jButtonEdit.setEnabled(false);
                    }
                }
                break;

                case "Clients":
                {
                    if (controller.getUserType().equals("Manager") || controller.getUserType().equals("Receptionist"))
                    {
                        if (controller.currentReservationCreationState())
                        {
                            jButtonAddToReservation.setEnabled(true);
                        }
                        jButtonEdit.setEnabled(true);
                    } else
                    {
                        jButtonAddToReservation.setEnabled(false);
                        jButtonEdit.setEnabled(false);
                    }
                    break;
                }

                default:
                {
                    jButtonAddToReservation.setEnabled(false);
                    jButtonEdit.setEnabled(false);
                }
            }

            //to be deleted:
            jLogLabel2.setText(jTable1.getValueAt(jTable1.getSelectedRow(), jTable1.getSelectedColumn()).toString());
        } else
        {
            jButtonAddToReservation.setEnabled(false);
            jButtonEdit.setEnabled(false);
        }
    }//GEN-LAST:event_jTable1MouseReleased

    private void jSearchButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jSearchButtonActionPerformed
    {//GEN-HEADEREND:event_jSearchButtonActionPerformed
        datesNotChanged = false;
        switch (jComboBox1.getSelectedItem().toString())
        {
            case "List rooms":
            {
                switch (jComboBox2.getSelectedItem().toString())
                {
                    case "Show all":
                    {
                        jTable1.setModel(new CustomTableModel(controller.getAllRooms(), controller.getTableColumnNames()));
                        jLogLabel2.setText("Displaying " + controller.getSearchResultCount() + " search results.");
                        break;
                    }
                    case "by availability":
                    {
                        if (jXDatePicker1.getDate() == null && jXDatePicker2.getDate() == null)
                        {
                            jLogLabel2.setForeground(Color.red);
                            jLogLabel2.setText("Starting and ending dates not entered!");
                        } else if (jXDatePicker1.getDate() == null)
                        {
                            jLogLabel2.setForeground(Color.red);
                            jLogLabel2.setText("Starting date not entered!");
                        } else if (jXDatePicker2.getDate() == null)
                        {
                            jLogLabel2.setForeground(Color.red);
                            jLogLabel2.setText("Ending date not entered!");
                        } else if (jXDatePicker1.getDate().after(jXDatePicker2.getDate()))
                        {
                            jLogLabel2.setForeground(Color.red);
                            jLogLabel2.setText("Ending date should be after starting date!");
                        } else
                        {
                            jTable1.setModel(new CustomTableModel(controller.getRoomsByAvailability(jXDatePicker1.getDate(), jXDatePicker2.getDate()), controller.getTableColumnNames()));
                            jLogLabel2.setForeground(Color.black);
                            jLogLabel2.setText("Displaying " + controller.getSearchResultCount() + " search results.");
                            datesNotChanged = true;
                        }
                        break;
                    }
                    case "by room number":
                    {
                        try
                        {
                            jTable1.setModel(new CustomTableModel(controller.getRoomByRoomNumber(Integer.parseInt(jTextField1.getText())), controller.getTableColumnNames()));
                            jLogLabel2.setForeground(Color.black);
                            jLogLabel2.setText("Displaying " + controller.getSearchResultCount() + " search results.");
                        } catch (NumberFormatException e)
                        {
                            jLogLabel2.setForeground(Color.red);
                            jLogLabel2.setText("Please insert a number in the \"Room number\" field!");
                        }
                        break;
                    }
                    default:
                    {
                        // do nothing
                    }
                }
                break;
            }
            case "List clients":
            {
                jTable1.setModel(new CustomTableModel(controller.getAllClients(), controller.getTableColumnNames()));
                jLogLabel2.setText("Displaying " + controller.getSearchResultCount() + " search results.");
                break;
            }
            case "List reservations":
            {
                jTable1.setModel(new CustomTableModel(controller.getAllReservations(), controller.getTableColumnNames()));
                jLogLabel2.setText("Displaying " + controller.getSearchResultCount() + " search results.");
                break;
            }
            case "List facility reservations":
            {
                jTable1.setModel(new CustomTableModel(controller.getAllFacilityReservations(), controller.getTableColumnNames()));
                jLogLabel2.setText("Displaying " + controller.getSearchResultCount() + " search results.");
                break;
            }
            case "List employees":
            {
                jTable1.setModel(new CustomTableModel(controller.getAllEmployees(), controller.getTableColumnNames()));
                jLogLabel2.setText("Displaying " + controller.getSearchResultCount() + " search results.");
                break;
            }
            case "List facilities":
            {
                jTable1.setModel(new CustomTableModel(controller.getAllFacilities(), controller.getTableColumnNames()));
                jLogLabel2.setText("Displaying " + controller.getSearchResultCount() + " search results.");
                break;
            }
            case "List room types":
            {
                jTable1.setModel(new CustomTableModel(controller.getAllRoomTypes(), controller.getTableColumnNames()));
                jLogLabel2.setText("Displaying " + controller.getSearchResultCount() + " search results.");
                break;
            }
            default:
            {
                //do nothing
            }
        }
        jButtonAddToReservation.setEnabled(false);
        jButtonEdit.setEnabled(false);
    }//GEN-LAST:event_jSearchButtonActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_jTextField1KeyReleased
    {//GEN-HEADEREND:event_jTextField1KeyReleased
        jTable1.setModel(new CustomTableModel(controller.dynamicSearch(jTextField1.getText(), jComboBox2.getSelectedItem().toString()), controller.getTableColumnNames()));
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jComboBox1ActionPerformed
    {//GEN-HEADEREND:event_jComboBox1ActionPerformed
        if (jComboBox1.getSelectedIndex() != -1)
        {
            setupCriteriaComboBox(controller.getUserType(), jComboBox1.getSelectedItem().toString());
            jSearchButton.setEnabled(true);
            if (jComboBox1.getSelectedItem().toString().equals("Create reservation"))
            {
                jSearchButton.setEnabled(false);
                if (controller.currentReservationCreationState())
                {
                    reservationForm.requestFocus();
                } else
                {
                    controller.createNewReservation();
                    reservationForm = new ReservationForm();
                    reservationForm.setLocation((int) (this.getLocation().getX() + this.getSize().getWidth() + 10), (int) (this.getLocation().getY()));
                    //                    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                    //                    System.out.println(this.getLocation().getX());
                    //                    System.out.println(this.getSize().getWidth());
                    reservationForm.setVisible(true);
                }
            }
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButtonEditActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonEditActionPerformed
    {//GEN-HEADEREND:event_jButtonEditActionPerformed
       
        if (jButtonEdit.getText().equals("Edit details"))
        {
             jTextField101.setEditable(true);
        jTextField102.setEditable(true);
        jTextField103.setEditable(true);
        jTextField104.setEditable(true);
        jTextField105.setEditable(true);
        jTextField106.setEditable(true);
        jTextField107.setEditable(true);
        jTextField108.setEditable(true);
        jTextField109.setEditable(true);
        jTextField110.setEditable(true);
            jButtonEdit.setText("Save details");
        } else
        {
             jTextField101.setEditable(false);
        jTextField102.setEditable(false);
        jTextField103.setEditable(false);
        jTextField104.setEditable(false);
        jTextField105.setEditable(false);
        jTextField106.setEditable(false);
        jTextField107.setEditable(false);
        jTextField108.setEditable(false);
        jTextField109.setEditable(false);
        jTextField110.setEditable(false);
            jButtonEdit.setText("Edit details");
        }

    }//GEN-LAST:event_jButtonEditActionPerformed

    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(CasablancaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                new CasablancaGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddToReservation;
    private javax.swing.JButton jButtonEdit;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox4;
    private javax.swing.JButton jConnectButton;
    private javax.swing.JTextField jConnectionField;
    private javax.swing.JLabel jConnectionLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLogLabel;
    private javax.swing.JLabel jLogLabel2;
    private javax.swing.JLayeredPane jLoginDetailsLayeredPane;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanelDetails;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JLabel jPasswordLabel;
    private javax.swing.JLayeredPane jPresentationLayeredPane;
    private javax.swing.JCheckBox jRememberCheckBox;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jSearchButton;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField101;
    private javax.swing.JTextField jTextField102;
    private javax.swing.JTextField jTextField103;
    private javax.swing.JTextField jTextField104;
    private javax.swing.JTextField jTextField105;
    private javax.swing.JTextField jTextField106;
    private javax.swing.JTextField jTextField107;
    private javax.swing.JTextField jTextField108;
    private javax.swing.JTextField jTextField109;
    private javax.swing.JTextField jTextField110;
    private javax.swing.JLabel jTitleLabel;
    private javax.swing.JTextField jUsernameField;
    private javax.swing.JLabel jUsernameLabel;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker1;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker2;
    // End of variables declaration//GEN-END:variables
}
