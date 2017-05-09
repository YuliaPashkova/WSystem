package GUI;
import WORK.Access;

import javax.swing.*;
/**
 * Created by Юлия on 20.04.2017.
 */
public class GJournalOrders extends javax.swing.JDialog {
    private javax.swing.JButton ClearButton;
    private org.jdesktop.swingx.JXDatePicker DateRealizDatePicker;
    private javax.swing.JLabel DateRealizLabel;
    private org.jdesktop.swingx.JXDatePicker DateRegDatePicker;
    private javax.swing.JLabel DateRegLabel;
    private javax.swing.JLabel NoteLabel;
    private javax.swing.JTextArea NoteTextArea;
    private javax.swing.JLabel NumAccLabel;
    private javax.swing.JTextField NumAccTextField;
    private javax.swing.JLabel NumOrderLabel;
    private javax.swing.JTextField NumOrderTextField;
    private javax.swing.JLabel OperatorLabel;
    private javax.swing.JTextField OperatorTextField;
    private javax.swing.JTable ResultTable;
    private javax.swing.JButton SearchButton;
    private javax.swing.JLabel SerialNumLabel;
    private javax.swing.JTextField SerialNumTextField;
    private javax.swing.JComboBox<String> StatusComboBox;
    private javax.swing.JLabel StatusLabel;
    private javax.swing.JLabel SumLabel;
    private javax.swing.JTextField SumTextField;
    private javax.swing.JComboBox<String> TypeWorkComboBox;
    private javax.swing.JLabel TypeWorkLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public GJournalOrders(java.awt.Frame parent) {
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
        } catch (ClassNotFoundException | UnsupportedLookAndFeelException | IllegalAccessException | InstantiationException ex) {
            java.util.logging.Logger.getLogger(GJournalOrders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GJournalOrders(null).setVisible(true);
            }
        });
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        DateRegDatePicker = new org.jdesktop.swingx.JXDatePicker();
        DateRegDatePicker.setFormats("yyyy-MM-dd");
        DateRegDatePicker.setDate(null);
        DateRegDatePicker.setLinkDate(System.currentTimeMillis(), "Сегодня {0}");
        DateRealizDatePicker = new org.jdesktop.swingx.JXDatePicker();
        DateRealizDatePicker.setFormats("yyyy-MM-dd");
        DateRealizDatePicker.setDate(null);
        DateRealizDatePicker.setLinkDate(System.currentTimeMillis(), "Сегодня {0}");
        SumLabel = new javax.swing.JLabel();
        SumTextField = new javax.swing.JTextField();
        SearchButton = new javax.swing.JButton();
        NoteLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        NoteTextArea = new javax.swing.JTextArea();
        SerialNumLabel = new javax.swing.JLabel();
        SerialNumTextField = new javax.swing.JTextField();
        ClearButton = new javax.swing.JButton();
        TypeWorkLabel = new javax.swing.JLabel();
        TypeWorkComboBox = new javax.swing.JComboBox<>();
        OperatorTextField = new javax.swing.JTextField();
        NumOrderTextField = new javax.swing.JTextField();
        NumOrderLabel = new javax.swing.JLabel();
        NumAccTextField = new javax.swing.JTextField();
        NumAccLabel = new javax.swing.JLabel();
        StatusLabel = new javax.swing.JLabel();
        OperatorLabel = new javax.swing.JLabel();
        DateRealizLabel = new javax.swing.JLabel();
        DateRegLabel = new javax.swing.JLabel();
        StatusComboBox = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        ResultTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Журнал заказов ("+ Access.name_operator+")");
        ImageIcon icon = new ImageIcon("src\\main\\resources\\main_icon\\main_icon.png");
        setIconImage(icon.getImage());

        SumLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        SumLabel.setText("Сумма");

        SumTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        SearchButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        SearchButton.setText("Поиск");
        SearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchButtonActionPerformed(evt);
            }
        });

        NoteLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        NoteLabel.setText("Примечание");

        NoteTextArea.setColumns(20);
        NoteTextArea.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        NoteTextArea.setRows(5);
        jScrollPane1.setViewportView(NoteTextArea);

        SerialNumLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        SerialNumLabel.setText("Заводской номер водомера");

        SerialNumTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        ClearButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ClearButton.setText("Очистить форму");

        TypeWorkLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        TypeWorkLabel.setText("Тип работы");

        TypeWorkComboBox.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        TypeWorkComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "НЕ ВЫБРАНО", "УСТАНОВКА ВОДОМЕРА", "СНЯТИЕ ВОДОМЕРА" }));
        TypeWorkComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TypeWorkComboBoxActionPerformed(evt);
            }
        });

        OperatorTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        OperatorTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OperatorTextFieldActionPerformed(evt);
            }
        });

        NumOrderTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        NumOrderTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NumOrderTextFieldActionPerformed(evt);
            }
        });

        NumOrderLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        NumOrderLabel.setText("Номер заказа");

        NumAccTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        NumAccTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NumAccTextFieldActionPerformed(evt);
            }
        });

        NumAccLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        NumAccLabel.setText("№ лицевого счета");

        StatusLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        StatusLabel.setText("Статус");

        OperatorLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        OperatorLabel.setText("Оператор");

        DateRealizLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        DateRealizLabel.setText("Дата выполнения");

        DateRegLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        DateRegLabel.setText("Дата оформления");

        StatusComboBox.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        StatusComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ОТКРЫТ", "ЗАКРЫТ" }));

        ResultTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "№ л/счета", "№ заказа", "Тип работ", "Заводской номер водомера"
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
                ResultTableMouseClicked(evt);
            }
        });
        ResultTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ResultTableKeyPressed(evt);
            }
        });
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
                                                                .addComponent(NumOrderLabel))
                                                        .addComponent(DateRegLabel)
                                                        .addComponent(DateRegDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                        .addComponent(NumAccTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(NumAccLabel, javax.swing.GroupLayout.Alignment.LEADING))
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGap(34, 34, 34)
                                                                                .addComponent(StatusLabel))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(DateRealizLabel)
                                                                                        .addComponent(StatusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(SumTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(DateRealizDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(37, 37, 37)
                                                                .addComponent(SumLabel)))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(40, 40, 40)
                                                                .addComponent(OperatorLabel))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(29, 29, 29)
                                                                .addComponent(TypeWorkLabel))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(TypeWorkComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(OperatorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(SerialNumLabel)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(SerialNumTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                .addComponent(NoteLabel)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jScrollPane1)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(SearchButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(ClearButton, javax.swing.GroupLayout.Alignment.TRAILING))))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                                        .addComponent(StatusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(OperatorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(DateRegLabel)
                                        .addComponent(SumLabel)
                                        .addComponent(DateRealizLabel)
                                        .addComponent(TypeWorkLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(DateRealizDatePicker, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(DateRegDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(SumTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(TypeWorkComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(9, 9, 9)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(SerialNumLabel)
                                        .addComponent(SerialNumTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                        .addGap(45, 45, 45)
                                                        .addComponent(ClearButton)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(SearchButton))
                                                .addGroup(layout.createSequentialGroup()
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(NoteLabel)))
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

    private void SearchButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void TypeWorkComboBoxActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void OperatorTextFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void NumOrderTextFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void NumAccTextFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void ResultTableMouseClicked(java.awt.event.MouseEvent evt) {

    }

    private void ResultTableKeyPressed(java.awt.event.KeyEvent evt) {
        // TODO add your handling code here:
    }

}
