package GUI;

import java.awt.*;

/**
 * Created by Юлия on 13.04.2017.
 */
public class GTitul extends javax.swing.JFrame {
    public GTitul() {
        //Connect.conntoDB();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        UserNameLabel = new javax.swing.JLabel();
        PasswordLabel = new javax.swing.JLabel();
        UserNameTextField = new javax.swing.JTextField();
        PasswordTextField = new javax.swing.JPasswordField();
        ExitButton = new javax.swing.JButton();
        GoButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Вход в систему.");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("main_icon.png")));
        setBounds(new java.awt.Rectangle(500, 200, 0, 0));
        setResizable(false);

        UserNameLabel.setText("Имя пользователя");
        PasswordLabel.setText("Пароль");

        PasswordTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                PasswordTextFieldKeyPressed(evt);
            }
        });

        ExitButton.setText("Выход");
        ExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitButtonActionPerformed(evt);
            }
        });

        GoButton.setText("Войти");
        GoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GoButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(UserNameLabel)
                                                        .addComponent(PasswordLabel))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(PasswordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(UserNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(99, 99, 99)
                                                .addComponent(GoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(ExitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(UserNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(UserNameLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(PasswordLabel)
                                        .addComponent(PasswordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(ExitButton)
                                        .addComponent(GoButton))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pack();
    }

    private void GoButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // go();

    }

    private void ExitButtonActionPerformed(java.awt.event.ActionEvent evt) {
      
    }

    private void PasswordTextFieldKeyPressed(java.awt.event.KeyEvent evt) {
       
    }
                                             

    /*public void go() throws SQLException {
        int error = Access.login(UserNameTextField.getText(), PasswordTextField.getText());
        switch (error) {
            case 1://логин  и пароль введены верно
                int access = Access.checkingUser(UserNameTextField.getText());//проверка доступа}
                if (access != -1) {
                    Lic_Schet_Menu.setEnabled(true);
                    Bank_Menu.setEnabled(true);
                    Otchet_Menu.setEnabled(true);
                    Spravochnik_Menu.setEnabled(true);
                }
                switch (access) {
                    case -1:
                        JOptionPane.showMessageDialog(null, "Что-то пошло не так!", "Ошибка", JOptionPane.ERROR_MESSAGE);
                        break;
                    case 1://доступ к водомерному подключению
                        formaaccount.Vodomer_UzelButton.setEnabled(false);
                        break;
                    case 2://нет доступа к созданию лицевого счета
                        formaaccount.NewLicSchetMenuItem.setEnabled(false);
                        break;

                }
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "Логин или пароль введены неверно!", "Ошибка", JOptionPane.ERROR_MESSAGE);
                break;
            case 3:JOptionPane.showMessageDialog(null, "Введите логин и пароль!", "Ошибка", JOptionPane.ERROR_MESSAGE);
                break;
            case 4:
                JOptionPane.showMessageDialog(null, "Введите логин!", "Ошибка", JOptionPane.ERROR_MESSAGE);
                break;
            case 5:
                JOptionPane.showMessageDialog(null, "Введите пароль!", "Ошибка", JOptionPane.ERROR_MESSAGE);
                break;
        }
    }*/

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | javax.swing.UnsupportedLookAndFeelException | IllegalAccessException | InstantiationException ex) {
            java.util.logging.Logger.getLogger(GTitul.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GTitul().setVisible(true);
            }
        });
    }

    private javax.swing.JButton ExitButton;
    private javax.swing.JButton GoButton;
    private javax.swing.JLabel PasswordLabel;
    private javax.swing.JPasswordField PasswordTextField;
    private javax.swing.JLabel UserNameLabel;
    private javax.swing.JTextField UserNameTextField;
}

