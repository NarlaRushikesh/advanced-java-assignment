/**
 * 
 */
package mockito_assignment.mockito_assignment;

/**
 * 
 */

import java.util.List;

public class OrderDao {

    public List<Order> getAllOrders() {
        throw new UnsupportedOperationException("Database not implemented");
    }

    public boolean addOrder(Order order) {
        throw new UnsupportedOperationException("Database not implemented");
    }

    public boolean cancelOrder(int orderId) {
        throw new UnsupportedOperationException("Database not implemented");
    }

    // FINAL METHOD
    public final String getDatabaseInfo() {
        return "DB: MySQL | Host: localhost | Port: 3306";
    }

    // VOID METHOD
    public void logAction(String message) {
        System.out.println("LOG: " + message);
    }
}

