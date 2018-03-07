package zw.co.tengahuku.dto;

import java.util.List;

public class CustomerDTO {

	private Long id;
	private String companyName;
	private String contactName;
	private String contactTitle;
	private String deliveryAddress;
	private String city;
	private String telephoneNumber;
	private String emailAddress;
	private Boolean enabled;
	private List<PaymentDTO> payments;
	private List<OrderDTO> orders;
	private AccountDTO account;
	private UserDTO user;

	public CustomerDTO(Long id, String companyName, String contactName, String contactTitle, String deliveryAddress,
			String city, String telephoneNumber, String emailAddress, Boolean enabled, List<PaymentDTO> payments,
			List<OrderDTO> orders, AccountDTO account, UserDTO user) {
		this.id = id;
		this.companyName = companyName;
		this.contactName = contactName;
		this.contactTitle = contactTitle;
		this.deliveryAddress = deliveryAddress;
		this.city = city;
		this.telephoneNumber = telephoneNumber;
		this.emailAddress = emailAddress;
		this.enabled = enabled;
		this.payments = payments;
		this.orders = orders;
		this.account = account;
		this.user = user;
	}

	public List<PaymentDTO> getPayments() {
		return payments;
	}

	public void setPayments(List<PaymentDTO> payments) {
		this.payments = payments;
	}

	public List<OrderDTO> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderDTO> orders) {
		this.orders = orders;
	}

	public AccountDTO getAccount() {
		return account;
	}

	public void setAccount(AccountDTO account) {
		this.account = account;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactTitle() {
		return contactTitle;
	}

	public void setContactTitle(String contactTitle) {
		this.contactTitle = contactTitle;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

}
