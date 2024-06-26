package com.sportyshoes.repository;

import com.sportyshoes.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void save(Product product) {
        String sql = "INSERT INTO products (name, category, price) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, product.getName(), product.getCategory(), product.getPrice());
    }

    public List<Product> findAll() {
        String sql = "SELECT * FROM products";
        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new Product(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("category"),
                        rs.getDouble("price")
                ));
    }

    public Product findById(Long id) {
        String sql = "SELECT * FROM products WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) ->
                new Product(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("category"),
                        rs.getDouble("price")
                ));
    }
}