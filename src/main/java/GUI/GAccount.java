package GUI;
import WORK.*;
import com.mxrck.autocompleter.TextAutoCompleter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import static WORK.Connect.close;
import static WORK.Connect.conntoDB;

/*
 * Created by Юлия on 13.04.2017.
 */
public class GAccount extends javax.swing.JFrame {
    public static String NUM_ACC;//номер аккаунта (необходимо запомнить для контактных лиц)
    private static DefaultTableModel model = new DefaultTableModel();//модель таблицы с результатом поиска
    private boolean change_mode=false;//флаг изменений(true - если была нажата вкладка "изменить лиц.счет",иначе false)
    private JTextField textfields [];//массив текстовых полей
    private JComboBox comboboxes[];//массив комбобоксов
    private String old_data[];//массив старых данных

    private javax.swing.JTextField AdressTextField;
    private javax.swing.JTextField BIKTextField;
    private javax.swing.JTextField BalanceTextField;
    private javax.swing.JTextField BankAccTextField;//расчетный счет
    private javax.swing.JTextField BankTextField;
    private javax.swing.JMenu CatalogMenu;
    private javax.swing.JMenuItem ChangeAccMenuItem;
    private javax.swing.JButton ClearButton;
    private javax.swing.JComboBox<String> ConsTypeComboBox;
    private javax.swing.JButton ContactsButton;
    private javax.swing.JTextField CorpusTextField;
    private javax.swing.JButton CountAccButton;
    private javax.swing.JMenu DataProtectionMenu;
    private org.jdesktop.swingx.JXDatePicker DateContractDatePicker;
    private javax.swing.JMenuItem DeleteAccMenuItem;
    private javax.swing.JComboBox<String> DistrictComboBox;
    private javax.swing.JMenu DocumentsMenu;
    private javax.swing.JMenu ExitProgrammMenu;
    private javax.swing.JTextField FlatTextField;
    private javax.swing.JTextField HouseTextField;
    private javax.swing.JTextField INNTextField;
    private javax.swing.JTextField IndexTextField;
    private javax.swing.JTextField KPPTextField;
    private javax.swing.JTextField MiddleNameTextField;
    private javax.swing.JTextField NameCompanyTextField;
    private javax.swing.JTextField NameTextField;
    private javax.swing.JMenuItem NewAccMenuItem;
    private javax.swing.JMenuItem NewWaterconMenuItem;
    private javax.swing.JMenuItem NewWatermeterMenuItem;
    private javax.swing.JTextField NumAccTextField;
    private javax.swing.JTextField NumContractTextField;
    private javax.swing.JTextField NumSertifTextField;
    private javax.swing.JMenu OrderMenu;
    private javax.swing.JTextField OwnerTextField;
    private javax.swing.JTable ResultTable;
    private javax.swing.JButton SearchButton;
    private javax.swing.JComboBox<String> StatusAccComboBox;
    private javax.swing.JButton SummBalanceButton;
    private javax.swing.JTextField SurnameTextField;
    private javax.swing.JTextField TelephoneTextField;
    private javax.swing.JButton WaterconButton;
    private javax.swing.JButton WatermeterButton;
    private javax.swing.JMenuItem newOrderMenuItem;

