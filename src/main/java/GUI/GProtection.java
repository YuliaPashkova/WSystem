package GUI;
/*
 * Created by Юлия on 27.04.2017.
 */
import WORK.Access;
import WORK.Magma;

import java.io.File;
import javax.swing.*;

public class GProtection extends javax.swing.JDialog {
    private static boolean mode=true;//true - шифрование,false - дешифрование
    private javax.swing.JButton CryptButton;
    private javax.swing.JFileChooser DataFileChooser;
    private javax.swing.JFileChooser KeyFileChooser;
    private javax.swing.JFileChooser LogFileChooser;
    private javax.swing.JTextField PathDataTextField;
    private javax.swing.JTextField PathKeyTextField;
    private javax.swing.JTextField PathLogTextField;
    private javax.swing.JTextField PathSynchroTextField;
    private javax.swing.JFileChooser SynchroFileChooser;
    private JButton chooseDataButton = new JButton();
    GProtection(boolean mode, java.awt.Frame parent) {
        super(parent, true);
        initComponents();
        setMode(mode);
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
            java.util.logging.Logger.getLogger(GProtection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> new GProtection(true,null).setVisible(true));
    }

    private void initComponents() {
        DataFileChooser = new javax.swing.JFileChooser();
        KeyFileChooser = new javax.swing.JFileChooser();
        LogFileChooser = new javax.swing.JFileChooser();
        SynchroFileChooser = new javax.swing.JFileChooser();

        CryptButton = new javax.swing.JButton();
        JButton chooseKeyButton = new JButton();
        JButton chooseLogButton = new JButton();
        JButton chooseSynchroButton = new JButton();
        PathDataTextField = new javax.swing.JTextField();
        PathKeyTextField = new javax.swing.JTextField();
        PathLogTextField = new javax.swing.JTextField();
        PathSynchroTextField = new javax.swing.JTextField();

        DataFileChooser.setDialogTitle("Выбор пути к дампу базы данных");

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        ImageIcon icon = new ImageIcon("src\\main\\resources\\main_icon\\main_icon.png");
        setIconImage(icon.getImage());

        chooseDataButton.addActionListener(this::ChooseDataButtonActionPerformed);

        CryptButton.setText("Зашифровать данные");
        CryptButton.addActionListener((evt) -> {
            try {
                CryptButtonActionPerformed();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        chooseKeyButton.setText("Выбрать файл с ключом");
        chooseKeyButton.addActionListener(this::ChooseKeyButtonActionPerformed);

        chooseLogButton.setText("Выбрать файл для лога");
        chooseLogButton.addActionListener(this::ChooseLogButtonActionPerformed);

        chooseSynchroButton.setText("Выбрать файл с нач. заполнителем");
        chooseSynchroButton.addActionListener(this::ChooseSynchroButtonActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(chooseSynchroButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(chooseDataButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(chooseKeyButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(chooseLogButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(PathDataTextField)
                                                        .addComponent(PathKeyTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                                                        .addComponent(PathLogTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                                                        .addComponent(PathSynchroTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(CryptButton)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(chooseDataButton)
                                                        .addComponent(PathDataTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(chooseKeyButton))
                                        .addComponent(PathKeyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(chooseLogButton)
                                        .addComponent(PathLogTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(chooseSynchroButton)
                                        .addComponent(PathSynchroTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CryptButton)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }

    private void ChooseDataButtonActionPerformed(java.awt.event.ActionEvent evt) {
        DataFileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        int returnVal = DataFileChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = DataFileChooser.getSelectedFile();
            PathDataTextField.setText(file.getPath());
        }
    }

    private void CryptButtonActionPerformed() throws Exception {
        if(PathDataTextField.getText().length() == 0 ||
                PathDataTextField.getText().length() == 0 ||
                PathKeyTextField.getText().length() == 0 ||
                PathSynchroTextField.getText().length() == 0 ||
                PathLogTextField.getText().length() == 0){
            JOptionPane.showMessageDialog(null, "Пожалуйста, заполните все поля.", "", JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            if (mode) {
                int result = Magma.encryption(PathDataTextField.getText(), PathDataTextField.getText(), PathKeyTextField.getText(), PathSynchroTextField.getText(), PathLogTextField.getText());//шифрование
                if(result == 1)
                    JOptionPane.showMessageDialog(null, "Шифрование файлов SQL потерпело неудачу. Подробная информация в " + PathLogTextField.getText(), "Результат шифрования", JOptionPane.INFORMATION_MESSAGE);
                else
                    JOptionPane.showMessageDialog(null, "Шифрование файлов SQL окончено. Зашифрованные файлы находятся в " + PathDataTextField.getText() +
                        "\\out", "Результат шифрования", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            } else {
                int result = Magma.decryption(PathDataTextField.getText(), PathDataTextField.getText(), PathKeyTextField.getText(), PathSynchroTextField.getText(), PathLogTextField.getText());//дешифрование
                if(result == 1)
                    JOptionPane.showMessageDialog(null, "Дешифрование файлов mgm потерпело неудачу. Подробная информация в " + PathLogTextField.getText(), "Результат дешифрования", JOptionPane.INFORMATION_MESSAGE);
                else
                    JOptionPane.showMessageDialog(null, "Дешифрование файлов mgm окончено. Дешифрованные файлы находятся в " + PathDataTextField.getText() +
                        "\\out", "Результат дешифрования", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
        }
    }

    private void ChooseKeyButtonActionPerformed(java.awt.event.ActionEvent evt) {
        KeyFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int returnVal = KeyFileChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = KeyFileChooser.getSelectedFile();
            PathKeyTextField.setText(file.getPath());
        }
    }

    private void ChooseLogButtonActionPerformed(java.awt.event.ActionEvent evt) {
        LogFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int returnVal =  LogFileChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file =  LogFileChooser.getSelectedFile();
            PathLogTextField.setText(file.getPath());
        }
    }

    private void ChooseSynchroButtonActionPerformed(java.awt.event.ActionEvent evt) {
        SynchroFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int returnVal =  SynchroFileChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file =  SynchroFileChooser.getSelectedFile();
            PathSynchroTextField.setText(file.getPath());
        }
    }

    /* Устаналивает режим работы формы Защита данных.
      * Если mode-true, то шифрование данных
      * Если mode-false,то дешифрование данных
      */
    private void setMode(boolean m) {
        if(m){
            mode=true;
            setTitle("Шифрование данных ("+ Access.name_operator+")");
            CryptButton.setText("Зашифровать данные");
            chooseDataButton.setText("Выбрать файлы SQL");
        }
        else{
            mode=false;
            setTitle("Дешифрование данных ("+ Access.name_operator+")");
            CryptButton.setText("Дешифровать данные");
            chooseDataButton.setText("Выбрать файлы mgm");
        }
    }
}