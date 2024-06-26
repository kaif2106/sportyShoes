package com.sportyshoes.service;

import com.sportyshoes.entity.Product;
import com.sportyshoes.entity.User;
import com.sportyshoes.repository.ProductRepository;
import com.sportyshoes.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    public void changePassword(Long adminId, String newPassword) {
        User admin = userRepository.findById(adminId);
        admin.setPassword(newPassword);
        userRepository.save(admin);
    }

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}