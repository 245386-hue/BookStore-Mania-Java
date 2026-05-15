# 📚 BookStore Mania

A modern Java Swing based Book Store Management System featuring interactive GUI components, book categories, shopping cart, wishlist, login/register system, and account management.

---

## ✨ Features

* 🖥️ User-Friendly Java Swing Interface
* 📖 Browse Books by Categories
* 🔥 Best Sellers & Trending Sections
* 🛒 Add to Cart Functionality
* ❤️ Wishlist Management
* 👤 Login & Registration System
* 📂 Account/Profile Page
* 💳 Checkout System
* 🖼️ Book Image Support
* 🧩 Object-Oriented Design

---

## 🛠️ Technologies Used

* Java
* Java Swing
* AWT
* Object-Oriented Programming (OOP)

---

## 📂 Project Structure

```text
BookStore-Mania-Java/
│
├── src/
│   └── bookstore/
│       ├── AccountPage.java
│       ├── BookData.java
│       ├── BookSection.java
│       ├── BookStoreMania.java
│       ├── CartPage.java
│       ├── LoginRegister.java
│       ├── MainGUI.java
│       ├── MenuHandler.java
│       ├── SpecialPages.java
│       └── WishlistPage.java
│
├── images/
│   ├── book1.jpg
│   ├── book2.jpg
│   ├── book3.jpg
│   └── ...
│
├── bin/
│
└── README.md
```

---

## ▶️ How to Run

### 1️⃣ Compile the Project

```bash
javac -d bin src/bookstore/*.java
```

### 2️⃣ Run the Application

```bash
java -cp bin bookstore.BookStoreMania
```

---

## ⚙️ Requirements

* JDK 21 or Above
* VS Code / Eclipse / IntelliJ IDEA

---

## 🖼️ Images Setup

Create an `images` folder in the main project directory and place your book images inside it.

Example:

```text
images/
├── book1.jpg
├── book2.jpg
├── book3.jpg
└── ...
```

Image paths are configured in:

```text
BookData.java
```

---

## 📌 Notes

* Ensure image names match the paths written in `BookData.java`
* Supports `.jpg` and `.png` images
* Built for educational and learning purposes

---

## 👨‍💻 Author

Aimen Nadeem

---

## 📄 License

This project is for educational purposes only.
