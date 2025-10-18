package cp.lab.exam.service;

public class OrderLineNotFoundException extends RuntimeException{
	public OrderLineNotFoundException (Long id) {
		super("Could not found order_line "+id);
	}
}
