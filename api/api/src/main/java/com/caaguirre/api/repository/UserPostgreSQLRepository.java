package com.caaguirre.api.repository;

import com.caaguirre.api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
@Qualifier("postgreSQL")
public class UserPostgreSQLRepository implements IUserRepository{

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserPostgreSQLRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public User findByUsername(String username) {
        String sqlQuery = "SELECT id, username, password, email, enabled " +
                "FROM user WHERE username = ?";
        return jdbcTemplate.queryForObject(sqlQuery, this::mapRowToUser, username);
    }

    @Override
    public User findById(Long id) {
        String sqlQuery = "SELECT id, username, password, email, enabled " +
                "FROM user where id = ?";
        return jdbcTemplate.queryForObject(sqlQuery, this::mapRowToUser, id);
    }

    @Override
    public List<User> selectAllUsers() {
        String sqlQuery = "SELECT id, username, password, email, enabled FROM user";
        return jdbcTemplate.query(sqlQuery, this::mapRowToUser);
    }

    @Override
    public int deleteUser(Long userId) {
        String sql = "" +
                "DELETE FROM user " +
                "WHERE student_id = ?";
        return jdbcTemplate.update(sql, userId);
    }

    @Override
    public int createUser(User user) {
        String sql = "" +
                "INSERT INTO user (" +
                "id" +
                " username, " +
                " password, " +
                " email, " +
                " enabled) " +
                "VALUES (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(
                sql,
                user.getUserId(),
                user.getUsername(),
                user.getPassword(),
                user.getEmail(),
                user.isEnabled()
        );
    }

    @Override
    public void updateUser(User user) {
        String sqlQuery = "update user set " +
                "username = ?, password = ?, email = ? " +
                "WHERE id = ?";
        jdbcTemplate.update(sqlQuery
                , user.getUsername()
                , user.getPassword()
                , user.getEmail()
                , user.getUserId());
    }

    private User mapRowToUser(ResultSet resultSet, int rowNum) throws SQLException {
        return User.builder()
                .userId(resultSet.getLong("id"))
                .username(resultSet.getString("username"))
                .password(resultSet.getString("password"))
                .email(resultSet.getString("email"))
                .enabled(resultSet.getBoolean("enabled"))
                .build();
    }
}