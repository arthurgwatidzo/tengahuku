package zw.co.tengahuku.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@ToString
@AllArgsConstructor
@Table(name="SUPPLIER")
public class Supplier {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID")
	private int id;
	@Column(name="NAME",nullable=false)
	private String name;
	@Column(name="PHYSICAL_ADDRESS",nullable=false)
	private String physicalAddress;
	@Column(name="TOWN",nullable=false)
	private String town;
	@Column(name="CITY",nullable=false)
	private String city;
	@Column(name="CONTACT_PERSON",nullable=false)
	private String contactPerson;
	@Column(name="ALTERNATIVE_CONTACT_PERSON",nullable=false)
	private String alternativeContactPerson;
	@Column(name="CELL_NUMBER",nullable=false)
	private String cellNumber;
	@Column(name="TELEPHONE_NUMBER_ONE",nullable=false)
	private String telephoneNumberOne;
	@Column(name="TELEPHONE_NUMBER_TWO",nullable=false)
	private String telephoneNumberTwo;
	@Column(name="EMAIL_ADDRESS",nullable=false)
	private String emailAddress;
}
