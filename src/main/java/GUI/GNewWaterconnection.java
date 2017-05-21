package GUI;
import WORK.Access;
import WORK.Connect;
import WORK.Waterconnection;
import com.mxrck.autocompleter.TextAutoCompleter;

import javax.swing.*;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/*
 * Created by Юлия on 19.04.2017.
 */
public class GNewWaterconnection extends javax.swing.JDialog {
    private JTextField textfields [];//массив текстовых полей
    private JComboBox comboboxes[];//массив комбобоксов
    private javax.swing.JTextField CodeWatconTextField;
    private org.jdesktop.swingx.JXDatePicker DateTYDatePicker;
    private javax.swing.JTextField DepthTextField;
    private javax.swing.JTextField LocationTextField;
    private javax.swing.JTextArea NoteTextArea;
    private javax.swing.JTextField NumTYTextField;
    private javax.swing.JTextField ObjectConTextField;
    private javax.swing.JComboBox<String> OwnerComboBox;
    private javax.swing.JTextField OwnerTerTextField;
    private javax.swing.JComboBox<String> StatusComboBox;
    private javax.swing.JComboBox<String> TypeConComboBox;

    GNewWaterconnection(java.awt.Frame parent) throws SQLException {
        super(parent, true);
        initComponents();
        textfields=new JTextField[]{CodeWatconTextField,NumTYTextField,ObjectConTextField,OwnerTerTextField,
                LocationTextField,DepthTextField};
        comboboxes =new JComboBox[]{StatusComboBox,OwnerComboBox,TypeConComboBox};
        CodeWatconTextField.setText(Integer.toString(Waterconnection.getLastCode()+1));//получение номера аккаунта
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
            java.util.logging.Logger.getLogger(GNewWaterconnection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            try {
                new GNewWaterconnection(null).setVisible(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
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
        JScrollPane jScrollPane2 = new JScrollPane();
        NoteTextArea = new javax.swing.JTextArea();
        JButton clearButton = new JButton();
        JButton okButton = new JButton();
        JButton cancelButton = new JButton();
        OwnerComboBox = new javax.swing.JComboBox<>();
        TypeConComboBox = new javax.swing.JComboBox<>();
        StatusComboBox = new javax.swing.JComboBox<>();

        //AUTOCOMPLETERS
        TextAutoCompleter objectcomplete = new TextAutoCompleter(ObjectConTextField);
        Connect.retrieveObject();
        while (Connect.rs.next()) {
            objectcomplete.addItem(Connect.rs.getString("object_con"));
        }

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Новое водомерное подключение ("+ Access.name_operator+")");
        ImageIcon icon = new ImageIcon("src\\main\\resources\\main_icon\\main_icon.png");
        setIconImage(icon.getImage());
        setResizable(false);

        codeWatconLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        codeWatconLabel.setText("Код ВП");

        CodeWatconTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        CodeWatconTextField.setEditable(false);

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

        NoteTextArea.setColumns(20);
        NoteTextArea.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        NoteTextArea.setRows(5);
        jScrollPane2.setViewportView(NoteTextArea);

        clearButton.setText("Очистить форму");
        clearButton.addActionListener(evt -> ClearButtonActionPerformed());

        okButton.setText("ОК");
        okButton.addActionListener(evt -> {
            try {
                AddWaterconnectButtonActionPerformed();
            } catch (ParseException | SQLException e) {
                e.printStackTrace();
            }
        });

        cancelButton.setText("Отмена");
        cancelButton.addActionListener(evt -> CancelButtonActionPerformed());

        OwnerComboBox.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        OwnerComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "НЕ ВЫБРАНО", "ГУПС ВОДОКАНАЛ", "АБОНЕНТ" }));

        TypeConComboBox.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        TypeConComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "НЕ ВЫБРАНО", "ОДИНОЧНОЕ", "КОЛЛЕКТИВНОЕ" }));

        StatusComboBox.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        StatusComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "НЕ ВЫБРАНО", "РАБОЧЕЕ", "НЕ РАБОЧЕЕ" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(clearButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(24, 24, 24)
                                                .addComponent(typeConLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(ownerTerLabel)
                                                .addGap(31, 31, 31))
                                        .addComponent(CodeWatconTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(17, 17, 17)
                                                .addComponent(codeWatconLabel)
                                                .addGap(38, 38, 38)
                                                .addComponent(numTYLabel)
                                                .addGap(55, 55, 55)
                                                .addComponent(dateTYLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(statusLabel)
                                                .addGap(24, 24, 24))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(79, 79, 79)
                                                .addComponent(locationLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(depthLabel)
                                                .addGap(17, 17, 17))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(LocationTextField)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(DepthTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(153, 153, 153)
                                                .addComponent(noteLabel))
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(TypeConComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(OwnerComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addGap(77, 77, 77)
                                                                        .addComponent(NumTYTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addGap(10, 10, 10)
                                                                        .addComponent(ownerLabel))))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGap(60, 60, 60)
                                                                                .addComponent(objectConLabel))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(DateTYDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(StatusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(ObjectConTextField, javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(OwnerTerTextField, javax.swing.GroupLayout.Alignment.TRAILING))))))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
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
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(clearButton)
                                        .addComponent(okButton)
                                        .addComponent(cancelButton))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>


    private void ClearButtonActionPerformed() {
        //очистка полей
        for(int i=1;i<textfields.length;i++) textfields[i].setText(null);
        for (JComboBox comboboxe : comboboxes) comboboxe.setSelectedIndex(0);
        DateTYDatePicker.setDate(null);
        NoteTextArea.setText(null);
    }

    private void AddWaterconnectButtonActionPerformed() throws ParseException, SQLException {
        switch(Waterconnection.addWaterconnection(readData())){
            case 0:
                JOptionPane.showMessageDialog(null,"Новое водомерное подключение было создано!", "Результат добавления", JOptionPane.INFORMATION_MESSAGE);
                dispose();
                break;
            case -1:
                JOptionPane.showMessageDialog(null,Waterconnection.error, "Ошибка", JOptionPane.ERROR_MESSAGE);
                break;
        }
    }

    private void CancelButtonActionPerformed() {
        dispose();
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
}
