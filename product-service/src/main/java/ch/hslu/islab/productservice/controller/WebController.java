package ch.hslu.islab.productservice.controller;

import java.security.Principal;
import ch.hslu.islab.productservice.dao.ProductDao;
import ch.hslu.islab.productservice.entities.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ch.hslu.islab.productservice.dao.CustomerDAO;
import ch.hslu.islab.productservice.entities.Customer;

@Controller
public class WebController {

  private static final Logger logger = LogManager.getLogger(WebController.class);

  @Autowired
  private ModelMapper modelMapper;

  @Autowired
  private CustomerDAO customerDAO;

  @Autowired
  private ProductDao productDao;

  @GetMapping(path = "/")
  public String index() {
    return "external";
  }
/*
  @GetMapping(path = "/products")
  public String customers(Principal principal, Model model) {
    addCustomers();
    Iterable<Customer> customers = customerDAO.findAll();
    model.addAttribute("customers", customers);
    if (principal != null) {
      model.addAttribute("username", principal.getName());
    }
    return "customers";
  }

 */

  @GetMapping(path = "/products")
  public String getProducts(Principal principal, Model model) {
    addProducts();
    Iterable<Product> products = productDao.findAll();
    model.addAttribute("products", products);
    if (principal != null) {
      model.addAttribute("username", principal.getName());
    }
    logger.info("Get all products" + products);
    return "products";
  }


/*
  @GetMapping(path = "/customers")
  public String getProductDtos(Principal principal, Model model) {
    addProducDto();
    Iterable<Product> products = productDao.findAll();
    List<ProductDto> productDtos = new ArrayList<>();
    for (Product productInList : products) {
      ProductDto productDto = modelMapper.map(productInList, ProductDto.class);
      productDtos.add(productDto);
      logger.info("Get all product of the product DB.");
    }
    model.addAttribute("productDtos", productDtos);
    if (principal != null) {
      model.addAttribute("username", principal.getName());
    }
    return "productDtos";
  }

 */

  public void addProducts(){
    Product product1 = new Product();
    product1.setDescription("Zahnpasta");
    product1.setPrice(10);
    productDao.save(product1);

    Product product2 = new Product();
    product2.setDescription("Barilla Pasta");
    product2.setPrice(35);
    productDao.save(product2);

    Product product3 = new Product();
    product3.setDescription("Rasenmäher");
    product3.setPrice(150);
    productDao.save(product3);
  }


  // add customers for demonstration
  public void addCustomers() {

    Customer customer1 = new Customer();
    customer1.setAddress("1111 foo blvd");
    customer1.setName("Foo Industries");
    customer1.setServiceRendered("Important services");
    customerDAO.save(customer1);

    Customer customer2 = new Customer();
    customer2.setAddress("2222 bar street");
    customer2.setName("Bar LLP");
    customer2.setServiceRendered("Important services");
    customerDAO.save(customer2);

    Customer customer3 = new Customer();
    customer3.setAddress("33 main street");
    customer3.setName("Big LLC");
    customer3.setServiceRendered("Important services");
    customerDAO.save(customer3);
  }
}
