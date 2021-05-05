package RefunGarantee.Int221.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import RefunGarantee.Int221.Exception.NotFoundException;
import RefunGarantee.Int221.Exception.NotFoundNameException;
import RefunGarantee.Int221.Exception.SameProductNameException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import RefunGarantee.Int221.Model.Product;
import RefunGarantee.Int221.Repository.ProductRepository;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "*")
public class ProductController {

    Product p;
    List<Long> list = new ArrayList<Long>();

    @Autowired
    private ProductRepository productRepository;

    //Get all Product
    @GetMapping("/list")
    public List<Product> getProduct() {
        return productRepository.findAll();

    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable(value = "id") long id) {
        if (this.productRepository.existsById(id)) {
            return productRepository.findById(id);
        } else
            throw new NotFoundException(id);

    }

    //Edit Product
    @PutMapping("/update")
    public Product editProduct(@RequestBody Product products) {
        this.productRepository.save(products);
        return products;
    }

    //Delete Product
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable long id) {
        if (this.productRepository.existsById(id)) {
            this.productRepository.deleteById(id);
        } else
            throw new NotFoundException(id);
    }

    //Add Product
   @ResponseStatus(HttpStatus.FORBIDDEN)
    @PostMapping("/add")
    public void addProduct(@RequestBody Product products) {
        Boolean b = false;
        for (int i = 0; i < productRepository.count(); i++) {
            if (productRepository.findAll().get(i).getProductName().equals(products.getProductName()) || products.getProductId() <=0) {
                b = true;
                throw new SameProductNameException(products.getProductName());
            }
        }if (b == false){
            productRepository.save(products);
       }

    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @GetMapping("getbyname/{name}")
    public Product getProductByName(@PathVariable("name") String name) {
        Product product = null;
        for (int i = 0; i < this.productRepository.count(); i++) {
            if (this.productRepository.findAll().get(i).getProductName().equals(name)) {
                product = this.productRepository.findAll().get(i);
            }
        }if(product == null){
            throw new NotFoundNameException(name);
        }
        return product;
    }

    @GetMapping("id/list")
    public List<Long> getProductId() {
        list.clear();
        for (int i = 0; i < productRepository.count(); i++) {
            list.add(productRepository.findAll().get(i).getProductId());
        }
        return list;
    }

}
