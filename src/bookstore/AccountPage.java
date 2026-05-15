package bookstore;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedHashMap;

public class AccountPage extends JFrame {
    public AccountPage(boolean isRegistered, LinkedHashMap<String, Double> cart) {
        setTitle("Account/Profile");
        setSize(400, 400);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.setBackground(new Color(223, 198, 205));

        JLabel regLabel = new JLabel(isRegistered ? "User Registered: Yes" : "User Registered: No");
        regLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        panel.add(regLabel);

        panel.add(Box.createVerticalStrut(20));
        panel.add(new JLabel("Purchase History:"));
        DefaultListModel<String> model = new DefaultListModel<>();

        for (String item : cart.keySet()) {
            model.addElement(item);
        }

        JList<String> purchaseList = new JList<>(model);
        JScrollPane scrollPane = new JScrollPane(purchaseList);
        panel.add(scrollPane);

        add(panel);
        setVisible(true);
    }
}