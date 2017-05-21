package GUI;
import WORK.Access;
import WORK.Order;
import WORK.Watermeter;
import org.jdesktop.swingx.JXDatePicker;

import javax.swing.*;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/*
 * Created by Юлия on 18.04.2017.
 */
public class GNewWatermeter extends javax.swing.JDialog {
    javax.swing.JComboBox<String> CodeComboBox;
    boolean order =false;//флаг заказа (true, если водомер создается из заказа)
    private JTextField textfields [];//массив текстовых полей
    private JComboBox comboboxes[];//массив комбобоксов
    private JXDatePicker datepickers[];//массив дэйткиперов
    private javax.swing.JTextField CaliberTextField;
    private org.jdesktop.swingx.JXDatePicker CheckLastIndicatDatePicker;
    private org.jdesktop.swingx.JXDatePicker DateCheckDatePicker;
    private org.jdesktop.swingx.JXDatePicker DateSetDatePicker;
    private org.jdesktop.swingx.JXDatePicker EnterExploitDatePicker;
    private javax.swing.JComboBox<String> InstalledComboBox;
    private javax.swing.JTextField InventNumTextField;
    private javax.swing.JTextField LastIndicatTextField;
    private javax.swing.JTextField PrimIndicatTextField;
    private javax.swing.JTextField ReleaseYearTextField;
    private org.jdesktop.swingx.JXDatePicker SealDatePicker;
    private javax.swing.JTextField SerialNumTextField;
    private javax.swing.JComboBox<String> StatusComboBox;
    private javax.swing.JTextField TypeTextField;
    GNewWatermeter(java.awt.Frame parent) {
        super(parent, true);
        initComponents();
        initArray();
    }
    private GNewWatermeter() {
        initComponents();
        initArray();
    }

