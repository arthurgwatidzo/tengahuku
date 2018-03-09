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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@ToString
@AllArgsConstructor
@Table(name="INVOICE")
public class Invoice {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID")
	private Long id;
	@Column(name="PRODUCT_NUMBER")
	private int productNumber;
	@Column(name="ORDER_REFERENCE")
	private String orderReference;
	@Column(name="INVOICE_DATE")
	private Date invoiceDate;
	@Column(name="QUANTITY")
	private Long quantity;
	@Column(name="PRICE_PER_ITEM")
	private double pricePerItem;
	@Column(name="AMOUNT")
	private double amount;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "account", cascade = CascadeType.ALL)
	@JoinColumn(name="CUSTOMER_ID")
	Customer customer;
	
}
