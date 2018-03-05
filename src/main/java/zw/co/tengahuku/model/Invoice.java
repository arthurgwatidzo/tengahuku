package zw.co.tengahuku.model;

import java.util.Date;

public class Invoice {
	private int id;
	private int productNumber;
	private String orderReference;
	private Date invoiceDate;
	private Long quantity;
	private double pricePerItem;
	private double amount;
	private Customer customer;
	
}
