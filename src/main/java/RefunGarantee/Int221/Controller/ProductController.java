package RefunGarantee.Int221.Controller;

import java.util.List;
import java.util.Optional;
import RefunGarantee.Int221.Exception.NotFoundException;
import RefunGarantee.Int221.Exception.SameProductNameException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@GetMapping("/{id}")
	public Optional<Product> getProductById(@PathVariable long id) {
		if(this.productRepository.existsById(id) ){
			Optional<Product> p = productRepository.findById(id) ;
			return p;
		}else
			throw new NotFoundException(id);

	}

	@PutMapping("/update")
	public Product editProduct(@RequestBody Product products) {
		this.productRepository.save(products);
		return products;
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/delete/{id}")
	public void deleteProduct(@PathVariable long id) {
        if(this.productRepository.existsById(id) ){
        	this.productRepository.deleteById(id);
        }else
        throw new NotFoundException(id);
	}

	@PostMapping("/add")
	public Product addProduct(@RequestBody Product products) {
		for(int i =0 ;i < productRepository.count(); i++){
			if(!productRepository.findAll().get(i).getProductName().equals(products.getProductName()) ){

				this.productRepository.save(products);
			}else
			throw new SameProductNameException(products.getProductName());
		}
		return products;

	}

	@GetMapping("/name")
	public void getProductName() {
		for(int i =0 ;i < productRepository.count(); i++){
		System.out.println(productRepository.findAll().get(i).getProductName());
	}}

}
