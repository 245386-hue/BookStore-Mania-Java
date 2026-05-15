package bookstore;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedHashMap;

public class CartPage extends JFrame {
    public CartPage(LinkedHashMap<String, Double> cart) {
        setTitle("Cart");
        setSize(400, 450);
        setLocationRelativeTo(null);
        setBackground(new Color(223, 198, 205));

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(223, 198, 205));

        DefaultListModel<String> model = new DefaultListModel<>();
        double total = 0;
        for (var entry : cart.entrySet()) {
            String itemStr = entry.getKey() + " - PKR" + String.format("%.2f", entry.getValue());
            model.addElement(itemStr);
            total += entry.getValue();
        }

        JList<String> list = new JList<>(model);
        list.setBackground(new Color(223, 198, 205));
        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.getViewport().setBackground(new Color(223, 198, 205));

        JLabel totalLabel = new JLabel("Total: PKR" + String.format("%.2f", total));
        totalLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        totalLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton removeBtn = new JButton("Remove Selected");
        removeBtn.addActionListener(e -> {
            for (String selected : list.getSelectedValuesList()) {
                String itemName = selected.split(" - \\PKR")[0];
                cart.remove(itemName);
                model.removeElement(selected);
            }
            double newTotal = 0;
            for (Double price : cart.values()) newTotal += price;
            totalLabel.setText("Total: PKR" + String.format("%.2f", newTotal));
        });

        JButton checkoutBtn = new JButton("Checkout");
        checkoutBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        checkoutBtn.addActionListener(e -> {
            if (cart.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Your cart is empty. Add items before checkout.");
                return;
            }
            double checkoutTotal = 0;
            for (Double price : cart.values()) checkoutTotal += price;
            int confirm = JOptionPane.showConfirmDialog(this,
                    "Your total is PKR " + String.format("%.2f", checkoutTotal) + ". Proceed to checkout?",
                    "Confirm Checkout", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                cart.clear();
                model.clear();
                totalLabel.setText("Total: PKR0.00");
                JOptionPane.showMessageDialog(this, "Checkout successful! Thank you for your purchase.");
                dispose();
            }
        });

        panel.add(scrollPane);
        panel.add(Box.createVerticalStrut(10));
        panel.add(totalLabel);
        panel.add(Box.createVerticalStrut(10));
        panel.add(removeBtn);
        panel.add(Box.createVerticalStrut(10));
        panel.add(checkoutBtn);

        add(panel);
        setVisible(true);
    }
}