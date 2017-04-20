package GUI;
import javax.swing.*;
/**
 * Created by Юлия on 19.04.2017.
 */

public class GWaterconnection extends javax.swing.JDialog {
    private javax.swing.JMenuItem AcceptChangesMenuItem;
    private javax.swing.JMenuItem ChangeModeMenuItem;
    private javax.swing.JMenu ChangesMenu;
    private javax.swing.JMenuItem ClearMenuItem;
    private javax.swing.JLabel CodeWatconLabel;
    private javax.swing.JTextField CodeWatconTextField;
    private org.jdesktop.swingx.JXDatePicker DateTYDatePicker;
    private javax.swing.JLabel DateTYLabel;
    private javax.swing.JMenuItem DeleteMenuItem;
    private javax.swing.JLabel DepthLabel;
    private javax.swing.JTextField DepthTextField;
    private javax.swing.JMenu EditMenu;
    private javax.swing.JMenu JournalWatconMenu;
    private javax.swing.JLabel LocationLabel;
    private javax.swing.JTextField LocationTextField;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JLabel NoteLabel;
    private javax.swing.JTextArea NoteTextArea;
    private javax.swing.JLabel NumTYLabel;
    private javax.swing.JTextField NumTYTextField;
    private javax.swing.JLabel ObjectConLabel;
    private javax.swing.JTextField ObjectConTextField;
    private javax.swing.JComboBox<String> OwnerComboBox;
    private javax.swing.JLabel OwnerLabel;
    private javax.swing.JLabel OwnerTerLabel;
    private javax.swing.JTextField OwnerTerTextField;
    private javax.swing.JTable ResultTable;
    private javax.swing.JMenuItem SearchMenuItem;
    private javax.swing.JMenuItem ShowWatermetersMenuItem;
    private javax.swing.JComboBox<String> StatusComboBox;
    private javax.swing.JLabel StatusLabel;
    private javax.swing.JComboBox<String> TypeConComboBox;
    private javax.swing.JLabel TypeConLabel;
    private javax.swing.JMenu WatermetersMenu;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public GWaterconnection(java.awt.Frame parent) {
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
            java.util.logging.Logger.getLogger(GWaterconnection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GWaterconnection(null).setVisible(true);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        ResultTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        NoteTextArea = new javax.swing.JTextArea();
        OwnerComboBox = new javax.swing.JComboBox<>();
        StatusComboBox = new javax.swing.JComboBox<>();
        TypeConComboBox = new javax.swing.JComboBox<>();
        MenuBar = new javax.swing.JMenuBar();
        EditMenu = new javax.swing.JMenu();
        ChangesMenu = new javax.swing.JMenu();
        ChangeModeMenuItem = new javax.swing.JMenuItem();
        AcceptChangesMenuItem = new javax.swing.JMenuItem();
        DeleteMenuItem = new javax.swing.JMenuItem();
        JournalWatconMenu = new javax.swing.JMenu();
        SearchMenuItem = new javax.swing.JMenuItem();
        ClearMenuItem = new javax.swing.JMenuItem();
        WatermetersMenu = new javax.swing.JMenu();
        ShowWatermetersMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Карточка водопроводного подключения");
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

        ResultTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "№ л/счета", "Код ВП", "Состояние", "Объект подключения"
                }
        ) {
            boolean[] canEdit = new boolean [] {
                    true, true, false, false
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
        jScrollPane1.setViewportView(ResultTable);

        NoteTextArea.setColumns(20);
        NoteTextArea.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        NoteTextArea.setRows(5);
        jScrollPane2.setViewportView(NoteTextArea);

        OwnerComboBox.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        OwnerComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "НЕ ВЫБРАНО", "ГУПС ВОДОКАНАЛ", "АБОНЕНТ" }));
        OwnerComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OwnerComboBoxActionPerformed(evt);
            }
        });

        StatusComboBox.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        StatusComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "НЕ ВЫБРАНО", "РАБОЧЕЕ", "НЕ РАБОЧЕЕ" }));
        StatusComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StatusComboBoxActionPerformed(evt);
            }
        });

        TypeConComboBox.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        TypeConComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"НЕ ВЫБРАНО","ОДИНОЧНОЕ", "КОЛЛЕКТИВНОЕ" }));
        TypeConComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TypeConComboBoxActionPerformed(evt);
            }
        });

        EditMenu.setText("Изменения");

        ChangesMenu.setText("Изменения");

        ChangeModeMenuItem.setText("Включить режим изменения");
        ChangeModeMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChangeModeMenuItemActionPerformed(evt);
            }
        });
        ChangesMenu.add(ChangeModeMenuItem);

        AcceptChangesMenuItem.setText("Принять изменения");
        AcceptChangesMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AcceptChangesMenuItemActionPerformed(evt);
            }
        });
        ChangesMenu.add(AcceptChangesMenuItem);

        EditMenu.add(ChangesMenu);

        DeleteMenuItem.setText("Удалить текущее подключение");
        DeleteMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteMenuItemActionPerformed(evt);
            }
        });
        EditMenu.add(DeleteMenuItem);

        MenuBar.add(EditMenu);

        JournalWatconMenu.setText("Справочник ВП");

        SearchMenuItem.setText("Поиск");
        SearchMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchMenuItemActionPerformed(evt);
            }
        });
        JournalWatconMenu.add(SearchMenuItem);

        ClearMenuItem.setText("Очистить форму");
        ClearMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearMenuItemActionPerformed(evt);
            }
        });
        JournalWatconMenu.add(ClearMenuItem);

        MenuBar.add(JournalWatconMenu);

        WatermetersMenu.setText("Водомеры");

        ShowWatermetersMenuItem.setText("Открыть водомеры текущего ВП");
        ShowWatermetersMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowWatermetersMenuItemActionPerformed(evt);
            }
        });
        WatermetersMenu.add(ShowWatermetersMenuItem);

        MenuBar.add(WatermetersMenu);

        setJMenuBar(MenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addGap(24, 24, 24)
                                                .addComponent(TypeConLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(OwnerTerLabel)
                                                .addGap(31, 31, 31))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addGap(17, 17, 17)
                                                .addComponent(CodeWatconLabel)
                                                .addGap(38, 38, 38)
                                                .addComponent(NumTYLabel)
                                                .addGap(55, 55, 55)
                                                .addComponent(DateTYLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(StatusLabel)
                                                .addGap(24, 24, 24))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(79, 79, 79)
                                                .addComponent(LocationLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(DepthLabel)
                                                .addGap(17, 17, 17))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(LocationTextField)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(DepthTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(CodeWatconTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                .addGap(153, 153, 153)
                                                                .addComponent(NoteLabel)))
                                                .addGap(48, 48, 48))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(77, 77, 77)
                                                                .addComponent(NumTYTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(10, 10, 10)
                                                                .addComponent(OwnerLabel)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(DateTYDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(StatusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addComponent(ObjectConLabel)
                                                                .addGap(51, 51, 51))))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(TypeConComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(OwnerComboBox, 0, 146, Short.MAX_VALUE))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(ObjectConTextField))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(10, 10, 10)
                                                                .addComponent(OwnerTerTextField)))))
                                .addContainerGap(16, Short.MAX_VALUE))
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
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>

    private void ResultTableMouseClicked(java.awt.event.MouseEvent evt) {

    }

    private void ChangeModeMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void AcceptChangesMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void DeleteMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void SearchMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void ClearMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void ShowWatermetersMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

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

    private void StatusComboBoxActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void OwnerComboBoxActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void TypeConComboBoxActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    /* Устаналивает режим работы формы Водомерное подключение.
    * Если b-true, то форма работает в качестве карточки водомерного подключения
    * Если b-false,то в качестве журнала водомерных подключений.
    */
    public void setWatconMode(boolean b) {
        if(b){
            setTitle("Карточка водомерного подключения");
            EditMenu.setEnabled(true);//включение вкладки "редактирование"
            WatermetersMenu.setEnabled(true);
            JournalWatconMenu.setEnabled(false);//отключени вкладки "журнал водомеров"

            CodeWatconTextField.setEditable(false);
            NumTYTextField.setEditable(false);
            DateTYDatePicker.setEditable(false);
            StatusComboBox.setEnabled(false);
            OwnerComboBox.setEnabled(false);
            ObjectConTextField.setEditable(false);
            TypeConComboBox.setEnabled(false);
            OwnerTerTextField.setEditable(false);
            LocationTextField.setEditable(false);
            DepthTextField.setEditable(false);
            NoteTextArea.setEditable(false);

            setVisible(true);
        }
        else{
            setTitle("Справочник водомерных подключений");
            EditMenu.setEnabled(false);//отключение вкладки "редактирование"
            WatermetersMenu.setEnabled(false);
            JournalWatconMenu.setEnabled(true);//включение вкладки "журнал водомеров"

            CodeWatconTextField.setEditable(true);
            NumTYTextField.setEditable(true);
            DateTYDatePicker.setEditable(true);
            StatusComboBox.setEnabled(true);
            OwnerComboBox.setEnabled(true);
            ObjectConTextField.setEditable(true);
            TypeConComboBox.setEnabled(true);
            OwnerTerTextField.setEditable(true);
            LocationTextField.setEditable(true);
            DepthTextField.setEditable(true);
            NoteTextArea.setEditable(true);

            setVisible(true);
        }

    }
}

