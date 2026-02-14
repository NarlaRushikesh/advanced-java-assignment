/**
 * 
 */
package mockito_assignment.mockito_assignment;

/**
 * 
 */
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OrderManagerTest {

	@Spy
	private OrderDao orderDao = new OrderDao();

    @InjectMocks
    private OrderManager orderManager;

    // 1. Fetch all orders
    @Test
    void testGetAllOrders() {
        List<Order> orders = Arrays.asList(
                new Order(1, "KFC", "Burger", 200),
                new Order(2, "Dominos", "Pizza", 500)
        );

        doReturn(orders).when(orderDao).getAllOrders();

        List<Order> result = orderManager.getAllOrders();

        assertEquals(2, result.size());
        verify(orderDao).getAllOrders();
    }


    // 2. Add order
    @Test
    void testAddOrder() {
        Order order = new Order(1, "KFC", "Burger", 200);

        doReturn(true).when(orderDao).addOrder(order);
        doNothing().when(orderDao).logAction(anyString());

        boolean result = orderManager.addOrder(order);

        assertTrue(result);
        verify(orderDao).addOrder(order);
        verify(orderDao).logAction("Order Placed");
    }


    // 3. Cancel order
    @Test
    void testCancelOrder() {
        doReturn(true).when(orderDao).cancelOrder(1);
        doNothing().when(orderDao).logAction(anyString());

        boolean result = orderManager.cancelOrder(1);

        assertTrue(result);
        verify(orderDao).cancelOrder(1);
        verify(orderDao).logAction("Order Cancelled");
    }


    // 4. Static discount calculation
    @Test
    void testStaticDiscountCalculation() {
        try (MockedStatic<OrderManager> mockedStatic = mockStatic(OrderManager.class)) {
            mockedStatic.when(() -> OrderManager.calculateDiscount(1000))
                        .thenReturn(900.0);

            double discountedPrice = OrderManager.calculateDiscount(1000);

            assertEquals(900.0, discountedPrice);
        }
    }

    // 5. Final method
    @Test
    void testFinalDatabaseInfo() {
        String dbInfo = orderDao.getDatabaseInfo();
        assertNotNull(dbInfo);
        assertTrue(dbInfo.contains("MySQL"));
    }

    // 6. Void logging method
    @Test
    void testVoidLoggingMethod() {
        doNothing().when(orderDao).logAction(anyString());
        orderDao.logAction("Order Placed");
        verify(orderDao).logAction("Order Placed");
    }

    // 7. Processing orders using Spy
    @Test
    void testProcessOrderWithFestivalOffer() {
        Order order = new Order(1, "Dominos", "Pizza", 1000);

        OrderManager spyManager = spy(orderManager);
        doReturn("Festival Offer").when(spyManager).getOfferType();

        double finalPrice = spyManager.processOrder(order);

        assertEquals(800.0, finalPrice);
    }
}

