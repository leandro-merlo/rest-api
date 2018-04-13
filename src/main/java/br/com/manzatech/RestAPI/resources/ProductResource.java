package br.com.manzatech.RestAPI.resources;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.manzatech.RestAPI.models.Product;

@RestController
@RequestMapping("/product")
public class ProductResource {

	@GetMapping
	@ResponseBody
	public List<Product> findAll() {
		return null;
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	public Product find(@PathVariable Long id) {
		return null;
	}
	
	@PostMapping
	@ResponseBody
	public Product create(Product product) {
		return null;
	}
	
	@PutMapping("/{id}")
	@ResponseBody
	public Product update(@PathVariable Long id, Product product) {
		return null;
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		
	}
}
