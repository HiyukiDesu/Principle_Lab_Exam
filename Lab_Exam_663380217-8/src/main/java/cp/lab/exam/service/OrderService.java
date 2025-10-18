package cp.lab.exam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cp.lab.exam.repository.OrderRepository;
import cp.lab.exam.model.Order;
import cp.lab.exam.model.OrderLine;

@Service
public class OrderService {
	@Autowired
    OrderRepository orderRepo;

    public List<Order> getOrders() {
    	List<Order> orders = orderRepo.findAll();
        for (Order order : orders) {
            order.setTotalPrice(calculateTotal(order));
        }
        return orders;
    }

    public Order getOrderById(Long id) {
    	Order order = orderRepo.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));
        order.setTotalPrice(calculateTotal(order));
        return order;
    }
    
    public void save(Order o) {
    	orderRepo.save(o);
	}
    
    public Order addOrder(Order order) {
        return orderRepo.save(order);
    }

    public void deleteById(Long id) {
        Order order = orderRepo.findById(id).orElseThrow(() ->
            new OrderNotFoundException(id));
        orderRepo.delete(order);
    }
    
    public static double calculateTotal(Order order) {
        return order.getOrderLine().stream()
                .filter(ol -> ol.getProduct() != null)
                .mapToDouble(ol -> ol.getQty() * ol.getProduct().getPrice())
                .sum();
    }
    
    public Order updateOrder(Long id, Order o) {
        Order existingOrder = orderRepo.findById(id).get();
        //existingOrder.setId(o.getId());
        existingOrder.setCustomer(o.getCustomer());
        existingOrder.getOrderLine().clear();
        if (o.getOrderLine() != null) {
            for (OrderLine ol : o.getOrderLine()) {
                ol.setOrder(existingOrder);
                existingOrder.getOrderLine().add(ol);
            }
        }
        return orderRepo.save(existingOrder);
    }

    
}
