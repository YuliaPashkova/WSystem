package GUI;
import WORK.Order;
import WORK.Watermeter;
import javax.swing.*;
import java.sql.SQLException;

/*
 * Created by Юлия on 12.05.2017.
 */
public class GDeleteWatermeter extends javax.swing.JDialog  {
javax.swing.JComboBox<String> NumWMComboBox;


    GDeleteWatermeter(java.awt.Dialog parent) {
        super(parent, true);
        initComponents();
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GDeleteWatermeter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> new GDeleteWatermeter(null).setVisible(true));
    }

    private void initComponents() {

        JLabel numWMLabel = new JLabel();
        JButton DeleteWatForOrderButton = new JButton();
        JButton cancelButton = new JButton();
        NumWMComboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Снятие водомера");
        ImageIcon icon = new ImageIcon("src\\main\\resources\\main_icon\\main_icon.png");
        setIconImage(icon.getImage());

        numWMLabel.setText("Укажите заводской номер водомера:");

        DeleteWatForOrderButton.setText("ОК");
        DeleteWatForOrderButton.addActionListener(evt -> {
            try {
                DeleteWatForOrderButtonActionPerformed();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });

        cancelButton.setText("Отмена");
        cancelButton.addActionListener(evt -> CancelButtonActionPerformed());

        NumWMComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "НЕ ВЫБРАНО" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(NumWMComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(numWMLabel)
                                                .addGap(0, 60, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(DeleteWatForOrderButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(numWMLabel)
                                .addGap(5, 5, 5)
                                .addComponent(NumWMComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(DeleteWatForOrderButton)
                                        .addComponent(cancelButton))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }

        private void DeleteWatForOrderButtonActionPerformed() throws SQLException {
        if(NumWMComboBox.getSelectedItem().equals("НЕ ВЫБРАНО"))
            JOptionPane.showMessageDialog(null,"Выберите серийный номер водомера!", "Закрытие заказа", JOptionPane.ERROR_MESSAGE);
        else {
            Watermeter.deleteWatermeter(String.valueOf(NumWMComboBox.getSelectedItem()));
            Order.setCloseStatus(GCloseOrder.num_order, String.valueOf(NumWMComboBox.getSelectedItem()));
            dispose();
        }

    }
private void CancelButtonActionPerformed() {
      dispose();
    }
}

