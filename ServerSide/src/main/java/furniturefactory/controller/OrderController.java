package furniturefactory.controller;

import furniturefactory.domain.Department;
import furniturefactory.domain.Order;
import furniturefactory.dto.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import furniturefactory.service.OrderService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class OrderController {

    @Autowired
    @Qualifier(value = "ordrSrv")
    OrderService orderService;


    @RequestMapping(value = "/addOrder", method = RequestMethod.POST)
    public ResponseEntity<OrderDto> addOrder(@RequestBody OrderDto orderDto) {

        if (orderDto == null) {
            return new ResponseEntity<OrderDto>(HttpStatus.NOT_FOUND);
        }

        Order order = convertToEntity(orderDto);
        order = orderService.addOrder(order);
        orderDto = convertToDto(order);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Order created  - ", String.valueOf(orderDto.getId()));

        return new ResponseEntity<OrderDto>(orderDto, httpHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/getOrder/{id}", method = RequestMethod.GET)
    public ResponseEntity<OrderDto> getOrderById(@PathVariable long id) {

        Order order = orderService.getById(id);
        if (order == null) {
            return new ResponseEntity<OrderDto>(HttpStatus.NOT_FOUND);
        }

        OrderDto orderDto = convertToDto(order);

        return new ResponseEntity<OrderDto>(orderDto, HttpStatus.OK);
    }

    @RequestMapping(value = "/getAllOrders", method = RequestMethod.GET)
    public ResponseEntity<List<OrderDto>> getAllDepartments() {

        List<Order> orders= orderService.getAll();
        if (orders == null && orders.isEmpty()) {
            return new ResponseEntity<List<OrderDto>>(HttpStatus.NOT_FOUND);
        }

        List<OrderDto> orderDtos = new ArrayList<>();
        for (Order order : orders) {
            OrderDto orderDto = convertToDto(order);
            orderDtos.add(orderDto);
        }

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Department list  - ", String.valueOf(orderDtos.size()));

        return new ResponseEntity<List<OrderDto>>(orderDtos, httpHeaders, HttpStatus.OK);
    }

    @RequestMapping(value = "/updateOrder/{id}", method = RequestMethod.POST)
    public ResponseEntity<OrderDto> updateDepartment(@PathVariable long id,
                                                     @RequestBody OrderDto orderDto) {

        if (orderDto == null) {
            return new ResponseEntity<OrderDto>(HttpStatus.BAD_REQUEST);
        }

        Order isExist = orderService.getById(id);
        if (isExist == null) {
            return new ResponseEntity<OrderDto>(HttpStatus.NOT_FOUND);
        }

        Order order = convertToEntity(orderDto);
        order  = orderService.updateOrder(order);
        orderDto = convertToDto(order);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Order updated  - ", String.valueOf(orderDto));

        return new ResponseEntity<OrderDto>(orderDto, httpHeaders, HttpStatus.OK);
    }

    private OrderDto convertToDto(Order order) {
        OrderDto orderDto = new OrderDto(order.getId(), order.getName(), order.getDate(), order.getFinalDate(), order.isReady(), null, null );
        return  orderDto;
    }

    private Order convertToEntity(OrderDto orderDto) {
        Order order = new Order(orderDto.getId(), orderDto.getName(), orderDto.getDate(), orderDto.getFinalDate(), orderDto.isReady());
        return order;
    }
}
