package furniturefactory.service;

import furniturefactory.domain.Order;

import java.util.List;

public interface OrderService {

    Order addOrder(Order order);    // create
    Order getById(long id);         // retrieve
    List<Order> getAll();
    Order updateOrder(Order order); // update
    void  delete(long id);          // delete

}
