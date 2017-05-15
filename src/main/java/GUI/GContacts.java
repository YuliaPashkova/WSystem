package GUI;

import WORK.Access;
import WORK.Contact;
import WORK.Methods;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import static WORK.Contact.company;

/*
 * Created by Юлия on 15.04.2017.
 */
public class GContacts extends javax.swing.JDialog {

    private static DefaultTableModel model = new DefaultTableModel();//модель таблицы с результатом поиска
    private static javax.swing.JTable ResultTable;
    javax.swing.JTextField NameCompanyTextField;
    private boolean change_mode=false;//флаг изменений(true - если была нажата вкладка "изменить контактное лицо",иначе false)
    private boolean add_mode=false;//флаг добавления(true - если была нажата вкладка "добавить контактное лицо",иначе false)
    private String old_data[];//массив старых данных
    private JTextField textfields [];//массив текстовых полей
    private javax.swing.JMenuItem AcceptChangesMenuItem;
    private javax.swing.JMenu AddMenu;
    private javax.swing.JMenuItem AddModeContactMenuItem;
    private javax.swing.JMenuItem AddNewContactMenuItem;
    private javax.swing.JMenuItem ChangeModeMenuItem;
    private javax.swing.JMenu ChangesMenu;
    private javax.swing.JMenuItem DeleteMenuItem;
    private javax.swing.JTextField EmailTextField;
    private javax.swing.JTextField MiddleNameTextField;
    private javax.swing.JTextField NameTextField;
    private javax.swing.JTextField SurnameTextField;
    private javax.swing.JTextField TelephoneTextField;
    private javax.swing.JTextField WorkTextField;

    GContacts(java.awt.Frame parent) {
        super(parent, true);
        initComponents();
        textfields =new JTextField[]{SurnameTextField,NameTextField,MiddleNameTextField,
                WorkTextField,TelephoneTextField,EmailTextField,NameCompanyTextField};
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
            java.awt.EventQueue.invokeLater(() -> new GContacts(null).setVisible(true));
        }

        //добавление в таблицу новой строки
        public  static void AddRowTable() {
            model.addRow(new Object[]{
                    Contact.id, Contact.FIO, Contact.telephone});
        }

