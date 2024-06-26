package com.sportyshoes.repository;

import com.sportyshoes.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void save(User user) {
        String sql = "INSERT INTO users (username, password, email) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, user.getUsername(), user.getPassword(), user.getEmail());
    }

    public List<User> findAll() {
        String sql = "SELECT * FROM users";
        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new User(
                        rs.getLong("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("email")
                ));
    }

    public User findById(Long id) {
        String sql = "SELECT * FROM users WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) ->
                new User(
                        rs.getLong("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("email")
                ));
    }
}