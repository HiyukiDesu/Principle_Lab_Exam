package cp.lab.exam.service;

public class OrderNotFoundException extends RuntimeException{
	public OrderNotFoundException (Long id) {
		super("Could not found order "+id);
	}
}
