 package com.niit.shoppingcart.homecontroller;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.MycartDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.domain.Category;
import com.niit.shoppingcart.domain.Mycart;
import com.niit.shoppingcart.domain.Product;
import com.niit.shoppingcart.domain.Supplier;
import com.niit.shoppingcart.domain.User;



@Controller
public class SpringSecurityController {

	//public static Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserDAO userDAO;
	

	@Autowired
	private User user;

//	@Autowired
//	private CartDAO cartDAO;
//
//	@Autowired
//	private MyCart myCart;
	
	@Autowired
	private Mycart mycart;
	
	@Autowired
	private MycartDAO  mycartDAO;
	
	@Autowired
	private Category category;
	
	@Autowired
	private  CategoryDAO categoryDAO;

	
	@Autowired
	private HttpSession session;
	
	/*@RequestMapping(value = "validate", method = RequestMethod.GET)
	public ModelAndView validate(HttpServletRequest request ,HttpServletRequest response) throws Exception
	{
		
		ModelAndView mv = new ModelAndView("/index");
		
		Authentication auth= SecurityContextHolder.getContext().getAuthentication();
		
		String userID = auth.getName();
		System.out.println( userID );
		session.setAttribute("loggedInUser", userID );
		
		if(request.isUserInRole("ROLE_ADMIN"))
		{
			System.out.println("Logged in as Admin");
			session.setAttribute("isAdmin", "true");
			session.setAttribute("AdminLoggedIn","true");
		}
		else{
			System.out.println("Logged in as User");
			session.setAttribute("isAdmin", "false");
			
			List<Mycart> mycartList  = mycartDAO.list();
			mv.addObject("mycartList" , mycartList);
			mv.addObject("mycart" , mycart);
			//mv.addObject("cartSize", cartList.size());
			//mv.addObject("totalAmount",cartDAO.getTotalAmount(userID));
			
		}
		mv.addObject("successMessage", "Valid Credentials ");
	    session.setAttribute("loginMessage", "Welcome :" + userID);
	    
	    session.setAttribute("loggedInUser", userID );
	    
		
		return mv;
	}*/
	
	//authentication-failure-forward-url="/loginError"
		@RequestMapping(value = "/loginError", method = RequestMethod.GET)
		public String loginError(Model model) {
			System.out.println("Starting of the method loginError");
			model.addAttribute("errorMessage", "Invalid Credentials.  Please try again.");
			System.out.println("Ending of the method loginError");
			return "/index";

		}
	//<security:access-denied-handler error-page="/accessDenied" />
		@RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
		public String accessDenied(Model model) {
			System.out.println("Starting of the method accessDenied");
			model.addAttribute("errorMessage", "You are not authorized to access this page");
			System.out.println("Ending of the method accessDenied");
			return "/index";

		}
		
		/*@RequestMapping("/logout")
		public ModelAndView logout() {
			System.out.println("Starting of the method logout");
			ModelAndView mv = new ModelAndView("forward:/");
			session.invalidate(); // will remove the attributes which are added
									// session
			session.setAttribute("category", category);
			session.setAttribute("categoryList", categoryDAO.list());

			mv.addObject("logoutMessage", "You successfully logged out");
			mv.addObject("loggedOut", "true");
			
		    
			return mv;
		}*/


}
