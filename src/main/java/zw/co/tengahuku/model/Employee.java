package zw.co.tengahuku.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@ToString
@AllArgsConstructor
@Table(name="EMPLOYEE")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID")
	private Long id;
	
	@Column(name="FIRST_NAME")
	private String firstname;
	
	@Column(name="MIDDLE_NAME")
	private String middleName;
	
	@Column(name="SURNAME")
	private String surname;
	
	@Column(name="START_DATE")
	private Date startDate;
	
	@Column(name="BIRTH_DATE")
	private Date birthDate;
	
	@Column(name="DEPARTMENT")
	private String department;
	
	@Column(name="JOB_TITLE")
	private String jobTitle;
	
	@Column(name="RATE_PER_HOUR")
	private String ratePerHour;
	
	@Column(name="HOME_ADDRESS")
	private String homeAddress;
	
	@Column(name="CELL_NUMBER")
	private String cellNumber;
	
	@Column(name="EMAIL")
	private String emailAddress;
	
	@Column(name="NEXT_OF_KIN")
	private String nextOfKinFullName;
	
	@Column(name="NEXT_OF_KIN_CELL")
	private String nextOfKinCellNumber;
	
	@Column(name="EMPLOYEE_ENABLED")
	private Boolean enabled;
	
	@Column(name="EMPLOYEE_SALARY")
	private Double monthlySalary;
	
	
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private Order order;
	
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private Manager manager;
	
	

}
