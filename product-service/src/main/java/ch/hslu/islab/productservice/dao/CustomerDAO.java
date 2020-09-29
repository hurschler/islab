package ch.hslu.islab.productservice.dao;

import org.springframework.data.repository.CrudRepository;
import ch.hslu.islab.productservice.entities.Customer;

public interface CustomerDAO extends CrudRepository<Customer, Long> {

}
