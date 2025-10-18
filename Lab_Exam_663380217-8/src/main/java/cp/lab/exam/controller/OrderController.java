package cp.lab.exam.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cp.lab.exam.service.OrderService;
import cp.lab.exam.model.Order;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
	private final OrderService orderService;
	
	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}
	
	@GetMapping
	public ResponseEntity<List<Order>> getOrder(){
		List<Order> orders = orderService.getOrders();
		return new ResponseEntity<>(orders, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Order> getOrderById(@PathVariable("id") Long Id){
		Order orders = orderService.getOrderById(Id);
		return new ResponseEntity<>(orders, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Order> addNewOrder(@RequestBody Order order) {
		System.out.println(order);
		Order saveOrder = orderService.addOrder(order);
		return new ResponseEntity<>(saveOrder, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Order> updateOrder(@RequestBody Order newOrder, @PathVariable Long id) {
		Order updateOrder = orderService.updateOrder(id, newOrder);
		return ResponseEntity.ok(updateOrder);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteOrder(@PathVariable Long id) {
		orderService.deleteById(id);
		return ResponseEntity.ok("Order deleted successfully");
	}
}
