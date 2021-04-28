package Refun.Int221;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Int221Application{
	
	@Autowired
	

	public static void main(String[] args) {
		SpringApplication.run(Int221Application.class, args);
	}
//
//	@Override
//	public void run(String... args) throws Exception {
//		String sql = "insert into brand VALUES (1,'Asus',null)";		
//		this.jdbcTemplate.update(sql);
//	}

}
