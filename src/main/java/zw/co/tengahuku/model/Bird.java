package zw.co.tengahuku.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@ToString
@AllArgsConstructor
@Table(name="BIRD")
public class Bird {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="BIRD_TYPE")
	private Boolean birdType;
	
	@Column(name="RFID_TAG_NUMBER")
	private Long rfidTagNumber;
	
	@Column(name="PURCHASE_DATE")
	private Date purchaseDate;
	
	@Column(name="BREED_NAME")
	private String breedName;
	
	@Column(name="SUPPLIER_NAME")
	private String supplierName;
	
	//TODO: broiler -0, 1 - layer	

}
