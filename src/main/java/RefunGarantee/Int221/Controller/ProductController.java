package RefunGarantee.Int221.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import RefunGarantee.Int221.Model.Product;
import RefunGarantee.Int221.Repository.ProductRepository;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping("/list")
	public List<Product> getProduct() {
		return productRepository.findAll();

	}

	@PutMapping("/update")
	public Product editProduct(@RequestBody Product products) {
		this.productRepository.save(products);
		return products;
	}

	@DeleteMapping("/delete/{id}")
	public void deleteProduct(@PathVariable long id) {
        this.productRepository.deleteById(id);

	}

	@PostMapping("/add")
	public Product addProduct(@RequestBody Product products) {
             this.productRepository.save(products);
		     return products;
	}

}
