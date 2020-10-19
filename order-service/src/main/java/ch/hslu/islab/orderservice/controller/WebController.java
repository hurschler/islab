package ch.hslu.islab.orderservice.controller;

import ch.hslu.islab.orderservice.dao.OrderDao;
import ch.hslu.islab.orderservice.entities.Order;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class WebController {

  private static final Logger logger = LogManager.getLogger(WebController.class);

  @Autowired
  private OrderDao orderDao;

  @GetMapping(path = "/")
  public String index() {
    return "external";
  }

  @GetMapping(path = "/orders")
  public String getOrders(Principal principal, Model model) {
    addOrders();
    Iterable<Order> orders = orderDao.findAll();
    model.addAttribute("orders", orders);
    if (principal != null) {
      model.addAttribute("username", principal.getName());
    }
    logger.info("Get all orders" + orders);
    return "orders";
  }


  public void addOrders(){

    Order order1 = new Order();
    order1.setOrderId(1);
    order1.setProductId(4480);
    orderDao.save(order1);

    Order order2 = new Order();
    order2.setOrderId(2);
    order2.setProductId(5530);
    orderDao.save(order2);

    Order order3 = new Order();
    order3.setOrderId(3);
    order3.setProductId(1020);
    orderDao.save(order3);
  }
}
