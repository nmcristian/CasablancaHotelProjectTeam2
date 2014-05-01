package presentation;

import domain.Controller;
import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Cristian
 */
public class ReservationForm extends javax.swing.JFrame
{

    String[] roomsTableColumnNames, clientsTableColumnNames;
    private Controller controller;
    private CasablancaGUI mainGUI;

    public ReservationForm()
    {
        this.controller = Controller.getInstance();
        this.mainGUI = CasablancaGUI.getInstance();

        initComponents();
        roomsTableColumnNames = new String[]
        {
            "Room number", "Room type", "Price"
        };
        clientsTableColumnNames = new String[]
        {
            "Client ID", "First name", "Last name"
        };

        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.getTableHeader().setResizingAllowed(false);
        jTable2.getTableHeader().setReorderingAllowed(false);
        jTable2.getTableHeader().setResizingAllowed(false);

        displayReservationInfo();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jSaveButton = new javax.swing.JButton();
        jDiscardButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter()
        {
            public void windowClosing(java.awt.event.WindowEvent evt)
            {
                formWindowClosing(evt);
            }
        });

        jButton1.setText("Confirm new payment");
        jButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel6.setText("Reservation id:");
        jLabel6.setPreferredSize(new java.awt.Dimension(100, 25));

        jLabel1.setText("Client name:");
        jLabel1.setPreferredSize(new java.awt.Dimension(100, 25));

        jLabel2.setText("Client id:");
        jLabel2.setPreferredSize(new java.awt.Dimension(100, 25));

        jLabel3.setText("Total capacity:");
        jLabel3.setPreferredSize(new java.awt.Dimension(100, 25));

        jLabel4.setText("Confirmation cost:");
        jLabel4.setPreferredSize(new java.awt.Dimension(100, 25));

        jLabel5.setText("Total cost:");
        jLabel5.setPreferredSize(new java.awt.Dimension(100, 25));

        jLabel7.setText("Already paid:");
        jLabel7.setPreferredSize(new java.awt.Dimension(100, 25));

        jTextField6.setEditable(false);
        jTextField6.setPreferredSize(new java.awt.Dimension(210, 25));

        jTextField1.setEditable(false);
        jTextField1.setPreferredSize(new java.awt.Dimension(210, 25));

        jTextField2.setEditable(false);
        jTextField2.setPreferredSize(new java.awt.Dimension(210, 25));

        jTextField3.setEditable(false);
        jTextField3.setPreferredSize(new java.awt.Dimension(210, 25));

        jTextField4.setEditable(false);
        jTextField4.setPreferredSize(new java.awt.Dimension(210, 25));

        jTextField5.setEditable(false);
        jTextField5.setPreferredSize(new java.awt.Dimension(210, 25));

        jTextField7.setEditable(false);
        jTextField7.setPreferredSize(new java.awt.Dimension(210, 25));

        jTabbedPane1.setName(""); // NOI18N

