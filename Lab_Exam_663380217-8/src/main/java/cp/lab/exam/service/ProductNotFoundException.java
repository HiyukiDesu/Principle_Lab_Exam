package cp.lab.exam.service;

public class ProductNotFoundException extends RuntimeException{
	public ProductNotFoundException (Long id) {
		super("Could not found product "+id);
	}
}
