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
import co.grandcircus.coffeeshopapp.entity.Product;
import co.grandcircus.coffeeshopapp.entity.User;

@Controller
public class CoffeeShopController {
	
	@Autowired
	private ProductsDao productdao;

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
}