        jScrollPane2.setName(""); // NOI18N

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {
                "Room number", "Room type", "Price"
            }
        )
        {
            Class[] types = new Class []
            {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean []
            {
                false, false, false
            };

            public Class getColumnClass(int columnIndex)
            {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex)
            {
                return canEdit [columnIndex];
            }
        });
        jTable1.setToolTipText("");
        jTable1.setRowHeight(20);
        jTable1.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyReleased(java.awt.event.KeyEvent evt)
            {
                jTable1KeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jTabbedPane1.addTab("Rooms", jScrollPane2);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {
                "Client ID", "First name", "Last name"
            }
        )
        {
            Class[] types = new Class []
            {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean []
            {
                false, false, false
            };

            public Class getColumnClass(int columnIndex)
            {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex)
            {
                return canEdit [columnIndex];
            }
        });
        jTable2.setToolTipText("");
        jTable2.setRowHeight(20);
        jTable2.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseReleased(java.awt.event.MouseEvent evt)
            {
                jTable2MouseReleased(evt);
            }
        });
        jTable2.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyReleased(java.awt.event.KeyEvent evt)
            {
                jTable2KeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(jTable2);

        jTabbedPane1.addTab("Clients", jScrollPane3);

        jSaveButton.setText("Save");
        jSaveButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jSaveButtonActionPerformed(evt);
            }
        });

        jDiscardButton.setText("Discard");
        jDiscardButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jDiscardButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jSaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(jDiscardButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(jTextField5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jDiscardButton)
                    .addComponent(jSaveButton))
                .addContainerGap())
        );
        jLayeredPane1.setLayer(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jTextField6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jTextField1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jTextField2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jTextField3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jTextField4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jTextField5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jTextField7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jTabbedPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jSaveButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jDiscardButton, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1)
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void displayReservationInfo()
    {
        jTextField3.setText(controller.getTotalCapacityFromNewReservation());
        jTextField4.setText(controller.getNewReservationDeposit() + "");
        jTextField5.setText(controller.getNewReservationTotalPrice() + "");
        jTextField6.setText(controller.getNewReservationsID());
        jTextField7.setText(controller.getNewReservationAlreadyPaid() + "");

        jTable2.setModel(new CustomTableModel(controller.getClientsFromNewReservation(), clientsTableColumnNames));
        if (jTable2.getModel().getRowCount() > 0)
        {
            jTextField1.setText(jTable2.getModel().getValueAt(0, 1).toString() + ", " + jTable2.getModel().getValueAt(0, 2).toString());
            jTextField2.setText(jTable2.getModel().getValueAt(0, 0).toString());
        }

        jTable1.setModel(new CustomTableModel(controller.getRoomsFromNewReservation(), roomsTableColumnNames));
    }

    private void jSaveButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jSaveButtonActionPerformed
    {//GEN-HEADEREND:event_jSaveButtonActionPerformed
        String reservationID = controller.getNewReservationsID();
        mainGUI.showLog(Color.black, "Saving reservation " + reservationID + "...");
        if (controller.saveNewReservation())
        {
            mainGUI.showLog(Color.black, "Reservation " + reservationID + " successfully saved!");
            this.dispose();
        } else
        {
            String errorMessage = "There was an error saving these rooms reservations: ";
            for (int x : controller.getUnavailableRoomsNumbers())
            {
                errorMessage += x + ", ";
            }
            errorMessage = errorMessage.substring(0, errorMessage.length() - 2);
            errorMessage += "!";

            // This is to be set on the jLogLabel2 from the main jFrame
            mainGUI.showLog(Color.red, errorMessage);
        }
    }//GEN-LAST:event_jSaveButtonActionPerformed

    private void jDiscardButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jDiscardButtonActionPerformed
    {//GEN-HEADEREND:event_jDiscardButtonActionPerformed
        mainGUI.showLog(Color.black, "Changes for reservation " + controller.getNewReservationsID() + " have been discarded!");
        controller.discardNewReservation();
        this.dispose();
    }//GEN-LAST:event_jDiscardButtonActionPerformed

    protected void refreshReservationTablesInfo()
    {
        switch (controller.getSearchResultType())
        {
            case "Rooms":
                jTabbedPane1.setSelectedIndex(0);
                jTable1.setModel(new CustomTableModel(controller.getRoomsFromNewReservation(), roomsTableColumnNames));
                jTextField3.setText(controller.getTotalCapacityFromNewReservation());
                jTextField4.setText(controller.getNewReservationDeposit() + "");
                jTextField5.setText(controller.getNewReservationTotalPrice() + "");
                break;

            case "Clients":
                jTabbedPane1.setSelectedIndex(1);
                jTable2.setModel(new CustomTableModel(controller.getClientsFromNewReservation(), clientsTableColumnNames));
                if (jTable2.getRowCount() == 1)
                {
                    jTextField1.setText(jTable2.getModel().getValueAt(0, 1).toString() + ", " + jTable2.getModel().getValueAt(0, 2).toString());
                    jTextField2.setText(jTable2.getModel().getValueAt(0, 0).toString());
                }
                break;

            default:
            //do nothing
        }
    }

    private void formWindowClosing(java.awt.event.WindowEvent evt)//GEN-FIRST:event_formWindowClosing
    {//GEN-HEADEREND:event_formWindowClosing
        controller.discardNewReservation();
    }//GEN-LAST:event_formWindowClosing

    private void jTable1KeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_jTable1KeyReleased
    {//GEN-HEADEREND:event_jTable1KeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_DELETE)
        {
            if (jTable1.getSelectedRow() != -1)
            {
                if (controller.getSearchResultType().equals("Rooms"))
                {
                    if (controller.getLastSearchFrom() == null && controller.getLastSearchTo() == null)
                    {
                        mainGUI.addRowAndRefreshTableInfo(((CustomTableModel) jTable1.getModel()).getRow(jTable1.getSelectedRow()));
                    } else if (controller.getLastSearchFrom().equals(controller.getRoomFromNewReservation(jTable1.getSelectedRow()).getStartingDate())
                            && controller.getLastSearchTo().equals(controller.getRoomFromNewReservation(jTable1.getSelectedRow()).getEndingDate()))
                    {
                        mainGUI.addRowAndRefreshTableInfo(((CustomTableModel) jTable1.getModel()).getRow(jTable1.getSelectedRow()));
                    }
                }

                controller.removeRoomFromReservation(jTable1.getSelectedRow());
                ((CustomTableModel) jTable1.getModel()).removeRow(jTable1.getSelectedRow());
                jTable1.setModel(new CustomTableModel(((CustomTableModel) jTable1.getModel()).getData(), ((CustomTableModel) jTable1.getModel()).getColumnNames()));
                jTextField3.setText(controller.getTotalCapacityFromNewReservation());
                jTextField4.setText(controller.getNewReservationDeposit() + "");
                jTextField5.setText(controller.getNewReservationTotalPrice() + "");
            }
        }
    }//GEN-LAST:event_jTable1KeyReleased

    private void jTable2KeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_jTable2KeyReleased
    {//GEN-HEADEREND:event_jTable2KeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_DELETE)
        {
            if (jTable2.getSelectedRow() != -1)
            {
                if (controller.getSearchResultType().equals("Clients"))
                {
                    mainGUI.addRowAndRefreshTableInfo(((CustomTableModel) jTable2.getModel()).getRow(jTable2.getSelectedRow()));
                }
                if (jTable2.getValueAt(jTable2.getSelectedRow(), 0).toString().equals(jTextField2.getText()))
                {
                    jTextField1.setText(null);
                    jTextField2.setText(null);
                }
                controller.removeClientFromReservation(jTable2.getSelectedRow());
                ((CustomTableModel) jTable2.getModel()).removeRow(jTable2.getSelectedRow());
                jTable2.setModel(new CustomTableModel(((CustomTableModel) jTable2.getModel()).getData(), ((CustomTableModel) jTable2.getModel()).getColumnNames()));
                if (jTextField1.getText().equals("") && jTable2.getModel().getRowCount() > 0)
                {
                    jTextField1.setText(jTable2.getModel().getValueAt(0, 1).toString() + ", " + jTable2.getModel().getValueAt(0, 2).toString());
                    jTextField2.setText(jTable2.getModel().getValueAt(0, 0).toString());
                }
            }
        }
    }//GEN-LAST:event_jTable2KeyReleased

    private void jTable2MouseReleased(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jTable2MouseReleased
    {//GEN-HEADEREND:event_jTable2MouseReleased
        if (evt.getClickCount() == 2)
        {
            if (jTable2.getSelectedRow() != -1)
            {
                jTextField1.setText(jTable2.getModel().getValueAt(jTable2.getSelectedRow(), 1).toString() + ", " + jTable2.getModel().getValueAt(jTable2.getSelectedRow(), 2).toString());
                jTextField2.setText(jTable2.getModel().getValueAt(jTable2.getSelectedRow(), 0).toString());
            }
        }
    }//GEN-LAST:event_jTable2MouseReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton1ActionPerformed
    {//GEN-HEADEREND:event_jButton1ActionPerformed
        String infoMessage, request;
        double payment = -1;
        if (controller.getNewReservationAlreadyPaid() >= controller.getNewReservationTotalPrice())
        {
            infoMessage = "Total cost for this reservation has been already paid!";
            JOptionPane.showMessageDialog(this, infoMessage);
        } else
        {
            request = "Please insert the paid amount you want to confirm:";
            infoMessage = "\nTotal remaining to pay: $" + (controller.getNewReservationTotalPrice() - controller.getNewReservationAlreadyPaid());
            if (controller.getNewReservationAlreadyPaid() < controller.getNewReservationDeposit())
            {
                infoMessage += "\nRemaining to pay from deposit, to confirm reservation: $" + (controller.getNewReservationDeposit() - controller.getNewReservationAlreadyPaid());
            }

            while (payment < 0)
            {
                try
                {
                    payment = Double.parseDouble(JOptionPane.showInputDialog(request + infoMessage));
                    if ((payment + controller.getNewReservationAlreadyPaid() > controller.getNewReservationTotalPrice()))
                    {
                        request = "Please insert the paid amount you want to confirm, not more than $"
                                + (controller.getNewReservationTotalPrice() - controller.getNewReservationAlreadyPaid());
                        payment = -1;
                    } else
                    {
                        request = "Please insert the paid amount you want to confirm:";
                    }
                } catch (NumberFormatException e)
                {
                    request = "Please insert the paid amount you want to confirm, not more than $"
                            + (controller.getNewReservationTotalPrice() - controller.getNewReservationAlreadyPaid());
                } catch (NullPointerException e)
                {
                    payment = 0;
                }
            }
            if (payment > 0)
            {
                controller.confirmNewReservationPayment(payment);
                jTextField7.setText(controller.getNewReservationAlreadyPaid() + "");
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(ReservationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                new ReservationForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jDiscardButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JButton jSaveButton;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables
}
