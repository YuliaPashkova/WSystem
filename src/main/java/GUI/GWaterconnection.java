package GUI;
import WORK.*;
import com.mxrck.autocompleter.TextAutoCompleter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
/*
 * Created by Юлия on 19.04.2017.
 */

public class GWaterconnection extends javax.swing.JDialog {
    private static DefaultTableModel model = new DefaultTableModel();//модель таблицы с результатом поиска
    private String CODE;//код ВП
    private JTextField textfields [];//массив текстовых полей
    private JComboBox comboboxes[];//массив комбобоксов
    private String old_data[];//массив старых данных
    private boolean change_mode=false;//флаг изменений(true - если была нажата вкладка "изменить ВП",иначе false)
    private boolean journal_mode=false;//если открыт журнал,то  true
    private javax.swing.JMenuItem AcceptChangesMenuItem;
    private javax.swing.JMenuItem ChangeModeMenuItem;
    private javax.swing.JMenu ChangesMenu;
    private javax.swing.JTextField CodeWatconTextField;
    private org.jdesktop.swingx.JXDatePicker DateTYDatePicker;
    private javax.swing.JMenuItem DeleteWaterconMenuItem;
    private javax.swing.JTextField DepthTextField;
    private javax.swing.JMenu EditMenu;
    private javax.swing.JMenu JournalWatconMenu;
    private javax.swing.JTextField LocationTextField;
    private javax.swing.JTextArea NoteTextArea;
    private javax.swing.JTextField NumTYTextField;
    private javax.swing.JTextField ObjectConTextField;
    private javax.swing.JComboBox<String> OwnerComboBox;
    private javax.swing.JTextField OwnerTerTextField;
    private javax.swing.JTable ResultTable;
    private javax.swing.JMenuItem ShowWatermetersMenuItem;
    private javax.swing.JComboBox<String> StatusComboBox;
    private javax.swing.JComboBox<String> TypeConComboBox;
    private javax.swing.JMenu WatermetersMenu;

