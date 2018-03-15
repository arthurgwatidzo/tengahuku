package zw.co.tengahuku.dto;

import java.util.Date;

import zw.co.tengahuku.model.Customer;

public class UserDTO {
	private Long id;
	private String emailUserName;
	private String password;
	private Customer customer;
	private Boolean accountLocked;
	private String userRole;
	private Date updatedOn;
	private Date createdOn;
	
	
	
	public UserDTO(Long id, String emailUserName, String password, Customer customer, Boolean accountLocked,
			String userRole) {
		this.id = id;
		this.emailUserName = emailUserName;
		this.password = password;
		this.customer = customer;
		this.accountLocked = accountLocked;
		this.userRole = userRole;
	}
	
	
	
	public UserDTO(Long id, String emailUserName, String password, Customer customer, Boolean accountLocked,
			String userRole, Date updatedOn, Date createdOn) {
		this.id = id;
		this.emailUserName = emailUserName;
		this.password = password;
		this.customer = customer;
		this.accountLocked = accountLocked;
		this.userRole = userRole;
		this.updatedOn = updatedOn;
		this.createdOn = createdOn;
	}



	public Date getUpdatedOn() {
		return updatedOn;
	}



	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}



	public Date getCreatedOn() {
		return createdOn;
	}



	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}



	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmailUserName() {
		return emailUserName;
	}
	public void setEmailUserName(String emailUserName) {
		this.emailUserName = emailUserName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Boolean getAccountLocked() {
		return accountLocked;
	}
	public void setAccountLocked(Boolean accountLocked) {
		this.accountLocked = accountLocked;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	

}
