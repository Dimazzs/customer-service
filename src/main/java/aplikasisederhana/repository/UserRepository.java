package aplikasisederhana.repository;
import aplikasisederhana.entity.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    private final JdbcTemplate jdbcTemplate;

    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public User createUser(User user) {
        String sql = "INSERT INTO users (first_name, last_name, email) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, user.getFirstName(), user.getLastName(), user.getEmail());
        return user;
    }

    public User getUserById(Long userId) {
        String sql = "SELECT * FROM users WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{userId}, new UserRowMapper());
    }

    public List<User> getAllUsers() {
        String sql = "SELECT * FROM users";
        return jdbcTemplate.query(sql, new UserRowMapper());
    }

    public User updateUser(User user) {
        String sql = "UPDATE users SET first_name = ?, last_name = ?, email = ? WHERE id = ?";
        jdbcTemplate.update(sql, user.getFirstName(), user.getLastName(), user.getEmail(), user.getId());
        return user;
    }

    public void deleteUser(Long userId) {
        String sql = "DELETE FROM users WHERE id = ?";
        jdbcTemplate.update(sql, userId);
    }


}
