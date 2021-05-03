package RefunGarantee.Int221.Model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product {

	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "productid",nullable = false, unique = true)
	private long productId;


	@Column(name = "productname" ,nullable = false, unique = true)
	private String productName;


	@Column(name = "price")
	private double price;


	@Column(name = "description")
	private String description;

	@ManyToOne
	@JoinColumn(name = "brandid")
	private Brand brand;

	@ManyToOne
	@JoinColumn(name = "typeid")
	private Type type;


	@Column(name = "warranty")
	private int warranty;


	@Column(name = "launchdate")
	private Date launchDate;


	@Column(name = "imageurl")
	private String imageUrl;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "productcolor", joinColumns = @JoinColumn(name = "productid"), inverseJoinColumns = @JoinColumn(name = "colorid"))
	private List<Color> colors = new ArrayList<>();

//	public Product(String productName, double price, String description, Brand brand, Type type, int warranty, Date launchDate, String imageUrl, List<Color> colors) {
//		this.productName = productName;
//		this.price = price;
//		this.description = description;
//		this.brand = brand;
//		this.type = type;
//		this.warranty = warranty;
//		this.launchDate = launchDate;
//		this.imageUrl = imageUrl;
//		this.colors = colors;
//	}
}
