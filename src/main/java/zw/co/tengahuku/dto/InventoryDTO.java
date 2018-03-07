package zw.co.tengahuku.dto;

import java.util.Date;


public class InventoryDTO {
	
	private Long id;
	private PoultryProductDTO poultryProduct;
	private Long stockIn;
	private Long stockOut;
	private Date transactionDate;
	private CustomerDTO customer;
	
	public InventoryDTO(Long id, PoultryProductDTO poultryProduct, Long stockIn, Long stockOut, Date transactionDate,CustomerDTO customer) {
		this.id = id;
		this.poultryProduct = poultryProduct;
		this.stockIn = stockIn;
		this.stockOut = stockOut;
		this.transactionDate = transactionDate;
		this.customer=customer;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PoultryProductDTO getPoultryProduct() {
		return poultryProduct;
	}

	public void setPoultryProduct(PoultryProductDTO poultryProduct) {
		this.poultryProduct = poultryProduct;
	}

	public Long getStockIn() {
		return stockIn;
	}

	public void setStockIn(Long stockIn) {
		this.stockIn = stockIn;
	}

	public Long getStockOut() {
		return stockOut;
	}

	public void setStockOut(Long stockOut) {
		this.stockOut = stockOut;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public CustomerDTO getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerDTO customer) {
		this.customer = customer;
	}
	
	

}
