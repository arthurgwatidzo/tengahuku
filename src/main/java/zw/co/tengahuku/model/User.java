package zw.co.tengahuku.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@ToString
@AllArgsConstructor
@Table(name="USER")
public class User{
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID")
	private Long id;
	@Column(name="EMAIL_USERNAME",nullable=false)
	@NotNull(message = "\"The Email Address field cannot be null.\"")
	private String emailUserName;
	@Column(name="PASSWORD",nullable=false)
	private String password;
	
	@Column(name="ACCOUNT_LOCKED",nullable=false)
	private Boolean accountLocked;
	@Column(name="USER_ROLE",nullable=false)
	private String userRole;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "account", cascade = CascadeType.ALL)
	@JoinColumn(name="CUSTOMER_ID")
	Customer customer;
	
	@Column(name="CREATED_ON",nullable=false)
	private Date createdOn;
	
	@Column(name="UPDATED_ON",nullable=false)
	private Date updatedOn;
	
	@OneToMany(targetEntity=UserRole.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
	private List<UserRole> userRoles;
	

	public User(String emailUserName, String password, Boolean accountLocked) {
		this.emailUserName = emailUserName;
		this.password = password;
		this.accountLocked = accountLocked;
	}
	
	public User(String emailUserName, String password, Boolean accountLocked, String userRole) {
		this.emailUserName = emailUserName;
		this.password = password;
		this.accountLocked = accountLocked;
		this.userRole=userRole;
	}
	
	public User(String emailUserName, String password, Boolean accountLocked, String userRole, Customer customer) {
		this.emailUserName = emailUserName;
		this.password = password;
		this.accountLocked = accountLocked;
		this.userRole=userRole;
		this.customer=customer;
	}
	
	

}