    GNewWatermeter(java.awt.Dialog parent) {
        super(parent, true);
        initComponents();
        initArray();
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | UnsupportedLookAndFeelException | IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GNewWatermeter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> new GNewWatermeter().setVisible(true));
    }

    private void initArray() {
        textfields = new JTextField[]{TypeTextField,InventNumTextField,SerialNumTextField,ReleaseYearTextField,
                CaliberTextField,PrimIndicatTextField,LastIndicatTextField};
        comboboxes = new JComboBox[]{CodeComboBox,StatusComboBox,InstalledComboBox};
        datepickers = new JXDatePicker[]{DateSetDatePicker,EnterExploitDatePicker,SealDatePicker,DateCheckDatePicker,CheckLastIndicatDatePicker};

    }

    private void initComponents() {
        JLabel codeWatconLabel = new JLabel();
        JLabel typeLabel = new JLabel();
        TypeTextField = new javax.swing.JTextField();
        JLabel inventNumLabel = new JLabel();
        InventNumTextField = new javax.swing.JTextField();
        JLabel serialNumLabel = new JLabel();
        SerialNumTextField = new javax.swing.JTextField();
        JLabel releaseYearLabel = new JLabel();
        ReleaseYearTextField = new javax.swing.JTextField();
        JLabel dateCheckLabel = new JLabel();
        JLabel caliberLabel = new JLabel();
        CaliberTextField = new javax.swing.JTextField();
        JLabel installedlLabel = new JLabel();
        DateSetDatePicker = new org.jdesktop.swingx.JXDatePicker();
        DateSetDatePicker.setFormats("yyyy-MM-dd");
        DateSetDatePicker.setDate(null);
        DateSetDatePicker.setLinkDate(System.currentTimeMillis(), "Сегодня {0}");
        JLabel dateSetLabel = new JLabel();
        JLabel primIndicatLabel = new JLabel();
        PrimIndicatTextField = new javax.swing.JTextField();
        DateCheckDatePicker = new org.jdesktop.swingx.JXDatePicker();
        DateCheckDatePicker.setFormats("yyyy-MM-dd");
        DateCheckDatePicker.setDate(null);
        DateCheckDatePicker.setLinkDate(System.currentTimeMillis(), "Сегодня {0}");
        JLabel enterExploitLabel = new JLabel();
        EnterExploitDatePicker = new org.jdesktop.swingx.JXDatePicker();
        EnterExploitDatePicker.setFormats("yyyy-MM-dd");
        EnterExploitDatePicker.setDate(null);
        EnterExploitDatePicker.setLinkDate(System.currentTimeMillis(), "Сегодня {0}");
        SealDatePicker = new org.jdesktop.swingx.JXDatePicker();
        SealDatePicker.setFormats("yyyy-MM-dd");
        SealDatePicker.setDate(null);
        SealDatePicker.setLinkDate(System.currentTimeMillis(), "Сегодня {0}");
        JLabel sealLabel = new JLabel();
        JLabel lastIndicatLabel = new JLabel();
        LastIndicatTextField = new javax.swing.JTextField();
        JLabel checkLastIndicatLabel = new JLabel();
        CheckLastIndicatDatePicker = new org.jdesktop.swingx.JXDatePicker();
        CheckLastIndicatDatePicker.setFormats("yyyy-MM-dd");
        CheckLastIndicatDatePicker.setDate(null);
        CheckLastIndicatDatePicker.setLinkDate(System.currentTimeMillis(), "Сегодня {0}");
        JLabel statusLabel = new JLabel();
        JButton clearButton = new JButton();
        JButton okButton = new JButton();
        JButton cancelButton = new JButton();
        StatusComboBox = new javax.swing.JComboBox<>();
        InstalledComboBox = new javax.swing.JComboBox<>();
        CodeComboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Новый водомер ("+ Access.name_operator+")");
        ImageIcon icon = new ImageIcon("src\\main\\resources\\main_icon\\main_icon.png");
        setIconImage(icon.getImage());
        setResizable(false);

        codeWatconLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        codeWatconLabel.setText("Код ВП");

        typeLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        typeLabel.setText("Тип водомера");


        inventNumLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        inventNumLabel.setText("Инвентарный №");

        InventNumTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N


        serialNumLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        serialNumLabel.setText("Заводской №");

        SerialNumTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        releaseYearLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        releaseYearLabel.setText("Год выпуска");

        ReleaseYearTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        dateCheckLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        dateCheckLabel.setText("Поверка");

        caliberLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        caliberLabel.setText("Калибр");

        CaliberTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        installedlLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        installedlLabel.setText("Установлен (кем)");

        dateSetLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        dateSetLabel.setText("Дата установки");

        primIndicatLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        primIndicatLabel.setText("Начальные показания");

        PrimIndicatTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        enterExploitLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        enterExploitLabel.setText("Ввод в экспл.");

        sealLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        sealLabel.setText("Опломбирован");

        lastIndicatLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lastIndicatLabel.setText("Последние показания");

        LastIndicatTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        checkLastIndicatLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        checkLastIndicatLabel.setText("Дата снятия последних показаний");

        statusLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        statusLabel.setText("Состояние");

        clearButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        clearButton.setText("Очистить форму");
        clearButton.addActionListener(evt -> ClearButtonActionPerformed());

        okButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        okButton.setText("ОК");
        okButton.addActionListener(evt -> {
            try {
                AddNewWatermButtonActionPerformed();
            } catch (ParseException | SQLException e) {
                e.printStackTrace();
            }
        });

        cancelButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cancelButton.setText("Отмена");
        cancelButton.addActionListener(evt -> CancelButtonActionPerformed());

        StatusComboBox.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        StatusComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "НЕ ВЫБРАНО", "РАБОЧЕЕ", "НЕ РАБОЧЕЕ" }));

        InstalledComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "НЕ ВЫБРАНО", "ГУПС ВОДОКАНАЛ", "АБОНЕНТ" }));

        CodeComboBox.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                .addComponent(StatusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(DateSetDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(InstalledComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                                                .addComponent(typeLabel))
                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                .addComponent(CodeComboBox, 0, 112, Short.MAX_VALUE)
                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(TypeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                .addGap(18, 18, 18)
                                                                                                .addComponent(inventNumLabel))
                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(InventNumTextField)))
                                                                                .addGap(0, 6, Short.MAX_VALUE))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGap(34, 34, 34)
                                                                                .addComponent(statusLabel)
                                                                                .addGap(56, 56, 56)
                                                                                .addComponent(dateSetLabel)
                                                                                .addGap(0, 0, Short.MAX_VALUE)))
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGap(71, 71, 71)
                                                                                .addComponent(installedlLabel))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(SerialNumTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(6, 6, 6)
                                                                                .addComponent(ReleaseYearTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(CaliberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                .addGap(14, 14, 14)
                                                                .addComponent(codeWatconLabel)
                                                                .addGap(278, 278, 278)
                                                                .addComponent(serialNumLabel)
                                                                .addGap(26, 26, 26)
                                                                .addComponent(releaseYearLabel)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(caliberLabel)
                                                                .addGap(10, 10, 10)))
                                                .addGap(13, 13, 13))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(clearButton)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGap(10, 10, 10)
                                                                                .addComponent(enterExploitLabel)
                                                                                .addGap(39, 39, 39)
                                                                                .addComponent(sealLabel)
                                                                                .addGap(43, 43, 43)
                                                                                .addComponent(dateCheckLabel))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                .addComponent(primIndicatLabel)
                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                                .addComponent(PrimIndicatTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                .addComponent(EnterExploitDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(SealDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(DateCheckDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                .addComponent(checkLastIndicatLabel)
                                                                                                .addGap(6, 6, 6)
                                                                                                .addComponent(CheckLastIndicatDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(lastIndicatLabel)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(LastIndicatTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addGap(0, 0, Short.MAX_VALUE)))
                                                .addContainerGap())))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(codeWatconLabel)
                                        .addComponent(typeLabel)
                                        .addComponent(inventNumLabel)
                                        .addComponent(releaseYearLabel)
                                        .addComponent(caliberLabel)
                                        .addComponent(serialNumLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(TypeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(InventNumTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(SerialNumTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(ReleaseYearTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(CaliberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(CodeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(statusLabel)
                                        .addComponent(dateSetLabel)
                                        .addComponent(installedlLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(DateSetDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(StatusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(InstalledComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(enterExploitLabel)
                                        .addComponent(sealLabel)
                                        .addComponent(dateCheckLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(EnterExploitDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(SealDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(DateCheckDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(16, 16, 16)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(primIndicatLabel)
                                        .addComponent(PrimIndicatTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(checkLastIndicatLabel)
                                        .addComponent(CheckLastIndicatDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lastIndicatLabel)
                                        .addComponent(LastIndicatTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(cancelButton)
                                                .addComponent(okButton))
                                        .addComponent(clearButton))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>

    private void ClearButtonActionPerformed() {
        for (JTextField textfield : textfields) textfield.setText(null);
        for (JComboBox comboboxe : comboboxes) comboboxe.setSelectedIndex(0);
        for (JXDatePicker datepicker : datepickers) datepicker.setDate(null);
    }

    private void AddNewWatermButtonActionPerformed() throws ParseException, SQLException {
        switch(Watermeter.addWatermeter(readData())){
            case 0:
                JOptionPane.showMessageDialog(null,"Новый водомер был добавлен!", "Результат добавления", JOptionPane.INFORMATION_MESSAGE);
                if(order) Order.setCloseStatus(GCloseOrder.num_order,textfields[2].getText());//изменяем статус с ОТКРЫТ на ЗАКРЫТ и заисываем номер добавленного водомера
                dispose();
                break;
            case -1:
                JOptionPane.showMessageDialog(null, Watermeter.error, "Ошибка", JOptionPane.ERROR_MESSAGE);
                break;
        }
    }

    private void CancelButtonActionPerformed() {
       dispose();
    }

    /*
     Метод считывает данные из всех полей и возвращает их в виде массива
     */
    private String[] readData() {
        String datafields [] = new String [15];//данные
        for(int i=0;i<textfields.length;i++)//считывание данных
            datafields[i]=textfields[i].getText();
        for(int i=textfields.length,j=0;i<comboboxes.length +textfields.length;i++,j++)
            datafields[i]=(String)comboboxes[j].getSelectedItem();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        for(int i=textfields.length+comboboxes.length,j=0;i<textfields.length+comboboxes.length+datepickers.length;i++,j++){
            try{
                datafields[i] = dateFormat.format(datepickers[j].getDate());//
            }catch (NullPointerException ex){
                datafields[i]= null;
            }
        }
        for(int i=0;i<datafields.length;i++)
            if(datafields[i]!=null) datafields[i]=datafields[i].toUpperCase();
        return datafields;
    }
}