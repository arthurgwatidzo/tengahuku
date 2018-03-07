package zw.co.tengahuku.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Table(name = "CUSTOMER")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;
	@Column(name = "COMPANY_NAME", nullable = false)
	private String companyName;
	@Column(name = "CONTACT_NAME", nullable = false)
	private String contactName;
	@Column(name = "CONTACT_TITLE", nullable = false)
	private String contactTitle;
	@Column(name = "DELIVERY_ADDRESS", nullable = false)
	private String deliveryAddress;
	@Column(name = "CITY", nullable = false)
	private String city;
	@Column(name = "TELEPHONE_NUMBER", nullable = false)
	private String telephoneNumber;
	@Column(name = "EMAIL_ADDRESS", nullable = false)
	private String emailAddress;
	@Column(name = "ENABLED", nullable = false)
	private Boolean enabled;
	@OneToMany(targetEntity=Payment.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "customer")
	private List<Payment> payments;
	@OneToMany(targetEntity=Order.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "customer")
	private List<Order> orders;
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private Account account;
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private User user;

}
