package RefunGarantee.Int221.Controller;

import RefunGarantee.Int221.Model.Product;
import RefunGarantee.Int221.Model.Type;
import RefunGarantee.Int221.Repository.ColorRepository;
import RefunGarantee.Int221.Repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/type")
@CrossOrigin(origins = "*")
public class TypeController {

    @Autowired
    private TypeRepository typeRepository;

    @GetMapping("/list")
    public List<Type> getProduct() {
        return typeRepository.findAll();

    }

}
