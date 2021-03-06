package RefunGarantee.Int221.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import RefunGarantee.Int221.Model.Color;

import RefunGarantee.Int221.Repository.ColorRepository;

@RestController
@RequestMapping("/color")
@CrossOrigin(origins = "*")
public class ColorController {
	
	@Autowired
	private ColorRepository colorRepository;
	
	@GetMapping("/list")
	public List<Color> getColor(){
		return colorRepository.findAll();
	}

}
