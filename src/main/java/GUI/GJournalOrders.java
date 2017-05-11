package GUI;
import WORK.Access;
import WORK.Order;
import org.jdesktop.swingx.JXDatePicker;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/*
 * Created by Юлия on 20.04.2017.
 */
public class GJournalOrders extends javax.swing.JDialog {
    private static DefaultTableModel model = new DefaultTableModel();//модель таблицы с результатом поиска

    private JTextField textfields [];//массив текстовых полей
    private JComboBox comboboxes[];//массив комбобоксов
    private JXDatePicker datepickers[];//массив дэйткиперов


    private org.jdesktop.swingx.JXDatePicker DateRealizDatePicker;
    private org.jdesktop.swingx.JXDatePicker DateRegDatePicker;
    private javax.swing.JTextArea NoteTextArea;
    private javax.swing.JTextField NumAccTextField;
    private javax.swing.JTextField NumOrderTextField;
    private javax.swing.JTextField OperatorTextField;
    private javax.swing.JTable ResultTable;
    private javax.swing.JTextField SerialNumTextField;
    private javax.swing.JComboBox<String> StatusComboBox;
    private javax.swing.JTextField SumTextField;
    private javax.swing.JComboBox<String> TypeWorkComboBox;

    GJournalOrders(java.awt.Frame parent) {
        super(parent, true);
        initComponents();
        textfields = new JTextField[]{NumOrderTextField,NumAccTextField,OperatorTextField,SumTextField,SerialNumTextField};
        comboboxes = new JComboBox[]{StatusComboBox,TypeWorkComboBox};
        datepickers = new JXDatePicker[]{DateRegDatePicker,DateRealizDatePicker};
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | UnsupportedLookAndFeelException | IllegalAccessException | InstantiationException ex) {
            java.util.logging.Logger.getLogger(GJournalOrders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> new GJournalOrders(null).setVisible(true));
    }

    //добавление в таблицу новой строки
    public  static void AddRowTable() {
        model.addRow(new Object[]{
               Order.num_account,Order.num_order,Order.type_work,Order.status});
    }

