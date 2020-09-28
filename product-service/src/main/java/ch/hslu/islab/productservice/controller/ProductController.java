package ch.hslu.islab.productservice.controller;

import ch.hslu.islab.productservice.entities.Product;
import ch.hslu.islab.productservice.dtos.ProductDto;
import ch.hslu.islab.productservice.repository.ProductRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
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

    @CrossOrigin(origins = "*")
    @RequestMapping(
            method = RequestMethod.GET,
            path = "/products/{productId}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ProductDto getProductDtoById(@PathVariable("productId") Integer productId) {
        Optional<Product> product = productRepository.findById(productId);
        logger.info("Get product by Id from productDb. ProductId is: " + productId);
        logger.info(product.get());
        return modelMapper.map(product.get(), ProductDto.class);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(
            method = RequestMethod.POST,
            path = "/products",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ProductDto saveProduct(@RequestBody ProductDto productDto){
        Product product = modelMapper.map(productDto, Product.class);
        Product productTemp = productRepository.save(product);
        logger.info("Saved product on productDb. ProductId is: " + product.getProductId());
        return modelMapper.map(productTemp, ProductDto.class);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(
            method = RequestMethod.DELETE,
            path = "/products/{productId}"
    )
    public void deleteProduct(@PathVariable("productId") Integer productId) {
        productRepository.deleteById(productId);
        logger.info("Deleted product on productDb. ProductId is: " + productId);
    }

}
