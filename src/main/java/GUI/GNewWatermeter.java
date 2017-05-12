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
    public javax.swing.JComboBox<String> CodeComboBox;
    public JTextField textfields [];//массив текстовых полей
    public boolean order =false;//флаг заказа (true, если водомер создается из заказа)
    private JComboBox comboboxes[];//массив комбобоксов
    private JXDatePicker datepickers[];//массив дэйткиперов
    private javax.swing.JLabel CaliberLabel;
    private javax.swing.JTextField CaliberTextField;
    private javax.swing.JButton CancelButton;
    private org.jdesktop.swingx.JXDatePicker CheckLastIndicatDatePicker;
    private javax.swing.JLabel CheckLastIndicatLabel;
    private javax.swing.JButton ClearButton;
    private javax.swing.JLabel CodeWatconLabel;
    private org.jdesktop.swingx.JXDatePicker DateCheckDatePicker;
    private javax.swing.JLabel DateCheckLabel;
    private org.jdesktop.swingx.JXDatePicker DateSetDatePicker;
    private javax.swing.JLabel DateSetLabel;
    private org.jdesktop.swingx.JXDatePicker EnterExploitDatePicker;
    private javax.swing.JLabel EnterExploitLabel;
    private javax.swing.JComboBox<String> InstalledComboBox;
    private javax.swing.JLabel InstalledlLabel;
    private javax.swing.JLabel InventNumLabel;
    private javax.swing.JTextField InventNumTextField;
    private javax.swing.JLabel LastIndicatLabel;
    private javax.swing.JTextField LastIndicatTextField;
    private javax.swing.JButton OkButton;
    private javax.swing.JLabel PrimIndicatLabel;
    private javax.swing.JTextField PrimIndicatTextField;
    private javax.swing.JLabel ReleaseYearLabel;
    private javax.swing.JTextField ReleaseYearTextField;
    private org.jdesktop.swingx.JXDatePicker SealDatePicker;
    private javax.swing.JLabel SealLabel;
    private javax.swing.JLabel SerialNumLabel;
    private javax.swing.JTextField SerialNumTextField;
    private javax.swing.JComboBox<String> StatusComboBox;
    private javax.swing.JLabel StatusLabel;
    private javax.swing.JLabel TypeLabel;
    private javax.swing.JTextField TypeTextField;
    public GNewWatermeter(java.awt.Frame parent) {
        super(parent, true);
        initComponents();
        initArray();
    }
    public GNewWatermeter() {
        initComponents();
        initArray();
    }

    public GNewWatermeter(java.awt.Dialog parent) {
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
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GNewWatermeter().setVisible(true);
            }
        });
    }

    private void initArray() {
        textfields = new JTextField[]{TypeTextField,InventNumTextField,SerialNumTextField,ReleaseYearTextField,
                CaliberTextField,PrimIndicatTextField,LastIndicatTextField};
        comboboxes = new JComboBox[]{CodeComboBox,StatusComboBox,InstalledComboBox};
        datepickers = new JXDatePicker[]{DateSetDatePicker,EnterExploitDatePicker,SealDatePicker,DateCheckDatePicker,CheckLastIndicatDatePicker};

    }

    private void initComponents() {
        CodeWatconLabel = new javax.swing.JLabel();
        TypeLabel = new javax.swing.JLabel();
        TypeTextField = new javax.swing.JTextField();
        InventNumLabel = new javax.swing.JLabel();
        InventNumTextField = new javax.swing.JTextField();
        SerialNumLabel = new javax.swing.JLabel();
        SerialNumTextField = new javax.swing.JTextField();
        ReleaseYearLabel = new javax.swing.JLabel();
        ReleaseYearTextField = new javax.swing.JTextField();
        DateCheckLabel = new javax.swing.JLabel();
        CaliberLabel = new javax.swing.JLabel();
        CaliberTextField = new javax.swing.JTextField();
        InstalledlLabel = new javax.swing.JLabel();
        DateSetDatePicker = new org.jdesktop.swingx.JXDatePicker();
        DateSetDatePicker.setFormats("yyyy-MM-dd");
        DateSetDatePicker.setDate(null);
        DateSetDatePicker.setLinkDate(System.currentTimeMillis(), "Сегодня {0}");
        DateSetLabel = new javax.swing.JLabel();
        PrimIndicatLabel = new javax.swing.JLabel();
        PrimIndicatTextField = new javax.swing.JTextField();
        DateCheckDatePicker = new org.jdesktop.swingx.JXDatePicker();
        DateCheckDatePicker.setFormats("yyyy-MM-dd");
        DateCheckDatePicker.setDate(null);
        DateCheckDatePicker.setLinkDate(System.currentTimeMillis(), "Сегодня {0}");
        EnterExploitLabel = new javax.swing.JLabel();
        EnterExploitDatePicker = new org.jdesktop.swingx.JXDatePicker();
        EnterExploitDatePicker.setFormats("yyyy-MM-dd");
        EnterExploitDatePicker.setDate(null);
        EnterExploitDatePicker.setLinkDate(System.currentTimeMillis(), "Сегодня {0}");
        SealDatePicker = new org.jdesktop.swingx.JXDatePicker();
        SealDatePicker.setFormats("yyyy-MM-dd");
        SealDatePicker.setDate(null);
        SealDatePicker.setLinkDate(System.currentTimeMillis(), "Сегодня {0}");
        SealLabel = new javax.swing.JLabel();
        LastIndicatLabel = new javax.swing.JLabel();
        LastIndicatTextField = new javax.swing.JTextField();
        CheckLastIndicatLabel = new javax.swing.JLabel();
        CheckLastIndicatDatePicker = new org.jdesktop.swingx.JXDatePicker();
        CheckLastIndicatDatePicker.setFormats("yyyy-MM-dd");
        CheckLastIndicatDatePicker.setDate(null);
        CheckLastIndicatDatePicker.setLinkDate(System.currentTimeMillis(), "Сегодня {0}");
        StatusLabel = new javax.swing.JLabel();
        ClearButton = new javax.swing.JButton();
        OkButton = new javax.swing.JButton();
        CancelButton = new javax.swing.JButton();
        StatusComboBox = new javax.swing.JComboBox<>();
        InstalledComboBox = new javax.swing.JComboBox<>();
        CodeComboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Новый водомер ("+ Access.name_operator+")");
        ImageIcon icon = new ImageIcon("src\\main\\resources\\main_icon\\main_icon.png");
        setIconImage(icon.getImage());
        setResizable(false);

        CodeWatconLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        CodeWatconLabel.setText("Код ВП");

        TypeLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        TypeLabel.setText("Тип водомера");


        InventNumLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        InventNumLabel.setText("Инвентарный №");

        InventNumTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N


        SerialNumLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        SerialNumLabel.setText("Заводской №");

        SerialNumTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        ReleaseYearLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ReleaseYearLabel.setText("Год выпуска");

        ReleaseYearTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        DateCheckLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        DateCheckLabel.setText("Поверка");

        CaliberLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        CaliberLabel.setText("Калибр");

        CaliberTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        InstalledlLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        InstalledlLabel.setText("Установлен (кем)");

        DateSetLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        DateSetLabel.setText("Дата установки");

        PrimIndicatLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        PrimIndicatLabel.setText("Начальные показания");

        PrimIndicatTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        EnterExploitLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        EnterExploitLabel.setText("Ввод в экспл.");

        SealLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        SealLabel.setText("Опломбирован");

        LastIndicatLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        LastIndicatLabel.setText("Последние показания");

        LastIndicatTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        CheckLastIndicatLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        CheckLastIndicatLabel.setText("Дата снятия последних показаний");

        StatusLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        StatusLabel.setText("Состояние");

        ClearButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ClearButton.setText("Очистить форму");
        ClearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearButtonActionPerformed();
            }
        });

        OkButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        OkButton.setText("ОК");
        OkButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    OkButtonActionPerformed();
                } catch (ParseException | SQLException e) {
                    e.printStackTrace();
                }
            }
        });

        CancelButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        CancelButton.setText("Отмена");
        CancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelButtonActionPerformed();
            }
        });

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
                                                                                                .addComponent(TypeLabel))
                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                .addComponent(CodeComboBox, 0, 112, Short.MAX_VALUE)
                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(TypeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                .addGap(18, 18, 18)
                                                                                                .addComponent(InventNumLabel))
                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(InventNumTextField)))
                                                                                .addGap(0, 6, Short.MAX_VALUE))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGap(34, 34, 34)
                                                                                .addComponent(StatusLabel)
                                                                                .addGap(56, 56, 56)
                                                                                .addComponent(DateSetLabel)
                                                                                .addGap(0, 0, Short.MAX_VALUE)))
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGap(71, 71, 71)
                                                                                .addComponent(InstalledlLabel))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(SerialNumTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(6, 6, 6)
                                                                                .addComponent(ReleaseYearTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(CaliberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                .addGap(14, 14, 14)
                                                                .addComponent(CodeWatconLabel)
                                                                .addGap(278, 278, 278)
                                                                .addComponent(SerialNumLabel)
                                                                .addGap(26, 26, 26)
                                                                .addComponent(ReleaseYearLabel)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(CaliberLabel)
                                                                .addGap(10, 10, 10)))
                                                .addGap(13, 13, 13))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(ClearButton)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(OkButton, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(CancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGap(10, 10, 10)
                                                                                .addComponent(EnterExploitLabel)
                                                                                .addGap(39, 39, 39)
                                                                                .addComponent(SealLabel)
                                                                                .addGap(43, 43, 43)
                                                                                .addComponent(DateCheckLabel))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                .addComponent(PrimIndicatLabel)
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
                                                                                                .addComponent(CheckLastIndicatLabel)
                                                                                                .addGap(6, 6, 6)
                                                                                                .addComponent(CheckLastIndicatDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(LastIndicatLabel)
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
                                        .addComponent(CodeWatconLabel)
                                        .addComponent(TypeLabel)
                                        .addComponent(InventNumLabel)
                                        .addComponent(ReleaseYearLabel)
                                        .addComponent(CaliberLabel)
                                        .addComponent(SerialNumLabel))
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
                                        .addComponent(StatusLabel)
                                        .addComponent(DateSetLabel)
                                        .addComponent(InstalledlLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(DateSetDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(StatusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(InstalledComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(EnterExploitLabel)
                                        .addComponent(SealLabel)
                                        .addComponent(DateCheckLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(EnterExploitDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(SealDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(DateCheckDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(16, 16, 16)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(PrimIndicatLabel)
                                        .addComponent(PrimIndicatTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(CheckLastIndicatLabel)
                                        .addComponent(CheckLastIndicatDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(LastIndicatLabel)
                                        .addComponent(LastIndicatTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(CancelButton)
                                                .addComponent(OkButton))
                                        .addComponent(ClearButton))
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

    private void OkButtonActionPerformed() throws ParseException, SQLException {
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