package RefunGarantee.Int221.Controller;





import RefunGarantee.Int221.Exception.NotFoundImageException;
import RefunGarantee.Int221.Exception.SameImageException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import java.io.*;
import java.io.IOException;



@RestController
@RequestMapping("/image")
@CrossOrigin(origins = "*")
public class ImagesController {



    private final String path = "./images/";

    @GetMapping("/get/{id:.+}")
    public ResponseEntity<byte[]> getImage(@PathVariable("id")String id) throws IOException {
        FileInputStream fi = new FileInputStream(path+id);
        byte[] image = fi.readAllBytes();
        fi.close();
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(image);
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @PostMapping ("/add")
    public ResponseEntity<Object> fileUpload(@RequestParam("refun")MultipartFile file)throws IOException{
        File myFile = new File(path + file.getOriginalFilename());
        if(myFile.exists()) {
            throw new SameImageException(file.getOriginalFilename());
        }else
        myFile.createNewFile();
        FileOutputStream fos = new FileOutputStream(myFile);
        fos.write(file.getBytes());
        fos.close();
        return  new ResponseEntity<Object>("The File Uploaded Successfully", HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @PutMapping("/update/{id:.+}")
    public void changeImage(@RequestParam("refun")MultipartFile file,@PathVariable("id")String id)throws IOException {
            File newFile = new File(path + file.getOriginalFilename());
            File oldFile = new File(path + id);
            if(oldFile.exists()) {
                oldFile.delete();
                newFile.createNewFile();
                FileOutputStream fos = new FileOutputStream(newFile);
                fos.write(file.getBytes());
                fos.close();
                System.out.println("Success to update file");
            }else throw new NotFoundImageException(id);


    }

    @DeleteMapping("/delete/{id:.+}")
    public void deleteImage(@PathVariable("id")String id){
            File myFile = new File(path + id);
            if(myFile.exists()) {
                myFile.delete();
            }else throw new NotFoundImageException(id);

        System.out.println(myFile.exists());
    }


}
