package GUI;
import WORK.Access;
import WORK.Account;
import WORK.Connect;
import com.mxrck.autocompleter.TextAutoCompleter;

import javax.swing.*;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/*
 * Created by Юлия on 14.04.2017.
 */
public class GNewAccountCompany extends javax.swing.JDialog {
    private JTextField textfields [];//массив текстовых полей
    private javax.swing.JTextField AdressTextField;
    private javax.swing.JTextField BalanceTextField;
    private javax.swing.JTextField BankAccTextField;
    private javax.swing.JTextField BankTextField;
    private javax.swing.JTextField ConsTypeTextField;
    private javax.swing.JTextField CorpusTextField;
    private org.jdesktop.swingx.JXDatePicker DateContractDatePicker;
    private javax.swing.JComboBox<String> DistrictComboBox;
    private javax.swing.JTextField FlatTextField;
    private javax.swing.JTextField HouseTextField;
    private javax.swing.JTextField INNTextField;
    private javax.swing.JTextField IndexTextField;
    private javax.swing.JTextField KPPTextField;
    private javax.swing.JTextField MiddleNameTextField;
    private javax.swing.JTextField NameCompanyTextField;
    private javax.swing.JTextField NameTextField;
    private javax.swing.JTextField NumAccTextField;
    private javax.swing.JTextField NumContractTextField;
    private javax.swing.JTextField NumSertifTextField;
    private javax.swing.JTextField OwnerTextField;
    private javax.swing.JTextField StatusAccTextField;
    private javax.swing.JTextField SurnameTextField;
    private javax.swing.JTextField TelephoneTextField;

