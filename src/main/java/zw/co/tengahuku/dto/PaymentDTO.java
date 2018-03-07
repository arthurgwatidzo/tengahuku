package zw.co.tengahuku.dto;

import java.util.Date;

public class PaymentDTO {
	
	private Long id;
	private CustomerDTO customerDTO;
	private Date paymentDate;
	private Double paymentAmount;
	private String paymentDescription;
	private String paymentType;
	
	
	public PaymentDTO(Long id, CustomerDTO customerDTO, Date paymentDate, Double paymentAmount,
			String paymentDescription, String paymentType) {
	
		this.id = id;
		this.customerDTO = customerDTO;
		this.paymentDate = paymentDate;
		this.paymentAmount = paymentAmount;
		this.paymentDescription = paymentDescription;
		this.paymentType = paymentType;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public CustomerDTO getCustomerDTO() {
		return customerDTO;
	}
	public void setCustomerDTO(CustomerDTO customerDTO) {
		this.customerDTO = customerDTO;
	}
	public Date getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	public Double getPaymentAmount() {
		return paymentAmount;
	}
	public void setPaymentAmount(Double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}
	public String getPaymentDescription() {
		return paymentDescription;
	}
	public void setPaymentDescription(String paymentDescription) {
		this.paymentDescription = paymentDescription;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	
	

}
