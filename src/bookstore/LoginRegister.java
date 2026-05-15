package bookstore;

import javax.swing.*;
import java.awt.*;

public class LoginRegister {
    private MainGUI mainGUI;
    
    public LoginRegister(MainGUI mainGUI) {
        this.mainGUI = mainGUI;
    }
    
    public void showLoginPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setBackground(new Color(223, 198, 205));

        panel.add(new JLabel("Username:"));
        JTextField userField = new JTextField();
        userField.setPreferredSize(new Dimension(200, 25));
        JPanel userFieldPanel = new JPanel(new BorderLayout());
        userFieldPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        userFieldPanel.add(userField, BorderLayout.CENTER);
        panel.add(userFieldPanel);
        panel.add(Box.createVerticalStrut(10));

        panel.add(new JLabel("Password:"));
        JPasswordField passField = new JPasswordField();
        passField.setPreferredSize(new Dimension(200, 25));
        JPanel passFieldPanel = new JPanel(new BorderLayout());
        passFieldPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        passFieldPanel.add(passField, BorderLayout.CENTER);
        panel.add(passFieldPanel);
        panel.add(Box.createVerticalStrut(20));

        JButton login = new JButton("Login");
        JButton register = new JButton("Register");
        JButton cancel = new JButton("Cancel");

        panel.add(login);
        panel.add(Box.createVerticalStrut(10));
        panel.add(register);
        panel.add(Box.createVerticalStrut(10));
        panel.add(cancel);

        JDialog loginDialog = new JDialog(mainGUI, false);
        cancel.addActionListener(e -> loginDialog.dispose());

        register.addActionListener(e -> {
            loginDialog.dispose();
            showRegisterPage();
        });

        login.addActionListener(e -> {
            // Simple login logic
            mainGUI.setRegistered(true);
            loginDialog.dispose();
            JOptionPane.showMessageDialog(mainGUI, "Login successful!");
        });

        loginDialog.getContentPane().add(panel);
        loginDialog.setUndecorated(true);
        loginDialog.setSize(300, mainGUI.getHeight());
        loginDialog.setLocation(mainGUI.getWidth() - 300, 0);
        loginDialog.setVisible(true);
    }

    private void showRegisterPage() {
        JFrame regFrame = new JFrame("Create Account");
        regFrame.setSize(400, 500);
        regFrame.setLocationRelativeTo(mainGUI);
        
        JPanel regPanel = new JPanel();
        regPanel.setLayout(new BoxLayout(regPanel, BoxLayout.Y_AXIS));
        regPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        regPanel.setBackground(new Color(223, 198, 205));

        regPanel.add(new JLabel("Full Name:"));
        regPanel.add(new JTextField());
        regPanel.add(Box.createVerticalStrut(10));

        regPanel.add(new JLabel("Email:"));
        regPanel.add(new JTextField());
        regPanel.add(Box.createVerticalStrut(10));

        regPanel.add(new JLabel("Username:"));
        regPanel.add(new JTextField());
        regPanel.add(Box.createVerticalStrut(10));

        regPanel.add(new JLabel("Password:"));
        regPanel.add(new JPasswordField());
        regPanel.add(Box.createVerticalStrut(10));

        regPanel.add(new JLabel("Confirm Password:"));
        regPanel.add(new JPasswordField());
        regPanel.add(Box.createVerticalStrut(20));

        JButton submit = new JButton("Create Account");
        JButton cancel = new JButton("Cancel");

        submit.setAlignmentX(Component.CENTER_ALIGNMENT);
        cancel.setAlignmentX(Component.CENTER_ALIGNMENT);

        regPanel.add(submit);
        regPanel.add(Box.createVerticalStrut(10));
        regPanel.add(cancel);

        cancel.addActionListener(e -> regFrame.dispose());

        submit.addActionListener(e -> {
            mainGUI.setRegistered(true);
            regFrame.dispose();
            JOptionPane.showMessageDialog(mainGUI, "Account Created Successfully!");
        });

        regFrame.add(regPanel);
        regFrame.setVisible(true);
    }
}