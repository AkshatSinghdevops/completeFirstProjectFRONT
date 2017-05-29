package com.niit.shoppingcart.homecontroller;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.MycartDAO;
import com.niit.shoppingcart.dao.OrdersDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.domain.Category;
import com.niit.shoppingcart.domain.Mycart;
import com.niit.shoppingcart.domain.Orders;
import com.niit.shoppingcart.domain.Product;
import com.niit.shoppingcart.domain.Supplier;
import com.niit.shoppingcart.domain.User;

@Controller
public class homeController {
	

	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private User user;
	
	@Autowired
	private Category category; 
	
	@Autowired
	private CategoryDAO categoryDAO;;
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private Supplier supplier;
	
	@Autowired
	private SupplierDAO  supplierDAO;
	
	@Autowired
	private Product product;
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private Mycart mycart;
	
	@Autowired
	private MycartDAO  mycartDAO;
	
	@Autowired 
	private Orders orders;
	
	@Autowired 
	private OrdersDAO ordersDAO;
	
	
	@RequestMapping(value={("/"),("index")})
	public ModelAndView showHomePage()
	{
		
		//Specifying which page you have navigateion
		ModelAndView mv = new ModelAndView("/index");
		 List<Category> categoryList=	categoryDAO.list();
		  mv.addObject("categoryList", categoryList);
		  mv.addObject("category", category);//To access category domain object in category.jsp
		  
		  List<Supplier> supplierList  = supplierDAO.list();
			mv.addObject("supplierList" , supplierList);
			mv.addObject("supplier" , supplier);
			
		 List<Product> productList =  productDAO.list();
			 mv.addObject("productList",productList);
			 mv.addObject("product",product);
		//Specify what data you have to carry to home page
		
		mv.addObject("msg", "WELCOME TO SHOPPING CART");
		
		return mv;
	}
	@RequestMapping("/Login")
	public ModelAndView showLoginPage()
	{
		ModelAndView mv = new ModelAndView("/index");
		mv.addObject("msg", "  WELCOME TO LOGIN PAGE");
		mv.addObject("isUserClickedLogin","true");
		session.getAttribute("loginMessage");
		return mv;
	}

	@RequestMapping("/Registration")
	public ModelAndView showRegistrationPage()
	{
		ModelAndView mv = new ModelAndView("/index");
		mv.addObject("msg", "  WELCOME TO Registration page ");
		mv.addObject("isUserClickedRegistration","true");
		mv.addObject("user",user);
		return mv;
	}
	
	
	@RequestMapping(value = "/Registration" , method=RequestMethod.POST)
	public ModelAndView registerPage(@ModelAttribute User user,    @ModelAttribute("id")String id,@ModelAttribute("name")String name,
			@ModelAttribute("password")String password,@ModelAttribute("mail")String mail,@ModelAttribute("contact")String contact)
	{
		
	      user.setId(id);
	      user.setMail(mail);
	      user.setName(name);
	      user.setPassword(password);
	      user.setContact(contact);
	      user.setRole("ROLE_USER");
	      
	      
	      
	      ModelAndView mv = new ModelAndView("redirect:/index");
	      mv.addObject("isUserClickedRegistration","true");
	  	mv.addObject("msg", "  WELCOME TO Registration page ");
	  	mv.addObject("user",user);
	      if(userDAO.save(user))
	      {
	    	  mv.addObject("successR", "Success To Registration");
	      }
	      else
	      {
	    	  mv.addObject("errorR" ,"you are not Register go to Page Contact or About us ");
	      }
	      return mv;
	
	}
	
	
	@RequestMapping("/Contact")
	public ModelAndView showContactPage()
	{
		ModelAndView mv = new ModelAndView("/index");
		mv.addObject("msg", " Hey Hello Brother , WELCOME TO LOGIN PAGE");
		mv.addObject("isUserClickedContact","true");
		return mv;
	}
	@RequestMapping("/Menu")
	public ModelAndView showMenuPage()
	{
		ModelAndView mv = new ModelAndView("/index");
		mv.addObject("msg", " Hey Hello Brother , WELCOME TO LOGIN PAGE");
		mv.addObject("isUserClickedMenu","true");
		return mv;
	}
	
	


	/*@RequestMapping("/validate")
	public ModelAndView validateCredentials(@RequestParam(value="id") String id,@RequestParam(value="password") String pwd)
	{

		
		//Actually you have get the data from DB
		//Tempororily  -user->niit password =niit@123
		
		ModelAndView mv = new ModelAndView("/index");
		mv.addObject("isUserLoggedIn", "false");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		if( userDAO.validate(id, pwd)==true)
		
		{
			//Createntials are correct
			mv.addObject("isUserLoggedIn", "true");
			
			user = userDAO.getUser(id);
			
			if(user.getRole().equals("ROLE_ADMIN"))
			{   
				mv.addObject("isAdmin", "true");
				mv.addObject("role", "Admin");
				session.setAttribute("isAdmin", "true");
				session.setAttribute("AdminLoggedIn","true");
			}
			else
			{
				mv.addObject("isAdmin", "false");
				mv.addObject("role", "User");
				List<Mycart> mycartList  = mycartDAO.list();
				mv.addObject("mycartList" , mycartList);
				mv.addObject("mycart" , mycart);
				
				
				
				List<Mycart> cartList = mycartDAO.list(id);
				mv.addObject("cartList"	, cartList);
				mv.addObject("cartSize", cartList.size());
				mv.addObject("totalAmount",mycartDAO.getTotalAmount(id));
				
				
			} 
			
			mv.addObject("successMessage", "Valid Credentials");
			session.setAttribute("loginMessage", "Welcome :" +id);
			
		}
		else
		{
			mv.addObject("errorMessage", "InValid Credentials...please try again");
		}
		session.setAttribute("loggedInUserID", id );
		return mv;
		
		
	}*/
	/*
	@RequestMapping("/logout")
	public ModelAndView showlogout()
	{
		ModelAndView mv = new ModelAndView("forward:/");
		session.removeAttribute("loginMessage");
		
		
		session.setAttribute("category", category);
		session.setAttribute("categoryList", categoryDAO.list());
		return mv;
				
	}*/
	