    GWaterconnection(boolean mode, java.awt.Frame parent) throws SQLException {
        super(parent, true);
        initComponents();
        setWatconMode(mode);
        textfields=new JTextField[]{CodeWatconTextField,NumTYTextField,ObjectConTextField,OwnerTerTextField,
                LocationTextField,DepthTextField};
        comboboxes =new JComboBox[]{StatusComboBox,OwnerComboBox,TypeConComboBox};
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

        java.awt.EventQueue.invokeLater(() -> {
            try {
                new GWaterconnection(true,null).setVisible(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }

    //добавление в таблицу новой строки
    public static void AddRowTable() throws SQLException {
        model.addRow(new Object[]{
                Waterconnection.num_account,Waterconnection.code,Waterconnection.status,Waterconnection.getObjectFromIndex(Waterconnection.object_con)
                });
    }

    @SuppressWarnings("unchecked")
    private void initComponents() throws SQLException {
        JLabel codeWatconLabel = new JLabel();
        CodeWatconTextField = new javax.swing.JTextField();
        JLabel numTYLabel = new JLabel();
        NumTYTextField = new javax.swing.JTextField();
        JLabel dateTYLabel = new JLabel();
        DateTYDatePicker = new org.jdesktop.swingx.JXDatePicker();
        DateTYDatePicker.setFormats("yyyy-MM-dd");
        DateTYDatePicker.setDate(null);
        DateTYDatePicker.setLinkDate(System.currentTimeMillis(), "Сегодня {0}");
        JLabel statusLabel = new JLabel();
        JLabel ownerLabel = new JLabel();
        JLabel objectConLabel = new JLabel();
        JLabel typeConLabel = new JLabel();
        ObjectConTextField = new javax.swing.JTextField();
        JLabel ownerTerLabel = new JLabel();
        OwnerTerTextField = new javax.swing.JTextField();
        JLabel locationLabel = new JLabel();
        JLabel depthLabel = new JLabel();
        LocationTextField = new javax.swing.JTextField();
        DepthTextField = new javax.swing.JTextField();
        JLabel noteLabel = new JLabel();
        JScrollPane jScrollPane1 = new JScrollPane();
        ResultTable = new javax.swing.JTable();
        JScrollPane jScrollPane2 = new JScrollPane();
        NoteTextArea = new javax.swing.JTextArea();
        OwnerComboBox = new javax.swing.JComboBox<>();
        StatusComboBox = new javax.swing.JComboBox<>();
        TypeConComboBox = new javax.swing.JComboBox<>();
        JMenuBar menuBar = new JMenuBar();
        EditMenu = new javax.swing.JMenu();
        ChangesMenu = new javax.swing.JMenu();
        ChangeModeMenuItem = new javax.swing.JMenuItem();
        AcceptChangesMenuItem = new javax.swing.JMenuItem();
        DeleteWaterconMenuItem = new javax.swing.JMenuItem();
        JournalWatconMenu = new javax.swing.JMenu();
        JMenuItem searchMenuItem = new JMenuItem();
        JMenuItem clearMenuItem = new JMenuItem();
        WatermetersMenu = new javax.swing.JMenu();
        ShowWatermetersMenuItem = new javax.swing.JMenuItem();

        //AUTOCOMPLETERS
        TextAutoCompleter objectcomplete = new TextAutoCompleter(ObjectConTextField);
        Connect.retrieveObject();
        while (Connect.rs.next()) {
            objectcomplete.addItem(Connect.rs.getString("object_con"));
        }

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Карточка водопроводного подключения ("+ Access.name_operator+")");
        ImageIcon icon = new ImageIcon("src\\main\\resources\\main_icon\\main_icon.png");
        setIconImage(icon.getImage());
        setResizable(false);

        codeWatconLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        codeWatconLabel.setText("Код ВП");

        CodeWatconTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        numTYLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        numTYLabel.setText("№ ТУ");
        NumTYTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        dateTYLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        dateTYLabel.setText("Дата ТУ");


        statusLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        statusLabel.setText("Состояние");

        ownerLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ownerLabel.setText("Принадлежность ВП");

        objectConLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        objectConLabel.setText("Объект подключения");

        typeConLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        typeConLabel.setText("Вид подключения");

        ObjectConTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        ownerTerLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ownerTerLabel.setText("Принадлежность территории");

        OwnerTerTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        locationLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        locationLabel.setText("Местонахождение ВП");

        depthLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        depthLabel.setText("Глубина (м)");

        LocationTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        DepthTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        noteLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        noteLabel.setText("Примечание");

        ResultTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "№ л/счета","Код ВП", "Состояние", "Объект подключения"
                }
        ) {
            boolean[] canEdit = new boolean [] {
                   false,false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ResultTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
                    ResultTableMouseClicked(evt);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
        ResultTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        model = (DefaultTableModel) ResultTable.getModel();//подключение таблицы к модели
        jScrollPane1.setViewportView(ResultTable);

        NoteTextArea.setColumns(20);
        NoteTextArea.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        NoteTextArea.setRows(5);
        jScrollPane2.setViewportView(NoteTextArea);

        OwnerComboBox.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        OwnerComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "НЕ ВЫБРАНО", "ГУПС ВОДОКАНАЛ", "АБОНЕНТ" }));

        StatusComboBox.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        StatusComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "НЕ ВЫБРАНО", "РАБОЧЕЕ", "НЕ РАБОЧЕЕ" }));

        TypeConComboBox.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        TypeConComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"НЕ ВЫБРАНО","ОДИНОЧНОЕ", "КОЛЛЕКТИВНОЕ" }));

        EditMenu.setText("Редактирование");
        EditMenu.setEnabled(false);
        ChangesMenu.setText("Изменения");


        ChangeModeMenuItem.setText("Включить режим изменения");
        ChangeModeMenuItem.addActionListener(evt -> {
            try {
                ChangeModeMenuItemActionPerformed();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        ChangesMenu.add(ChangeModeMenuItem);

        AcceptChangesMenuItem.setText("Принять изменения");
        AcceptChangesMenuItem.addActionListener(evt -> {
            try {
                AcceptChangesMenuItemActionPerformed();
            } catch (SQLException | ParseException e) {
                e.printStackTrace();
            }
        });
        ChangesMenu.add(AcceptChangesMenuItem);
        ChangesMenu.setEnabled(false);

        EditMenu.add(ChangesMenu);

        DeleteWaterconMenuItem.setText("Удалить текущее подключение");
        DeleteWaterconMenuItem.setEnabled(false);
        DeleteWaterconMenuItem.addActionListener(evt -> DeleteWaterconMenuItemActionPerformed());
        EditMenu.add(DeleteWaterconMenuItem);

        menuBar.add(EditMenu);

        JournalWatconMenu.setText("Справочник ВП");

        searchMenuItem.setText("Поиск");
        searchMenuItem.addActionListener(evt -> {
            try {
                SearchMenuItemActionPerformed();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        JournalWatconMenu.add(searchMenuItem);

        clearMenuItem.setText("Очистить форму");
        clearMenuItem.addActionListener(evt -> ClearMenuItemActionPerformed());
        JournalWatconMenu.add(clearMenuItem);

        menuBar.add(JournalWatconMenu);

        WatermetersMenu.setText("Водомеры");
        WatermetersMenu.setEnabled(false);

        ShowWatermetersMenuItem.setText("Открыть водомеры текущего ВП");
        ShowWatermetersMenuItem.addActionListener(evt -> {
            try {
                ShowWatermetersMenuItemActionPerformed();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        WatermetersMenu.add(ShowWatermetersMenuItem);
        menuBar.add(WatermetersMenu);

        setJMenuBar(menuBar);

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
                                                .addComponent(typeConLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(ownerTerLabel)
                                                .addGap(31, 31, 31))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addGap(17, 17, 17)
                                                .addComponent(codeWatconLabel)
                                                .addGap(38, 38, 38)
                                                .addComponent(numTYLabel)
                                                .addGap(55, 55, 55)
                                                .addComponent(dateTYLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(statusLabel)
                                                .addGap(24, 24, 24))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(79, 79, 79)
                                                .addComponent(locationLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(depthLabel)
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
                                                                .addComponent(noteLabel)))
                                                .addGap(48, 48, 48))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(77, 77, 77)
                                                                .addComponent(NumTYTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(10, 10, 10)
                                                                .addComponent(ownerLabel)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(DateTYDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(StatusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addComponent(objectConLabel)
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
                                                .addComponent(numTYLabel)
                                                .addComponent(codeWatconLabel))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(dateTYLabel)
                                                .addComponent(statusLabel)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(CodeWatconTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(NumTYTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(DateTYDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(StatusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(7, 7, 7)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(objectConLabel)
                                        .addComponent(ownerLabel))
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(ObjectConTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(OwnerComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(ownerTerLabel)
                                        .addComponent(typeConLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(OwnerTerTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(TypeConComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(depthLabel)
                                        .addComponent(locationLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(DepthTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(LocationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(noteLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>

    private void ResultTableMouseClicked(java.awt.event.MouseEvent evt) throws SQLException {
        if(evt.getClickCount()==1&&!change_mode)clickOnTable();
    }

    private void clickOnTable() throws SQLException {
        CODE=String.valueOf(ResultTable.getModel().getValueAt(ResultTable.getSelectedRow(), 1));
        ChangeModeMenuItem.setEnabled(true);
        ShowWatermetersMenuItem.setEnabled(true);
        ChangesMenu.setEnabled(true);
        EditMenu.setEnabled(true);
        AcceptChangesMenuItem.setEnabled(false);
        DeleteWaterconMenuItem.setEnabled(true);
        WatermetersMenu.setEnabled(true);
        Waterconnection.showWaterconnection(CODE);
        CodeWatconTextField.setText(String.valueOf(Waterconnection.code));
        NumTYTextField.setText(Waterconnection.num_TY);
        DateTYDatePicker.setDate(Waterconnection.date_TY);
        StatusComboBox.setSelectedItem(Waterconnection.status);
        OwnerComboBox.setSelectedItem(Waterconnection.owner);
        ObjectConTextField.setText(Waterconnection.obj_str);
        TypeConComboBox.setSelectedItem(Waterconnection.type_con);
        OwnerTerTextField.setText(Waterconnection.owner_ter);
        LocationTextField.setText(Waterconnection.location);
        DepthTextField.setText(String.valueOf(Waterconnection.depth));
        NoteTextArea.setText(Waterconnection.note);
        ResultTable.requestFocus();

        if(journal_mode)setConditionMenuForJournal();
    }

    private void ChangeModeMenuItemActionPerformed() throws SQLException {
        changeMode(true);
        old_data=readData();//считать все текущие данные
    }
    /*
     Метод считывает данные из всех полей и возвращает их в виде массива
     */
    private String[] readData() {
        String datafields [] = new String [11];
        for(int i=0;i<textfields.length;i++)//считывание данных
            datafields[i]=textfields[i].getText();
        for(int i=textfields.length,j=0;i<comboboxes.length +textfields.length;i++,j++)
            datafields[i]=(String)comboboxes[j].getSelectedItem();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try{
            datafields[9] = dateFormat.format(DateTYDatePicker.getDate());//
        }catch (NullPointerException ex){
            datafields[9]= null;
        }
        datafields[10]=NoteTextArea.getText();
        for(int i=0;i<datafields.length;i++)
            if(datafields[i]!=null) datafields[i]=datafields[i].toUpperCase();
        return datafields;
    }
    /*
     * Изменение данных
     */
    private void AcceptChangesMenuItemActionPerformed() throws SQLException, ParseException {
        String[] new_data = readData();
        String local_error="";//если один из комбобоксов не выбран
        boolean loc_error=false;//ошибка в комбобоксах
        if(new_data[7].equals("НЕ ВЫБРАНО")){
            loc_error=true;
            local_error="Выберите принадлежность ВП!";
        }
        if(new_data[8].equals("НЕ ВЫБРАНО")){
            loc_error=true;
            local_error="Выберите вид подключения!";
        }
        if(new_data[6].equals("НЕ ВЫБРАНО")){
            loc_error=true;
            local_error="Выберите состояние!";
        }
        if(loc_error) JOptionPane.showMessageDialog(null,local_error, "Ошибка", JOptionPane.ERROR_MESSAGE);
        else {
            if (Methods.haveNewValues(Methods.compareData(old_data, new_data)) == 0) {//данные не изменялись
                JOptionPane.showMessageDialog(null, "Данные не были изменены. Выход из режима редактирования...", "Выход", JOptionPane.INFORMATION_MESSAGE);
                changeMode(false);//выход из режима редактирования
            } else {
                Object[] options = {"Да", "Нет"};
                if (JOptionPane.showOptionDialog(null, "Принять изменения?", "Подтверждение", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, options, options[0]) == 0)//если да,то изменить бд
                    switch (Waterconnection.changeWaterconnection(new_data)) {
                        case 0:// успешное изменение
                            JOptionPane.showMessageDialog(null, "Изменение данных прошло успешно! Выход из режима редактирования...", "Результат изменения", JOptionPane.INFORMATION_MESSAGE);
                            old_data = null;
                            changeMode(false);//выход из режима редактирования
                            break;
                        case -1:
                            JOptionPane.showMessageDialog(null, Waterconnection.error, "Ошибка", JOptionPane.ERROR_MESSAGE);
                            break;
                    }
                else if (JOptionPane.showOptionDialog(null, "Выйти из режима редактирования?",
                        "Подтверждение", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]) == 0) {//Если да, то выйти из режима редактирования
                    changeMode(false);//выход из режима редактирования
                }
            }
        }
    }

    /*
    * Производит необходимые действия при входе/выходе из режима редактирования
    * Принимает mode (true-вход/false-выход)
    */
    private void changeMode(boolean mode) throws SQLException {
        if(mode){
            change_mode=true;
            JOptionPane.showMessageDialog(null,"Измените данные, затем нажмите \"Принять изменения\"", "Режим изменения", JOptionPane.INFORMATION_MESSAGE);
            ResultTable.setEnabled(false);
            DeleteWaterconMenuItem.setEnabled(false);
            ChangeModeMenuItem.setEnabled(false);
            AcceptChangesMenuItem.setEnabled(true);
            WatermetersMenu.setEnabled(false);
            setConditionFields(true);

        }else{
            change_mode=false;
            ResultTable.setEnabled(true);
            EditMenu.setEnabled(false);
            AcceptChangesMenuItem.setEnabled(false);
            setConditionFields(false);
            cleanFields();
            deleteRows();
            Waterconnection.searchWaterconnection(GAccount.NUM_ACC);
            ResultTable.requestFocus();
        }
    }

    private void DeleteWaterconMenuItemActionPerformed() {
        Object[] options = {"Да", "Нет"};
        int n = JOptionPane.showOptionDialog(null, "Удалить выбранное водомерное подключение? Так же будут удалены\n все водомеры,привязанные к водомерному подключению.",
                "Подтверждение удаления", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        if (n == 0) {
            Waterconnection.deleteWaterconnection(String.valueOf(ResultTable.getModel().getValueAt(ResultTable.getSelectedRow(), 1)));
            model.removeRow(ResultTable.getSelectedRow());//удаление строки из таблицы
            cleanFields();
            ChangesMenu.setEnabled(false);
            DeleteWaterconMenuItem.setEnabled(false);
            JOptionPane.showMessageDialog(null, "Водомерное подключение было удалено!", "Результат удаления", JOptionPane.INFORMATION_MESSAGE);

        }
    }

    private void SearchMenuItemActionPerformed() throws SQLException {
        search();
    }

    private void search() throws SQLException {
        String data[] = new String[11];
        data[0]= CodeWatconTextField.getText().trim();
        data[1]= NumTYTextField.getText().trim();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date_TY = DateTYDatePicker.getDate();
            data[2] = format.format(date_TY);
        } catch (Exception ex) {
            data[2] = "";
        }
        data[3] = (String)StatusComboBox.getSelectedItem();
        if (Objects.equals(data[3], "НЕ ВЫБРАНО")) data[3] = "";
        data[4] = (String)OwnerComboBox.getSelectedItem();
        if (Objects.equals(data[4], "НЕ ВЫБРАНО")) data[4] = "";

        int id_object = Waterconnection.getIndexOfObject(data[5]);
        if(id_object==-1)data[5]="";
        else data[5]= String.valueOf(id_object);

        data[6] = (String)TypeConComboBox.getSelectedItem();
        if (Objects.equals(data[6], "НЕ ВЫБРАНО")) data[6] = "";
        data[7]=OwnerTerTextField.getText().trim();
        data[8]=LocationTextField.getText().trim();
        data[9]=DepthTextField.getText().trim();
        data[10]=NoteTextArea.getText().trim();

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
            int result = Waterconnection.searchWaterconnectionFromJournal(data);
            if (result == 0) {//если что-то найдено
                Waterconnection.waterconnection = null;//обнуление
                ResultTable.requestFocus();
            } else {
                deleteRows();//удаление строк из таблицы
                JOptionPane.showMessageDialog(null, "Не найдено!", "Результат поиска", JOptionPane.INFORMATION_MESSAGE);
            }
        }

    }

    private void ClearMenuItemActionPerformed() {
        cleanFields();
        deleteRows();
        setConditionMenuForJournal();
    }

    /*
    Устанавливает состояние меню для журнала ВП
    */
    private void setConditionMenuForJournal() {
        EditMenu.setEnabled(false);
        WatermetersMenu.setEnabled(false);
    }

    private void ShowWatermetersMenuItemActionPerformed() throws SQLException {
       GWatermeter wm = new GWatermeter(this,true);
        wm.deleteRows();
        int result=Watermeter.searchWatermeter(CODE);
        GWatermeter.card=true;
        if(result==-1) {
            JOptionPane.showMessageDialog(null, "На водопроводном подключении с номером "+CODE+" еще не установлено водомеров!", "Результат поиска", JOptionPane.INFORMATION_MESSAGE);
        }else  wm.setVisible(true);
    }

    /* Устаналивает режим работы формы Водомерное подключение.
    * Если mode-true, то форма работает в качестве карточки водомерного подключения
    * Если mode-false,то в качестве журнала водомерных подключений.
    */
    private void setWatconMode(boolean mode) {
        if(mode){
            journal_mode=false;
            setTitle("Карточка водомерного подключения");
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
        }
        else{
            journal_mode=true;
            setTitle("Справочник водомерных подключений");
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
        }
    }

    //удаление строк в таблице
    void deleteRows() {
        model.setRowCount(0);
    }

    //очистка полей
    private void cleanFields(){
        for (JTextField textfield : textfields) textfield.setText(null);
        for (JComboBox comboboxe : comboboxes) comboboxe.setSelectedIndex(0);
        DateTYDatePicker.setDate(null);
        WatermetersMenu.setEnabled(false);
        ChangesMenu.setEnabled(false);
        NoteTextArea.setText(null);
    }
    /*
     * Принимает cond: true или false
     * Делает активными/неактивными поля соответственно
     */
    private void setConditionFields(boolean cond) {
        for (int i=1;i<textfields.length;i++)//код изменить нельзя
            textfields[i].setEditable(cond);
        for (JComboBox comboboxe : comboboxes) comboboxe.setEnabled(cond);
        DateTYDatePicker.setEditable(cond);
        NoteTextArea.setEditable(cond);

    }
}

