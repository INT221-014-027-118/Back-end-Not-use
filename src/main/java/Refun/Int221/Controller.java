package Refun.Int221;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	private List<Color>  colors = new ArrayList<>();
	private List<Mouse>  mouses = new ArrayList<>(); 
	private List<Keyboard>  keybords = new ArrayList<>(); 
	private List<Headset>  headsets = new ArrayList<>(); 
	private List<Brand> brand = new ArrayList<Brand>();
	private List<Product> product = new ArrayList<Product>();
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	


	public Controller() {
//		colors.add(new Color(1,"Black","#000000"));
//		colors.add(new Color(2,"Ivory","#fffff0"));
//		colors.add(new Color(3,"Gray79","#c9c9c9"));
//		mouses.add(new Mouse(1,"G703 LIGHTSPEED",3799.00,"25/4/2564","G703 LIGHTSPEED นำเสนอประสิทธิภาพรูปแบบเจเนอเรชันถัดไปด้วยเซ็น HERO 25K ขั้นสูง เตรียมพร้อมสำหรับสำหรับการติดตามที่ยกระดับไปอีกขั้น LIGHTSPEED ที่ได้รับการเพิ่มประสิทธิภาพ และประสิทธิภาพด้านพลังงาน 10 เท่าเมื่อเทียบกับเจเนอเรชันก่อนหน้า เพิ่ม POWERPLAY และไม่ต้องกังวลเรื่องการชาร์จอีกต่อไป และเติมสมรรถนะให้กับสุดยอดอุปกรณ์ LIGHTSPEED","logitech"));
//		mouses.add(new Mouse(2,"PRO X SUPERLIGHT",4990.00,"25/4/2564","ขจัดทุกอุปสรรคที่ขวางทางสู่ชัยชนะด้วยเมาส์ PRO ที่เร็วที่สุดและเบาที่สุดของเรา อาวุธใหม่ที่ยอดเยี่ยมสำหรับนักกีฬาอีสปอร์ตระดับมืออาชีพชั้นนำของโลก ด้วยน้ำหนักไม่ถึง 63 กรัม และมอบการเลื่อนที่เกือบไร้แรงเสียดทาน PRO X SUPERLIGHT สานต่อปรัชญาการออกแบบของเราที่ว่า ZERØ OPPOSITION หรือไร้คู่แข่ง ความมุ่งมั่นของเราคือการขจัดทุกอุปสรรค เพื่อสร้างสรรค์การเชื่อมต่อที่บริสุทธิ์ที่สุดระหว่างผู้เล่นและเกม","Logitech"));
//		mouses.add(new Mouse(3,"G502 LIGHTSPEED",5999.00,"25/4/2564","G502 คือไอคอนตัวอย่าง เป็นอันดับหนึ่งในทุกชาร์ทในทุกเจเนอเรชัน และเป็นตัวเลือกเมาส์สำหรับนักเล่นเกมตัวยง ขณะนี้ G502 ติดอันดับเมาส์เกมมิ่งไร้สายที่เหนือชั้นที่สุด ด้วยการเปิดตัว G502 LIGHTSPEED LIGHTSPEED รวดเร็วเป็นพิเศษและเชื่อถือได้ ด้วยประสิทธิภาพที่มือโปร E-Sport ให้ความไว้วางใจ G502 LIGHTSPEED ยังมาพร้อมกับเซ็นเซอร์ HERO 25K เจเนอเรชันใหม่ และเข้ากันได้กับ POWERPLAY ด้วยการปรับปรุงเทคโนโลยีขั้นสูงใหม่ทั้งหมดในครั้งนี้ G502 LIGHTSPEED ยังคงรูปทรงแบบเดิมที่เป็นที่ชื่นชอบเอาไว้อยู่ และลดน้ำหนักให้เหลือเพียง 7 กรัม","Logitech"));
	}
	
	@GetMapping("/color")
	public List<Color> getColor() {
		String sql = "select * from color;";
		this.colors = this.jdbcTemplate.query(sql,BeanPropertyRowMapper.newInstance(Color.class));
		return this.colors;
	}
	
	@GetMapping("/mouse")
	public List<Mouse> getMouse() {
		String sql = "select productId,productName,price,description,brandName,typeName from product p,type t,brand b where p.brandid = b.productid and"
				+ "p.typeid = t.typeid and typename = 'mouse';";
		this.mouses = this.jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Mouse.class));
		return this.mouses;
	}
	
	@GetMapping("/keybord")
	public List<Keyboard> getKeybord() {
		String sql = "select productId,productName,price,description,brandName,typeName from product p,type t,brand b where p.brandid = b.productid and"
				+ "p.typeid = t.typeid and typename = 'keybord';";
		this.keybords = this.jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Keyboard.class));
		return this.keybords;
	}
	
	
	@GetMapping("/headset")
	public List<Headset> getHeadset() {
		String sql = "select productId,productName,price,description,brandName,typeName from product p,type t,brand b where p.brandid = b.productid and"
				+ "p.typeid = t.typeid and typename = 'headset';";
		this.headsets = this.jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Headset.class));
		return this.headsets;
	}
	
	@GetMapping("/brand")
	public List<Brand> getBrand() {
		String sql = "select * from brand;";
		this.brand = this.jdbcTemplate.query(sql,BeanPropertyRowMapper.newInstance(Brand.class));
		return this.brand;
	}
	
	@PostMapping("/product/post")
	public void addProduct() {
		String sql = "INSERT INTO product (productId,productName,price,description,brandId,typeId,warranty,launchDate,imageUrl) VALUES"
				+ " (?,?,?,?,?,?,?,?,?);";
		this.jdbcTemplate.update(sql,"","","","","","","","","");
		
	}
	
	@DeleteMapping("/deleteProduct/{id}")
	public void deleteProduct(@PathVariable int id) {
		String sql = "DELETE FROM product WHERE productId = " + id;
		this.jdbcTemplate.execute(sql);
	}
	
	
	@PutMapping("/editProduct/{id}")
	public void editProduct() {
		
	}
	
	
//	@GetMapping("/mouse/post")
//	public  List<Mouse> getPostMouse() {
//		String sql = "select p.productid,price  from product p,type t where type_typeid = typeid and typename = 'mouse'";
//		this.mouses = this.jdbcTemplate.query(sql, );
//		return this.mouses;
//		
//	}
	
	
	

}
