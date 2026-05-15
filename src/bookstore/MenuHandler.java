package bookstore;

import javax.swing.*;
import java.awt.*;

public class MenuHandler {
    private MainGUI mainGUI;
    private BookData bookData;
    private SpecialPages specialPages;
    
    public MenuHandler(MainGUI mainGUI, BookData bookData) {
        this.mainGUI = mainGUI;
        this.bookData = bookData;
        this.specialPages = new SpecialPages(bookData);
    }
    
    public void showMenu() {
        String[] menuItems = {"Home", "Categories", "Best Sellers", "On Sale", "About Us", "Contact Us"};

        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
        menuPanel.setBackground(new Color(223, 198, 205));
        menuPanel.setPreferredSize(new Dimension(200, mainGUI.getHeight()));

        JButton cancelBtn = new JButton("Cancel");
        cancelBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        cancelBtn.setMaximumSize(new Dimension(180, 40));

        JDialog menuDialog = new JDialog(mainGUI, false);
        cancelBtn.addActionListener(e -> menuDialog.dispose());
        menuPanel.add(cancelBtn);

        for (String item : menuItems) {
            JButton button = new JButton(item);
            button.setAlignmentX(Component.CENTER_ALIGNMENT);
            button.setMaximumSize(new Dimension(180, 40));
            
            if (item.equals("Categories")) {
                button.addActionListener(e -> {
                    menuDialog.dispose();
                    showCategoriesSubMenu();
                });
            } else if (item.equals("Best Sellers") || item.equals("On Sale")) {
                button.addActionListener(e -> {
                    menuDialog.dispose();
                    specialPages.showSpecialPage(item);
                });
            } else if (item.equals("About Us")) {
                button.addActionListener(e -> {
                    menuDialog.dispose();
                    showAboutUsPage();
                });
            } else if (item.equals("Contact Us")) {
                button.addActionListener(e -> {
                    menuDialog.dispose();
                    showContactUsPage();
                });
            } else {
                button.addActionListener(e -> {
                    menuDialog.dispose();
                    JOptionPane.showMessageDialog(mainGUI, "Welcome to Home Page!");
                });
            }
            
            menuPanel.add(button);
        }

        menuDialog.getContentPane().add(menuPanel);
        menuDialog.setUndecorated(true);
        menuDialog.setSize(200, mainGUI.getHeight());
        menuDialog.setLocation(0, 0);
        menuDialog.setVisible(true);
    }

    private void showCategoriesSubMenu() {
        String[] subCategories = {"Islamic Books", "History Books", "Children Books", "Urdu Books"};
        
        JPanel subMenuPanel = new JPanel();
        subMenuPanel.setLayout(new BoxLayout(subMenuPanel, BoxLayout.Y_AXIS));
        subMenuPanel.setBackground(new Color(240, 240, 240));
        subMenuPanel.setPreferredSize(new Dimension(200, mainGUI.getHeight()));
        
        JButton backBtn = new JButton("← Back");
        backBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        backBtn.setMaximumSize(new Dimension(180, 40));
        
        JDialog subMenuDialog = new JDialog(mainGUI, false);
        backBtn.addActionListener(e -> {
            subMenuDialog.dispose();
            showMenu();
        });
        subMenuPanel.add(backBtn);
        
        for (String category : subCategories) {
            JButton button = new JButton(category);
            button.setAlignmentX(Component.CENTER_ALIGNMENT);
            button.setMaximumSize(new Dimension(180, 40));
            button.addActionListener(e -> {
                subMenuDialog.dispose();
                specialPages.showCategoryBooksPage(category);
            });
            subMenuPanel.add(button);
        }
        
        subMenuDialog.getContentPane().add(subMenuPanel);
        subMenuDialog.setUndecorated(true);
        subMenuDialog.setSize(200, mainGUI.getHeight());
        subMenuDialog.setLocation(0, 0);
        subMenuDialog.setVisible(true);
    }

    private void showAboutUsPage() {
        // Implement about us page
    }

    private void showContactUsPage() {
        // Implement contact us page
    }
}