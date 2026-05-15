package bookstore;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class MainGUI extends JFrame {
    private JPanel mainPanel;
    private ArrayList<String> wishlist = new ArrayList<>();
    private LinkedHashMap<String, Double> cart = new LinkedHashMap<>();
    private boolean isRegistered = false;
    private BookData bookData;
    private BookSection bookSection;
    private MenuHandler menuHandler;
    private LoginRegister loginRegister;

    public MainGUI() {
        bookData = new BookData();
        bookSection = new BookSection(bookData, this);
        menuHandler = new MenuHandler(this, bookData);
        loginRegister = new LoginRegister(this);

        initializeGUI();
    }

    private void initializeGUI() {
        setTitle("Book Store Mania");
        setSize(1200, 900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        createHeader();
        createMainPanel();

        JScrollPane scrollPane = new JScrollPane(mainPanel);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        add(scrollPane, BorderLayout.CENTER);

        createFooter();
        setVisible(true);
    }

    private void createHeader() {
        JPanel headerContainer = new JPanel();
        headerContainer.setLayout(new BoxLayout(headerContainer, BoxLayout.Y_AXIS));

        // Top header with menu button
        JPanel topHeader = new JPanel(new BorderLayout());
        topHeader.setBackground(new Color(183, 132, 167));
        JButton menuButton = new JButton("☰");
        menuButton.setFont(new Font("SansSerif", Font.BOLD, 18));
        menuButton.setFocusPainted(false);
        menuButton.addActionListener(e -> menuHandler.showMenu());
        topHeader.add(menuButton, BorderLayout.WEST);
        headerContainer.add(topHeader);

        // Navigation bar
        JPanel navBar = new JPanel(new FlowLayout(FlowLayout.LEFT));
        navBar.setBackground(new Color(223, 198, 205));

        JLabel logo = new JLabel("📚 BookStore");
        logo.setFont(new Font("SansSerif", Font.BOLD, 30));

        JTextField search = new JTextField(60);
        JButton loginBtn = new JButton("Login/Register");
        JButton wishlistBtn = new JButton("Wishlist");
        JButton cartBtn = new JButton("Cart");
        JButton accountBtn = new JButton("Account");

        loginBtn.addActionListener(e -> loginRegister.showLoginPanel());
        wishlistBtn.addActionListener(e -> new WishlistPage(wishlist, cart));
        cartBtn.addActionListener(e -> new CartPage(cart));
        accountBtn.addActionListener(e -> new AccountPage(isRegistered, cart));

        navBar.add(logo);
        navBar.add(search);
        navBar.add(loginBtn);
        navBar.add(wishlistBtn);
        navBar.add(cartBtn);
        navBar.add(accountBtn);

        headerContainer.add(navBar);

        // Welcome label
        JLabel welcome = new JLabel("Welcome to Our Book Store!", JLabel.CENTER);
        welcome.setFont(new Font("SansSerif", Font.ITALIC, 20));
        welcome.setForeground(Color.black);
        headerContainer.add(welcome);

        // Banner panel
        JPanel bannerPanel = new JPanel();
        bannerPanel.setPreferredSize(new Dimension(1200, 150));
        bannerPanel.setBackground(new Color(178, 172, 136));
        ImageIcon bannerIcon = new ImageIcon("images/header.jpg");
        JLabel bannerImg = new JLabel();

        if (bannerIcon.getIconWidth() > 0) {
            Image scaledImage = bannerIcon.getImage().getScaledInstance(1200, 150, Image.SCALE_SMOOTH);
            bannerIcon = new ImageIcon(scaledImage);
            bannerImg.setIcon(bannerIcon);
        } else {
            bannerImg.setText("images/ends.jpeg");
            bannerImg.setFont(new Font("SansSerif", Font.BOLD, 20));
            bannerImg.setHorizontalAlignment(SwingConstants.CENTER);
        }

        bannerImg.setPreferredSize(new Dimension(1200, 150));
        bannerPanel.add(bannerImg);
        headerContainer.add(bannerPanel);

        add(headerContainer, BorderLayout.NORTH);
    }

    private void createMainPanel() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(new Color(223, 198, 205));

        mainPanel.add(bookSection.createBookSection("Best Sellers"));
        mainPanel.add(bookSection.createBookSection("New Trending"));
        mainPanel.add(bookSection.createBookSection("On Sale"));
        mainPanel.add(bookSection.createBookSection("New Arrival"));
    }

    private void createFooter() {
        JPanel footer = new JPanel();
        footer.setBackground(new Color(183, 132, 167));
        footer.setPreferredSize(new Dimension(getWidth(), 50));
        JLabel footerLabel = new JLabel("© 2025 Book Store Mania");
        footerLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
        footer.add(footerLabel);
        add(footer, BorderLayout.SOUTH);
    }

    // Getters for shared data
    public ArrayList<String> getWishlist() {
        return wishlist;
    }

    public LinkedHashMap<String, Double> getCart() {
        return cart;
    }

    public boolean isRegistered() {
        return isRegistered;
    }

    public void setRegistered(boolean registered) {
        isRegistered = registered;
    }
}