package br.com.manzatech.RestAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.manzatech.RestAPI.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
