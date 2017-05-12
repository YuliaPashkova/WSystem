package GUI;

import WORK.Access;
import WORK.Order;
import WORK.Waterconnection;
import WORK.Watermeter;

import javax.swing.*;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/*
 * Created by Юлия on 15.04.2017.
 */
public class GNewOrder extends javax.swing.JDialog {
    private javax.swing.JButton CancelButton;
    private org.jdesktop.swingx.JXDatePicker DateRealizDatePicker;
    private javax.swing.JLabel DateRealizLabel;
    private org.jdesktop.swingx.JXDatePicker DateRegDatePicker;
    private javax.swing.JLabel DateRegLabel;
    private javax.swing.JLabel NoteLabel;
    private javax.swing.JScrollPane NoteScrollPane;
    private javax.swing.JTextArea NoteTextArea;
    private javax.swing.JLabel NumAccLabel;
    private javax.swing.JTextField NumAccTextField;
    private javax.swing.JLabel NumOrderLabel;
    private javax.swing.JTextField NumOrderTextField;
    private javax.swing.JButton OkButton;
    private javax.swing.JLabel OperatorLabel;
    private javax.swing.JTextField OperatorTextField;
    private javax.swing.JLabel StatusLabel;
    private javax.swing.JTextField StatusTextField;
    private javax.swing.JLabel SumLabel;
    private javax.swing.JTextField SumTextField;
    private javax.swing.JComboBox<String> TypeWorkComboBox;
    private javax.swing.JLabel TypeWorkLabel;
    private javax.swing.JSeparator jSeparator1;
    public GNewOrder(java.awt.Frame parent) throws SQLException {
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
        } catch (ClassNotFoundException | InstantiationException | javax.swing.UnsupportedLookAndFeelException | IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GNewOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new GNewOrder(null).setVisible(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }

    private void initComponents() throws SQLException {
        NumOrderLabel = new javax.swing.JLabel();
        NumOrderTextField = new javax.swing.JTextField();
        NumAccLabel = new javax.swing.JLabel();
        NumAccTextField = new javax.swing.JTextField();
        TypeWorkComboBox = new javax.swing.JComboBox<>();
        TypeWorkLabel = new javax.swing.JLabel();
        StatusTextField = new javax.swing.JTextField();
        StatusLabel = new javax.swing.JLabel();
        DateRegDatePicker = new org.jdesktop.swingx.JXDatePicker();
        DateRegDatePicker.setFormats("yyyy-MM-dd");
        DateRegDatePicker.setLinkDate(System.currentTimeMillis(), "Сегодня {0}");
        DateRealizDatePicker = new org.jdesktop.swingx.JXDatePicker();
        DateRealizDatePicker.setDate(null);
        DateRealizDatePicker.setFormats("yyyy-MM-dd");
        DateRealizDatePicker.setLinkDate(System.currentTimeMillis(), "Сегодня {0}");
        DateRegLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        DateRealizLabel = new javax.swing.JLabel();
        OperatorTextField = new javax.swing.JTextField();
        OperatorLabel = new javax.swing.JLabel();
        SumLabel = new javax.swing.JLabel();
        SumTextField = new javax.swing.JTextField();
        NoteLabel = new javax.swing.JLabel();
        NoteScrollPane = new javax.swing.JScrollPane();
        NoteTextArea = new javax.swing.JTextArea();
        CancelButton = new javax.swing.JButton();
        OkButton = new javax.swing.JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Новый заказ ("+ Access.name_operator+")");

        ImageIcon icon = new ImageIcon("src\\main\\resources\\main_icon\\main_icon.png");
        setIconImage(icon.getImage());
        setResizable(false);

        NumOrderLabel.setText("Номер заказа");

        NumOrderTextField.setEnabled(false);
        NumOrderTextField.setText(String.valueOf(Order.getLastNumber()+1));

        NumAccLabel.setText("№ лицевого счета");

        NumAccTextField.setEnabled(false);
        NumAccTextField.setText(GAccount.NUM_ACC);

        TypeWorkComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "НЕ ВЫБРАНО", "УСТАНОВКА ВОДОМЕРА", "СНЯТИЕ ВОДОМЕРА" }));

        TypeWorkLabel.setText("Тип работы");

        StatusTextField.setText("ОТКРЫТ");
        StatusTextField.setEnabled(false);

        StatusLabel.setText("Статус");

        DateRegLabel.setText("Дата оформления");
        DateRegDatePicker.setEnabled(false);

        DateRealizLabel.setText("Дата выполнения");

        OperatorTextField.setEnabled(false);
        OperatorTextField.setText(Access.name_operator);

        OperatorLabel.setText("Оператор");

        SumLabel.setText("Сумма");

        NoteLabel.setText("Примечание");

        NoteTextArea.setColumns(20);
        NoteTextArea.setRows(5);
        NoteScrollPane.setViewportView(NoteTextArea);

        CancelButton.setText("Отмена");
        CancelButton.addActionListener(evt -> CancelButtonActionPerformed());

        OkButton.setText("Принять");
        OkButton.addActionListener(evt -> {
            try {
                OkButtonActionPerformed();
            } catch (ParseException | SQLException e) {
                e.printStackTrace();
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(OkButton, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(CancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(19, 19, 19)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jSeparator1)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(NumOrderTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGap(15, 15, 15)
                                                                                .addComponent(NumOrderLabel)))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(NumAccLabel)
                                                                                .addGap(32, 32, 32)
                                                                                .addComponent(StatusLabel)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addComponent(OperatorLabel)
                                                                                .addGap(41, 41, 41))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(NumAccTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(StatusTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(OperatorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(DateRegLabel)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(DateRegDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(TypeWorkLabel)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(TypeWorkComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                        .addComponent(SumLabel)
                                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                        .addComponent(SumTextField))
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                        .addComponent(DateRealizLabel)
                                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                        .addComponent(DateRealizDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(NoteScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(NoteLabel))))))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(NumOrderLabel)
                                        .addComponent(NumAccLabel)
                                        .addComponent(StatusLabel)
                                        .addComponent(OperatorLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(NumOrderTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(NumAccTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(StatusTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(OperatorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(DateRegDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(DateRegLabel)
                                        .addComponent(NoteLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(TypeWorkComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(TypeWorkLabel))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(DateRealizDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(DateRealizLabel))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(SumLabel)
                                                        .addComponent(SumTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(NoteScrollPane))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(CancelButton)
                                        .addComponent(OkButton))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>

    private void OkButtonActionPerformed() throws ParseException, SQLException {
        String data [] = readData();
        boolean error=false;
        String message="";
        if(data[7].equals("НЕ ВЫБРАНО")) JOptionPane.showMessageDialog(null, "Выберите тип работы!", "Ошибка", JOptionPane.ERROR_MESSAGE);
        else if (data[7].equals("УСТАНОВКА ВОДОМЕРА")){
            //проверить,есть ли на лицевом счете вообще ВП
            if(!Waterconnection.existWatercon(NumAccTextField.getText())) {//если нет
                error=true;
                message="Данный лицевой счет не имеет водомерных подключений, поэтому невозможно создать заказ на установку водомера!";
                dispose();
            }
        }
        else {//если снятие водомера
            //проверить,есть ли на лицевом счете водомеры
            if(!Watermeter.existWatermeter(NumAccTextField.getText())){//если не существуют
                error=true;
                message="Данный лицевой счет не имеет водомеров, поэтому невозможно создать заказ на снятие водомера!";
                dispose();
            }
        }

        if(error)
            JOptionPane.showMessageDialog(null,message, "Ошибка", JOptionPane.ERROR_MESSAGE);
        else
            switch(Order.addOrder(data)){
            case 0:
                JOptionPane.showMessageDialog(null,"Заказ с номером "+NumOrderTextField.getText()+" принят!", "Формирование заказа", JOptionPane.INFORMATION_MESSAGE);
                dispose();
                break;
            case -1:
                JOptionPane.showMessageDialog(null, Order.error, "Ошибка", JOptionPane.ERROR_MESSAGE);
                break;
        }
    }

    private String[] readData() {
        String data []=new String[9];
        data[0]= NumAccTextField.getText();
        data[1]= NumOrderTextField.getText();
        data[2]= StatusTextField.getText();

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try{
            data[3] = dateFormat.format(DateRealizDatePicker.getDate());
        }catch (NullPointerException ex){
            data[3]= null;
        }
        data[4]= SumTextField.getText().trim();
        try{
            data[5] = dateFormat.format(DateRegDatePicker.getDate());
        }catch (NullPointerException ex){
            data[5]= null;
        }
        data[6]= String.valueOf(Access.id);//ид оператора
        data[7]= String.valueOf(TypeWorkComboBox.getSelectedItem());
        data[8]= NoteTextArea.getText().trim();
        return data;
    }

    private void CancelButtonActionPerformed() {
        this.dispose(); // уничтожить окно
    }
}
