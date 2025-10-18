package cp.lab.exam.service;

public class CustomerNotFoundException extends RuntimeException{
	public CustomerNotFoundException (Long id) {
		super("Could not found customer "+id);
	}
}
