package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ecommerce.beans.Product;
import com.ecommerce.dao.ProductDao;



public class ProductController {

	@Autowired  
	ProductDao dao;
    @RequestMapping("/empform")  
    public String showform(Model m){  
    	m.addAttribute("command", new Product());
    	return "empform"; 
    }  
    
    @RequestMapping(value="/save",method = RequestMethod.POST)  
    public String save(@ModelAttribute("pr") Product pr){  
        dao.save(pr);  
        return "redirect:/viewemp";//will redirect to viewemp request mapping  
    }  
     
    @RequestMapping("/viewemp")  
    public String viewemp(Model m){  
        List<Product> list=dao.getProduct();  
        m.addAttribute("list",list);
        return "viewemp";  
    }  
    
    @RequestMapping(value="/editemp/{id}")  
    public String edit(@PathVariable int id, Model m){  
    	Product pr=dao.getProductById(id);  
        m.addAttribute("command",pr);
        return "empeditform";  
    }  
    /* It updates model object. */  
    @RequestMapping(value="/editsave",method = RequestMethod.POST)  
    public String editsave(@ModelAttribute("emp") Product pr){  
        dao.update(pr);  
        return "redirect:/viewemp";  
    }  
    
    @RequestMapping(value="/deleteemp/{id}",method = RequestMethod.GET)  
    public String delete(@PathVariable int id){  
        dao.delete(id);  
        return "redirect:/viewemp";  
    }  
}
