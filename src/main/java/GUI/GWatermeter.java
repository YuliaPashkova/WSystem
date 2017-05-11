package GUI;
import WORK.Access;
import WORK.Methods;
import WORK.Waterconnection;
import WORK.Watermeter;
import org.jdesktop.swingx.JXDatePicker;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/*
 * Created by Юлия on 18.04.2017.
 */
public class GWatermeter extends javax.swing.JDialog {
    public static boolean card = false;//если открыта карта водомера через ВП
    private static DefaultTableModel model = new DefaultTableModel();//модель таблицы с результатом поиска
    public javax.swing.JTextField CodeWatconTextField;
    private JTextField textfields [];//массив текстовых полей
    private JComboBox comboboxes[];//массив комбобоксов
    private String old_data[];//массив старых данных
    private JXDatePicker datepickers[];//массив дэйткиперов
    private boolean change_mode=false;//флаг изменений(true - если была нажата вкладка "изменить водомер",иначе false)
    private boolean journal_mode=false;//если открыт журнал,то  true
    private javax.swing.JMenuItem AcceptChangesMenuItem;
    private javax.swing.JLabel CaliberLabel;
    private javax.swing.JTextField CaliberTextField;
    private javax.swing.JMenuItem ChangeModeMenuItem;
    private javax.swing.JMenu ChangesMenu;
    private org.jdesktop.swingx.JXDatePicker CheckLastIndicatDatePicker;
    private javax.swing.JLabel CheckLastIndicatLabel;
    private javax.swing.JMenuItem ClearMenuItem;
    private javax.swing.JLabel CodeWatconLabel;
    private org.jdesktop.swingx.JXDatePicker DateCheckDatePicker;
    private javax.swing.JLabel DateCheckLabel;
    private org.jdesktop.swingx.JXDatePicker DateSetDatePicker;
    private javax.swing.JLabel DateSetLabel;
    private javax.swing.JMenuItem DeleteMenuItem;
    private javax.swing.JMenu EditMenu;
    private org.jdesktop.swingx.JXDatePicker EnterExploitDatePicker;
    private javax.swing.JLabel EnterExploitLabel;
    private javax.swing.JComboBox<String> InstalledComboBox;
    private javax.swing.JLabel InstalledlLabel;
    private javax.swing.JLabel InventNumLabel;
    private javax.swing.JTextField InventNumTextField;
    private javax.swing.JMenu JournalWMMenu;
    private javax.swing.JLabel LastIndicatLabel;
    private javax.swing.JTextField LastIndicatTextField;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JLabel PrimIndicatLabel;
    private javax.swing.JTextField PrimIndicatTextField;
    private javax.swing.JLabel ReleaseYearLabel;
    private javax.swing.JTextField ReleaseYearTextField;
    private javax.swing.JTable ResultTable;
    private org.jdesktop.swingx.JXDatePicker SealDatePicker;
    private javax.swing.JLabel SealLabel;
    private javax.swing.JMenuItem SearchMenuItem;
    private javax.swing.JLabel SerialNumLabel;
    private javax.swing.JTextField SerialNumTextField;
    private javax.swing.JComboBox<String> StatusComboBox;
    private javax.swing.JLabel StatusLabel;
    private javax.swing.JLabel TypeLabel;
    private javax.swing.JTextField TypeTextField;
    private javax.swing.JScrollPane jScrollPane1;

    public GWatermeter(javax.swing.JDialog parent, boolean mode) {
        super(parent, true);
        initComponents();
        initializationArrays();
        setWMode(mode);
    }

    public GWatermeter(GAccount parent, boolean mode) {
        super(parent, true);
        initComponents();
        initializationArrays();
        setWMode(mode);
    }

