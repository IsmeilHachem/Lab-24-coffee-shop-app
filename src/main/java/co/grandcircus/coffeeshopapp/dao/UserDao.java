package co.grandcircus.coffeeshopapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import co.grandcircus.coffeeshopapp.entity.User;


@Repository
@Transactional
public class UserDao {
	
	@PersistenceContext
	EntityManager em;
	
	public List<User> findAll(){
		return em.createQuery("FROM User", User.class)
				.getResultList();
	}
	
	public User findById(Long id) {
		return em.find(User.class, id);
	}
	
	public void create(User user) {
		em.persist(user);
	}
	
	public void update(User user) {
		em.merge(user);
	}
	
	public void delete(Long id) {
		User user = em.getReference(User.class, id);
		em.remove(user);
	}

	public User findByUsernameAndPassword(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
	
	
}