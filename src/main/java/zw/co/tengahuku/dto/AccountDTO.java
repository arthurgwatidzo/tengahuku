package zw.co.tengahuku.dto;

import java.util.Date;

public class AccountDTO {

	private Long id;
	private Double interestRate;
	private Double balance;
	private CustomerDTO customer;
	private Date openedDate;
	

	public AccountDTO(Long id, Double interestRate, Double balance, CustomerDTO customer, Date openedDate) {
		this.id = id;
		this.interestRate = interestRate;
		this.balance = balance;
		this.customer = customer;
		this.openedDate = openedDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(Double interestRate) {
		this.interestRate = interestRate;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public CustomerDTO getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerDTO customer) {
		this.customer = customer;
	}

	public Date getOpenedDate() {
		return openedDate;
	}

	public void setOpenedDate(Date openedDate) {
		this.openedDate = openedDate;
	}

}
