package GUI;
import javax.swing.*;
/*
 * Created by Юлия on 13.04.2017.
 */
public class GAccount extends javax.swing.JFrame {
    private javax.swing.JLabel AdressLabel;
    private javax.swing.JTextField AdressTextField;
    private javax.swing.JLabel BIKLabel;
    private javax.swing.JTextField BIKTextField;
    private javax.swing.JLabel BalanceLabel;
    private javax.swing.JTextField BalanceTextField;
    private javax.swing.JLabel BankAccLabel;
    private javax.swing.JTextField BankAccTextField;
    private javax.swing.JLabel BankLabel;
    private javax.swing.JTextField BankTextField;
    private javax.swing.JMenu CatalogMenu;
    private javax.swing.JMenuItem ChangeAccMenuItem;
    private javax.swing.JMenu ChangesMenu;
    private javax.swing.JButton ClearButton;
    private javax.swing.JMenuItem CloseOrderMenuItem;
    private javax.swing.JComboBox<String> ConsTypeComboBox;
    private javax.swing.JLabel ConsTypeLabel;
    private javax.swing.JButton ContactsButton;
    private javax.swing.JLabel CorpusLabel;
    private javax.swing.JTextField CorpusTextField;
    private javax.swing.JButton CountAccButton;
    private javax.swing.JMenu DataProtectionMenu;
    private org.jdesktop.swingx.JXDatePicker DateContractDatePicker;
    private javax.swing.JLabel DateContractLabel;
    private javax.swing.JMenuItem DecryptDataMenuItem;
    private javax.swing.JMenuItem DeleteAccMenuItem;
    private javax.swing.JComboBox<String> DistrictComboBox;
    private javax.swing.JLabel DistrictLabel;
    private javax.swing.JMenu DocumentsMenu;
    private javax.swing.JMenuItem EncryptDataMenuItem;
    private javax.swing.JMenu ExitProgrammMenu;
    private javax.swing.JLabel FIOLabel;
    private javax.swing.JLabel FlatLabel;
    private javax.swing.JTextField FlatTextField;
    private javax.swing.JMenuItem HistoryMenuItem;
    private javax.swing.JLabel HouseLabel;
    private javax.swing.JTextField HouseTextField;
    private javax.swing.JLabel INNLabel;
    private javax.swing.JTextField INNTextField;
    private javax.swing.JLabel IndexLabel;
    private javax.swing.JTextField IndexTextField;
    private javax.swing.JLabel KPPLabel;
    private javax.swing.JTextField KPPTextField;
    private javax.swing.JMenuItem ListDeptorsMenuItem;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JPopupMenu.Separator MenuSeparator;
    private javax.swing.JPopupMenu.Separator MenuSeparator1;
    private javax.swing.JTextField MiddleNameTextField;
    private javax.swing.JLabel NameCompanyLabel;
    private javax.swing.JTextField NameCompanyTextField;
    private javax.swing.JTextField NameTextField;
    private javax.swing.JMenuItem NewAccMenuItem;
    private javax.swing.JMenuItem NewOrderMenuItem;
    private javax.swing.JMenuItem NewWaterconMenuItem;
    private javax.swing.JMenuItem NewWatermeterMenuItem;
    private javax.swing.JMenuItem NoticeDeptMenuItem;
    private javax.swing.JLabel NumAccLabel;
    private javax.swing.JTextField NumAccTextField;
    private javax.swing.JLabel NumContractLabel;
    private javax.swing.JTextField NumContractTextField;
    private javax.swing.JLabel NumSertifLabel;
    private javax.swing.JTextField NumSertifTextField;
    private javax.swing.JMenu OrderMenu;
    private javax.swing.JMenuItem OrdersMenuItem;
    private javax.swing.JLabel OwnerLabel;
    private javax.swing.JTextField OwnerTextField;
    private javax.swing.JMenuItem PatternDeptMenuItem;
    private javax.swing.JTable ResultTable;
    private javax.swing.JButton SearchButton;
    private javax.swing.JSeparator Separator;
    private javax.swing.JLabel StatusAccLabel;
    private javax.swing.JComboBox<String> StatusComboBox;
    private javax.swing.JButton SummDebtButton;
    private javax.swing.JTextField SurnameTextField;
    private javax.swing.JLabel TelephoneLabel;
    private javax.swing.JTextField TelephoneTextField;
    private javax.swing.JButton WaterconButton;
    private javax.swing.JMenuItem WaterconMenuItem;
    private javax.swing.JButton WatermeterButton;
    private javax.swing.JMenuItem WatermeterMenuItem;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    public GAccount() {
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
            java.util.logging.Logger.getLogger(GAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GAccount().setVisible(true);
            }
        });
    }

    private void initComponents() {
        DistrictLabel = new javax.swing.JLabel();
        FIOLabel = new javax.swing.JLabel();
        SurnameTextField = new javax.swing.JTextField();
        NumAccLabel = new javax.swing.JLabel();
        NumAccTextField = new javax.swing.JTextField();
        BalanceLabel = new javax.swing.JLabel();
        BalanceTextField = new javax.swing.JTextField();
        MiddleNameTextField = new javax.swing.JTextField();
        NameTextField = new javax.swing.JTextField();
        NumContractTextField = new javax.swing.JTextField();
        DateContractLabel = new javax.swing.JLabel();
        NumContractLabel = new javax.swing.JLabel();
        AdressLabel = new javax.swing.JLabel();
        AdressTextField = new javax.swing.JTextField();
        HouseLabel = new javax.swing.JLabel();
        HouseTextField = new javax.swing.JTextField();
        CorpusLabel = new javax.swing.JLabel();
        CorpusTextField = new javax.swing.JTextField();
        FlatTextField = new javax.swing.JTextField();
        OwnerLabel = new javax.swing.JLabel();
        OwnerTextField = new javax.swing.JTextField();
        ConsTypeLabel = new javax.swing.JLabel();
        IndexLabel = new javax.swing.JLabel();
        TelephoneLabel = new javax.swing.JLabel();
        IndexTextField = new javax.swing.JTextField();
        TelephoneTextField = new javax.swing.JTextField();
        StatusAccLabel = new javax.swing.JLabel();
        BankTextField = new javax.swing.JTextField();
        BankLabel = new javax.swing.JLabel();
        BIKLabel = new javax.swing.JLabel();
        KPPLabel = new javax.swing.JLabel();
        BIKTextField = new javax.swing.JTextField();
        KPPTextField = new javax.swing.JTextField();
        BankAccLabel = new javax.swing.JLabel();
        NumSertifLabel = new javax.swing.JLabel();
        INNLabel = new javax.swing.JLabel();
        BankAccTextField = new javax.swing.JTextField();
        NumSertifTextField = new javax.swing.JTextField();
        INNTextField = new javax.swing.JTextField();
        SearchButton = new javax.swing.JButton();
        DateContractDatePicker = new org.jdesktop.swingx.JXDatePicker();
        DateContractDatePicker.setFormats("yyyy-MM-dd");
        DateContractDatePicker.setDate(null);
        DateContractDatePicker.setLinkDate(System.currentTimeMillis(), "Сегодня {0}");
        WatermeterButton = new javax.swing.JButton();
        Separator = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        ResultTable = new javax.swing.JTable();
        WaterconButton = new javax.swing.JButton();
        ClearButton = new javax.swing.JButton();
        CountAccButton = new javax.swing.JButton();
        SummDebtButton = new javax.swing.JButton();
        ContactsButton = new javax.swing.JButton();
        FlatLabel = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        NameCompanyTextField = new javax.swing.JTextField();
        NameCompanyLabel = new javax.swing.JLabel();
        DistrictComboBox = new javax.swing.JComboBox<>();
        ConsTypeComboBox = new javax.swing.JComboBox<>();
        StatusComboBox = new javax.swing.JComboBox<>();
        MenuBar = new javax.swing.JMenuBar();
        ChangesMenu = new javax.swing.JMenu();
        NewAccMenuItem = new javax.swing.JMenuItem();
        ChangeAccMenuItem = new javax.swing.JMenuItem();
        DeleteAccMenuItem = new javax.swing.JMenuItem();
        MenuSeparator1 = new javax.swing.JPopupMenu.Separator();
        NewWatermeterMenuItem = new javax.swing.JMenuItem();
        NewWaterconMenuItem = new javax.swing.JMenuItem();
        MenuSeparator = new javax.swing.JPopupMenu.Separator();
        CatalogMenu = new javax.swing.JMenu();
        WatermeterMenuItem = new javax.swing.JMenuItem();
        WaterconMenuItem = new javax.swing.JMenuItem();
        OrdersMenuItem = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        HistoryMenuItem = new javax.swing.JMenuItem();
        OrderMenu = new javax.swing.JMenu();
        NewOrderMenuItem = new javax.swing.JMenuItem();
        CloseOrderMenuItem = new javax.swing.JMenuItem();
        DocumentsMenu = new javax.swing.JMenu();
        NoticeDeptMenuItem = new javax.swing.JMenuItem();
        PatternDeptMenuItem = new javax.swing.JMenuItem();
        ListDeptorsMenuItem = new javax.swing.JMenuItem();
        DataProtectionMenu = new javax.swing.JMenu();
        EncryptDataMenuItem = new javax.swing.JMenuItem();
        DecryptDataMenuItem = new javax.swing.JMenuItem();
        ExitProgrammMenu = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Лицевой счет");
        ImageIcon icon = new ImageIcon("src\\main\\resources\\main_icon\\main_icon.png");
        setIconImage(icon.getImage());
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        DistrictLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        DistrictLabel.setText("Район");

        FIOLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        FIOLabel.setText("Фамилия, имя, отчество");

        SurnameTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        SurnameTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                SurnameTextFieldKeyPressed(evt);
            }
        });

        NumAccLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        NumAccLabel.setText("№ лицевого счета");

        NumAccTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        NumAccTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                NumAccTextFieldKeyPressed(evt);
            }
        });

        BalanceLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        BalanceLabel.setText("Баланс");

        BalanceTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        BalanceTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BalanceTextFieldKeyPressed(evt);
            }
        });

        MiddleNameTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        MiddleNameTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                MiddleNameTextFieldKeyPressed(evt);
            }
        });

        NameTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        NameTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                NameTextFieldKeyPressed(evt);
            }
        });

        NumContractTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        NumContractTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                NumContractTextFieldKeyPressed(evt);
            }
        });

        DateContractLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        DateContractLabel.setText("Дата договора");

        NumContractLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        NumContractLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NumContractLabel.setText("№ договора");

        AdressLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        AdressLabel.setText("Адрес");

        AdressTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        AdressTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                AdressTextFieldKeyPressed(evt);
            }
        });

        HouseLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        HouseLabel.setText("Дом");

        HouseTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        HouseTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                HouseTextFieldKeyPressed(evt);
            }
        });

        CorpusLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        CorpusLabel.setText("Корпус");

        CorpusTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        CorpusTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CorpusTextFieldKeyPressed(evt);
            }
        });

        FlatTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        FlatTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                FlatTextFieldKeyPressed(evt);
            }
        });

        OwnerLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        OwnerLabel.setText("Владелец");

        OwnerTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        OwnerTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                OwnerTextFieldKeyPressed(evt);
            }
        });

        ConsTypeLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ConsTypeLabel.setText("Категория потребителей");

        IndexLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        IndexLabel.setText("Индекс");

        TelephoneLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        TelephoneLabel.setText("Телефон");

        IndexTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        IndexTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                IndexTextFieldKeyPressed(evt);
            }
        });

        TelephoneTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        TelephoneTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TelephoneTextFieldKeyPressed(evt);
            }
        });

        StatusAccLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        StatusAccLabel.setText("Статус cчета");

        BankTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        BankTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BankTextFieldKeyPressed(evt);
            }
        });

        BankLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        BankLabel.setText("Банк плательщика");

        BIKLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        BIKLabel.setText("БИК");

        KPPLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        KPPLabel.setText("КПП");

        BIKTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        BIKTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BIKTextFieldKeyPressed(evt);
            }
        });

        KPPTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        KPPTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                KPPTextFieldKeyPressed(evt);
            }
        });

        BankAccLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        BankAccLabel.setText("Расчетный счет");

        NumSertifLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        NumSertifLabel.setText("№ свидетельства");

        INNLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        INNLabel.setText("ИНН");

        BankAccTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        BankAccTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BankAccTextFieldKeyPressed(evt);
            }
        });

        NumSertifTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        NumSertifTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                NumSertifTextFieldKeyPressed(evt);
            }
        });

        INNTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        INNTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                INNTextFieldKeyPressed(evt);
            }
        });

        SearchButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        SearchButton.setText("Поиск");
        SearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchButtonActionPerformed(evt);
            }
        });

        DateContractDatePicker.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DateContractDatePickerMouseClicked(evt);
            }
        });
        DateContractDatePicker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DateContractDatePickerActionPerformed(evt);
            }
        });

        WatermeterButton.setIcon(new javax.swing.ImageIcon("src\\main\\resources\\buttons\\Vodomer_icon.jpg")); // NOI18N // NOI18N
        WatermeterButton.setRequestFocusEnabled(false);
        WatermeterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WatermeterButtonActionPerformed(evt);
            }
        });

        Separator.setOrientation(javax.swing.SwingConstants.VERTICAL);

        ResultTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "№ л/счета", "Баланс", "Фамилия", "Имя", "Отчество"
                }
        ) {
            boolean[] canEdit = new boolean [] {
                    false, false, false, false, false
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
        jScrollPane1.setViewportView(ResultTable);

        WaterconButton.setIcon(new javax.swing.ImageIcon("src\\main\\resources\\buttons\\vodomerniy_uzel.jpg")); // NOI18N
        WaterconButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WaterconButtonActionPerformed(evt);
            }
        });

        ClearButton.setIcon(new javax.swing.ImageIcon("src\\main\\resources\\buttons\\ikonka-korziny.jpg")); // NOI18N
        ClearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearButtonActionPerformed(evt);
            }
        });

        CountAccButton.setIcon(new javax.swing.ImageIcon("src\\main\\resources\\buttons\\n_icon.jpg")); // NOI18N
        CountAccButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CountAccButtonActionPerformed(evt);
            }
        });

        SummDebtButton.setIcon(new javax.swing.ImageIcon("src\\main\\resources\\buttons\\summa_icon.jpg")); // NOI18N
        SummDebtButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SummDebtButtonActionPerformed(evt);
            }
        });

        ContactsButton.setIcon(new javax.swing.ImageIcon("src\\main\\resources\\buttons\\contacts_icon.jpg")); // NOI18N
        ContactsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContactsButtonActionPerformed(evt);
            }
        });

        FlatLabel.setText("КВ");

        NameCompanyTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        NameCompanyLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        NameCompanyLabel.setText("Название предприятия");

        DistrictComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "НЕ ВЫБРАНО", "ГАГАРИНСКИЙ", "ЛЕНИНСКИЙ", "НАХИМОВСКИЙ", "БАЛАКЛАВСКИЙ" }));
        DistrictComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DistrictComboBoxActionPerformed(evt);
            }
        });

        ConsTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "НЕ ВЫБРАНО", "ФИЗИЧЕСКОЕ ЛИЦО", "ЮРИДИЧЕСКОЕ ЛИЦО" }));
        ConsTypeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsTypeComboBoxActionPerformed(evt);
            }
        });

        StatusComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "НЕ ВЫБРАНО", "ОТКРЫТ", "ЗАКРЫТ" }));
        StatusComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StatusComboBoxActionPerformed(evt);
            }
        });

        ChangesMenu.setText("Изменения");

        NewAccMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        NewAccMenuItem.setText("Новый лицевой счет");
        NewAccMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewAccMenuItemActionPerformed(evt);
            }
        });
        ChangesMenu.add(NewAccMenuItem);

        ChangeAccMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        ChangeAccMenuItem.setText("Изменение текущей записи");
        ChangeAccMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChangeAccMenuItemActionPerformed(evt);
            }
        });
        ChangesMenu.add(ChangeAccMenuItem);

        DeleteAccMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DELETE, java.awt.event.InputEvent.CTRL_MASK));
        DeleteAccMenuItem.setText("Удалить лицевой счет");
        DeleteAccMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteAccMenuItemActionPerformed(evt);
            }
        });
        ChangesMenu.add(DeleteAccMenuItem);
        ChangesMenu.add(MenuSeparator1);

        NewWatermeterMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        NewWatermeterMenuItem.setText("Новый водомер");
        NewWatermeterMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewWatermeterMenuItemActionPerformed(evt);
            }
        });
        ChangesMenu.add(NewWatermeterMenuItem);

        NewWaterconMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        NewWaterconMenuItem.setText("Новый водомерный узел");
        NewWaterconMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewWaterconMenuItemActionPerformed(evt);
            }
        });
        ChangesMenu.add(NewWaterconMenuItem);
        ChangesMenu.add(MenuSeparator);

        MenuBar.add(ChangesMenu);

        CatalogMenu.setText("Справочники");

        WatermeterMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        WatermeterMenuItem.setText("Водомеры");
        WatermeterMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WatermeterMenuItemActionPerformed(evt);
            }
        });
        CatalogMenu.add(WatermeterMenuItem);

        WaterconMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, 0));
        WaterconMenuItem.setText("Водомерные узлы");
        WaterconMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WaterconMenuItemActionPerformed(evt);
            }
        });
        CatalogMenu.add(WaterconMenuItem);

        OrdersMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        OrdersMenuItem.setText("Журнал заказов");
        OrdersMenuItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OrdersMenuItemMouseClicked(evt);
            }
        });
        OrdersMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrdersMenuItemActionPerformed(evt);
            }
        });
        CatalogMenu.add(OrdersMenuItem);
        CatalogMenu.add(jSeparator1);

        HistoryMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, 0));
        HistoryMenuItem.setText("История изменений");
        HistoryMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HistoryMenuItemActionPerformed(evt);
            }
        });
        CatalogMenu.add(HistoryMenuItem);

        MenuBar.add(CatalogMenu);

        OrderMenu.setText("Заказы");

        NewOrderMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F6, 0));
        NewOrderMenuItem.setText("Новый заказ");
        NewOrderMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewOrderMenuItemActionPerformed(evt);
            }
        });
        OrderMenu.add(NewOrderMenuItem);

        CloseOrderMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F7, 0));
        CloseOrderMenuItem.setText("Закрыть заказ");
        CloseOrderMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseOrderMenuItemActionPerformed(evt);
            }
        });
        OrderMenu.add(CloseOrderMenuItem);

        MenuBar.add(OrderMenu);

        DocumentsMenu.setText("Документы");

        NoticeDeptMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_1, java.awt.event.InputEvent.CTRL_MASK));
        NoticeDeptMenuItem.setText("Сформировать извещение о долге");
        NoticeDeptMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NoticeDeptMenuItemActionPerformed(evt);
            }
        });
        DocumentsMenu.add(NoticeDeptMenuItem);

        PatternDeptMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_2, java.awt.event.InputEvent.CTRL_MASK));
        PatternDeptMenuItem.setText("Шаблон извещения о долге");
        PatternDeptMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PatternDeptMenuItemActionPerformed(evt);
            }
        });
        DocumentsMenu.add(PatternDeptMenuItem);

        ListDeptorsMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_3, java.awt.event.InputEvent.CTRL_MASK));
        ListDeptorsMenuItem.setText("Список должников");
        ListDeptorsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListDeptorsMenuItemActionPerformed(evt);
            }
        });
        DocumentsMenu.add(ListDeptorsMenuItem);

        MenuBar.add(DocumentsMenu);

        DataProtectionMenu.setText("Защита данных");

        EncryptDataMenuItem.setText("Шифрование дампа базы данных");
        EncryptDataMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EncryptDataMenuItemActionPerformed(evt);
            }
        });
        DataProtectionMenu.add(EncryptDataMenuItem);

        DecryptDataMenuItem.setText("Дешифрование дампа базы данных");
        DecryptDataMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DecryptDataMenuItemActionPerformed(evt);
            }
        });
        DataProtectionMenu.add(DecryptDataMenuItem);

        MenuBar.add(DataProtectionMenu);

        ExitProgrammMenu.setText("Выход");
        ExitProgrammMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ExitProgrammMenuMouseClicked(evt);
            }
        });
        MenuBar.add(ExitProgrammMenu);

        setJMenuBar(MenuBar);

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
                                                        .addComponent(SummDebtButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Separator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                                                                                                                .addComponent(DistrictLabel)
                                                                                                                .addGap(43, 43, 43)))
                                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                                        .addComponent(NumAccLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                                        .addComponent(NumAccTextField)))
                                                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                                                .addGap(43, 43, 43)
                                                                                                .addComponent(FIOLabel)))
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                                                        .addGap(10, 10, 10)
                                                                                                        .addComponent(NumContractLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                        .addGap(43, 43, 43)
                                                                                                        .addComponent(DateContractLabel))
                                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                        .addComponent(ConsTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                        .addComponent(BalanceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                .addComponent(ConsTypeLabel)
                                                                                                .addGap(29, 29, 29)
                                                                                                .addComponent(BalanceLabel)))
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
                                                                                                                .addComponent(CorpusLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                                                                                                                        .addComponent(AdressLabel)))
                                                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                                        .addComponent(NumContractTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                        .addComponent(DateContractDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                                        .addGap(10, 10, 10)
                                                                                                                        .addComponent(StatusAccLabel)
                                                                                                                        .addGap(59, 59, 59)
                                                                                                                        .addComponent(TelephoneLabel))
                                                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                .addComponent(StatusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                .addComponent(HouseLabel))
                                                                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                .addComponent(TelephoneTextField)
                                                                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                                                        .addComponent(FlatLabel)
                                                                                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                                                                        .addComponent(IndexLabel)
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
                                                                .addComponent(NameCompanyLabel)
                                                                .addGap(118, 118, 118)
                                                                .addComponent(NumSertifLabel))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(63, 63, 63)
                                                                .addComponent(BankLabel)
                                                                .addGap(137, 137, 137)
                                                                .addComponent(BankAccLabel))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(85, 85, 85)
                                                                .addComponent(OwnerLabel))))
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
                                                .addComponent(SummDebtButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(CountAccButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(ClearButton))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(Separator, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                        .addGap(3, 3, 3)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(DistrictLabel)
                                                                .addComponent(NumAccLabel)
                                                                .addComponent(BalanceLabel)
                                                                .addComponent(ConsTypeLabel))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(NumAccTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(DistrictComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(ConsTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(BalanceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(NumContractLabel)
                                                                        .addComponent(DateContractLabel))
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
                                                                .addComponent(StatusAccLabel)
                                                                .addComponent(TelephoneLabel))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(MiddleNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(StatusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(TelephoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGap(10, 10, 10)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(CorpusLabel)
                                                                .addComponent(FlatLabel)
                                                                .addComponent(HouseLabel)
                                                                .addComponent(AdressLabel)
                                                                .addComponent(IndexLabel))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(AdressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(HouseTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(CorpusTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(FlatTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(IndexTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(OwnerLabel)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(OwnerTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(NameCompanyLabel)
                                                                .addComponent(NumSertifLabel))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(NameCompanyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(NumSertifTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(BankLabel)
                                                                .addComponent(BankAccLabel))
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

    private void SearchButtonActionPerformed(java.awt.event.ActionEvent evt) {
    }

    //карточка водомера
    private void WatermeterButtonActionPerformed(java.awt.event.ActionEvent evt) {
        GWatermeter wm = new GWatermeter(true,this);
    }

    private void formWindowClosing(java.awt.event.WindowEvent evt) {
        // TODO add your handling code here:
    }

    private void ResultTableMouseClicked(java.awt.event.MouseEvent evt) {

    }

    //карточка водомерного подключения
    private void WaterconButtonActionPerformed(java.awt.event.ActionEvent evt) {
        GWaterconnection wc = new GWaterconnection(true,this);
    }

    private void ClearButtonActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void OrdersMenuItemMouseClicked(java.awt.event.MouseEvent evt) {

    }

    private void SurnameTextFieldKeyPressed(java.awt.event.KeyEvent evt) {
        // TODO add your handling code here:
    }

    private void NameTextFieldKeyPressed(java.awt.event.KeyEvent evt) {
        // TODO add your handling code here:
    }

    private void MiddleNameTextFieldKeyPressed(java.awt.event.KeyEvent evt) {
        // TODO add your handling code here:
    }

    private void NumContractTextFieldKeyPressed(java.awt.event.KeyEvent evt) {
        // TODO add your handling code here:
    }

    private void AdressTextFieldKeyPressed(java.awt.event.KeyEvent evt) {
        // TODO add your handling code here:
    }

    private void HouseTextFieldKeyPressed(java.awt.event.KeyEvent evt) {
        // TODO add your handling code here:
    }

    private void CorpusTextFieldKeyPressed(java.awt.event.KeyEvent evt) {
        // TODO add your handling code here:
    }

    private void FlatTextFieldKeyPressed(java.awt.event.KeyEvent evt) {
        // TODO add your handling code here:
    }

    private void OwnerTextFieldKeyPressed(java.awt.event.KeyEvent evt) {
        // TODO add your handling code here:
    }

    private void IndexTextFieldKeyPressed(java.awt.event.KeyEvent evt) {
        // TODO add your handling code here:
    }

    private void TelephoneTextFieldKeyPressed(java.awt.event.KeyEvent evt) {
        // TODO add your handling code here:
    }

    private void BankTextFieldKeyPressed(java.awt.event.KeyEvent evt) {
        // TODO add your handling code here:
    }

    private void BIKTextFieldKeyPressed(java.awt.event.KeyEvent evt) {
        // TODO add your handling code here:
    }

    private void KPPTextFieldKeyPressed(java.awt.event.KeyEvent evt) {
        // TODO add your handling code here:
    }

    private void BankAccTextFieldKeyPressed(java.awt.event.KeyEvent evt) {
        // TODO add your handling code here:
    }

    private void NumSertifTextFieldKeyPressed(java.awt.event.KeyEvent evt) {
        // TODO add your handling code here:
    }

    private void INNTextFieldKeyPressed(java.awt.event.KeyEvent evt) {
        // TODO add your handling code here:
    }

    private void NumAccTextFieldKeyPressed(java.awt.event.KeyEvent evt) {
        // TODO add your handling code here:
    }

    private void BalanceTextFieldKeyPressed(java.awt.event.KeyEvent evt) {
        // TODO add your handling code here:
    }

    private void DateContractDatePickerActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void ResultTableKeyPressed(java.awt.event.KeyEvent evt) {
        // TODO add your handling code here:
    }

    private void CountAccButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void SummDebtButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void ContactsButtonActionPerformed(java.awt.event.ActionEvent evt) {
        GContacts c = new GContacts(this);
        c.setVisible(true);
    }

    private void DateContractDatePickerMouseClicked(java.awt.event.MouseEvent evt) {

    }

    private void ChangeAccMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void NewAccMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
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
        switch (result){
            case 0://физ.лицо
                GNewAccountPerson nap= new GNewAccountPerson(this);
                nap.setVisible(true);
                break;
            case 1://юр.лицо
                GNewAccountCompany nac= new GNewAccountCompany(this);
                nac.setVisible(true);
                break;
        }
    }

    private void NoticeDeptMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void PatternDeptMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void ListDeptorsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    //шифрование дампа бд
    private void EncryptDataMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        GProtection p = new GProtection(true,this);//режим шифрования
    }

    private void DeleteAccMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    //новый водомер
    private void NewWatermeterMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        GNewWatermeter nw = new GNewWatermeter(this);
        nw.setVisible(true);
    }

    //новое водомерное подключение
    private void NewWaterconMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        GNewWaterconnection wc = new GNewWaterconnection(this);
        wc.setVisible(true);
    }

    //журнал водомеров
    private void WatermeterMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        GWatermeter wm = new GWatermeter(false,this);
    }

    //журнал водомерных подключений
    private void WaterconMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        GWaterconnection wc = new GWaterconnection(false,this);
    }

    //журнал заказов
    private void OrdersMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        GJournalOrders jo = new GJournalOrders(this);
        jo.setVisible(true);
    }

    private void HistoryMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void NewOrderMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        GNewOrder no = new GNewOrder(this);
        no.setVisible(true);
    }

    private void CloseOrderMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        GCloseOrder co = new GCloseOrder(this);
        co.setVisible(true);
    }

    //дешифрование дампа бд
    private void DecryptDataMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        GProtection p = new GProtection(false,this);//режим дешифрования
    }

    private void ExitProgrammMenuMouseClicked(java.awt.event.MouseEvent evt) {
        Object[] options = { "Да", "Нет" };
        int n = JOptionPane.showOptionDialog(null, "Выйти из программы?",
                "Подтверждение выхода", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        if (n == 0) {
            System.exit(0);
        }
    }

    private void DistrictComboBoxActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void ConsTypeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void StatusComboBoxActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }
}
