/**
 * 
 */
package mockito_assignment.mockito_assignment;

/**
 * 
 */
import java.util.List;

public class OrderManager {

    private OrderDao orderDao;

    public OrderManager(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public List<Order> getAllOrders() {
        return orderDao.getAllOrders();
    }

    public boolean addOrder(Order order) {
        orderDao.logAction("Order Placed");
        return orderDao.addOrder(order);
    }

    public boolean cancelOrder(int orderId) {
        orderDao.logAction("Order Cancelled");
        return orderDao.cancelOrder(orderId);
    }

    
    protected String getOfferType() {
        return "Normal Offer";
    }

    public double processOrder(Order order) {
        String offerType = getOfferType();
        double price = order.getPrice();

        if ("Festival Offer".equals(offerType)) {
            return price * 0.8; // 20% discount
        } else {
            return price * 0.9; // 10% discount
        }
    }

    
    public static double calculateDiscount(double price) {
        return price * 0.9;
    }
}
