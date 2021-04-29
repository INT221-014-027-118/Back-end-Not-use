package RefunGarantee.Int221.Model;

import javax.persistence.*;

import lombok.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "type")
public class Type {
	
	@Id
	@Column(name = "typeid")
	private long typeId;
	
	@Column(name = "typename")
	private String typeName;


}
