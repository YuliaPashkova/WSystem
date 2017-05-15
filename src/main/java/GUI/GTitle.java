package GUI;
import WORK.Access;
import WORK.Connect;
import javax.swing.*;
import java.awt.event.KeyEvent;
import static WORK.Connect.conntoDB;

/*
 * Created by Юлия on 13.04.2017.
 */
public class GTitle extends javax.swing.JFrame {
    private javax.swing.JPasswordField PasswordTextField;
    private javax.swing.JTextField UserNameTextField;


    private GTitle() throws Exception {
        conntoDB();
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
            java.util.logging.Logger.getLogger(GTitle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            try {
                new GTitle().setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        JLabel userNameLabel = new JLabel();
        JLabel passwordLabel = new JLabel();
        UserNameTextField = new javax.swing.JTextField();
        PasswordTextField = new javax.swing.JPasswordField();
        JButton exitButton = new JButton();
        JButton goButton = new JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Вход в систему");
        ImageIcon icon = new ImageIcon("src\\main\\resources\\main_icon\\main_icon.png");
        setIconImage(icon.getImage());

        setBounds(new java.awt.Rectangle(500, 200, 0, 0));
        setResizable(false);

        userNameLabel.setText("Имя пользователя");
        passwordLabel.setText("Пароль");

        PasswordTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                try {
                    PasswordTextFieldKeyPressed(evt);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        exitButton.setText("Выход");
        exitButton.addActionListener(evt -> {
            try {
                ExitButtonActionPerformed();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        goButton.setText("Войти");
        goButton.addActionListener(evt -> {
            try {
                GoButtonActionPerformed();
            } catch (Exception e) {
                e.printStackTrace();
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
                                                        .addComponent(userNameLabel)
                                                        .addComponent(passwordLabel))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(PasswordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(UserNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(99, 99, 99)
                                                .addComponent(goButton, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(UserNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(userNameLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(passwordLabel)
                                        .addComponent(PasswordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(exitButton)
                                        .addComponent(goButton))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }

    private void GoButtonActionPerformed() throws Exception {
        login();
    }
    /*
    * Метод осуществляет вход в систему
    * */
    private void login() throws Exception {
        int result = Access.login(UserNameTextField.getText(), PasswordTextField.getText());
        switch (result) {
            case 1://логин  и пароль введены верно
                    GAccount gaccount = new GAccount();
                    gaccount.setAccess(Access.access);
                    gaccount.setVisible(true);
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "Логин или пароль введены неверно!", "Ошибка", JOptionPane.ERROR_MESSAGE);
                break;
            case 3:
                JOptionPane.showMessageDialog(null, "Введите логин и пароль!", "Ошибка", JOptionPane.ERROR_MESSAGE);
                break;
            case 4:
                JOptionPane.showMessageDialog(null, "Введите логин!", "Ошибка", JOptionPane.ERROR_MESSAGE);
                break;
            case 5:
                JOptionPane.showMessageDialog(null, "Введите пароль!", "Ошибка", JOptionPane.ERROR_MESSAGE);
                break;
        }
    }

    private void ExitButtonActionPerformed() throws Exception {
        Connect.close();
        System.exit(0);
    }

    private void PasswordTextFieldKeyPressed(java.awt.event.KeyEvent evt) throws Exception {
        if (evt.getKeyCode()== KeyEvent.VK_ENTER) login();
    }
}

