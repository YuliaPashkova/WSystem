package GUI;
/*
 * Created by Юлия on 27.04.2017.
 */
import java.io.File;
import javax.swing.*;

public class GProtection extends javax.swing.JDialog {

    private javax.swing.JButton ChooseDataButton;
    private javax.swing.JButton CryptButton;
    private javax.swing.JFileChooser DataFileChooser;
    private javax.swing.JLabel KeyLabel;
    private javax.swing.JTextArea KeyTextArea;
    private javax.swing.JCheckBox LogCheckBox;
    private javax.swing.JTextField PathDBTextField;
    private javax.swing.JScrollPane jScrollPane1;
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
        } catch (ClassNotFoundException | InstantiationException | javax.swing.UnsupportedLookAndFeelException | IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GProtection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GProtection(true,null).setVisible(true);
            }
        });
    }

    @SuppressWarnings("unchecked")

    private void initComponents() {
        DataFileChooser = new javax.swing.JFileChooser();
        ChooseDataButton = new javax.swing.JButton();
        PathDBTextField = new javax.swing.JTextField();
        LogCheckBox = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        KeyTextArea = new javax.swing.JTextArea();
        KeyLabel = new javax.swing.JLabel();
        CryptButton = new javax.swing.JButton();

        DataFileChooser.setDialogTitle("Выбор пути к дампу базы данных");

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        ImageIcon icon = new ImageIcon("src\\main\\resources\\main_icon\\main_icon.png");
        setIconImage(icon.getImage());

        ChooseDataButton.setText("Выбрать дамп БД");
        ChooseDataButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChooseDataButtonActionPerformed(evt);
            }
        });

        LogCheckBox.setText("Лог файл");
        LogCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogCheckBoxActionPerformed(evt);
            }
        });

        KeyTextArea.setColumns(20);
        KeyTextArea.setRows(5);
        jScrollPane1.setViewportView(KeyTextArea);

        KeyLabel.setText("Ключ для шифрования ");

        CryptButton.setText("Зашифровать данные");
        CryptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CryptButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(PathDBTextField)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(LogCheckBox)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                .addComponent(CryptButton)
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addComponent(ChooseDataButton)
                                                                        .addGap(213, 213, 213)))
                                                        .addComponent(KeyLabel)
                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(ChooseDataButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(PathDBTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(LogCheckBox)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(KeyLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CryptButton)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>

    private void ChooseDataButtonActionPerformed(java.awt.event.ActionEvent evt) {
        DataFileChooser.setFileFilter(new FileFilter(".sql",""));
        DataFileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        int returnVal = DataFileChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = DataFileChooser.getSelectedFile();
            PathDBTextField.setText(file.getPath());
        }
    }

    private void CryptButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void LogCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {
        //if(LogCheckBox.isSelected())System.out.println("ffffff");
    }

    /* Устаналивает режим работы формы Защита данных.
      * Если mode-true, то шифрование данных
      * Если mode-false,то дешифрование данных
      */
    public void setMode(boolean mode) {
        if(mode){
            setTitle("Шифрование дампа БД");
            ChooseDataButton.setText("Выбрать дамп БД");
            DataFileChooser.setDialogTitle("Выбор пути к дампу БД");
            KeyLabel.setText("Ключ для шифрования ");
            CryptButton.setText("Зашифровать данные");
            setVisible(true);
        }
        else{
            setTitle("Дешифрование данных");
            ChooseDataButton.setText("Выбрать данные");
            DataFileChooser.setDialogTitle("Выбор пути к данным");
            KeyLabel.setText("Ключ для дешифрования ");
            CryptButton.setText("Дешифровать данные");
            setVisible(true);
        }
    }
}
