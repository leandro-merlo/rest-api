package br.com.manzatech.RestAPI.resources;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.manzatech.RestAPI.models.Product;
import br.com.manzatech.RestAPI.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductResource {

	@Autowired
	private ProductService productService;
	
	@GetMapping
	@ResponseBody
	
	public ResponseEntity<?> findAll() {
		return new ResponseEntity<List<?>>(productService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	public ResponseEntity<Product> find(@PathVariable Long id) {
		return new ResponseEntity<Product>(productService.find(id), HttpStatus.OK);
	}
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<?> create(@Valid @RequestBody Product product, Errors errors) {
		if (!errors.hasErrors()) {
			return new ResponseEntity<Product>(this.productService.create(product), HttpStatus.CREATED);
		}
		return ResponseEntity.badRequest().body(errors.getAllErrors().stream().map(msg -> msg.getDefaultMessage()).collect(Collectors.joining(",")));
	}
	
	@PutMapping("/{id}")
	@ResponseBody
	public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody Product product, Errors errors) {
		if (!errors.hasErrors()) {
			return new ResponseEntity<Product>(productService.update(id, product), HttpStatus.OK);
		}
		return ResponseEntity.badRequest().body(errors.getAllErrors().stream().map(msg -> msg.getDefaultMessage()).collect(Collectors.joining(",")));
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code= HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		productService.delete(id);
	}
}
