package bookstore;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class WishlistPage extends JFrame {
    public WishlistPage(ArrayList<String> wishlist, LinkedHashMap<String, Double> cart) {
        setTitle("Wishlist");
        setSize(500, 400);
        setLocationRelativeTo(null);

        DefaultListModel<String> model = new DefaultListModel<>();
        for (String item : wishlist) {
            model.addElement(item);
        }

        JList<String> list = new JList<>(model);
        list.setBackground(new Color(223, 198, 205));
        JScrollPane scrollPane = new JScrollPane(list);

        JButton addToCartBtn = new JButton("Add to Cart");
        addToCartBtn.addActionListener(e -> {
            for (String selected : list.getSelectedValuesList()) {
                if (!cart.containsKey(selected)) {
                    double price = 15.00;
                    cart.put(selected, price);
                    JOptionPane.showMessageDialog(this, selected + " added to cart!");
                }
            }
        });

        JButton removeBtn = new JButton("Remove Selected");
        removeBtn.addActionListener(e -> {
            for (String selected : list.getSelectedValuesList()) {
                wishlist.remove(selected);
                model.removeElement(selected);
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(223, 198, 205));
        panel.add(scrollPane);
        panel.add(addToCartBtn);
        panel.add(removeBtn);

        add(panel);
        setVisible(true);
    }
}