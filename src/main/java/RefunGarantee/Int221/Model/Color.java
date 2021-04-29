package RefunGarantee.Int221.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "color")
public class Color {
	
	@Id
	@Column(name = "colorid")
	private long colorId;
	

	@Column(name = "colorname")
	private String colorName;
	

	@Column(name = "hexcolor")
	private String hexColor;


}
