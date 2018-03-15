package zw.co.tengahuku.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@ToString
@AllArgsConstructor
@Table(name="MANAGER")
public class Manager {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID")
	private int id;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="EMPLOYEE_ID")
	private Employee employee;
	@Column(name="DESIGNATION")
	private String designation;
	@Column(name="HEADED_DIVISION")
	private String headedDivision;
	@Column(name="CREATED_ON")
	private Date CreatedOn;
	@Column(name="LAST_UPDATED_BY")
	private Date lastUpdatedBy;
	

}
