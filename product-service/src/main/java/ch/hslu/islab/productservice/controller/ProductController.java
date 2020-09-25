package ch.hslu.islab.productservice.controller;

import ch.hslu.islab.productservice.entities.Product;
import ch.hslu.islab.productservice.entities.ProductDto;
import ch.hslu.islab.productservice.repository.ProductRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

public class ProductController {

    private static final Logger logger = LogManager.getLogger(ProductController.class);

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;

    public void setModelMapper(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(
            method = RequestMethod.GET,
            path = "/products",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<ProductDto> getProductDtos() {
        List<Product> productList = productRepository.findAll();
        List<ProductDto> productDtos = new ArrayList<>();
        for (Product productInList : productList){
            ProductDto productDto = modelMapper.map(productInList, ProductDto.class);
            productDtos.add(productDto);
            logger.info("Get all product of the product DB.");
        }
        logger.info("The Size of the productDtoList is: " + productDtos.size());
        return productDtos;
    }

}