    GNewAccountCompany(java.awt.Frame parent) throws SQLException {
        super(parent, true);
        initComponents();
        textfields = new JTextField[]{//массив текстовых полей
                NumAccTextField, SurnameTextField, NameTextField, MiddleNameTextField,
                BalanceTextField, NumContractTextField, AdressTextField, HouseTextField,
                CorpusTextField, FlatTextField, IndexTextField, TelephoneTextField,
                OwnerTextField,StatusAccTextField,ConsTypeTextField,BankTextField,KPPTextField,
                //BIKTextField,
                BankAccTextField,NumSertifTextField,INNTextField,NameCompanyTextField



        };
        NumAccTextField.setText(Integer.toString(Account.getLastNumAccount()+1));//получение номера аккаунта
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
            java.util.logging.Logger.getLogger(GNewAccountPerson.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new GNewAccountPerson(null).setVisible(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }

    @SuppressWarnings("unchecked")
    private void initComponents() throws SQLException {
        JLabel districtLabel = new JLabel();
        MiddleNameTextField = new javax.swing.JTextField();
        NameTextField = new javax.swing.JTextField();
        JLabel FIOLabel = new JLabel();
        SurnameTextField = new javax.swing.JTextField();
        JLabel numAccLabel = new JLabel();
        NumAccTextField = new javax.swing.JTextField();
        JLabel dateContractLabel = new JLabel();
        JLabel adressLabel = new JLabel();
        AdressTextField = new javax.swing.JTextField();
        JLabel houseLabel = new JLabel();
        HouseTextField = new javax.swing.JTextField();
        JLabel corpusLabel = new JLabel();
        CorpusTextField = new javax.swing.JTextField();
        JLabel flatLabel = new JLabel();
        FlatTextField = new javax.swing.JTextField();
        JLabel ownerLabel = new JLabel();
        OwnerTextField = new javax.swing.JTextField();
        JLabel consTypeLabel = new JLabel();
        JLabel indexLabel = new JLabel();
        JLabel telephoneLabel = new JLabel();
        ConsTypeTextField = new javax.swing.JTextField();
        TelephoneTextField = new javax.swing.JTextField();
        IndexTextField = new javax.swing.JTextField();
        JButton okButton = new JButton();
        JButton cancelButton = new JButton();
        DateContractDatePicker = new org.jdesktop.swingx.JXDatePicker();
        DateContractDatePicker.setFormats("yyyy-MM-dd");
        DateContractDatePicker.setDate(null);
        DateContractDatePicker.setLinkDate(System.currentTimeMillis(), "Сегодня {0}");
        JButton clearButton = new JButton();
        BalanceTextField = new javax.swing.JTextField();
        JLabel balanceLabel = new JLabel();
        NumContractTextField = new javax.swing.JTextField();
        JLabel numContractLabel = new JLabel();
        StatusAccTextField = new javax.swing.JTextField();
        JLabel statusAccLabel = new JLabel();
        INNTextField = new javax.swing.JTextField();
        JSeparator jSeparator2 = new JSeparator();
        NameCompanyTextField = new javax.swing.JTextField();
        JLabel nameCompanyLabel = new JLabel();
        BankTextField = new javax.swing.JTextField();
        JLabel bankLabel = new JLabel();
        //JLabel BIKLabel = new JLabel();
        JLabel KPPLabel = new JLabel();
       // BIKTextField = new javax.swing.JTextField();
        KPPTextField = new javax.swing.JTextField();
        JLabel bankAccLabel = new JLabel();
        JLabel numSertifLabel = new JLabel();
        JLabel INNLabel = new JLabel();
        BankAccTextField = new javax.swing.JTextField();
        NumSertifTextField = new javax.swing.JTextField();
        DistrictComboBox = new javax.swing.JComboBox<>();

        //AUTOCOMPLETERS

        TextAutoCompleter streetcomplete = new TextAutoCompleter(AdressTextField);
        Connect.retrieveStreet();
        while (Connect.rs.next()) {
            streetcomplete.addItem(Connect.rs.getString("street"));
        }
        TextAutoCompleter indexcomplete = new TextAutoCompleter(IndexTextField);
        Connect.retrieveIndex();
        while (Connect.rs.next()) {
            indexcomplete.addItem(Connect.rs.getString("indx"));
        }
        TextAutoCompleter bankcomplete = new TextAutoCompleter(BankTextField);
        Connect.retrieveBank();
        while (Connect.rs.next()) {
            bankcomplete.addItem(Connect.rs.getString("bank"));
        }

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Новый лицевой счет типа \"юр.лицо\" ("+ Access.name_operator+")");
        ImageIcon icon = new ImageIcon("src\\main\\resources\\main_icon\\main_icon.png");
        setIconImage(icon.getImage());
        setBounds(new java.awt.Rectangle(300, 150, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        districtLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        districtLabel.setText("Район");

        MiddleNameTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N


        NameTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N


        FIOLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        FIOLabel.setText("Фамилия, имя, отчество");

        SurnameTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N


        numAccLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        numAccLabel.setText("№ лицевого счета");

        NumAccTextField.setEditable(false);
        NumAccTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N


        dateContractLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        dateContractLabel.setText("Дата договора");

        adressLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        adressLabel.setText("Адрес");

        AdressTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N


        houseLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        houseLabel.setText("Дом");

        HouseTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N


        corpusLabel.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        corpusLabel.setText("Корпус");

        CorpusTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N


        flatLabel.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        flatLabel.setText("Квартира");

        FlatTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N


        ownerLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ownerLabel.setText("Владелец");

        OwnerTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N


        consTypeLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        consTypeLabel.setText("Категория потребителей");

        indexLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        indexLabel.setText(" Индекс");

        telephoneLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        telephoneLabel.setText("Телефон");

        ConsTypeTextField.setEditable(false);
        ConsTypeTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ConsTypeTextField.setText("ЮРИДИЧЕСКОЕ ЛИЦО");


        TelephoneTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N


        IndexTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N


        okButton.setText("ОК");
        okButton.addActionListener(evt -> {
            try {
                AddAccCompanyButtonActionPerformed();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        cancelButton.setText("Отмена");
        cancelButton.addActionListener((e) -> CancelButtonActionPerformed());



        clearButton.setText("Очистить форму");
        clearButton.addActionListener(this::ClearButtonActionPerformed);

        BalanceTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N


        balanceLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        balanceLabel.setText("Баланс");

        NumContractTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N


        numContractLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        numContractLabel.setText("Номер договора");

        StatusAccTextField.setEditable(false);
        StatusAccTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        StatusAccTextField.setText("ОТКРЫТ");


        statusAccLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        statusAccLabel.setText("Статус лицевого счета");


        nameCompanyLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        nameCompanyLabel.setText("Название предприятия");

        BankTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N


        bankLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bankLabel.setText("Банк плательщика");

        //BIKLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        //BIKLabel.setText("БИК");

        KPPLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        KPPLabel.setText("КПП");

        //BIKTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N


        KPPTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N


        bankAccLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bankAccLabel.setText("Расчетный счет");

        numSertifLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        numSertifLabel.setText("№ свидетельства");

        INNLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        INNLabel.setText("ИНН");




        DistrictComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "НЕ ВЫБРАНО", "ГАГАРИНСКИЙ", "ЛЕНИНСКИЙ", "НАХИМОВСКИЙ", "БАЛАКЛАВСКИЙ" }));

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
                                                                .addGap(103, 103, 103)
                                                                .addComponent(districtLabel))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(138, 138, 138)
                                                                .addComponent(ownerLabel))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(172, 172, 172)
                                                                .addComponent(consTypeLabel))
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                        .addGap(97, 97, 97)
                                                                        .addComponent(adressLabel)
                                                                        .addGap(154, 154, 154)
                                                                        .addComponent(houseLabel)
                                                                        .addGap(44, 44, 44)
                                                                        .addComponent(corpusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(flatLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                        .addComponent(NameCompanyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(NumSertifTextField))
                                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                        .addComponent(SurnameTextField)
                                                                                        .addComponent(NameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                        .addGap(46, 46, 46)
                                                                                        .addComponent(FIOLabel))
                                                                                .addComponent(DistrictComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                        .addGap(10, 10, 10)
                                                                                                        .addComponent(numContractLabel)
                                                                                                        .addGap(18, 18, 18)
                                                                                                        .addComponent(dateContractLabel))
                                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(NumAccTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(NumContractTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(numAccLabel))
                                                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                                                        .addComponent(DateContractDatePicker, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                                                        .addComponent(BalanceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                                                                        .addComponent(balanceLabel)
                                                                                                                        .addGap(33, 33, 33))))))
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                        .addGap(35, 35, 35)
                                                                                        .addComponent(telephoneLabel)
                                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                        .addComponent(indexLabel)
                                                                                        .addGap(33, 33, 33))))
                                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                                .addComponent(AdressTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(MiddleNameTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                        .addComponent(TelephoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                        .addComponent(IndexTextField))
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                        .addComponent(HouseTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                        .addGap(10, 10, 10)
                                                                                                        .addComponent(statusAccLabel)
                                                                                                        .addGap(0, 0, Short.MAX_VALUE))
                                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                        .addComponent(CorpusTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                        .addComponent(FlatTextField))))))
                                                                .addComponent(ConsTypeTextField)
                                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                        .addComponent(OwnerTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(StatusAccTextField))
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addGap(61, 61, 61)
                                                                        .addComponent(nameCompanyLabel)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(numSertifLabel)
                                                                        .addGap(64, 64, 64))
                                                                .addComponent(jSeparator2)
                                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                        .addGap(69, 69, 69)
                                                                        .addComponent(bankLabel)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(bankAccLabel)
                                                                        .addGap(67, 67, 67))
                                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                        .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                                .addComponent(INNTextField)
                                                                                .addComponent(BankTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE))
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(BankAccTextField)
                                                                                .addComponent(KPPTextField)))))
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(109, 109, 109)
                                                .addComponent(INNLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(KPPLabel)
                                                .addGap(115, 115, 115))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(districtLabel)
                                        .addComponent(numAccLabel)
                                        .addComponent(balanceLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(NumAccTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(BalanceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(DistrictComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(FIOLabel)
                                        .addComponent(numContractLabel)
                                        .addComponent(dateContractLabel))
                                .addGap(3, 3, 3)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(SurnameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(NumContractTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(DateContractDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(NameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(telephoneLabel)
                                        .addComponent(indexLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(MiddleNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(TelephoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(IndexTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(adressLabel)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(houseLabel)
                                                .addComponent(corpusLabel)
                                                .addComponent(flatLabel)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(AdressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(HouseTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(CorpusTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(FlatTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(ownerLabel)
                                        .addComponent(statusAccLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(OwnerTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(StatusAccTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(7, 7, 7)
                                .addComponent(consTypeLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ConsTypeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(numSertifLabel)
                                        .addComponent(nameCompanyLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(NameCompanyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(NumSertifTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(bankLabel)
                                        .addComponent(bankAccLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(BankTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(BankAccTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(30, 30, 30))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(KPPLabel)
                                                        .addComponent(INNLabel))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(INNTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(KPPTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cancelButton)
                                        .addComponent(okButton)
                                        .addComponent(clearButton))
                                .addContainerGap())
        );
        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>

    private void CancelButtonActionPerformed() {
        dispose();
    }

    private void AddAccCompanyButtonActionPerformed() throws Exception {
        String data[] = readData();
        switch(Account.addAccount(data,false)){
            case 0:
                JOptionPane.showMessageDialog(null,"Новый лицевой счет был успешно создан!", "Результат добавления", JOptionPane.INFORMATION_MESSAGE);
                dispose();
                break;
            case -1:
                JOptionPane.showMessageDialog(null,Account.error, "Ошибка", JOptionPane.ERROR_MESSAGE);
                break;
        }
    }
    /*
     Метод считывает данные из всех полей и возвращает их в виде массива
     */
    private String[] readData() {
        String data[] = new String[23];
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date_contract;
        try{
            date_contract = dateFormat.format(DateContractDatePicker.getDate());// дата договора
        }catch (NullPointerException ex){
            date_contract= null;
        }
        for(int i=0;i<15;i++)//считывание данных из текстовых полей(первая часть)
            data[i]=textfields[i].getText();
        data[15]=(String)DistrictComboBox.getSelectedItem();
        data[16]=date_contract;
        for(int i=15;i<textfields.length;i++)//считывание данных из текстовых полей(вторая часть)
            data[i+2]=textfields[i].getText();

        for(int i=0;i<data.length;i++)
            if(data[i]!=null) data[i]=data[i].toUpperCase();
        return  data;
    }

    private void ClearButtonActionPerformed(java.awt.event.ActionEvent evt) {
        for(int i=0;i<textfields.length;i++)
            if(i!=0&&i!=13&&i!=14) textfields[i].setText(null);
        DistrictComboBox.setSelectedIndex(0);
        DateContractDatePicker.setDate(null);
    }


}
