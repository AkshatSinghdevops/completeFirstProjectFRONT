package com.niit.shoppingcart.homecontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.domain.Category;
import com.niit.shoppingcart.domain.Product;
import com.niit.shoppingcart.domain.Supplier;
import com.niit.shoppingcart.util.FileUtil;
import com.niit.shoppingcart.util.Util;

@Controller
public class ProductController {
	
	
	@Autowired
	private ProductDAO productDAO;

	@Autowired
	private Product product;
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	
	@Autowired
	private Category category;
	

	@Autowired
	private SupplierDAO supplierDAO;
	
	
	@Autowired
	private Supplier supplier;	 private String path   ="D://akshat_project_files//21042017_FrontEndSecurityButNotWorking-master//src//main//webapp//resources//images";

	
		

	
 	@RequestMapping(value = "/manage_products", method = RequestMethod.GET)
	public String listProducts(Model model) {
		//log.debug("Starting of the method listProducts");
		model.addAttribute("product", new Product());
		/*model.addAttribute("category", new Category());
		model.addAttribute("supplier", new Supplier());*/
		model.addAttribute("productList", this.productDAO.list());
		/*model.addAttribute("categoryList", this.categoryDAO.list());
		model.addAttribute("supplierList", this.supplierDAO.list());*/
		model.addAttribute("isAdminClickedProducts", "true");
		//log.debug("Ending of the method listProducts");
		return "/Admin/Product";
	}

	// For add and update product both
	@RequestMapping(value = "/manage_product_add", method = RequestMethod.POST)
	public String addProduct(@ModelAttribute("product") Product product,
			 @RequestParam("file") MultipartFile file, Model model) {
	
		
		//log.debug("Starting of the method addProduct");
		Category category = categoryDAO.getCategoryByName(product.getCategory().getName());
		// categoryDAO.saveOrUpdate(category); // why to save??

		Supplier supplier = supplierDAO.getSupplierByName(product.getSupplier().getname());
		// supplierDAO.saveOrUpdate(supplier); // Why to save??

		product.setCategory(category);
		product.setSupplier(supplier);

		product.setCategory_id(category.getId());
		product.setSupplier_id(supplier.getId());
		//product.setId(Util.removeComman(Product.getId()));
		productDAO.save(product);

		FileUtil.upload(path, file, product.getId() + ".jpg");
		//log.debug("Ending of the method addProduct");
		model.addAttribute("isAdminClickedProducts", "true");
		model.addAttribute("productList", this.productDAO.list());
		model.addAttribute("product", new Product());
		model.addAttribute("categoryList", this.categoryDAO.list());
		model.addAttribute("category", new Category());
		
		return "/Admin/AdminHome";
		// return "redirect:/uploadFile";

	}

	/*@RequestMapping(value = "/manage_products",method = RequestMethod.GET)
	public String listProducts(Model model) {
		log.debug(" Starting of the method listProduct");
		model.addAttribute("product", product);
		model.addAttribute("ProductList", productDAO.list());
		model.addAttribute("isAdminClickedProduct", "true");
		log.debug(" End of the method listProduct");
		return "/Admin/Product";
	}
	
	//private String path   ="C://Users//mr10//divya//ShoppingcartFrontend//src//main//webapp//resources//images";

	// handing product submission
		@RequestMapping(value="/products", method=RequestMethod.POST)
		public String handleProductSubmission(@Valid @ModelAttribute("product") Product Product, BindingResult results, Model model, 
				HttpServletRequest request){
			
			// handle image validation for new products
			if(product.getId() == "0")
			{
				new Product().validate(product, results);
			}
			else
			{
				if(!Product.getFile().getOriginalFilename().equals(""))
				{
					new ProductValidator().validate(Product, results);

				}
			}
			// check if there are any errors
			if(results.hasErrors())
			{
				model.addAttribute("isUserClickedManageProducts",true);
				model.addAttribute("title","Manage Products");
				model.addAttribute("message","Validation failed for Product Submission!");
				
				return "Admin/AdminHome";
			}
			
			
			logger.debug(product.toString());
			
			
			if(Product.getId() == "0")
			{
				//create a new product record if id is 0
				productDAO.add(product);
			}
			else
			{
				//update the product if id is not 0
				productDAO.update(product);
			}
			
			if(!Product.getFile().getOriginalFilename().equals(""))
			{
				FileUtil.uploadFile(request,Product.getFile(), product.getFile());
			}
			
			return "redirect:/manage/products?operation=product";
		}
		*/

	
	@RequestMapping("manage_products_remove/{ID}")
//	public ModelAndView deleteProduct(@PathVariable("id") String id, Model model) throws Exception {
	public String deleteProduct(@PathVariable("id") String id, Model model) throws Exception {
		boolean flag = productDAO.delete(id);

		String msg = "Successfully done the operation";
		if (flag != true) {
			msg = "The operation could not success";
		}
		/*
		 * model.addAttribute("product", product);
		 * model.addAttribute("categoryList", this.productDAO.list());
		 */
		model.addAttribute("msg", msg);
	//	ModelAndView mv = new ModelAndView("forward:/manage_categories");
		//return mv;

		return "forward:/manage_products";
	}

	@RequestMapping("manage_product_edit/{ID}")
	public String editProduct(@PathVariable("ID") String id, Model model) {
		// productDAO.saveOrUpdate(product);
		//log.debug(" Starting of the method editProduct");

		product = productDAO.get(id);
		//model.addAttribute("product", product);
		//log.debug(" End of the method editProduct");
		return "forward:/manage_products";
	}
	


}
