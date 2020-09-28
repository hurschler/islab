package ch.hslu.islab.orderservice.controller;

import ch.hslu.islab.orderservice.dtos.OrderDto;
import ch.hslu.islab.orderservice.entities.Order;
import ch.hslu.islab.orderservice.repository.OrderRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class OrderController {

    private static final Logger logger = LogManager.getLogger(OrderController.class);


    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ModelMapper modelMapper;

    @CrossOrigin(origins = "*")
    @RequestMapping(
            method = RequestMethod.GET,
            path = "/orders",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<OrderDto> getOrderDtos(){
        List<OrderDto> orderDtoList = new ArrayList<>();
        List<Order> orders = orderRepository.findAll();
        for (Order orderInList : orders) {
            OrderDto orderDto = modelMapper.map(orderInList, OrderDto.class);
            orderDtoList.add(orderDto);
            logger.info("Get all orders from orderDb. OrderId is: " + orderDto.getOrderId());
        }
        logger.info("Size of orderDtoList: " + orderDtoList.size());
        return orderDtoList;
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(
            method = RequestMethod.GET,
            path = "/orders/{orderId}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public OrderDto getOrderByIdDto(@PathVariable("orderId") Integer orderId){
        Optional<Order> order = orderRepository.findById(orderId);
        logger.info("Get order by Id from orderDb. OrderId is: " + orderId);
        logger.info(order.get());
        return modelMapper.map(order.get(), OrderDto.class);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(
            method = RequestMethod.POST,
            path = "/orders",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public OrderDto saveOrder(@RequestBody OrderDto orderDto) throws Exception {
        Order order = modelMapper.map(orderDto, Order.class);
        Order orderTemp = orderRepository.save(order);
        logger.info("Save order on orderDb. orderId is: " + order.getOrderId());
        return modelMapper.map(orderTemp, OrderDto.class);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(
            method = RequestMethod.DELETE,
            path = "/orders/{orderId}"
    )
    public void deleteOrder(@PathVariable("orderId") Integer orderId){
        orderRepository.deleteById(orderId);
        logger.info("Delete order on orderDb. OrderId is: " + orderId);
    }
}
