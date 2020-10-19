package ch.hslu.islab.orderservice.dao;

import ch.hslu.islab.orderservice.entities.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderDao extends CrudRepository<Order, Long> {
}
