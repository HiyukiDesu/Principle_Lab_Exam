package cp.lab.exam.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import cp.lab.exam.model.OrderLine;
import cp.lab.exam.service.OrderLineService;

@RestController
@RequestMapping("/api/orderlines")
public class OrderLineController {

    private final OrderLineService orderLineService;

    public OrderLineController(OrderLineService orderLineService) {
        this.orderLineService = orderLineService;
    }

    @GetMapping
    public ResponseEntity<List<OrderLine>> getOrderLines() {
        List<OrderLine> orderLines = orderLineService.getOrderLines();
        return new ResponseEntity<>(orderLines, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderLine> getOrderLineById(@PathVariable("id") Long Id){
        OrderLine orderLine = orderLineService.getOrderLineById(Id);
        return new ResponseEntity<>(orderLine, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<OrderLine> addOrderLine(@RequestBody OrderLine orderLine) {
        OrderLine savedOrderLine = orderLineService.addOrderLine(orderLine);
        return new ResponseEntity<>(savedOrderLine, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderLine> updateOrderLine(@RequestBody OrderLine newOrderLine, @PathVariable Long id) {
        OrderLine updatedOrderLine = orderLineService.updateOrderLine(id, newOrderLine);
        return ResponseEntity.ok(updatedOrderLine);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrderLine(@PathVariable Long id) {
        orderLineService.deleteById(id);
        return ResponseEntity.ok("OrderLine deleted successfully");
    }
}
