package com.bel.training.ims.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bel.training.ims.exception.ResourceNotFoundException;
import com.bel.training.ims.model.Product;
import com.bel.training.ims.repository.ProductRepository;

@RestController
@RequestMapping(value="/api")
public class ProductRestController {

	@Autowired
	private ProductRepository prepo;
	
	@GetMapping("/products")
	public List<Product> getAllProducts()
	{
		return prepo.findAll();
	}
	
	 /** 
	  * ResponseEntity represents an HTTP response, including headers, body, and status.
	  */
	 @GetMapping("/products/{id}")
		public ResponseEntity<Product> getProductById(@PathVariable(value = "id") Long pId)
				throws ResourceNotFoundException {
			Product product = prepo.findById(pId)
					.orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + pId));
			return ResponseEntity.ok().body(product);
		}
	 // @RequestBody annotation automatically deserializes the JSON into a Java type
	 @PostMapping("/products")  
	    public Product saveProduct(@Validated @RequestBody Product product) {  
		 return prepo.save(product)  ;
	       	          
	    } 
	 @PutMapping("/products/{id}")
	    public ResponseEntity<Product> updateProduct(@PathVariable(value = "id") Long pId,
				@Validated @RequestBody Product p) throws ResourceNotFoundException {
	     
		 Product product = prepo.findById(pId)
					.orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + pId));
		 
		    		    
		    product.setBrand(p.getBrand());
		    product.setMadein(p.getMadein());
		    product.setName(p.getName());
		    product.setPrice(p.getPrice());
		    
		    final Product updatedProduct = prepo.save(product);
			return ResponseEntity.ok(updatedProduct);
	    }
	 @DeleteMapping("/products/{id}")
	    public Map<String, Boolean> deleteProduct(@PathVariable(value = "id") Long pId) 
	    		throws ResourceNotFoundException{
		 Product product = prepo.findById(pId)
					.orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + pId));
	        prepo.delete(product);
	        
	        Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return response;
	 }
}