    GAccount() throws Exception {
        conntoDB();
        initComponents();
        textfields = new JTextField[]{//массив текстовых полей
                NumAccTextField, SurnameTextField, NameTextField, MiddleNameTextField,
                BalanceTextField, NumContractTextField, AdressTextField, HouseTextField,
                CorpusTextField, FlatTextField, IndexTextField, TelephoneTextField,
                OwnerTextField, NameCompanyTextField, NumSertifTextField, BankTextField,
                BankAccTextField, INNTextField, KPPTextField, BIKTextField
        };
        comboboxes=new JComboBox[]{//массив комбобоксов
            DistrictComboBox, ConsTypeComboBox, StatusAccComboBox
        };

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
            java.util.logging.Logger.getLogger(GAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new GAccount().setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    //добавление в таблицу новой строки
    public static void AddRowTable() {
        model.addRow(new Object[]{
                Account.num_account, Methods.Zero(Double.toString(Account.balance)),
                Account.FIO, Account.cons_type});
    }

    private void initComponents() throws SQLException {
        JLabel districtLabel = new JLabel();
        JLabel FIOLabel = new JLabel();
        SurnameTextField = new javax.swing.JTextField();
        JLabel numAccLabel = new JLabel();
        NumAccTextField = new javax.swing.JTextField();
        JLabel balanceLabel = new JLabel();
        BalanceTextField = new javax.swing.JTextField();
        MiddleNameTextField = new javax.swing.JTextField();
        NameTextField = new javax.swing.JTextField();
        NumContractTextField = new javax.swing.JTextField();
        JLabel dateContractLabel = new JLabel();
        JLabel numContractLabel = new JLabel();
        JLabel adressLabel = new JLabel();
        AdressTextField = new javax.swing.JTextField();
        JLabel houseLabel = new JLabel();
        HouseTextField = new javax.swing.JTextField();
        JLabel corpusLabel = new JLabel();
        CorpusTextField = new javax.swing.JTextField();
        FlatTextField = new javax.swing.JTextField();
        JLabel ownerLabel = new JLabel();
        OwnerTextField = new javax.swing.JTextField();
        JLabel consTypeLabel = new JLabel();
        JLabel indexLabel = new JLabel();
        JLabel telephoneLabel = new JLabel();
        IndexTextField = new javax.swing.JTextField();
        TelephoneTextField = new javax.swing.JTextField();
        JLabel statusAccLabel = new JLabel();
        BankTextField = new javax.swing.JTextField();
        JLabel bankLabel = new JLabel();
        JLabel BIKLabel = new JLabel();
        JLabel KPPLabel = new JLabel();
        BIKTextField = new javax.swing.JTextField();
        KPPTextField = new javax.swing.JTextField();
        JLabel bankAccLabel = new JLabel();
        JLabel numSertifLabel = new JLabel();
        JLabel INNLabel = new JLabel();
        BankAccTextField = new javax.swing.JTextField();
        NumSertifTextField = new javax.swing.JTextField();
        INNTextField = new javax.swing.JTextField();
        SearchButton = new javax.swing.JButton();
        DateContractDatePicker = new org.jdesktop.swingx.JXDatePicker();
        DateContractDatePicker.setFormats("yyyy-MM-dd");
        DateContractDatePicker.setDate(null);
        DateContractDatePicker.setLinkDate(System.currentTimeMillis(), "Сегодня {0}");
        WatermeterButton = new javax.swing.JButton();
        JSeparator separator = new JSeparator();
        JScrollPane jScrollPane1 = new JScrollPane();
        ResultTable = new javax.swing.JTable();
        WaterconButton = new javax.swing.JButton();
        ClearButton = new javax.swing.JButton();
        CountAccButton = new javax.swing.JButton();
        SummBalanceButton = new javax.swing.JButton();
        ContactsButton = new javax.swing.JButton();
        JLabel flatLabel = new JLabel();
        JSeparator jSeparator2 = new JSeparator();
        NameCompanyTextField = new javax.swing.JTextField();
        JLabel nameCompanyLabel = new JLabel();
        DistrictComboBox = new javax.swing.JComboBox<>();
        ConsTypeComboBox = new javax.swing.JComboBox<>();
        StatusAccComboBox = new javax.swing.JComboBox<>();
        JMenuBar menuBar = new JMenuBar();
        JMenu changesMenu = new JMenu();
        NewAccMenuItem = new javax.swing.JMenuItem();
        ChangeAccMenuItem = new javax.swing.JMenuItem();
        DeleteAccMenuItem = new javax.swing.JMenuItem();
        JPopupMenu.Separator menuSeparator1 = new JPopupMenu.Separator();
        NewWatermeterMenuItem = new javax.swing.JMenuItem();
        NewWaterconMenuItem = new javax.swing.JMenuItem();
        JPopupMenu.Separator menuSeparator = new JPopupMenu.Separator();
        CatalogMenu = new javax.swing.JMenu();
        JMenuItem watermeterMenuItem = new JMenuItem();
        JMenuItem waterconMenuItem = new JMenuItem();
        JMenuItem ordersMenuItem = new JMenuItem();
        OrderMenu = new javax.swing.JMenu();
        newOrderMenuItem = new JMenuItem();
        JMenuItem closeOrderMenuItem = new JMenuItem();
        DocumentsMenu = new javax.swing.JMenu();
        JMenuItem noticeDeptMenuItem = new JMenuItem();
        JMenuItem patternDeptMenuItem = new JMenuItem();
        JMenuItem listDeptorsMenuItem = new JMenuItem();
        DataProtectionMenu = new javax.swing.JMenu();
        JMenuItem encryptDataMenuItem = new JMenuItem();
        JMenuItem decryptDataMenuItem = new JMenuItem();
        ExitProgrammMenu = new javax.swing.JMenu();

        //AUTOCOMPLETERS

        TextAutoCompleter streetcomplete = new TextAutoCompleter(AdressTextField);
        Connect.retrieveStreet();
        while (Connect.rs.next()) {
            streetcomplete.addItem(Connect.rs.getString("street"));
        }

        TextAutoCompleter bankcomplete = new TextAutoCompleter(BankTextField);
        Connect.retrieveBank();
        while (Connect.rs.next()) {
            bankcomplete.addItem(Connect.rs.getString("bank"));
        }

        TextAutoCompleter indexcomplete = new TextAutoCompleter(IndexTextField);
        Connect.retrieveIndex();
        while (Connect.rs.next()) {
            indexcomplete.addItem(Connect.rs.getString("indx"));
        }

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Лицевой счет ("+ Access.name_operator+")");
        ImageIcon icon = new ImageIcon("src\\main\\resources\\main_icon\\main_icon.png");
        setIconImage(icon.getImage());
        setResizable(false);

        districtLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        districtLabel.setText("Район");

        FIOLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        FIOLabel.setText("Фамилия, имя, отчество");

        SurnameTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N


        numAccLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        numAccLabel.setText("№ лицевого счета");

        NumAccTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        balanceLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        balanceLabel.setText("Баланс");

        BalanceTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N


        MiddleNameTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N


        NameTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N


        NumContractTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N


        dateContractLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        dateContractLabel.setText("Дата договора");

        numContractLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        numContractLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        numContractLabel.setText("№ договора");

        adressLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        adressLabel.setText("Адрес");

        AdressTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N


        houseLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        houseLabel.setText("Дом");

        HouseTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N


        corpusLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        corpusLabel.setText("Корпус");

        CorpusTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N


        FlatTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N


        ownerLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ownerLabel.setText("Владелец");

        OwnerTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N


        consTypeLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        consTypeLabel.setText("Категория потребителей");

        indexLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        indexLabel.setText("Индекс");

        telephoneLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        telephoneLabel.setText("Телефон");

        IndexTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N


        TelephoneTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N


        statusAccLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        statusAccLabel.setText("Статус cчета");

        BankTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        bankLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bankLabel.setText("Банк плательщика");

        BIKLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        BIKLabel.setText("БИК");

        KPPLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        KPPLabel.setText("КПП");

        BIKTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N


        KPPTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N


        bankAccLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bankAccLabel.setText("Расчетный счет");

        numSertifLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        numSertifLabel.setText("№ свидетельства");

        INNLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        INNLabel.setText("ИНН");

        BankAccTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        NumSertifTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N


        INNTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N


        SearchButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        SearchButton.setText("Поиск");
        SearchButton.addActionListener(evt -> {
            try {
                SearchButtonActionPerformed();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        WatermeterButton.setIcon(new javax.swing.ImageIcon("src\\main\\resources\\buttons\\Vodomer_icon.jpg")); // NOI18N // NOI18N
        WatermeterButton.setRequestFocusEnabled(false);
        WatermeterButton.setEnabled(false);
        WatermeterButton.addActionListener(evt -> {
            try {
                WatermeterButtonActionPerformed();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });

        separator.setOrientation(javax.swing.SwingConstants.VERTICAL);

        ResultTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "№ л/счета", "Баланс", "ФИО", "Тип абонента"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                    false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
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
        jScrollPane1.setViewportView(ResultTable);

        WaterconButton.setIcon(new javax.swing.ImageIcon("src\\main\\resources\\buttons\\vodomerniy_uzel.jpg")); // NOI18N
        WaterconButton.addActionListener(evt -> {
            try {
                WaterconButtonActionPerformed();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        WaterconButton.setEnabled(false);

        ClearButton.setIcon(new javax.swing.ImageIcon("src\\main\\resources\\buttons\\ikonka-korziny.jpg")); // NOI18N
        ClearButton.addActionListener(evt -> ClearButtonActionPerformed());

        CountAccButton.setIcon(new javax.swing.ImageIcon("src\\main\\resources\\buttons\\n_icon.jpg")); // NOI18N
        CountAccButton.addActionListener(evt -> CountAccButtonActionPerformed());

        SummBalanceButton.setIcon(new javax.swing.ImageIcon("src\\main\\resources\\buttons\\summa_icon.jpg")); // NOI18N
        SummBalanceButton.addActionListener(evt -> {
            try {
                SummBalanceButtonActionPerformed();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });

        ContactsButton.setIcon(new javax.swing.ImageIcon("src\\main\\resources\\buttons\\contacts_icon.jpg")); // NOI18N
        ContactsButton.addActionListener(evt -> {
            try {
                ContactsButtonActionPerformed();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        ContactsButton.setEnabled(false);

        flatLabel.setText("КВ");

        NameCompanyTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        nameCompanyLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        nameCompanyLabel.setText("Название предприятия");

        DistrictComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"НЕ ВЫБРАНО", "ГАГАРИНСКИЙ", "ЛЕНИНСКИЙ", "НАХИМОВСКИЙ", "БАЛАКЛАВСКИЙ"}));
        ConsTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"НЕ ВЫБРАНО", "ФИЗИЧЕСКОЕ ЛИЦО", "ЮРИДИЧЕСКОЕ ЛИЦО"}));
        StatusAccComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"НЕ ВЫБРАНО", "ОТКРЫТ", "ЗАКРЫТ"}));

        changesMenu.setText("Изменения");

        NewAccMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        NewAccMenuItem.setText("Новый лицевой счет");
        NewAccMenuItem.addActionListener(evt -> {
            try {
                NewAccMenuItemActionPerformed();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        changesMenu.add(NewAccMenuItem);

        ChangeAccMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        ChangeAccMenuItem.setText("Изменение текущей записи");
        ChangeAccMenuItem.setEnabled(false);
        ChangeAccMenuItem.addActionListener(evt -> {
            try {
                ChangeAccMenuItemActionPerformed();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        changesMenu.add(ChangeAccMenuItem);

        DeleteAccMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DELETE, java.awt.event.InputEvent.CTRL_MASK));
        DeleteAccMenuItem.setText("Удалить лицевой счет");
        DeleteAccMenuItem.setEnabled(false);
        DeleteAccMenuItem.addActionListener(evt -> {
            try {
                DeleteAccMenuItemActionPerformed();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        changesMenu.add(DeleteAccMenuItem);
        changesMenu.add(menuSeparator1);

        NewWatermeterMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        NewWatermeterMenuItem.setText("Новый водомер");
        NewWatermeterMenuItem.setEnabled(false);
        NewWatermeterMenuItem.addActionListener(evt -> {
            try {
                NewWatermeterMenuItemActionPerformed();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        changesMenu.add(NewWatermeterMenuItem);

        NewWaterconMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        NewWaterconMenuItem.setText("Новое водомерное подключение");
        NewWaterconMenuItem.setEnabled(false);
        NewWaterconMenuItem.addActionListener(evt -> {
            try {
                NewWaterconMenuItemActionPerformed();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        changesMenu.add(NewWaterconMenuItem);
        changesMenu.add(menuSeparator);

        menuBar.add(changesMenu);

        CatalogMenu.setText("Справочники");

        watermeterMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        watermeterMenuItem.setText("Водомеры");
        watermeterMenuItem.addActionListener(evt -> WatermeterMenuItemActionPerformed());
        CatalogMenu.add(watermeterMenuItem);

        waterconMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, 0));
        waterconMenuItem.setText("Водомерные подключения");
        waterconMenuItem.addActionListener(evt -> {
            try {
                WaterconMenuItemActionPerformed();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        CatalogMenu.add(waterconMenuItem);

        ordersMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        ordersMenuItem.setText("Журнал заказов");
        ordersMenuItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OrdersMenuItemMouseClicked();
            }
        });
        ordersMenuItem.addActionListener(evt -> OrdersMenuItemActionPerformed());
        CatalogMenu.add(ordersMenuItem);
        menuBar.add(CatalogMenu);

        OrderMenu.setText("Заказы");
        //OrderMenu.setEnabled(false);

        newOrderMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F6, 0));
        newOrderMenuItem.setText("Новый заказ");
        newOrderMenuItem.setEnabled(false);
        newOrderMenuItem.addActionListener(evt -> {
            try {
                NewOrderMenuItemActionPerformed();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        OrderMenu.add(newOrderMenuItem);

        closeOrderMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F7, 0));
        closeOrderMenuItem.setText("Закрыть заказ");
        closeOrderMenuItem.addActionListener(evt -> CloseOrderMenuItemActionPerformed());
        OrderMenu.add(closeOrderMenuItem);

        menuBar.add(OrderMenu);

        DocumentsMenu.setText("Документы");

        noticeDeptMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_1, java.awt.event.InputEvent.CTRL_MASK));
        noticeDeptMenuItem.setText("Сформировать извещение о долге");
        noticeDeptMenuItem.addActionListener(evt -> NoticeDeptMenuItemActionPerformed());
        DocumentsMenu.add(noticeDeptMenuItem);

        patternDeptMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_2, java.awt.event.InputEvent.CTRL_MASK));
        patternDeptMenuItem.setText("Шаблон извещения о долге");
        patternDeptMenuItem.addActionListener(evt -> PatternDeptMenuItemActionPerformed());
        DocumentsMenu.add(patternDeptMenuItem);

        listDeptorsMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_3, java.awt.event.InputEvent.CTRL_MASK));
        listDeptorsMenuItem.setText("Список должников");
        listDeptorsMenuItem.addActionListener(evt -> ListDeptorsMenuItemActionPerformed());
        DocumentsMenu.add(listDeptorsMenuItem);

        menuBar.add(DocumentsMenu);

        DataProtectionMenu.setText("Защита данных");

        encryptDataMenuItem.setText("Шифрование дампа базы данных");
        encryptDataMenuItem.addActionListener(evt -> EncryptDataMenuItemActionPerformed());
        DataProtectionMenu.add(encryptDataMenuItem);

        decryptDataMenuItem.setText("Дешифрование дампа базы данных");
        decryptDataMenuItem.addActionListener(evt -> DecryptDataMenuItemActionPerformed());
        DataProtectionMenu.add(decryptDataMenuItem);

        menuBar.add(DataProtectionMenu);

        ExitProgrammMenu.setText("Выход");
        ExitProgrammMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
                    ExitProgrammMenuMouseClicked();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        menuBar.add(ExitProgrammMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(WatermeterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(WaterconButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(ContactsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(ClearButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(CountAccButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(SummBalanceButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(separator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                                                                .addComponent(DistrictComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                                .addGap(36, 36, 36)
                                                                                                                .addComponent(districtLabel)
                                                                                                                .addGap(43, 43, 43)))
                                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                                        .addComponent(numAccLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                                        .addComponent(NumAccTextField)))
                                                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                                                .addGap(43, 43, 43)
                                                                                                .addComponent(FIOLabel)))
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                                                        .addGap(10, 10, 10)
                                                                                                        .addComponent(numContractLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                        .addGap(43, 43, 43)
                                                                                                        .addComponent(dateContractLabel))
                                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                        .addComponent(ConsTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                        .addComponent(BalanceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                .addComponent(consTypeLabel)
                                                                                                .addGap(29, 29, 29)
                                                                                                .addComponent(balanceLabel)))
                                                                                .addGap(3, 3, 3))
                                                                        .addComponent(OwnerTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addComponent(SearchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                                                .addComponent(NameCompanyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(NumSertifTextField))
                                                                                        .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                        .addComponent(AdressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                        .addComponent(HouseTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                                                .addComponent(CorpusTextField)
                                                                                                                .addComponent(corpusLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                        .addComponent(FlatTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                        .addComponent(IndexTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                                                                        .addComponent(MiddleNameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                                                                                                                        .addComponent(SurnameTextField)
                                                                                                                        .addComponent(NameTextField))
                                                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                                        .addGap(85, 85, 85)
                                                                                                                        .addComponent(adressLabel)))
                                                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                                        .addComponent(NumContractTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                        .addComponent(DateContractDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                                        .addGap(10, 10, 10)
                                                                                                                        .addComponent(statusAccLabel)
                                                                                                                        .addGap(59, 59, 59)
                                                                                                                        .addComponent(telephoneLabel))
                                                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                .addComponent(StatusAccComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                .addComponent(houseLabel))
                                                                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                .addComponent(TelephoneTextField)
                                                                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                                                        .addComponent(flatLabel)
                                                                                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                                                                        .addComponent(indexLabel)
                                                                                                                                        .addGap(42, 42, 42)))))))
                                                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                        .addComponent(BankTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                                .addGap(66, 66, 66)
                                                                                                                .addComponent(INNLabel)))
                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                        .addComponent(BankAccTextField)
                                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                                .addComponent(KPPLabel)
                                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                                                .addComponent(BIKLabel)
                                                                                                                .addGap(65, 65, 65))))
                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                .addComponent(INNTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(KPPTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(BIKTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(58, 58, 58)
                                                                .addComponent(nameCompanyLabel)
                                                                .addGap(118, 118, 118)
                                                                .addComponent(numSertifLabel))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(63, 63, 63)
                                                                .addComponent(bankLabel)
                                                                .addGap(137, 137, 137)
                                                                .addComponent(bankAccLabel))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(85, 85, 85)
                                                                .addComponent(ownerLabel))))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(WatermeterButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(WaterconButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(ContactsButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(SummBalanceButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(CountAccButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(ClearButton))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(separator, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                        .addGap(3, 3, 3)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(districtLabel)
                                                                .addComponent(numAccLabel)
                                                                .addComponent(balanceLabel)
                                                                .addComponent(consTypeLabel))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(NumAccTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(DistrictComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(ConsTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(BalanceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(numContractLabel)
                                                                        .addComponent(dateContractLabel))
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addComponent(FIOLabel)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(SurnameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(NumContractTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(DateContractDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(NameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(statusAccLabel)
                                                                .addComponent(telephoneLabel))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(MiddleNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(StatusAccComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(TelephoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGap(10, 10, 10)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(corpusLabel)
                                                                .addComponent(flatLabel)
                                                                .addComponent(houseLabel)
                                                                .addComponent(adressLabel)
                                                                .addComponent(indexLabel))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(AdressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(HouseTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(CorpusTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(FlatTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(IndexTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(ownerLabel)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(OwnerTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(nameCompanyLabel)
                                                                .addComponent(numSertifLabel))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(NameCompanyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(NumSertifTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(bankLabel)
                                                                .addComponent(bankAccLabel))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(BankTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(BankAccTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(INNLabel)
                                                                .addComponent(KPPLabel)
                                                                .addComponent(BIKLabel))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(INNTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(KPPTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(BIKTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(SearchButton))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>

    private void SearchButtonActionPerformed() throws Exception {
        if(change_mode)change();//если включен режим изменения
        else search();
    }

    /*
    * Метод осуществляет изменение данных
    * */
    private void change() throws Exception {
        String[] new_data = readData();
        String local_error="";//если один из комбобоксов не выбран
        boolean loc_error=false;//ошибка в комбобоксах
        if(new_data[20].equals("НЕ ВЫБРАНО")){//район
            loc_error=true;
            local_error="Выберите район!";
        }
         if(new_data[22].equals("НЕ ВЫБРАНО")){//статус счета
             loc_error=true;
             local_error="Выберите статус счета!";
         }
        if(loc_error) JOptionPane.showMessageDialog(null,local_error, "Ошибка", JOptionPane.ERROR_MESSAGE);
        else {
            //сравнение данных и проверка на изменение данных
            if (Methods.haveNewValues(Methods.compareData(old_data, new_data)) == 0) {//данные не изменялись
                JOptionPane.showMessageDialog(null, "Данные не были изменены. Выход из режима редактирования...", "Выход", JOptionPane.INFORMATION_MESSAGE);
                NumAccTextField.setEditable(true);
                ConsTypeComboBox.setEnabled(true);
                changeMode(false, true);//выход из режима редактирования
                setDefaultConditionButton();
            } else {
                Object[] options = {"Да", "Нет"};
                if (JOptionPane.showOptionDialog(null, "Принять изменения?", "Подтверждение", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, options, options[0]) == 0)//если да,то изменить бд
                    switch (Account.changeData(new_data)) {
                        case 0:// успешное изменение
                            JOptionPane.showMessageDialog(null, "Изменение данных прошло успешно! Выход из режима редактирования...", "Результат изменения", JOptionPane.INFORMATION_MESSAGE);
                            NumAccTextField.setEditable(true);
                            ConsTypeComboBox.setEnabled(true);
                            old_data = null;
                            changeMode(false, true);//выход из режима редактирования
                            setDefaultConditionButton();
                            break;
                        case -1:
                            JOptionPane.showMessageDialog(null, Account.error, "Ошибка", JOptionPane.ERROR_MESSAGE);
                            break;
                    }
                else if (JOptionPane.showOptionDialog(null, "Выйти из режима редактирования?",
                        "Подтверждение", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]) == 0) {//Если да, то выйти из режима редактирования
                    changeMode(false, true);//выход из режима редактирования
                    setDefaultConditionButton();
                    NumAccTextField.setEditable(true);
                    ConsTypeComboBox.setEnabled(true);
                }
            }
        }
    }

    /*
    Метод считывает данные из всех полей и возвращает их в виде массива
     */
    private String [] readData() {
        String data[] = new String[24];
        String datafields[] = new  String [20];//массив,где будут хранится данные из текстовых полей
        String datacomboboxes[] = new String[3];//массив,где будут хранится данные из комбобоксов
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date_contract;
        try{
            date_contract = dateFormat.format(DateContractDatePicker.getDate());//дата договора
        }catch (NullPointerException ex){
            date_contract= null;
        }
        for(int i=0;i<textfields.length;i++)//считывание данных из текстовых полей
            datafields[i]=textfields[i].getText();
        for(int i=0;i<comboboxes.length;i++)datacomboboxes[i]=(String)comboboxes[i].getSelectedItem();
        System.arraycopy(datafields, 0, data, 0, 20);//копирование данных из текстовых полей
        System.arraycopy(datacomboboxes, 0, data, 20, 3);//копирование данных из комбобоксов
        data[23]=date_contract;

        for(int i=0;i<data.length;i++)
            if(data[i]!=null) data[i]=data[i].toUpperCase();
        return  data;
    }
    /*
    * Метод собирает данные для поиска,затем вызвает метод поиска
    * */
    private void search() throws Exception {
        String data[] = new String[23];//данные из текстовых полей
        data[0] = NumAccTextField.getText().trim();

        data[1] = SurnameTextField.getText().toUpperCase() + " " + NameTextField.getText().toUpperCase() + " " + MiddleNameTextField.getText().toUpperCase();
        data[1] = data[1].trim();//удалить пробелы

        data[2] = BalanceTextField.getText().trim();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date_contr = DateContractDatePicker.getDate();
            data[3] = format.format(date_contr);//дата договора
        } catch (Exception ex) {
            data[3] = "";
        }
        data[4] = NumContractTextField.getText().trim();
        data[5] = "";//здесь будет заполняться адрес
        data[6] = OwnerTextField.getText().toUpperCase().trim();

        data[7] = (String) ConsTypeComboBox.getSelectedItem();
        if (Objects.equals(data[7], "НЕ ВЫБРАНО")) data[7] = "";

        data[8] = TelephoneTextField.getText().trim();
        data[9] = (String) StatusAccComboBox.getSelectedItem();
        if (Objects.equals(data[9], "НЕ ВЫБРАНО")) data[9] = "";

        //поля адреса,которые формируют data[5]
        data[10] = (String) DistrictComboBox.getSelectedItem();
        if (Objects.equals(data[10], "НЕ ВЫБРАНО")) data[10] = "";
        data[11] = AdressTextField.getText().toUpperCase().trim();
        data[12] = HouseTextField.getText().trim();
        data[13] = CorpusTextField.getText().toUpperCase().trim();
        data[14] = FlatTextField.getText().trim();
        data[15] = IndexTextField.getText().trim();

        //юр.лицо
        data[16] = BankTextField.getText().toUpperCase().trim();//банк
        data[17] = KPPTextField.getText().trim();
        data[18] = BIKTextField.getText().trim();
        data[19] = BankAccTextField.getText().trim();//расчетный счет
        data[20] = NumSertifTextField.getText().trim();
        data[21] = INNTextField.getText().trim();
        data[22] = NameCompanyTextField.getText().toUpperCase().trim();

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
            int result = Account.searchAccount(data);
            if (result == 0) {//если что-то найдено
                Account.account = null;//обнуление абонента
                ResultTable.requestFocus();
                ResultTable.setRowSelectionInterval(0, 0);
                clickOnTable();
            } else {
                deleteRows();//удаление строк из таблицы
                JOptionPane.showMessageDialog(null, "Не найдено!", "Результат поиска", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }


    //карточка водомера
    private void WatermeterButtonActionPerformed() throws SQLException {
        GWatermeter wm = new GWatermeter(this,true);
        wm.deleteRows();
        NUM_ACC =String.valueOf(ResultTable.getModel().getValueAt(ResultTable.getSelectedRow(), 0));
        int result=Watermeter.searchWatermeterForCard(NUM_ACC);
        GWatermeter.card=false;
        if(result==-1) {
            JOptionPane.showMessageDialog(null, "По лицевому счету с номером " + NUM_ACC + " не найдено водомеров!", "Результат поиска", JOptionPane.INFORMATION_MESSAGE);
        }
        else  wm.setVisible(true);

    }

    //карточка водомерного подключения
    private void WaterconButtonActionPerformed() throws SQLException {
        GWaterconnection wc = new GWaterconnection(true, this);
        wc.deleteRows();
        NUM_ACC =String.valueOf(ResultTable.getModel().getValueAt(ResultTable.getSelectedRow(), 0));
        int result=Waterconnection.searchWaterconnection(NUM_ACC);
        if(result==-1) {
            JOptionPane.showMessageDialog(null, "По лицевому счету с номером " + NUM_ACC + " не найдено водомерных подключений!", "Результат поиска", JOptionPane.INFORMATION_MESSAGE);
        }
        else  wc.setVisible(true);
    }

    private void ClearButtonActionPerformed() {
        cleanFields();
        deleteRows();//очистка таблицы
        SearchButton.setEnabled(true);
        setConditionFields(true,true);  //активные поля
    }

    private void OrdersMenuItemMouseClicked() {

    }

    //по клику на строке таблицы
    private void ResultTableMouseClicked(java.awt.event.MouseEvent evt) throws Exception {
        if(evt.getClickCount()==1&&!change_mode)clickOnTable();
    }

    private void clickOnTable() throws Exception {
        NUM_ACC =String.valueOf(ResultTable.getModel().getValueAt(ResultTable.getSelectedRow(), 0));
        cleanFields();
        WaterconButton.setEnabled(true);
        WatermeterButton.setEnabled(true);
        NewWatermeterMenuItem.setEnabled(true);
        NewWaterconMenuItem.setEnabled(true);
        newOrderMenuItem.setEnabled(true);
        ChangeAccMenuItem.setEnabled(true);
        NumAccTextField.requestFocus();
        //получение номера лицевого счета с выделенной строки
        String num_acc = String.valueOf(ResultTable.getModel().getValueAt(ResultTable.getSelectedRow(), 0));
        String cons_type = String.valueOf(ResultTable.getModel().getValueAt(ResultTable.getSelectedRow(), 3));

        if(cons_type.equals("ФИЗИЧЕСКОЕ ЛИЦО")) ContactsButton.setEnabled(false);
        else ContactsButton.setEnabled(true);

        Account.showAccount(num_acc, cons_type);//вызов метода заполнения формы по клику

        DistrictComboBox.setSelectedItem(Account.names_indexes[0]);
        NumAccTextField.setText(Integer.toString(Account.num_account));
        ConsTypeComboBox.setSelectedItem(Account.cons_type);
        BalanceTextField.setText(Methods.Zero(Double.toString(Account.balance)));
        String FIO[] = Account.FIO.split(" ");
        SurnameTextField.setText(FIO[0]);
        NameTextField.setText(FIO[1]);
        MiddleNameTextField.setText(FIO[2]);
        NumContractTextField.setText(Integer.toString(Account.num_contract));

        DateContractDatePicker.setDate(Account.date_contract);

        StatusAccComboBox.setSelectedItem(Account.acc_status);
        TelephoneTextField.setText(Account.telephone);
        AdressTextField.setText(Account.names_indexes[1]);
        HouseTextField.setText(Account.names_indexes[2]);

        if (Account.names_indexes[3] == null) FlatTextField.setText("");
        FlatTextField.setText(Account.names_indexes[3]);

        if (Account.names_indexes[4] == null) CorpusTextField.setText("");
        else CorpusTextField.setText(Account.names_indexes[4]);

        IndexTextField.setText(Account.names_indexes[5]);
        OwnerTextField.setText(Account.owner_flat);

        if (cons_type.equals("ЮРИДИЧЕСКОЕ ЛИЦО")) {//юр.лицо
            NameCompanyTextField.setText(Account.name_company);
            NumSertifTextField.setText(Long.toString(Account.num_cert));
            BankTextField.setText(Account.names_indexes[6]);
            BankAccTextField.setText(Long.toString(Account.pay_account));
            INNTextField.setText(Long.toString(Account.INN));
            KPPTextField.setText(Long.toString(Account.kpp));
            BIKTextField.setText(Long.toString(Account.bik));
        }
        setConditionFields(false,true);
        SearchButton.setEnabled(false);
        DeleteAccMenuItem.setEnabled(true);
        ResultTable.requestFocus();
    }



    private void CountAccButtonActionPerformed() {
        JOptionPane.showMessageDialog(null, "Найдено лицевых счетов: " + ResultTable.getRowCount(), "Количество лицевых счетов", JOptionPane.INFORMATION_MESSAGE);
    }

    //суммарный долг по счетам
    private void SummBalanceButtonActionPerformed() throws SQLException {
        double balance;
        String num_accs = "";
        for (int i = 0; i < ResultTable.getRowCount(); i++)
            num_accs += ResultTable.getValueAt(i, 0) + " ";
        if (num_accs.equals(""))
            JOptionPane.showMessageDialog(null, "Не найден ни один лицевой счет. Выполните поиск и повторите попытку!", "Ошибка", JOptionPane.ERROR_MESSAGE);
        else {
            balance = Methods.SumBalance(num_accs);
            JOptionPane.showMessageDialog(null, "Суммарный баланс по найденным лицевым счетам составляет " + String.format("%.2f ", balance) + " руб.", "Суммарный баланс", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void ContactsButtonActionPerformed() throws SQLException {
        GContacts contact = new GContacts(this);
        contact.deleteRows();
        int result=Contact.searchContact(NUM_ACC);
        if(result==-1) {
            contact.NameCompanyTextField.setText(Contact.getCompany(NUM_ACC));
            JOptionPane.showMessageDialog(null, "По лицевому счету с номером " + NUM_ACC + " не найдено контактных лиц!", "Результат поиска", JOptionPane.INFORMATION_MESSAGE);
        }
        contact.setVisible(true);
    }

    private void ChangeAccMenuItemActionPerformed() throws Exception {
        boolean company=false;//если изменяем юр.лицо
        if(String.valueOf(ResultTable.getModel().getValueAt(ResultTable.getSelectedRow(), 3)).equals("ЮРИДИЧЕСКОЕ ЛИЦО"))
            company=true;
        changeMode(true,company);
        old_data = readData();//считать все текущие данные
        NumAccTextField.setEditable(false);//нельзя изменять номер счета
        ConsTypeComboBox.setEnabled(false);//нельзя изменять тип лица
    }

    private void NewAccMenuItemActionPerformed() throws SQLException {
        Object[] options = {"Физическое лицо",
                "Юридическое лицо",
                "Отмена"};
        int result = JOptionPane.showOptionDialog(null,
                "Укажите тип нового абонента ",
                "Выбор типа абонента ",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[2]);
        switch (result) {
            case 0://физ.лицо
                GNewAccountPerson nap = new GNewAccountPerson(this);
                nap.setVisible(true);
                break;
            case 1://юр.лицо
                GNewAccountCompany nac = new GNewAccountCompany(this);
                nac.setVisible(true);
                break;
        }
    }

    private void NoticeDeptMenuItemActionPerformed() {
        // TODO add your handling code here:
    }

    private void PatternDeptMenuItemActionPerformed() {
    }

    private void ListDeptorsMenuItemActionPerformed() {
    }

    //шифрование дампа бд
    private void EncryptDataMenuItemActionPerformed() {
        GProtection p = new GProtection(true, this);//режим шифрования
        p.setVisible(true);
    }
    //удаление лицевого счета
    private void DeleteAccMenuItemActionPerformed() throws SQLException {
        String num_acc = String.valueOf(ResultTable.getModel().getValueAt(ResultTable.getSelectedRow(), 0)); //получение номера счета
        Object[] options = {"Да", "Нет"};
        int n = JOptionPane.showOptionDialog(null, "Удалить лицевой счет с номером "+num_acc+" ? Так же будут удалены все водоменые подключения,\n водомеры, заказы, контактные лица,связанные с лицевым счетом.",
                "Подтверждение удаления", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        if (n == 0) {
            Account.deleteAccount(num_acc);
            JOptionPane.showMessageDialog(null, "Лицевой счет с номером "+num_acc+" был удален!", "Удаление лицевого счета", JOptionPane.INFORMATION_MESSAGE);
            model.removeRow(ResultTable.getSelectedRow());//удаление строки из таблицы
            cleanFields();
            setConditionFields(true,true);
            SearchButton.setEnabled(true);
            DeleteAccMenuItem.setEnabled(false);
        }
    }

    //новый водомер
    private void NewWatermeterMenuItemActionPerformed() throws SQLException {
        NUM_ACC =String.valueOf(ResultTable.getModel().getValueAt(ResultTable.getSelectedRow(), 0));

        String [] codes =(Waterconnection.showWaterconnectionForWatermer(NUM_ACC)).split("_");//массив кодов ВП лицевого счета

        if(codes.length==1){//если нет ВП на лицевом счета (в массиве только значение "НЕ ВЫБРАНО")
            JOptionPane.showMessageDialog(null, "К лицевому счету, с номером "+NUM_ACC+", нельзя прикрепить водомер, так как \n " +
                    "лицевой счет не имеет водомерных подключений! Добавьте водомерное \n подключение, перед тем как добавить " +
                    "водомер.", "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
        else {
            GNewWatermeter nw = new GNewWatermeter(this);
            nw.CodeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(codes));
            nw.setVisible(true);
        }
    }

    //новое водомерное подключение
    private void NewWaterconMenuItemActionPerformed() throws SQLException {
        GNewWaterconnection wc = new GNewWaterconnection(this);
        wc.setVisible(true);
    }

    //журнал водомеров
    private void WatermeterMenuItemActionPerformed() {
        GWatermeter wm = new GWatermeter( this,false);
        wm.setVisible(true);

    }

    //журнал водомерных подключений
    private void WaterconMenuItemActionPerformed() throws SQLException {
        GWaterconnection wc = new GWaterconnection(false, this);
        wc.setVisible(true);
    }

    //журнал заказов
    private void OrdersMenuItemActionPerformed() {
        GJournalOrders jo = new GJournalOrders(this);
        jo.setVisible(true);
    }
    private void NewOrderMenuItemActionPerformed() throws SQLException {
        GNewOrder no = new GNewOrder(this);
        no.setVisible(true);
    }

    private void CloseOrderMenuItemActionPerformed() {
        GCloseOrder co = new GCloseOrder(this);
        co.setVisible(true);
    }

    //дешифрование дампа бд
    private void DecryptDataMenuItemActionPerformed() {
        GProtection p = new GProtection(false, this);//режим дешифрования
        p.setVisible(true);
    }

    private void ExitProgrammMenuMouseClicked() throws Exception {
        Object[] options = {"Да", "Нет"};
        int n = JOptionPane.showOptionDialog(null, "Выйти из программы?",
                "Подтверждение выхода", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        if (n == 0) {
            System.exit(0);
            close();
        }
    }

    /**
     * Производит необходимые действия при входе/выходе из режима редактирования
     * Принимает mode (true-вход/false-выход)
     * company: true- юр.лицо,false-физ.лицо
     */
    private void changeMode(boolean mode,boolean company) throws Exception {
        if(mode){//включить режим изменения
            change_mode = true;//флаг изменения
            SearchButton.setText("Изменить");
            ResultTable.setEnabled(false);
            setConditionFields(true,company);//активные поля
            SearchButton.setEnabled(true);
            DeleteAccMenuItem.setEnabled(false);
            ChangeAccMenuItem.setEnabled(false);
            changeStateButtonsForChangeMode(false);
        }
        else{//выход
            change_mode=false;
            SearchButton.setText("Поиск");
            ResultTable.setEnabled(true);
            ChangeAccMenuItem.setEnabled(false);
            DeleteAccMenuItem.setEnabled(false);
            setConditionFields(true,company);//активные поля
            deleteRows();
            cleanFields();
            ResultTable.requestFocus();
            changeStateButtonsForChangeMode(true);
        }
    }
    /**
     * Изменяет состояние кнопок и вкладок при входе/выходе из режима изменений
     */
    private void changeStateButtonsForChangeMode(boolean sost) {
        SummBalanceButton.setEnabled(sost);
        CountAccButton.setEnabled(sost);
        ClearButton.setEnabled(sost);
        WaterconButton.setEnabled(sost);
        WatermeterButton.setEnabled(sost);
        ContactsButton.setEnabled(sost);
        NewAccMenuItem.setEnabled(sost);
        NewWaterconMenuItem.setEnabled(sost);
        NewWatermeterMenuItem.setEnabled(sost);
        CatalogMenu.setEnabled(sost);
        OrderMenu.setEnabled(sost);
        DocumentsMenu.setEnabled(sost);
        DataProtectionMenu.setEnabled(sost);
        ExitProgrammMenu.setEnabled(sost);
    }

    //удаляет все строки из таблицы
    private void deleteRows() {
        model.setRowCount(0);
    }
    /*
     * Очищает поля в форме
     */
    private void cleanFields() {
        for (JTextField textfield : textfields) textfield.setText(null);
        for (JComboBox comboboxe : comboboxes) comboboxe.setSelectedIndex(0);
        DateContractDatePicker.setDate(null);
        setDefaultConditionButton();
    }
    /*
    Метод блокирует все кнопки,которые должны быть заблокированы при открытии программы
    */
    private void setDefaultConditionButton(){
        ContactsButton.setEnabled(false);
        WatermeterButton.setEnabled(false);
        WaterconButton.setEnabled(false);
        NewWatermeterMenuItem.setEnabled(false);
        NewWaterconMenuItem.setEnabled(false);
        newOrderMenuItem.setEnabled(false);
        ChangeAccMenuItem.setEnabled(false);
        DeleteAccMenuItem.setEnabled(false);
    }
    /* Принимает company : true - юр.лицо,false- физ.лицо
     * Принимает sost: true или false
     * Делает активными/неактивными поля соответственно
     */
    private void setConditionFields(boolean sost, boolean company) {
        //для всех лиц
        for(int i=0;i<13;i++) textfields[i].setEnabled(sost);
        DateContractDatePicker.setEditable(sost);
        for (JComboBox comboboxe : comboboxes) comboboxe.setEnabled(sost);

        if(company)
            for(int i=13;i<textfields.length;i++) textfields[i].setEnabled(sost);//для юр.лиц

        NumAccTextField.requestFocus();

    }
}
