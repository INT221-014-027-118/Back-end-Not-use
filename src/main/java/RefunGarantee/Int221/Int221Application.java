package RefunGarantee.Int221;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;


@SpringBootApplication
public class Int221Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Int221Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String dir = "./images";
		File file = new  File(dir);
		file.mkdir();
	}
}
