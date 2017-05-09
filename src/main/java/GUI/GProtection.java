package GUI;
/*
 * Created by Юлия on 27.04.2017.
 */
import WORK.Access;

import java.io.File;
import javax.swing.*;

public class GProtection extends javax.swing.JDialog {

    private javax.swing.JButton ChooseDataButton;
    private javax.swing.JButton ChooseKeyButton;
    private javax.swing.JButton ChooseLogButton;
    private javax.swing.JButton ChooseSynchroButton;
    private javax.swing.JButton CryptButton;
    private javax.swing.JFileChooser DataFileChooser;
    private javax.swing.JFileChooser KeyFileChooser;
    private javax.swing.JFileChooser LogFileChooser;
    private javax.swing.JTextField PathDataTextField;
    private javax.swing.JTextField PathKeyTextField;
    private javax.swing.JTextField PathLogTextField;
    private javax.swing.JTextField PathSynchroTextField;
    private javax.swing.JFileChooser SynchroFileChooser;
    public GProtection(boolean mode,java.awt.Frame parent) {
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

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GProtection(true,null).setVisible(true);
            }
        });
    }

    private void initComponents() {
        DataFileChooser = new javax.swing.JFileChooser();
        KeyFileChooser = new javax.swing.JFileChooser();
        LogFileChooser = new javax.swing.JFileChooser();
        SynchroFileChooser = new javax.swing.JFileChooser();
        ChooseDataButton = new javax.swing.JButton();
        CryptButton = new javax.swing.JButton();
        ChooseKeyButton = new javax.swing.JButton();
        ChooseLogButton = new javax.swing.JButton();
        ChooseSynchroButton = new javax.swing.JButton();
        PathDataTextField = new javax.swing.JTextField();
        PathKeyTextField = new javax.swing.JTextField();
        PathLogTextField = new javax.swing.JTextField();
        PathSynchroTextField = new javax.swing.JTextField();

        DataFileChooser.setDialogTitle("Выбор пути к дампу базы данных");

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        ImageIcon icon = new ImageIcon("src\\main\\resources\\main_icon\\main_icon.png");
        setIconImage(icon.getImage());
        setTitle("Шифрование данных ("+ Access.name_operator+")");

        ChooseDataButton.setText("Выбрать файлы SQL");
        ChooseDataButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChooseDataButtonActionPerformed(evt);
            }
        });

        CryptButton.setText("Зашифровать данные");
        CryptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CryptButtonActionPerformed(evt);
            }
        });

        ChooseKeyButton.setText("Выбрать файл с ключом");
        ChooseKeyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChooseKeyButtonActionPerformed(evt);
            }
        });

        ChooseLogButton.setText("Выбрать файл для лога");
        ChooseLogButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChooseLogButtonActionPerformed(evt);
            }
        });

        ChooseSynchroButton.setText("Выбрать файл с синхропосылкой");
        ChooseSynchroButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChooseSynchroButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(ChooseSynchroButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(ChooseDataButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(ChooseKeyButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(ChooseLogButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                                                        .addComponent(ChooseDataButton)
                                                        .addComponent(PathDataTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(ChooseKeyButton))
                                        .addComponent(PathKeyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(ChooseLogButton)
                                        .addComponent(PathLogTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(ChooseSynchroButton)
                                        .addComponent(PathSynchroTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CryptButton)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>

    private void ChooseDataButtonActionPerformed(java.awt.event.ActionEvent evt) {
        DataFileChooser.setFileFilter(new FileFilter(".sql"));
        DataFileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        int returnVal = DataFileChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = DataFileChooser.getSelectedFile();
            PathDataTextField.setText(file.getPath());
        }
    }

    private void CryptButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void ChooseKeyButtonActionPerformed(java.awt.event.ActionEvent evt) {
        KeyFileChooser.setFileFilter(new FileFilter(".txt"));
        KeyFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int returnVal = KeyFileChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = KeyFileChooser.getSelectedFile();
            PathKeyTextField.setText(file.getPath());
        }
    }

    private void ChooseLogButtonActionPerformed(java.awt.event.ActionEvent evt) {
        LogFileChooser.setFileFilter(new FileFilter(".txt"));
        LogFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int returnVal =  LogFileChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file =  LogFileChooser.getSelectedFile();
            PathLogTextField.setText(file.getPath());
        }
    }

    private void ChooseSynchroButtonActionPerformed(java.awt.event.ActionEvent evt) {
        SynchroFileChooser.setFileFilter(new FileFilter(".txt"));
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
    public void setMode(boolean mode) {
        if(mode){
            setTitle("Шифрование данных ("+ Access.name_operator+")");
            CryptButton.setText("Зашифровать данные");
            setVisible(true);
        }
        else{
            setTitle("Дешифрвание данных ("+ Access.name_operator+")");
            CryptButton.setText("Дешифровать данные");
            setVisible(true);
        }
    }
}
