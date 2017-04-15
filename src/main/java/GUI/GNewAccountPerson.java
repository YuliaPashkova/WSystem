package GUI;

/**
 * Created by Юлия on 14.04.2017.
 */
import javax.swing.*;
import java.awt.*;

public class GNewAccountPerson extends javax.swing.JDialog {
    // Variables declaration - do not modify
    private javax.swing.JLabel AdressLabel;
    private javax.swing.JTextField AdressTextField;
    private javax.swing.JLabel BalanceLabel;
    private javax.swing.JTextField BalanceTextField;
    private javax.swing.JButton CancelButton;
    private javax.swing.JButton ClearButton;
    private javax.swing.JLabel ConsTypeLabel;
    private javax.swing.JTextField ConsTypeTextField;
    private javax.swing.JLabel CorpusLabel;
    private javax.swing.JTextField CorpusTextField;
    private org.jdesktop.swingx.JXDatePicker DateContractDatePicker;
    private javax.swing.JLabel DateContractLabel;
    private javax.swing.JLabel DistrictLabel;
    private javax.swing.JTextField DistrictTextField;
    private javax.swing.JLabel FIOLabel;
    private javax.swing.JLabel FlatLabel;
    private javax.swing.JTextField FlatTextField;
    private javax.swing.JLabel HouseLabel;
    private javax.swing.JTextField HouseTextField;
    private javax.swing.JLabel IndexLabel;
    private javax.swing.JTextField IndexTextField;
    private javax.swing.JTextField MiddleNameTextField;
    private javax.swing.JTextField NameTextField;
    private javax.swing.JLabel NumAccLabel;
    private javax.swing.JTextField NumAccTextField;
    private javax.swing.JButton OkButton;
    private javax.swing.JLabel OwnerLabel;
    private javax.swing.JTextField OwnerTextField;
    private javax.swing.JLabel StatusAccLabel;
    private javax.swing.JTextField StatusAccTextField;
    private javax.swing.JTextField SurnameTextField;
    private javax.swing.JLabel TelephoneLabel;
    private javax.swing.JTextField TelephoneTextField;
    private javax.swing.JLabel NumContractLabel;
    private javax.swing.JTextField NumContractTextField;
    public GNewAccountPerson(java.awt.Frame parent) {
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
        } catch (ClassNotFoundException | javax.swing.UnsupportedLookAndFeelException | IllegalAccessException | InstantiationException ex) {
            java.util.logging.Logger.getLogger(GNewAccountPerson.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GNewAccountPerson(null).setVisible(true);
            }
        });
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        DistrictLabel = new javax.swing.JLabel();
        MiddleNameTextField = new javax.swing.JTextField();
        NameTextField = new javax.swing.JTextField();
        FIOLabel = new javax.swing.JLabel();
        SurnameTextField = new javax.swing.JTextField();
        NumAccLabel = new javax.swing.JLabel();
        NumAccTextField = new javax.swing.JTextField();
        DateContractLabel = new javax.swing.JLabel();
        AdressLabel = new javax.swing.JLabel();
        AdressTextField = new javax.swing.JTextField();
        HouseLabel = new javax.swing.JLabel();
        HouseTextField = new javax.swing.JTextField();
        CorpusLabel = new javax.swing.JLabel();
        CorpusTextField = new javax.swing.JTextField();
        FlatLabel = new javax.swing.JLabel();
        FlatTextField = new javax.swing.JTextField();
        OwnerLabel = new javax.swing.JLabel();
        OwnerTextField = new javax.swing.JTextField();
        ConsTypeLabel = new javax.swing.JLabel();
        IndexLabel = new javax.swing.JLabel();
        TelephoneLabel = new javax.swing.JLabel();
        ConsTypeTextField = new javax.swing.JTextField();
        TelephoneTextField = new javax.swing.JTextField();
        IndexTextField = new javax.swing.JTextField();
        OkButton = new javax.swing.JButton();
        CancelButton = new javax.swing.JButton();
        DateContractDatePicker = new org.jdesktop.swingx.JXDatePicker();
        DateContractDatePicker.setFormats(new String[] {"yyyy-MM-dd"});
        DateContractDatePicker.setDate(null);
        DateContractDatePicker.setLinkDate(System.currentTimeMillis(), "Сегодня {0}");
        ClearButton = new javax.swing.JButton();
        DistrictTextField = new javax.swing.JTextField();
        BalanceTextField = new javax.swing.JTextField();
        BalanceLabel = new javax.swing.JLabel();
        NumContractTextField = new javax.swing.JTextField();
        NumContractLabel = new javax.swing.JLabel();
        StatusAccTextField = new javax.swing.JTextField();
        StatusAccLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Новый лицевой счет (физ.лицо)");
        //setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("main_icon.png")));
        ImageIcon icon = new ImageIcon("src\\main\\resources\\main_icon\\main_icon.png");
        setIconImage(icon.getImage());
        setBounds(new java.awt.Rectangle(300, 150, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        DistrictLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        DistrictLabel.setText("Район");

        MiddleNameTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        MiddleNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MiddleNameTextFieldActionPerformed(evt);
            }
        });

        NameTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        NameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameTextFieldActionPerformed(evt);
            }
        });

        FIOLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        FIOLabel.setText("Фамилия, имя, отчество");

        SurnameTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        SurnameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SurnameTextFieldActionPerformed(evt);
            }
        });

        NumAccLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        NumAccLabel.setText("№ лицевого счета");

        NumAccTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        NumAccTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NumAccTextFieldActionPerformed(evt);
            }
        });

        DateContractLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        DateContractLabel.setText("Дата договора");

        AdressLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        AdressLabel.setText("Адрес");

        AdressTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        AdressTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdressTextFieldActionPerformed(evt);
            }
        });

        HouseLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        HouseLabel.setText("Дом");

        HouseTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        HouseTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HouseTextFieldActionPerformed(evt);
            }
        });

        CorpusLabel.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        CorpusLabel.setText("Корпус");

        CorpusTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        CorpusTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CorpusTextFieldActionPerformed(evt);
            }
        });

        FlatLabel.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        FlatLabel.setText("Квартира");

        FlatTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        FlatTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FlatTextFieldActionPerformed(evt);
            }
        });

        OwnerLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        OwnerLabel.setText("Владелец");

        OwnerTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        OwnerTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OwnerTextFieldActionPerformed(evt);
            }
        });

        ConsTypeLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ConsTypeLabel.setText("Категория потребителей");

        IndexLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        IndexLabel.setText(" Индекс");

        TelephoneLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        TelephoneLabel.setText("Телефон");

        ConsTypeTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ConsTypeTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsTypeTextFieldActionPerformed(evt);
            }
        });

        TelephoneTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        TelephoneTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TelephoneTextFieldActionPerformed(evt);
            }
        });

        IndexTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        IndexTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IndexTextFieldActionPerformed(evt);
            }
        });

        OkButton.setText("ОК");
        OkButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OkButtonActionPerformed(evt);
            }
        });

        CancelButton.setText("Отмена");
        CancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelButtonActionPerformed(evt);
            }
        });

        DateContractDatePicker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DateContractDatePickerActionPerformed(evt);
            }
        });

        ClearButton.setText("Очистить форму");
        ClearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearButtonActionPerformed(evt);
            }
        });

        DistrictTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        DistrictTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DistrictTextFieldActionPerformed(evt);
            }
        });

        BalanceTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        BalanceTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BalanceTextFieldActionPerformed(evt);
            }
        });

        BalanceLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        BalanceLabel.setText("Баланс");

        NumContractTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        NumContractTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NumContractTextFieldActionPerformed(evt);
            }
        });

        NumContractLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        NumContractLabel.setText("Номер договора");

        StatusAccTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        StatusAccTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StatusAccTextFieldActionPerformed(evt);
            }
        });

        StatusAccLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        StatusAccLabel.setText("Статус лицевого счета");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(123, 123, 123)
                                .addComponent(DistrictLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BalanceLabel)
                                .addGap(54, 54, 54))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(158, 158, 158)
                                .addComponent(OwnerLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(StatusAccLabel)
                                .addGap(32, 32, 32))
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addGap(117, 117, 117)
                                                .addComponent(AdressLabel)
                                                .addGap(154, 154, 154)
                                                .addComponent(HouseLabel)
                                                .addGap(44, 44, 44)
                                                .addComponent(CorpusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                                                .addComponent(FlatLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addGap(192, 192, 192)
                                                        .addComponent(ConsTypeLabel))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                .addGap(20, 20, 20)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                                .addComponent(DistrictTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                                                                                                .addComponent(SurnameTextField)
                                                                                                .addComponent(NameTextField))
                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                .addGap(46, 46, 46)
                                                                                                .addComponent(FIOLabel)))
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                                .addGap(10, 10, 10)
                                                                                                                .addComponent(NumContractLabel)
                                                                                                                .addGap(18, 18, 18)
                                                                                                                .addComponent(DateContractLabel))
                                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                        .addComponent(NumAccTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                        .addComponent(NumContractTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                        .addComponent(NumAccLabel))
                                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                                                        .addComponent(DateContractDatePicker, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                                                                                                                        .addComponent(BalanceTextField)))))
                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                .addGap(35, 35, 35)
                                                                                                .addComponent(TelephoneLabel)
                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                                .addComponent(IndexLabel)
                                                                                                .addGap(33, 33, 33))))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                                        .addComponent(AdressTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(MiddleNameTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE))
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                .addComponent(HouseTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(CorpusTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(FlatTextField))
                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                .addComponent(TelephoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(IndexTextField))))))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                .addGap(20, 20, 20)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(ClearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addComponent(OkButton, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(CancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addComponent(ConsTypeTextField, javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(OwnerTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(StatusAccTextField)))))))
                                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(DistrictLabel)
                                        .addComponent(NumAccLabel)
                                        .addComponent(BalanceLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(DistrictTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(NumAccTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(BalanceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(FIOLabel)
                                        .addComponent(NumContractLabel)
                                        .addComponent(DateContractLabel))
                                .addGap(3, 3, 3)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(SurnameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(NumContractTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(DateContractDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(NameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(TelephoneLabel)
                                        .addComponent(IndexLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(MiddleNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(TelephoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(IndexTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(AdressLabel)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(HouseLabel)
                                                .addComponent(CorpusLabel)
                                                .addComponent(FlatLabel)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(AdressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(HouseTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(CorpusTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(FlatTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(OwnerLabel)
                                        .addComponent(StatusAccLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(OwnerTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(StatusAccTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(7, 7, 7)
                                .addComponent(ConsTypeLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ConsTypeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(OkButton)
                                        .addComponent(CancelButton)
                                        .addComponent(ClearButton))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {
        //какие-то действия
        this.dispose();

    }

    private void OkButtonActionPerformed(java.awt.event.ActionEvent evt) {
        //какие-то действия
        this.dispose();
    }

    private void ClearButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void DistrictTextFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void NumAccTextFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void BalanceTextFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void SurnameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void NameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void MiddleNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void NumContractTextFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void DateContractDatePickerActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void TelephoneTextFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void IndexTextFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void AdressTextFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void HouseTextFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void CorpusTextFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void FlatTextFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void OwnerTextFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void StatusAccTextFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void ConsTypeTextFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }
    // End of variables declaration                   
}
