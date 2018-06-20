package furniturefactory.dao;


import furniturefactory.domain.Order;

public class OrderDaoImpl extends GenericaDaoImpl<Order> implements OrderDao {

    public void beanInit() {
        this.setClazz(Order.class);
    }

}
