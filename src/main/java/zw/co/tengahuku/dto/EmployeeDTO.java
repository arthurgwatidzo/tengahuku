package zw.co.tengahuku.dto;

import java.util.Date;

public class EmployeeDTO {

	private Long id;
	private String firstname;
	private String middleName;
	private String surname;
	private Date startDate;
	private Date birthDate;
	private String department;
	private String jobTitle;
	private String ratePerHour;
	private String homeAddress;
	private String cellNumber;
	private String emailAddress;
	private String nextOfKinFullName;
	private String nextOfKinCellNumber;
	private Boolean enabled;
	private OrderDTO order;
	private Double monthlySalary;
	
	

	public EmployeeDTO(Long id, String firstname, String middleName, String surname, Date startDate, Date birthDate,
			String department, String jobTitle, String ratePerHour, String homeAddress, String cellNumber,
			String emailAddress, String nextOfKinFullName, String nextOfKinCellNumber, Boolean enabled, OrderDTO order,
			Double monthlySalary) {
		this.id = id;
		this.firstname = firstname;
		this.middleName = middleName;
		this.surname = surname;
		this.startDate = startDate;
		this.birthDate = birthDate;
		this.department = department;
		this.jobTitle = jobTitle;
		this.ratePerHour = ratePerHour;
		this.homeAddress = homeAddress;
		this.cellNumber = cellNumber;
		this.emailAddress = emailAddress;
		this.nextOfKinFullName = nextOfKinFullName;
		this.nextOfKinCellNumber = nextOfKinCellNumber;
		this.enabled = enabled;
		this.order = order;
		this.monthlySalary = monthlySalary;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getRatePerHour() {
		return ratePerHour;
	}

	public void setRatePerHour(String ratePerHour) {
		this.ratePerHour = ratePerHour;
	}

	public String getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	public String getCellNumber() {
		return cellNumber;
	}

	public void setCellNumber(String cellNumber) {
		this.cellNumber = cellNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getNextOfKinFullName() {
		return nextOfKinFullName;
	}

	public void setNextOfKinFullName(String nextOfKinFullName) {
		this.nextOfKinFullName = nextOfKinFullName;
	}

	public String getNextOfKinCellNumber() {
		return nextOfKinCellNumber;
	}

	public void setNextOfKinCellNumber(String nextOfKinCellNumber) {
		this.nextOfKinCellNumber = nextOfKinCellNumber;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public OrderDTO getOrder() {
		return order;
	}

	public void setOrder(OrderDTO order) {
		this.order = order;
	}

	public Double getMonthlySalary() {
		return monthlySalary;
	}

	public void setMonthlySalary(Double monthlySalary) {
		this.monthlySalary = monthlySalary;
	}
	
	

}
