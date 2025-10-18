package cp.lab.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cp.lab.exam.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long>{

}
