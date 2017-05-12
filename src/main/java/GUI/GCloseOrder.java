package GUI;

import WORK.*;
import javax.swing.*;
import java.sql.SQLException;
/*
 * Created by Юлия on 15.04.2017.
 */

public class GCloseOrder extends javax.swing.JDialog {
    static String num_order;//номер заказа
    private javax.swing.JTextField NumOrderTextField;
    GCloseOrder(java.awt.Frame parent) {
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
        } catch (ClassNotFoundException | javax.swing.UnsupportedLookAndFeelException | IllegalAccessException | InstantiationException ex) {
            java.util.logging.Logger.getLogger(GCloseOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> new GCloseOrder(null).setVisible(true));
    }

    private void initComponents() {
        JLabel numOrderLabel = new JLabel();
        NumOrderTextField = new javax.swing.JTextField();
        JButton cancelButton = new JButton();
        JButton closeOrderButton = new JButton();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Закрытие заказа");
        ImageIcon icon = new ImageIcon("src\\main\\resources\\main_icon\\main_icon.png");
        setIconImage(icon.getImage());
        setResizable(false);

        numOrderLabel.setText("Номер заказа");
        cancelButton.setText("Отмена");
        cancelButton.addActionListener(evt -> CancelButtonActionPerformed());

        closeOrderButton.setText("Закрыть заказ");
        closeOrderButton.addActionListener(evt -> {
            try {
                CloseOrderButtonActionPerformed();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(9, 9, 9)
                                                .addComponent(numOrderLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(NumOrderTextField))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(closeOrderButton, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(numOrderLabel)
                                        .addComponent(NumOrderTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cancelButton)
                                        .addComponent(closeOrderButton))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>

    private void CloseOrderButtonActionPerformed() throws SQLException {
        num_order = NumOrderTextField.getText();
        if(num_order.equals("")) JOptionPane.showMessageDialog(null,"Поле \"Номер заказа\" не может быть пустым!", "Ошибка", JOptionPane.ERROR_MESSAGE);
        else if(!Methods.isOnlyDigit(num_order))JOptionPane.showMessageDialog(null,"Неверный формат поля \"Номер заказа\"!", "Ошибка", JOptionPane.ERROR_MESSAGE);
        else{
            if(Order.existOrder(num_order)) {//если заказ есть
                Order.checkOrderData(num_order);
                if(Order.status.equals("ОТКРЫТ")) {//при этом он открыт
                    if (Order.type_work.equals("УСТАНОВКА ВОДОМЕРА")) {
                        String[] codes = (Waterconnection.showWaterconnectionForWatermer(String.valueOf(Order.num_account))).split("_");
                            JOptionPane.showMessageDialog(null,"Введите данные об установленном водомере!", "Новый водомер", JOptionPane.INFORMATION_MESSAGE);
                            GNewWatermeter nw = new GNewWatermeter(this);
                            nw.order=true;//флаг заказа
                            nw.CodeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(codes));
                            nw.setVisible(true);
                            JOptionPane.showMessageDialog(null,"Статус заказа с номером "+num_order+" изменен на \"ЗАКРЫТ\"!", "Закрытие заказа", JOptionPane.INFORMATION_MESSAGE);
                            dispose(); // уничтожить окно
                    }
                    else{//снятие водомера
                        String[] nums = (Watermeter.getAllWatermeters(String.valueOf(Order.num_account))).split("_");
                        GDeleteWatermeter dw = new GDeleteWatermeter(this);
                        dw.NumWMComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(nums));
                        dw.setVisible(true);
                        JOptionPane.showMessageDialog(null,"Статус заказа с номером "+num_order+" изменен на \"ЗАКРЫТ\"!", "Закрытие заказа", JOptionPane.INFORMATION_MESSAGE);
                        dispose(); // уничтожить окно
                    }
                }else JOptionPane.showMessageDialog(null,"Заказ с номером "+num_order+" уже закрыт!", "Ошибка", JOptionPane.ERROR_MESSAGE);

            }else JOptionPane.showMessageDialog(null,"Заказа с номером "+num_order+" не существует!", "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void CancelButtonActionPerformed() {
        dispose(); // уничтожить окно
    }
}
