package ch.hslu.islab.orderservice.entities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

    private static final Logger logger = LogManager.getLogger(Order.class);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;

    @Column
    private Integer productId;

    public Order(){}

    public Order(Integer orderId, Integer productId){
        this.orderId = orderId;
        this.productId = productId;
    }

    public Integer getOrderId() {
        logger.info("Get orderId " + orderId);
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        logger.info("setOrderId " + orderId);
        this.orderId = orderId;
    }

    public Integer getProductId() {
        logger.info("Get productId " + productId);
        return productId;
    }

    public void setProductId(Integer productId) {
        logger.info("Set productId " + productId);
        this.productId = productId;
    }
}
