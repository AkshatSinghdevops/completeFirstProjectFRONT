package com.niit.shoppingcart.homecontroller;

import java.util.Collection;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.MycartDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.domain.Mycart;
import com.niit.shoppingcart.domain.Product;
import com.niit.shoppingcart.domain.User;

@Controller
public class MycartController {
	
	@Autowired
	private MycartDAO mycartDAO;

	@Autowired
	private Mycart myCart;

	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private User user;
	
	@Autowired UserDAO userDAO;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping(value = "/myCart/add/{id}", method = RequestMethod.GET)
	public ModelAndView addToCart(@PathVariable("id") String id) {
		
		//session.getAttribute("loggedInUser");
		// get the product based on product id
		ModelAndView mv = new ModelAndView("redirect:/Mycart");

		Product product = productDAO.getProductById(id);
		
		myCart.setPrice((int) product.getPrice());
		
		myCart.setProduct_name(product.getName());
		
		String loggedInUserid = (String) session.getAttribute("loggedInUserID");
		
		if (loggedInUserid == null) {
		
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			//loggedInUserid = auth.getName();
			
		}
		myCart.setUser_id(loggedInUserid);
		
		//It is not required if you given default value while creating the table
		
		myCart.setStatus('N'); // Status is New. Once it is dispatched, we can
								// changed to 'D'
		myCart.setDate_added(new Date());
		
		if(myCart.getQuantity()== 0){
			myCart.setQuantity(1);
		}
		
		
		
		//To get sequence number, you can do programmatically in DAOImpl
		//myCart.setId(ThreadLocalRandom.current().nextLong(100, 1000000 + 1));

		
		mycartDAO.save(myCart);
		// return "redirect:/views/home.jsp";

		/*ModelAndView mv = new ModelAndView("forward:/myCart");*/
		//ModelAndView mv = new ModelAndView("redirect:/myCart");
		/*ModelAndView mv = new ModelAndView("/home");*/
		mv.addObject("successMessage", " Successfuly add the product to myCart");
				return mv;

	}
	@RequestMapping("/remove/{id}")
	public ModelAndView RemoveFromCart(@PathVariable("id")Long id ){
		
		System.out.println("Staring of remove Method");
		myCart.setId(id);
		System.out.println("id is " + id);
		mycartDAO.delete(myCart);
		System.out.println("id is by delete method " + id);
		ModelAndView mv = new ModelAndView("redirect:/Mycart");
		mv.addObject("successMessage", " Successfuly delete one product from myCart");
		//log.debug("Ending of remove Method");
		
		return mv;
		
		
	}
	
	/*
	@RequestMapping("/remove/all/{id}")
	public ModelAndView Removeall(@PathVariable("id") String id ){
		
		log.debug("Staring of removeall method	");
		
		cartDAO.list(userId);
		
		ModelAndView mv = new ModelAndView("redirect:/myCart");
		mv.addObject("successMessage", " Successfuly delete one product from myCart");
		log.debug("Staring of remove Method");
		
		return mv;
		
		
	}
	
	*/
	
	
	
	@RequestMapping(value = "/details_get/myCart/add/{id}", method = RequestMethod.GET)
	public ModelAndView fromProductCart(@PathVariable("id") String id) {
		
		
		// get the product based on product id
		
		Product product = productDAO.getProductById(id);
		
		myCart.setPrice( (int)product.getPrice());
		
		myCart.setProduct_name(product.getName());
		
		String loggedInUserid = (String) session.getAttribute("isUserLoggedIn");
		
		if (loggedInUserid == null) {
		
			//Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			//loggedInUserid = auth.getName();
			
		}
		myCart.setUser_id(loggedInUserid);
		
		//It is not required if you given default value while creating the table
		
		myCart.setStatus('N'); // Status is New. Once it is dispatched, we can
								// changed to 'D'
		myCart.setDate_added(new Date());
		
		if(myCart.getQuantity()== 0){
			myCart.setQuantity(1);
		}
		
		
		
		//To get sequence number, you can do programmatically in DAOImpl
		//myCart.setId(ThreadLocalRandom.current().nextLong(100, 1000000 + 1));

		
		mycartDAO.save(myCart);
		// return "redirect:/views/home.jsp";

		/*ModelAndView mv = new ModelAndView("forward:/myCart");*/
		ModelAndView mv = new ModelAndView("redirect:/Mycart");
		mv.addObject("successMessage", " Successfuly add the product to myCart");
		
		return mv;

	}
	


}
