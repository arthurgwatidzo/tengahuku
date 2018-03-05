package zw.co.tengahuku.model;

import java.util.Date;

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
@Table(name="ACCOUNT")
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID")
	Long id;
	@Column(name="INTEREST_RATE")
	Double interestRate;
	@Column(name="BALANCE")
	Double balance;
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "account", cascade = CascadeType.ALL)
	@JoinColumn(name="CUSTOMER_ID")
	Customer customer;
	@Column(name="OPENED_RATE")
	Date openedDate;

}
