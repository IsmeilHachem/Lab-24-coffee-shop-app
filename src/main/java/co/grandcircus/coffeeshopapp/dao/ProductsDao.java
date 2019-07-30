package co.grandcircus.coffeeshopapp.dao;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import co.grandcircus.coffeeshopapp.entity.Product;


@Repository
public class ProductsDao {

	@Autowired
	private JdbcTemplate jdbc;

	public List<Product> findAll() {

		String sql = "SELECT * FROM products";
		return jdbc.query(sql, new BeanPropertyRowMapper<>(Product.class));
	}

	public Product findById(Long id) {
		String sql = "SELECT * FROM products WHERE id = ?";
		return jdbc.queryForObject(sql, new BeanPropertyRowMapper<>(Product.class), id);
	}

	public void update(Product product) {
		String sql = "UPDATE Products SET name=?, description=?, price=? WHERE id=?";
		jdbc.update(sql, product.getName(), product.getDescription(), product.getPrice(), product.getId());
	}

	public void create(Product product) {
		String sql = "INSERT INTO Products (name, description, price) VALUES(?, ?, ?)";
		jdbc.update(sql, product.getName(), product.getDescription(), product.getPrice());
	}

	public void delete(Long id) {
		String sql = "DELETE FROM Products WHERE id = ?";
		jdbc.update(sql, id);

	}

}
