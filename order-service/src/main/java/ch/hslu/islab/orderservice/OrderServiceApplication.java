package ch.hslu.islab.orderservice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OrderServiceApplication {

	private static final Logger logger = LogManager.getLogger(OrderServiceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
		logger.info("OrderServiceApplication started successfully.");
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
