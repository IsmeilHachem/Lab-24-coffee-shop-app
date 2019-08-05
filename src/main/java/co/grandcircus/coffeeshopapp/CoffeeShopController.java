package co.grandcircus.coffeeshopapp;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.coffeeshopapp.dao.ProductsDao;
import co.grandcircus.coffeeshopapp.dao.UserDao;
import co.grandcircus.coffeeshopapp.dao.UserRepository;
import co.grandcircus.coffeeshopapp.entity.Product;
import co.grandcircus.coffeeshopapp.entity.User;


@Controller
public class CoffeeShopController {
	
	@Autowired
	private ProductsDao productdao;
	
	@Autowired
	private UserRepository dao;

//	@RequestMapping("/")
//	public ModelAndView home() {
//		List<Product> Products = dao.findAll();
//		ModelAndView mv = new ModelAndView("index");
//
//		mv.addObject("products", Products);
//
//		return mv;
//
//	}
	
	@RequestMapping("/")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("list", productdao.findAll());
		return mv;
	}

	@RequestMapping("/register")
	public ModelAndView showRegister() {
		return new ModelAndView("register");
	}
	
//	@PostMapping("/register")
//	public ModelAndView register(User user) {
//		ModelAndView mv =new ModelAndView("sign-up");
//		
//		if(!user.getFirstname().equals("")) {
//			daoUser.create(user);
//			mv.addObject("user", user);
//		}
//		return mv;
//	}

	@Autowired
	private UserDao daoUser;

	@RequestMapping("/register-result")
	public ModelAndView add() {
		return new ModelAndView("register-result");
	}

	@PostMapping("/register-result")
	public ModelAndView addRegisterResult(User firstname, HttpSession session){ // add http session after users.
		daoUser.create(firstname);
		session.setAttribute("preference", firstname);
		return new ModelAndView("register-result");
	}
	
	@RequestMapping("/admin")
	public ModelAndView admin() {
		List<Product> Products = productdao.findAll();
		ModelAndView mv = new ModelAndView("admin");
		mv.addObject("products", Products);
		return mv;
	}
	
	@RequestMapping("/add")
	public ModelAndView addProduct() {
		return new ModelAndView("add");
	}
	
	@PostMapping("/add")
	public ModelAndView addItem(Product product) {
		productdao.create(product);
		return new ModelAndView("redirect:/admin");

	}
	
	@RequestMapping("/delete")
    public ModelAndView remove(@RequestParam("id") Long id) {
        productdao.delete(id);
        return new ModelAndView("redirect:/admin");
    }
	
	@RequestMapping("/login")
	public ModelAndView showLogin() {
		return new ModelAndView("login-form");
	}
	
	@PostMapping("/login")
	public ModelAndView submitLogin(
		@RequestParam("username") String username,
		@RequestParam("password") String password,
		HttpSession session
			) {
		
		System.out.println("In the controller.");
		
		// check the database for the user that matches both email and password
		User user = dao.findByUsernameAndPassword(username, password);
		System.out.println(user);
		
		// if not found, show the form again with error message
		if (user == null) {
			return new ModelAndView("login-form", "message", "Incorrect username or password.");
		}
		
		// "login" just means adding the user to the session
		session.setAttribute("preference", user);
		
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping("/logout")
	public ModelAndView logout(HttpSession session) {
		// This clears the session and starts a brand new clean one.
		session.invalidate();
		
		return new ModelAndView("redirect:/");
	}
	
	
}