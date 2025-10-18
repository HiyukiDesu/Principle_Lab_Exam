package cp.lab.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cp.lab.exam.model.OrderLine;

@Repository
public interface OrderLineRepository extends JpaRepository<OrderLine,Long>{

}
