package ch.hslu.islab.productservice.entities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {

    private static final Logger logger = LogManager.getLogger(Product.class);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;

    @Column
    private String description;

    @Column
    private Integer price;


    public Product() { }

    public Product(Integer productId, String description, Integer price) {
        this.productId = productId;
        this.description = description;
        this.price = price;
    }

    public Integer getProductId() {
        logger.info("Get productId " + productId);
        return productId;
    }

    public void setProductId(Integer productId) {
        logger.info("Set productId " + productId);
        this.productId = productId;
    }

    public String getDescription() {
        logger.info("Get description " + description);
        return description;
    }

    public void setDescription(String description) {
        logger.info("Set description " + description);
        this.description = description;
    }

    public Integer getPrice() {
        logger.info("Get price " + price);
        return price;
    }

    public void setPrice(Integer price) {
        logger.info("Set price " + price);
        this.price = price;
    }
}
