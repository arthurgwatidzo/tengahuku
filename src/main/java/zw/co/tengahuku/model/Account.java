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
	private Long id;
	@Column(name="INTEREST_RATE")
	private Double interestRate;
	@Column(name="BALANCE")
	private Double balance;
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "account", cascade = CascadeType.ALL)
	@JoinColumn(name="CUSTOMER_ID")
	private Customer customer;
	@Column(name="OPENED_RATE")
	private Date openedDate;

}
