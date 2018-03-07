package zw.co.tengahuku.dto;

public class PoultryProductDTO {
	
	private int id;
	private String productName;
	private int quantityPerUnit;
	private double unitPrice;
	private Long unitsInStock;
	private Long unitsOnOrder;
	private Boolean discontinued;
	
	public PoultryProductDTO(int id, String productName, int quantityPerUnit, double unitPrice, Long unitsInStock,
			Long unitsOnOrder, Boolean discontinued) {
	
		this.id = id;
		this.productName = productName;
		this.quantityPerUnit = quantityPerUnit;
		this.unitPrice = unitPrice;
		this.unitsInStock = unitsInStock;
		this.unitsOnOrder = unitsOnOrder;
		this.discontinued = discontinued;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantityPerUnit() {
		return quantityPerUnit;
	}

	public void setQuantityPerUnit(int quantityPerUnit) {
		this.quantityPerUnit = quantityPerUnit;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Long getUnitsInStock() {
		return unitsInStock;
	}

	public void setUnitsInStock(Long unitsInStock) {
		this.unitsInStock = unitsInStock;
	}

	public Long getUnitsOnOrder() {
		return unitsOnOrder;
	}

	public void setUnitsOnOrder(Long unitsOnOrder) {
		this.unitsOnOrder = unitsOnOrder;
	}

	public Boolean getDiscontinued() {
		return discontinued;
	}

	public void setDiscontinued(Boolean discontinued) {
		this.discontinued = discontinued;
	}
	
	
	
	

}
