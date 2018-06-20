package furniturefactory.serviceImpl;

import furniturefactory.dao.OrderDao;
import furniturefactory.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import furniturefactory.service.OrderService;

import java.util.List;

public class OrderServiceImpl implements OrderService {

    @Autowired
    @Qualifier(value = "ordrDao")
    OrderDao orderDao;

    @Override
    public Order addOrder(Order order) {
        order = orderDao.create(order);
        return order;
    }

    @Override
    public Order getById(long id) {
        Order order = orderDao.findOne(id);
        return order;
    }

    @Override
    public List<Order> getAll() {
        List<Order> orders = orderDao.findAll();
        return orders;
    }

    @Override
    public Order updateOrder(Order order) {
        order = orderDao.update(order);
        return order;
    }

    @Override
    public void delete(long id) {

    }
}
