package com.sportyshoes.repository;

import com.sportyshoes.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class OrderRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void save(Order order) {
        String sql = "INSERT INTO orders (user_id, product_id, order_date) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, order.getUserId(), order.getProductId(), order.getOrderDate());
    }

    public List<Order> findAll() {
        String sql = "SELECT * FROM orders";
        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new Order(
                        rs.getLong("id"),
                        rs.getLong("user_id"),
                        rs.getLong("product_id"),
                        rs.getDate("order_date")
                ));
    }

    public List<Order> findByDateRange(Date startDate, Date endDate) {
        String sql = "SELECT * FROM orders WHERE order_date BETWEEN ? AND ?";
        return jdbcTemplate.query(sql, new Object[]{startDate, endDate}, (rs, rowNum) ->
                new Order(
                        rs.getLong("id"),
                        rs.getLong("user_id"),
                        rs.getLong("product_id"),
                        rs.getDate("order_date")
                ));
    }
}