	@RequestMapping("/Mycart")
	public ModelAndView showMycart()
	{
		ModelAndView mv = new ModelAndView("/index");
		mv.addObject("isUserClickedMycart", "true");
	
		
		
		/*List<Mycart> mycartList  = mycartDAO.list();
		mv.addObject("mycartList" , mycartList);
		mv.addObject("mycart" , mycart);
		*/
		
		List<Mycart> mycartList = mycartDAO.list((String) session.getAttribute("loggedInUserID"));
		mv.addObject("mycartList"	, mycartList);
		mv.addObject("mycartSize", mycartList.size());
		mv.addObject("totalAmount",mycartDAO.getTotalAmount( (String) session.getAttribute("loggedInUserID")));
		
		
		return mv;
	}
	
	
	
	
	
	
	
	@RequestMapping("/lastPage")
	public ModelAndView showlastPage()
	{

		System.out.println("This is ***************lastPage");
		
		String loggedInUserid = (String) session.getAttribute("loggedInUserID");
		
		System.out.println("the logged in ********USER ID***********"+ loggedInUserid );
		
		if (loggedInUserid == null) {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			loggedInUserid = auth.getName();
			Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>)   auth.getAuthorities();
			authorities.contains("ROLE_USER");
			
		}
		
		System.out.println("the logged in ********USER ID***********"+ loggedInUserid );
		
		List<Mycart> cartlist = mycartDAO.list(loggedInUserid);
		
		int catsize = mycartDAO.list(loggedInUserid).size();
		
		System.out.println("the ****SIZE IS******"+catsize);
	
		for(Mycart listall : cartlist)
		{
			
			mycart.setId(listall.getId());
			
			mycartDAO.delete(mycart);
			
			System.out.println("****THE CATSIZE**** "+catsize);
		}
		
		ModelAndView mv = new ModelAndView("lastPage");
		
		System.out.println("This is end ************of lastpage");
		return mv;
	}

	
	@RequestMapping("/CheckoutPage")
	public ModelAndView showCheckoutPage() {

		System.out.println("**Starting OF ***************CHECK****OUT PAGE");
		ModelAndView mv = new ModelAndView("/CheckoutPage");
		
		mv.addObject("orders",orders);
		
		mv.addObject("isUserClikedCheckout", "true");
		System.out.println("**Ending  OF ***************CHECK****OUT PAGE");
		return mv;
	}
	
	@RequestMapping("/NextPage")
	public ModelAndView nextpage() {
		
		ModelAndView mv = new ModelAndView("/NextPage");
		return mv;
	}
	
	
	
	
	
	 @RequestMapping(value = "/NavigationPro/{id}", method = RequestMethod.GET)
	    public ModelAndView showNaviPRO(@PathVariable("id") String id)
	    {
	    	
	    	ModelAndView mv = new ModelAndView("forward:/index");
	    	//product = productDAO.get(id);
	    	Product product = productDAO.getProductById(id);
	    	
	    	//session.setAttribute("isProductClicked","true");
			mv.addObject("product",  productDAO.getProductById(id));
	    	
	    	 List<Product> productList =  productDAO.list();
			 mv.addObject("productList",productList);
			 mv.addObject("product",product);
	    	
	    	return mv;
	    	
	    }
	
	
	
	
	
	
	/* @RequestMapping(value = "/CheckoutPage", method=RequestMethod.GET )
		public ModelAndView registerPage(@ModelAttribute Orders orders,   
				
				@ModelAttribute("full_name")String full_name,
				@ModelAttribute("address")String address,
				@ModelAttribute("country")String country,
				@ModelAttribute("city")String city,
				@ModelAttribute("state")String state,
				@ModelAttribute("email")String email,
				@ModelAttribute("zip_code")int zip_code,
				@ModelAttribute("phone_number")int phone_number,
				@ModelAttribute("card_type")String card_type,
				@ModelAttribute("card_number")int card_number,
				@ModelAttribute("card_cvv")int card_cvv,
				@ModelAttribute("ex_month")int ex_month,
				@ModelAttribute("ex_year")int ex_year,
				@RequestParam String action)
		{
			
			
		order.setAddress(address);
		order.setCard_cvv(card_cvv);
		order.setCard_number(card_number);
		order.setCard_type(card_type);
		order.setCity(city);
		order.setCountry(country);
		order.setEmail(email);
		order.setFull_name(full_name);
		order.setEx_month(ex_month);
		order.setState(state);
		order.setPhone_number(phone_number);
		order.setZip_code(zip_code);
		order.setEx_year(ex_year);
			
			ModelAndView mv = new ModelAndView("/index");
			
			 if(ordersDAO.save(orders))
		      {
			
				mv.addObject("message", "Successfully created the category");
			}
			else
			{
				mv.addObject("message", "Not able to create Category.  Pl contact Administrator");
			}
			
			return mv;
			
		}
	
	
	*/
	
	
	
	
	
	 
}
