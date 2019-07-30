package co.grandcircus.coffeeshopapp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import co.grandcircus.coffeeshopapp.entity.User;

@Repository
public class UserDao {
	
	@Autowired
	private JdbcTemplate jdbc;

	public List<User> findAll() {

		String sql = "SELECT * FROM user";
		return jdbc.query(sql, new BeanPropertyRowMapper<>(User.class));
	}

	public User findById(Long id) {
		String sql = "SELECT * FROM user WHERE id = ?";
		return jdbc.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), id);
	}

	public void update(User user) {
		String sql = "UPDATE user SET firstname=?, lastname=?, username=?, password=? WHERE id=?";
		jdbc.update(sql, user.getFirstname(), user.getLastname(), user.getUsername(), user.getPassword(), user.getId());
	}

	public void create(User user) {
		String sql = "INSERT INTO user (firstname, lastname, username, password) VALUES(?, ?, ?, ?)";
		jdbc.update(sql, user.getFirstname(), user.getLastname(), user.getUsername(), user.getPassword());
	}

	public void delete(Long id) {
		String sql = "DELETE FROM User WHERE id = ?";
		jdbc.update(sql, id);

	}

}