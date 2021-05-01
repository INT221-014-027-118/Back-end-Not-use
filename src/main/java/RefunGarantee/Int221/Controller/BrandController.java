package RefunGarantee.Int221.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import RefunGarantee.Int221.Model.Brand;

import RefunGarantee.Int221.Repository.BrandRepository;


@RestController
@RequestMapping("/brand")
@CrossOrigin(origins = "*")
public class BrandController {
	
	@Autowired
	private BrandRepository brandRepository ;
	
	@GetMapping("/list")
	public List<Brand> getBrand() {
		return brandRepository.findAll();

	}



}
