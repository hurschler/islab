package ch.hslu.islab.productservice.dao;

import ch.hslu.islab.productservice.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductDao extends CrudRepository<Product, Long>{
}
