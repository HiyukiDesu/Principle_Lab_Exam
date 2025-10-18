package cp.lab.exam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cp.lab.exam.model.Product;
import cp.lab.exam.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
    ProductRepository productRepo;

    public List<Product> getProducts() {
        return productRepo.findAll();
    }

    public Product getProductById(Long id) {
        return productRepo.findById(id).orElseThrow(() ->
            new ProductNotFoundException(id));
    }
    
    public void save(Product p) {
    	productRepo.save(p);
	}
    
    public Product addProduct(Product product) {
        return productRepo.save(product);
    }

    public void deleteById(Long id) {
        Product product = productRepo.findById(id).orElseThrow(() ->
            new ProductNotFoundException(id));
        productRepo.delete(product);
    }

    public Product updateProduct(Long id, Product p) {
        Product existingProduct = productRepo.findById(id).get();
        //existingProduct.setId(p.getId());
        existingProduct.setName(p.getName());
        existingProduct.setOrderLine(p.getOrderLine());
        existingProduct.setPrice(p.getPrice());
        return productRepo.save(existingProduct);
    }
}

