package GUI;
import javax.swing.*;
/*
 * Created by Юлия on 18.04.2017.
 */
public class GNewWatermeter extends javax.swing.JDialog {
    private javax.swing.JLabel CaliberLabel;
    private javax.swing.JTextField CaliberTextField;
    private javax.swing.JButton CancelButton;
    private org.jdesktop.swingx.JXDatePicker CheckLastIndicatDatePicker;
    private javax.swing.JLabel CheckLastIndicatLabel;
    private javax.swing.JButton ClearButton;
    private javax.swing.JLabel CodeWatconLabel;
    private javax.swing.JTextField CodeWatconTextField;
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
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | UnsupportedLookAndFeelException | IllegalAccessException | InstantiationException ex) {
            java.util.logging.Logger.getLogger(GNewWatermeter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GNewWatermeter(null).setVisible(true);
            }
        });
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        CodeWatconLabel = new javax.swing.JLabel();
        CodeWatconTextField = new javax.swing.JTextField();
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
        DateSetDatePicker.setFormats("yyy-MM-dd");
        DateSetDatePicker.setDate(null);
        DateSetDatePicker.setLinkDate(System.currentTimeMillis(), "Сегодня {0}");
        DateSetLabel = new javax.swing.JLabel();
        PrimIndicatLabel = new javax.swing.JLabel();
        PrimIndicatTextField = new javax.swing.JTextField();
        DateCheckDatePicker = new org.jdesktop.swingx.JXDatePicker();
        DateCheckDatePicker.setFormats("yyy-MM-dd");
        DateCheckDatePicker.setDate(null);
        DateCheckDatePicker.setLinkDate(System.currentTimeMillis(), "Сегодня {0}");
        EnterExploitLabel = new javax.swing.JLabel();
        EnterExploitDatePicker = new org.jdesktop.swingx.JXDatePicker();
        EnterExploitDatePicker.setFormats("yyy-MM-dd");
        EnterExploitDatePicker.setDate(null);
        EnterExploitDatePicker.setLinkDate(System.currentTimeMillis(), "Сегодня {0}");
        SealDatePicker = new org.jdesktop.swingx.JXDatePicker();
        SealDatePicker.setFormats("yyy-MM-dd");
        SealDatePicker.setDate(null);
        SealDatePicker.setLinkDate(System.currentTimeMillis(), "Сегодня {0}");
        SealLabel = new javax.swing.JLabel();
        LastIndicatLabel = new javax.swing.JLabel();
        LastIndicatTextField = new javax.swing.JTextField();
        CheckLastIndicatLabel = new javax.swing.JLabel();
        CheckLastIndicatDatePicker = new org.jdesktop.swingx.JXDatePicker();
        CheckLastIndicatDatePicker.setFormats("yyy-MM-dd");
        CheckLastIndicatDatePicker.setDate(null);
        CheckLastIndicatDatePicker.setLinkDate(System.currentTimeMillis(), "Сегодня {0}");
        StatusLabel = new javax.swing.JLabel();
        ClearButton = new javax.swing.JButton();
        OkButton = new javax.swing.JButton();
        CancelButton = new javax.swing.JButton();
        StatusComboBox = new javax.swing.JComboBox<>();
        InstalledComboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Новый водомер");
        ImageIcon icon = new ImageIcon("src\\main\\resources\\main_icon\\main_icon.png");
        setIconImage(icon.getImage());
        setResizable(false);

        CodeWatconLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        CodeWatconLabel.setText("Код ВП");

        CodeWatconTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        CodeWatconTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CodeWatconTextFieldActionPerformed(evt);
            }
        });

        TypeLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        TypeLabel.setText("Тип водомера");

        TypeTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        TypeTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TypeTextFieldActionPerformed(evt);
            }
        });

        InventNumLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        InventNumLabel.setText("Инвентарный №");

        InventNumTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        InventNumTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InventNumTextFieldActionPerformed(evt);
            }
        });

        SerialNumLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        SerialNumLabel.setText("Заводской №");

        SerialNumTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        SerialNumTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SerialNumTextFieldActionPerformed(evt);
            }
        });

        ReleaseYearLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ReleaseYearLabel.setText("Год выпуска");

        ReleaseYearTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ReleaseYearTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReleaseYearTextFieldActionPerformed(evt);
            }
        });

        DateCheckLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        DateCheckLabel.setText("Поверка");

        CaliberLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        CaliberLabel.setText("Калибр");

        CaliberTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        CaliberTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CaliberTextFieldActionPerformed(evt);
            }
        });

        InstalledlLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        InstalledlLabel.setText("Установлен (кем)");

        DateSetDatePicker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DateSetDatePickerActionPerformed(evt);
            }
        });

        DateSetLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        DateSetLabel.setText("Дата установки");

        PrimIndicatLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        PrimIndicatLabel.setText("Начальные показания");

        PrimIndicatTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        PrimIndicatTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrimIndicatTextFieldActionPerformed(evt);
            }
        });

        DateCheckDatePicker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DateCheckDatePickerActionPerformed(evt);
            }
        });

        EnterExploitLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        EnterExploitLabel.setText("Ввод в экспл.");

        EnterExploitDatePicker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnterExploitDatePickerActionPerformed(evt);
            }
        });

        SealDatePicker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SealDatePickerActionPerformed(evt);
            }
        });

        SealLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        SealLabel.setText("Опломбирован");

        LastIndicatLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        LastIndicatLabel.setText("Последние показания");

        LastIndicatTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        LastIndicatTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LastIndicatTextFieldActionPerformed(evt);
            }
        });

        CheckLastIndicatLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        CheckLastIndicatLabel.setText("Дата снятия последних показаний");

        CheckLastIndicatDatePicker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckLastIndicatDatePickerActionPerformed(evt);
            }
        });

        StatusLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        StatusLabel.setText("Состояние");

        ClearButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ClearButton.setText("Очистить форму");
        ClearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearButtonActionPerformed(evt);
            }
        });

        OkButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        OkButton.setText("ОК");
        OkButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OkButtonActionPerformed(evt);
            }
        });

        CancelButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        CancelButton.setText("Отмена");
        CancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelButtonActionPerformed(evt);
            }
        });

        StatusComboBox.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        StatusComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "НЕ ВЫБРАНО", "РАБОЧЕЕ", "НЕ РАБОЧЕЕ" }));
        StatusComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StatusComboBoxActionPerformed(evt);
            }
        });

        InstalledComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "НЕ ВЫБРАНО", "ГУПС ВОДОКАНАЛ", "АБОНЕНТ" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(14, 14, 14)
                                                                .addComponent(CodeWatconLabel)
                                                                .addGap(228, 228, 228)
                                                                .addComponent(SerialNumLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(ReleaseYearLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(22, 22, 22)
                                                                .addComponent(CaliberLabel))
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                        .addComponent(StatusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(DateSetDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(InstalledComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                        .addComponent(CodeWatconTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                                .addComponent(TypeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                                .addComponent(TypeTextField)))
                                                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                                        .addGap(34, 34, 34)
                                                                                        .addComponent(StatusLabel)))
                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                        .addGap(18, 18, 18)
                                                                                        .addComponent(InventNumLabel)
                                                                                        .addGap(0, 0, Short.MAX_VALUE))
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                .addComponent(DateSetLabel)
                                                                                                .addComponent(InventNumTextField))))
                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                        .addComponent(SerialNumTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addGap(6, 6, 6)
                                                                                        .addComponent(ReleaseYearTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                        .addComponent(CaliberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                        .addGap(71, 71, 71)
                                                                                        .addComponent(InstalledlLabel))))))
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
                                                                                .addComponent(LastIndicatLabel)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(LastIndicatTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                                                                                                .addComponent(CheckLastIndicatDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))))
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
                                        .addComponent(CodeWatconTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(TypeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(InventNumTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(SerialNumTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(ReleaseYearTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(CaliberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void ClearButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void OkButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void TypeTextFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void CodeWatconTextFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void InventNumTextFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void ReleaseYearTextFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void SerialNumTextFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void CaliberTextFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void DateSetDatePickerActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void EnterExploitDatePickerActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void SealDatePickerActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void DateCheckDatePickerActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void PrimIndicatTextFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void LastIndicatTextFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void CheckLastIndicatDatePickerActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void StatusComboBoxActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }
}
