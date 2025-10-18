package cp.lab.exam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cp.lab.exam.model.Customer;
import cp.lab.exam.model.Order;
import cp.lab.exam.repository.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	CustomerRepository customerRepo;
	
	public List<Customer> getCustomers(){
		List<Customer> customers = (List<Customer>) customerRepo.findAll();
		for (Customer c : customers) {
	        for (Order o : c.getOrders()) {
	            o.setTotalPrice(OrderService.calculateTotal(o));
	        }
	    }
		return customers;
	}
	
	public Customer getCustomerById(Long id){
		return customerRepo.findById(id).orElseThrow(()->
		new CustomerNotFoundException(id));
	}	 
	
	public void save(Customer c) {
		customerRepo.save(c);
	}
	
	public Customer addCustomer(Customer customer) {
	    return customerRepo.save(customer);
	}
	
	public void deleteById(Long id) {
		Customer customer = customerRepo.findById(id).orElseThrow(()->
		new CustomerNotFoundException(id));
		
		customerRepo.delete(customer);
	}
	
	public Customer updateCustomer(Long id,Customer c) {
		Customer existingCustomer = customerRepo.findById(id).get();
		//existingCustomer.setId(c.getId());
		existingCustomer.setName(c.getName());
		existingCustomer.setOrders(c.getOrders());
		return customerRepo.save(existingCustomer);
	}
}
