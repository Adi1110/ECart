package com.ecommerce.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.ecommerce.beans.Product;

public class ProductDao {

	JdbcTemplate template;  
	  
	public void setTemplate(JdbcTemplate template) {  
	    this.template = template;  
	}  
	
	public int save(Product p){  
	    String sql="insert into product(name,price,quantity,description) values('"+p.getName()+"',"+p.getPrice()+",'"+p.getQuantity()+"','"+p.getDescription()+"')";  
	    return template.update(sql);  
	}  
	public int update(Product p){  
	    String sql="update product set name='"+p.getName()+"', price='"+p.getPrice()+"',quantity='"+p.getQuantity()+"',description='"+p.getDescription()+"' where id="+p.getId()+"";  
	    return template.update(sql);  
	}  
	public int delete(int id){  
	    String sql="delete from product where id="+id+"";  
	    return template.update(sql);  
	}  
	public Product getProductById(int id){  
	    String sql="select * from product where id=?";  
	    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Product>(Product.class));  
	}  
	public List<Product> getProduct(){  
	    return template.query("select * from employee",new RowMapper<Product>(){  
	        public Product mapRow(ResultSet rs, int row) throws SQLException {  
	        	Product e=new Product();  
	            e.setId(rs.getInt(1));  
	            e.setName(rs.getString(2));  
	            e.setPrice(rs.getFloat(3));  
	            e.setQuantity(rs.getInt(4));
	            e.setDescription(rs.getString(5));
	            return e;  
	        }  
	    });  
	} 
}
