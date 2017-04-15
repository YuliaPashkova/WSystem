package GUI;

import javax.swing.*;

/**
 * Created by Юлия on 15.04.2017.
 */
public class GContacts extends javax.swing.JDialog {
        // Variables declaration - do not modify
        private javax.swing.JMenuItem AcceptChangesMenuItem;
        private javax.swing.JMenu AddMenu;
        private javax.swing.JMenuItem AddModeContactMenuItem;
        private javax.swing.JMenuItem AddNewContactMenuItem;
        private javax.swing.JMenuItem ChangeModeMenuItem;
        private javax.swing.JMenu ChangesMenu;
        private javax.swing.JMenuItem DeleteMenuItem;
        private javax.swing.JMenu EditMenu;
        private javax.swing.JLabel EmailLabel;
        private javax.swing.JTextField EmailTextField;
        private javax.swing.JTextField MiddleNameTextField;
        private javax.swing.JLabel NameCompanyLabel;
        private javax.swing.JTextField NameCompanyTextField;
        private javax.swing.JTextField NameTextField;
        private javax.swing.JMenu PrintMenu;
        private javax.swing.JTable ResultTable;
        private javax.swing.JLabel SurnameLabel;
        private javax.swing.JTextField SurnameTextField;
        private javax.swing.JLabel TelephoneLabel;
        private javax.swing.JTextField TelephoneTextField;
        private javax.swing.JLabel WorkLabel;
        private javax.swing.JTextField WorkTextField;
        private javax.swing.JMenuBar jMenuBar1;
        private javax.swing.JScrollPane jScrollPane2;
    public GContacts(java.awt.Frame parent) {
        //вызываем конструктор базового класса, т.о. сообщаем, что переданное в качестве аргумента
        // окно parent является родительским для данного; true - диалог модальный (блокирует выполнение
        // родительского окна до завершение работы дочернего)
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
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                java.util.logging.Logger.getLogger(GContacts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new GContacts(null).setVisible(true);
                }
            });
        }

        private void initComponents() {
            SurnameLabel = new javax.swing.JLabel();
            SurnameTextField = new javax.swing.JTextField();
            NameTextField = new javax.swing.JTextField();
            MiddleNameTextField = new javax.swing.JTextField();
            NameCompanyLabel = new javax.swing.JLabel();
            NameCompanyTextField = new javax.swing.JTextField();
            WorkLabel = new javax.swing.JLabel();
            WorkTextField = new javax.swing.JTextField();
            EmailTextField = new javax.swing.JTextField();
            EmailLabel = new javax.swing.JLabel();
            TelephoneLabel = new javax.swing.JLabel();
            TelephoneTextField = new javax.swing.JTextField();
            jScrollPane2 = new javax.swing.JScrollPane();
            ResultTable = new javax.swing.JTable();
            jMenuBar1 = new javax.swing.JMenuBar();
            EditMenu = new javax.swing.JMenu();
            ChangesMenu = new javax.swing.JMenu();
            ChangeModeMenuItem = new javax.swing.JMenuItem();
            AcceptChangesMenuItem = new javax.swing.JMenuItem();
            AddMenu = new javax.swing.JMenu();
            AddModeContactMenuItem = new javax.swing.JMenuItem();
            AddNewContactMenuItem = new javax.swing.JMenuItem();
            DeleteMenuItem = new javax.swing.JMenuItem();
            PrintMenu = new javax.swing.JMenu();

            setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            setTitle("Контактные лица");
            ImageIcon icon = new ImageIcon("src\\main\\resources\\main_icon\\main_icon.png");
            setIconImage(icon.getImage());
            setResizable(false);

            SurnameLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
            SurnameLabel.setText("Фамилия, имя, отчество");

            SurnameTextField.setEditable(false);
            SurnameTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

            NameTextField.setEditable(false);
            NameTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

            MiddleNameTextField.setEditable(false);
            MiddleNameTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

            NameCompanyLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
            NameCompanyLabel.setText("Наименование предприятия (организации)");

            NameCompanyTextField.setEditable(false);
            NameCompanyTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

            WorkLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
            WorkLabel.setText("Должность");

            WorkTextField.setEditable(false);
            WorkTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

            EmailTextField.setEditable(false);
            EmailTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

            EmailLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
            EmailLabel.setText("E-mail (электронная почта)");

            TelephoneLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
            TelephoneLabel.setText("Контактный телефон");

            TelephoneTextField.setEditable(false);
            TelephoneTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

            ResultTable.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
            ResultTable.setModel(new javax.swing.table.DefaultTableModel(
                    new Object [][] {

                    },
                    new String [] {
                            "ФИО", "Телефон "
                    }
            ) {
                boolean[] canEdit = new boolean [] {
                        false, false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
                }
            });
            jScrollPane2.setViewportView(ResultTable);

            EditMenu.setText("Редактирование");

            ChangesMenu.setText("Изменение");

            ChangeModeMenuItem.setText("Включить режим изменения");
            ChangesMenu.add(ChangeModeMenuItem);

            AcceptChangesMenuItem.setText("Принять изменения");
            ChangesMenu.add(AcceptChangesMenuItem);

            EditMenu.add(ChangesMenu);

            AddMenu.setText("Добавление");

            AddModeContactMenuItem.setText("Включить режим добавления");
            AddMenu.add(AddModeContactMenuItem);

            AddNewContactMenuItem.setText("Добавить новое контактное лицо");
            AddMenu.add(AddNewContactMenuItem);

            EditMenu.add(AddMenu);

            DeleteMenuItem.setText("Удаление выбранного контактного лица");
            DeleteMenuItem.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    DeleteMenuItemActionPerformed(evt);
                }
            });
            EditMenu.add(DeleteMenuItem);

            jMenuBar1.add(EditMenu);

            PrintMenu.setText("Печать");
            jMenuBar1.add(PrintMenu);

            setJMenuBar(jMenuBar1);

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
                                                                    .addGap(118, 118, 118)
                                                                    .addComponent(NameCompanyLabel))
                                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                    .addGroup(layout.createSequentialGroup()
                                                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                                    .addComponent(MiddleNameTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                                                                    .addComponent(NameTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                                                                    .addComponent(SurnameTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                            .addComponent(WorkTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                    .addComponent(NameCompanyTextField)
                                                                    .addGroup(layout.createSequentialGroup()
                                                                            .addComponent(EmailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                            .addComponent(TelephoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(layout.createSequentialGroup()
                                                    .addGap(33, 33, 33)
                                                    .addComponent(EmailLabel)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(TelephoneLabel)
                                                    .addGap(36, 36, 36))
                                            .addGroup(layout.createSequentialGroup()
                                                    .addGap(43, 43, 43)
                                                    .addComponent(SurnameLabel)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(WorkLabel)
                                                    .addGap(66, 66, 66))))
            );
            layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(SurnameLabel)
                                            .addComponent(WorkLabel))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(SurnameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(WorkTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(NameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(MiddleNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(NameCompanyLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(NameCompanyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(EmailLabel)
                                            .addComponent(TelephoneLabel))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(EmailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(TelephoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );

            pack();
            setLocationRelativeTo(null);
        }// </editor-fold>

        private void DeleteMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
            // TODO add your handling code here:
        }
        // End of variables declaration                   
    }
