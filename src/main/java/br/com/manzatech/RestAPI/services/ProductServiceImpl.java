package br.com.manzatech.RestAPI.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.manzatech.RestAPI.models.Product;
import br.com.manzatech.RestAPI.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public List<Product> findAll() {
		return this.productRepository.findAll();
	}

	@Override
	public Product find(Long id) {
		return this.productRepository.findById(id).get();
	}

	@Override
	public Product create(Product product) {
		productRepository.save(product);
		return product;
	}

	@Override
	public Product update(Long id, Product product) {
		Product p = productRepository.getOne(id);
		if (p != null) {
			product.setId(id);
			productRepository.save(product);
			return product;
		}
		return null;
	}

	@Override
	public void delete(Long id) {
		Product p = productRepository.getOne(id);
		if (p != null) productRepository.delete(p);
	}

}
