package zw.co.tengahuku.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@ToString
@AllArgsConstructor
@Table(name="DELIVERER")
public class Deliverer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID")
	private Long id;
	@Column(name = "COMPANY_NAME", nullable = false)
	private String companyName;
	@Column(name = "DRIVER_NAME", nullable = false)
	private String delivererDriverName;
	@Column(name = "CONTACT_NUMBER", nullable = false)
	private String contactNumber;
	@Column(name = "EMAIL_ADDRESS", nullable = false)
	private String emailAddres;
	@Column(name = "CREATED_ON", nullable = false)
	private Date createdOn;
	@Column(name = "ACTIVATED", nullable = false)
	private Boolean activated;

}
