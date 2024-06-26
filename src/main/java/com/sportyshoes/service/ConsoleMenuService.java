package com.sportyshoes.service;

import com.sportyshoes.entity.Product;
import com.sportyshoes.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class ConsoleMenuService {

    @Autowired
    private AdminService adminService;

    private Scanner scanner = new Scanner(System.in);

    public void displayMenu() {
        while (true) {
            System.out.println("\n--- Sporty Shoes Admin Menu ---");
            System.out.println("1. Change Password");
            System.out.println("2. Manage Products");
            System.out.println("3. View Users");
            System.out.println("4. View Purchase Reports");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    changePassword();
                    break;
                case 2:
                    manageProducts();
                    break;
                case 3:
                    viewUsers();
                    break;
                case 4:
                    viewPurchaseReports();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void changePassword() {
        System.out.print("Enter new password: ");
        String newPassword = scanner.nextLine();
        adminService.changePassword(1L, newPassword); // Assuming admin ID is 1
        System.out.println("Password changed successfully.");
    }

    private void manageProducts() {
        System.out.println("\n--- Manage Products ---");
        System.out.println("1. Add Product");
        System.out.println("2. View All Products");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                addProduct();
                break;
            case 2:
                viewAllProducts();
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private void addProduct() {
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter product category: ");
        String category = scanner.nextLine();
        System.out.print("Enter product price: ");
        double price = scanner.nextDouble();

        Product product = new Product();
        product.setName(name);
        product.setCategory(category);
        product.setPrice(price);

        adminService.addProduct(product);
        System.out.println("Product added successfully.");
    }

    private void viewAllProducts() {
        List<Product> products = adminService.getAllProducts();
        for (Product product : products) {
            System.out.println(product.getId() + ": " + product.getName() + " - " + product.getCategory() + " - $" + product.getPrice());
        }
    }

    private void viewUsers() {
        List<User> users = adminService.getAllUsers();
        for (User user : users) {
            System.out.println(user.getId() + ": " + user.getUsername() + " - " + user.getEmail());
        }
    }

    private void viewPurchaseReports() {
        // This feature is not implemented in this basic version
        System.out.println("Purchase reports feature is not implemented in this version.");
    }
}