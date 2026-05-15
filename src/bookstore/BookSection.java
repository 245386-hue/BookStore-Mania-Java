package bookstore;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class BookSection {
    private Map<String, String> bookImages;
    private MainGUI mainGUI;
    
    public BookSection(BookData bookData, MainGUI mainGUI) {
        this.bookImages = bookData.getBookImages();
        this.mainGUI = mainGUI;
    }
    
    public JPanel createBookSection(String title) {
        JPanel section = new JPanel();
        section.setLayout(new BoxLayout(section, BoxLayout.Y_AXIS));
        section.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        section.setBackground(new Color(223, 198, 205));

        JLabel label = new JLabel(title);
        label.setFont(new Font("SansSerif", Font.BOLD, 20));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        section.add(label);

        JPanel bookPanelContainer = new JPanel();
        bookPanelContainer.setLayout(new BoxLayout(bookPanelContainer, BoxLayout.X_AXIS));
        bookPanelContainer.setBackground(new Color(223, 198, 205));

        for (int i = 1; i <= 5; i++) {
            JPanel bookPanel = new JPanel();
            bookPanel.setLayout(new BoxLayout(bookPanel, BoxLayout.Y_AXIS));
            bookPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            bookPanel.setBackground(Color.WHITE);
            bookPanel.setPreferredSize(new Dimension(180, 300));
            bookPanel.setMaximumSize(new Dimension(180, 300));

            String bookName = title + " Book " + i;
            double price = 10 + i * 2 + title.length() * 0.5;

            // Create image label
            JLabel imgLabel;
            if (bookImages.containsKey(bookName)) {
                ImageIcon originalIcon = new ImageIcon(bookImages.get(bookName));
                Image scaledImage = originalIcon.getImage().getScaledInstance(160, 200, Image.SCALE_SMOOTH);
                imgLabel = new JLabel(new ImageIcon(scaledImage));
            } else {
                imgLabel = new JLabel("No Image");
                imgLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));
            }
            imgLabel.setHorizontalAlignment(SwingConstants.CENTER);
            imgLabel.setPreferredSize(new Dimension(160, 200));
            bookPanel.add(imgLabel);

            JLabel nameLabel = new JLabel(bookName);
            nameLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
            nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

            JLabel priceLabel = new JLabel("PKR" + String.format("%.2f", price));
            priceLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));
            priceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

            JButton addToCartBtn = new JButton("Add to Cart");
            addToCartBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
            addToCartBtn.addActionListener(e -> {
                mainGUI.getCart().put(bookName, price);
                JOptionPane.showMessageDialog(null, bookName + " added to cart!");
            });

            JButton addToWishlistBtn = new JButton("Add to Wishlist");
            addToWishlistBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
            addToWishlistBtn.addActionListener(e -> {
                if (!mainGUI.getWishlist().contains(bookName)) {
                    mainGUI.getWishlist().add(bookName);
                    JOptionPane.showMessageDialog(null, bookName + " added to wishlist!");
                } else {
                    JOptionPane.showMessageDialog(null, bookName + " is already in wishlist!");
                }
            });

            bookPanel.add(nameLabel);
            bookPanel.add(priceLabel);
            bookPanel.add(addToCartBtn);
            bookPanel.add(addToWishlistBtn);

            bookPanelContainer.add(bookPanel);
            bookPanelContainer.add(Box.createHorizontalStrut(10));
        }

        section.add(bookPanelContainer);
        return section;
    }
}