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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
@Data
@Entity
@ToString
@AllArgsConstructor
@Table(name="ORDER")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID")
	private Long id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CUSTOMER_ID")
	private Customer customer;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "order", cascade = CascadeType.ALL)
	@JoinColumn(name="EMPLOYEE_ID")
	private Employee employee;
	
	@Column(name="ORDER_DATE")
	private Date orderDate;
	
	@Column(name="REQUIRED_DATE")
	private Date requiredDate;
	
	private Date deliveredDate;
	
	private String deliveryAddress;
	
	private String deliveryTown;
	
	private String delivererId;
	
	private String status;
	
	@OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="poultryProduct")
    private List<OrderLine> orderLines;
	
	

}
