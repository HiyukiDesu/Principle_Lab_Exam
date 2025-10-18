package cp.lab.exam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cp.lab.exam.repository.OrderLineRepository;
import cp.lab.exam.model.OrderLine;

@Service
public class OrderLineService {
	@Autowired
    OrderLineRepository orderLineRepo;

    public List<OrderLine> getOrderLines() {
        return orderLineRepo.findAll();
    }

    public OrderLine getOrderLineById(Long id) {
        return orderLineRepo.findById(id).orElseThrow(() ->
            new OrderLineNotFoundException(id));
    }
    
    public void save(OrderLine ol) {
    	orderLineRepo.save(ol);
    }
    
    public OrderLine addOrderLine(OrderLine ol) {
        return orderLineRepo.save(ol);
    }

    public void deleteById(Long id) {
        OrderLine orderLine = orderLineRepo.findById(id).orElseThrow(() ->
            new OrderLineNotFoundException(id));
        orderLineRepo.delete(orderLine);
    }

    public OrderLine updateOrderLine(Long id, OrderLine ol) {
        OrderLine existingOrderLine = orderLineRepo.findById(id).get();
        //existingOrderLine.setId(ol.getId());
        existingOrderLine.setQty(ol.getQty());
        existingOrderLine.setOrder(ol.getOrder());
        existingOrderLine.setProduct(ol.getProduct());
        return orderLineRepo.save(existingOrderLine);
    }
}

