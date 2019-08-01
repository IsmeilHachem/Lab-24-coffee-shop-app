package co.grandcircus.coffeeshopapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import co.grandcircus.coffeeshopapp.entity.Product;



@Repository
@Transactional
public class ProductsDao{
	
	@PersistenceContext
	EntityManager em;
	
	public List<Product> findAll(){
		
		List<Product> products = em.createQuery("FROM Product", Product.class)
				.getResultList();
		return products;
		
	}
	
	// find specific product with its unique id
	public Product findById(Long id) {
		return em.find(Product.class, id);
	}
	
	public void create(Product product) {
		em.persist(product);
	}
	
	public void update(Product product) {
		em.merge(product);
	}
	
	public void delete(Long id) {
		Product product = em.getReference(Product.class, id);
		em.remove(product);
	}
}


