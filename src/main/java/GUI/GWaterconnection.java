package GUI;
import WORK.*;
import com.mxrck.autocompleter.TextAutoCompleter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
/*
 * Created by Юлия on 19.04.2017.
 */

public class GWaterconnection extends javax.swing.JDialog {
    static DefaultTableModel model = new DefaultTableModel();//модель таблицы с результатом поиска
    JTextField textfields [];//массив текстовых полей
    JComboBox comboboxes[];//массив комбобоксов
    private String old_data[];//массив старых данных
    private boolean change_mode=false;//флаг изменений(true - если была нажата вкладка "изменить ВП",иначе false)
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

    public GWaterconnection(boolean mode,java.awt.Frame parent) throws SQLException {
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

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new GWaterconnection(true,null).setVisible(true);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    //добавление в таблицу новой строки
    public static void AddRowTable() throws SQLException {
        model.addRow(new Object[]{
                Waterconnection.code,Waterconnection.status,Waterconnection.getObjectFromIndex(Waterconnection.object_con)
                });
    }

    @SuppressWarnings("unchecked")
    private void initComponents() throws SQLException {
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

        CodeWatconLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        CodeWatconLabel.setText("Код ВП");

        CodeWatconTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        NumTYLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        NumTYLabel.setText("№ ТУ");
        NumTYTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        DateTYLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        DateTYLabel.setText("Дата ТУ");


        StatusLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        StatusLabel.setText("Состояние");

        OwnerLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        OwnerLabel.setText("Принадлежность ВП");

        ObjectConLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ObjectConLabel.setText("Объект подключения");

        TypeConLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        TypeConLabel.setText("Вид подключения");

        ObjectConTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        OwnerTerLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        OwnerTerLabel.setText("Принадлежность территории");

        OwnerTerTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        LocationLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        LocationLabel.setText("Местонахождение ВП");

        DepthLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        DepthLabel.setText("Глубина (м)");

        LocationTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        DepthTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        NoteLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        NoteLabel.setText("Примечание");

        ResultTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "Код ВП", "Состояние", "Объект подключения"
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
        ChangeModeMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    ChangeModeMenuItemActionPerformed(evt);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
        ChangesMenu.add(ChangeModeMenuItem);

        AcceptChangesMenuItem.setText("Принять изменения");
        AcceptChangesMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    AcceptChangesMenuItemActionPerformed(evt);
                } catch (SQLException | ParseException e) {
                    e.printStackTrace();
                }
            }
        });
        ChangesMenu.add(AcceptChangesMenuItem);
        ChangesMenu.setEnabled(false);

        EditMenu.add(ChangesMenu);

        DeleteMenuItem.setText("Удалить текущее подключение");
        DeleteMenuItem.setEnabled(false);
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
        WatermetersMenu.setEnabled(false);

        ShowWatermetersMenuItem.setText("Открыть водомеры текущего ВП");
        ShowWatermetersMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowWatermetersMenuItemActionPerformed(evt);
            }
        });
        WatermetersMenu.add(ShowWatermetersMenuItem);
       // ShowWatermetersMenuItem.setEnabled(false);
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

    private void ResultTableMouseClicked(java.awt.event.MouseEvent evt) throws SQLException {
        if(evt.getClickCount()==1&&!change_mode)clickOnTable();
    }

    private void clickOnTable() throws SQLException {
        ChangeModeMenuItem.setEnabled(true);
        ShowWatermetersMenuItem.setEnabled(true);
        ChangesMenu.setEnabled(true);
        EditMenu.setEnabled(true);
        AcceptChangesMenuItem.setEnabled(false);
        DeleteMenuItem.setEnabled(true);
        WatermetersMenu.setEnabled(true);
        Waterconnection.showWaterconnection(String.valueOf(ResultTable.getModel().getValueAt(ResultTable.getSelectedRow(), 0)));
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
    }

    private void ChangeModeMenuItemActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {
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
        String date_TY;
        try{
            date_TY = dateFormat.format(DateTYDatePicker.getDate());//
        }catch (NullPointerException ex){
            date_TY= null;
        }
        datafields[9]=date_TY;
        datafields[10]=NoteTextArea.getText();
        for(int i=0;i<datafields.length;i++)
            if(datafields[i]!=null) datafields[i]=datafields[i].toUpperCase();
        return datafields;
    }
    /*
     * Изменение данных
     */
    private void AcceptChangesMenuItemActionPerformed(java.awt.event.ActionEvent evt) throws SQLException, ParseException {
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
            DeleteMenuItem.setEnabled(false);
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

    private void DeleteMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        Object[] options = {"Да", "Нет"};
        int n = JOptionPane.showOptionDialog(null, "Удалить выбранное водомерное подключение? Так же будут удалены\n все водомеры,привязанные к водомерному подключению.",
                "Подтверждение удаления", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        if (n == 0) {
            Waterconnection.deleteWaterconnection(String.valueOf(ResultTable.getModel().getValueAt(ResultTable.getSelectedRow(), 0)));
            model.removeRow(ResultTable.getSelectedRow());//удаление строки из таблицы
            cleanFields();
            ChangesMenu.setEnabled(false);
            DeleteMenuItem.setEnabled(false);
            JOptionPane.showMessageDialog(null, "Водомерное подключение было удалено!", "Результат удаления", JOptionPane.INFORMATION_MESSAGE);

        }
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

    /* Устаналивает режим работы формы Водомерное подключение.
    * Если mode-true, то форма работает в качестве карточки водомерного подключения
    * Если mode-false,то в качестве журнала водомерных подключений.
    */
    private void setWatconMode(boolean mode) {
        if(mode){
            setTitle("Карточка водомерного подключения");
           // EditMenu.setEnabled(true);//включение вкладки "редактирование"
           // WatermetersMenu.setEnabled(true);
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
            setTitle("Справочник водомерных подключений");
           // EditMenu.setEnabled(false);//отключение вкладки "редактирование"
           // WatermetersMenu.setEnabled(false);
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
    public void deleteRows() {
        model.setRowCount(0);
    }

    //очистка полей
    private void cleanFields(){
        for(int i=0;i<textfields.length;i++) textfields[i].setText(null);
        for(int i=0;i<comboboxes.length;i++)comboboxes[i].setSelectedIndex(0);
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
        for (int i=0;i<comboboxes.length;i++)
            comboboxes[i].setEnabled(cond);
        DateTYDatePicker.setEditable(cond);
        NoteTextArea.setEditable(cond);

    }
}

