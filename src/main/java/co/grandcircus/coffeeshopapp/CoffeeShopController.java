package co.grandcircus.coffeeshopapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.coffeeshopapp.dao.ProductsDao;
import co.grandcircus.coffeeshopapp.dao.UserDao;
import co.grandcircus.coffeeshopapp.entity.Product;
import co.grandcircus.coffeeshopapp.entity.User;

@Controller
public class CoffeeShopController {
	
	@Autowired
	private ProductsDao dao;

	@RequestMapping("/")
	public ModelAndView index() {
		List<Product> Products = dao.findAll();
		ModelAndView mv = new ModelAndView("index");

		mv.addObject("products", Products);

		return mv;

	}

	@RequestMapping("/register")
	public ModelAndView showRegister() {
		return new ModelAndView("register");
	}

	@Autowired
	private UserDao daoUser;

	@RequestMapping("/register-result")
	public ModelAndView add() {
		return new ModelAndView("register-result");
	}

	@PostMapping("/register-result")
	public ModelAndView addRegisterResult(User users) {
		daoUser.create(users);
		return new ModelAndView("register-result");
	}
}