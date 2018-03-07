package zw.co.tengahuku.dto;

public class SupplierDTO {

	private int id;
	private String name;
	private String physicalAddress;
	private String town;
	private String city;
	private String contactPerson;
	private String alternativeContactPerson;
	private String cellNumber;
	private String telephoneNumberOne;
	private String telephoneNumberTwo;
	private String emailAddress;
	
	

	public SupplierDTO(int id, String name, String physicalAddress, String town, String city, String contactPerson,
			String alternativeContactPerson, String cellNumber, String telephoneNumberOne, String telephoneNumberTwo,
			String emailAddress) {
		this.id = id;
		this.name = name;
		this.physicalAddress = physicalAddress;
		this.town = town;
		this.city = city;
		this.contactPerson = contactPerson;
		this.alternativeContactPerson = alternativeContactPerson;
		this.cellNumber = cellNumber;
		this.telephoneNumberOne = telephoneNumberOne;
		this.telephoneNumberTwo = telephoneNumberTwo;
		this.emailAddress = emailAddress;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhysicalAddress() {
		return physicalAddress;
	}

	public void setPhysicalAddress(String physicalAddress) {
		this.physicalAddress = physicalAddress;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getAlternativeContactPerson() {
		return alternativeContactPerson;
	}

	public void setAlternativeContactPerson(String alternativeContactPerson) {
		this.alternativeContactPerson = alternativeContactPerson;
	}

	public String getCellNumber() {
		return cellNumber;
	}

	public void setCellNumber(String cellNumber) {
		this.cellNumber = cellNumber;
	}

	public String getTelephoneNumberOne() {
		return telephoneNumberOne;
	}

	public void setTelephoneNumberOne(String telephoneNumberOne) {
		this.telephoneNumberOne = telephoneNumberOne;
	}

	public String getTelephoneNumberTwo() {
		return telephoneNumberTwo;
	}

	public void setTelephoneNumberTwo(String telephoneNumberTwo) {
		this.telephoneNumberTwo = telephoneNumberTwo;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

}
