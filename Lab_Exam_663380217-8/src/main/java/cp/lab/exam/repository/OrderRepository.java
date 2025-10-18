package cp.lab.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cp.lab.exam.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {

}
