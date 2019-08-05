package co.grandcircus.coffeeshopapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import co.grandcircus.coffeeshopapp.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsernameAndPassword(String username, String password);
}