    private void initComponents() {
        DateRegDatePicker = new org.jdesktop.swingx.JXDatePicker();
        DateRegDatePicker.setFormats("yyyy-MM-dd");
        DateRegDatePicker.setDate(null);
        DateRegDatePicker.setLinkDate(System.currentTimeMillis(), "Сегодня {0}");
        DateRealizDatePicker = new org.jdesktop.swingx.JXDatePicker();
        DateRealizDatePicker.setFormats("yyyy-MM-dd");
        DateRealizDatePicker.setDate(null);
        DateRealizDatePicker.setLinkDate(System.currentTimeMillis(), "Сегодня {0}");
        JLabel sumLabel = new JLabel();
        SumTextField = new javax.swing.JTextField();
        JButton searchButton = new JButton();
        JLabel noteLabel = new JLabel();
        JScrollPane jScrollPane1 = new JScrollPane();
        NoteTextArea = new javax.swing.JTextArea();
        JLabel serialNumLabel = new JLabel();
        SerialNumTextField = new javax.swing.JTextField();
        JButton clearButton = new JButton();
        JLabel typeWorkLabel = new JLabel();
        TypeWorkComboBox = new javax.swing.JComboBox<>();
        OperatorTextField = new javax.swing.JTextField();
        NumOrderTextField = new javax.swing.JTextField();
        JLabel numOrderLabel = new JLabel();
        NumAccTextField = new javax.swing.JTextField();
        JLabel numAccLabel = new JLabel();
        JLabel statusLabel = new JLabel();
        JLabel operatorLabel = new JLabel();
        JLabel dateRealizLabel = new JLabel();
        JLabel dateRegLabel = new JLabel();
        StatusComboBox = new javax.swing.JComboBox<>();
        JScrollPane jScrollPane2 = new JScrollPane();
        ResultTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Журнал заказов ("+ Access.name_operator+")");
        ImageIcon icon = new ImageIcon("src\\main\\resources\\main_icon\\main_icon.png");
        setIconImage(icon.getImage());

        sumLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        sumLabel.setText("Сумма");

        SumTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        searchButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        searchButton.setText("Поиск");
        searchButton.addActionListener(evt -> {
            try {
                SearchButtonActionPerformed();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });

        noteLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        noteLabel.setText("Примечание");

        NoteTextArea.setColumns(20);
        NoteTextArea.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        NoteTextArea.setRows(5);
        jScrollPane1.setViewportView(NoteTextArea);

        serialNumLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        serialNumLabel.setText("Заводской номер водомера");

        SerialNumTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        clearButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        clearButton.setText("Очистить форму");
        clearButton.addActionListener(evt -> ClearButtonActionPerformed());
        typeWorkLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        typeWorkLabel.setText("Тип работы");

        TypeWorkComboBox.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        TypeWorkComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "НЕ ВЫБРАНО", "УСТАНОВКА ВОДОМЕРА", "СНЯТИЕ ВОДОМЕРА" }));

        OperatorTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        NumOrderTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        numOrderLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        numOrderLabel.setText("Номер заказа");

        NumAccTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        numAccLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        numAccLabel.setText("№ лицевого счета");

        statusLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        statusLabel.setText("Статус");

        operatorLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        operatorLabel.setText("Оператор");

        dateRealizLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        dateRealizLabel.setText("Дата выполнения");

        dateRegLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        dateRegLabel.setText("Дата оформления");

        StatusComboBox.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        StatusComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "НЕ ВЫБРАНО","ОТКРЫТ", "ЗАКРЫТ" }));

        ResultTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "№ л/счета", "№ заказа", "Тип работ", "Статус"
                }
        ) {
            boolean[] canEdit = new boolean [] {
                    false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ResultTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ResultTableMouseClicked();
            }
        });
        ResultTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        model = (DefaultTableModel) ResultTable.getModel();//подключение таблицы к модели
        jScrollPane2.setViewportView(ResultTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jScrollPane2)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(NumOrderTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(18, 18, 18)
                                                                .addComponent(numOrderLabel))
                                                        .addComponent(dateRegLabel)
                                                        .addComponent(DateRegDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                        .addComponent(NumAccTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(numAccLabel, javax.swing.GroupLayout.Alignment.LEADING))
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGap(34, 34, 34)
                                                                                .addComponent(statusLabel))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(dateRealizLabel)
                                                                                        .addComponent(StatusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(SumTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(DateRealizDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(37, 37, 37)
                                                                .addComponent(sumLabel)))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(40, 40, 40)
                                                                .addComponent(operatorLabel))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(29, 29, 29)
                                                                .addComponent(typeWorkLabel))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(TypeWorkComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(OperatorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(serialNumLabel)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(SerialNumTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                .addComponent(noteLabel)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jScrollPane1)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(searchButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(clearButton, javax.swing.GroupLayout.Alignment.TRAILING))))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(numOrderLabel)
                                        .addComponent(numAccLabel)
                                        .addComponent(statusLabel)
                                        .addComponent(operatorLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(NumOrderTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(NumAccTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(StatusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(OperatorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(dateRegLabel)
                                        .addComponent(sumLabel)
                                        .addComponent(dateRealizLabel)
                                        .addComponent(typeWorkLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(DateRealizDatePicker, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(DateRegDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(SumTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(TypeWorkComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(9, 9, 9)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(serialNumLabel)
                                        .addComponent(SerialNumTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                        .addGap(45, 45, 45)
                                                        .addComponent(clearButton)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(searchButton))
                                                .addGroup(layout.createSequentialGroup()
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(noteLabel)))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>

    private void ClearButtonActionPerformed() {
        for (JTextField textfield : textfields) textfield.setText(null);
        for (JComboBox comboboxe : comboboxes) comboboxe.setSelectedIndex(0);
        for (JXDatePicker datepicker : datepickers) datepicker.setDate(null);
        NoteTextArea.setText(null);
        deleteRows();
    }

    private void SearchButtonActionPerformed() throws SQLException {
       search();
    }

    private void search() throws SQLException {
        String data []=new String[10];
        data[0]= NumOrderTextField.getText();
        data[1]= (String) StatusComboBox.getSelectedItem();
        if (Objects.equals(data[1], "НЕ ВЫБРАНО")) data[1] = "";
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try{
            Date date_real = DateRealizDatePicker.getDate();
            data[2] = format.format(date_real);
        }catch (NullPointerException ex){
            data[2]= "";
        }
        data[3]= SumTextField.getText().trim();
        try{
            Date date_reg = DateRegDatePicker.getDate();
            data[4] = format.format(date_reg);
        }catch (NullPointerException ex){
            data[4]= "";
        }
        if(!Objects.equals(OperatorTextField.getText(), ""))data[5]= String.valueOf(Order.getIdOperatorFromName(OperatorTextField.getText()));
        else data[5]="";
        data[6]= String.valueOf(TypeWorkComboBox.getSelectedItem());
        if (Objects.equals(data[6], "НЕ ВЫБРАНО")) data[6] = "";
        data[7]= NoteTextArea.getText().trim();
        data[8]= SerialNumTextField.getText();
        data[9]=NumAccTextField.getText().trim();

        deleteRows();//удаление строк из таблицы

        //замена пустых значений на null
        for (int i = 0; i < data.length; i++)
            if (data[i].equals("")) data[i] = null;

        //подсчет null полей
        int count_null = 0;//количество null полей
        for (String aData : data) if (aData == null) count_null++;
        if (count_null == data.length) {//если ничего не введено
            JOptionPane.showMessageDialog(null, "Выберите критерии поиска и повторите попытку!", "Результат поиска", JOptionPane.INFORMATION_MESSAGE);
        } else {
            int result = Order.searchOrder(data);
            if (result == 0) {//если что-то найдено
                Order.order = null;//обнуление
                ResultTable.requestFocus();
            } else {
                deleteRows();//удаление строк из таблицы
                JOptionPane.showMessageDialog(null, "Не найдено!", "Результат поиска", JOptionPane.INFORMATION_MESSAGE);
            }
        }

    }

    private void ResultTableMouseClicked() {

    }

    //удаляет все строки из таблицы
    private void deleteRows() {
        model.setRowCount(0);
    }

}
