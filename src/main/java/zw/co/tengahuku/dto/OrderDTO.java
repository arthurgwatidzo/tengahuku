package zw.co.tengahuku.dto;

import java.util.Date;


public class OrderDTO {
	
	private Long id;
	private CustomerDTO customerDTO;
	private EmployeeDTO employeeDTO;
	private Date orderDate;
	private Date requiredDate;
	private Date deliveredDate;
	private String deliveryAddress;
	private String deliveryTown;
	private String delivererId;
	private String status;
	
	
	
	public OrderDTO(Long id, CustomerDTO customerDTO, EmployeeDTO employeeDTO, Date orderDate, Date requiredDate,
			Date deliveredDate, String deliveryAddress, String deliveryTown, String delivererId, String status) {
		this.id = id;
		this.customerDTO = customerDTO;
		this.employeeDTO = employeeDTO;
		this.orderDate = orderDate;
		this.requiredDate = requiredDate;
		this.deliveredDate = deliveredDate;
		this.deliveryAddress = deliveryAddress;
		this.deliveryTown = deliveryTown;
		this.delivererId = delivererId;
		this.status = status;
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
	
	public EmployeeDTO getEmployeeDTO() {
		return employeeDTO;
	}
	
	public void setEmployeeDTO(EmployeeDTO employeeDTO) {
		this.employeeDTO = employeeDTO;
	}
	
	public Date getOrderDate() {
		return orderDate;
	}
	
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	
	public Date getRequiredDate() {
		return requiredDate;
	}
	
	public void setRequiredDate(Date requiredDate) {
		this.requiredDate = requiredDate;
	}
	
	public Date getDeliveredDate() {
		return deliveredDate;
	}
	
	public void setDeliveredDate(Date deliveredDate) {
		this.deliveredDate = deliveredDate;
	}
	
	public String getDeliveryAddress() {
		return deliveryAddress;
	}
	
	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
	
	public String getDeliveryTown() {
		return deliveryTown;
	}
	
	public void setDeliveryTown(String deliveryTown) {
		this.deliveryTown = deliveryTown;
	}
	
	public String getDelivererId() {
		return delivererId;
	}
	
	public void setDelivererId(String delivererId) {
		this.delivererId = delivererId;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
