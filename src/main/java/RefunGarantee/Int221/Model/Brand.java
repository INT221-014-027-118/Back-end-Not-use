package RefunGarantee.Int221.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "brand")
public class Brand {

	@Id
	@Column(name = "brandid")
	private long brandId;


	@Column(name = "brandname")
	private String brandName;


}