    public GWatermeter() {
        initComponents();
        initializationArrays();
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | javax.swing.UnsupportedLookAndFeelException | IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GWatermeter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GWatermeter().setVisible(true);
            }
        });
    }

    //добавление в таблицу новой строки
    public static void AddRowTable() throws SQLException {
        model.addRow(new Object[]{
                Watermeter.num_acc,Watermeter.code_watcon,Watermeter.serial_num,Watermeter.inv_num,Watermeter.type
        });
    }

    /*Метод иницииализиурет массивы*/
    public void initializationArrays(){
        textfields = new JTextField[]{CodeWatconTextField,TypeTextField,InventNumTextField,SerialNumTextField,ReleaseYearTextField,
                CaliberTextField,PrimIndicatTextField,LastIndicatTextField};
        comboboxes = new JComboBox[]{StatusComboBox,InstalledComboBox};
        datepickers = new JXDatePicker[]{DateSetDatePicker,EnterExploitDatePicker,SealDatePicker,DateCheckDatePicker,CheckLastIndicatDatePicker};
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
        jScrollPane1 = new javax.swing.JScrollPane();
        ResultTable = new javax.swing.JTable();
        InstalledComboBox = new javax.swing.JComboBox<>();
        StatusComboBox = new javax.swing.JComboBox<>();
        MenuBar = new javax.swing.JMenuBar();
        EditMenu = new javax.swing.JMenu();
        ChangesMenu = new javax.swing.JMenu();
        ChangeModeMenuItem = new javax.swing.JMenuItem();
        AcceptChangesMenuItem = new javax.swing.JMenuItem();
        DeleteMenuItem = new javax.swing.JMenuItem();
        JournalWMMenu = new javax.swing.JMenu();
        SearchMenuItem = new javax.swing.JMenuItem();
        ClearMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Карточка водомера ("+ Access.name_operator+")");
        ImageIcon icon = new ImageIcon("src\\main\\resources\\main_icon\\main_icon.png");
        setIconImage(icon.getImage());
        setResizable(false);

        CodeWatconLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        CodeWatconLabel.setText("Код ВП");

        CodeWatconTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        TypeLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        TypeLabel.setText("Тип водомера");

        TypeTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

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

        ResultTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "№ л/счета", "№ ВП", "Завод. номер", "Ивент.номер", "Тип"
                }
        ) {
            boolean[] canEdit = new boolean [] {
                    false, true, false, false, false
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

        InstalledComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "НЕ ВЫБРАНО", "ГУПС ВОДОКАНАЛ", "АБОНЕНТ" }));
        StatusComboBox.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        StatusComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "НЕ ВЫБРАНО", "РАБОЧЕЕ", "НЕ РАБОЧЕЕ" }));

        EditMenu.setText("Редактирование");

        ChangesMenu.setText("Изменения");

        ChangeModeMenuItem.setText("Включить режим изменения");
        ChangeModeMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    ChangeModeMenuItemActionPerformed();
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
                    AcceptChangesMenuItemActionPerformed();
                } catch (SQLException | ParseException e) {
                    e.printStackTrace();
                }
            }
        });
        ChangesMenu.add(AcceptChangesMenuItem);

        EditMenu.add(ChangesMenu);
        EditMenu.setEnabled(false);

        DeleteMenuItem.setText("Удалить текущий водомер");
        DeleteMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteMenuItemActionPerformed();
            }
        });
        EditMenu.add(DeleteMenuItem);

        MenuBar.add(EditMenu);

        JournalWMMenu.setText("Справочник водомеров");

        SearchMenuItem.setText("Поиск");
        SearchMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    SearchMenuItemActionPerformed();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
        JournalWMMenu.add(SearchMenuItem);

        ClearMenuItem.setText("Очистить форму");
        ClearMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearMenuItemActionPerformed();
            }
        });
        JournalWMMenu.add(ClearMenuItem);

        MenuBar.add(JournalWMMenu);

        setJMenuBar(MenuBar);

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
                                                .addGap(0, 0, Short.MAX_VALUE))
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
                                                                                .addComponent(InstalledlLabel))))
                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(StatusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(DateSetDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(InstalledComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                                        .addComponent(InstalledComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(StatusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>

    private void ResultTableMouseClicked(java.awt.event.MouseEvent evt) throws SQLException {
        if(evt.getClickCount()==1&&!change_mode)clickOnTable();
    }

    private void clickOnTable() throws SQLException {
        EditMenu.setEnabled(true);
        ChangeModeMenuItem.setEnabled(true);
        ChangesMenu.setEnabled(true);
        DeleteMenuItem.setEnabled(true);
        AcceptChangesMenuItem.setEnabled(false);
        Watermeter.showWatermeter(String.valueOf(ResultTable.getModel().getValueAt(ResultTable.getSelectedRow(), 2)));
        CodeWatconTextField.setText(String.valueOf(Watermeter.code_watcon));
        TypeTextField.setText(Watermeter.type);
        InventNumTextField.setText(String.valueOf(Watermeter.inv_num));
        SerialNumTextField.setText(String.valueOf(Watermeter.serial_num));
        ReleaseYearTextField.setText(String.valueOf(Watermeter.year_release));
        CaliberTextField.setText(String.valueOf(Watermeter.caliber));
        StatusComboBox.setSelectedItem(Watermeter.status);
        DateSetDatePicker.setDate(Watermeter.date_set);
        InstalledComboBox.setSelectedItem(Watermeter.installed);
        EnterExploitDatePicker.setDate(Watermeter.enter_exploit);
        SealDatePicker.setDate(Watermeter.seal);
        DateCheckDatePicker.setDate(Watermeter.date_check);
        PrimIndicatTextField.setText(String.valueOf(Watermeter.prim_indications));
        CheckLastIndicatDatePicker.setDate(Watermeter.check_last_indic);
        LastIndicatTextField.setText(String.valueOf(Watermeter.last_indications));

        if(journal_mode)setConditionMenuForJournal();

    }

    private void setConditionMenuForJournal() {
        EditMenu.setEnabled(false);
        DeleteMenuItem.setEnabled(false);
    }

    private void AcceptChangesMenuItemActionPerformed() throws SQLException, ParseException {
        String[] new_data = readData();
        String local_error="";//если один из комбобоксов не выбран
        boolean loc_error=false;//ошибка в комбобоксах
        if(new_data[8].equals("НЕ ВЫБРАНО")){
            loc_error=true;
            local_error="Выберите состояние!";
        }
        if(new_data[9].equals("НЕ ВЫБРАНО")){
            loc_error=true;
            local_error="Выберите кем был установлен водомер!";
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
                    switch (Watermeter.changeWatermeter(new_data,old_data[3])) {
                        case 0:// успешное изменение
                            JOptionPane.showMessageDialog(null, "Изменение данных прошло успешно! Выход из режима редактирования...", "Результат изменения", JOptionPane.INFORMATION_MESSAGE);
                            old_data = null;
                            changeMode(false);//выход из режима редактирования
                            break;
                        case -1:
                            JOptionPane.showMessageDialog(null, Watermeter.error, "Ошибка", JOptionPane.ERROR_MESSAGE);
                            break;
                    }
                else if (JOptionPane.showOptionDialog(null, "Выйти из режима редактирования?",
                        "Подтверждение", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]) == 0) {//Если да, то выйти из режима редактирования
                    changeMode(false);//выход из режима редактирования
                }
            }
        }
    }

    private void ClearMenuItemActionPerformed() {
       cleanFields();
    }

    private void SearchMenuItemActionPerformed() throws SQLException {
        search();
    }

    private void search() throws SQLException {
        String data [] = new String[15];
        data[0]=CodeWatconTextField.getText().trim();
        data[1]=TypeTextField.getText().trim();
        data[2]=InventNumTextField.getText().trim();
        data[3]=SerialNumTextField.getText().trim();
        data[4]=ReleaseYearTextField.getText().trim();

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date_check = DateCheckDatePicker.getDate();
            data[5] = format.format(date_check);
        } catch (Exception ex) {
            data[5] = "";
        }
        data[6]=CaliberTextField.getText().trim();
        data[7] = (String)InstalledComboBox.getSelectedItem();
        if (Objects.equals(data[7], "НЕ ВЫБРАНО")) data[7] = "";
        try {
            Date date_set = DateSetDatePicker.getDate();
            data[8] = format.format(date_set);
        } catch (Exception ex) {
            data[8] = "";
        }
        data[9]=PrimIndicatTextField.getText().trim();
        try {
            Date enter_expl = EnterExploitDatePicker.getDate();
            data[10] = format.format(enter_expl);
        } catch (Exception ex) {
            data[10] = "";
        }
        try {
            Date seal = SealDatePicker.getDate();
            data[11] = format.format(seal);
        } catch (Exception ex) {
            data[11] = "";
        }
        data[12]=LastIndicatTextField.getText().trim();
        try {
            Date check_last = CheckLastIndicatDatePicker.getDate();
            data[13] = format.format(check_last);
        } catch (Exception ex) {
            data[13] = "";
        }
        data[14] = (String)StatusComboBox.getSelectedItem();
        if (Objects.equals(data[14], "НЕ ВЫБРАНО")) data[14] = "";

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
            int result = Watermeter.searchWatermeterFromJournal(data);
            if (result == 0) {//если что-то найдено
                Watermeter.watermeter = null;//обнуление
                ResultTable.requestFocus();
            } else {
                deleteRows();//удаление строк из таблицы
                JOptionPane.showMessageDialog(null, "Не найдено!", "Результат поиска", JOptionPane.INFORMATION_MESSAGE);
            }
        }

    }

    private void ChangeModeMenuItemActionPerformed() throws SQLException {
        changeMode(true);
        old_data=readData();//считать все текущие данные
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

    private void changeMode(boolean cond) throws SQLException {
        if(cond){
            change_mode=true;
            JOptionPane.showMessageDialog(null,"Измените данные, затем нажмите \"Принять изменения\"", "Режим изменения", JOptionPane.INFORMATION_MESSAGE);
            ResultTable.setEnabled(false);
            DeleteMenuItem.setEnabled(false);
            ChangeModeMenuItem.setEnabled(false);
            AcceptChangesMenuItem.setEnabled(true);
            setConditionFields(true);
        }
        else{
            change_mode=false;
            ResultTable.setEnabled(true);
            EditMenu.setEnabled(false);
            AcceptChangesMenuItem.setEnabled(false);
            setConditionFields(false);
            cleanFields();
            deleteRows();
            if(card)Watermeter.searchWatermeter(String.valueOf(Waterconnection.code));//если через ВП
            else Watermeter.searchWatermeterForCard(GAccount.NUM_ACC); //если через лицевой счет
            ResultTable.requestFocus();
        }

    }
    /*
     * Принимает cond: true или false
     * Делает активными/неактивными поля соответственно
     */
    private void setConditionFields(boolean cond) {
        for (int i=1;i<textfields.length;i++)//код изменить нельзя
            textfields[i].setEditable(cond);
        for (JComboBox comboboxe : comboboxes) comboboxe.setEnabled(cond);
        for (JXDatePicker datepicker : datepickers) datepicker.setEditable(cond);
    }

    private void DeleteMenuItemActionPerformed() {
        Object[] options = {"Да", "Нет"};
        int n = JOptionPane.showOptionDialog(null, "Удалить выбранный водомер?",
                "Подтверждение удаления", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        if (n == 0) {
            Watermeter.deleteWatermeter(String.valueOf(ResultTable.getModel().getValueAt(ResultTable.getSelectedRow(), 2)));
            model.removeRow(ResultTable.getSelectedRow());//удаление строки из таблицы
            cleanFields();
            EditMenu.setEnabled(false);
            JOptionPane.showMessageDialog(null, "Водомер был удален!", "Результат удаления", JOptionPane.INFORMATION_MESSAGE);

        }
    }
    //Очистка полей
    private void cleanFields() {
        for (JTextField textfield : textfields) textfield.setText(null);
        for (JComboBox comboboxe : comboboxes) comboboxe.setSelectedIndex(0);
        for (JXDatePicker datepicker : datepickers) datepicker.setDate(null);
    }

    //удаление строк в таблице
    public void deleteRows() {
        model.setRowCount(0);
    }

    /*
   * Устаналивает режим работы формы Водомер.
   * Если mode-true, то форма работает в качестве карточки водомера
   * Если mode-false,то в качестве журнала водомеров.
   * */
    private void setWMode(boolean mode) {
        if(mode){
            journal_mode=false;
            setTitle("Карточка водомера");
            JournalWMMenu.setEnabled(false);//отключени вкладки "журнал водомеров"
            CodeWatconTextField.setEditable(false);
            TypeTextField.setEditable(false);
            InventNumTextField.setEditable(false);
            SerialNumTextField.setEditable(false);
            ReleaseYearTextField.setEditable(false);
            CaliberTextField.setEditable(false);
            StatusComboBox.setEnabled(false);
            DateSetDatePicker.setEditable(false);
            InstalledComboBox.setEnabled(false);
            EnterExploitDatePicker.setEditable(false);
            SealDatePicker.setEditable(false);
            DateCheckDatePicker.setEditable(false);
            PrimIndicatTextField.setEditable(false);
            LastIndicatTextField.setEditable(false);
            CheckLastIndicatDatePicker.setEditable(false);
        }
        else{
            journal_mode=true;
            setTitle("Справочник водомеров");
            EditMenu.setEnabled(false);//отключение вкладки "редактирование"
            JournalWMMenu.setEnabled(true);//включение вкладки "журнал водомеров"
            CodeWatconTextField.setEditable(true);
            TypeTextField.setEditable(true);
            InventNumTextField.setEditable(true);
            SerialNumTextField.setEditable(true);
            ReleaseYearTextField.setEditable(true);
            CaliberTextField.setEditable(true);
            StatusComboBox.setEnabled(true);
            DateSetDatePicker.setEditable(true);
            InstalledComboBox.setEnabled(true);
            EnterExploitDatePicker.setEditable(true);
            SealDatePicker.setEditable(true);
            DateCheckDatePicker.setEditable(true);
            PrimIndicatTextField.setEditable(true);
            LastIndicatTextField.setEditable(true);
            CheckLastIndicatDatePicker.setEditable(true);
        }
    }
}
