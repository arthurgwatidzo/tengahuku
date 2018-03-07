package zw.co.tengahuku.dto;

import java.util.Date;

public class BirdDTO {

	private Long id;
	private Boolean birdType;
	private Long rfidTagNumber;
	private Date purchaseDate;
	private String breedName;
	private String supplierName;
	
	

	public BirdDTO(Long id, Boolean birdType, Long rfidTagNumber, Date purchaseDate, String breedName,
			String supplierName) {
		this.id = id;
		this.birdType = birdType;
		this.rfidTagNumber = rfidTagNumber;
		this.purchaseDate = purchaseDate;
		this.breedName = breedName;
		this.supplierName = supplierName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getBirdType() {
		return birdType;
	}

	public void setBirdType(Boolean birdType) {
		this.birdType = birdType;
	}

	public Long getRfidTagNumber() {
		return rfidTagNumber;
	}

	public void setRfidTagNumber(Long rfidTagNumber) {
		this.rfidTagNumber = rfidTagNumber;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String getBreedName() {
		return breedName;
	}

	public void setBreedName(String breedName) {
		this.breedName = breedName;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

}
