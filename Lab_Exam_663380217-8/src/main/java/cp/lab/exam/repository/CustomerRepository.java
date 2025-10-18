package cp.lab.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cp.lab.exam.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long>{

}
