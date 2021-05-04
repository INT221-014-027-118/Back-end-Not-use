package RefunGarantee.Int221.Controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import java.io.*;
import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/image")
@CrossOrigin(origins = "*")
public class ImagesController {


    List<String>  imagePath = null;
    private final String path = "./images/";

    @GetMapping("/get/{id:.+}")
    public ResponseEntity<byte[]> getImage(@PathVariable("id")String id) throws IOException {
        System.out.println(id);
        FileInputStream fi = new FileInputStream(path+id);
        byte[] image = fi.readAllBytes();
        fi.close();
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(image);
    }

    @PostMapping ("/add")
    public ResponseEntity<Object> fileUpload(@RequestParam("refun")MultipartFile file)throws IOException{
        System.out.println(file.getContentType());
        File myFile = new File(path + file.getOriginalFilename());
        myFile.createNewFile();
        FileOutputStream fos = new FileOutputStream(myFile);
        fos.write(file.getBytes());
        fos.close();


        return  new ResponseEntity<Object>("The File Uploaded Successfully", HttpStatus.OK);
    }

    @PutMapping("/update/{id:.+}")
    public void changeImage(@RequestParam("refun")MultipartFile file,@PathVariable("id")String id)throws IOException {
        FileOutputStream fos = new FileOutputStream(path+id);
        fos.write(file.getBytes());
        fos.close();
    }

    @DeleteMapping("/delete/{id:.+}")
    public void deleteImage(@PathVariable("id")String id){
            File myFile = new File(path + id);
            myFile.delete();
          


    }


}
