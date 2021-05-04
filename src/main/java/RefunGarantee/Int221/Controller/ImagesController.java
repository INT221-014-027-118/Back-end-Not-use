package RefunGarantee.Int221.Controller;



import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import java.io.*;
import java.io.IOException;



@RestController
@RequestMapping("/image")
public class ImagesController {


    private final String path = "./images";

    @GetMapping("/get/{id:.+}")
    public ResponseEntity<byte[]> getImage(@PathVariable("id")String id) throws IOException {
        System.out.println(id);
        FileInputStream fi = new FileInputStream(path+id);
        byte[] image = fi.readAllBytes();
        fi.close();
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(image);
    }

    @PostMapping ("/add/{id}")
    public ResponseEntity<Object> fileUpload(@RequestParam("File")MultipartFile file,@PathVariable("id")String id)throws IOException{
        System.out.println(file.getContentType());
        File myFile = new File(path + file.getOriginalFilename());
        myFile.createNewFile();
        FileOutputStream fos = new FileOutputStream(myFile);
        fos.write(file.getBytes());
        fos.close();
        return  new ResponseEntity<Object>("The File Uploaded Successfully", HttpStatus.OK);
    }

    @PutMapping("/edit/{id:.+}")
    public void changeImage(@RequestParam("File")MultipartFile file,@PathVariable("id")String id)throws IOException {
        FileOutputStream fos = new FileOutputStream(path+id);
        fos.write(file.getBytes());
        fos.close();
    }

    @DeleteMapping("/delete/{id:.+}")
    public void deleteImage(@PathVariable("id")String id){
        String idString[] = id.split("\\.(?=[^\\.]+$)");
            File myFile = new File(path + id);
            myFile.delete();

    }


}