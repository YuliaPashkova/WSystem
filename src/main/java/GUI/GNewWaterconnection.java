package GUI;
import WORK.Access;

import javax.swing.*;
/**
 * Created by Юлия on 19.04.2017.
 */
public class GNewWaterconnection extends javax.swing.JDialog {
    private javax.swing.JButton CancelButton;
    private javax.swing.JButton ClearButton;
    private javax.swing.JLabel CodeWatconLabel;
    private javax.swing.JTextField CodeWatconTextField;
    private org.jdesktop.swingx.JXDatePicker DateTYDatePicker;
    private javax.swing.JLabel DateTYLabel;
    private javax.swing.JLabel DepthLabel;
    private javax.swing.JTextField DepthTextField;
    private javax.swing.JLabel LocationLabel;
    private javax.swing.JTextField LocationTextField;
    private javax.swing.JLabel NoteLabel;
    private javax.swing.JTextArea NoteTextArea;
    private javax.swing.JLabel NumTYLabel;
    private javax.swing.JTextField NumTYTextField;
    private javax.swing.JLabel ObjectConLabel;
    private javax.swing.JTextField ObjectConTextField;
    private javax.swing.JButton OkButton;
    private javax.swing.JComboBox<String> OwnerComboBox;
    private javax.swing.JLabel OwnerLabel;
    private javax.swing.JLabel OwnerTerLabel;
    private javax.swing.JTextField OwnerTerTextField;
    private javax.swing.JComboBox<String> StatusComboBox;
    private javax.swing.JLabel StatusLabel;
    private javax.swing.JComboBox<String> TypeConComboBox;
    private javax.swing.JLabel TypeConLabel;
    private javax.swing.JScrollPane jScrollPane2;
    public GNewWaterconnection(java.awt.Frame parent) {
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
        } catch (ClassNotFoundException | InstantiationException | UnsupportedLookAndFeelException | IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GNewWaterconnection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GNewWaterconnection(null).setVisible(true);
            }
        });
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        CodeWatconLabel = new javax.swing.JLabel();
        CodeWatconTextField = new javax.swing.JTextField();
        NumTYLabel = new javax.swing.JLabel();
        NumTYTextField = new javax.swing.JTextField();
        DateTYLabel = new javax.swing.JLabel();
        DateTYDatePicker = new org.jdesktop.swingx.JXDatePicker();
        DateTYDatePicker.setFormats("yyyy-MM-dd");
        DateTYDatePicker.setDate(null);
        DateTYDatePicker.setLinkDate(System.currentTimeMillis(), "Сегодня {0}");
        StatusLabel = new javax.swing.JLabel();
        OwnerLabel = new javax.swing.JLabel();
        ObjectConLabel = new javax.swing.JLabel();
        TypeConLabel = new javax.swing.JLabel();
        ObjectConTextField = new javax.swing.JTextField();
        OwnerTerLabel = new javax.swing.JLabel();
        OwnerTerTextField = new javax.swing.JTextField();
        LocationLabel = new javax.swing.JLabel();
        DepthLabel = new javax.swing.JLabel();
        LocationTextField = new javax.swing.JTextField();
        DepthTextField = new javax.swing.JTextField();
        NoteLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        NoteTextArea = new javax.swing.JTextArea();
        ClearButton = new javax.swing.JButton();
        OkButton = new javax.swing.JButton();
        CancelButton = new javax.swing.JButton();
        OwnerComboBox = new javax.swing.JComboBox<>();
        TypeConComboBox = new javax.swing.JComboBox<>();
        StatusComboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Новое водомерное подключение ("+ Access.name_operator+")");
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

        NumTYLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        NumTYLabel.setText("№ ТУ");

        NumTYTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        NumTYTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NumTYTextFieldActionPerformed(evt);
            }
        });

        DateTYLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        DateTYLabel.setText("Дата ТУ");

        DateTYDatePicker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DateTYDatePickerActionPerformed(evt);
            }
        });

        StatusLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        StatusLabel.setText("Состояние");

        OwnerLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        OwnerLabel.setText("Принадлежность ВП");

        ObjectConLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ObjectConLabel.setText("Объект подключения");

        TypeConLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        TypeConLabel.setText("Вид подключения");

        ObjectConTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ObjectConTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ObjectConTextFieldActionPerformed(evt);
            }
        });

        OwnerTerLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        OwnerTerLabel.setText("Принадлежность территории");

        OwnerTerTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        OwnerTerTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OwnerTerTextFieldActionPerformed(evt);
            }
        });

        LocationLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        LocationLabel.setText("Местонахождение ВП");

        DepthLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        DepthLabel.setText("Глубина (м)");

        LocationTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        LocationTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LocationTextFieldActionPerformed(evt);
            }
        });

        DepthTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        DepthTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DepthTextFieldActionPerformed(evt);
            }
        });

        NoteLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        NoteLabel.setText("Примечание");

        NoteTextArea.setColumns(20);
        NoteTextArea.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        NoteTextArea.setRows(5);
        jScrollPane2.setViewportView(NoteTextArea);

        ClearButton.setText("Очистить форму");
        ClearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearButtonActionPerformed(evt);
            }
        });

        OkButton.setText("ОК");
        OkButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OkButtonActionPerformed(evt);
            }
        });

        CancelButton.setText("Отмена");
        CancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelButtonActionPerformed(evt);
            }
        });

        OwnerComboBox.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        OwnerComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "НЕ ВЫБРАНО", "ГУПС ВОДОКАНАЛ", "АБОНЕНТ" }));
        OwnerComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OwnerComboBoxActionPerformed(evt);
            }
        });

        TypeConComboBox.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        TypeConComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "НЕ ВЫБРАНО", "ОДИНОЧНОЕ", "КОЛЛЕКТИВНОЕ" }));
        TypeConComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TypeConComboBoxActionPerformed(evt);
            }
        });

        StatusComboBox.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        StatusComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "НЕ ВЫБРАНО", "РАБОЧЕЕ", "НЕ РАБОЧЕЕ" }));
        StatusComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StatusComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(ClearButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(OkButton, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(CancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(24, 24, 24)
                                                .addComponent(TypeConLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(OwnerTerLabel)
                                                .addGap(31, 31, 31))
                                        .addComponent(CodeWatconTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(17, 17, 17)
                                                .addComponent(CodeWatconLabel)
                                                .addGap(38, 38, 38)
                                                .addComponent(NumTYLabel)
                                                .addGap(55, 55, 55)
                                                .addComponent(DateTYLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(StatusLabel)
                                                .addGap(24, 24, 24))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(79, 79, 79)
                                                .addComponent(LocationLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(DepthLabel)
                                                .addGap(17, 17, 17))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(LocationTextField)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(DepthTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(153, 153, 153)
                                                .addComponent(NoteLabel))
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(TypeConComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(OwnerComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addGap(77, 77, 77)
                                                                        .addComponent(NumTYTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addGap(10, 10, 10)
                                                                        .addComponent(OwnerLabel))))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGap(60, 60, 60)
                                                                                .addComponent(ObjectConLabel))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(DateTYDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(StatusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(ObjectConTextField, javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(OwnerTerTextField, javax.swing.GroupLayout.Alignment.TRAILING))))))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(NumTYLabel)
                                                .addComponent(CodeWatconLabel))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(DateTYLabel)
                                                .addComponent(StatusLabel)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(CodeWatconTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(NumTYTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(DateTYDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(StatusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(7, 7, 7)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(ObjectConLabel)
                                        .addComponent(OwnerLabel))
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(ObjectConTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(OwnerComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(OwnerTerLabel)
                                        .addComponent(TypeConLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(OwnerTerTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(TypeConComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(DepthLabel)
                                        .addComponent(LocationLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(DepthTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(LocationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(NoteLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(ClearButton)
                                        .addComponent(OkButton)
                                        .addComponent(CancelButton))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>

    private void CodeWatconTextFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void NumTYTextFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void DateTYDatePickerActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void ObjectConTextFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void OwnerTerTextFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void LocationTextFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void DepthTextFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void ClearButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void OkButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void OwnerComboBoxActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void TypeConComboBoxActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void StatusComboBoxActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }
}