        private void initComponents() {
            JLabel surnameLabel = new JLabel();
            SurnameTextField = new javax.swing.JTextField();
            NameTextField = new javax.swing.JTextField();
            MiddleNameTextField = new javax.swing.JTextField();
            JLabel nameCompanyLabel = new JLabel();
            NameCompanyTextField = new javax.swing.JTextField();
            JLabel workLabel = new JLabel();
            WorkTextField = new javax.swing.JTextField();
            EmailTextField = new javax.swing.JTextField();
            JLabel emailLabel = new JLabel();
            JLabel telephoneLabel = new JLabel();
            TelephoneTextField = new javax.swing.JTextField();
            JScrollPane jScrollPane2 = new JScrollPane();
            ResultTable = new javax.swing.JTable();
            JMenuBar jMenuBar1 = new JMenuBar();
            JMenu editMenu = new JMenu();
            ChangesMenu = new javax.swing.JMenu();
            ChangeModeMenuItem = new javax.swing.JMenuItem();
            AcceptChangesMenuItem = new javax.swing.JMenuItem();
            AddMenu = new javax.swing.JMenu();
            AddModeContactMenuItem = new javax.swing.JMenuItem();
            AddNewContactMenuItem = new javax.swing.JMenuItem();
            DeleteMenuItem = new javax.swing.JMenuItem();

            setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            setTitle("Контактные лица ("+ Access.name_operator+")");
            ImageIcon icon = new ImageIcon("src\\main\\resources\\main_icon\\main_icon.png");
            setIconImage(icon.getImage());
            setResizable(false);

            surnameLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
            surnameLabel.setText("Фамилия, имя, отчество");

            SurnameTextField.setEditable(false);
            SurnameTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

            NameTextField.setEditable(false);
            NameTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

            MiddleNameTextField.setEditable(false);
            MiddleNameTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

            nameCompanyLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
            nameCompanyLabel.setText("Наименование предприятия (организации)");

            NameCompanyTextField.setEditable(false);
            NameCompanyTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

            workLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
            workLabel.setText("Должность");

            WorkTextField.setEditable(false);
            WorkTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

            EmailTextField.setEditable(false);
            EmailTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

            emailLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
            emailLabel.setText("E-mail (электронная почта)");

            telephoneLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
            telephoneLabel.setText("Контактный телефон");

            TelephoneTextField.setEditable(false);
            TelephoneTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

            ResultTable.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
            ResultTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            ResultTable.setModel(new javax.swing.table.DefaultTableModel(
                    new Object [][] {

                    },
                    new String [] {
                            "Номер","ФИО", "Телефон"
                    }
            ) {
                boolean[] canEdit = new boolean [] {
                        false, false, false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
                }
            });
            ResultTable.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    try {
                        ResultTableMouseClicked(evt);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            ResultTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            model = (DefaultTableModel) ResultTable.getModel();//подключение таблицы к модели
            jScrollPane2.setViewportView(ResultTable);

            editMenu.setText("Редактирование");

            ChangesMenu.setText("Изменение");

            ChangeModeMenuItem.setText("Включить режим изменения");
            ChangeModeMenuItem.addActionListener(evt -> {
                try {
                    ChangeModeMenuItemActionPerformed();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });
            ChangesMenu.add(ChangeModeMenuItem);
            ChangesMenu.setEnabled(false);
            DeleteMenuItem.setEnabled(false);

            AcceptChangesMenuItem.setText("Принять изменения");
            AcceptChangesMenuItem.setEnabled(false);
            AcceptChangesMenuItem.addActionListener(evt -> {
                try {
                    AcceptChangesMenuItemActionPerformed();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });
            ChangesMenu.add(AcceptChangesMenuItem);

            editMenu.add(ChangesMenu);

            AddMenu.setText("Добавление");

            AddModeContactMenuItem.setText("Включить режим добавления");
            AddModeContactMenuItem.addActionListener(evt -> {
                try {
                    AddModeContactMenuItemActionPerformed();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });
            AddMenu.add(AddModeContactMenuItem);

            AddNewContactMenuItem.setText("Добавить новое контактное лицо");
            AddNewContactMenuItem.addActionListener(evt -> {
                try {
                    AddNewContactMenuItemActionPerformed();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });
            AddMenu.add(AddNewContactMenuItem);

            editMenu.add(AddMenu);

            DeleteMenuItem.setText("Удаление выбранного контактного лица");
            DeleteMenuItem.addActionListener(evt -> DeleteMenuItemActionPerformed());
            editMenu.add(DeleteMenuItem);

            jMenuBar1.add(editMenu);

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
                                                                    .addComponent(nameCompanyLabel))
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
                                                    .addComponent(emailLabel)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(telephoneLabel)
                                                    .addGap(36, 36, 36))
                                            .addGroup(layout.createSequentialGroup()
                                                    .addGap(43, 43, 43)
                                                    .addComponent(surnameLabel)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(workLabel)
                                                    .addGap(66, 66, 66))))
            );
            layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(surnameLabel)
                                            .addComponent(workLabel))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(SurnameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(WorkTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(NameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(MiddleNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(nameCompanyLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(NameCompanyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(emailLabel)
                                            .addComponent(telephoneLabel))
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

    private void AddNewContactMenuItemActionPerformed() throws SQLException {
        Object[] options = { "Да", "Нет" };
        if (JOptionPane.showOptionDialog(null, "Добавить новое контактное лицо?", "Подтверждение", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, options, options[0]) == 0)//если да
            switch(Contact.addContact(readData())){
                case 0:// успешное изменение
                    JOptionPane.showMessageDialog(null,"Новое контактное лицо было добавлено! Выход из режима добавления...", "Результат добавление", JOptionPane.INFORMATION_MESSAGE);
                    addMode(false);//выход из режима добавления
                    break;
                case -1:
                    JOptionPane.showMessageDialog(null,Contact.error, "Ошибка", JOptionPane.ERROR_MESSAGE);
                    break;
            }
        else if (JOptionPane.showOptionDialog(null, "Выйти из режима добавления?",
                "Подтверждение", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, null, options, options[1]) == 0) {//Если да
            addMode(false);//выход из режима добавления
        }

    }

    private void AddModeContactMenuItemActionPerformed() throws SQLException {
        addMode(true);
    }


    private void ChangeModeMenuItemActionPerformed() throws SQLException {
            changeMode(true);
            old_data=readData();//считать все текущие данные
    }
    /*
    Метод считывает данные из всех полей и возвращает их в виде массива
    */
    private String[] readData() {
        String datafields[]=new String[6];
        for(int i=0;i<textfields.length-1;i++)//считывание данных из текстовых полей (компанию не нужно считывать,т.к. она не изменется)
            datafields[i]=textfields[i].getText();
        for(int i=0;i<datafields.length;i++)
            if(datafields[i]!=null) datafields[i]=datafields[i].toUpperCase();
        return datafields;
    }
    /*
    * Изменение данных
    */
    private void AcceptChangesMenuItemActionPerformed() throws SQLException {
        String[] new_data = readData();
        if(Methods.haveNewValues(Methods.compareData(old_data, new_data))==0) {//данные не изменялись
            JOptionPane.showMessageDialog(null, "Данные не были изменены. Выход из режима редактирования...", "Выход", JOptionPane.INFORMATION_MESSAGE);
            changeMode(false);//выход из режима редактирования
        }
        else {
            Object[] options = { "Да", "Нет" };
            if (JOptionPane.showOptionDialog(null, "Принять изменения?", "Подтверждение", JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, options, options[0]) == 0)//если да,то изменить бд
                switch(Contact.changeContact(new_data,String.valueOf(ResultTable.getModel().getValueAt(ResultTable.getSelectedRow(), 0)))){
                    case 0:// успешное изменение
                        JOptionPane.showMessageDialog(null,"Изменение данных прошло успешно! Выход из режима редактирования...", "Результат изменения", JOptionPane.INFORMATION_MESSAGE);
                        old_data=null;
                        changeMode(false);//выход из режима редактирования
                        break;
                    case -1:
                        JOptionPane.showMessageDialog(null,Contact.error, "Ошибка", JOptionPane.ERROR_MESSAGE);
                        break;
                }
            else if (JOptionPane.showOptionDialog(null, "Выйти из режима редактирования?",
                    "Подтверждение", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, null, options, options[1]) == 0) {//Если да, то выйти из режима редактирования
                changeMode(false);//выход из режима редактирования
            }
        }
    }

        /*
         * Производит необходимые действия при входе/выходе из режима добавления
         * Принимает mode (true-вход/false-выход)
         */
        private void addMode(boolean mode) throws SQLException {
        if(mode){
            add_mode=true;
            AddNewContactMenuItem.setEnabled(true);
            AddModeContactMenuItem.setEnabled(false);
            ResultTable.setEnabled(false);
            ChangesMenu.setEnabled(false);
            DeleteMenuItem.setEnabled(false);
            setConditionFields(true);
            cleanFieldsForAddMode();
            JOptionPane.showMessageDialog(null,"Введите данные,затем нажмите \"Добавить новое контактное лицо\"", "Режим добавления", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            add_mode=false;
            ResultTable.setEnabled(true);
            ChangesMenu.setEnabled(false);
            DeleteMenuItem.setEnabled(false);
            AddModeContactMenuItem.setEnabled(true);
            AcceptChangesMenuItem.setEnabled(false);
            cleanFields();
            setConditionFields(false);
            //обновление таблицы
            deleteRows();
            Contact.searchContact(GAccount.NUM_ACC);
            ResultTable.requestFocus();
        }
    }

         /*
         * Производит необходимые действия при входе/выходе из режима редактирования
         * Принимает mode (true-вход/false-выход)
         */
        private void changeMode(boolean mode) throws SQLException {
        if(mode){//включить режим изменения
            JOptionPane.showMessageDialog(null,"Измените данные, затем нажмите \"Принять изменения\"", "Режим изменения", JOptionPane.INFORMATION_MESSAGE);
            change_mode = true;
            ResultTable.setEnabled(false);
            AcceptChangesMenuItem.setEnabled(true);
            DeleteMenuItem.setEnabled(false);
            AddMenu.setEnabled(false);
            setConditionFields(true);
            ChangeModeMenuItem.setEnabled(false);
        }
        else{//выход
            change_mode=false;
            ResultTable.setEnabled(true);
            ChangesMenu.setEnabled(false);
            DeleteMenuItem.setEnabled(false);
            AddMenu.setEnabled(true);
            setConditionFields(false);
            ChangeModeMenuItem.setEnabled(true);
            AcceptChangesMenuItem.setEnabled(false);
            cleanFields();
            deleteRows();
            Contact.searchContact(GAccount.NUM_ACC);
            ResultTable.requestFocus();
        }
    }
        private void DeleteMenuItemActionPerformed() {

            Object[] options = {"Да", "Нет"};
            int n = JOptionPane.showOptionDialog(null, "Удалить выбранное контактное лицо?",
                    "Подтверждение удаления", JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if (n == 0) {
                Contact.deleteContact(String.valueOf(ResultTable.getModel().getValueAt(ResultTable.getSelectedRow(), 0)));
                JOptionPane.showMessageDialog(null, "Контактное лицо было удалено!", "Результат удаления", JOptionPane.INFORMATION_MESSAGE);
                model.removeRow(ResultTable.getSelectedRow());//удаление строки из таблицы
                cleanFields();
                ChangesMenu.setEnabled(false);
                DeleteMenuItem.setEnabled(false);

            }
        }
        /*
        * Очистка  полей
        */
        private void cleanFieldsForAddMode() {for (int i=0;i<textfields.length-1;i++) textfields[i].setText(null);
        }
        private void cleanFields() {
            for(int i=0;i<textfields.length-1;i++)textfields[i].setText(null);
        }
        //удаляет все строки из таблицы
        void deleteRows() {
            model.setRowCount(0);
        }
        //по клику на строке таблицы
        private void ResultTableMouseClicked(java.awt.event.MouseEvent evt) throws Exception {
            if(evt.getClickCount()==1&&!change_mode&&!add_mode)clickOnTable();
        }
        /*
        Метод отправляет ИД контакта,происходит поиск расширенных данных.
        Затем данные выводятся в форму
        */
        private void clickOnTable() throws SQLException {
            AddNewContactMenuItem.setEnabled(false);
            ChangesMenu.setEnabled(true);
            DeleteMenuItem.setEnabled(true);
            Contact.showContact(String.valueOf(ResultTable.getModel().getValueAt(ResultTable.getSelectedRow(), 0)));
            String FIO[] = Contact.FIO.split(" ");
            SurnameTextField.setText(FIO[0]);
            NameTextField.setText(FIO[1]);
            MiddleNameTextField.setText(FIO[2]);
            WorkTextField.setText(Contact.post);
            NameCompanyTextField.setText(company);
            EmailTextField.setText(Contact.email);
            TelephoneTextField.setText(Contact.telephone);
            ResultTable.requestFocus();

        }
        /*
        * Принимает sost: true или false
        * Делает активными/неактивными поля соответственно
        */
        private void setConditionFields(boolean sost) {
        for (int i=0;i<textfields.length-1;i++)//компанию изменить нельзя
            textfields[i].setEditable(sost);

    }
}
