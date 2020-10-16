package ch.hslu.islab.productservice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProductServiceApplication {

    private final static Logger logger = LogManager.getLogger(ProductServiceApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
        logger.info("Product-Service started successfully.");
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
