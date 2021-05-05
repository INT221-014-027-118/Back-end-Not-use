package RefunGarantee.Int221.Controller;





import RefunGarantee.Int221.Exception.NotFoundImageException;
import RefunGarantee.Int221.Exception.SameImageException;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;


import java.io.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;


@RestController
@RequestMapping("/image")
@CrossOrigin(origins = "*")
public class ImagesController {



    private final Path path = Paths.get("images");
    private final Path path1 = Path.of("./images/");
    private final String path2 = "./images/";
    @GetMapping("/get/{id:.+}")
    public ResponseEntity<Resource> getImage(@PathVariable("id")String id) throws IOException {
        Path file = path.resolve(id);
        Resource resource = new UrlResource(file.toUri());
        Resource file1 = resource;
       System.out.println(file1.exists());
        System.out.println(file1.isReadable());
        if(file1.exists() || file1.isReadable()){
            return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(file1);
        }else

        throw new NotFoundImageException(id);
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @PostMapping ("/add")
    public ResponseEntity<Object> fileUpload(@RequestParam("refun")MultipartFile file)throws IOException{
        Path file1 = path.resolve(file.getOriginalFilename());
        Resource resource = new UrlResource(file1.toUri());
        File myFile = new File(resource.getURI());
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
        Path file1 = path.resolve(id);
        Path file2 = path.resolve(file.getOriginalFilename());
        Resource resource = new UrlResource(file1.toUri());
            File newFile = new File(file2.toUri());
            File oldFile = new File(file1.toUri());
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
    public void deleteImage(@PathVariable("id")String id) throws MalformedURLException {
        Path file = path.resolve(id);
        Resource resource = new UrlResource(file.toUri());
        //Resource file1 = resource;

            File myFile = new File(file.toUri());
            if(myFile.exists()) {
                myFile.delete();
            }else throw new NotFoundImageException(id);

        System.out.println(myFile.exists());
    }


}
