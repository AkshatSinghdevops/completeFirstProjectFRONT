package com.niit.shoppingcart.homecontroller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.OrdersDAO;
import com.niit.shoppingcart.domain.Orders;

@Controller
public class CheckoutPageController {
	
	@Autowired 
	private Orders Orders;
	
	@Autowired 
	private OrdersDAO ordersDAO;
	
	
	 @RequestMapping(value = "/Checkout", method=RequestMethod.POST )
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
				@ModelAttribute("ex_year")int ex_year
				)
		{
			
		 orders.setFull_name(full_name);	
		orders.setAddress(address);
		orders.setCard_cvv(card_cvv);
		orders.setCard_number(card_number);
		orders.setCard_type(card_type);
		orders.setCity(city);
		orders.setCountry(country);
		orders.setEmail(email);
		
		orders.setEx_month(ex_month);
		orders.setState(state);
		orders.setPhone_number(phone_number);
		orders.setZip_code(zip_code);
		orders.setEx_year(ex_year);
			
			ModelAndView mv = new ModelAndView("/lastPage");
			
			mv.addObject("orders",orders);
			
			
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
	
	
	

}
